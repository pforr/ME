package vn.dtt.sol.ns.reporting.model.hopnhattinh;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.baocaodli.business.BaoCaoDLITongHopBusiness;
import vn.dtt.sol.ns.business.DataItemBusiness;
import vn.dtt.sol.ns.danhgiavesinh.business.DANHGIAVESINHXABusiness;
import vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA;
import vn.dtt.sol.ns.reporting.utils.ReportConstant;
import vn.dtt.sol.ns.tramcap.business.DanhGiaBenVungBussiness;
import vn.dtt.sol.ns.tramcap.business.THONGTINKIEMDEMNUOCBusiness;
import vn.dtt.sol.ns.tramcap.business.TramCapBusiness;
import vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVung;
import vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.util.WebKeys;
import vn.dtt.sol.ns.util.format.ConvertUtil;
import vn.dtt.sol.ns.vesinhmoitruong.business.ThongTinKiemDemHoGDBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.business.VeSinhGiaDinhBusiness;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhGiaDinh;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class HopNhatTinhExport {
	private static Log log = LogFactoryUtil.getLog(HopNhatTinhExport.class);
	
	public static HopNhatTinh getModel(String namBaoCao,String maTinh,String giaiDoanTu,String giaiDoanDen){
		log.info("==START==HOP NHAT CAC TINH==HopNhatTinhExport===");
		log.info("==giaidoantu=="+giaiDoanTu+"--");
		log.info("==giaidoanden=="+giaiDoanDen+"--");
		// nam toi thieu thuc hien chuong trinh
		int namToiThieu = 2013;
		int namToiDa = 0;
		String[] TRANGTHAIVS = {"2","3"}; // trangthai 2 la co nha tieu hvs xay moi, 3 la co nha tieu hvs
		String KETLUANVSTX = "1"; // 1 la co vstx
		String DAKETTHUCDIEUTRA = "1";
		// nuoc
		String DANHGIAKIEMDEMDNN = "1"; ///danhgiakiemdem 1 la kiem dem dat
		// ve sinh
		String[] DANHGIAKIEMDEMVSHGD = {"1","2"};// danhgiakiemdem 1 la co nha tieu hvs xay moi, 2 la co nha tieu hvs
		
		HopNhatTinh result = new HopNhatTinh();
		
		//
		String namValue = "";
		String tenTinhValue = "";
		String giaiDoanTuValue = "";
		String giaiDoanDenValue = "";
		int namValueInt = 0;
		int giaiDoanTuValueInt = 0;
		int giaiDoanDenValueInt = 0;
		
		//
		HopNhatTinhChiSoGiaiNgan hopNhatTinhChiSoGiaiNgan = null;
		List<HopNhatTinhChiSoGiaiNgan> lstHopNhatTinhChiSoGiaiNgan = null;
		//
		HopNhatTinhCapNuocTapTrung hopNhatTinhCapNuocTapTrung = null;
		List<HopNhatTinhCapNuocTapTrung> lstHopNhatTinhCapNuocTapTrung = null;
		//
		HopNhatTinhNhaTieuHVSXayMoi hopNhatTinhNhaTieuHVSXayMoi = null;
		List<HopNhatTinhNhaTieuHVSXayMoi> lstHopNhatTinhNhaTieuHVSXayMoi = null;
		//
		HopNhatTinhThucHienVSTX hopNhatTinhThucHienVSTX = null;
		List<HopNhatTinhThucHienVSTX> lstHopNhatTinhThucHienVSTX = null;
		//
		HopNhatTinhTongHopVeGioi hopNhatTinhTongHopVeGioi = null;
		List<HopNhatTinhTongHopVeGioi> lstHopNhatTinhTongHopVeGioi = null;
		
		namValue = Validator.isNotNull(namBaoCao) ? namBaoCao : "";		
		tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
		
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
			lstHopNhatTinhChiSoGiaiNgan = new ArrayList<HopNhatTinhChiSoGiaiNgan>();
			
			
			hopNhatTinhChiSoGiaiNgan = new HopNhatTinhChiSoGiaiNgan();
			
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
			
			//1
			SoDauNoiKHValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0));
			SoDauNoiKQDDValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0));
			//2
			SoNhaTieuHGDXayMoiKHValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0));
			SoNhaTieuHGDXayMoiKQDDValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0));
			//3
			SoNgHgLoiTuCapNcBenVungKHValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0));
			SoNgHgLoiTuCapNcBenVungKQDDValue = "0";
			//4
			SoNgHgLoiTuVSTXKHValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0));
			SoNgHgLoiTuVSTXKQDDValue = "0";
			//5
			SoKHCuaTinhDcPheDuyetKHValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0));
			SoKHCuaTinhDcPheDuyetKQDDValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0));
			//6
			SoBCCTDcCongBoKHValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0));
			SoBCCTDcCongBoKQDDValue = ConvertUtil.parseIntToString1000(BaoCaoDLITongHopBusiness.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1));
			
			
			hopNhatTinhChiSoGiaiNgan.setSoDauNoiKH(SoDauNoiKHValue);
			hopNhatTinhChiSoGiaiNgan.setSoDauNoiKQDD(SoDauNoiKQDDValue);
			hopNhatTinhChiSoGiaiNgan.setSoNhaTieuHGDXayMoiKH(SoNhaTieuHGDXayMoiKHValue);
			hopNhatTinhChiSoGiaiNgan.setSoNhaTieuHGDXayMoiKQDD(SoNhaTieuHGDXayMoiKQDDValue);
			hopNhatTinhChiSoGiaiNgan.setSoNgHgLoiTuCapNcBenVungKH(SoNgHgLoiTuCapNcBenVungKHValue);
			hopNhatTinhChiSoGiaiNgan.setSoNgHgLoiTuCapNcBenVungKQDD(SoNgHgLoiTuCapNcBenVungKQDDValue);
			hopNhatTinhChiSoGiaiNgan.setSoNgHgLoiTuVSTXKH(SoNgHgLoiTuVSTXKHValue);
			hopNhatTinhChiSoGiaiNgan.setSoNgHgLoiTuVSTXKQDD(SoNgHgLoiTuVSTXKQDDValue);
			hopNhatTinhChiSoGiaiNgan.setSoKHCuaTinhDcPheDuyetKH(SoKHCuaTinhDcPheDuyetKHValue);
			hopNhatTinhChiSoGiaiNgan.setSoKHCuaTinhDcPheDuyetKQDD(SoKHCuaTinhDcPheDuyetKQDDValue);
			hopNhatTinhChiSoGiaiNgan.setSoBCCTDcCongBoKH(SoBCCTDcCongBoKHValue);
			hopNhatTinhChiSoGiaiNgan.setSoBCCTDcCongBoKQDD(SoBCCTDcCongBoKQDDValue);
			lstHopNhatTinhChiSoGiaiNgan.add(hopNhatTinhChiSoGiaiNgan);
			// end part 1
			
			// start part 2 : tien do cap nuoc tap trung
			lstHopNhatTinhCapNuocTapTrung = new ArrayList<HopNhatTinhCapNuocTapTrung>();
			List<TramCapNuoc> lstTramCapNuoc = TramCapBusiness.getTramCapNuocJoinDanhGiaBenVungBaoCaoHopNhat(maTinh, namValueInt, namToiThieu);
			if(Validator.isNotNull(lstTramCapNuoc) && lstTramCapNuoc.size() > 0){
				for (TramCapNuoc tramCapNuoc : lstTramCapNuoc) {
					hopNhatTinhCapNuocTapTrung = new HopNhatTinhCapNuocTapTrung();
					
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
					
					hopNhatTinhCapNuocTapTrung.setTenCongTrinh(tenCongTrinhValue);
					hopNhatTinhCapNuocTapTrung.setDiaDiem(diaDiemValue);
					hopNhatTinhCapNuocTapTrung.setTinhTrang(tinhTrangValue);
					hopNhatTinhCapNuocTapTrung.setTheoKH(theoKHValue);
					hopNhatTinhCapNuocTapTrung.setWorking(workingValue);
					hopNhatTinhCapNuocTapTrung.setTatCaChiSo(tatCaChiSoValue);
					hopNhatTinhCapNuocTapTrung.setArsen(arsenValue);
					hopNhatTinhCapNuocTapTrung.setNcThatThoat(ncThatThoatValue);
					hopNhatTinhCapNuocTapTrung.setDoanhThu(doanhThuValue);
					hopNhatTinhCapNuocTapTrung.setChiPhiVHBD(chiPhiVHBDValue);
					hopNhatTinhCapNuocTapTrung.setMoHinhQL(moHinhQLValue);
					lstHopNhatTinhCapNuocTapTrung.add(hopNhatTinhCapNuocTapTrung);
				}
			}
			// end part 2
			
			// start part 3, nha tieu hvs xay moi
			lstHopNhatTinhNhaTieuHVSXayMoi = new ArrayList<HopNhatTinhNhaTieuHVSXayMoi>();
			List<VeSinhGiaDinh> lstVeSinhGiaDinh = VeSinhGiaDinhBusiness.getVeSinhGiaDinhGroupByMaHuyenBaoCaoHopNhat(maTinh, null, null, null, TRANGTHAIVS, namValueInt, namToiThieu);
			
			if(Validator.isNotNull(lstVeSinhGiaDinh) && lstVeSinhGiaDinh.size() > 0){
				for (VeSinhGiaDinh veSinhGiaDinh : lstVeSinhGiaDinh) {
					hopNhatTinhNhaTieuHVSXayMoi = new HopNhatTinhNhaTieuHVSXayMoi();
					String huyenValue = "";
					String xaValue = "";
					int soNhaTieuHGDHVSMoiValue = 0;
					
					huyenValue = Validator.isNotNull(veSinhGiaDinh.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, veSinhGiaDinh.getMaHuyen()) : "";
					xaValue = Validator.isNotNull(veSinhGiaDinh.getMaXa()) ? NuocSachUtils.getNameXa( veSinhGiaDinh.getMaXa()) : "";
					soNhaTieuHGDHVSMoiValue = VeSinhGiaDinhBusiness.countVeSinhGiaDinhGroupByMaHuyenBaoCaoHopNhat(maTinh, veSinhGiaDinh.getMaHuyen(), veSinhGiaDinh.getMaXa(),  TRANGTHAIVS, namValueInt,namToiThieu);
					
					hopNhatTinhNhaTieuHVSXayMoi.setHuyen(huyenValue);
					hopNhatTinhNhaTieuHVSXayMoi.setXa(xaValue);
					hopNhatTinhNhaTieuHVSXayMoi.setSoNhaTieuHGDHVSMoi(soNhaTieuHGDHVSMoiValue);
					lstHopNhatTinhNhaTieuHVSXayMoi.add(hopNhatTinhNhaTieuHVSXayMoi);
				}
			}
			// end part 3
			
			// start part 4, ve sinh toan xa
			lstHopNhatTinhThucHienVSTX = new ArrayList<HopNhatTinhThucHienVSTX>();
			List<DANHGIAVESINHXA> lstDanhgiavesinhxa = DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaGroupByMaHuyenMaXaBaoCaoHopNhat(maTinh, null, null, namValueInt, namToiThieu, KETLUANVSTX);
			if(Validator.isNotNull(lstDanhgiavesinhxa) && lstDanhgiavesinhxa.size() > 0){
				for (DANHGIAVESINHXA danhgiavesinhxa : lstDanhgiavesinhxa) {
					hopNhatTinhThucHienVSTX = new HopNhatTinhThucHienVSTX();
					
					String huyenValue = "";
					String xaValue = "";
					int coNhaTieuHVSValue = 0;
					int coNhaTieuValue = 0;
					int truongHocCoNcSachVaNhaTieuHVSValue = 0;
					int tramYteCoNcSachVaNhaTieuHVSValue = 0;
					int soNgHuongLoiTuVSTXValue = 0;
					
					huyenValue = Validator.isNotNull(danhgiavesinhxa.getMaHuyen()) ? NuocSachUtils.getNameHuyen(null, danhgiavesinhxa.getMaHuyen()) : "";
					xaValue = Validator.isNotNull(danhgiavesinhxa.getMaXa()) ? NuocSachUtils.getNameXa( danhgiavesinhxa.getMaXa()) : "";
					coNhaTieuHVSValue = Validator.isNotNull(danhgiavesinhxa.getMaTinh()) ? ConvertUtil.convertDoubleToint(DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat(danhgiavesinhxa.getMaTinh(),danhgiavesinhxa.getMaHuyen(),danhgiavesinhxa.getMaXa(),namValueInt,namToiThieu, KETLUANVSTX, 0, 1, 0, 0, 0, 0)) : 0;
					coNhaTieuValue = Validator.isNotNull(danhgiavesinhxa.getMaTinh()) ? ConvertUtil.convertDoubleToint(DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat(danhgiavesinhxa.getMaTinh(),danhgiavesinhxa.getMaHuyen(),danhgiavesinhxa.getMaXa(),namValueInt,namToiThieu, KETLUANVSTX, 0, 0, 1, 0, 0, 0)) : 0;
					truongHocCoNcSachVaNhaTieuHVSValue = Validator.isNotNull(danhgiavesinhxa.getMaTinh()) ? ConvertUtil.convertDoubleToint(DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat(danhgiavesinhxa.getMaTinh(),danhgiavesinhxa.getMaHuyen(),danhgiavesinhxa.getMaXa(),namValueInt,namToiThieu, KETLUANVSTX, 0, 0, 0, 1, 0, 0)) : 0;
					tramYteCoNcSachVaNhaTieuHVSValue = Validator.isNotNull(danhgiavesinhxa.getMaTinh()) ? ConvertUtil.convertDoubleToint(DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat(danhgiavesinhxa.getMaTinh(),danhgiavesinhxa.getMaHuyen(),danhgiavesinhxa.getMaXa(),namValueInt,namToiThieu, KETLUANVSTX, 0, 0, 0, 0, 1, 0)) : 0;
					soNgHuongLoiTuVSTXValue = Validator.isNotNull(danhgiavesinhxa.getMaTinh()) ? ConvertUtil.convertDoubleToint(DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat(danhgiavesinhxa.getMaTinh(),danhgiavesinhxa.getMaHuyen(),danhgiavesinhxa.getMaXa(),namValueInt,namToiThieu, KETLUANVSTX, 0, 0, 0, 0, 0, 1)) : 0;
					
					hopNhatTinhThucHienVSTX.setHuyen(huyenValue);
					hopNhatTinhThucHienVSTX.setXa(xaValue);
					hopNhatTinhThucHienVSTX.setCoNhaTieuHVS(coNhaTieuHVSValue);
					hopNhatTinhThucHienVSTX.setCoNhaTieu(coNhaTieuValue);
					hopNhatTinhThucHienVSTX.setTruongHocCoNcSachVaNhaTieuHVS(truongHocCoNcSachVaNhaTieuHVSValue);
					hopNhatTinhThucHienVSTX.setTramYteCoNcSachVaNhaTieuHVS(tramYteCoNcSachVaNhaTieuHVSValue);
					hopNhatTinhThucHienVSTX.setSoNgHuongLoiTuVSTX(soNgHuongLoiTuVSTXValue);
					
					lstHopNhatTinhThucHienVSTX.add(hopNhatTinhThucHienVSTX);
				}
			}
			// end part 4
			
			// start part 5, tong hop ve gioi
			lstHopNhatTinhTongHopVeGioi = new ArrayList<HopNhatTinhTongHopVeGioi>();
			
			hopNhatTinhTongHopVeGioi = new HopNhatTinhTongHopVeGioi();
			
			String tongSo11Value = "";
			String chuHoNam11Value = "";
			String chuHoNu11Value = "";
			int tongSo11ValueInt = 0;
			int chuHoNam11ValueInt = 0;
			int chuHoNu11ValueInt = 0;
			
			String tongSo12Value = "";
			String chuHoNam12Value = "";
			String chuHoNu12Value = "";
			int tongSo12ValueInt = 0;
			int chuHoNam12ValueInt = 0;
			int chuHoNu12ValueInt = 0;
			
			String tongSo22Value = "";
			String chuHoNam22Value = "";
			String chuHoNu22Value = "";
			int tongSo22ValueInt = 0;
			int chuHoNam22ValueInt = 0;
			int chuHoNu22ValueInt = 0;
			
			chuHoNam11ValueInt = THONGTINKIEMDEMNUOCBusiness.countGioiTinhChuHoBaoCaoHopNhat(maTinh, namValueInt, namToiThieu,  String.valueOf(WebKeys.GIOITINH_NAM), DANHGIAKIEMDEMDNN, DAKETTHUCDIEUTRA);
			chuHoNu11ValueInt = THONGTINKIEMDEMNUOCBusiness.countGioiTinhChuHoBaoCaoHopNhat(maTinh, namValueInt, namToiThieu,  String.valueOf(WebKeys.GIOITINH_NU), DANHGIAKIEMDEMDNN, DAKETTHUCDIEUTRA);
			tongSo11ValueInt = chuHoNam11ValueInt + chuHoNu11ValueInt;
			chuHoNam11Value = ConvertUtil.parseIntToString1000(chuHoNam11ValueInt);
			chuHoNu11Value = ConvertUtil.parseIntToString1000(chuHoNu11ValueInt);
			tongSo11Value = ConvertUtil.parseIntToString1000(tongSo11ValueInt);
			
			chuHoNam12ValueInt = ThongTinKiemDemHoGDBusiness.countGioiTinhChuHoBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, String.valueOf(WebKeys.GIOITINH_NAM), DANHGIAKIEMDEMVSHGD, DAKETTHUCDIEUTRA);
			chuHoNu12ValueInt = ThongTinKiemDemHoGDBusiness.countGioiTinhChuHoBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, String.valueOf(WebKeys.GIOITINH_NU), DANHGIAKIEMDEMVSHGD, DAKETTHUCDIEUTRA);
			tongSo12ValueInt = chuHoNam12ValueInt + chuHoNu12ValueInt;
			chuHoNam12Value = ConvertUtil.parseIntToString1000(chuHoNam12ValueInt);
			chuHoNu12Value = ConvertUtil.parseIntToString1000(chuHoNu12ValueInt);
			tongSo12Value = ConvertUtil.parseIntToString1000(tongSo12ValueInt);
			
			chuHoNam22ValueInt = ThongTinKiemDemHoGDBusiness.countGioiTinhChuHoByMauNNVSTXJoinVSGDBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, String.valueOf(WebKeys.GIOITINH_NAM), null, null);
			chuHoNu22ValueInt = ThongTinKiemDemHoGDBusiness.countGioiTinhChuHoByMauNNVSTXJoinVSGDBaoCaoHopNhat(maTinh, namValueInt, namToiThieu, String.valueOf(WebKeys.GIOITINH_NU), null, null);
			tongSo22ValueInt = chuHoNam22ValueInt + chuHoNu22ValueInt;
			chuHoNam22Value = ConvertUtil.parseIntToString1000(chuHoNam22ValueInt);
			chuHoNu22Value = ConvertUtil.parseIntToString1000(chuHoNu22ValueInt);
			tongSo22Value = ConvertUtil.parseIntToString1000(tongSo22ValueInt);
			
			hopNhatTinhTongHopVeGioi.setChuHoNam11(chuHoNam11Value);
			hopNhatTinhTongHopVeGioi.setChuHoNu11(chuHoNu11Value);
			hopNhatTinhTongHopVeGioi.setTongSo11(tongSo11Value);
			hopNhatTinhTongHopVeGioi.setChuHoNam12(chuHoNam12Value);
			hopNhatTinhTongHopVeGioi.setChuHoNu12(chuHoNu12Value);
			hopNhatTinhTongHopVeGioi.setTongSo12(tongSo12Value);
			hopNhatTinhTongHopVeGioi.setChuHoNam22(chuHoNam22Value);
			hopNhatTinhTongHopVeGioi.setChuHoNu22(chuHoNu22Value);
			hopNhatTinhTongHopVeGioi.setTongSo22(tongSo22Value);
			
			lstHopNhatTinhTongHopVeGioi.add(hopNhatTinhTongHopVeGioi);
			// end part 5
		}
		
		result.setNam(namValue);
		result.setTenTinh(tenTinhValue);
		result.setGiaiDoanTu(giaiDoanTuValue);
		result.setGiaiDoanDen(giaiDoanDenValue);
		//
		result.setLstHopNhatTinhChiSoGiaiNgan(lstHopNhatTinhChiSoGiaiNgan);
		result.setLstHopNhatTinhCapNuocTapTrung(lstHopNhatTinhCapNuocTapTrung);
		result.setLstHopNhatTinhNhaTieuHVSXayMoi(lstHopNhatTinhNhaTieuHVSXayMoi);
		result.setLstHopNhatTinhThucHienVSTX(lstHopNhatTinhThucHienVSTX);
		result.setLstHopNhatTinhTongHopVeGioi(lstHopNhatTinhTongHopVeGioi);
		//
		log.info("==END==HOP NHAT CAC TINH==HopNhatTinhExport===");
		return result;
	}
}
