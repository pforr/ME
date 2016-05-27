package vn.dtt.sol.ns.reporting.model.dlith;

import java.util.Date;

import vn.dtt.sol.ns.baocaodli.business.BaoCaoDLITongHopBusiness;
import vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHop;
import vn.dtt.sol.ns.baocaodli.util.DLIUtils;
import vn.dtt.sol.ns.business.KeHoachNuocSachBusiness;
import vn.dtt.sol.ns.business.KeHoachVeSinhBusiness;
import vn.dtt.sol.ns.danhgiavesinh.business.DANHGIAVESINHXABusiness;
import vn.dtt.sol.ns.reporting.utils.ReportBusinessUtils;
import vn.dtt.sol.ns.reporting.utils.ReportConstant;
import vn.dtt.sol.ns.reporting.utils.ReportFunction;
import vn.dtt.sol.ns.util.NuocSachUtils;
import vn.dtt.sol.ns.util.format.ConvertUtil;
import vn.dtt.sol.ns.util.format.FormatData;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class TomTatTDTHCSGiaiNganExport {
	private static Log log = LogFactoryUtil.getLog(TomTatTDTHCSGiaiNganExport.class);
	
	
	public static TomTatTDTHCSGiaiNgan getModel(String namBaoCao, String maTinh, String soBaoCao, String ngayBaoCao, String nguoiLap, String nguoiDuyet,String donViBaoCao){
		log.info("==========TomTatTDTHCSGiaiNganExport===");
		log.info("--getModel==namBaoCao=="+namBaoCao+"==soBaoCao--"+soBaoCao+"==ngayBaoCao--"+ngayBaoCao+"==maTinh--"+maTinh);
		String DANGKYVSTX = "1"; // 1 la co vstx
		String KETLUANVSTX = "1"; // 1 la ketuan co vstoanxa
		TomTatTDTHCSGiaiNgan result = new TomTatTDTHCSGiaiNgan(); 
		
		String namValue = "";
		String tenTinhValue = "";	
		String baoCaoSoValue = "";
		String baoCaoNgayThangNamValue = "";
		String nguoiLapValue = "";
		String nguoiDuyetValue = "";
		String donViBaoCaoValue = "";
		
		String SoDauNoiKHValue = "";
		String SoDauNoiKQDDValue = "";
		String SoDauNoiThucHienKHValue = "";

		String SoNhaTieuHGDXayMoiKHValue = "";
		String SoNhaTieuHGDXayMoiKQDDValue = "";
		String SoNhaTieuHGDXayMoiThucHienKHValue = "";

		String SoNgHgLoiTuCapNcBenVungKHValue = "";
		String SoNgHgLoiTuCapNcBenVungKQDDValue = "";
		String SoNgHgLoiTuCapNcBenVungThucHienKHValue = "";
		
		String SoNgHgLoiTuVSTXKHValue = "";
		String SoNgHgLoiTuVSTXKQDDValue = "";
		String SoNgHgLoiTuVSTXThucHienKHValue = "";
		
		String SoKHCuaTinhDcPheDuyetKHValue = "";
		String SoKHCuaTinhDcPheDuyetKQDDValue = "";
		String SoKHCuaTinhDcPheDuyetThucHienKHValue = "";
		
		String SoBCCTDcCongBoKHValue = "";
		String SoBCCTDcCongBoKQDDValue = "";
		String SoBCCTDcCongBoThucHienKHValue = "";
		
		
		namValue = Validator.isNotNull(namBaoCao) ? namBaoCao : "";		
		tenTinhValue = NuocSachUtils.getNameTinh(maTinh);
		baoCaoSoValue = Validator.isNotNull(soBaoCao) ? soBaoCao : "" ;
		if(Validator.isNotNull(ngayBaoCao)){
			Date dateNgayBaoCao = FormatData.parseStringToDateTypeDDMMYYYY(ngayBaoCao.trim());
			baoCaoNgayThangNamValue = ReportFunction.parserDateToString4(dateNgayBaoCao);
		}
		if(Validator.isNotNull(nguoiLap)){
			nguoiLapValue = nguoiLap;
		}
		if(Validator.isNotNull(nguoiDuyet)){
			nguoiDuyetValue = nguoiDuyet;
		}
		donViBaoCaoValue = donViBaoCao;
		DLIUtils util = new DLIUtils();
		BaoCaoDLITongHop baoCaoDLITongHop = BaoCaoDLITongHopBusiness.getBaoCaoDLITongHopByTinhVaNam(maTinh, namBaoCao);
/*		if(Validator.isNotNull(baoCaoDLITongHop) ){
			
			SoDauNoiKHValue = Validator.isNotNull(baoCaoDLITongHop.getSoDauNoiTheoKeHoach()) ? ConvertUtil.parseIntToString1000(baoCaoDLITongHop.getSoDauNoiTheoKeHoach()) : "" ;
			SoDauNoiKQDDValue = Validator.isNotNull(baoCaoDLITongHop.getSoDauNoiMoi()) ? ConvertUtil.parseIntToString1000(baoCaoDLITongHop.getSoDauNoiMoi()) : "" ;
			if(Validator.isNotNull(baoCaoDLITongHop.getSoDauNoiMoi())
					&& Validator.isNotNull(baoCaoDLITongHop.getSoDauNoiTheoKeHoach())   
					&& baoCaoDLITongHop.getSoDauNoiTheoKeHoach() > 0 ){
				
				SoDauNoiThucHienKHValue = ConvertUtil.parseDoubleToString2Digits((ConvertUtil.convertIntToDouble(baoCaoDLITongHop.getSoDauNoiMoi()) / ConvertUtil.convertIntToDouble(baoCaoDLITongHop.getSoDauNoiTheoKeHoach())) * 100);
			
			}
			
			SoNhaTieuHGDXayMoiKHValue = Validator.isNotNull(baoCaoDLITongHop.getSoNhaTieuHVSTheoKH()) ? ConvertUtil.parseIntToString1000(baoCaoDLITongHop.getSoNhaTieuHVSTheoKH()) : "" ;
			SoNhaTieuHGDXayMoiKQDDValue = Validator.isNotNull(baoCaoDLITongHop.getSoNhaTieuHVSMoi()) ? ConvertUtil.parseIntToString1000(baoCaoDLITongHop.getSoNhaTieuHVSMoi()) : "" ;
			if(Validator.isNotNull(baoCaoDLITongHop.getSoNhaTieuHVSMoi())
					&& Validator.isNotNull(baoCaoDLITongHop.getSoNhaTieuHVSTheoKH())   
					&& baoCaoDLITongHop.getSoNhaTieuHVSTheoKH() > 0 ){
				
				SoNhaTieuHGDXayMoiThucHienKHValue = ConvertUtil.parseDoubleToString2Digits((ConvertUtil.convertIntToDouble(baoCaoDLITongHop.getSoNhaTieuHVSMoi()) / ConvertUtil.convertIntToDouble(baoCaoDLITongHop.getSoNhaTieuHVSTheoKH())) * 100);
			
			}
			
			SoNgHgLoiTuCapNcBenVungKHValue = Validator.isNotNull(baoCaoDLITongHop.getSoNguoiHuongLoiNuocSach()) ? ConvertUtil.parseIntToString1000(baoCaoDLITongHop.getSoNguoiHuongLoiNuocSach()) : "" ;
			int SoNgHgLoiTuCapNcBenVungKQDDValueTemp = KeHoachNuocSachBusiness.countSoNguoiHuongLoiCapNcBenVung(namBaoCao,maTinh);
			SoNgHgLoiTuCapNcBenVungKQDDValue = (SoNgHgLoiTuCapNcBenVungKQDDValueTemp > 0) ? ConvertUtil.parseIntToString1000(SoNgHgLoiTuCapNcBenVungKQDDValueTemp) : "";
			if( Validator.isNotNull(baoCaoDLITongHop.getSoNguoiHuongLoiNuocSach())   
					&& baoCaoDLITongHop.getSoNguoiHuongLoiNuocSach() > 0 ){
				
				SoNgHgLoiTuCapNcBenVungThucHienKHValue = ConvertUtil.parseDoubleToString2Digits((ConvertUtil.convertIntToDouble(SoNgHgLoiTuCapNcBenVungKQDDValueTemp) / ConvertUtil.convertIntToDouble(baoCaoDLITongHop.getSoNguoiHuongLoiNuocSach())) * 100);
			
			}
			
			int SoNgHgLoiTuVSTXKHValueTemp = KeHoachVeSinhBusiness.countSoDanHuongLoi(namBaoCao, maTinh, DANGKYVSTX);
			SoNgHgLoiTuVSTXKHValue = (SoNgHgLoiTuVSTXKHValueTemp > 0) ? ConvertUtil.parseIntToString1000(SoNgHgLoiTuVSTXKHValueTemp) : "0";
			double SoNgHgLoiTuVSTXKQDDValueDoubleTemp = DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaTyLeAllTW(maTinh, namBaoCao, KETLUANVSTX, 0, 0, 0, 0, 0, 1);
			int SoNgHgLoiTuVSTXKQDDValueIntTemp = ConvertUtil.convertDoubleToint(SoNgHgLoiTuVSTXKQDDValueDoubleTemp);
			SoNgHgLoiTuVSTXKQDDValue = (SoNgHgLoiTuVSTXKQDDValueIntTemp > 0) ? ConvertUtil.parseIntToString1000(SoNgHgLoiTuVSTXKQDDValueIntTemp) : "0";
			
			if( Validator.isNotNull(SoNgHgLoiTuVSTXKHValueTemp)   
					&& SoNgHgLoiTuVSTXKHValueTemp > 0 ){
				
				SoNgHgLoiTuVSTXThucHienKHValue = ConvertUtil.parseDoubleToString2Digits((SoNgHgLoiTuVSTXKQDDValueDoubleTemp / ConvertUtil.convertIntToDouble(SoNgHgLoiTuVSTXKHValueTemp)) * 100);
			
			}
			
			SoKHCuaTinhDcPheDuyetKHValue = Validator.isNotNull(baoCaoDLITongHop.getKeHoachPheDuyet()) ? ReportConstant.CO : "";
			SoKHCuaTinhDcPheDuyetKQDDValue = Validator.isNotNull(baoCaoDLITongHop.getKeHoachPheDuyet()) ? ReportConstant.CO : "";
			SoKHCuaTinhDcPheDuyetThucHienKHValue = "";
			
			SoBCCTDcCongBoKHValue = Validator.isNotNull(baoCaoDLITongHop.getBaoCaoChuongTrinh()) ? ReportConstant.CO : "";
			SoBCCTDcCongBoKQDDValue = Validator.isNotNull(baoCaoDLITongHop.getBaoCaoChuongTrinh()) ? ReportConstant.CO : "";
			SoBCCTDcCongBoThucHienKHValue = "";
		}*/

		if(Validator.isNotNull(baoCaoDLITongHop) ){
			
			
			
			// 1.1 start
			//SoDauNoiKHValue = Validator.isNotNull(baoCaoDLITongHop.getSoDauNoiTheoKeHoach()) ? ConvertUtil.parseIntToString1000(baoCaoDLITongHop.getSoDauNoiTheoKeHoach()) : "" ;
			SoDauNoiKHValue =  ConvertUtil.parseIntToString1000(util.getSoDauNoiTheoKeHoach(maTinh, Integer.parseInt(namBaoCao)));
			//SoDauNoiKQDDValue = Validator.isNotNull(baoCaoDLITongHop.getSoDauNoiMoi()) ? ConvertUtil.parseIntToString1000(baoCaoDLITongHop.getSoDauNoiMoi()) : "" ;
			SoDauNoiKQDDValue = ConvertUtil.parseIntToString1000(util.getSoDauNoiMoi(maTinh, Integer.parseInt(namBaoCao)));
			if(Validator.isNotNull(baoCaoDLITongHop.getSoDauNoiMoi())
					&& Validator.isNotNull(baoCaoDLITongHop.getSoDauNoiTheoKeHoach())   
					&& baoCaoDLITongHop.getSoDauNoiTheoKeHoach() > 0 ){
				
				SoDauNoiThucHienKHValue = ConvertUtil.parseDoubleToString2Digits((ConvertUtil.convertIntToDouble(baoCaoDLITongHop.getSoDauNoiMoi()) / ConvertUtil.convertIntToDouble(baoCaoDLITongHop.getSoDauNoiTheoKeHoach())) * 100);
			
			}
			// 1.1 end
			
			// 1.2 start
			//SoNhaTieuHGDXayMoiKHValue = Validator.isNotNull(baoCaoDLITongHop.getSoNhaTieuHVSTheoKH()) ? ConvertUtil.parseIntToString1000(baoCaoDLITongHop.getSoNhaTieuHVSTheoKH()) : "" ;
			//SoNhaTieuHGDXayMoiKQDDValue = Validator.isNotNull(baoCaoDLITongHop.getSoNhaTieuHVSMoi()) ? ConvertUtil.parseIntToString1000(baoCaoDLITongHop.getSoNhaTieuHVSMoi()) : "" ;

			SoNhaTieuHGDXayMoiKHValue =  ConvertUtil.parseIntToString1000(util.getSoNhaTieuHVSTheoKH(maTinh, Integer.parseInt(namBaoCao)));
			SoNhaTieuHGDXayMoiKQDDValue		=  ConvertUtil.parseIntToString1000(util.getSoNhaTieuHVSMoi(maTinh, Integer.parseInt(namBaoCao)));
			
			//System.out.println("SoNhaTieuHGDXayMoiKQDDValue:---------------"+SoNhaTieuHGDXayMoiKQDDValue); 
			
			if(Validator.isNotNull(baoCaoDLITongHop.getSoNhaTieuHVSMoi())
					&& Validator.isNotNull(baoCaoDLITongHop.getSoNhaTieuHVSTheoKH())   
					&& baoCaoDLITongHop.getSoNhaTieuHVSTheoKH() > 0 ){
				
				SoNhaTieuHGDXayMoiThucHienKHValue = ConvertUtil.parseDoubleToString2Digits((ConvertUtil.convertIntToDouble(baoCaoDLITongHop.getSoNhaTieuHVSMoi()) / ConvertUtil.convertIntToDouble(baoCaoDLITongHop.getSoNhaTieuHVSTheoKH())) * 100);
			
			}
			// 1.2 end
			
			// 2.1 start
			int SoNgHgLoiTuCapNcBenVungKHValueTemp = KeHoachNuocSachBusiness.countSoNguoiHuongLoiCapNcBenVung(namBaoCao,maTinh);
			SoNgHgLoiTuCapNcBenVungKHValue = (SoNgHgLoiTuCapNcBenVungKHValueTemp > 0) ? ConvertUtil.parseIntToString1000(SoNgHgLoiTuCapNcBenVungKHValueTemp) : "0";
			
			SoNgHgLoiTuCapNcBenVungKQDDValue = Validator.isNotNull(baoCaoDLITongHop.getSoNguoiHuongLoiNuocSach()) ? ConvertUtil.parseIntToString1000(baoCaoDLITongHop.getSoNguoiHuongLoiNuocSach()) : "0" ;
			if( Validator.isNotNull(baoCaoDLITongHop.getSoNguoiHuongLoiNuocSach())   
					&& SoNgHgLoiTuCapNcBenVungKHValueTemp > 0 ){
				
				SoNgHgLoiTuCapNcBenVungThucHienKHValue = ConvertUtil.parseDoubleToString2Digits((ConvertUtil.convertIntToDouble(baoCaoDLITongHop.getSoNguoiHuongLoiNuocSach()) / ConvertUtil.convertIntToDouble(SoNgHgLoiTuCapNcBenVungKHValueTemp)) * 100);
			
			}
			// 2.1 end
			
			// 2.2 start
			int SoNgHgLoiTuVSTXKHValueTemp = KeHoachVeSinhBusiness.countSoDanHuongLoi(namBaoCao, maTinh, DANGKYVSTX);

			
			SoNgHgLoiTuVSTXKHValue = (SoNgHgLoiTuVSTXKHValueTemp > 0) ? ConvertUtil.parseIntToString1000(SoNgHgLoiTuVSTXKHValueTemp) : "0";
			
			//double SoNgHgLoiTuVSTXKQDDValueDoubleTemp = DANHGIAVESINHXABusiness.getDanhGiaVeSinhXaTyLeAllTW(maTinh, namBaoCao, KETLUANVSTX, 0, 0, 0, 0, 0, 1);
			double SoNgHgLoiTuVSTXKQDDValueDoubleTemp = (double) util.getSoNguoiHuongLoiVSTX(maTinh, Integer.parseInt(namBaoCao));

			
			int SoNgHgLoiTuVSTXKQDDValueIntTemp = ConvertUtil.convertDoubleToint(SoNgHgLoiTuVSTXKQDDValueDoubleTemp);
			SoNgHgLoiTuVSTXKQDDValue = (SoNgHgLoiTuVSTXKQDDValueIntTemp > 0) ? ConvertUtil.parseIntToString1000(SoNgHgLoiTuVSTXKQDDValueIntTemp) : "0";
			
			if( Validator.isNotNull(SoNgHgLoiTuVSTXKHValueTemp)   
					&& SoNgHgLoiTuVSTXKHValueTemp > 0 ){
				
				SoNgHgLoiTuVSTXThucHienKHValue = ConvertUtil.parseDoubleToString2Digits((SoNgHgLoiTuVSTXKQDDValueDoubleTemp / ConvertUtil.convertIntToDouble(SoNgHgLoiTuVSTXKHValueTemp)) * 100);
			
			}
			// 2.2 end
			
			// 3.1 start
			SoKHCuaTinhDcPheDuyetKHValue = Validator.isNotNull(baoCaoDLITongHop.getKeHoachPheDuyet()) ? ReportConstant.CO : "";
			SoKHCuaTinhDcPheDuyetKQDDValue = Validator.isNotNull(baoCaoDLITongHop.getKeHoachPheDuyet()) ? ReportConstant.CO : "";
			SoKHCuaTinhDcPheDuyetThucHienKHValue = "";
			// 3.1 end
			
			// 3.2 start
			SoBCCTDcCongBoKHValue = Validator.isNotNull(baoCaoDLITongHop.getBaoCaoChuongTrinh()) ? ReportConstant.CO : "";
			SoBCCTDcCongBoKQDDValue = Validator.isNotNull(baoCaoDLITongHop.getBaoCaoChuongTrinh()) ? ReportConstant.CO : "";
			SoBCCTDcCongBoThucHienKHValue = "";
			// 3.2 end
		}
		
		
		
		
		result.setNam(namValue);
		result.setTenTinh(tenTinhValue);
		result.setBaoCaoSo(baoCaoSoValue);
		result.setBaoCaoNgayThangNam(baoCaoNgayThangNamValue);
		result.setNguoiLap(nguoiLapValue);
		result.setNguoiDuyet(nguoiDuyetValue);
		result.setDonViBaoCao(donViBaoCaoValue);
		
		result.setSoDauNoiKH(SoDauNoiKHValue);
		result.setSoDauNoiKQDD(SoDauNoiKQDDValue);
		result.setSoDauNoiThucHienKH(SoDauNoiThucHienKHValue);
		
		result.setSoNhaTieuHGDXayMoiKH(SoNhaTieuHGDXayMoiKHValue);
		result.setSoNhaTieuHGDXayMoiKQDD(SoNhaTieuHGDXayMoiKQDDValue);
		result.setSoNhaTieuHGDXayMoiThucHienKH(SoNhaTieuHGDXayMoiThucHienKHValue);
		
		result.setSoNgHgLoiTuCapNcBenVungKH(SoNgHgLoiTuCapNcBenVungKHValue);
		result.setSoNgHgLoiTuCapNcBenVungKQDD(SoNgHgLoiTuCapNcBenVungKQDDValue);
		result.setSoNgHgLoiTuCapNcBenVungThucHienKH(SoNgHgLoiTuCapNcBenVungThucHienKHValue);
		
		result.setSoNgHgLoiTuVSTXKH(SoNgHgLoiTuVSTXKHValue);
		result.setSoNgHgLoiTuVSTXKQDD(SoNgHgLoiTuVSTXKQDDValue);
		result.setSoNgHgLoiTuVSTXThucHienKH(SoNgHgLoiTuVSTXThucHienKHValue);
		
		result.setSoKHCuaTinhDcPheDuyetKH(SoKHCuaTinhDcPheDuyetKHValue);
		result.setSoKHCuaTinhDcPheDuyetKQDD(SoKHCuaTinhDcPheDuyetKQDDValue);
		result.setSoKHCuaTinhDcPheDuyetThucHienKH(SoKHCuaTinhDcPheDuyetThucHienKHValue);
		
		result.setSoBCCTDcCongBoKH(SoBCCTDcCongBoKHValue);
		result.setSoBCCTDcCongBoKQDD(SoBCCTDcCongBoKQDDValue);
		result.setSoBCCTDcCongBoThucHienKH(SoBCCTDcCongBoThucHienKHValue);
		
		
		return result;
	}
	
}
