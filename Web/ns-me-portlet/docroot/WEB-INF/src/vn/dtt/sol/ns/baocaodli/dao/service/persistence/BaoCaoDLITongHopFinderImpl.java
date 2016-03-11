package vn.dtt.sol.ns.baocaodli.dao.service.persistence;



import java.util.List;

import vn.dtt.sol.ns.baocaodli.dao.model.BaoCaoDLITongHop;
import vn.dtt.sol.ns.baocaodli.dao.model.impl.BaoCaoDLITongHopImpl;
import vn.dtt.sol.ns.util.format.FormatData;

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

public class BaoCaoDLITongHopFinderImpl extends BasePersistenceImpl<BaoCaoDLITongHop> implements BaoCaoDLITongHopFinder {
	private static final Log _log = LogFactoryUtil.getLog(BaoCaoDLITongHopFinderImpl.class);
	/**
	 * @author tailt
	 * @param maTinh
	 * @param namBaoCao
	 * @return
	 */
	
	public BaoCaoDLITongHop getBaoCaoDLITongHopByTinhVaNam(String maTinh, String namBaoCao){
		List<BaoCaoDLITongHop>  result = null;
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT * FROM ME_TONGHOPDLI ");
			query.append(" WHERE 1=1 ");
			if(Validator.isNotNull(maTinh)){
				query.append(" AND MATINH =  ? ");
			}
			if(Validator.isNotNull(namBaoCao)){
				if(namBaoCao.equalsIgnoreCase("0")){
					query.append(" AND ( NAM =  ? OR NAM =  ? ) ");
				}else{
					query.append(" AND NAM = ? ");
				}
			}
			
			query.append(" ORDER BY NAM, MATINH ASC  ");
			_log.info("==getBaoCaoDLITongHopByTinhVaNam==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addEntity(BaoCaoDLITongHopImpl.TABLE_NAME,BaoCaoDLITongHopImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(namBaoCao)){
				if(namBaoCao.equalsIgnoreCase("0")){
					qPos.add(namBaoCao);
					qPos.add(FormatData.getCurrentYear());
				}else{
					qPos.add(namBaoCao);
				}
			}
			result = (List<BaoCaoDLITongHop>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			if (result != null && result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}
		
		return null;
	}
		
	public List<BaoCaoDLITongHop> getListBaoCaoDLITongHopByNamTW(String namBaoCao)  {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT * FROM ME_TONGHOPDLI ");
			query.append(" WHERE 1=1 ");
			
			if(Validator.isNotNull(namBaoCao)){
				query.append(" AND NAM = ? ");
			}
			query.append(" ORDER BY  MATINH ,NAM ASC ");
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(BaoCaoDLITongHopImpl.TABLE_NAME,BaoCaoDLITongHopImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			if(Validator.isNotNull(namBaoCao)){
				qPos.add(namBaoCao);
			}
			return (List<BaoCaoDLITongHop>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}
		
		return null;
	}	
	
	
	public int sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat(String maTinh, int namBaoCao, int namToiThieu,int is11TheoKeHoach,int is11ThucTe,int is12TheoKeHoach,int is12ThucTe,int is21TheoKeHoach ,int is22TheoKeHoach,int is31TheoKeHoach,int is31ThucTe,int is32TheoKeHoach,int is32ThucTe)	throws SystemException {
			Session session = null;
			try {
				session = openSession();
				StringBuilder query = new StringBuilder();
				
				query.append(" SELECT ");
				// dong 1, dli 1.1
				if(is11TheoKeHoach == 1){
					query.append(" SUM(soDauNoiTheoKeHoach) ");
				}
				if(is11ThucTe == 1){
					query.append(" SUM(sodaunoimoi) ");
				}
				// dong 2, dli 1.2
				if(is12TheoKeHoach == 1){
					query.append(" SUM(SONHATIEUHVSTHEOKEHOACH) ");
				}
				if(is12ThucTe == 1){
					query.append(" SUM(SONNHATIEUHVSMOI) ");
				}
				// dong 3, dli 2.1
				if(is21TheoKeHoach == 1){
					query.append(" SUM(songuoihuongloinuocsach) ");
				}
				// 2.1 thuc te o cho khac
				// dong 4, dli 2.2
				if(is22TheoKeHoach == 1){
					query.append(" SUM(songuoihuongloivstx) ");
				}
				// 2.2 thuc te o cho khac
				// dong 5, dli 3.1
				if(is31TheoKeHoach == 1){
					query.append(" COUNT(kehoachpheduyet) ");
				}
				if(is31ThucTe == 1){
					query.append(" COUNT(ngayduyetkehoach) ");
				}
				// dong 6,dli 3.2
				if(is32TheoKeHoach == 1){
					query.append(" COUNT(baocaochuongtrinh) ");
				}
				if(is32ThucTe == 1){
					query.append(" COUNT(ngaydangtai) ");
				}
				query.append(" as total ");
				query.append(" FROM ME_TONGHOPDLI ");
				query.append(" WHERE 1 = 1 ");
				
				if(Validator.isNotNull(maTinh)){
					query.append(" AND MATINH = ? ");
				}				
				if( Validator.isNotNull(namToiThieu) && namToiThieu > 0
						&& Validator.isNotNull(namBaoCao) && namBaoCao > 0 ){
					query.append(" AND ( NAM >= ?");
					query.append(" AND NAM <= ? ) ");
				}
				
				
				_log.info("==sumBaoCaoDLITongHopByMaTinhNamGiaiDoanTuBaoCaoHopNhat==" + query.toString()+"--");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addScalar("total", Type.INTEGER);
				q.setCacheable(false);
				QueryPos qPos = QueryPos.getInstance(q);
				
				if(Validator.isNotNull(maTinh)){
					qPos.add(maTinh);
				}
				if( Validator.isNotNull(namToiThieu) && namToiThieu > 0
						&& Validator.isNotNull(namBaoCao) && namBaoCao > 0 ){
					qPos.add(namToiThieu);
					qPos.add(namBaoCao);
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
}
