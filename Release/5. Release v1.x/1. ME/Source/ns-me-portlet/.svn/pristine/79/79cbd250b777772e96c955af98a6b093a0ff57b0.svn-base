package vn.dtt.sol.ns.danhgiavesinh.dao.service.persistence;

import java.util.List;

import vn.dtt.sol.ns.danhgiavesinh.dao.model.DANHGIAVESINHXA;
import vn.dtt.sol.ns.danhgiavesinh.dao.model.impl.DANHGIAVESINHXAImpl;
import vn.dtt.sol.ns.util.format.FormatData;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.VeSinhGiaDinhImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class DANHGIAVESINHXAFinderImpl extends BasePersistenceImpl<DANHGIAVESINHXA> implements DANHGIAVESINHXAFinder {
	private static Log _log = LogFactoryUtil.getLog(DANHGIAVESINHXAFinderImpl.class);
	
	/**
	 * @author tailt
	 * @param maTinh
	 * @param maHuyen
	 * @param maXa
	 * @param namBaoCao
	 * @return
	 * @throws SystemException
	 */
	

	public List<DANHGIAVESINHXA> getDanhGiaVeSinhXaBaoCao(String maTinh,String maHuyen,String maXa,String namBaoCao, String ketLuanVSTX) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT * ");
			query.append(" FROM ME_DANHGIAVESINHXA ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND MATINH = ? ");
			}
			if(Validator.isNotNull(maHuyen)){
				query.append(" AND MAHUYEN = ? ");
			}
			if(Validator.isNotNull(maXa)){
				query.append(" AND MAXA = ? ");
			}
			if(Validator.isNotNull(namBaoCao) ){
				if(namBaoCao.equalsIgnoreCase("0")){
					query.append(" AND ( NAM =  ? OR NAM =  ? ) ");
				}else{
					query.append(" AND NAM = ? ");
				}
				
			}
			if(Validator.isNotNull(ketLuanVSTX)){
				query.append(" AND KETLUANVSTX = ? ");
			}
			query.append(" ORDER BY MATINH , MAHUYEN , MAXA ");
			
			_log.debug("=getDanhGiaVeSinhXaBaoCao=" + query.toString());
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(DANHGIAVESINHXAImpl.TABLE_NAME,DANHGIAVESINHXAImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
			}
			if(Validator.isNotNull(maXa)){
				qPos.add(maXa);
			}
			if(Validator.isNotNull(namBaoCao) ){
				if(namBaoCao.equalsIgnoreCase("0")){
					qPos.add(namBaoCao);
					qPos.add(FormatData.getCurrentYear());
				}else{
					qPos.add(Long.valueOf(namBaoCao));
				}
				
			}
			if(Validator.isNotNull(ketLuanVSTX)){
				qPos.add(ketLuanVSTX);
			}
			return (List<DANHGIAVESINHXA>) QueryUtil.list(q, getDialect(),   QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}
		return null;
	}
	public int sumSoNguoiHuongLoiByMaTinh(String maTinh, String namBaoCao) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT sum(SODAN) as total ");
			query.append(" FROM me_danhgiavesinhxa ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND MATINH = ? ");
			}
			if(Validator.isNotNull(namBaoCao)){
				query.append(" AND NAM = ? ");
			}
			
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);		
			}
			
			if(Validator.isNotNull(namBaoCao)){
				qPos.add(namBaoCao);
			}
			
			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (lstTotal != null) {
				return lstTotal.get(0);
			}
			
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}
		return 0;
	}
	
	public List<DANHGIAVESINHXA> getDanhGiaVeSinhXaGroupByMaTinhTW(String maTinh,String maHuyen,String maXa,String namBaoCao, String ketLuanVSTX) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT * ");
			query.append(" FROM ME_DANHGIAVESINHXA ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND MATINH = ? ");
			}
			if(Validator.isNotNull(maHuyen)){
				query.append(" AND MAHUYEN = ? ");
			}
			if(Validator.isNotNull(maXa)){
				query.append(" AND MAXA = ? ");
			}
			if(Validator.isNotNull(namBaoCao) ){
				query.append(" AND NAM = ? ");
			}
			if(Validator.isNotNull(ketLuanVSTX) ){
				query.append(" AND KETLUANVSTX = ? ");
			}
			query.append(" GROUP BY MATINH ");
			query.append(" ORDER BY MATINH , MAHUYEN , MAXA ");
			
			_log.debug("=getDanhGiaVeSinhXaBaoCao=" + query.toString());
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(DANHGIAVESINHXAImpl.TABLE_NAME,DANHGIAVESINHXAImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
			}
			if(Validator.isNotNull(maXa)){
				qPos.add(maXa);
			}
			if(Validator.isNotNull(namBaoCao) ){
				qPos.add(namBaoCao);
			}
			if(Validator.isNotNull(ketLuanVSTX) ){
				qPos.add(ketLuanVSTX);
			}
			return (List<DANHGIAVESINHXA>) QueryUtil.list(q, getDialect(),   QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	

	
	
	
	public List<DANHGIAVESINHXA> getDanhGiaVeSinhXaGroupByMaHuyenMaXaTW(String maTinh,String maHuyen,String maXa,String namBaoCao,String ketLuanVSTX) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT * ");
			query.append(" FROM ME_DANHGIAVESINHXA ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND MATINH = ? ");
			}
			if(Validator.isNotNull(maHuyen)){
				query.append(" AND MAHUYEN = ? ");
			}
			if(Validator.isNotNull(maXa)){
				query.append(" AND MAXA = ? ");
			}
			if(Validator.isNotNull(namBaoCao) ){
				query.append(" AND NAM = ? ");
			}
			if(Validator.isNotNull(ketLuanVSTX) ){
				query.append(" AND KETLUANVSTX = ? ");
			}
			query.append(" GROUP BY MAHUYEN, MAXA ");
			query.append(" ORDER BY MATINH , MAHUYEN , MAXA ");
			
			_log.debug("=getDanhGiaVeSinhXaBaoCao=" + query.toString());
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(DANHGIAVESINHXAImpl.TABLE_NAME,DANHGIAVESINHXAImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
			}
			if(Validator.isNotNull(maXa)){
				qPos.add(maXa);
			}
			if(Validator.isNotNull(namBaoCao) ){
				qPos.add(namBaoCao);
			}
			if(Validator.isNotNull(ketLuanVSTX) ){
				qPos.add(ketLuanVSTX);
			}
			return (List<DANHGIAVESINHXA>) QueryUtil.list(q, getDialect(),   QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	
	public double getDanhGiaVeSinhXaTyLeAllTW(String maTinh, String namBaoCao,String ketLuanVSTX, int isSumSoXa, int isCoNhaTieuHVS,int isCoNhaTieu,int isCoTyLeTruongHoc, int isCoTyLeTramYTe, int isSumSoNguoiHuongLoi) {
		// 1 la tinh, 0 la ko tinh
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT ");
			
			if(Validator.isNotNull(isSumSoXa) && isSumSoXa == 1){
				query.append(" COUNT(MAXA) ");
			}
			if(Validator.isNotNull(isCoNhaTieuHVS) && isCoNhaTieuHVS == 1){
				query.append(" SUM(TILEHGDCONHATIEUHVS)/COUNT(TILEHGDCONHATIEUHVS) ");
			}
			if(Validator.isNotNull(isCoNhaTieu) && isCoNhaTieu == 1){
				query.append(" SUM(TILEHGDCONHATIEU)/COUNT(TILEHGDCONHATIEU) ");
			}
			if(Validator.isNotNull(isCoTyLeTruongHoc) && isCoTyLeTruongHoc == 1){
				query.append(" SUM(TILETRUONGHOCHVS)/COUNT(TILETRUONGHOCHVS) ");
			}
			if(Validator.isNotNull(isCoTyLeTramYTe) && isCoTyLeTramYTe == 1){
				query.append(" SUM(TILETRAMYTEHVS)/COUNT(TILETRAMYTEHVS) ");
			}
			if(Validator.isNotNull(isSumSoNguoiHuongLoi) && isSumSoNguoiHuongLoi == 1){
				query.append(" SUM(SODAN) ");
			}
		
			
			query.append(" as total ");
			query.append(" FROM me_danhgiavesinhxa ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND MATINH = ? ");
			}
			if(Validator.isNotNull(namBaoCao)){
				query.append(" AND NAM = ? ");
			}
			if(Validator.isNotNull(ketLuanVSTX) ){
				query.append(" AND KETLUANVSTX = ? ");
			}
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.DOUBLE);
			q.setCacheable(false);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);		
			}
			
			if(Validator.isNotNull(namBaoCao)){
				qPos.add(namBaoCao);
			}
			if(Validator.isNotNull(ketLuanVSTX) ){
				qPos.add(ketLuanVSTX);
			}
			List<Double> lstTotal = (List<Double>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(lstTotal) && Validator.isNotNull(lstTotal.get(0)) ) {
				return lstTotal.get(0);
			}
			
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}
		return 0;
	}
	
	public List<DANHGIAVESINHXA> getDanhGiaVeSinhXaGroupByMaHuyenMaXaBaoCaoHopNhat(String maTinh,String maHuyen,String maXa,int namBaoCao, int namToiThieu, String ketLuanVSTX) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT * ");
			query.append(" FROM ME_DANHGIAVESINHXA ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND MATINH = ? ");
			}
			if(Validator.isNotNull(maHuyen)){
				query.append(" AND MAHUYEN = ? ");
			}
			if(Validator.isNotNull(maXa)){
				query.append(" AND MAXA = ? ");
			}
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0 
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0){
				query.append(" AND ( NAM >= ? AND NAM <= ? )");
			}
			if(Validator.isNotNull(ketLuanVSTX) ){
				query.append(" AND KETLUANVSTX = ? ");
			}
			query.append(" GROUP BY MAHUYEN, MAXA ");
			query.append(" ORDER BY MATINH , MAHUYEN , MAXA ");
			
			_log.debug("=getDanhGiaVeSinhXaGroupByMaHuyenMaXaBaoCaoHopNhat=" + query.toString());
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(DANHGIAVESINHXAImpl.TABLE_NAME,DANHGIAVESINHXAImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
			}
			if(Validator.isNotNull(maXa)){
				qPos.add(maXa);
			}
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0 
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0){
				qPos.add(namToiThieu);
				qPos.add(namBaoCao);
			}
			if(Validator.isNotNull(ketLuanVSTX) ){
				qPos.add(ketLuanVSTX);
			}
			return (List<DANHGIAVESINHXA>) QueryUtil.list(q, getDialect(),   QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public double getDanhGiaVeSinhXaTyLeAllBaoCaoHopNhat(String maTinh,String maHuyen,String maXa, int namBaoCao,int namToiThieu,String ketLuanVSTX, int isSumSoXa, int isCoNhaTieuHVS,int isCoNhaTieu,int isCoTyLeTruongHoc, int isCoTyLeTramYTe, int isSumSoNguoiHuongLoi) {
		// 1 la tinh, 0 la ko tinh
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT ");
			
			if(Validator.isNotNull(isSumSoXa) && isSumSoXa == 1){
				query.append(" COUNT(MAXA) ");
			}
			if(Validator.isNotNull(isCoNhaTieuHVS) && isCoNhaTieuHVS == 1){
				query.append(" SUM(TILEHGDCONHATIEUHVS)/COUNT(TILEHGDCONHATIEUHVS) ");
			}
			if(Validator.isNotNull(isCoNhaTieu) && isCoNhaTieu == 1){
				query.append(" SUM(TILEHGDCONHATIEU)/COUNT(TILEHGDCONHATIEU) ");
			}
			if(Validator.isNotNull(isCoTyLeTruongHoc) && isCoTyLeTruongHoc == 1){
				query.append(" SUM(TILETRUONGHOCHVS)/COUNT(TILETRUONGHOCHVS) ");
			}
			if(Validator.isNotNull(isCoTyLeTramYTe) && isCoTyLeTramYTe == 1){
				query.append(" SUM(TILETRAMYTEHVS)/COUNT(TILETRAMYTEHVS) ");
			}
			if(Validator.isNotNull(isSumSoNguoiHuongLoi) && isSumSoNguoiHuongLoi == 1){
				query.append(" SUM(SODAN) ");
			}
		
			
			query.append(" as total ");
			query.append(" FROM me_danhgiavesinhxa ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND MATINH = ? ");
			}
			if(Validator.isNotNull(maHuyen)){
				query.append(" AND MAHUYEN = ? ");
			}
			if(Validator.isNotNull(maXa)){
				query.append(" AND MAXA = ? ");
			}
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0 
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0){
				query.append(" AND ( NAM >= ? AND NAM <= ? ) ");
			}
			if(Validator.isNotNull(ketLuanVSTX) ){
				query.append(" AND KETLUANVSTX = ? ");
			}
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.DOUBLE);
			q.setCacheable(false);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);		
			}
			if(Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);		
			}
			if(Validator.isNotNull(maXa)){
				qPos.add(maXa);		
			}
			
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0 
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0){
				qPos.add(namToiThieu);
				qPos.add(namBaoCao);
			}
			if(Validator.isNotNull(ketLuanVSTX) ){
				qPos.add(ketLuanVSTX);
			}
			List<Double> lstTotal = (List<Double>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(lstTotal) && Validator.isNotNull(lstTotal.get(0)) ) {
				return lstTotal.get(0);
			}
			
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}
		return 0;
	}
	
}
