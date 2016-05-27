package vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence;

import java.util.List;

import vn.dtt.sol.ns.vesinhmoitruong.dao.model.ThongTinKiemDemCongTrinh;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.ThongTinKiemDemCongTrinhImpl;

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

public class ThongTinKiemDemCongTrinhFinderImpl extends BasePersistenceImpl<ThongTinKiemDemCongTrinh> implements ThongTinKiemDemCongTrinhFinder{
	
	public List<ThongTinKiemDemCongTrinh> getListThongTinKiemDemCongTrinhByKeHoachId(int keHoachId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT * FROM me_thongtinkiemdemcongtrinh ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(keHoachId)){
				query.append(" AND KEHOACHKIEMDEMVESINHID = ? ");
			}
	
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(ThongTinKiemDemCongTrinhImpl.TABLE_NAME,ThongTinKiemDemCongTrinhImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(keHoachId)){
				qPos.add(keHoachId);
			}
			return (List<ThongTinKiemDemCongTrinh>) QueryUtil.list(q, getDialect(),   QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	
	public ThongTinKiemDemCongTrinh getThongTinKiemDemCongTrinhByVeSinhCTID(String VESINHCONGTRINHID) throws SystemException {
		Session session = null;
		List<ThongTinKiemDemCongTrinh> result = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			query.append(" SELECT * FROM me_thongtinkiemdemcongtrinh ");
			query.append(" WHERE 1 = 1 ");

			
			if(Validator.isNotNull(VESINHCONGTRINHID)){
				query.append(" AND VESINHCONGTRINHID = ? ");
			}
			//_log.info("=========getDanhGiaBenVungByTramCapNuocAndNam==="+ query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(ThongTinKiemDemCongTrinhImpl.TABLE_NAME, ThongTinKiemDemCongTrinhImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(VESINHCONGTRINHID)){
				qPos.add(VESINHCONGTRINHID);
			}

			result = (List<ThongTinKiemDemCongTrinh>) QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (result != null && result.size() > 0) {
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
	
	public List<ThongTinKiemDemCongTrinh> getListGroupByBaoCaoThongKeCTCC(String nam,String maTinh,String maHuyen,String maXa) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT t.* FROM me_thongtinkiemdemcongtrinh as t ");
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
			query.append(" ORDER BY t.MATINH, t.MAHUYEN, t.MAXA,t.diachi, t.ID ASC ");
			
			SQLQuery q = session.createSQLQuery(query.toString());
			
			_log.info("=getListGroupByBaoCaoThongKeCTCC==" + query.toString());
			
			q.setCacheable(false);
			q.addEntity(ThongTinKiemDemCongTrinhImpl.TABLE_NAME,ThongTinKiemDemCongTrinhImpl.class);
			
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
			return (List<ThongTinKiemDemCongTrinh>) QueryUtil.list(q, getDialect(),   QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countCTCCBaoCaoThongKeCTCC(String nam,String maTinh,String maHuyen,String maXa,int isHVS,int isKoHVS,int isChuaKiemDem,int isDangKiemDem) throws SystemException {
		Session session = null;
		try {
			
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT count(t.id) as total FROM me_thongtinkiemdemcongtrinh AS t ");
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
				query.append(" AND t.MATINH = ? ");
			}
			if(Validator.isNotNull(maXa)){
				query.append(" AND t.maXa = ? ");
			}
			
			if(Validator.isNotNull(isHVS) && isHVS == 1){/// cac ho da hoan thanh va danh gia 1 la hvs
				query.append(" AND t.DAKETTHUCDIEUTRA = 1 AND t.DANHGIAKIEMDEM = 1 ");
			}
			if(Validator.isNotNull(isKoHVS) && isKoHVS == 1){/// cac ho da hoan thanh va danh gia 2 ko hvs
				query.append(" AND t.DAKETTHUCDIEUTRA = 1 AND t.DANHGIAKIEMDEM = 2 ");
			}
			if(Validator.isNotNull(isChuaKiemDem) && isChuaKiemDem == 1){/// cac ho cho khao sat
				query.append(" AND ( t.DAKETTHUCDIEUTRA = 0 OR t.DAKETTHUCDIEUTRA is null ) ");
			}
			if(Validator.isNotNull(isDangKiemDem) && isDangKiemDem == 1){/// cac ho chua hoan thanh
				query.append(" AND t.DAKETTHUCDIEUTRA = 2 ");
			}
			
			_log.info("====countCTCCBaoCaoThongKeCTCC==" + query.toString());
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
	Log _log = LogFactoryUtil.getLog(ThongTinKiemDemCongTrinhFinderImpl.class);
}
