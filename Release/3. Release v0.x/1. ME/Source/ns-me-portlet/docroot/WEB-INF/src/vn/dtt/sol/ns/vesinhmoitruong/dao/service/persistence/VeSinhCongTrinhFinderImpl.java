package vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence;

import java.util.List;

import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhCongTrinh;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhGiaDinh;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.impl.VeSinhCongTrinhImpl;
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

public class VeSinhCongTrinhFinderImpl extends BasePersistenceImpl<VeSinhCongTrinh> implements VeSinhCongTrinhFinder{
	public int countVeSinhCongTrinhSearch(String maTinh,String maHuyen,String maXa,String loaiNhaTieuId,String loaiCongTrinh,String trangThai,String namBaoCao) throws SystemException {
		return countVeSinhCongTrinhSearch_(maTinh, maHuyen, maXa, loaiNhaTieuId, loaiCongTrinh, trangThai, namBaoCao);
	}
	private int countVeSinhCongTrinhSearch_(String maTinh,String maHuyen,String maXa,String loaiNhaTieuId,String loaiCongTrinh, String trangThai,String namBaoCao) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT count(*) as total ");
			query.append(" FROM me_vesinhcongtrinh ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh))query.append(" AND MATINH = ? ");
			if(Validator.isNotNull(maHuyen))query.append(" AND MAHUYEN = ? ");
			if(Validator.isNotNull(maXa))query.append(" AND MAXA = ? ");
			
			if(Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")){
				if(Validator.isNotNull(trangThai) && trangThai.equals("0")){
					query.append(" AND ( TRANGTHAI = 0 OR TRANGTHAI = 3 OR TRANGTHAI = 4 OR TRANGTHAI = 8 ) ");
				}else{
					query.append(" AND TRANGTHAI = ? ");
				}
			}else{
				if(Validator.isNotNull(trangThai))query.append(" AND TRANGTHAI = ? ");
				if(Validator.isNotNull(namBaoCao))query.append(" AND NAMBAOCAO = ? ");
			}
			if(Validator.isNotNull(loaiNhaTieuId))query.append(" AND LOAINHATIEU = ? ");
			if(Validator.isNotNull(loaiCongTrinh))query.append(" AND LOAICONGTRINH = ? ");
			_log.info("==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh))qPos.add(maTinh);
			if(Validator.isNotNull(maHuyen))qPos.add(maHuyen);
			if(Validator.isNotNull(maXa))qPos.add(maXa);
			
			if(Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")){
				if(Validator.isNotNull(trangThai) && trangThai.equals("0")){
					
				}else{
					qPos.add(Long.valueOf(trangThai));
				}
			}else{
				if(Validator.isNotNull(trangThai))qPos.add(Long.valueOf(trangThai));
				if(Validator.isNotNull(namBaoCao))qPos.add(Long.valueOf(namBaoCao));
			}
			if(Validator.isNotNull(loaiNhaTieuId))qPos.add(Long.valueOf(loaiNhaTieuId));
			if(Validator.isNotNull(loaiCongTrinh))qPos.add(Long.valueOf(loaiCongTrinh));
			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (lstTotal != null) {
				return lstTotal.get(0);
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	public List<VeSinhCongTrinh> getVeSinhCongTrinhSearch(String maTinh,String maHuyen,String maXa,String loaiNhaTieuId, String loaiCongTrinh,String trangThai,String namBaoCao,int start,int end) throws SystemException {
		return getVeSinhCongTrinhSearch_(maTinh, maHuyen, maXa, loaiNhaTieuId, loaiCongTrinh, trangThai, namBaoCao, start, end);
	}
	private List<VeSinhCongTrinh> getVeSinhCongTrinhSearch_(String maTinh,String maHuyen,String maXa,String loaiNhaTieuId, String loaiCongTrinh,String trangThai,String namBaoCao,int start,int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT * ");
			query.append(" FROM me_vesinhcongtrinh ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh))query.append(" AND MATINH = ? ");
			if(Validator.isNotNull(maHuyen))query.append(" AND MAHUYEN = ? ");
			if(Validator.isNotNull(maXa))query.append(" AND MAXA = ? ");
			
			if(Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")){
				if(Validator.isNotNull(trangThai) && trangThai.equals("0")){
					query.append(" AND ( TRANGTHAI = 0 OR TRANGTHAI = 3 OR TRANGTHAI = 4 OR TRANGTHAI = 8 ) ");
				}else{
					query.append(" AND TRANGTHAI = ? ");
				}
//				query.append(" AND NAMBAOCAO = ? ");
			}else{
				if(Validator.isNotNull(trangThai))query.append(" AND TRANGTHAI = ? ");
				if(Validator.isNotNull(namBaoCao))query.append(" AND NAMBAOCAO = ? ");
			}
			if(Validator.isNotNull(loaiNhaTieuId))query.append(" AND LOAINHATIEU = ? ");
			if(Validator.isNotNull(loaiCongTrinh))query.append(" AND LOAICONGTRINH = ? ");
			query.append(" ORDER BY MATINH , MAHUYEN , MAXA , DIACHI , LOAINHATIEU , TENCONGTRINH, LOAICONGTRINH, TRANGTHAI, NAMBAOCAO ");
			_log.debug("==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity("VeSinhCongTrinh",VeSinhCongTrinhImpl.class);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh))qPos.add(maTinh);
			if(Validator.isNotNull(maHuyen))qPos.add(maHuyen);
			if(Validator.isNotNull(maXa))qPos.add(maXa);
			
			if(Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")){
				if(Validator.isNotNull(trangThai) && trangThai.equals("0")){
					
				}else{
					qPos.add(Long.valueOf(trangThai));
				}
//				qPos.add(0);
			}else{
				if(Validator.isNotNull(trangThai))qPos.add(Long.valueOf(trangThai));
				if(Validator.isNotNull(namBaoCao))qPos.add(Long.valueOf(namBaoCao));
			}
			if(Validator.isNotNull(loaiNhaTieuId))qPos.add(Long.valueOf(loaiNhaTieuId));
			if(Validator.isNotNull(loaiCongTrinh))qPos.add(Long.valueOf(loaiCongTrinh));
			return (List<VeSinhCongTrinh>) QueryUtil.list(q, getDialect(),  start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	Log _log = LogFactoryUtil.getLog(VeSinhCongTrinhFinderImpl.class);
}
