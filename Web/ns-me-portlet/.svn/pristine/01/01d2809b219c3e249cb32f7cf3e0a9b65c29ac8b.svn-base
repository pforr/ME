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
			query.append(" GROUP BY MAHUYEN, MAXA ");//them maxa
			query.append(" ORDER BY MATINH, MAHUYEN, MAXA, ID  ");
			
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
			if(Validator.isNotNull(maHuyen)){
				query.append(" AND MAHUYEN = ? ");
			}
			if(Validator.isNotNull(maXa)){
				query.append(" AND MAXA = ? ");
			}
			if(Validator.isNotNull(daketthucdieutra)){
				query.append(" AND DAKETTHUCDIEUTRA = ? ");
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
			
			query.append(" SELECT count(*) as total ");
			query.append(" FROM ME_THONGTINKIEMDEMHOGD ");
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
			
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT count(*) as total ");
			query.append(" FROM ME_THONGTINKIEMDEMHOGD AS t ");
			query.append(" INNER JOIN ME_VESINHGIADINH AS v ");
			query.append(" ON t.VESINHGIADINHID = v.ID ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND t.MATINH = ? ");
			}
			
			if(Validator.isNotNull(mauNgauNhien)){
				query.append(" AND v.MAUNGAUNHIEN = ? ");
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				query.append(" AND t.GIOITINHCHUHO = ? ");
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
				qPos.add(mauNgauNhien);
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
			
			query.append(" SELECT count(*) as total ");
			query.append(" FROM ME_THONGTINKIEMDEMHOGD ");
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
			
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT count(*) as total ");
			query.append(" FROM ME_THONGTINKIEMDEMHOGD AS t ");
			query.append(" INNER JOIN ME_VESINHGIADINH AS v ");
			query.append(" ON t.VESINHGIADINHID = v.ID ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND t.MATINH = ? ");
			}
			
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namMauNgauNhien) && namMauNgauNhien > 0){
				query.append(" AND ( v.MAUNGAUNHIEN >= ? AND v.MAUNGAUNHIEN <= ? ) ");
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
	
	Log _log = LogFactoryUtil.getLog(ThongTinKiemDemHoGDFinderImpl.class);
}
