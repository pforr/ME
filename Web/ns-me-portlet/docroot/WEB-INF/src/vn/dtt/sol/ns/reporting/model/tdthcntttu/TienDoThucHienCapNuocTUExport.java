package vn.dtt.sol.ns.reporting.model.tdthcntttu;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.business.DataItemBusiness;
import vn.dtt.sol.ns.reporting.model.tdthcntttu.TienDoThucHienCapNuocTU.TienDoThucHienCapNuocTUDanhSach;
import vn.dtt.sol.ns.reporting.utils.ReportConstant;
import vn.dtt.sol.ns.tramcap.business.DanhGiaBenVungBussiness;
import vn.dtt.sol.ns.tramcap.business.TramCapBusiness;
import vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVung;
import vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.util.WebKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class TienDoThucHienCapNuocTUExport {
	private static Log log = LogFactoryUtil.getLog(TienDoThucHienCapNuocTUExport.class);
	public static TienDoThucHienCapNuocTU getModel(String namBaoCao){
		log.info("==START==TienDoThucHienCapNuocTUExport===");
		
		TienDoThucHienCapNuocTU result = new TienDoThucHienCapNuocTU();
		
		TienDoThucHienCapNuocTU.TienDoThucHienCapNuocTUDanhSach tienDoThucHienCapNuocTUDanhSach = null;
		List<TienDoThucHienCapNuocTUDanhSach> lstTienDoThucHienCapNuocTUDanhSach = null;
		
		String namValue = "";
		
		namValue = namBaoCao;	
		
		
		List<TramCapNuoc> lstTramCapNuoc = TramCapBusiness.getTramCapNuocJoinDanhGiaBenVung(null,namBaoCao);
		lstTienDoThucHienCapNuocTUDanhSach = new ArrayList<TienDoThucHienCapNuocTUDanhSach>();
		if(Validator.isNotNull(lstTramCapNuoc) && lstTramCapNuoc.size() > 0){
			log.info("===TienDoThucHienCapNuocTUExport===getModel---===lstTramCapNuoc---"+lstTramCapNuoc.size());
			for (TramCapNuoc tramCapNuoc : lstTramCapNuoc) {
				tienDoThucHienCapNuocTUDanhSach = result.new TienDoThucHienCapNuocTUDanhSach();// kienthuc moi uuuuu
				
				String tenTinhValue = "";
				String tenCongTrinhValue = "";
				String diaDiemValue = "";
				String tinhTrangValue = "";
				int theoKHValue = 0;
				int workingValue = 0;
				String tatCaChiSoValue = "";
				String arsenValue = "";
				int ncThatThoatValue = 0;
				int doanhThuValue = 0;
				int chiPhiVHBDValue = 0;
				String moHinhQLValue = "";
				
				tenTinhValue = NuocSachUtils.getNameTinh(tramCapNuoc.getMaTinh());
				tenCongTrinhValue = Validator.isNotNull(tramCapNuoc.getTenTram()) ? tramCapNuoc.getTenTram() : "";
				String xaValueTemp = Validator.isNotNull(tramCapNuoc.getMaXa()) ? NuocSachUtils.getNameXa( tramCapNuoc.getMaXa()) : "";
				String huyenValueTemp = Validator.isNotNull(tramCapNuoc.getMaHuyen()) ? ", "+NuocSachUtils.getNameHuyen(null, tramCapNuoc.getMaHuyen()) : "";
				diaDiemValue = xaValueTemp+huyenValueTemp;
				
				int tinhTrangTemp = Validator.isNotNull(tramCapNuoc.getTinhTrangDuAn()) ? tramCapNuoc.getTinhTrangDuAn() : 0 ;
				tinhTrangValue = ReportConstant.CHUATHUCHIEN;
				if(tinhTrangTemp == 1){
					tinhTrangValue = ReportConstant.DANGVANHANH;
				}else if(tinhTrangTemp == 2){
					tinhTrangValue = ReportConstant.DANGCHAYTHU;
				}else if(tinhTrangTemp == 3){
					tinhTrangValue = ReportConstant.DANGXAYDUNG;
				}else if(tinhTrangTemp == 4){
					tinhTrangValue = ReportConstant.DANGCHUANBIDAUTU;
				}
				
				theoKHValue = Validator.isNotNull(tramCapNuoc.getTongDauNoiThietKe()) ? tramCapNuoc.getTongDauNoiThietKe() : 0 ;
				workingValue = Validator.isNotNull(tramCapNuoc.getTongDauNoiThucTe()) ? tramCapNuoc.getTongDauNoiThucTe() : 0 ;
				
				DanhGiaBenVung danhGiaBenVung = DanhGiaBenVungBussiness.getDanhGiaBenVungByTramCapNuocAndNam(tramCapNuoc.getId(),namBaoCao,null); // tramcapnuoc join danhgiabenvung chi bang tramcapid thoi
				if(Validator.isNotNull(danhGiaBenVung)){
					int nuocDatTieuChuanTemp = Validator.isNotNull(danhGiaBenVung.getNuocDatTieuChuan()) ? danhGiaBenVung.getNuocDatTieuChuan() : 0;
					tatCaChiSoValue = (nuocDatTieuChuanTemp > 0 && nuocDatTieuChuanTemp == 1)  ? ReportConstant.DAT : ReportConstant.KHONG ;
					
					int nuocCoAsenTemp = Validator.isNotNull(danhGiaBenVung.getNuocCoAsen() ) ? danhGiaBenVung.getNuocCoAsen() : 0;
					arsenValue = (nuocCoAsenTemp > 0 && nuocCoAsenTemp == 2 ) ? ReportConstant.DAT : ReportConstant.KHONG ;
					
					ncThatThoatValue = Validator.isNotNull(danhGiaBenVung.getNuocThatThoat() ) ? danhGiaBenVung.getNuocThatThoat() : 0;
					doanhThuValue = Validator.isNotNull(danhGiaBenVung.getTongDoanhThu() ) ? danhGiaBenVung.getTongDoanhThu() : 0;
					chiPhiVHBDValue = Validator.isNotNull(danhGiaBenVung.getTongChiPhi() ) ? danhGiaBenVung.getTongChiPhi() : 0;
					
				}
				moHinhQLValue = Validator.isNotNull(tramCapNuoc.getMaMoHinh() ) ? DataItemBusiness.getByNode1Id(WebKeys.DATAGROUPID_MOHINHQUANLY, tramCapNuoc.getMaMoHinh()).getName() : ""; 
				
				
				tienDoThucHienCapNuocTUDanhSach.setTenTinh(tenTinhValue);
				tienDoThucHienCapNuocTUDanhSach.setTenCongTrinh(tenCongTrinhValue);
				tienDoThucHienCapNuocTUDanhSach.setDiaDiem(diaDiemValue);
				tienDoThucHienCapNuocTUDanhSach.setTinhTrang(tinhTrangValue);
				tienDoThucHienCapNuocTUDanhSach.setTheoKH(theoKHValue);
				tienDoThucHienCapNuocTUDanhSach.setWorking(workingValue);
				tienDoThucHienCapNuocTUDanhSach.setTatCaChiSo(tatCaChiSoValue);
				tienDoThucHienCapNuocTUDanhSach.setArsen(arsenValue);
				tienDoThucHienCapNuocTUDanhSach.setNcThatThoat(ncThatThoatValue);
				tienDoThucHienCapNuocTUDanhSach.setDoanhThu(doanhThuValue);
				tienDoThucHienCapNuocTUDanhSach.setChiPhiVHBD(chiPhiVHBDValue);
				tienDoThucHienCapNuocTUDanhSach.setMoHinhQL(moHinhQLValue);
				lstTienDoThucHienCapNuocTUDanhSach.add(tienDoThucHienCapNuocTUDanhSach);
				
			}
			
			
		}
		
		
		result.setNam(namValue);
		result.setLstTienDoThucHienCapNuocTUDanhSach(lstTienDoThucHienCapNuocTUDanhSach);
		log.info("==END==TienDoThucHienCapNuocTUExport===");
		return result;
		
	}
}
