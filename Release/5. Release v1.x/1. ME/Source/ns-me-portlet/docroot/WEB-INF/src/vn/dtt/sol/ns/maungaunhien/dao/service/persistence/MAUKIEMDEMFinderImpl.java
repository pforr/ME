package vn.dtt.sol.ns.maungaunhien.dao.service.persistence;

import java.util.Iterator;
import java.util.List;

import vn.dtt.sol.ns.maungaunhien.dao.model.MAUKIEMDEM;
import vn.dtt.sol.ns.maungaunhien.dao.model.impl.MAUKIEMDEMImpl;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhGiaDinh;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.VeSinhGiaDinhImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class MAUKIEMDEMFinderImpl extends BasePersistenceImpl<MAUKIEMDEM>
		implements MAUKIEMDEMFinder {

	public static final String FINDER_SQL = MAUKIEMDEMFinder.class.getName()
			+ ".finder";

	public static final String COUNT_SQL = MAUKIEMDEMFinder.class.getName()
			+ ".count";

	public static final String COUNT_MAURASOAT = MAUKIEMDEMFinder.class
			.getName() + ".countMauRaSoat";

	public static final String FINDER_MAURASOAT = MAUKIEMDEMFinder.class
			.getName() + ".finderMauRaSoat";
	public static final String COUNT_MAUKIEMDEM = MAUKIEMDEMFinder.class
			.getName() + ".countMauKiemDem";

	public static final String FINDER_MAUKIEMDEM = MAUKIEMDEMFinder.class
			.getName() + ".finderMauKiemDem";
	
	public List<VeSinhGiaDinh> finderMauKiemDem(int nam, String maTinh, String maHuyen,
			String maXa, int start, int end) throws PortalException,
			SystemException {
		Session session = null;

		try {

			session = openSession();

			String sql = CustomSQLUtil.get(FINDER_MAUKIEMDEM);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("VeSinhGiaDinh", VeSinhGiaDinhImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(maTinh);
			qPos.add(maHuyen);
			qPos.add(maXa);
			qPos.add(nam);

			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(), start,
					end);

		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	}

	public int countKiemDem(int nam, String maTinh, String maHuyen,
			String maXa) throws PortalException, SystemException {
		Session session = null;

		try {

			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_MAUKIEMDEM);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(maTinh);
			qPos.add(maHuyen);
			qPos.add(maXa);
			qPos.add(nam);
			
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

	public List<VeSinhGiaDinh> finderMauRaSoat(int nam, String maTinh, String maHuyen,
			String maXa, int start, int end) throws PortalException,
			SystemException {
		Session session = null;

		try {

			session = openSession();

			String sql = CustomSQLUtil.get(FINDER_MAURASOAT);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("VeSinhGiaDinh", VeSinhGiaDinhImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(maTinh);
			qPos.add(maHuyen);
			qPos.add(maXa);
			qPos.add(nam);
			qPos.add(maTinh);
			qPos.add(maHuyen);
			qPos.add(maXa);

			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(), start,
					end);

		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	}

	public int countMauRaSoat(int nam, String maTinh, String maHuyen,
			String maXa) throws PortalException, SystemException {
		Session session = null;

		try {

			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_MAURASOAT);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(maTinh);
			qPos.add(maHuyen);
			qPos.add(maXa);
			qPos.add(nam);
			qPos.add(maTinh);
			qPos.add(maHuyen);
			qPos.add(maXa);

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

	public List<MAUKIEMDEM> findMauKiemDem(int nam, String tinh, String huyen,
			String xa, int start, int end) throws PortalException,
			SystemException {

		Session session = null;

		try {

			session = openSession();

			String sql = CustomSQLUtil.get(FINDER_SQL);

			if ((Validator.isNull(tinh) || tinh.contentEquals("0"))) {
				sql = StringUtil.replace(sql, "AND matinh = ?",
						StringPool.BLANK);
			}

			if ((Validator.isNull(huyen) || huyen.contentEquals("0"))) {
				sql = StringUtil.replace(sql, "AND mahuyen = ?",
						StringPool.BLANK);
			}

			if ((Validator.isNull(xa) || xa.contentEquals("0"))) {
				sql = StringUtil.replace(sql, "AND maxa = ?", StringPool.BLANK);
			}

			if ((Validator.isNull(nam) || nam == 0)) {
				sql = StringUtil.replace(sql, "AND nam = ?", StringPool.BLANK);
			}

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("MAUKIEMDEM", MAUKIEMDEMImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (!(Validator.isNull(tinh) || tinh.contentEquals("0"))) {
				qPos.add(tinh);
			}

			if (!(Validator.isNull(huyen) || huyen.contentEquals("0"))) {
				qPos.add(huyen);
			}

			if (!(Validator.isNull(xa) || xa.contentEquals("0"))) {
				qPos.add(xa);
			}

			if (!(Validator.isNull(nam) || nam == 0)) {
				qPos.add(nam);
			}

			return (List<MAUKIEMDEM>) QueryUtil.list(q, getDialect(), start,
					end);

		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countMauKiemDem(int nam, String tinh, String huyen, String xa)
			throws PortalException, SystemException {
		Session session = null;

		try {

			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_SQL);

			if (Validator.isNull(tinh)) {
				sql = StringUtil.replace(sql, "AND matinh = ?",
						StringPool.BLANK);
			}

			if (Validator.isNull(huyen)) {
				sql = StringUtil.replace(sql, "AND mahuyen = ?",
						StringPool.BLANK);
			}

			if (Validator.isNull(xa)) {
				sql = StringUtil.replace(sql, "AND maxa = ?", StringPool.BLANK);
			}

			if (Validator.isNull(nam)) {
				sql = StringUtil.replace(sql, "AND nam = ?", StringPool.BLANK);
			}

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			if (!Validator.isNull(tinh)) {
				qPos.add(tinh);
			}

			if (!Validator.isNull(huyen)) {
				qPos.add(huyen);
			}

			if (!Validator.isNull(xa)) {
				qPos.add(xa);
			}

			if (!Validator.isNull(nam)) {
				qPos.add(nam);
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

	private static Log _log = LogFactoryUtil.getLog(MAUKIEMDEMFinderImpl.class);
}
