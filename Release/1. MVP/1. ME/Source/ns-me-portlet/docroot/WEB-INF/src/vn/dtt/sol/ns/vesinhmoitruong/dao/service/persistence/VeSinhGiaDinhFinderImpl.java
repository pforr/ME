package vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence;

import java.util.Calendar;
import java.util.List;

import vn.dtt.sol.ns.util.format.FormatData;
import vn.dtt.sol.ns.vesinhmoitruong.dao.model.VeSinhGiaDinh;
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

public class VeSinhGiaDinhFinderImpl extends BasePersistenceImpl<VeSinhGiaDinh> implements VeSinhGiaDinhFinder{
	public int countVeSinhGiaDinhSearch(String maTinh,String maHuyen,String maXa,String loaiNhaTieuId,String trangThai,String namBaoCao,String namBaoCaoVstx) throws SystemException {
		return countVeSinhGiaDinhSearch_(maTinh, maHuyen, maXa, loaiNhaTieuId, trangThai, namBaoCao, namBaoCaoVstx);
	}
	private int countVeSinhGiaDinhSearch_(String maTinh,String maHuyen,String maXa,String loaiNhaTieuId,String trangThai,String namBaoCao, String namBaoCaoVstx) throws SystemException {
		Session session = null;
		try {
			int year = Calendar.getInstance().get(Calendar.YEAR);
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT count(*) as total ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh))query.append(" AND MATINH = ? ");
			if(Validator.isNotNull(maHuyen))query.append(" AND MAHUYEN = ? ");
			if(Validator.isNotNull(maXa))query.append(" AND MAXA = ? ");
			
