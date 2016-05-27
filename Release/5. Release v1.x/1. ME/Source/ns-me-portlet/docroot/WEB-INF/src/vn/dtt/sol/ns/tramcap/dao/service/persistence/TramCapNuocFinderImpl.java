package vn.dtt.sol.ns.tramcap.dao.service.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import vn.dtt.sol.ns.tramcap.dao.model.DanhGiaBenVung;
import vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc;
import vn.dtt.sol.ns.tramcap.dao.model.impl.DanhGiaBenVungImpl;
import vn.dtt.sol.ns.tramcap.dao.model.impl.TramCapNuocImpl;
import vn.dtt.sol.ns.util.format.FormatData;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class TramCapNuocFinderImpl extends BasePersistenceImpl<TramCapNuoc>
		implements TramCapNuocFinder {
	private static final Log _log = LogFactoryUtil
			.getLog(TramCapNuocFinderImpl.class);

	/**
	 * @param maTinh
	 * @return
	 */
	public int countTramCap(String maTinh) throws PortalException, SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT COUNT(*) AS COUNT_VALUE from me_tramcapnuoc ");

			query.append(" WHERE 1=1 ");

			if (Validator.isNotNull(maTinh)) {
				query.append(" AND me_tramcapnuoc.matinh =  ? ");
			}

			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}

			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	 * @param maTinh
	 * @param start
	 * @param end
	 * @return
	 */
	public List<TramCapNuoc> getTramCapByTinh(String maTinh, int start, int end)
			throws PortalException, SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT * from me_tramcapnuoc ");

			query.append(" WHERE 1=1 ");

			if (Validator.isNotNull(maTinh)) {
				query.append(" AND me_tramcapnuoc.matinh =  ? ");
			}

			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(TramCapNuocImpl.TABLE_NAME, TramCapNuocImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}

			return (List<TramCapNuoc>) QueryUtil.list(q, getDialect(), start,
					end);

		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}

		return new ArrayList<TramCapNuoc>();
	}

	/**
	 * @author tailt
	 */
	public List<TramCapNuoc> getTramCapNuocByTinhDauNoiNuoc(String maTinh, String namBaoCao, String trangThai) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT DISTINCT t.* FROM me_tramcapnuoc AS t ");
			query.append(" INNER JOIN me_daunoinuoc AS d ");
			query.append(" ON t.id = d.tramcapnuocid ");
			query.append(" WHERE 1=1 ");
			if (Validator.isNotNull(maTinh)) {
				query.append(" AND d.matinh =  ? ");
			}
			if (Validator.isNotNull(namBaoCao)) {
				if(namBaoCao.equalsIgnoreCase("0")){
					query.append(" AND ( d.nambaocao =  ? OR d.nambaocao =  ? ) ");
				}else{
					query.append(" AND d.nambaocao =  ? ");
					query.append(" AND YEAR(d.NgayDauNoiThucTe) =  ? ");
				}
				
			}
			if (Validator.isNotNull(trangThai)) {
				query.append(" AND d.TrangThai =  ? ");
			}
			query.append(" ORDER BY d.nambaocao, t.MAHUYEN, t.MAXA, d.tramcapnuocid ASC ");
			
			//_log.info("==getTramCapNuocByTinhDauNoiNuoc==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(TramCapNuocImpl.TABLE_NAME, TramCapNuocImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}
			if (Validator.isNotNull(namBaoCao)) {
				if(namBaoCao.equalsIgnoreCase("0")){
					qPos.add(namBaoCao);
					qPos.add(FormatData.getCurrentYear());
				}else{
					qPos.add(namBaoCao);
					qPos.add(namBaoCao);
				}
				
			}
			if (Validator.isNotNull(trangThai)) {
				qPos.add(trangThai);
			}
			return (List<TramCapNuoc>) QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}

		return new ArrayList<TramCapNuoc>();
	}

	/**
	 * @author tailt
	 */
	public List<TramCapNuoc> getTramCapNuocByDanhGiaBenVung(String maTinh,
			String nam, String ketquadanhgia) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT DISTINCT t.* FROM me_tramcapnuoc AS t ");
			query.append(" INNER JOIN me_danhgiabenvung AS d ");
			query.append(" ON t.id = d.tramcapnuocid ");
			query.append(" WHERE 1=1 ");

			if (Validator.isNotNull(maTinh)) {
				query.append(" AND t.matinh =  ? ");
			}

			if (Validator.isNotNull(nam)) {
				if(nam.equalsIgnoreCase("0")){
					query.append(" AND ( d.nam =  ? OR d.nam =  ? ) ");					
				}else{
					query.append(" AND d.nam =  ? ");
				}				
			}
			if (Validator.isNotNull(ketquadanhgia)) {
				query.append(" AND d.ketquadanhgia = ? ");
			}
			
			query.append(" ORDER BY d.nam, matinh, mahuyen, maxa, d.tramcapnuocid ASC ");
			//_log.info("==getTramCapNuocByDanhGiaBenVung===" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(TramCapNuocImpl.TABLE_NAME, TramCapNuocImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}

			if (Validator.isNotNull(nam)) {
				if(nam.equalsIgnoreCase("0")){
					qPos.add(nam);
					qPos.add(FormatData.getCurrentYear());
				}else{
					qPos.add(nam);
				}
				
			}
			if (Validator.isNotNull(ketquadanhgia)) {
				qPos.add(ketquadanhgia);
			}
			return (List<TramCapNuoc>) QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}

		return new ArrayList<TramCapNuoc>();
	}

	
	public List<TramCapNuoc> getTramCapNuocJoinDanhGiaBenVung(String maTinh, String nam) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT t.* FROM me_tramcapnuoc AS t ");
			query.append(" INNER JOIN me_danhgiabenvung AS d ");
			query.append(" ON t.id = d.tramcapnuocid ");
			query.append(" WHERE 1=1 ");

			if (Validator.isNotNull(maTinh)) {
				query.append(" AND t.matinh =  ? ");
			}

			if (Validator.isNotNull(nam)) {
				if(nam.equalsIgnoreCase("0")){
					query.append(" AND ( d.nam =  ? OR d.nam =  ? ) ");
				}else{
					query.append(" AND d.nam =  ? ");
				}				
			}
			query.append(" ORDER BY  t.matinh,t.MAHUYEN, t.MAXA ,d.tramcapnuocid,d.nam  ASC ");
			
			//_log.info("==getTramCapNuocJoinDanhGiaBenVung===" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(TramCapNuocImpl.TABLE_NAME, TramCapNuocImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}

			if (Validator.isNotNull(nam)) {
				if(nam.equalsIgnoreCase("0")){
					qPos.add(nam);
					qPos.add(FormatData.getCurrentYear());
				}else{
					qPos.add(nam);
				}
				
			}
			
			return (List<TramCapNuoc>) QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}

		return new ArrayList<TramCapNuoc>();
	}
	
	
	public List<TramCapNuoc> getTramCapNuocByThoiGianThuc(String maTinh, String namBaoCao, String danhgiakiemdem, String daketthucdieutra) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT DISTINCT t.* FROM ME_TRAMCAPNUOC AS t ");
			query.append(" INNER JOIN ME_DAUNOINUOC AS d ON t.ID = d.TRAMCAPNUOCID ");
			query.append(" INNER JOIN ME_THONGTINKIEMDEMNUOC as k ON d.ID = k.DAUNOINUOCID ");
			query.append(" WHERE 1=1 ");
			if (Validator.isNotNull(maTinh)) {
				query.append(" AND d.MATINH =  ? ");
			}
			if (Validator.isNotNull(namBaoCao)) {
				query.append(" AND YEAR(k.THOIGIANDAUNOITHUCTE) =  ? ");
			}
			if (Validator.isNotNull(danhgiakiemdem)) {
				query.append(" AND k.DANHGIAKIEMDEM = ? ");
			}
			if (Validator.isNotNull(daketthucdieutra)) {
				query.append(" AND k.DAKETTHUCDIEUTRA = ? ");
			}
			query.append(" ORDER BY  t.ID, t.MAHUYEN, t.MAXA  ASC ");
			
			//_log.info("==getTramCapNuocByThoiGianThuc==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(TramCapNuocImpl.TABLE_NAME, TramCapNuocImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}
			if (Validator.isNotNull(namBaoCao)) {
				qPos.add(namBaoCao);
			}
			if (Validator.isNotNull(danhgiakiemdem)) {
				qPos.add(danhgiakiemdem);
			}
			if (Validator.isNotNull(daketthucdieutra)) {
				qPos.add(daketthucdieutra);
			}
			return (List<TramCapNuoc>) QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}

		return new ArrayList<TramCapNuoc>();
	}
	
	public int countDauNoiTramCapThoiGianThuc(String maTinh, String namBaoCao, String danhgiakiemdem, String tramCapNuocId, String daketthucdieutra) throws PortalException, SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT COUNT(*) AS COUNT_VALUE FROM ME_TRAMCAPNUOC AS t ");
			query.append(" INNER JOIN ME_DAUNOINUOC AS d ON t.ID = d.TRAMCAPNUOCID ");
			query.append(" INNER JOIN ME_THONGTINKIEMDEMNUOC as k ON d.ID = k.DAUNOINUOCID ");
			query.append(" WHERE 1=1 ");
			if (Validator.isNotNull(maTinh)) {
				query.append(" AND d.MATINH =  ? ");
			}
			if (Validator.isNotNull(namBaoCao)) {
				query.append(" AND YEAR(k.THOIGIANDAUNOITHUCTE) =  ? ");
			}
			if (Validator.isNotNull(danhgiakiemdem)) {
				query.append(" AND k.DANHGIAKIEMDEM = ? ");
			}
			if (Validator.isNotNull(tramCapNuocId)) {
				query.append(" AND d.TRAMCAPNUOCID = ? ");
			}
			if (Validator.isNotNull(daketthucdieutra)) {
				query.append(" AND k.DAKETTHUCDIEUTRA = ? ");
			}
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}
			if (Validator.isNotNull(namBaoCao)) {
				qPos.add(namBaoCao);
			}
			if (Validator.isNotNull(danhgiakiemdem)) {
				qPos.add(danhgiakiemdem);
			}
			if (Validator.isNotNull(tramCapNuocId)) {
				qPos.add(tramCapNuocId);
			}
			if (Validator.isNotNull(daketthucdieutra)) {
				qPos.add(daketthucdieutra);
			}
			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public TramCapNuoc getTramCapNuocByMaTinhAndDNNID(String maTinh, String dauNoiNuocID) throws SystemException {
		Session session = null;
		List<TramCapNuoc> result = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			query.append(" SELECT t.* FROM me_tramcapnuoc as t ");
			query.append(" INNER JOIN me_daunoinuoc as d ON t.ID = d.TRAMCAPNUOCID ");
			query.append(" WHERE 1=1 ");

			
			if (Validator.isNotNull(maTinh)) {
				query.append(" AND d.MATINH = ?  ");
			}
			if (Validator.isNotNull(dauNoiNuocID)) {
				query.append(" AND d.ID = ?  ");
			}
			//_log.info("=========getDanhGiaBenVungByTramCapNuocAndNam==="+ query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(TramCapNuocImpl.TABLE_NAME, TramCapNuocImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			
			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}
			if (Validator.isNotNull(dauNoiNuocID)) {
				qPos.add(dauNoiNuocID);
			}

			result = (List<TramCapNuoc>) QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	
	public List<TramCapNuoc> getTramCapJoinDanhGiaBenVungGroupByMaTinhTW( String nam, String ketquadanhgia)throws PortalException, SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT t.* FROM me_tramcapnuoc AS t ");
			query.append(" INNER JOIN me_danhgiabenvung AS d ");
			query.append(" ON t.id = d.tramcapnuocid ");
			query.append(" WHERE 1=1 ");
			
			if (Validator.isNotNull(nam)) {
				query.append(" AND d.nam =  ? ");
			}
			if (Validator.isNotNull(ketquadanhgia)) {
				query.append(" AND d.ketquadanhgia = ? ");
			}
			
			query.append(" GROUP BY t.matinh ");
			query.append(" ORDER BY t.matinh, t.mahuyen, t.maxa ASC ");
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(TramCapNuocImpl.TABLE_NAME, TramCapNuocImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(nam)) {
				qPos.add(nam);
			}
			if (Validator.isNotNull(ketquadanhgia)) {
				qPos.add(ketquadanhgia);
			}
			return (List<TramCapNuoc>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS,QueryUtil.ALL_POS);

		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}

		return new ArrayList<TramCapNuoc>();
	}
	
	public List<TramCapNuoc> getTramCapJoinDanhGiaBenVungGroupByMaHuyenXaTW( String nam, String maTinh ,String ketquadanhgia)throws PortalException, SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT t.* FROM me_tramcapnuoc AS t ");
			query.append(" INNER JOIN me_danhgiabenvung AS d ");
			query.append(" ON t.id = d.tramcapnuocid ");
			query.append(" WHERE 1=1 ");
			
			if (Validator.isNotNull(nam)) {
				query.append(" AND d.nam =  ? ");
			}
			if (Validator.isNotNull(maTinh)) {
				query.append(" AND t.matinh =  ? ");
			}
			if (Validator.isNotNull(ketquadanhgia)) {
				query.append(" AND d.ketquadanhgia = ? ");
			}
			
			query.append(" GROUP BY t.mahuyen,t.maxa ");
			query.append(" ORDER BY t.matinh, t.mahuyen, t.maxa,d.tramcapnuocid ASC ");
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(TramCapNuocImpl.TABLE_NAME, TramCapNuocImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(nam)) {
				qPos.add(nam);
			}
			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}
			if (Validator.isNotNull(ketquadanhgia)) {
				qPos.add(ketquadanhgia);
			}
			return (List<TramCapNuoc>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS,QueryUtil.ALL_POS);

		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}

		return new ArrayList<TramCapNuoc>();
	}
	
	public List<TramCapNuoc> getTramCapNuocJoinDanhGiaBenVungBaoCaoHopNhat(String maTinh, int nam, int namToiThieu) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT t.* FROM me_tramcapnuoc AS t ");
			query.append(" INNER JOIN me_danhgiabenvung AS d ");
			query.append(" ON t.id = d.tramcapnuocid ");
			query.append(" WHERE 1=1 ");

			if (Validator.isNotNull(maTinh)) {
				query.append(" AND t.matinh =  ? ");
			}

			if (Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(nam) && nam > 0) {
				query.append(" AND ( d.nam >=  ? ");
				query.append(" AND d.nam <= ? ) ");
			}
			query.append(" GROUP BY t.matinh ");
			query.append(" ORDER BY d.nam , t.matinh,MAHUYEN, MAXA ,d.tramcapnuocid ASC ");
			
			//_log.info("==getTramCapNuocJoinDanhGiaBenVung===" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(TramCapNuocImpl.TABLE_NAME, TramCapNuocImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}
			if (Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(nam) && nam > 0) {
				qPos.add(namToiThieu);
				qPos.add(nam);
			}
			
			return (List<TramCapNuoc>) QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}

		return new ArrayList<TramCapNuoc>();
	}
	
	
	public int sumDauNoiTramCapBaoCaoHopNhat(String maTinh, int nam, int namToiThieu,String tramCapId, int isThietKe, int isThucTe) throws PortalException, SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT  ");
			if(isThietKe == 1){
				query.append(" SUM(t.TONGDAUNOITHIETKE) ");
			}
			if(isThucTe == 1){
				query.append(" SUM(t.TONGDAUNOITHUCTE) ");
			}
			
			
			query.append("  AS COUNT_VALUE FROM ME_TRAMCAPNUOC AS t ");
			query.append(" INNER JOIN ME_DANHGIABENVUNG AS d ");
			query.append(" ON t.ID = d.TRAMCAPNUOCID ");
			query.append(" WHERE 1=1 ");
			if (Validator.isNotNull(maTinh)) {
				query.append(" AND t.matinh =  ? ");
			}

			if (Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(nam) && nam > 0) {
				query.append(" AND ( d.nam >=  ? ");
				query.append(" AND d.nam <= ? ) ");
			}
			if (Validator.isNotNull(tramCapId)) {
				query.append(" AND t.ID =  ? ");
			}
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}
			if (Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(nam) && nam > 0) {
				qPos.add(namToiThieu);
				qPos.add(nam);
			}
			if (Validator.isNotNull(tramCapId)) {
				qPos.add(tramCapId);
			}
			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
}
