package vn.dtt.sol.ns.reporting.model.hopnhattinhtu;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.baocaodli.business.BaoCaoDLITongHopBusiness;
import vn.dtt.sol.ns.business.DataItemBusiness;
import vn.dtt.sol.ns.business.KeHoachNuocSachBusiness;
import vn.dtt.sol.ns.business.KeHoachVeSinhBusiness;
import vn.dtt.sol.ns.danhgiavesinh.business.DANHGIAVESINHXABusiness;
import vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA;
import vn.dtt.sol.ns.reporting.model.hopnhattinhtu.HopNhatTinhTongHopVeGioiTU.HopNhatTinhTongHopVeGioiTUDanhSach;
import vn.dtt.sol.ns.reporting.model.tonghopvegioitu.TongHopVeGioiTU.TongHopVeGioiTUDanhSach;
import vn.dtt.sol.ns.reporting.utils.ReportConstant;
import vn.dtt.sol.ns.tramcap.business.DanhGiaBenVungBussiness;
import vn.dtt.sol.ns.tramcap.business.THONGTINKIEMDEMNUOCBusiness;
import vn.dtt.sol.ns.tramcap.business.TramCapBusiness;
import vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVung;
import vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC;
import vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.util.WebKeys;
import vn.dtt.sol.ns.util.format.ConvertUtil;
import vn.dtt.sol.ns.vesinhmoitruong.business.ThongTinKiemDemHoGDBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.business.VeSinhGiaDinhBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhGiaDinh;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class HopNhatTinhTUExport {
	private static Log log = LogFactoryUtil.getLog(HopNhatTinhTUExport.class);
	public static HopNhatTinhTU getModel(String namBaoCao,String giaiDoanTu,String giaiDoanDen){
		log.info("==START==HOP NHAT CAC TINH==HopNhatTinhTUExport===");
		HopNhatTinhTU result = new HopNhatTinhTU();
		
		int namToiThieu = 2013;
		int namToiDa = 0;
		//String[] TRANGTHAIVS = {"2","3"}; // trangthai 2 la co nha tieu hvs xay moi, 3 la co nha tieu hvs
		String[] DANHGIAKIEMDEMCHOT = {"1"};// 1 la thong tin kiem dem danh gia nha tieu hvs xay moi
		
		//String KETLUANVSTX = "1"; // 1 la co vstx
		int KETLUANVSTXINT = 1;// 1 la co vstx
		String DANGKYVSTX = "1"; // 1 la co dang ky vstx
		
		String DAKETTHUCDIEUTRA = "1";
		// nuoc
		String DANHGIAKIEMDEMDNN = "1"; ///danhgiakiemdem 1 la kiem dem dat
		// ve sinh
		String[] DANHGIAKIEMDEMVSHGD = {"1","2"};// danhgiakiemdem 1 la co nha tieu hvs xay moi, 2 la co nha tieu hvs
		
		String mauNgauNhien = namBaoCao;
		
		String namValue = "";
		String giaiDoanTuValue = "";
		String giaiDoanDenValue = "";
		int namValueInt = 0;
		int giaiDoanTuValueInt = 0;
		int giaiDoanDenValueInt = 0;
		
		//
		HopNhatTinhChiSoGiaiNganTU hopNhatTinhChiSoGiaiNganTU = null;
		List<HopNhatTinhChiSoGiaiNganTU> lstHopNhatTinhChiSoGiaiNganTU = null;
		//
		HopNhatTinhCapNuocTapTrungTU hopNhatTinhCapNuocTapTrungTU = null;
		List<HopNhatTinhCapNuocTapTrungTU> lstHopNhatTinhCapNuocTapTrungTU = null;
		//
		HopNhatTinhNhaTieuHVSXayMoiTU hopNhatTinhNhaTieuHVSXayMoiTU = null;
		List<HopNhatTinhNhaTieuHVSXayMoiTU> lstHopNhatTinhNhaTieuHVSXayMoiTU = null;
		//
		HopNhatTinhThucHienVSTXTU hopNhatTinhThucHienVSTXTU = null;
		List<HopNhatTinhThucHienVSTXTU> lstHopNhatTinhThucHienVSTXTU = null;
		//
		HopNhatTinhTongHopVeGioiTU hopNhatTinhTongHopVeGioiTU = null;
		List<HopNhatTinhTongHopVeGioiTU> lstHopNhatTinhTongHopVeGioiTU = null;
		
		HopNhatTinhTongHopVeGioiTU.HopNhatTinhTongHopVeGioiTUDanhSach hopNhatTinhTongHopVeGioiTUDanhSach = null;
		List<HopNhatTinhTongHopVeGioiTUDanhSach> lsthopNhatTinhTongHopVeGioiTUDanhSach11 = null;
		List<HopNhatTinhTongHopVeGioiTUDanhSach> lsthopNhatTinhTongHopVeGioiTUDanhSach12 = null;
		List<HopNhatTinhTongHopVeGioiTUDanhSach> lsthopNhatTinhTongHopVeGioiTUDanhSach22 = null;
		
		
		namValue = Validator.isNotNull(namBaoCao) ? namBaoCao : "";	
		
		namValueInt = ConvertUtil.convertToInt(namBaoCao);
		giaiDoanTuValueInt = ConvertUtil.convertToInt(giaiDoanTu);
		giaiDoanDenValueInt = ConvertUtil.convertToInt(giaiDoanDen);
		
		boolean canQuery = false;
		if(giaiDoanTuValueInt > 0 && giaiDoanDenValueInt > 0 && namValueInt > 0){ // nam giai doan > 0, nam bao cao > 0
			if(giaiDoanTuValueInt <= giaiDoanDenValueInt){ // nam giai doan tu phai nho hon giai đoan den
				if(namValueInt >= giaiDoanTuValueInt && namValueInt <= giaiDoanDenValueInt){ // nam bao cao phai o trong khoang 2 nam
					// den day la giaidoantu <= nambaocao <= giaidoanden
					namToiDa = giaiDoanDenValueInt; 
					if(giaiDoanTuValueInt > namToiThieu){ // neu lon hon 2013, nam toi thieu cua chuong trinh thi gan namToiThieu
						namToiThieu = giaiDoanTuValueInt;
					}
					giaiDoanDenValue = ConvertUtil.parseIntToString(namToiDa);// sau do gan lai vao giaidoanden
					giaiDoanTuValue = ConvertUtil.parseIntToString(namToiThieu);// sau do gan lai vao giaidoantu
					canQuery = true;
				}
			}
			
		}
		if(canQuery){ // sau khi tinh toan nam giai doan, co the thuc hien import bao cao tieo theo
			// start part 1: chi so giai ngan
			lstHopNhatTinhChiSoGiaiNganTU = new ArrayList<HopNhatTinhChiSoGiaiNganTU>();
			
			
			hopNhatTinhChiSoGiaiNganTU = new HopNhatTinhChiSoGiaiNganTU();
			
			String SoDauNoiKHValue = "";
			String SoDauNoiKQDDValue = "";

			String SoNhaTieuHGDXayMoiKHValue = "";
			String SoNhaTieuHGDXayMoiKQDDValue = "";

			String SoNgHgLoiTuCapNcBenVungKHValue = "";
			String SoNgHgLoiTuCapNcBenVungKQDDValue = "";
			
			String SoNgHgLoiTuVSTXKHValue = "";
			String SoNgHgLoiTuVSTXKQDDValue = "";
			
			String SoKHCuaTinhDcPheDuyetKHValue = "";
			String SoKHCuaTinhDcPheDuyetKQDDValue = "";
			
			String SoBCCTDcCongBoKHValue = "";
			String SoBCCTDcCongBoKQDDValue = "";
			
			//1 1.1
			SoDauNoiKHValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(null, namValueInt, namToiThieu, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
			SoDauNoiKQDDValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(null, namValueInt, namToiThieu, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
			//2 1.2
			SoNhaTieuHGDXayMoiKHValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(null, namValueInt, namToiThieu, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0));
			SoNhaTieuHGDXayMoiKQDDValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(null, namValueInt, namToiThieu, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0));
			//3 2.1
			SoNgHgLoiTuCapNcBenVungKHValue =  ConvertUtil.parseIntToString1000(KeHoachNuocSachBusiness.sumSoNguoiHuongLoiCapNcBenVungBaoCaoHopNhat(null, namValueInt, namToiThieu));;;
			SoNgHgLoiTuCapNcBenVungKQDDValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(null, namValueInt, namToiThieu, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0));;
			//4 2.2
			SoNgHgLoiTuVSTXKHValue =
			ConvertUtil.parseIntToString1000(KeHoachVeSinhBusiness.sumSoDanHuongLoiBaoCaoHopNhat(null, namValueInt, namToiThieu, DANGKYVSTX));
			SoNgHgLoiTuVSTXKQDDValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(null, namValueInt, namToiThieu, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0));;
			//5 3.1
			SoKHCuaTinhDcPheDuyetKHValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(null, namValueInt, namToiThieu, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0));
			SoKHCuaTinhDcPheDuyetKQDDValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(null, namValueInt, namToiThieu, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0));
			//6 3.2
			SoBCCTDcCongBoKHValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(null, namValueInt, namToiThieu, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0));
			SoBCCTDcCongBoKQDDValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(null, namValueInt, namToiThieu, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1));
			
			
			hopNhatTinhChiSoGiaiNganTU.setSoDauNoiKH(SoDauNoiKHValue);
			hopNhatTinhChiSoGiaiNganTU.setSoDauNoiKQDD(SoDauNoiKQDDValue);
			hopNhatTinhChiSoGiaiNganTU.setSoNhaTieuHGDXayMoiKH(SoNhaTieuHGDXayMoiKHValue);
			hopNhatTinhChiSoGiaiNganTU.setSoNhaTieuHGDXayMoiKQDD(SoNhaTieuHGDXayMoiKQDDValue);
			hopNhatTinhChiSoGiaiNganTU.setSoNgHgLoiTuCapNcBenVungKH(SoNgHgLoiTuCapNcBenVungKHValue);
			hopNhatTinhChiSoGiaiNganTU.setSoNgHgLoiTuCapNcBenVungKQDD(SoNgHgLoiTuCapNcBenVungKQDDValue);
			hopNhatTinhChiSoGiaiNganTU.setSoNgHgLoiTuVSTXKH(SoNgHgLoiTuVSTXKHValue);
			hopNhatTinhChiSoGiaiNganTU.setSoNgHgLoiTuVSTXKQDD(SoNgHgLoiTuVSTXKQDDValue);
			hopNhatTinhChiSoGiaiNganTU.setSoKHCuaTinhDcPheDuyetKH(SoKHCuaTinhDcPheDuyetKHValue);
			hopNhatTinhChiSoGiaiNganTU.setSoKHCuaTinhDcPheDuyetKQDD(SoKHCuaTinhDcPheDuyetKQDDValue);
			hopNhatTinhChiSoGiaiNganTU.setSoBCCTDcCongBoKH(SoBCCTDcCongBoKHValue);
			hopNhatTinhChiSoGiaiNganTU.setSoBCCTDcCongBoKQDD(SoBCCTDcCongBoKQDDValue);
			lstHopNhatTinhChiSoGiaiNganTU.add(hopNhatTinhChiSoGiaiNganTU);
			
			// end part 1
			
			
			// start part 2 : tien do cap nuoc tap trung
			lstHopNhatTinhCapNuocTapTrungTU = new ArrayList<HopNhatTinhCapNuocTapTrungTU>();
			List<TramCapNuoc> lstTramCapNuoc = TramCapBusiness.getTramCapNuocJoinDanhGiaBenVungBaoCaoHopNhat(null, namValueInt, namToiThieu);
			if(Validator.isNotNull(lstTramCapNuoc) && lstTramCapNuoc.size() > 0){
				for (TramCapNuoc tramCapNuoc : lstTramCapNuoc) {
					hopNhatTinhCapNuocTapTrungTU = new HopNhatTinhCapNuocTapTrungTU();
					String maTinh = tramCapNuoc.getMaTinh();
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
					
					tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
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
					theoKHValue = Validator.isNotNull(tramCapNuoc.getId()) ? TramCapBusiness.sumDauNoiTramCapBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, ConvertUtil.parseLongToString(tramCapNuoc.getId()), 1, 0): 0;
					workingValue = Validator.isNotNull(tramCapNuoc.getId()) ? TramCapBusiness.sumDauNoiTramCapBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, ConvertUtil.parseLongToString(tramCapNuoc.getId()), 0, 1): 0;
					
					DanhGiaBenVung danhGiaBenVung = DanhGiaBenVungBussiness.getDanhGiaBenVungByTramCapNuocAndNam(tramCapNuoc.getId(),namBaoCao,null);
					if(Validator.isNotNull(danhGiaBenVung)){
						int nuocDatTieuChuanTemp = Validator.isNotNull(danhGiaBenVung.getNuocDatTieuChuan()) ? danhGiaBenVung.getNuocDatTieuChuan() : 0;
						tatCaChiSoValue = (nuocDatTieuChuanTemp > 0 && nuocDatTieuChuanTemp == 1)  ? ReportConstant.DAT : ReportConstant.KHONG ;
						
						int nuocCoAsenTemp = Validator.isNotNull(danhGiaBenVung.getNuocCoAsen() ) ? danhGiaBenVung.getNuocCoAsen() : 0;
						arsenValue = (nuocCoAsenTemp > 0 && nuocCoAsenTemp == 2 ) ? ReportConstant.DAT : ReportConstant.KHONG ;
						
						ncThatThoatValue = Validator.isNotNull(danhGiaBenVung.getTramCapNuocId()) ? ConvertUtil.convertDoubleToint(DanhGiaBenVungBussiness.calcuInDanhGiaBenVungBaoCaoHopNhat(maTinh, null, null, namValueInt, namToiThieu, ConvertUtil.parseIntToString(danhGiaBenVung.getTramCapNuocId()), 1, 0, 0)): 0 ;
						doanhThuValue = Validator.isNotNull(danhGiaBenVung.getTramCapNuocId()) ? ConvertUtil.convertDoubleToint(DanhGiaBenVungBussiness.calcuInDanhGiaBenVungBaoCaoHopNhat(maTinh, null, null, namValueInt, namToiThieu, ConvertUtil.parseIntToString(danhGiaBenVung.getTramCapNuocId()), 0, 1, 0)): 0 ;
						chiPhiVHBDValue = Validator.isNotNull(danhGiaBenVung.getTramCapNuocId()) ? ConvertUtil.convertDoubleToint(DanhGiaBenVungBussiness.calcuInDanhGiaBenVungBaoCaoHopNhat(maTinh, null, null, namValueInt, namToiThieu, ConvertUtil.parseIntToString(danhGiaBenVung.getTramCapNuocId()), 0, 0, 1)): 0 ;
						
					}
					moHinhQLValue = Validator.isNotNull(tramCapNuoc.getMaMoHinh() ) ? DataItemBusiness.getByNode1Id(WebKeys.DATAGROUPID_MOHINHQUANLY, tramCapNuoc.getMaMoHinh()).getName() : ""; 
					
					hopNhatTinhCapNuocTapTrungTU.setTenTinh(tenTinhValue);
					hopNhatTinhCapNuocTapTrungTU.setTenCongTrinh(tenCongTrinhValue);
					hopNhatTinhCapNuocTapTrungTU.setDiaDiem(diaDiemValue);
					hopNhatTinhCapNuocTapTrungTU.setTinhTrang(tinhTrangValue);
					hopNhatTinhCapNuocTapTrungTU.setTheoKH(theoKHValue);
					hopNhatTinhCapNuocTapTrungTU.setWorking(workingValue);
					hopNhatTinhCapNuocTapTrungTU.setTatCaChiSo(tatCaChiSoValue);
					hopNhatTinhCapNuocTapTrungTU.setArsen(arsenValue);
					hopNhatTinhCapNuocTapTrungTU.setNcThatThoat(ncThatThoatValue);
					hopNhatTinhCapNuocTapTrungTU.setDoanhThu(doanhThuValue);
					hopNhatTinhCapNuocTapTrungTU.setChiPhiVHBD(chiPhiVHBDValue);
					hopNhatTinhCapNuocTapTrungTU.setMoHinhQL(moHinhQLValue);
					
					lstHopNhatTinhCapNuocTapTrungTU.add(hopNhatTinhCapNuocTapTrungTU);
				}
			}
			// end part 2
			
			// start part 3, nha tieu hvs xay moi
			lstHopNhatTinhNhaTieuHVSXayMoiTU = new ArrayList<HopNhatTinhNhaTieuHVSXayMoiTU>();
			List<VeSinhGiaDinh> lstVeSinhGiaDinh = VeSinhGiaDinhBusiness.getVeSinhGiaDinhGroupByMaTinhBaoCaoHopNhatTU(null,null,null,null,DANHGIAKIEMDEMCHOT,namValueInt,namToiThieu);
			if(Validator.isNotNull(lstVeSinhGiaDinh) && lstVeSinhGiaDinh.size() > 0){
				for (VeSinhGiaDinh veSinhGiaDinh : lstVeSinhGiaDinh) {
					hopNhatTinhNhaTieuHVSXayMoiTU = new HopNhatTinhNhaTieuHVSXayMoiTU();
					
					String maTinh = veSinhGiaDinh.getMaTinh();
					String tenTinhValue = "";
					int soNhaTieuHGDHVSMoiValue = 0;
					
					tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
					
					soNhaTieuHGDHVSMoiValue = VeSinhGiaDinhBusiness.countVeSinhGiaDinhGroupByMaHuyenBaoCaoHopNhat(maTinh, null, null,  DANHGIAKIEMDEMCHOT, namValueInt,namToiThieu);
					
					hopNhatTinhNhaTieuHVSXayMoiTU.setTenTinh(tenTinhValue);
					hopNhatTinhNhaTieuHVSXayMoiTU.setSoNhaTieuHGDHVSMoi(soNhaTieuHGDHVSMoiValue);
					lstHopNhatTinhNhaTieuHVSXayMoiTU.add(hopNhatTinhNhaTieuHVSXayMoiTU);
				}
			}
			// end part 3
			
			// start part 4, ve sinh toan xa
			lstHopNhatTinhThucHienVSTXTU = new ArrayList<HopNhatTinhThucHienVSTXTU>();
			List<DANHGIAVESINHXA> lstDanhgiavesinhxa = DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaGroupByMaHuyenMaXaBaoCaoHopNhat(null, null, null, namValueInt, namToiThieu, null);
			
			if(Validator.isNotNull(lstDanhgiavesinhxa) && lstDanhgiavesinhxa.size() > 0){
				for (DANHGIAVESINHXA danhgiavesinhxa : lstDanhgiavesinhxa) {
					hopNhatTinhThucHienVSTXTU = new HopNhatTinhThucHienVSTXTU();
					
					String maTinh = danhgiavesinhxa.getMaTinh();
					
					String tenTinhValue = "";
					String huyenValue = "";
					String xaValue = "";
					int coNhaTieuHVSValue = 0;
					int coNhaTieuValue = 0;
					int truongHocCoNcSachVaNhaTieuHVSValue = 0;
					int tramYteCoNcSachVaNhaTieuHVSValue = 0;
					int soNgHuongLoiTuVSTXValue = 0;
					
					tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
					huyenValue = Validator.isNotNull(danhgiavesinhxa.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, danhgiavesinhxa.getMaHuyen()) : "";
					xaValue = Validator.isNotNull(danhgiavesinhxa.getMaXa()) ? NuocSachUtils.getNameXa( danhgiavesinhxa.getMaXa()) : "";
					coNhaTieuHVSValue = Validator.isNotNull(danhgiavesinhxa.getMaTinh()) ? ConvertUtil.convertDoubleToint(DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat(danhgiavesinhxa.getMaTinh(),danhgiavesinhxa.getMaHuyen(),danhgiavesinhxa.getMaXa(),namValueInt,namToiThieu, String.valueOf(danhgiavesinhxa.getKetLuanVSTX()), 0, 1, 0, 0, 0, 0)) : 0;
					coNhaTieuValue = Validator.isNotNull(danhgiavesinhxa.getMaTinh()) ? ConvertUtil.convertDoubleToint(DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat(danhgiavesinhxa.getMaTinh(),danhgiavesinhxa.getMaHuyen(),danhgiavesinhxa.getMaXa(),namValueInt,namToiThieu, String.valueOf(danhgiavesinhxa.getKetLuanVSTX()), 0, 0, 1, 0, 0, 0)) : 0;
					truongHocCoNcSachVaNhaTieuHVSValue = Validator.isNotNull(danhgiavesinhxa.getMaTinh()) ? ConvertUtil.convertDoubleToint(DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat(danhgiavesinhxa.getMaTinh(),danhgiavesinhxa.getMaHuyen(),danhgiavesinhxa.getMaXa(),namValueInt,namToiThieu, String.valueOf(danhgiavesinhxa.getKetLuanVSTX()), 0, 0, 0, 1, 0, 0)) : 0;
					tramYteCoNcSachVaNhaTieuHVSValue = Validator.isNotNull(danhgiavesinhxa.getMaTinh()) ? ConvertUtil.convertDoubleToint(DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat(danhgiavesinhxa.getMaTinh(),danhgiavesinhxa.getMaHuyen(),danhgiavesinhxa.getMaXa(),namValueInt,namToiThieu, String.valueOf(danhgiavesinhxa.getKetLuanVSTX()), 0, 0, 0, 0, 1, 0)) : 0;
					if(Validator.isNotNull(danhgiavesinhxa.getKetLuanVSTX()) && danhgiavesinhxa.getKetLuanVSTX() == KETLUANVSTXINT){ // neu ketluanvstx la 1, tuc la co vstx thi hien thi so nguoi huong loi. Neu 0 thi ko hien thi so nguoi huong loi
						soNgHuongLoiTuVSTXValue = Validator.isNotNull(danhgiavesinhxa.getMaTinh()) ? ConvertUtil.convertDoubleToint(DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat(danhgiavesinhxa.getMaTinh(),danhgiavesinhxa.getMaHuyen(),danhgiavesinhxa.getMaXa(),namValueInt,namToiThieu, String.valueOf(danhgiavesinhxa.getKetLuanVSTX()), 0, 0, 0, 0, 0, 1)) : 0;
					}
					
					hopNhatTinhThucHienVSTXTU.setTenTinh(tenTinhValue);
					hopNhatTinhThucHienVSTXTU.setHuyen(huyenValue);
					hopNhatTinhThucHienVSTXTU.setXa(xaValue);
					hopNhatTinhThucHienVSTXTU.setCoNhaTieuHVS(coNhaTieuHVSValue);
					hopNhatTinhThucHienVSTXTU.setCoNhaTieu(coNhaTieuValue);
					hopNhatTinhThucHienVSTXTU.setTruongHocCoNcSachVaNhaTieuHVS(truongHocCoNcSachVaNhaTieuHVSValue);
					hopNhatTinhThucHienVSTXTU.setTramYteCoNcSachVaNhaTieuHVS(tramYteCoNcSachVaNhaTieuHVSValue);
					hopNhatTinhThucHienVSTXTU.setSoNgHuongLoiTuVSTX(soNgHuongLoiTuVSTXValue);
					
					lstHopNhatTinhThucHienVSTXTU.add(hopNhatTinhThucHienVSTXTU);
				}
			}
			// end part 4
			
			
			// start part 5, tong hop ve gioi
			lstHopNhatTinhTongHopVeGioiTU = new ArrayList<HopNhatTinhTongHopVeGioiTU>();
			hopNhatTinhTongHopVeGioiTU = new HopNhatTinhTongHopVeGioiTU();
			// 1.1 start
			int tongSo11Value = 0;
			int chuHoNam11Value = 0;
			int chuHoNu11Value = 0;
			
			int tongSo12Value = 0;
			int chuHoNam12Value = 0;
			int chuHoNu12Value = 0;
			
			int tongSo22Value = 0;
			int chuHoNam22Value = 0;
			int chuHoNu22Value = 0;
			List<THONGTINKIEMDEMNUOC> lstThongtinkiemdemnuoc = THONGTINKIEMDEMNUOCBusiness.getThongTinDNNTHVGGroupByMaTinhBaoCaoHopNhatTU(null, namValueInt, namToiThieu, null, null);
			lsthopNhatTinhTongHopVeGioiTUDanhSach11 = new ArrayList<HopNhatTinhTongHopVeGioiTUDanhSach>();
			if(Validator.isNotNull(lstThongtinkiemdemnuoc) && lstThongtinkiemdemnuoc.size() > 0){
				log.info("===HopNhatTinhTUExport==lstThongtinkiemdemnuoc="+lstThongtinkiemdemnuoc.size()+"--");
				for (THONGTINKIEMDEMNUOC thongtinkiemdemnuoc : lstThongtinkiemdemnuoc) {
					hopNhatTinhTongHopVeGioiTUDanhSach = hopNhatTinhTongHopVeGioiTU.new HopNhatTinhTongHopVeGioiTUDanhSach();
					
					String maTinh = thongtinkiemdemnuoc.getMaTinh();
					
					String tenTinhValue = "";
					int tongSoValue = 0;
					int chuHoNamValue = 0;
					int chuHoNuValue = 0;
					
					tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
					chuHoNamValue = THONGTINKIEMDEMNUOCBusiness.countGioiTinhChuHoBaoCaoHopNhat(maTinh, namValueInt, namToiThieu,  String.valueOf(WebKeys.GIOITINH_NAM), DANHGIAKIEMDEMDNN, DAKETTHUCDIEUTRA);
					chuHoNuValue = THONGTINKIEMDEMNUOCBusiness.countGioiTinhChuHoBaoCaoHopNhat(maTinh, namValueInt, namToiThieu,  String.valueOf(WebKeys.GIOITINH_NU), DANHGIAKIEMDEMDNN, DAKETTHUCDIEUTRA);
					tongSoValue = chuHoNamValue + chuHoNuValue;
					
					chuHoNam11Value = chuHoNam11Value + chuHoNamValue;
					chuHoNu11Value = chuHoNu11Value + chuHoNuValue;
					tongSo11Value = tongSo11Value + tongSoValue;
					
					
					hopNhatTinhTongHopVeGioiTUDanhSach.setTenTinh(tenTinhValue);
					hopNhatTinhTongHopVeGioiTUDanhSach.setTongSo(tongSoValue);
					hopNhatTinhTongHopVeGioiTUDanhSach.setChuHoNam(chuHoNamValue);
					hopNhatTinhTongHopVeGioiTUDanhSach.setChuHoNu(chuHoNuValue);
					lsthopNhatTinhTongHopVeGioiTUDanhSach11.add(hopNhatTinhTongHopVeGioiTUDanhSach);
				}
			}
			// 1.1 end
			
			
			
			// 1.2 start lttaidanglam
			List<ThongTinKiemDemHoGD> lstThongTinKiemDemHoGD12 = ThongTinKiemDemHoGDBusiness.getThongTinKiemDemHGDTVGGroupByMatinhBaoCaoHopNhatTU(null, namValueInt, namToiThieu, null, null, null);
			lsthopNhatTinhTongHopVeGioiTUDanhSach12 = new ArrayList<HopNhatTinhTongHopVeGioiTUDanhSach>();
			if(Validator.isNotNull(lstThongTinKiemDemHoGD12) && lstThongTinKiemDemHoGD12.size() > 0){
				log.info("===TongHopVeGioiTUExport==lstThongTinKiemDemHoGD12="+lstThongTinKiemDemHoGD12.size()+"--");
				for (ThongTinKiemDemHoGD thongTinKiemDemHoGD : lstThongTinKiemDemHoGD12) {
					hopNhatTinhTongHopVeGioiTUDanhSach = hopNhatTinhTongHopVeGioiTU.new HopNhatTinhTongHopVeGioiTUDanhSach();
					
					String maTinh = thongTinKiemDemHoGD.getMaTinh();
					
					String tenTinhValue = "";
					int tongSoValue = 0;
					int chuHoNamValue = 0;
					int chuHoNuValue = 0;
					
					tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
					chuHoNamValue = ThongTinKiemDemHoGDBusiness.countGioiTinhChuHoBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, String.valueOf(WebKeys.GIOITINH_NAM), DANHGIAKIEMDEMVSHGD, DAKETTHUCDIEUTRA);
					chuHoNuValue = ThongTinKiemDemHoGDBusiness.countGioiTinhChuHoBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, String.valueOf(WebKeys.GIOITINH_NU), DANHGIAKIEMDEMVSHGD, DAKETTHUCDIEUTRA);
					tongSoValue = chuHoNamValue + chuHoNuValue;
					
					chuHoNam12Value = chuHoNam12Value + chuHoNamValue;
					chuHoNu12Value = chuHoNu12Value + chuHoNuValue;
					tongSo12Value = tongSo12Value + tongSoValue;
					
					
					hopNhatTinhTongHopVeGioiTUDanhSach.setTenTinh(tenTinhValue);
					hopNhatTinhTongHopVeGioiTUDanhSach.setTongSo(tongSoValue);
					hopNhatTinhTongHopVeGioiTUDanhSach.setChuHoNam(chuHoNamValue);
					hopNhatTinhTongHopVeGioiTUDanhSach.setChuHoNu(chuHoNuValue);
					lsthopNhatTinhTongHopVeGioiTUDanhSach12.add(hopNhatTinhTongHopVeGioiTUDanhSach);
				}
			}
			// 1.2 end
			
			// 2.2 start
			
			List<ThongTinKiemDemHoGD> lstThongTinKiemDemHoGD22 = ThongTinKiemDemHoGDBusiness.getThongTinKiemDemHGDVSTXTVGGroupByMatinh(null, namBaoCao, null, null, null);
			lsthopNhatTinhTongHopVeGioiTUDanhSach22 = new ArrayList<HopNhatTinhTongHopVeGioiTUDanhSach>();
			if(Validator.isNotNull(lstThongTinKiemDemHoGD22) && lstThongTinKiemDemHoGD22.size() > 0){
				log.info("===TongHopVeGioiTUExport==lstThongTinKiemDemHoGD22="+lstThongTinKiemDemHoGD22.size()+"--");
				for (ThongTinKiemDemHoGD thongTinKiemDemHoGD : lstThongTinKiemDemHoGD22) {
					hopNhatTinhTongHopVeGioiTUDanhSach = hopNhatTinhTongHopVeGioiTU.new HopNhatTinhTongHopVeGioiTUDanhSach();
					String maTinh = thongTinKiemDemHoGD.getMaTinh();
					
					String tenTinhValue = "";
					int tongSoValue = 0;
					int chuHoNamValue = 0;
					int chuHoNuValue = 0;
					tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
					chuHoNamValue = ThongTinKiemDemHoGDBusiness.countGioiTinhChuHoByMauNNVSTXJoinVSGD(maTinh, mauNgauNhien, String.valueOf(WebKeys.GIOITINH_NAM));
					chuHoNuValue = ThongTinKiemDemHoGDBusiness.countGioiTinhChuHoByMauNNVSTXJoinVSGD(maTinh, mauNgauNhien, String.valueOf(WebKeys.GIOITINH_NU));
					tongSoValue = chuHoNamValue + chuHoNuValue;
					
					chuHoNam22Value = chuHoNam22Value + chuHoNamValue;
					chuHoNu22Value = chuHoNu22Value + chuHoNuValue;
					tongSo22Value = tongSo22Value + tongSoValue;
					
					
					hopNhatTinhTongHopVeGioiTUDanhSach.setTenTinh(tenTinhValue);
					hopNhatTinhTongHopVeGioiTUDanhSach.setTongSo(tongSoValue);
					hopNhatTinhTongHopVeGioiTUDanhSach.setChuHoNam(chuHoNamValue);
					hopNhatTinhTongHopVeGioiTUDanhSach.setChuHoNu(chuHoNuValue);
					lsthopNhatTinhTongHopVeGioiTUDanhSach22.add(hopNhatTinhTongHopVeGioiTUDanhSach);
				}
			}
			
			// 2.2 end
			
			hopNhatTinhTongHopVeGioiTU.setChuHoNam11(chuHoNam11Value);
			hopNhatTinhTongHopVeGioiTU.setChuHoNu11(chuHoNu11Value);
			hopNhatTinhTongHopVeGioiTU.setTongSo11(tongSo11Value);
			
			hopNhatTinhTongHopVeGioiTU.setChuHoNam12(chuHoNam12Value);
			hopNhatTinhTongHopVeGioiTU.setChuHoNu12(chuHoNu12Value);
			hopNhatTinhTongHopVeGioiTU.setTongSo12(tongSo12Value);
			
			hopNhatTinhTongHopVeGioiTU.setChuHoNam22(chuHoNam22Value);
			hopNhatTinhTongHopVeGioiTU.setChuHoNu22(chuHoNu22Value);
			hopNhatTinhTongHopVeGioiTU.setTongSo22(tongSo22Value);
			
			hopNhatTinhTongHopVeGioiTU.setLsthopNhatTinhTongHopVeGioiTUDanhSach11(lsthopNhatTinhTongHopVeGioiTUDanhSach11);
			hopNhatTinhTongHopVeGioiTU.setLsthopNhatTinhTongHopVeGioiTUDanhSach12(lsthopNhatTinhTongHopVeGioiTUDanhSach12);
			hopNhatTinhTongHopVeGioiTU.setLsthopNhatTinhTongHopVeGioiTUDanhSach22(lsthopNhatTinhTongHopVeGioiTUDanhSach22);
			
			
			// end part 5
			lstHopNhatTinhTongHopVeGioiTU.add(hopNhatTinhTongHopVeGioiTU);
		}
		
		result.setNam(namValue);
		result.setGiaiDoanTu(giaiDoanTuValue);
		result.setGiaiDoanDen(giaiDoanDenValue);
		result.setLstHopNhatTinhChiSoGiaiNganTU(lstHopNhatTinhChiSoGiaiNganTU);
		result.setLstHopNhatTinhCapNuocTapTrungTU(lstHopNhatTinhCapNuocTapTrungTU);
		result.setLstHopNhatTinhNhaTieuHVSXayMoiTU(lstHopNhatTinhNhaTieuHVSXayMoiTU);
		result.setLstHopNhatTinhThucHienVSTXTU(lstHopNhatTinhThucHienVSTXTU);
		result.setLstHopNhatTinhTongHopVeGioiTU(lstHopNhatTinhTongHopVeGioiTU);
	
		log.info("==END==HOP NHAT CAC TINH==HopNhatTinhTUExport===");
		return result;
		
	}
}
