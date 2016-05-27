package vn.dtt.sol.ns.tramcap.dao.service.persistence;

import java.util.List;

import vn.dtt.sol.ns.tramcap.dao.model.THONGTINKIEMDEMNUOC;
import vn.dtt.sol.ns.tramcap.dao.model.TramCapNuoc;
import vn.dtt.sol.ns.tramcap.dao.model.impl.DauNoiNuocImpl;
import vn.dtt.sol.ns.tramcap.dao.model.impl.THONGTINKIEMDEMNUOCImpl;
import vn.dtt.sol.ns.tramcap.dao.model.impl.TramCapNuocImpl;

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

public class THONGTINKIEMDEMNUOCFinderImpl extends BasePersistenceImpl<THONGTINKIEMDEMNUOC> implements THONGTINKIEMDEMNUOCFinder{
	private static final Log _log = LogFactoryUtil.getLog(THONGTINKIEMDEMNUOCFinderImpl.class);
	
	public List<THONGTINKIEMDEMNUOC> getThongTinDNNThoiGianThuc(String maTinh, String namBaoCao, String danhgiakiemdem,String daketthucdieutra) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT  k.* FROM ME_TRAMCAPNUOC as t ");
			query.append(" INNER JOIN ME_DAUNOINUOC as d ON t.ID = d.TRAMCAPNUOCID ");
			query.append(" INNER JOIN ME_THONGTINKIEMDEMNUOC as k ON d.ID = k.DAUNOINUOCID ");
			query.append(" WHERE 1=1 ");
			if (Validator.isNotNull(maTinh)) {
				query.append(" AND d.MATINH =  ? ");
			}
			if (Validator.isNotNull(namBaoCao)) {
				query.append(" AND YEAR(k.ThoiGianDauNoiThucTe) =  ? ");
			}
			if (Validator.isNotNull(danhgiakiemdem)) {
				query.append(" AND k.DANHGIAKIEMDEM = ? ");
			}
			if (Validator.isNotNull(daketthucdieutra)) {
				query.append(" AND k.DAKETTHUCDIEUTRA = ? ");
			}
			query.append(" ORDER BY  t.ID, t.MAHUYEN, t.MAXA  ASC ");
			
			_log.info("==getThongTinDNNThoiGianThuc==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(THONGTINKIEMDEMNUOCImpl.TABLE_NAME, THONGTINKIEMDEMNUOCImpl.class);

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
			return (List<THONGTINKIEMDEMNUOC>) QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

		
	}
	
	public List<THONGTINKIEMDEMNUOC> getThongTinDNNTHVGGroupByMaTinh(String maTinh, String namDauNoiThucTe, String danhgiakiemdem,String daketthucdieutra) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT  * ");
			query.append(" FROM ME_THONGTINKIEMDEMNUOC ");
			query.append(" WHERE 1=1 ");
			if (Validator.isNotNull(maTinh)) {
				query.append(" AND MATINH =  ? ");
			}
			if (Validator.isNotNull(namDauNoiThucTe)) {
				query.append(" AND YEAR(ThoiGianDauNoiThucTe) =  ? ");
			}
			if (Validator.isNotNull(danhgiakiemdem)) {
				query.append(" AND DANHGIAKIEMDEM = ? ");
			}
			if (Validator.isNotNull(daketthucdieutra)) {
				query.append(" AND DAKETTHUCDIEUTRA = ? ");
			}
			query.append(" GROUP BY MATINH ");
			query.append(" ORDER BY MATINH, MAHUYEN, MAXA  ASC ");
			
