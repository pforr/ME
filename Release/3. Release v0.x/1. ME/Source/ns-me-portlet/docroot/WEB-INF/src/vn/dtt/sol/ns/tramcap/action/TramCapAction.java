package vn.dtt.sol.ns.tramcap.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;

import vn.dtt.sol.ns.tramcap.dao.model.DanhGiaVanHanh;
import vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc;
import vn.dtt.sol.ns.tramcap.dao.service.DanhGiaVanHanhLocalServiceUtil;
import vn.dtt.sol.ns.tramcap.dao.service.TramCapNuocLocalServiceUtil;
import vn.dtt.sol.ns.util.NuocSachUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

public class TramCapAction {

	public void deleteVanHanh(ActionRequest request) throws SystemException,
			PortalException {
		long vanHanhId = ParamUtil.getLong(request, "vanHanhTramId");

		if (vanHanhId > 0) {
			DanhGiaVanHanhLocalServiceUtil.deleteDanhGiaVanHanh(vanHanhId);
		}
	}

	public boolean deleteTramCap(long tramCapId) {
		try {

			TramCapNuocLocalServiceUtil.deleteTramCapNuoc(tramCapId);

			return true;
		} catch (Exception e) {
			_log.error(e);
			return false;
		}
	}

	/**
	 * @param request
	 * @return
	 */
	public DanhGiaVanHanh updateDanhGiaVanHanh(ActionRequest request) {
		DanhGiaVanHanh danhGia = null;

		long id = ParamUtil.getLong(request, "danhGiaId");
		int userId = ParamUtil.getInteger(request, "userId");
		int tramCapNuocId = ParamUtil.getInteger(request, "tramCapId");
		int nam = ParamUtil.getInteger(request, "nam");
		int thang = ParamUtil.getInteger(request, "thang");
		int congXuatThucTe = NuocSachUtils.formatPrice(ParamUtil.getString(request, "congXuatThucTe")) ;
		int nuocThatThoat = 0;
		int nuocDatTieuChuan = ParamUtil
				.getInteger(request, "nuocDatTieuChuan");
		int nuocCoAsen = ParamUtil.getInteger(request, "nuocCoAsen");
		int trangThaiCapNuoc = ParamUtil
				.getInteger(request, "trangThaiCapNuoc");
		int chiPhiHoaChat = NuocSachUtils.formatPrice(ParamUtil.getString(request, "chiPhiHoaChat"));
		int chiPhiDien = NuocSachUtils.formatPrice(ParamUtil.getString(request, "chiPhiDien"));
		int luongNhanVien = NuocSachUtils.formatPrice(ParamUtil.getString(request, "luongNhanVien"));
		int chiPhiSuaChua = NuocSachUtils.formatPrice(ParamUtil.getString(request, "chiPhiSuaChua"));
		int doanhThu = NuocSachUtils.formatPrice(ParamUtil.getString(request, "doanhThu")) ;
		String ghiChu = ParamUtil.getString(request, "ghiChu");

		int sanLuongSanXuat = NuocSachUtils.formatPrice(ParamUtil.getString(request, "sanLuongSanXuat"));

		int sanLuongTieuHao = NuocSachUtils.formatPrice(ParamUtil.getString(request, "sanLuongTieuHao")) ;

		try {
			nuocThatThoat = (sanLuongTieuHao / sanLuongSanXuat)*100;
		} catch (Exception e) {
			nuocThatThoat = 0;
		}
		try {
			danhGia = DanhGiaVanHanhLocalServiceUtil.updateDanhGiaVanHanh(id,
					userId, tramCapNuocId, thang, nam, congXuatThucTe,
					nuocThatThoat, nuocDatTieuChuan, nuocCoAsen,
					trangThaiCapNuoc, chiPhiHoaChat, chiPhiDien, luongNhanVien,
					chiPhiSuaChua, doanhThu, ghiChu, sanLuongSanXuat,
					sanLuongTieuHao);
		} catch (Exception e) {
			_log.error(e);
		}

		return danhGia;
	}

	public TramCapNuoc updaTramCap(ActionRequest request) {

		TramCapNuoc tramCap = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		long id = ParamUtil.getLong(request, "id");
		String maTram = ParamUtil.getString(request, "maTram");
		String tenTram = ParamUtil.getString(request, "tenTram");
		String maTinh = ParamUtil.getString(request, "maTinh");
		String maHuyen = ParamUtil.getString(request, "maHuyen");
		String maXa = ParamUtil.getString(request, "maXa");
		String diaChi = ParamUtil.getString(request, "diaChi");
		String kinhDo = ParamUtil.getString(request, "kinhDo");
		String viDo = ParamUtil.getString(request, "viDo");
		int loaiHinh = ParamUtil.getInteger(request, "loaiHinh");
		String maMoHinh = ParamUtil.getString(request, "maMoHinh");

		int congXuatThietKe = NuocSachUtils.formatPrice(ParamUtil.getString(
				request, "congXuatThietKe"));
		int tongDauNoiThietKe = NuocSachUtils.formatPrice(ParamUtil.getString(
				request, "tongDauNoiThietKe"));
		int soNguoiCapThietKe = NuocSachUtils.formatPrice(ParamUtil.getString(
				request, "soNguoiCapThietKe"));

		int tinhTrangDuAn = ParamUtil.getInteger(request, "tinhTrangDuAn");
		int tienDoXayDung = ParamUtil.getInteger(request, "tienDoXayDung");
		int namXayDung = ParamUtil.getInteger(request, "namXayDung");
		int namHoanThanh = ParamUtil.getInteger(request, "namHoanThanh");
		Date ngayVanHanh = ParamUtil
				.getDate(request, "ngayVanHanh", dateFormat);
		int boMayVanHanh = ParamUtil.getInteger(request, "boMayVanHanh");
		String ghiChu = ParamUtil.getString(request, "ghiChu");
		
		long idNguoiTao = PortalUtil.getUserId(request);

		try {
			tramCap = TramCapNuocLocalServiceUtil
					.updateTramCap(id, idNguoiTao, maTram, tenTram, maTinh, maHuyen, maXa,
							diaChi, kinhDo, viDo, loaiHinh, maMoHinh,
							congXuatThietKe, tongDauNoiThietKe,
							soNguoiCapThietKe, tinhTrangDuAn, tienDoXayDung,
							namXayDung, namHoanThanh, ngayVanHanh,
							boMayVanHanh, ghiChu);
		} catch (Exception e) {
			_log.error(e);
		}

		return tramCap;

	}

	private static Log _log = LogFactoryUtil.getLog(TramCapAction.class);
}
