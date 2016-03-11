package vn.dtt.sol.ns.baocaodli.business;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHop;
import vn.dtt.sol.ns.baocaodli.dao.service.BaoCaoDLITongHopLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class BaoCaoDLITongHopBusiness {
	
	
	private static final Log _log = LogFactoryUtil.getLog(BaoCaoDLITongHopBusiness.class);
	public static BaoCaoDLITongHop getBaoCaoDLITongHopByTinhVaNam(String maTinh, String namBaoCao){
		BaoCaoDLITongHop baoCaoDLITongHop = null;
		
		try {

			baoCaoDLITongHop = BaoCaoDLITongHopLocalServiceUtil.getBaoCaoDLITongHopByTinhVaNam(maTinh,namBaoCao);

		} catch (Exception e) {
			_log.error(e);
		}
		
		return baoCaoDLITongHop;
	}
	
	public static List<BaoCaoDLITongHop> getListBaoCaoDLITongHopByNamTW(String namBaoCao){
		List<BaoCaoDLITongHop> lst = new ArrayList<BaoCaoDLITongHop>();
		
		try {

			lst = BaoCaoDLITongHopLocalServiceUtil.getListBaoCaoDLITongHopByNamTW(namBaoCao);

		} catch (Exception e) {
			_log.error(e);
		}
		
		return lst;
	}
	public static int sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(String maTinh, int namBaoCao, int namToiThieu,int is11TheoKeHoach,int is11ThucTe,int is12TheoKeHoach,int is12ThucTe,int is21TheoKeHoach ,int is22TheoKeHoach,int is31TheoKeHoach,int is31ThucTe,int is32TheoKeHoach,int is32ThucTe){
		int count = 0;
		try{
			count = BaoCaoDLITongHopLocalServiceUtil.sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat( maTinh,  namBaoCao,  namToiThieu, is11TheoKeHoach, is11ThucTe, is12TheoKeHoach, is12ThucTe, is21TheoKeHoach , is22TheoKeHoach, is31TheoKeHoach, is31ThucTe, is32TheoKeHoach, is32ThucTe);
		}catch (Exception e) {
			_log.error(e);
		}
		return count;
	}
	
}
