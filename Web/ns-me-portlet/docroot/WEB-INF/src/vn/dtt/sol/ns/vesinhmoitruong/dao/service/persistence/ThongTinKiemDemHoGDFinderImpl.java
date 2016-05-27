package vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence;




import java.util.List;

import vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemHoGD;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.ThongTinKiemDemHoGDImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class ThongTinKiemDemHoGDFinderImpl extends BasePersistenceImpl<ThongTinKiemDemHoGD> implements ThongTinKiemDemHoGDFinder{
	
	public List<ThongTinKiemDemHoGD> getThongTinKiemDemHGDThoiGianThucGroupBy(String maTinh, String namBaoCao, String[] danhgiakiemdem, String daketthucdieutra) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT * FROM ME_THONGTINKIEMDEMHOGD ");
			query.append(" join me_kehoachkiemdemvesinh on me_thongtinkiemdemhogd.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id  ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.MATINH = ? ");
			}
			if(Validator.isNotNull(namBaoCao)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.NAMXAYDUNG = ? and me_kehoachkiemdemvesinh.nam = ?  ");
			}
			if(ArrayUtil.isNotEmpty(danhgiakiemdem) && danhgiakiemdem.length > 0){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.DANHGIAKIEMDEM IN (  ");
				
				String temp="";
				for(int i=0;i<danhgiakiemdem.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				query.append(temp);
				query.append("  ) ");
			}
			if(Validator.isNotNull(daketthucdieutra)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.DAKETTHUCDIEUTRA = ? ");
			}
			query.append(" GROUP BY ME_THONGTINKIEMDEMHOGD.MAHUYEN, ME_THONGTINKIEMDEMHOGD.MAXA ");//them maxa
			query.append(" ORDER BY ME_THONGTINKIEMDEMHOGD.MATINH, ME_THONGTINKIEMDEMHOGD.MAHUYEN, ME_THONGTINKIEMDEMHOGD.MAXA, ME_THONGTINKIEMDEMHOGD.ID  ");
			
			_log.debug("=getThongTinKiemDemHGDThoiGianThucGroupBy==" + query.toString());
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(ThongTinKiemDemHoGDImpl.TABLE_NAME,ThongTinKiemDemHoGDImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(namBaoCao)){
				qPos.add(namBaoCao);
				qPos.add(namBaoCao);
			}
			if(ArrayUtil.isNotEmpty(danhgiakiemdem) && danhgiakiemdem.length > 0){
				for(int i=0;i<danhgiakiemdem.length;i++){
					qPos.add(danhgiakiemdem[i].toString());
				}
			}
			if(Validator.isNotNull(daketthucdieutra)){
				qPos.add(daketthucdieutra);
			}
			return (List<ThongTinKiemDemHoGD>) QueryUtil.list(q, getDialect(),   QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countThongTinKiemDemHGDThoiGianThucGroupBy(String maTinh, String namBaoCao, String[] danhgiakiemdem, String maHuyen, String maXa, String daketthucdieutra ) throws SystemException {
		Session session = null;
		try {
			
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT count(*) as total ");
			query.append(" FROM ME_THONGTINKIEMDEMHOGD ");
			query.append(" join me_kehoachkiemdemvesinh on me_thongtinkiemdemhogd.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id  ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.MATINH = ? ");
			}
			if(Validator.isNotNull(namBaoCao)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.NAMXAYDUNG = ? and me_kehoachkiemdemvesinh.nam = ?  ");
			}
			if(ArrayUtil.isNotEmpty(danhgiakiemdem) && danhgiakiemdem.length > 0){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.DANHGIAKIEMDEM IN (  ");
				
				String temp="";
				for(int i=0;i<danhgiakiemdem.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				query.append(temp);
				query.append("  ) ");
			}
			if(Validator.isNotNull(maHuyen)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.MAHUYEN = ? ");
			}
			if(Validator.isNotNull(maXa)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.MAXA = ? ");
			}
			if(Validator.isNotNull(daketthucdieutra)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.DAKETTHUCDIEUTRA = ? ");
			}
			_log.info("====countThongTinKiemDemHGDThoiGianThucGroupBy==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			
			
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(namBaoCao)){
				qPos.add(namBaoCao);
				qPos.add(namBaoCao);
			}
			if(ArrayUtil.isNotEmpty(danhgiakiemdem) && danhgiakiemdem.length > 0){
				for(int i=0;i<danhgiakiemdem.length;i++){
					qPos.add(danhgiakiemdem[i].toString());
				}
			}
			if(Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
			}
			if(Validator.isNotNull(maXa)){
				qPos.add(maXa);
			}
			if(Validator.isNotNull(daketthucdieutra)){
				qPos.add(daketthucdieutra);
			}
			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(lstTotal) && Validator.isNotNull(lstTotal.get(0))) {
				return lstTotal.get(0);
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<ThongTinKiemDemHoGD> getThongTinKiemDemHGDThoiGianThuc(String maTinh, String namBaoCao, String[] danhgiakiemdem, String daketthucdieutra) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT * FROM ME_THONGTINKIEMDEMHOGD ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND MATINH = ? ");
			}
			if(Validator.isNotNull(namBaoCao)){
				query.append(" AND NAMXAYDUNG = ? ");
			}
			if(ArrayUtil.isNotEmpty(danhgiakiemdem) && danhgiakiemdem.length > 0){
				query.append(" AND DANHGIAKIEMDEM IN (  ");
				
				String temp="";
				for(int i=0;i<danhgiakiemdem.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				query.append(temp);
				query.append("  ) ");
			}
			if(Validator.isNotNull(daketthucdieutra)){
				query.append(" AND DAKETTHUCDIEUTRA = ? ");
			}
			query.append(" ORDER BY MATINH,MAHUYEN, MAXA, ID  ");
			
			_log.debug("=getThongTinKiemDemHGDThoiGianThuc==" + query.toString());
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(ThongTinKiemDemHoGDImpl.TABLE_NAME,ThongTinKiemDemHoGDImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(namBaoCao)){
				qPos.add(namBaoCao);
			}
			if(ArrayUtil.isNotEmpty(danhgiakiemdem) && danhgiakiemdem.length > 0){
				for(int i=0;i<danhgiakiemdem.length;i++){
					qPos.add(danhgiakiemdem[i].toString());
				}
			}
			if(Validator.isNotNull(daketthucdieutra)){
				qPos.add(daketthucdieutra);
			}
			return (List<ThongTinKiemDemHoGD>) QueryUtil.list(q, getDialect(),   QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<ThongTinKiemDemHoGD> getListThongTinKiemDemHoGiaDinhByKeHoachId(int keHoachId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT * FROM ME_THONGTINKIEMDEMHOGD ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(keHoachId)){
				query.append(" AND KEHOACHKIEMDEMVESINHID = ? ");
			}
	
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(ThongTinKiemDemHoGDImpl.TABLE_NAME,ThongTinKiemDemHoGDImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(keHoachId)){
				qPos.add(keHoachId);
			}
			return (List<ThongTinKiemDemHoGD>) QueryUtil.list(q, getDialect(),   QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	public int countGioiTinhChuHo(String maTinh, String namBaoCao, String gioiTinhChuHo, String[] danhGiaKiemDem, String daKetThucDieuTra) throws SystemException {
		Session session = null;
		try {
			
			
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT count(DISTINCT ME_THONGTINKIEMDEMHOGD.id) as total FROM ME_THONGTINKIEMDEMHOGD  ");
			query.append(" LEFT JOIN me_vesinhgiadinh ON me_thongtinkiemdemhogd.vesinhgiadinhid = me_vesinhgiadinh.ID  ");
			query.append(" join me_kehoachkiemdemvesinh on me_thongtinkiemdemhogd.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.MATINH = ? ");
			}
			
			if(Validator.isNotNull(namBaoCao)){
				query.append(" AND me_kehoachkiemdemvesinh.nam = ? ");
				query.append(" AND ME_THONGTINKIEMDEMHOGD.NAMXAYDUNG = ? ");
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.GIOITINHCHUHO = ? ");
			}
			if(ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.DANHGIAKIEMDEM IN (  ");
				
				String temp="";
				for(int i=0;i<danhGiaKiemDem.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				query.append(temp);
				query.append("  ) ");
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.DAKETTHUCDIEUTRA = ? ");
			}
			
			_log.info("====countGioiTinhChuHo==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			
			
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(namBaoCao)){
				qPos.add(namBaoCao);
				qPos.add(namBaoCao);
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				qPos.add(gioiTinhChuHo);
			}
			if(ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0){
				for(int i=0;i<danhGiaKiemDem.length;i++){
					qPos.add(danhGiaKiemDem[i].toString());
				}
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				qPos.add(daKetThucDieuTra);
			}
			
			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(lstTotal) && Validator.isNotNull(lstTotal.get(0))) {
				return lstTotal.get(0);
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countGioiTinhChuHoByMauNNVSTXJoinVSGD(String maTinh, String mauNgauNhien, String gioiTinhChuHo) throws SystemException {
		Session session = null;
		try {
			
			int mauNgauNhienInt = 0;
			int mauNgauNhienIntx10 = 0;
			if(Validator.isNotNull(mauNgauNhien)){
				mauNgauNhienInt = Integer.parseInt(mauNgauNhien);
				mauNgauNhienIntx10 = Integer.parseInt(mauNgauNhien+"0");
			}
			
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT count(DISTINCT ME_THONGTINKIEMDEMHOGD.id) as total FROM ME_THONGTINKIEMDEMHOGD  ");
			query.append(" LEFT JOIN me_vesinhgiadinh ON me_thongtinkiemdemhogd.vesinhgiadinhid = me_vesinhgiadinh.ID  ");
			query.append(" join me_kehoachkiemdemvesinh on me_thongtinkiemdemhogd.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id ");
			query.append(" WHERE 1 = 1 ");
			
//			query.append(" SELECT count(*) as total ");
//			query.append(" FROM ME_THONGTINKIEMDEMHOGD AS t ");
//			query.append(" INNER JOIN ME_VESINHGIADINH AS v ");
//			query.append(" ON t.VESINHGIADINHID = v.ID ");
//			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.MATINH = ? ");
			}
			
			if(Validator.isNotNull(mauNgauNhien)){
				query.append(" AND ( me_vesinhgiadinh.MAUNGAUNHIEN = ? OR me_vesinhgiadinh.MAUNGAUNHIEN = ? ) ");
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.GIOITINHCHUHO = ? ");
			}
			
			
			_log.info("====countGioiTinhChuHoByMauNNVSTXJoinVSGD==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			
			
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(mauNgauNhien)){
				qPos.add(mauNgauNhienInt);
				qPos.add(mauNgauNhienIntx10);
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				qPos.add(gioiTinhChuHo);
			}
			
			
			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(lstTotal) && Validator.isNotNull(lstTotal.get(0))) {
				return lstTotal.get(0);
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	
	public int countGioiTinhChuHoBaoCaoHopNhat(String maTinh, int namBaoCao,int namToiThieu, String gioiTinhChuHo, String[] danhGiaKiemDem, String daKetThucDieuTra) throws SystemException {
		Session session = null;
		try {
			
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT count(DISTINCT ME_THONGTINKIEMDEMHOGD.id) as total FROM ME_THONGTINKIEMDEMHOGD  ");
			query.append(" LEFT JOIN me_vesinhgiadinh ON me_thongtinkiemdemhogd.vesinhgiadinhid = me_vesinhgiadinh.ID  ");
			query.append(" join me_kehoachkiemdemvesinh on me_thongtinkiemdemhogd.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id ");
			query.append(" WHERE 1 = 1 ");
			
//			query.append(" SELECT count(*) as total ");
//			query.append(" FROM ME_THONGTINKIEMDEMHOGD ");
//			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.MATINH = ? ");
			}
			
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0){
				query.append(" AND ( me_kehoachkiemdemvesinh.nam >= ? AND me_kehoachkiemdemvesinh.nam <= ? ) ");
				query.append(" AND ( ME_THONGTINKIEMDEMHOGD.NAMXAYDUNG >= ? AND ME_THONGTINKIEMDEMHOGD.NAMXAYDUNG <= ? )");
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.GIOITINHCHUHO = ? ");
			}
			if(ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.DANHGIAKIEMDEM IN (  ");
				
				String temp="";
				for(int i=0;i<danhGiaKiemDem.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				query.append(temp);
				query.append("  ) ");
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.DAKETTHUCDIEUTRA = ? ");
			}
			
			_log.info("====countGioiTinhChuHoBaoCaoHopNhat==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			
			
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0){
				qPos.add(namToiThieu);
				qPos.add(namBaoCao);
				qPos.add(namToiThieu);
				qPos.add(namBaoCao);
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				qPos.add(gioiTinhChuHo);
			}
			if(ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0){
				for(int i=0;i<danhGiaKiemDem.length;i++){
					qPos.add(danhGiaKiemDem[i].toString());
				}
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				qPos.add(daKetThucDieuTra);
			}
			
			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(lstTotal) && Validator.isNotNull(lstTotal.get(0))) {
				return lstTotal.get(0);
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countGioiTinhChuHoByMauNNVSTXJoinVSGDBaoCaoHopNhat(String maTinh, int namMauNgauNhien,int namToiThieu, String gioiTinhChuHo, String[] danhGiaKiemDem, String daKetThucDieuTra) throws SystemException {
		Session session = null;
		try {
			int mauNgauNhienx10 = 0;
			if(Validator.isNotNull(namMauNgauNhien) && namMauNgauNhien > 0){
				mauNgauNhienx10 = Integer.parseInt(namMauNgauNhien+"0");
			}
			int namToiThieux10 = 0;
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0){
				namToiThieux10 = Integer.parseInt(namToiThieu+"0");
			}
			
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT count(DISTINCT ME_THONGTINKIEMDEMHOGD.id) as total FROM ME_THONGTINKIEMDEMHOGD  ");
			query.append(" LEFT JOIN me_vesinhgiadinh ON me_thongtinkiemdemhogd.vesinhgiadinhid = me_vesinhgiadinh.ID  ");
			query.append(" join me_kehoachkiemdemvesinh on me_thongtinkiemdemhogd.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id ");
			query.append(" WHERE 1 = 1 ");
			
//			query.append(" SELECT count(*) as total ");
//			query.append(" FROM ME_THONGTINKIEMDEMHOGD AS t ");
//			query.append(" INNER JOIN ME_VESINHGIADINH AS v ");
//			query.append(" ON t.VESINHGIADINHID = v.ID ");
//			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.MATINH = ? ");
			}
			
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namMauNgauNhien) && namMauNgauNhien > 0){
				query.append(" AND ( ( me_vesinhgiadinh.MAUNGAUNHIEN >= ? AND me_vesinhgiadinh.MAUNGAUNHIEN <= ? ) OR ( me_vesinhgiadinh.MAUNGAUNHIEN >= ? AND me_vesinhgiadinh.MAUNGAUNHIEN <= ? ) ) ");
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.GIOITINHCHUHO = ? ");
			}
			if(ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.DANHGIAKIEMDEM IN (  ");
				
				String temp="";
				for(int i=0;i<danhGiaKiemDem.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				query.append(temp);
				query.append("  ) ");
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				query.append(" AND ME_THONGTINKIEMDEMHOGD.DAKETTHUCDIEUTRA = ? ");
			}
			
			_log.info("====countGioiTinhChuHoByMauNNVSTXJoinVSGDBaoCaoHopNhat==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			
			
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namMauNgauNhien) && namMauNgauNhien > 0){
				qPos.add(namToiThieu);
				qPos.add(namMauNgauNhien);
				qPos.add(namToiThieux10);
				qPos.add(mauNgauNhienx10);
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				qPos.add(gioiTinhChuHo);
			}
			if(ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0){
				for(int i=0;i<danhGiaKiemDem.length;i++){
					qPos.add(danhGiaKiemDem[i].toString());
				}
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				qPos.add(daKetThucDieuTra);
			}
			
			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(lstTotal) && Validator.isNotNull(lstTotal.get(0))) {
				return lstTotal.get(0);
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	public List<ThongTinKiemDemHoGD> getThongTinKiemDemHGDTVGGroupByMatinh(String maTinh, String namBaoCao, String gioiTinhChuHo, String[] danhGiaKiemDem, String daKetThucDieuTra) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT * FROM ME_THONGTINKIEMDEMHOGD ");
			query.append(" WHERE 1 = 1 ");
			if(Validator.isNotNull(maTinh)){
				query.append(" AND MATINH = ? ");
			}
			
			if(Validator.isNotNull(namBaoCao)){
				query.append(" AND NAMXAYDUNG = ? ");
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				query.append(" AND GIOITINHCHUHO = ? ");
			}
			if(ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0){
				query.append(" AND DANHGIAKIEMDEM IN (  ");
				
				String temp="";
				for(int i=0;i<danhGiaKiemDem.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				query.append(temp);
				query.append("  ) ");
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				query.append(" AND DAKETTHUCDIEUTRA = ? ");
			}
			
			query.append(" GROUP BY MATINH ");
			query.append(" ORDER BY MATINH,MAHUYEN ASC ");
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(ThongTinKiemDemHoGDImpl.TABLE_NAME,ThongTinKiemDemHoGDImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			

			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(namBaoCao)){
				qPos.add(namBaoCao);
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				qPos.add(gioiTinhChuHo);
			}
			if(ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0){
				for(int i=0;i<danhGiaKiemDem.length;i++){
					qPos.add(danhGiaKiemDem[i].toString());
				}
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				qPos.add(daKetThucDieuTra);
			}
			return (List<ThongTinKiemDemHoGD>) QueryUtil.list(q, getDialect(),   QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	public List<ThongTinKiemDemHoGD> getThongTinKiemDemHGDTVGGroupByMatinhBaoCaoHopNhatTU(String maTinh,  int namBaoCao,int namToiThieu, String gioiTinhChuHo, String[] danhGiaKiemDem, String daKetThucDieuTra) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT * FROM ME_THONGTINKIEMDEMHOGD ");
			query.append(" WHERE 1 = 1 ");
			if(Validator.isNotNull(maTinh)){
				query.append(" AND MATINH = ? ");
			}
			
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0){
				query.append(" AND ( NAMXAYDUNG >= ? AND NAMXAYDUNG <= ? )");
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				query.append(" AND GIOITINHCHUHO = ? ");
			}
			if(ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0){
				query.append(" AND DANHGIAKIEMDEM IN (  ");
				
				String temp="";
				for(int i=0;i<danhGiaKiemDem.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				query.append(temp);
				query.append("  ) ");
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				query.append(" AND DAKETTHUCDIEUTRA = ? ");
			}
			
			query.append(" GROUP BY MATINH ");
			query.append(" ORDER BY MATINH,MAHUYEN ASC ");
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(ThongTinKiemDemHoGDImpl.TABLE_NAME,ThongTinKiemDemHoGDImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			

			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0){
				qPos.add(namToiThieu);
				qPos.add(namBaoCao);
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				qPos.add(gioiTinhChuHo);
			}
			if(ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0){
				for(int i=0;i<danhGiaKiemDem.length;i++){
					qPos.add(danhGiaKiemDem[i].toString());
				}
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				qPos.add(daKetThucDieuTra);
			}
			return (List<ThongTinKiemDemHoGD>) QueryUtil.list(q, getDialect(),   QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<ThongTinKiemDemHoGD> getThongTinKiemDemHGDVSTXTVGGroupByMatinh(String maTinh, String namMauNgauNhien, String gioiTinhChuHo, String[] danhGiaKiemDem, String daKetThucDieuTra) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT t.*  ");
			query.append(" FROM ME_THONGTINKIEMDEMHOGD AS t ");
			query.append(" INNER JOIN ME_VESINHGIADINH AS v ");
			query.append(" ON t.VESINHGIADINHID = v.ID ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND t.MATINH = ? ");
			}
			
			if(Validator.isNotNull(namMauNgauNhien)){
				query.append(" AND v.MAUNGAUNHIEN = ? ");
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				query.append(" AND t.GIOITINHCHUHO = ? ");
			}
			if(ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0){
				query.append(" AND t.DANHGIAKIEMDEM IN (  ");
				
				String temp="";
				for(int i=0;i<danhGiaKiemDem.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				query.append(temp);
				query.append("  ) ");
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				query.append(" AND t.DAKETTHUCDIEUTRA = ? ");
			}
			
			query.append(" GROUP BY t.MATINH ");
			query.append(" ORDER BY t.MATINH,t.MAHUYEN ASC ");
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(ThongTinKiemDemHoGDImpl.TABLE_NAME,ThongTinKiemDemHoGDImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			

			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(namMauNgauNhien)){
				qPos.add(namMauNgauNhien);
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				qPos.add(gioiTinhChuHo);
			}
			if(ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0){
				for(int i=0;i<danhGiaKiemDem.length;i++){
					qPos.add(danhGiaKiemDem[i].toString());
				}
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				qPos.add(daKetThucDieuTra);
			}
			return (List<ThongTinKiemDemHoGD>) QueryUtil.list(q, getDialect(),   QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	
	public ThongTinKiemDemHoGD getThongTinKiemDemHGDVSTXByVeSinhGiaDinhID(String maTinh,String maHuyen,String maXa, String veSinhGiaDinhID, String[] danhGiaKiemDem, String daKetThucDieuTra) throws SystemException {
		Session session = null;
		List<ThongTinKiemDemHoGD> result = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT t.*  ");
			query.append(" FROM ME_THONGTINKIEMDEMHOGD AS t ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND t.MATINH = ? ");
			}
			
			if(Validator.isNotNull(maHuyen)){
				query.append(" AND t.MAHUYEN = ? ");
			}
			if(Validator.isNotNull(maXa)){
				query.append(" AND t.maXa = ? ");
			}
			if(Validator.isNotNull(veSinhGiaDinhID)){
				query.append(" AND t.veSinhGiaDinhID = ? ");
			}
			if(ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0){
				query.append(" AND t.DANHGIAKIEMDEM IN (  ");
				
				String temp="";
				for(int i=0;i<danhGiaKiemDem.length;i++){
				  temp+=",?";
				}
				temp=temp.replaceFirst(",","");				
				query.append(temp);
				query.append("  ) ");
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				query.append(" AND t.DAKETTHUCDIEUTRA = ? ");
			}
			
			
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(ThongTinKiemDemHoGDImpl.TABLE_NAME,ThongTinKiemDemHoGDImpl.class);
			
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
			if(Validator.isNotNull(veSinhGiaDinhID)){
				qPos.add(veSinhGiaDinhID);
			}
			if(ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0){
				for(int i=0;i<danhGiaKiemDem.length;i++){
					qPos.add(danhGiaKiemDem[i].toString());
				}
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				qPos.add(daKetThucDieuTra);
			}
			result = (List<ThongTinKiemDemHoGD>) QueryUtil.list(q, getDialect(),   QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
			if (result != null && result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return null;
	}
	public int countHoGDThongKeVSTX(String nam, String maTinh, String maHuyen,String maXa, String mauNgauNhien,int isHoGiaDinhTrongKH,int isHVS,int isKoHVS,int isKoNhaTieu,int isChuaKiemDem,int isDangKiemDem ) throws SystemException {
		// 1 la  su dung, 0 hoac khac la ko su dung
		Session session = null;
		try {
			
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			String mauNgauNhienx10 = mauNgauNhien;
			if(Validator.isNotNull(mauNgauNhien)){
				mauNgauNhienx10 += "0"; // x10 mau nghien nhien de lay mau du phong 
			}
			
			if(Validator.isNotNull(isHoGiaDinhTrongKH) && isHoGiaDinhTrongKH == 1){
				query.append(" SELECT count(t.id) as total ");
				query.append(" FROM ME_THONGTINKIEMDEMHOGD AS t ");
				query.append(" JOIN ME_VESINHGIADINH AS v ");
				query.append(" ON t.VESINHGIADINHID = v.ID ");
			}
			else{
				query.append(" SELECT count(t.id) as total ");
				query.append(" FROM ME_THONGTINKIEMDEMHOGD AS t ");
				query.append(" WHERE 1 = 1 ");
				if(Validator.isNotNull(isHVS) && isHVS == 1){
					query.append(" AND DAKETTHUCDIEUTRA = 1 AND (DANHGIAKIEMDEM = 1 OR DANHGIAKIEMDEM = 2) "); // lay cac ho hvs (hvs xay moi va hvs bt)
				}
				if(Validator.isNotNull(isKoHVS) && isKoHVS == 1){
					query.append(" AND DAKETTHUCDIEUTRA = 1 AND (DANHGIAKIEMDEM = 3 )  "); // lay cac ho ko hvs
				}
				if(Validator.isNotNull(isKoNhaTieu) && isKoNhaTieu == 1){
					query.append(" AND DAKETTHUCDIEUTRA = 1 AND (DANHGIAKIEMDEM = 4 )  "); // lay cac ho ko co nha tieu
				}
				if(Validator.isNotNull(isChuaKiemDem) && isChuaKiemDem == 1){
					query.append(" AND (DAKETTHUCDIEUTRA = 0 OR DAKETTHUCDIEUTRA is null)  "); // lay cac ho chua kiem dem, cho khao sat
				}
				if(Validator.isNotNull(isDangKiemDem) && isDangKiemDem == 1){
					query.append(" AND DAKETTHUCDIEUTRA = 2  "); // lay cac ho dang kiem dem, chua hoan thanh
				}
				query.append(" AND t.VESINHGIADINHID IN  ( ");
				
				query.append(" SELECT v.ID ");
				query.append(" FROM ME_THONGTINKIEMDEMHOGD AS t ");
				query.append(" JOIN ME_VESINHGIADINH AS v ");
				query.append(" ON t.VESINHGIADINHID = v.ID ");
			}
			
			
			query.append(" WHERE 1 = 1 ");
			query.append(" AND  t.DAKETTHUCDIEUTRA <> 3 ");
			if(Validator.isNotNull(nam)){
				query.append(" AND v.NAMBAOCAO = ? ");
			}
			if(Validator.isNotNull(maTinh)){
				query.append(" AND v.MATINH = ? ");
			}
			if(Validator.isNotNull(maHuyen)){
				query.append(" AND v.MAHUYEN = ? ");
			}
			if(Validator.isNotNull(maXa)){
				query.append(" AND v.MAXA = ? ");
			}
			if(Validator.isNotNull(mauNgauNhien)){
				query.append(" AND ( v.MAUNGAUNHIEN = ? OR v.MAUNGAUNHIEN = ? ) ");
			}
			if(isHVS == 1 
					|| isKoHVS == 1
					|| isKoNhaTieu == 1
					|| isChuaKiemDem == 1
					|| isDangKiemDem == 1){
				query.append(" ) ");
			}
			
			_log.info("====countHoGDThongKeVSTX==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			
			
			
			if(Validator.isNotNull(nam)){
				qPos.add(nam);
			}
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
			}
			if(Validator.isNotNull(maXa)){
				qPos.add(maXa);
			}
			if(Validator.isNotNull(mauNgauNhien)){
				qPos.add(mauNgauNhien);
				qPos.add(mauNgauNhienx10);
			}
			
			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(lstTotal) && Validator.isNotNull(lstTotal.get(0))) {
				return lstTotal.get(0);
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<ThongTinKiemDemHoGD> getListGroupByBaoCaoThongKeVSXM(String nam,String maTinh,String maHuyen,String maXa) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT t.* FROM ME_THONGTINKIEMDEMHOGD as t ");
			query.append(" join me_kehoachkiemdemvesinh as k on t.kehoachkiemdemvesinhid = k.id  ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(nam)){
				query.append(" AND k.NAM = ? ");
			}
			if(Validator.isNotNull(maTinh)){
				query.append(" AND t.MATINH = ? ");
			}
			if(Validator.isNotNull(maHuyen)){
				query.append(" AND t.MAHUYEN = ? ");
			}
			if(Validator.isNotNull(maXa)){
				query.append(" AND t.MAXA = ? ");
			}
			
			query.append(" GROUP BY t.MATINH,t.MAHUYEN, t.MAXA ");//them maxa
			query.append(" ORDER BY t.MATINH, t.MAHUYEN, t.MAXA,t.thonxom, t.ID ASC ");
			
			_log.info("=getListGroupByBaoCaoThongKeVSXM==" + query.toString());
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(ThongTinKiemDemHoGDImpl.TABLE_NAME,ThongTinKiemDemHoGDImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(nam)){
				qPos.add(nam);
			}
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
			}
			if(Validator.isNotNull(maXa)){
				qPos.add(maXa);
			}
			return (List<ThongTinKiemDemHoGD>) QueryUtil.list(q, getDialect(),   QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countHoGDBaoCaoThongKeVSXM(String nam,String maTinh,String maHuyen,String maXa,int isHoTrongKH,int isHVSXM,int isHVS,int isKoHVS,int isKoNhaTieu,int isChuaKiemDem,int isDangKiemDem) throws SystemException {
		Session session = null;
		try {
			
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT count(t.id) as total FROM ME_THONGTINKIEMDEMHOGD AS t ");
			query.append(" JOIN me_kehoachkiemdemvesinh AS k  ");
			query.append(" ON t.kehoachkiemdemvesinhid = k.id ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(nam)){
				query.append(" AND k.NAM = ? ");
			}
			if(Validator.isNotNull(maTinh)){
				query.append(" AND t.MATINH = ? ");
			}
			if(Validator.isNotNull(maHuyen)){
				query.append(" AND t.maHuyen = ? ");
			}
			if(Validator.isNotNull(maXa)){
				query.append(" AND t.maXa = ? ");
			}
			
			if(Validator.isNotNull(isHoTrongKH) && isHoTrongKH == 1){ // cac ho ko phai da huy
				query.append(" AND t.DAKETTHUCDIEUTRA <> 3 ");
			}
			if(Validator.isNotNull(isHVSXM) && isHVSXM == 1){/// cac ho da hoan thanh va danh gia 1 la hvs xm
				query.append(" AND t.DAKETTHUCDIEUTRA = 1 AND t.DANHGIAKIEMDEM = 1 ");
			}
			if(Validator.isNotNull(isHVS) && isHVS == 1){/// cac ho da hoan thanh va danh gia 2 la hvs
				query.append(" AND t.DAKETTHUCDIEUTRA = 1 AND t.DANHGIAKIEMDEM = 2 ");
			}
			if(Validator.isNotNull(isKoHVS) && isKoHVS == 1){/// cac ho da hoan thanh va danh gia 3 ko hvs
				query.append(" AND t.DAKETTHUCDIEUTRA = 1 AND t.DANHGIAKIEMDEM = 3 ");
			}
			if(Validator.isNotNull(isKoNhaTieu) && isKoNhaTieu == 1){/// cac ho da hoan thanh va danh gia 4 ko co nha tieu
				query.append(" AND t.DAKETTHUCDIEUTRA = 1 AND t.DANHGIAKIEMDEM = 4 ");
			}
			if(Validator.isNotNull(isChuaKiemDem) && isChuaKiemDem == 1){/// cac ho cho khao sat
				query.append(" AND ( t.DAKETTHUCDIEUTRA = 0 OR t.DAKETTHUCDIEUTRA is null ) ");
			}
			if(Validator.isNotNull(isDangKiemDem) && isDangKiemDem == 1){/// cac ho chua hoan thanh
				query.append(" AND t.DAKETTHUCDIEUTRA = 2 ");
			}
			
			_log.info("====countHoGDBaoCaoThongKeVSXM==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(nam)){
				qPos.add(nam);
			}
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
			}
			if(Validator.isNotNull(maXa)){
				qPos.add(maXa);
			}
			
			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(lstTotal) && Validator.isNotNull(lstTotal.get(0))) {
				return lstTotal.get(0);
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public ThongTinKiemDemHoGD getThongTinKiemDemHGDBaoCaoSearchHelp(String maTinh, String maHuyen,String maXa,String thonXom,String veSinhGiaDinhId) throws SystemException {
		Session session = null;
		List<ThongTinKiemDemHoGD> result = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			query.append(" SELECT me_thongtinkiemdemhogd.*   ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" LEFT JOIN me_thongtinkiemdemhogd ON me_vesinhgiadinh.id = me_thongtinkiemdemhogd.vesinhgiadinhid ");
			query.append(" LEFT JOIN me_kiemdemvien ON  me_thongtinkiemdemhogd.taikhoan = me_kiemdemvien.TAIKHOAN ");
			query.append(" WHERE 1=1 ");
			if (Validator.isNotNull(maTinh)) {
				query.append(" AND me_vesinhgiadinh.matinh = ?   ");
			}
			if (Validator.isNotNull(maHuyen)) {
				query.append(" AND me_vesinhgiadinh.mahuyen = ?  ");
			}
			if (Validator.isNotNull(maXa)) {
				query.append(" AND me_vesinhgiadinh.maxa = ?   ");
			}
			if (Validator.isNotNull(thonXom)) {
				query.append(" AND me_vesinhgiadinh.thonxom = ?  ");
			}
			if (Validator.isNotNull(veSinhGiaDinhId)) {
				query.append(" AND me_thongtinkiemdemhogd.vesinhgiadinhid = ?  ");
			}
			//_log.info("=========getThongTinKiemDemHGDBaoCaoSearchHelp==="+ query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(ThongTinKiemDemHoGDImpl.TABLE_NAME, ThongTinKiemDemHoGDImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			
			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}
			if (Validator.isNotNull(maHuyen)) {
				qPos.add(maHuyen);
			}
			if (Validator.isNotNull(maXa)) {
				qPos.add(maXa);
			}
			if (Validator.isNotNull(thonXom)) {
				qPos.add(thonXom);
			}
			if (Validator.isNotNull(veSinhGiaDinhId)) {
				qPos.add(veSinhGiaDinhId);
			}

			result = (List<ThongTinKiemDemHoGD>) QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (result != null && result.size() > 0 && result.get(0) != null) {
				return result.get(0);
			}
			
			
		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

		return null;
	}
	Log _log = LogFactoryUtil.getLog(ThongTinKiemDemHoGDFinderImpl.class);
}
