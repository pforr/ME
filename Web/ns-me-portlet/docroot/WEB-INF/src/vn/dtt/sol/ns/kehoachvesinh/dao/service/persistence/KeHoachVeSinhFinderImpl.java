package vn.dtt.sol.ns.kehoachvesinh.dao.service.persistence;

import java.util.Iterator;
import java.util.List;

import vn.dtt.sol.ns.kehoachvesinh.dao.model.KeHoachVeSinh;
import vn.dtt.sol.ns.kehoachvesinh.dao.model.impl.KeHoachVeSinhImpl;
import vn.dtt.sol.ns.maungaunhien.dao.service.persistence.MAUKIEMDEMFinder;
import vn.dtt.sol.ns.util.format.FormatData;
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

/**
 * @author HANT
 *
 */
public class KeHoachVeSinhFinderImpl extends BasePersistenceImpl<KeHoachVeSinh>
		implements KeHoachVeSinhFinder {

	public static final String FINDER_VESINH_HGD = KeHoachVeSinhFinder.class
			.getName() + ".finderVeSinhHGD";

	public static final String COUNT_VESINH_HGD = KeHoachVeSinhFinder.class
			.getName() + ".countVeSinhHGD";
	
	public int countVSGD(String maTinh, String maHuyen,
			String maXa, String loaiNhaTieuId, String trangThai,
			String namBaoCao, String namBaoCaoVstx, String ngayNhap,
			String idNguoiTao, String advText)
			throws PortalException, SystemException {

		Session session = null;

		int mauNgauNhien = 0;

		if (Validator.equals("vstx", namBaoCaoVstx)) {
			mauNgauNhien = Integer.parseInt(namBaoCao);
		} else if (Validator.equals("duphong", namBaoCaoVstx)) {
			mauNgauNhien = Integer.parseInt(namBaoCao) * 10;
		} else if (Validator.equals("rasoat", namBaoCaoVstx)) {
			mauNgauNhien = Integer.parseInt(namBaoCao) * 100;
		} else if (Validator.equals("rasoatduphong", namBaoCaoVstx)) {
			mauNgauNhien = Integer.parseInt(namBaoCao) * 1000;
		}

		try {

			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_VESINH_HGD);

			if (Validator.isNull(maTinh)) {
				sql = StringUtil.replace(sql, "MATINH = ?", StringPool.BLANK);
			}

			if (Validator.isNull(maHuyen)) {
				sql = StringUtil.replace(sql, "AND MAHUYEN = ?",
						StringPool.BLANK);
			}

			if (Validator.isNull(maXa)) {
				sql = StringUtil.replace(sql, "AND maxa = ?", StringPool.BLANK);
			}

			
			if (Validator.equals("xaymoi", namBaoCaoVstx) || Validator.isNull(namBaoCaoVstx)) {
				sql = StringUtil.replace(sql, "AND MAUNGAUNHIEN = ?",
						StringPool.BLANK);
			}
			
			if (Validator.equals("rasoat", namBaoCaoVstx)
					|| Validator.equals("rasoatduphong", namBaoCaoVstx)) {
				sql = StringUtil.replace(sql, "[$NAMXAYDUNG_CLAUSE$]",
						"namxaydung < ?");

			} else if (Validator.equals("xaymoi", namBaoCaoVstx)
					|| Validator.equals("vstx", namBaoCaoVstx)
					|| Validator.equals("duphong", namBaoCaoVstx)) {
				sql = StringUtil.replace(sql, "[$NAMXAYDUNG_CLAUSE$]",
						"namxaydung = ?");
			} else {
				sql = StringUtil.replace(sql, "AND [$NAMXAYDUNG_CLAUSE$]",
						StringPool.BLANK);
			}

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

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
			
			if (!Validator.equals("xaymoi", namBaoCaoVstx) && Validator.isNotNull(namBaoCaoVstx)) {
				qPos.add(mauNgauNhien);
			}
			
			if (Validator.isNotNull(namBaoCaoVstx)) {
				qPos.add(namBaoCao);
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


	public List<VeSinhGiaDinh> finderVSGD(String maTinh, String maHuyen,
			String maXa, String loaiNhaTieuId, String trangThai,
			String namBaoCao, String namBaoCaoVstx, String ngayNhap,
			String idNguoiTao, String advText, int start, int end)
			throws PortalException, SystemException {

		Session session = null;

		int mauNgauNhien = 0;

		if (Validator.equals("vstx", namBaoCaoVstx)) {
			mauNgauNhien = Integer.parseInt(namBaoCao);
		} else if (Validator.equals("duphong", namBaoCaoVstx)) {
			mauNgauNhien = Integer.parseInt(namBaoCao) * 10;
		} else if (Validator.equals("rasoat", namBaoCaoVstx)) {
			mauNgauNhien = Integer.parseInt(namBaoCao) * 100;
		} else if (Validator.equals("rasoatduphong", namBaoCaoVstx)) {
			mauNgauNhien = Integer.parseInt(namBaoCao) * 1000;
		}

		try {

			session = openSession();

			String sql = CustomSQLUtil.get(FINDER_VESINH_HGD);

			if (Validator.isNull(maTinh)) {
				sql = StringUtil.replace(sql, "MATINH = ?", StringPool.BLANK);
			}

			if (Validator.isNull(maHuyen)) {
				sql = StringUtil.replace(sql, "AND MAHUYEN = ?",
						StringPool.BLANK);
			}

			if (Validator.isNull(maXa)) {
				sql = StringUtil.replace(sql, "AND maxa = ?", StringPool.BLANK);
			}

			
			if (Validator.equals("xaymoi", namBaoCaoVstx) || Validator.isNull(namBaoCaoVstx)) {
				sql = StringUtil.replace(sql, "AND MAUNGAUNHIEN = ?",
						StringPool.BLANK);
			}
			
			if (Validator.equals("rasoat", namBaoCaoVstx)
					|| Validator.equals("rasoatduphong", namBaoCaoVstx)) {
				sql = StringUtil.replace(sql, "[$NAMXAYDUNG_CLAUSE$]",
						"namxaydung < ?");

			} else if (Validator.equals("xaymoi", namBaoCaoVstx)
					|| Validator.equals("vstx", namBaoCaoVstx)
					|| Validator.equals("duphong", namBaoCaoVstx)) {
				sql = StringUtil.replace(sql, "[$NAMXAYDUNG_CLAUSE$]",
						"namxaydung = ?");
			} else {
				sql = StringUtil.replace(sql, "AND [$NAMXAYDUNG_CLAUSE$]",
						StringPool.BLANK);
			}

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("VeSinhGiaDinh", VeSinhGiaDinhImpl.class);

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
			
			
			if (!Validator.equals("xaymoi", namBaoCaoVstx) && Validator.isNotNull(namBaoCaoVstx)) {
				qPos.add(mauNgauNhien);
			}
			if (Validator.isNotNull(namBaoCaoVstx)) {
				qPos.add(namBaoCao);
			}
			
			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(), start,
					end);

		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	}

	public List<KeHoachVeSinh> search(long nam, String maTinh, String maHuyen,
			int start, int end) throws PortalException, SystemException {

		Session session = null;

		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT * ");
			query.append(" FROM me_kehoachvesinhxa ");
			query.append(" WHERE 1 = 1 ");

			if (nam != 0) {
				query.append(" AND NAM = " + Long.valueOf(nam) + " ");
			}

			if (Validator.isNotNull(maTinh)) {
				query.append(" AND MATINH = '" + maTinh + "' ");
			}

			if (Validator.isNotNull(maHuyen)) {
				query.append(" AND MAHUYEN = '" + maHuyen + "' ");
			}

			_log.debug("==" + query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(KeHoachVeSinhImpl.TABLE_NAME, KeHoachVeSinhImpl.class);

			return (List<KeHoachVeSinh>) QueryUtil.list(q, getDialect(), start,
					end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int count(long nam, String maTinh, String maHuyen)
			throws PortalException, SystemException {

		Session session = null;

		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT count(*) as COUNT_VALUE ");
			query.append(" FROM me_kehoachvesinhxa ");
			query.append(" WHERE 1 = 1 ");

			if (nam != 0) {
				query.append(" AND NAM = " + Long.valueOf(nam) + " ");
			}

			if (Validator.isNotNull(maTinh)) {
				query.append(" AND MATINH = '" + maTinh + "' ");
			}

			if (Validator.isNotNull(maHuyen)) {
				query.append(" AND MAHUYEN = '" + maHuyen + "' ");
			}

			_log.debug("==" + query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			q.setCacheable(false);

			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}
			return 0;

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countSoDanHuongLoi(String nam, String maTinh, String dangkyvstx)
			throws PortalException, SystemException {

		Session session = null;

		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT SUM(SODAN) as COUNT_VALUE ");
			query.append(" FROM ME_KEHOACHVESINHXA ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(nam)) {
				query.append(" AND NAM = ? ");
			}

			if (Validator.isNotNull(maTinh)) {
				query.append(" AND MATINH = ? ");
			}

			if (Validator.isNotNull(dangkyvstx)) {
				query.append(" AND DANGKYVSTX = ? ");
			}

			_log.info("==countSoDanHuongLoi==" + query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(nam)) {
				qPos.add(nam);
			}
			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}
			if (Validator.isNotNull(dangkyvstx)) {
				qPos.add(dangkyvstx);
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
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List<KeHoachVeSinh> getKeHoachVeSinhByNamTinhDangKyVSTX(String nam,
			String maTinh, String dangkyvstx) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT * FROM me_kehoachvesinhxa ");
			query.append(" WHERE 1=1 ");

			if (Validator.isNotNull(nam)) {
				if (nam.equalsIgnoreCase("0")) {
					query.append(" AND ( nam =  ? OR nam =  ? ) ");
					query.append("  ");
				} else {
					query.append(" AND nam =  ? ");
				}

			}
			if (Validator.isNotNull(maTinh)) {
				query.append(" AND matinh =  ? ");
			}
			if (Validator.isNotNull(dangkyvstx)) {
				query.append(" AND DANGKYVSTX = ? ");
			}
			query.append(" ORDER BY NAM,MATINH,MAHUYEN,MAXA ASC ");

			_log.info("==getKeHoachVeSinhByNamTinhDangKyVSTX==="
					+ query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(KeHoachVeSinhImpl.TABLE_NAME, KeHoachVeSinhImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(nam)) {
				if (nam.equalsIgnoreCase("0")) {
					qPos.add(nam);
					qPos.add(FormatData.getCurrentYear());
				} else {
					qPos.add(nam);
				}

			}
			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}
			if (Validator.isNotNull(dangkyvstx)) {
				qPos.add(dangkyvstx);
			}
			return (List<KeHoachVeSinh>) QueryUtil.list(q, getDialect(),
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	}

	public int sumSoNhaTieuHVSMoiTW(String namBaoCao, String maTinh)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT SUM(SONHATIEUHVSMOI) AS total ");
			query.append(" FROM me_kehoachvesinhxa  ");

			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(namBaoCao)) {
				query.append(" AND NAM = ? ");
			}
			if (Validator.isNotNull(maTinh)) {
				query.append(" AND MATINH = ? ");
			}

			SQLQuery q = session.createSQLQuery(query.toString());
			_log.info("--sumSoNhaTieuHVSMoiTW----" + query.toString() + "===");
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(namBaoCao)) {
				qPos.add(namBaoCao);
			}
			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}

			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q,
					getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(lstTotal)
					&& Validator.isNotNull(lstTotal.get(0))) {
				return lstTotal.get(0);
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int sumSoNhaTieuHVSMoitheoKH(String nam, String maTinh, String maHuyen, String maXa,String dangKyVSTX)
			throws PortalException, SystemException {

		Session session = null;

		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT SUM(SONHATIEUHVSMOI)  as COUNT_VALUE ");
			query.append(" FROM me_kehoachvesinhxa ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(nam)) {
				query.append(" AND NAM = ? ");
			}

			if (Validator.isNotNull(maTinh)) {
				query.append(" AND MATINH = ? ");
			}

			if (Validator.isNotNull(maHuyen)) {
				query.append(" AND MAHUYEN = ? ");
			}
			if (Validator.isNotNull(maXa)) {
				query.append(" AND MAXA = ? ");
			}
			if (Validator.isNotNull(dangKyVSTX)) {
				query.append(" AND DANGKYVSTX = ? ");
			}
			_log.info("==sumSoNhaTieuHVSMoitheoKH==" + query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(nam)) {
				qPos.add(nam);
			}
			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}
			if (Validator.isNotNull(maHuyen)) {
				qPos.add(maHuyen);
			}
			if (Validator.isNotNull(maXa)) {
				qPos.add(maXa);
			}
			if (Validator.isNotNull(dangKyVSTX)) {
				qPos.add(dangKyVSTX);
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
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int sumSoDanHuongLoiBaoCaoHopNhat(String maTinh,int nam, int namToiThieu, String dangkyvstx)
			throws PortalException, SystemException {

		Session session = null;

		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT SUM(SODAN) as COUNT_VALUE ");
			query.append(" FROM ME_KEHOACHVESINHXA ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh)) {
				query.append(" AND MATINH = ? ");
			}
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(nam) && nam > 0){
				query.append(" AND ( NAM >= ?");
				query.append(" AND NAM <= ? ) ");
			}

			if (Validator.isNotNull(dangkyvstx)) {
				query.append(" AND DANGKYVSTX = ? ");
			}

			_log.info("==sumSoDanHuongLoiBaoCaoHopNhat==" + query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}
			
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(nam) && nam > 0){
				qPos.add(namToiThieu);
				qPos.add(nam);
			}
			
			if (Validator.isNotNull(dangkyvstx)) {
				qPos.add(dangkyvstx);
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
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	private static Log _log = LogFactoryUtil.getLog(KeHoachVeSinhFinderImpl.class);
}
