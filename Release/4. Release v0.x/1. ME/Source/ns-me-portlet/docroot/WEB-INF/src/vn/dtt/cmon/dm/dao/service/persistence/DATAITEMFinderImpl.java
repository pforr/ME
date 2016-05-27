package vn.dtt.cmon.dm.dao.service.persistence;

import java.util.ArrayList;
import java.util.List;

import vn.dtt.cmon.dm.dao.model.DATAITEM;
import vn.dtt.cmon.dm.dao.model.impl.DATAITEMImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class DATAITEMFinderImpl extends BasePersistenceImpl<DATAITEM> implements
		DATAITEMFinder {
	public static final String FINDER_SQL = DATAITEMFinder.class.getName()
			+ ".getDataItem";

	/**
	 * @param dataGroupCode
	 * @param level
	 * @param orgCode
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<DATAITEM> find(int dataGroupCode, int level, String orgCode)
			throws PortalException, SystemException {

		return getDataItem(dataGroupCode, level, orgCode);

	}

	/**
	 * @param dataGroupCode
	 * @param level
	 * @param orgCode
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private List<DATAITEM> getDataItem(int dataGroupCode, int level,
			String orgCode) throws PortalException, SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FINDER_SQL);

			if (dataGroupCode != 0 && level != 0) {

				String orgCodeOpt = "[$ORGCODE_SELECT$]";

				if (level == 1) {
					sql = StringUtil.replace(sql, "[$ORGCODE_SELECT$]",
							"AND (a1.NODE_1 = ?)");
				}
				if (level == 2) {
					sql = StringUtil.replace(sql, "[$ORGCODE_SELECT$]",
							"AND (a1.NODE_2 = ?)");
				}
				if (level == 3) {
					sql = StringUtil.replace(sql, "[$ORGCODE_SELECT$]",
							"AND (a1.NODE_3 = ?)");
				}
				if (level == 4) {
					sql = StringUtil.replace(sql, "[$ORGCODE_SELECT$]",
							"AND (a1.NODE_4 = ?)");
				}
				
				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("DATAITEM", DATAITEMImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataGroupCode);
				qPos.add(level);
				qPos.add(orgCode);

				return (List<DATAITEM>) QueryUtil.list(q, getDialect(), 0,
						1);
			} else {
				return new ArrayList<DATAITEM>();
			}

		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	}

	private static Log _log = LogFactoryUtil.getLog(DATAITEMFinderImpl.class);
}
