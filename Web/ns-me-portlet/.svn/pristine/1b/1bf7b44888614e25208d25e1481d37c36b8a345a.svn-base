package vn.dtt.sol.ns.business;

import vn.dtt.sol.ns.maungaunhien.dao.model.MAUKIEMDEM;
import vn.dtt.sol.ns.maungaunhien.dao.service.MAUKIEMDEMLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class MAUKIEMDEMBusiness {
	private static final Log _log = LogFactoryUtil.getLog(MAUKIEMDEMBusiness.class);
	public static MAUKIEMDEM getMauVSTXBaoCaoThongKeVSTX(String nam, String maTinh, String maHuyen,String maXa){
		MAUKIEMDEM maukiemdem = null; 
		
		try{
			maukiemdem = MAUKIEMDEMLocalServiceUtil.getMauVSTXBaoCaoThongKeVSTX( nam,  maTinh,  maHuyen, maXa);
		}catch (Exception e) {
			_log.error(e);
		}
		return maukiemdem;
	}
}