			if(Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")){
				if(Validator.isNotNull(trangThai) && trangThai.equals("0")){
					query.append(" AND ( ( TRANGTHAI = 0 OR TRANGTHAI = 3 OR TRANGTHAI = 4 OR TRANGTHAI = 8 ) ");
					query.append(" AND (NAMXAYDUNG = ? OR MAUNGAUNHIEN = ? ) )");
				}else{
					query.append(" AND TRANGTHAI = ? ");
				}
			}else{
				if(Validator.isNotNull(trangThai))query.append(" AND TRANGTHAI = ? ");
				if(Validator.isNotNull(namBaoCao))query.append(" AND NAMBAOCAO = ? ");
			}
			if(Validator.isNotNull(namBaoCaoVstx) && namBaoCaoVstx.equalsIgnoreCase("xaymoi")){
				if(Validator.isNotNull(namBaoCao) && !namBaoCao.contains("9999"))query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND NAMXAYDUNG = ? ");
			}if(Validator.isNotNull(namBaoCaoVstx) && namBaoCaoVstx.equalsIgnoreCase("vstx")){
				if(Validator.isNotNull(namBaoCao) && !namBaoCao.contains("9999"))query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND ( NAMXAYDUNG < ? OR NAMXAYDUNG is null ) ");
			}
			if(Validator.isNotNull(loaiNhaTieuId))query.append(" AND LOAINHATIEU = ? ");
			_log.info("Danh GIa Count ==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh))qPos.add(maTinh);
			if(Validator.isNotNull(maHuyen))qPos.add(maHuyen);
			if(Validator.isNotNull(maXa))qPos.add(maXa);
			
			if(Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")){
				if(Validator.isNotNull(trangThai) && trangThai.equals("0")){
					qPos.add(namBaoCao.replaceAll("9999", ""));
					qPos.add(namBaoCao.replaceAll("9999", ""));
				}else{
					qPos.add(Long.valueOf(trangThai));
				}
			}else{
				if(Validator.isNotNull(trangThai))qPos.add(Long.valueOf(trangThai));
				if(Validator.isNotNull(namBaoCao))qPos.add(Long.valueOf(namBaoCao));
			}
			if(Validator.isNotNull(namBaoCaoVstx) && namBaoCaoVstx.equalsIgnoreCase("xaymoi")){
				if(Validator.isNotNull(namBaoCao) && !namBaoCao.contains("9999"))qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year));
			}if(Validator.isNotNull(namBaoCaoVstx) && namBaoCaoVstx.equalsIgnoreCase("vstx")){
				if(Validator.isNotNull(namBaoCao) && !namBaoCao.contains("9999"))qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year));
			}
			
			if(Validator.isNotNull(loaiNhaTieuId))qPos.add(Long.valueOf(loaiNhaTieuId));
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
	public List<VeSinhGiaDinh> getVeSinhGiaDinhSearch(String maTinh,String maHuyen,String maXa,String loaiNhaTieuId,String trangThai,String namBaoCao, String namBaoCaoVstx,int start,int end) throws SystemException {
		return getVeSinhGiaDinhSearch_(maTinh, maHuyen, maXa, loaiNhaTieuId, trangThai, namBaoCao, namBaoCaoVstx, start, end);
	}
	private List<VeSinhGiaDinh> getVeSinhGiaDinhSearch_(String maTinh,String maHuyen,String maXa,String loaiNhaTieuId,String trangThai,String namBaoCao, String namBaoCaoVstx,int start,int end) throws SystemException {
		Session session = null;
		try {
			int year = Calendar.getInstance().get(Calendar.YEAR);
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT * ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh))query.append(" AND MATINH = ? ");
			if(Validator.isNotNull(maHuyen))query.append(" AND MAHUYEN = ? ");
			if(Validator.isNotNull(maXa))query.append(" AND MAXA = ? ");
			
			if(Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")){
				if(Validator.isNotNull(trangThai) && trangThai.equals("0")){
					query.append(" AND ( ( TRANGTHAI = 0 OR TRANGTHAI = 3 OR TRANGTHAI = 4 OR TRANGTHAI = 8 ) ");
					query.append(" AND (NAMXAYDUNG = ? OR MAUNGAUNHIEN = ? ) )");
				}else{
					query.append(" AND TRANGTHAI = ? ");
				}
				
			}else{
				if(Validator.isNotNull(trangThai))query.append(" AND TRANGTHAI = ? ");
				if(Validator.isNotNull(namBaoCao))query.append(" AND NAMBAOCAO = ? ");
			}
			if(Validator.isNotNull(namBaoCaoVstx) && namBaoCaoVstx.equalsIgnoreCase("xaymoi")){
				if(Validator.isNotNull(namBaoCao) && !namBaoCao.contains("9999"))query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND NAMXAYDUNG = ? ");
			}if(Validator.isNotNull(namBaoCaoVstx) && namBaoCaoVstx.equalsIgnoreCase("vstx")){
				if(Validator.isNotNull(namBaoCao) && !namBaoCao.contains("9999"))query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND ( NAMXAYDUNG < ? OR NAMXAYDUNG is null ) ");
			}
			if(Validator.isNotNull(loaiNhaTieuId))query.append(" AND LOAINHATIEU = ? ");
			query.append(" ORDER BY MATINH , MAHUYEN , MAXA , THONXOM , LOAINHATIEU , TENCHUHO, TRANGTHAI, NAMBAOCAO ");
			_log.info("=vesGiadinh=" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity("VeSinhGiaDinh",VeSinhGiaDinhImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh))qPos.add(maTinh);
			if(Validator.isNotNull(maHuyen))qPos.add(maHuyen);
			if(Validator.isNotNull(maXa))qPos.add(maXa);
			
			if(Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")){
				if(Validator.isNotNull(trangThai) && trangThai.equals("0")){
					qPos.add(namBaoCao.replaceAll("9999", ""));
					qPos.add(namBaoCao.replaceAll("9999", ""));
				}else{
					qPos.add(Long.valueOf(trangThai));
				}
				
			}else{
				if(Validator.isNotNull(trangThai))qPos.add(Long.valueOf(trangThai));
				if(Validator.isNotNull(namBaoCao))qPos.add(Long.valueOf(namBaoCao));
			}
			if(Validator.isNotNull(namBaoCaoVstx) && namBaoCaoVstx.equalsIgnoreCase("xaymoi")){
				if(Validator.isNotNull(namBaoCao) && !namBaoCao.contains("9999"))qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year));
			}if(Validator.isNotNull(namBaoCaoVstx) && namBaoCaoVstx.equalsIgnoreCase("vstx")){
				if(Validator.isNotNull(namBaoCao) && !namBaoCao.contains("9999"))qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year));
			}
			
			if(Validator.isNotNull(loaiNhaTieuId))qPos.add(Long.valueOf(loaiNhaTieuId));
			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(),  start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	
	/**
	 * @author tailt
	 * @param maTinh
	 * @param maHuyen
	 * @param maXa
	 * @param loaiNhaTieuId
	 * @param trangThai
	 * @param namBaoCao
	 * @return
	 * @throws SystemException
	 */
	public List<VeSinhGiaDinh> getVeSinhGiaDinhGroupByMaHuyen(String maTinh,String maHuyen,String maXa,String loaiNhaTieuId,String trangThai,String namBaoCao) throws SystemException {
		return getVeSinhGiaDinhGroupByMaHuyen_(maTinh, maHuyen, maXa, loaiNhaTieuId, trangThai, namBaoCao);
	}
	
	private List<VeSinhGiaDinh> getVeSinhGiaDinhGroupByMaHuyen_(String maTinh,String maHuyen,String maXa,String loaiNhaTieuId,String trangThai,String namBaoCao) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT * ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh))query.append(" AND MATINH = ? ");
			if(Validator.isNotNull(maHuyen))query.append(" AND MAHUYEN = ? ");
			if(Validator.isNotNull(maXa))query.append(" AND MAXA = ? ");
			if(Validator.isNotNull(loaiNhaTieuId))query.append(" AND LOAINHATIEU = ? ");
			if(Validator.isNotNull(trangThai))query.append(" AND TRANGTHAI = ? ");
			if(Validator.isNotNull(namBaoCao) ){
				if(namBaoCao.equals("9999")){
					query.append(" AND ( TRANGTHAI = 0 OR TRANGTHAI = 3 OR TRANGTHAI = 4 OR TRANGTHAI = 8 ) ");
					query.append(" AND NAMBAOCAO = ? ");
				}else{
					if(namBaoCao.equalsIgnoreCase("0")){
						query.append(" AND ( NAMBAOCAO =  ? OR NAMBAOCAO =  ? ) ");
					}else{
						query.append(" AND NAMBAOCAO = ? ");
					}
					
				}
			}
			
			query.append(" GROUP BY MAHUYEN, MAXA ");//them maxa
			query.append(" ORDER BY NAMBAOCAO, MATINH , MAHUYEN , MAXA , THONXOM , LOAINHATIEU , TENCHUHO, TRANGTHAI  ");
			
			_log.debug("=getVeSinhGiaDinhGroupByMaHuyen==" + query.toString());
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(VeSinhGiaDinhImpl.TABLE_NAME,VeSinhGiaDinhImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			if(Validator.isNotNull(maTinh))qPos.add(maTinh);
			if(Validator.isNotNull(maHuyen))qPos.add(maHuyen);
			if(Validator.isNotNull(maXa))qPos.add(maXa);
			if(Validator.isNotNull(loaiNhaTieuId))qPos.add(Long.valueOf(loaiNhaTieuId));
			if(Validator.isNotNull(trangThai))qPos.add(Long.valueOf(trangThai));
			if(Validator.isNotNull(namBaoCao) ){
				if(namBaoCao.equals("9999")){
					qPos.add(0);
				}else{
					if(namBaoCao.equalsIgnoreCase("0")){
						qPos.add(namBaoCao);
						qPos.add(FormatData.getCurrentYear());
					}else{
						qPos.add(Long.valueOf(namBaoCao));
					}
					
				}	
			}
			
			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(),   QueryUtil.ALL_POS,  QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	Log _log = LogFactoryUtil.getLog(VeSinhGiaDinhFinderImpl.class);
}