			_log.info("==getThongTinDNNTHVGGroupByMaTinh==" + query.toString()+"--");
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(THONGTINKIEMDEMNUOCImpl.TABLE_NAME, THONGTINKIEMDEMNUOCImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}
			if (Validator.isNotNull(namDauNoiThucTe)) {
				qPos.add(namDauNoiThucTe);
			}
			if (Validator.isNotNull(danhgiakiemdem)) {
				qPos.add(danhgiakiemdem);
			}
			if (Validator.isNotNull(daketthucdieutra)) {
				qPos.add(daketthucdieutra);
			}
			return (List<THONGTINKIEMDEMNUOC>) QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

		
	}
	
	public int countGioiTinhChuHo(String maTinh, String namBaoCao, String gioiTinhChuHo, String danhGiaKiemDem, String daKetThucDieuTra) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT count(DISTINCT me_thongtinkiemdemnuoc.id) as total FROM me_thongtinkiemdemnuoc  ");
			query.append(" LEFT JOIN me_daunoinuoc ON me_thongtinkiemdemnuoc.daunoinuocid = me_daunoinuoc.ID  ");
			query.append(" join me_kehoachkiemdemnuoc on me_thongtinkiemdemnuoc.kehoachkiemdemnuocid = me_kehoachkiemdemnuoc.id ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND me_thongtinkiemdemnuoc.MATINH = ? ");
			}
			if(Validator.isNotNull(namBaoCao)){
				query.append(" AND me_kehoachkiemdemnuoc.NAM = ? ");
				query.append(" AND YEAR(me_thongtinkiemdemnuoc.THOIGIANDAUNOITHUCTE) =  ? ");
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				query.append(" AND me_thongtinkiemdemnuoc.GIOITINHCHUHO = ? ");
			}
			if (Validator.isNotNull(danhGiaKiemDem)) {
				query.append(" AND me_thongtinkiemdemnuoc.DANHGIAKIEMDEM = ? ");
			}
			if (Validator.isNotNull(daKetThucDieuTra)) {
				query.append(" AND me_thongtinkiemdemnuoc.DAKETTHUCDIEUTRA = ? ");
			}
			
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
			if(Validator.isNotNull(danhGiaKiemDem)){
				qPos.add(danhGiaKiemDem);
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				qPos.add(daKetThucDieuTra);
			}
			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(lstTotal) && Validator.isNotNull(lstTotal.get(0))) {
				return lstTotal.get(0);
			}
			
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}
		return 0;
	}
	
	public int countGioiTinhChuHoBaoCaoHopNhat(String maTinh, int namBaoCao,int namToiThieu, String gioiTinhChuHo, String danhGiaKiemDem, String daKetThucDieuTra) {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append(" SELECT count(DISTINCT me_thongtinkiemdemnuoc.id) as total FROM me_thongtinkiemdemnuoc  ");
			query.append(" LEFT JOIN me_daunoinuoc ON me_thongtinkiemdemnuoc.daunoinuocid = me_daunoinuoc.ID  ");
			query.append(" join me_kehoachkiemdemnuoc on me_thongtinkiemdemnuoc.kehoachkiemdemnuocid = me_kehoachkiemdemnuoc.id ");
			query.append(" WHERE 1 = 1 ");
			
			if(Validator.isNotNull(maTinh)){
				query.append(" AND me_thongtinkiemdemnuoc.MATINH = ? ");
			}
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0){
				query.append(" AND ( me_kehoachkiemdemnuoc.NAM >= ? AND me_kehoachkiemdemnuoc.NAM <= ? )");
				query.append(" AND ( YEAR(me_thongtinkiemdemnuoc.THOIGIANDAUNOITHUCTE) >= ? AND YEAR(me_thongtinkiemdemnuoc.THOIGIANDAUNOITHUCTE) <= ? ) ");
			}
			if(Validator.isNotNull(gioiTinhChuHo)){
				query.append(" AND me_thongtinkiemdemnuoc.GIOITINHCHUHO = ? ");
			}
			if (Validator.isNotNull(danhGiaKiemDem)) {
				query.append(" AND me_thongtinkiemdemnuoc.DANHGIAKIEMDEM = ? ");
			}
			if (Validator.isNotNull(daKetThucDieuTra)) {
				query.append(" AND me_thongtinkiemdemnuoc.DAKETTHUCDIEUTRA = ? ");
			}
			
			SQLQuery q = session.createSQLQuery(query.toString());
			_log.info("--countGioiTinhChuHoBaoCaoHopNhat--"+query.toString()+"===");
			
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
			if(Validator.isNotNull(danhGiaKiemDem)){
				qPos.add(danhGiaKiemDem);
			}
			if(Validator.isNotNull(daKetThucDieuTra)){
				qPos.add(daKetThucDieuTra);
			}
			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(lstTotal) && Validator.isNotNull(lstTotal.get(0))) {
				return lstTotal.get(0);
			}
			
		} catch (Exception e) {
			_log.error(e);
		} finally {
			closeSession(session);
		}
		return 0;
	}
	
	public List<THONGTINKIEMDEMNUOC> getThongTinDNNTHVGGroupByMaTinhBaoCaoHopNhatTU(String maTinh, int namBaoCao,int namToiThieu, String danhgiakiemdem,String daketthucdieutra) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT  * ");
			query.append(" FROM ME_THONGTINKIEMDEMNUOC ");
			query.append(" WHERE 1=1 ");
			if (Validator.isNotNull(maTinh)) {
				query.append(" AND MATINH =  ? ");
			}
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0){
				query.append(" AND ( YEAR(THOIGIANDAUNOITHUCTE) >= ? AND YEAR(THOIGIANDAUNOITHUCTE) <= ? ) ");
			}
			if (Validator.isNotNull(danhgiakiemdem)) {
				query.append(" AND DANHGIAKIEMDEM = ? ");
			}
			if (Validator.isNotNull(daketthucdieutra)) {
				query.append(" AND DAKETTHUCDIEUTRA = ? ");
			}
			query.append(" GROUP BY MATINH ");
			query.append(" ORDER BY MATINH, MAHUYEN, MAXA  ASC ");
			
			_log.info("==getThongTinDNNTHVGGroupByMaTinhBaoCaoHopNhatTU==" + query.toString()+"--");
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(THONGTINKIEMDEMNUOCImpl.TABLE_NAME, THONGTINKIEMDEMNUOCImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}
			if(Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0){
				qPos.add(namToiThieu);
				qPos.add(namBaoCao);
			}
			if (Validator.isNotNull(danhgiakiemdem)) {
				qPos.add(danhgiakiemdem);
			}
			if (Validator.isNotNull(daketthucdieutra)) {
				qPos.add(daketthucdieutra);
			}
			return (List<THONGTINKIEMDEMNUOC>) QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			_log.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

		
	}
	
	
	public THONGTINKIEMDEMNUOC getDauNoiNuocBaoCaoSearchHelp(String maTinh, String maHuyen,String maXa,String maTramCap,String dauNoiNuocId) throws SystemException {
		Session session = null;
		List<THONGTINKIEMDEMNUOC> result = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			query.append(" SELECT me_thongtinkiemdemnuoc.*  ");
			query.append(" FROM  me_daunoinuoc ");
			query.append(" LEFT JOIN me_thongtinkiemdemnuoc ON  me_daunoinuoc.ID = me_thongtinkiemdemnuoc.daunoinuocid ");
			query.append(" LEFT JOIN me_kiemdemvien ON  me_thongtinkiemdemnuoc.taikhoan = me_kiemdemvien.TAIKHOAN ");
			query.append(" WHERE 1 = 1 ");
			
			
			
			if (Validator.isNotNull(maTinh)) {
				query.append(" AND me_thongtinkiemdemnuoc.MATINH = ?  ");
			}
			if (Validator.isNotNull(maHuyen)) {
				query.append(" AND me_thongtinkiemdemnuoc.MAHUYEN = ?  ");
			}
			if (Validator.isNotNull(maXa)) {
				query.append(" AND me_thongtinkiemdemnuoc.MAXA = ?  ");
			}
			if (Validator.isNotNull(maTramCap)) {
				query.append(" AND me_daunoinuoc.TRAMCAPNUOCID = ?  ");
			}
			if (Validator.isNotNull(dauNoiNuocId)) {
				query.append(" AND me_thongtinkiemdemnuoc.daunoinuocid = ?  ");
			}
			//_log.info("=========getDanhGiaBenVungByTramCapNuocAndNam==="+ query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(THONGTINKIEMDEMNUOCImpl.TABLE_NAME, THONGTINKIEMDEMNUOCImpl.class);

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
			if (Validator.isNotNull(maTramCap)) {
				qPos.add(maTramCap);
			}
			if (Validator.isNotNull(dauNoiNuocId)) {
				qPos.add(dauNoiNuocId);
			}

			result = (List<THONGTINKIEMDEMNUOC>) QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	
}
