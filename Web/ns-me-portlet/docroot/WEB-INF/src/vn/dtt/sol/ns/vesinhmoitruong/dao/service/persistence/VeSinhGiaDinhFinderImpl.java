package vn.dtt.sol.ns.vesinhmoitruong.dao.service.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class VeSinhGiaDinhFinderImpl extends BasePersistenceImpl<VeSinhGiaDinh>
		implements VeSinhGiaDinhFinder {
	
	public int countVeSinhGiaDinhSearch(String maTinh, String maHuyen,
			String maXa, String loaiNhaTieuId, String trangThai,
			String namBaoCao, String namBaoCaoVstx) throws SystemException {
		return countVeSinhGiaDinhSearch_(maTinh, maHuyen, maXa, loaiNhaTieuId,
				trangThai, namBaoCao, namBaoCaoVstx);
	}

	private int countVeSinhGiaDinhSearch_(String maTinh, String maHuyen,
			String maXa, String loaiNhaTieuId, String trangThai,
			String namBaoCao, String namBaoCaoVstx) throws SystemException {
		Session session = null;
		try {
			int year = Calendar.getInstance().get(Calendar.YEAR);
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT count(*) as total ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh))
				query.append(" AND MATINH = ? ");
			if (Validator.isNotNull(maHuyen))
				query.append(" AND MAHUYEN = ? ");
			if (Validator.isNotNull(maXa))
				query.append(" AND MAXA = ? ");

			if (Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")) {
				if (Validator.isNotNull(trangThai) && trangThai.equals("0")) {
					query.append(" AND ( ( TRANGTHAI = 0 OR TRANGTHAI = 3 OR TRANGTHAI = 4 OR TRANGTHAI = 8 ) ");
					query.append(" AND (NAMXAYDUNG = ? OR MAUNGAUNHIEN = ? ) )");
				} else {
					query.append(" AND TRANGTHAI = ? ");
				}
			} else {
				if (Validator.isNotNull(trangThai))
					query.append(" AND TRANGTHAI = ? ");
				if (Validator.isNotNull(namBaoCao))
					query.append(" AND NAMBAOCAO = ? ");
			}
			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("xaymoi")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND NAMXAYDUNG = ? ");
			}
			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("vstx")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND ( NAMXAYDUNG < ? OR NAMXAYDUNG is null ) ");
			}
			if (Validator.isNotNull(loaiNhaTieuId))
				query.append(" AND LOAINHATIEU = ? ");
			_log.info("Danh GIa Count ==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh))
				qPos.add(maTinh);
			if (Validator.isNotNull(maHuyen))
				qPos.add(maHuyen);
			if (Validator.isNotNull(maXa))
				qPos.add(maXa);

			if (Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")) {
				if (Validator.isNotNull(trangThai) && trangThai.equals("0")) {
					qPos.add(namBaoCao.replaceAll("9999", ""));
					qPos.add(namBaoCao.replaceAll("9999", ""));
				} else {
					qPos.add(Long.valueOf(trangThai));
				}
			} else {
				if (Validator.isNotNull(trangThai))
					qPos.add(Long.valueOf(trangThai));
				if (Validator.isNotNull(namBaoCao))
					qPos.add(Long.valueOf(namBaoCao));
			}
			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("xaymoi")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year));
			}
			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("vstx")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year));
			}

			if (Validator.isNotNull(loaiNhaTieuId))
				qPos.add(Long.valueOf(loaiNhaTieuId));
			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q,
					getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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

	public List<VeSinhGiaDinh> getVeSinhGiaDinhSearch(String maTinh,
			String maHuyen, String maXa, String loaiNhaTieuId,
			String trangThai, String namBaoCao, String namBaoCaoVstx,
			int start, int end) throws SystemException {
		return getVeSinhGiaDinhSearch_(maTinh, maHuyen, maXa, loaiNhaTieuId,
				trangThai, namBaoCao, namBaoCaoVstx, start, end);
	}

	private List<VeSinhGiaDinh> getVeSinhGiaDinhSearch_(String maTinh,
			String maHuyen, String maXa, String loaiNhaTieuId,
			String trangThai, String namBaoCao, String namBaoCaoVstx,
			int start, int end) throws SystemException {
		Session session = null;
		try {
			int year = Calendar.getInstance().get(Calendar.YEAR);
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT * ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh))
				query.append(" AND MATINH = ? ");
			if (Validator.isNotNull(maHuyen))
				query.append(" AND MAHUYEN = ? ");
			if (Validator.isNotNull(maXa))
				query.append(" AND MAXA = ? ");

			if (Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")) {
				if (Validator.isNotNull(trangThai) && trangThai.equals("0")) {
					query.append(" AND ( ( TRANGTHAI = 0 OR TRANGTHAI = 3 OR TRANGTHAI = 4 OR TRANGTHAI = 8 ) ");
					query.append(" AND (NAMXAYDUNG = ? OR MAUNGAUNHIEN = ? ) )");
				} else {
					query.append(" AND TRANGTHAI = ? ");
				}

			} else {
				if (Validator.isNotNull(trangThai))
					query.append(" AND TRANGTHAI = ? ");
				if (Validator.isNotNull(namBaoCao))
					query.append(" AND NAMBAOCAO = ? ");
			}
			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("xaymoi")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND NAMXAYDUNG = ? ");
			}
			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("vstx")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND ( NAMXAYDUNG < ? OR NAMXAYDUNG is null ) ");
			}
			if (Validator.isNotNull(loaiNhaTieuId))
				query.append(" AND LOAINHATIEU = ? ");
			query.append(" ORDER BY MATINH , MAHUYEN , MAXA , THONXOM , LOAINHATIEU , TENCHUHO, TRANGTHAI, NAMBAOCAO ");
			_log.info("=vesGiadinh=" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity("VeSinhGiaDinh", VeSinhGiaDinhImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh))
				qPos.add(maTinh);
			if (Validator.isNotNull(maHuyen))
				qPos.add(maHuyen);
			if (Validator.isNotNull(maXa))
				qPos.add(maXa);

			if (Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")) {
				if (Validator.isNotNull(trangThai) && trangThai.equals("0")) {
					qPos.add(namBaoCao.replaceAll("9999", ""));
					qPos.add(namBaoCao.replaceAll("9999", ""));
				} else {
					qPos.add(Long.valueOf(trangThai));
				}

			} else {
				if (Validator.isNotNull(trangThai))
					qPos.add(Long.valueOf(trangThai));
				if (Validator.isNotNull(namBaoCao))
					qPos.add(Long.valueOf(namBaoCao));
			}
			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("xaymoi")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year));
			}
			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("vstx")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year));
			}

			if (Validator.isNotNull(loaiNhaTieuId))
				qPos.add(Long.valueOf(loaiNhaTieuId));
			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(), start,
					end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countVeSinhGiaDinhSearch(String maTinh, String maHuyen,
			String maXa, String loaiNhaTieuId, String trangThai,
			String namBaoCao, String namBaoCaoVstx, String ngayNhap,
			String idNguoiTao, String advText) throws SystemException {
		return countVeSinhGiaDinhSearch_(maTinh, maHuyen, maXa, loaiNhaTieuId,
				trangThai, namBaoCao, namBaoCaoVstx, ngayNhap, idNguoiTao,
				advText);
	}

	private int countVeSinhGiaDinhSearch_(String maTinh, String maHuyen,
			String maXa, String loaiNhaTieuId, String trangThai,
			String namBaoCao, String namBaoCaoVstx, String ngayNhap,
			String idNguoiTao, String advText) throws SystemException {
		Session session = null;
		try {
			int year = Calendar.getInstance().get(Calendar.YEAR);
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT count(*) as total ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh))
				query.append(" AND MATINH = ? ");
			if (Validator.isNotNull(maHuyen))
				query.append(" AND MAHUYEN = ? ");
			if (Validator.isNotNull(maXa))
				query.append(" AND MAXA = ? ");

			if (Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")) {
				if (Validator.isNotNull(trangThai) && trangThai.equals("0")) {
					query.append(" AND ( ( TRANGTHAI = 0 OR TRANGTHAI = 3 OR TRANGTHAI = 4 OR TRANGTHAI = 8 ) ");
					query.append(" AND (NAMXAYDUNG = ? OR MAUNGAUNHIEN = ? ) )");
				} else {
					query.append(" AND TRANGTHAI = ? ");
				}
			} else {
				if (Validator.isNotNull(trangThai))
					query.append(" AND TRANGTHAI = ? ");
				if (Validator.isNotNull(namBaoCao))
					query.append(" AND NAMBAOCAO = ? ");
			}
			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("xaymoi")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND NAMXAYDUNG = ? ");
			}
			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("vstx")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND ( NAMXAYDUNG < ? OR NAMXAYDUNG is null ) ");
			}

			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("duphong")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND ( MAUNGAUNHIEN = ? ) ");
			}

			if (Validator.isNotNull(loaiNhaTieuId))
				query.append(" AND LOAINHATIEU = ? ");
			if (Validator.isNotNull(ngayNhap))
				query.append(" AND DATE_FORMAT(NGAYTAO, '%m/%d/%Y') = ? ");
			if (Validator.isNotNull(idNguoiTao))
				query.append(" AND IDNGUOITAO = ? ");
			if (Validator.isNotNull(advText))
				query.append(" AND ( THONXOM like ? OR TENCHUHO like ? ) ");
			_log.info("Danh GIa Count ==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh))
				qPos.add(maTinh);
			if (Validator.isNotNull(maHuyen))
				qPos.add(maHuyen);
			if (Validator.isNotNull(maXa))
				qPos.add(maXa);

			if (Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")) {
				if (Validator.isNotNull(trangThai) && trangThai.equals("0")) {
					qPos.add(namBaoCao.replaceAll("9999", ""));
					qPos.add(namBaoCao.replaceAll("9999", ""));
				} else {
					qPos.add(Long.valueOf(trangThai));
				}
			} else {
				if (Validator.isNotNull(trangThai))
					qPos.add(Long.valueOf(trangThai));
				if (Validator.isNotNull(namBaoCao))
					qPos.add(Long.valueOf(namBaoCao));
			}
			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("xaymoi")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year));
			}
			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("vstx")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year));
			}

			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("duphong")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year * 10));
			}

			if (Validator.isNotNull(loaiNhaTieuId))
				qPos.add(Long.valueOf(loaiNhaTieuId));
			if (Validator.isNotNull(ngayNhap))
				qPos.add(ngayNhap);
			if (Validator.isNotNull(idNguoiTao))
				qPos.add(idNguoiTao);
			if (Validator.isNotNull(advText)) {
				qPos.add(advText + StringPool.PERCENT);
				qPos.add(advText + StringPool.PERCENT);
			}
			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q,
					getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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

	public List<VeSinhGiaDinh> getVeSinhGiaDinhSearch(String maTinh,
			String maHuyen, String maXa, String loaiNhaTieuId,
			String trangThai, String namBaoCao, String namBaoCaoVstx,
			String ngayNhap, String idNguoiTao, String advText, int start,
			int end) throws SystemException {
		return getVeSinhGiaDinhSearch_(maTinh, maHuyen, maXa, loaiNhaTieuId,
				trangThai, namBaoCao, namBaoCaoVstx, ngayNhap, idNguoiTao,
				advText, start, end);
	}

	// TODO: here
	private List<VeSinhGiaDinh> getVeSinhGiaDinhSearch_(String maTinh,
			String maHuyen, String maXa, String loaiNhaTieuId,
			String trangThai, String namBaoCao, String namBaoCaoVstx,
			String ngayNhap, String idNguoiTao, String advText, int start,
			int end) throws SystemException {
		Session session = null;
		try {
			int year = Calendar.getInstance().get(Calendar.YEAR);
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT * ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh))
				query.append(" AND MATINH = ? ");
			if (Validator.isNotNull(maHuyen))
				query.append(" AND MAHUYEN = ? ");
			if (Validator.isNotNull(maXa))
				query.append(" AND MAXA = ? ");

			if (Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")) {
				if (Validator.isNotNull(trangThai) && trangThai.equals("0")) {
					query.append(" AND ( ( TRANGTHAI = 0 OR TRANGTHAI = 3 OR TRANGTHAI = 4 OR TRANGTHAI = 8 ) ");
					query.append(" AND (NAMXAYDUNG = ? OR MAUNGAUNHIEN = ? ) )");
				} else {
					query.append(" AND TRANGTHAI = ? ");
				}

			} else {
				if (Validator.isNotNull(trangThai))
					query.append(" AND TRANGTHAI = ? ");
				if (Validator.isNotNull(namBaoCao))
					query.append(" AND NAMBAOCAO = ? ");
			}
			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("xaymoi")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND NAMXAYDUNG = ? ");
			}

			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("vstx")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND ( NAMXAYDUNG < ? OR NAMXAYDUNG is null ) ");
			}

			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("duphong")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND ( MAUNGAUNHIEN = ? ) "); // TODO
			}

			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("rasoat")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND ( NAMXAYDUNG < ? OR NAMXAYDUNG is null ) ");
			}

			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("rasoatduphong")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND ( NAMXAYDUNG < ? OR NAMXAYDUNG is null ) ");
			}

			if (Validator.isNotNull(loaiNhaTieuId))
				query.append(" AND LOAINHATIEU = ? ");
			if (Validator.isNotNull(ngayNhap))
				query.append(" AND DATE_FORMAT(NGAYTAO, '%m/%d/%Y') = ? ");
			if (Validator.isNotNull(idNguoiTao))
				query.append(" AND IDNGUOITAO = ? ");
			if (Validator.isNotNull(advText))
				query.append(" AND ( THONXOM like ? OR TENCHUHO like ? ) ");
			query.append(" ORDER BY MATINH , MAHUYEN , MAXA , THONXOM , LOAINHATIEU , TENCHUHO, TRANGTHAI, NAMBAOCAO ");
			_log.info("=vesGiadinh=" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity("VeSinhGiaDinh", VeSinhGiaDinhImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh))
				qPos.add(maTinh);
			if (Validator.isNotNull(maHuyen))
				qPos.add(maHuyen);
			if (Validator.isNotNull(maXa))
				qPos.add(maXa);

			if (Validator.isNotNull(namBaoCao) && namBaoCao.contains("9999")) {
				if (Validator.isNotNull(trangThai) && trangThai.equals("0")) {
					qPos.add(namBaoCao.replaceAll("9999", ""));
					qPos.add(namBaoCao.replaceAll("9999", ""));
				} else {
					qPos.add(Long.valueOf(trangThai));
				}

			} else {
				if (Validator.isNotNull(trangThai))
					qPos.add(Long.valueOf(trangThai));
				if (Validator.isNotNull(namBaoCao))
					qPos.add(Long.valueOf(namBaoCao));
			}
			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("xaymoi")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year));
			}

			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("vstx")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year));
			}

			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("duphong")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year * 10));
			}

			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("rasoat")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year * 100));
			}

			if (Validator.isNotNull(namBaoCaoVstx)
					&& namBaoCaoVstx.equalsIgnoreCase("rasoatduphong")) {
				if (Validator.isNotNull(namBaoCao)
						&& !namBaoCao.contains("9999"))
					qPos.add(Long.valueOf(namBaoCao.replaceAll("9999", "")));
				qPos.add(Long.valueOf(year * 1000));
			}

			if (Validator.isNotNull(loaiNhaTieuId))
				qPos.add(Long.valueOf(loaiNhaTieuId));
			if (Validator.isNotNull(ngayNhap))
				qPos.add(ngayNhap);
			if (Validator.isNotNull(idNguoiTao))
				qPos.add(idNguoiTao);
			if (Validator.isNotNull(advText)) {
				qPos.add(advText + StringPool.PERCENT);
				qPos.add(advText + StringPool.PERCENT);
			}
			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(), start,
					end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countGioiTinhChuHo(String maTinh, String namBaoCao,
			String namXayDung, String gioiTinhChuHo, String trangThai)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT count(*) as total ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh)) {
				query.append(" AND MATINH = ? ");
			}

			if (Validator.isNotNull(namBaoCao)) {
				query.append(" AND NAMBAOCAO = ? ");
			}

			if (Validator.isNotNull(namXayDung)) {
				query.append(" AND NAMXAYDUNG = ? ");
			}
			if (Validator.isNotNull(gioiTinhChuHo)) {
				query.append(" AND GIOITINHCHUHO = ? ");
			}
			if (Validator.isNotNull(trangThai)) {
				query.append(" AND TRANGTHAI = ? ");
			}

			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh))
				qPos.add(maTinh);
			if (Validator.isNotNull(namBaoCao)) {
				qPos.add(namBaoCao);
			}
			if (Validator.isNotNull(namXayDung)) {
				qPos.add(namXayDung);
			}
			if (Validator.isNotNull(gioiTinhChuHo)) {
				qPos.add(gioiTinhChuHo);
			}
			if (Validator.isNotNull(trangThai)) {
				qPos.add(trangThai);
			}

			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q,
					getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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

	public List<VeSinhGiaDinh> getVeSinhGiaDinhGroupByMaTinhTW(String maTinh,
			String maHuyen, String maXa, String loaiNhaTieuId,
			String[] trangThai, String namBaoCao) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			
			query.append(" SELECT DISTINCT  me_vesinhgiadinh.* FROM me_vesinhgiadinh  ");
			query.append(" LEFT JOIN me_thongtinkiemdemhogd ON me_vesinhgiadinh.id = me_thongtinkiemdemhogd.vesinhgiadinhid  ");
			query.append(" join me_kehoachkiemdemvesinh on me_thongtinkiemdemhogd.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh)){
				query.append(" AND me_vesinhgiadinh.MATINH = ? ");
			}
			if (Validator.isNotNull(maHuyen)){
				query.append(" AND me_vesinhgiadinh.MAHUYEN = ? ");
			}
			if (Validator.isNotNull(maXa)){
				query.append(" AND me_vesinhgiadinh.MAXA = ? ");
			}
			if (Validator.isNotNull(loaiNhaTieuId))
				query.append(" AND me_vesinhgiadinh.LOAINHATIEU = ? ");
			

			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				query.append(" AND me_thongtinkiemdemhogd.danhgiakiemdem IN ( ");
				String temp = "";
				for (int i = 0; i < trangThai.length; i++) {
					temp += ",?";
				}
				temp = temp.replaceFirst(",", "");
				query.append(temp);
				query.append(" ) ");
			}			
			
			if (Validator.isNotNull(namBaoCao)) {
				
				query.append(" AND me_kehoachkiemdemvesinh.nam = ?  AND  me_thongtinkiemdemhogd.namxaydung = ? ");
			}
			query.append(" GROUP BY me_vesinhgiadinh.MATINH ");// them maxa
			query.append(" ORDER BY  me_vesinhgiadinh.MATINH , me_vesinhgiadinh.MAHUYEN , me_vesinhgiadinh.MAXA , me_vesinhgiadinh.THONXOM , me_vesinhgiadinh.tenchuho ");
			

/*			query.append(" SELECT * ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh))
				query.append(" AND MATINH = ? ");
			if (Validator.isNotNull(maHuyen))
				query.append(" AND MAHUYEN = ? ");
			if (Validator.isNotNull(maXa))
				query.append(" AND MAXA = ? ");
			if (Validator.isNotNull(loaiNhaTieuId))
				query.append(" AND LOAINHATIEU = ? ");
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				query.append(" AND TRANGTHAI IN ( ");
				String temp = "";
				for (int i = 0; i < trangThai.length; i++) {
					temp += ",?";
				}
				temp = temp.replaceFirst(",", "");
				query.append(temp);
				query.append(" ) ");
			}
			if (Validator.isNotNull(namBaoCao)) {

				query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND NAMXAYDUNG = ? ");
			}

			query.append(" GROUP BY MATINH ");
			query.append(" ORDER BY MATINH , MAHUYEN , MAXA , THONXOM , LOAINHATIEU , TENCHUHO, TRANGTHAI  ");*/

			_log.debug("=getVeSinhGiaDinhGroupByMaTinhTW==" + query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(VeSinhGiaDinhImpl.TABLE_NAME, VeSinhGiaDinhImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh))
				qPos.add(maTinh);
			if (Validator.isNotNull(maHuyen))
				qPos.add(maHuyen);
			if (Validator.isNotNull(maXa))
				qPos.add(maXa);
			if (Validator.isNotNull(loaiNhaTieuId))
				qPos.add(Long.valueOf(loaiNhaTieuId));
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				for (int i = 0; i < trangThai.length; i++) {
					qPos.add(trangThai[i].toString());
				}
			}
			if (Validator.isNotNull(namBaoCao)) {
				/*
				 * if (namBaoCao.equals("9999")) { qPos.add(0); } else { if
				 * (namBaoCao.equalsIgnoreCase("0")) { qPos.add(namBaoCao);
				 * qPos.add(FormatData.getCurrentYear()); } else {
				 * qPos.add(Long.valueOf(namBaoCao)); }
				 * 
				 * }
				 */
				qPos.add(namBaoCao);
				qPos.add(namBaoCao);
			}

			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(),
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List<VeSinhGiaDinh> getVeSinhGiaDinhGroupByMaHuyenMaXaAndMaXaNotInTW(
			String maTinh, String[] trangThai, String namBaoCao,
			String dangKyVSTX) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

				query.append(" SELECT DISTINCT  me_vesinhgiadinh.* FROM me_vesinhgiadinh  ");
				query.append(" LEFT JOIN me_thongtinkiemdemhogd ON me_vesinhgiadinh.id = me_thongtinkiemdemhogd.vesinhgiadinhid  ");
				query.append(" join me_kehoachkiemdemvesinh on me_thongtinkiemdemhogd.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id ");
				query.append(" WHERE 1 = 1 ");
				
				if (Validator.isNotNull(maTinh)){
					query.append(" AND me_vesinhgiadinh.MATINH = ? ");
				}
				
				
				if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
					query.append(" AND me_thongtinkiemdemhogd.danhgiakiemdem IN ( ");
					String temp = "";
					for (int i = 0; i < trangThai.length; i++) {
						temp += ",?";
					}
					temp = temp.replaceFirst(",", "");
					query.append(temp);
					query.append(" ) ");
				}			
				
				if (Validator.isNotNull(namBaoCao)) {
					
					query.append(" AND me_kehoachkiemdemvesinh.nam = ?  AND  me_thongtinkiemdemhogd.namxaydung = ? ");
				}		

				if (Validator.isNotNull(maTinh) && Validator.isNotNull(namBaoCao)
						&& Validator.isNotNull(dangKyVSTX)) {
					query.append(" AND me_vesinhgiadinh.MAXA NOT IN ( select k.maxa ");
					query.append(" from me_kehoachvesinhxa  as k ");
					query.append(" where k.matinh = ? and k.nam = ? and  k.DANGKYVSTX = ? ) ");
				}

/*
			query.append(" SELECT v.* ");
			query.append(" FROM me_vesinhgiadinh as v");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh)) {
				query.append(" AND v.MATINH = ? ");
			}
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				query.append(" AND v.TRANGTHAI IN ( ");
				String temp = "";
				for (int i = 0; i < trangThai.length; i++) {
					temp += ",?";
				}
				temp = temp.replaceFirst(",", "");
				query.append(temp);
				query.append(" ) ");
			}
			
			
			
			if (Validator.isNotNull(namBaoCao)) {
				query.append(" AND v.NAMXAYDUNG = ? ");
				query.append(" AND v.NAMBAOCAO = ? ");
			}
			if (Validator.isNotNull(maTinh) && Validator.isNotNull(namBaoCao)
					&& Validator.isNotNull(dangKyVSTX)) {
				query.append(" AND v.MAXA NOT IN ( select k.maxa ");
				query.append(" from me_kehoachvesinhxa  as k ");
				query.append(" where k.matinh = ? and k.nam = ? and  k.DANGKYVSTX = ? ) ");
			}
*/			query.append(" GROUP BY me_vesinhgiadinh.MAHUYEN, me_vesinhgiadinh.MAXA ");// them maxa
			query.append(" ORDER BY  me_vesinhgiadinh.MATINH , me_vesinhgiadinh.MAHUYEN , me_vesinhgiadinh.MAXA , me_vesinhgiadinh.THONXOM  ");

			_log.debug("=getVeSinhGiaDinhGroupByMaHuyenMaXaAndMaXaNotInTW=="
					+ query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(VeSinhGiaDinhImpl.TABLE_NAME, VeSinhGiaDinhImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)) {
				qPos.add(maTinh);
			}
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				for (int i = 0; i < trangThai.length; i++) {
					qPos.add(trangThai[i].toString());
				}
			}
			if (Validator.isNotNull(namBaoCao)) {
				qPos.add(namBaoCao);
				qPos.add(namBaoCao);
			}
			if (Validator.isNotNull(maTinh) && Validator.isNotNull(namBaoCao)
					&& Validator.isNotNull(dangKyVSTX)) {
				qPos.add(maTinh);
				qPos.add(namBaoCao);
				qPos.add(dangKyVSTX);
			}
			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(),
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countVeSinhGiaDinhGroupByMaHuyen(String maTinh, String maHuyen,
			String maXa, String[] trangThai, String namBaoCao)
			throws SystemException {
		Session session = null;
		try {


			int mauNgauNhien = 0;
			if(Validator.isNotNull(namBaoCao)){
				mauNgauNhien = Integer.parseInt(namBaoCao);
			}
			
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT count(DISTINCT  me_vesinhgiadinh.id) as total FROM me_vesinhgiadinh  ");
			query.append(" LEFT JOIN me_thongtinkiemdemhogd ON me_vesinhgiadinh.id = me_thongtinkiemdemhogd.vesinhgiadinhid  ");
			query.append(" join me_kehoachkiemdemvesinh on me_thongtinkiemdemhogd.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id ");
			query.append(" WHERE 1 = 1 ");

			
			
			
			if (Validator.isNotNull(maTinh)){
				query.append(" AND me_vesinhgiadinh.MATINH = ? ");
			}
			if (Validator.isNotNull(maHuyen)){
				query.append(" AND me_vesinhgiadinh.MAHUYEN = ? ");
			}
			if (Validator.isNotNull(maXa)){
				query.append(" AND me_vesinhgiadinh.MAXA = ? ");
			}
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				query.append(" AND me_thongtinkiemdemhogd.danhgiakiemdem IN ( ");
				String temp = "";
				for (int i = 0; i < trangThai.length; i++) {
					temp += ",?";
				}
				temp = temp.replaceFirst(",", "");
				query.append(temp);
				query.append(" ) ");
			}
			
			if (Validator.isNotNull(namBaoCao)) {
				
				query.append(" AND me_kehoachkiemdemvesinh.nam = ?  AND  me_thongtinkiemdemhogd.namxaydung = ? ");
				
			}
			
/*			query.append(" SELECT count(*) as total ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh))
				query.append(" AND MATINH = ? ");
			if (Validator.isNotNull(maHuyen))
				query.append(" AND MAHUYEN = ? ");
			if (Validator.isNotNull(maXa))
				query.append(" AND MAXA = ? ");

			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				query.append(" AND TRANGTHAI IN ( ");
				String temp = "";
				for (int i = 0; i < trangThai.length; i++) {
					temp += ",?";
				}
				temp = temp.replaceFirst(",", "");
				query.append(temp);
				query.append(" ) ");
			}
			if (Validator.isNotNull(namBaoCao)) {
				
				 * if (namBaoCao.equals("9999")) { query.append(
				 * " AND ( TRANGTHAI = 0 OR TRANGTHAI = 3 OR TRANGTHAI = 4 OR TRANGTHAI = 8 ) "
				 * ); query.append(" AND NAMBAOCAO = ? "); } else { if
				 * (namBaoCao.equalsIgnoreCase("0")) {
				 * query.append(" AND ( NAMBAOCAO =  ? OR NAMBAOCAO =  ? ) "); }
				 * else {
				 * 
				 * }
				 * 
				 * }
				 
				query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND NAMXAYDUNG = ? ");
			}*/
			_log.info("---countVeSinhGiaDinhGroupByMaHuyen ==" + query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh))
				qPos.add(maTinh);
			if (Validator.isNotNull(maHuyen))
				qPos.add(maHuyen);
			if (Validator.isNotNull(maXa))
				qPos.add(maXa);
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				for (int i = 0; i < trangThai.length; i++) {
					qPos.add(trangThai[i].toString());
				}
			}
			if (Validator.isNotNull(namBaoCao)) {
				/*
				 * if (namBaoCao.equals("9999")) { qPos.add(0); } else { if
				 * (namBaoCao.equalsIgnoreCase("0")) { qPos.add(namBaoCao);
				 * qPos.add(FormatData.getCurrentYear()); } else {
				 * qPos.add(namBaoCao); }
				 * 
				 * }
				 */
				qPos.add(namBaoCao);
				qPos.add(namBaoCao);
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
	public List<VeSinhGiaDinh> getVeSinhGiaDinhGroupByMaHuyen(String maTinh,
			String maHuyen, String maXa, String loaiNhaTieuId,
			String[] trangThai, String namBaoCao) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT * ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh))
				query.append(" AND MATINH = ? ");
			if (Validator.isNotNull(maHuyen))
				query.append(" AND MAHUYEN = ? ");
			if (Validator.isNotNull(maXa))
				query.append(" AND MAXA = ? ");
			if (Validator.isNotNull(loaiNhaTieuId))
				query.append(" AND LOAINHATIEU = ? ");
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				query.append(" AND TRANGTHAI IN ( ");
				String temp = "";
				for (int i = 0; i < trangThai.length; i++) {
					temp += ",?";
				}
				temp = temp.replaceFirst(",", "");
				query.append(temp);
				query.append(" ) ");
			}
			if (Validator.isNotNull(namBaoCao)) {
				/*
				 * if (namBaoCao.equals("9999")) { query.append(
				 * " AND ( TRANGTHAI = 0 OR TRANGTHAI = 3 OR TRANGTHAI = 4 OR TRANGTHAI = 8 ) "
				 * ); query.append(" AND NAMBAOCAO = ? "); } else { if
				 * (namBaoCao.equalsIgnoreCase("0")) {
				 * query.append(" AND ( NAMBAOCAO =  ? OR NAMBAOCAO =  ? ) "); }
				 * else {
				 * 
				 * }
				 * 
				 * }
				 */
				query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND NAMXAYDUNG = ? ");
			}

			query.append(" GROUP BY MAHUYEN, MAXA ");// them maxa
			query.append(" ORDER BY  MATINH , MAHUYEN , MAXA , THONXOM , LOAINHATIEU , TENCHUHO, TRANGTHAI  ");

			_log.debug("=getVeSinhGiaDinhGroupByMaHuyen==" + query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(VeSinhGiaDinhImpl.TABLE_NAME, VeSinhGiaDinhImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh))
				qPos.add(maTinh);
			if (Validator.isNotNull(maHuyen))
				qPos.add(maHuyen);
			if (Validator.isNotNull(maXa))
				qPos.add(maXa);
			if (Validator.isNotNull(loaiNhaTieuId))
				qPos.add(Long.valueOf(loaiNhaTieuId));
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				for (int i = 0; i < trangThai.length; i++) {
					qPos.add(trangThai[i].toString());
				}
			}
			if (Validator.isNotNull(namBaoCao)) {
				/*
				 * if (namBaoCao.equals("9999")) { qPos.add(0); } else { if
				 * (namBaoCao.equalsIgnoreCase("0")) { qPos.add(namBaoCao);
				 * qPos.add(FormatData.getCurrentYear()); } else {
				 * qPos.add(namBaoCao); }
				 * 
				 * }
				 */
				qPos.add(namBaoCao);
				qPos.add(namBaoCao);
			}

			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(),
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List<VeSinhGiaDinh> getVeSinhGiaDinhThoiGianChot(String maTinh,
			String maHuyen, String maXa, String loaiNhaTieuId,
			String[] trangThai, String namBaoCao) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT * ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh))
				query.append(" AND MATINH = ? ");
			if (Validator.isNotNull(maHuyen))
				query.append(" AND MAHUYEN = ? ");
			if (Validator.isNotNull(maXa))
				query.append(" AND MAXA = ? ");
			if (Validator.isNotNull(loaiNhaTieuId))
				query.append(" AND LOAINHATIEU = ? ");
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				query.append(" AND TRANGTHAI IN ( ");
				String temp = "";
				for (int i = 0; i < trangThai.length; i++) {
					temp += ",?";
				}
				temp = temp.replaceFirst(",", "");
				query.append(temp);
				query.append(" ) ");
			}
			if (Validator.isNotNull(namBaoCao)) {
				/*
				 * if (namBaoCao.equals("9999")) { query.append(
				 * " AND ( TRANGTHAI = 0 OR TRANGTHAI = 3 OR TRANGTHAI = 4 OR TRANGTHAI = 8 ) "
				 * ); query.append(" AND NAMBAOCAO = ? "); } else { if
				 * (namBaoCao.equalsIgnoreCase("0")) {
				 * query.append(" AND ( NAMBAOCAO =  ? OR NAMBAOCAO =  ? ) "); }
				 * else {
				 * 
				 * }
				 * 
				 * }
				 */
				query.append(" AND NAMBAOCAO = ? ");
				query.append(" AND NAMXAYDUNG = ? ");
			}

			// query.append(" GROUP BY MAHUYEN, MAXA ");// them maxa
			query.append(" ORDER BY  MATINH , MAHUYEN , MAXA , THONXOM , LOAINHATIEU , TENCHUHO, TRANGTHAI  ");

			_log.debug("=getVeSinhGiaDinhGroupByMaHuyen==" + query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(VeSinhGiaDinhImpl.TABLE_NAME, VeSinhGiaDinhImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh))
				qPos.add(maTinh);
			if (Validator.isNotNull(maHuyen))
				qPos.add(maHuyen);
			if (Validator.isNotNull(maXa))
				qPos.add(maXa);
			if (Validator.isNotNull(loaiNhaTieuId))
				qPos.add(Long.valueOf(loaiNhaTieuId));
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				for (int i = 0; i < trangThai.length; i++) {
					qPos.add(trangThai[i].toString());
				}
			}
			if (Validator.isNotNull(namBaoCao)) {
				/*
				 * if (namBaoCao.equals("9999")) { qPos.add(0); } else { if
				 * (namBaoCao.equalsIgnoreCase("0")) { qPos.add(namBaoCao);
				 * qPos.add(FormatData.getCurrentYear()); } else {
				 * qPos.add(namBaoCao); }
				 * 
				 * }
				 */
				qPos.add(namBaoCao);
				qPos.add(namBaoCao);
			}

			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(),
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List<VeSinhGiaDinh> getVeSinhGiaDinhGroupByMaHuyenBaoCaoHopNhat(
			String maTinh, String maHuyen, String maXa, String loaiNhaTieuId,
			String[] trangThai, int namBaoCao, int namToiThieu)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT DISTINCT  me_vesinhgiadinh.* FROM me_vesinhgiadinh  ");
			query.append(" LEFT JOIN me_thongtinkiemdemhogd ON me_vesinhgiadinh.id = me_thongtinkiemdemhogd.vesinhgiadinhid  ");
			query.append(" LEFT JOIN me_kiemdemvien ON me_thongtinkiemdemhogd.taikhoan = me_kiemdemvien.TAIKHOAN   ");
			query.append(" join me_kehoachkiemdemvesinh on me_thongtinkiemdemhogd.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh)){
				query.append(" AND me_vesinhgiadinh.MATINH = ? ");
			}
			if (Validator.isNotNull(maHuyen)){
				query.append(" AND me_vesinhgiadinh.MAHUYEN = ? ");
			}
			if (Validator.isNotNull(maXa)){
				query.append(" AND me_vesinhgiadinh.MAXA = ? ");
			}
			if (Validator.isNotNull(loaiNhaTieuId)){
				query.append(" AND me_thongtinkiemdemhogd.LOAINHATIEU = ? ");
			}
				
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				query.append(" AND me_thongtinkiemdemhogd.danhgiakiemdem IN ( ");
				String temp = "";
				for (int i = 0; i < trangThai.length; i++) {
					temp += ",?";
				}
				temp = temp.replaceFirst(",", "");
				query.append(temp);
				query.append(" ) ");
			}
			if (Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0) {
				_log.info("namToiThieu"+namToiThieu+"--namBaoCao"+namBaoCao);
				query.append(" AND (  me_kehoachkiemdemvesinh.nam >= ?  AND me_kehoachkiemdemvesinh.nam <= ? ) ");
				query.append(" AND (  me_thongtinkiemdemhogd.namxaydung >= ?  AND me_thongtinkiemdemhogd.namxaydung <= ? ) ");
			}

			query.append(" GROUP BY me_vesinhgiadinh.MAHUYEN, me_vesinhgiadinh.MAXA ");// them maxa
			query.append(" ORDER BY  me_vesinhgiadinh.MATINH , me_vesinhgiadinh.MAHUYEN , me_vesinhgiadinh.MAXA , me_vesinhgiadinh.THONXOM, me_vesinhgiadinh.tenchuho  ");

			_log.info("=getVeSinhGiaDinhGroupByMaHuyenBaoCaoHopNhat==" + query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(VeSinhGiaDinhImpl.TABLE_NAME, VeSinhGiaDinhImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
				
			if (Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
			}
				
			if (Validator.isNotNull(maXa)){
				qPos.add(maXa);
			}
				
			if (Validator.isNotNull(loaiNhaTieuId)){
				qPos.add(Long.valueOf(loaiNhaTieuId));
			}
				
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				for (int i = 0; i < trangThai.length; i++) {
					qPos.add(trangThai[i].toString());
				}
			}
			if (Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0) {
				qPos.add(namToiThieu);
				qPos.add(namBaoCao);
				qPos.add(namToiThieu);
				qPos.add(namBaoCao);
			}

			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(),
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countVeSinhGiaDinhGroupByMaHuyenBaoCaoHopNhat(String maTinh,
			String maHuyen, String maXa, String[] trangThai, int namBaoCao,
			int namToiThieu) throws SystemException {
		Session session = null;
		try {

			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT count(DISTINCT  me_vesinhgiadinh.id) as total FROM me_vesinhgiadinh  ");
			query.append(" LEFT JOIN me_thongtinkiemdemhogd ON me_vesinhgiadinh.id = me_thongtinkiemdemhogd.vesinhgiadinhid  ");
			query.append(" join me_kehoachkiemdemvesinh on me_thongtinkiemdemhogd.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh)){
				query.append(" AND me_vesinhgiadinh.MATINH = ? ");
			}
			if (Validator.isNotNull(maHuyen)){
				query.append(" AND me_vesinhgiadinh.MAHUYEN = ? ");
			}
			if (Validator.isNotNull(maXa)){
				query.append(" AND me_vesinhgiadinh.MAXA = ? ");
			}
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				query.append(" AND me_thongtinkiemdemhogd.danhgiakiemdem IN ( ");
				String temp = "";
				for (int i = 0; i < trangThai.length; i++) {
					temp += ",?";
				}
				temp = temp.replaceFirst(",", "");
				query.append(temp);
				query.append(" ) ");
			}
			if (Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0) {
				query.append(" AND ( me_kehoachkiemdemvesinh.nam >= ? AND me_kehoachkiemdemvesinh.nam <= ? ) ");
				query.append(" AND ( me_thongtinkiemdemhogd.namxaydung >= ? AND me_thongtinkiemdemhogd.namxaydung <= ? ) ");
			}
			_log.info("==countVeSinhGiaDinhGroupByMaHuyenBaoCaoHopNhat =="+ query.toString());
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
				
			if (Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
			}
				
			if (Validator.isNotNull(maXa)){
				qPos.add(maXa);
			}
				
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				for (int i = 0; i < trangThai.length; i++) {
					qPos.add(trangThai[i].toString());
				}
			}
			if (Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0) {
				qPos.add(namToiThieu);
				qPos.add(namBaoCao);
				qPos.add(namToiThieu);
				qPos.add(namBaoCao);
			}

			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q,getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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

	/*
	 * SELECT DISTINCT me_vesinhgiadinh.* FROM me_vesinhgiadinh LEFT JOIN
	 * me_thongtinkiemdemhogd ON me_vesinhgiadinh.id =
	 * me_thongtinkiemdemhogd.vesinhgiadinhid LEFT JOIN me_kiemdemvien ON
	 * me_thongtinkiemdemhogd.taikhoan = me_kiemdemvien.TAIKHOAN WHERE 1=1 AND
	 * me_vesinhgiadinh.matinh = ? AND me_vesinhgiadinh.mahuyen = ? AND
	 * me_vesinhgiadinh.thonxom = ? AND me_vesinhgiadinh.maxa = ? AND
	 * DATE(me_vesinhgiadinh.ngaytao) = ? AND me_vesinhgiadinh.nambaocao = ? AND
	 * me_vesinhgiadinh.idnguoitao = ? AND me_vesinhgiadinh.tenchuho LIKE ? AND
	 * me_thongtinkiemdemhogd.daketthucdieutra = ? AND
	 * me_thongtinkiemdemhogd.danhgiakiemdem = ? AND
	 * DATE(me_thongtinkiemdemhogd.ngaykiemdem) = ? AND me_kiemdemvien.TAIKHOAN
	 * = ? ORDER BY me_thongtinkiemdemhogd.ngaykiemdem desc,
	 * me_thongtinkiemdemhogd.tenchuho asc
	 */

	public int searchCountVeSinhGiaDinh(String maTinh, String maHuyen,
			String maXa, String thonXom, String trangThai,
			String danhGiaKiemDem, String tkKiemDemVien, String tkGiamSatVien,
			String ngayKiemDem, String namBaoCao, String namBaoCaoVstx,
			String idNguoiTao, String ngayTao, String advText)
			throws PortalException, SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_SQL);

			if (Validator.isNull(maTinh)) {

				sql = StringUtil.replace(sql,
						"AND me_vesinhgiadinh.matinh = ?", StringPool.BLANK);
			}

			if (Validator.isNull(maHuyen)) {

				sql = StringUtil.replace(sql,
						"AND me_vesinhgiadinh.mahuyen = ?", StringPool.BLANK);
			}

			if (Validator.isNull(maXa)) {

				sql = StringUtil.replace(sql, "AND me_vesinhgiadinh.maxa = ?",
						StringPool.BLANK);
			}

			if (Validator.isNull(thonXom)) {

				sql = StringUtil.replace(sql,
						"AND me_vesinhgiadinh.thonxom = ?", StringPool.BLANK);
			}

			if (Validator.isNull(trangThai)) {

				sql = StringUtil.replace(sql,
						"AND me_thongtinkiemdemhogd.daketthucdieutra = ?",
						StringPool.BLANK);
				sql = StringUtil.replace(sql,
						"AND me_vesinhgiadinh.trangThai = ?",
						StringPool.BLANK);
			}else{
				if(trangThai.equals("-1")){
					sql = StringUtil.replace(sql,
							"AND me_thongtinkiemdemhogd.daketthucdieutra = ?",
							StringPool.BLANK);
				}else{
					sql = StringUtil.replace(sql,
							"AND me_vesinhgiadinh.trangThai = ?",
							StringPool.BLANK);
				}
			}
			if (Validator.isNull(danhGiaKiemDem)) {

				sql = StringUtil.replace(sql,
						"AND me_thongtinkiemdemhogd.danhgiakiemdem = ?",
						StringPool.BLANK);
			}	
			
			
			if (Validator.isNull(tkKiemDemVien)) {

				sql = StringUtil.replace(sql,
						"AND me_kiemdemvien.TAIKHOAN = ?", StringPool.BLANK);
			}			
			if (Validator.isNull(tkGiamSatVien)) {

				sql = StringUtil.replace(sql,
						"AND GIAMSATVIEN_STRING", StringPool.BLANK);
			}else {
				sql = StringUtil.replace(sql,
						"AND me_kiemdemvien.TAIKHOAN = ?", StringPool.BLANK);
				sql = StringUtil.replace(sql,"AND GIAMSATVIEN_STRING",
						"	AND me_kiemdemvien.TAIKHOAN in (select me_kiemdemvien.TAIKHOAN  from me_kiemdemvien WHERE me_kiemdemvien.ID in (select ID from me_kiemdemvien WHERE me_kiemdemvien.idQuanLy= ?))");
				
			}				

			if (Validator.isNull(ngayKiemDem)) {

				sql = StringUtil.replace(sql,
						"AND DATE(me_thongtinkiemdemhogd.ngaykiemdem) = ?",
						StringPool.BLANK);
			}			
			
			if (Validator.isNull(namBaoCao)) {

				sql = StringUtil.replace(sql,
						"AND me_vesinhgiadinh.nambaocao = ?", StringPool.BLANK);
			}
			

			if (Validator.isNull(idNguoiTao)) {

				sql = StringUtil
						.replace(sql, "AND me_vesinhgiadinh.idnguoitao = ?",
								StringPool.BLANK);
			}
			
			if (Validator.isNull(ngayTao)) {

				sql = StringUtil.replace(sql,
						"AND DATE(me_vesinhgiadinh.ngaytao) = ?",
						StringPool.BLANK);
			}




			if (Validator.isNull(advText)) {

				sql = StringUtil.replace(sql,
						"AND me_vesinhgiadinh.tenchuho LIKE ?",
						StringPool.BLANK);
			}
			if (Validator.isNotNull(namBaoCaoVstx) || !namBaoCaoVstx .trim().isEmpty())  {
				if (namBaoCaoVstx.equals("1") && ! Validator.isNull(namBaoCao)) { //diem kiem dem xay moi
					sql = StringUtil.replace(sql, "AND LOAI_DU_LIEU",	" AND me_vesinhgiadinh.namxaydung = ? ");
					
				} else if (namBaoCaoVstx.equals("2") ){
					sql = StringUtil.replace(sql, "AND LOAI_DU_LIEU",	" AND me_vesinhgiadinh.maungaunhien > 0  ");
					
				}
			}
			if (Validator.isNull(namBaoCaoVstx)) {

				sql = StringUtil.replace(sql,
						"AND LOAI_DU_LIEU",	StringPool.BLANK);
			}			
			
			_log.info("sql: " + sql.toString());

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

			if (Validator.isNotNull(thonXom)) {

				qPos.add(thonXom);
			}
			if (Validator.isNotNull(trangThai)) {
				if(trangThai.equals("-1")){
					//do co 2 dieu kien o 2 bang la vesinhgiadinh va thongtinkiemdemhogd
					//deu co gia tri  = 0, nen quy dinh lai tren form jsp 1 dieu kien = -1, khi dua vao ham search thi doi lai la 0
					trangThai = "0";
				}
				
				qPos.add(trangThai);
			}
			if (Validator.isNotNull(danhGiaKiemDem)) {

				qPos.add(danhGiaKiemDem);
			}		

			
			if (Validator.isNotNull(tkGiamSatVien))  {
				qPos.add(tkGiamSatVien);
				
			}else {
				if (Validator.isNotNull(tkKiemDemVien)) {

					qPos.add(tkKiemDemVien);
				}
			}		
	

			if (Validator.isNotNull(ngayKiemDem)) {

				qPos.add(ngayKiemDem);
			}
			
			if (Validator.isNotNull(namBaoCao)) {

				qPos.add(namBaoCao);
			}			
			if (Validator.isNotNull(idNguoiTao)) {

				qPos.add(idNguoiTao);
			}			
			if (Validator.isNotNull(ngayTao)) {

				qPos.add(ngayTao);
			}


			if (Validator.isNotNull(advText)) {

				qPos.add(advText);
			}

			if (Validator.isNotNull(namBaoCaoVstx) || !namBaoCaoVstx .trim().isEmpty())  {
				if (namBaoCaoVstx.equals("1") && ! Validator.isNull(namBaoCao)) { //diem kiem dem xay moi
					qPos.add(namBaoCao);
				} 
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

			return 0;
		} finally {
			closeSession(session);
		}
	}

	public List<VeSinhGiaDinh> searchVeSinhGiaDinh(String maTinh,
			String maHuyen, String maXa, String thonXom, String trangThai,
			String danhGiaKiemDem, String tkKiemDemVien, String tkGiamSatVien,
			String ngayKiemDem, String namBaoCao, String namBaoCaoVstx,
			String idNguoiTao, String ngayTao, String advText, int start,
			int end, OrderByComparator obc) throws PortalException,
			SystemException {

		Session session = null;
		
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FINDER_SQL);

			if (Validator.isNull(maTinh)) {

				sql = StringUtil.replace(sql,
						"AND me_vesinhgiadinh.matinh = ?", StringPool.BLANK);
			}

			if (Validator.isNull(maHuyen)) {

				sql = StringUtil.replace(sql,
						"AND me_vesinhgiadinh.mahuyen = ?", StringPool.BLANK);
			}

			if (Validator.isNull(maXa)) {

				sql = StringUtil.replace(sql, "AND me_vesinhgiadinh.maxa = ?",
						StringPool.BLANK);
			}

			if (Validator.isNull(thonXom)) {

				sql = StringUtil.replace(sql,
						"AND me_vesinhgiadinh.thonxom = ?", StringPool.BLANK);
			}
			//goc
/*			if (Validator.isNull(trangThai)) {

				sql = StringUtil.replace(sql,
						"AND me_thongtinkiemdemhogd.daketthucdieutra = ?",
						StringPool.BLANK);
				sql = StringUtil.replace(sql,
						"AND me_vesinhgiadinh.trangThai = ?",
						StringPool.BLANK);
			}else{
				if(trangThai.equals("-1")){
					sql = StringUtil.replace(sql,
							"AND me_thongtinkiemdemhogd.daketthucdieutra = ?",
							StringPool.BLANK);
				}else{
					sql = StringUtil.replace(sql,
							"AND me_vesinhgiadinh.trangThai = ?",
							StringPool.BLANK);
				}
			}			*/
			
			
			
			//end gov
			
			
			

			if (Validator.isNull(trangThai) || Validator.equals(-2, trangThai)) {

				sql = StringUtil.replace(sql,
						"AND me_thongtinkiemdemhogd.daketthucdieutra = ?",
						StringPool.BLANK);
				sql = StringUtil.replace(sql,
						"AND me_vesinhgiadinh.trangThai = ?",
						StringPool.BLANK);
			}else{
				if(trangThai.equals("-1")){
					sql = StringUtil.replace(sql,
							"AND me_thongtinkiemdemhogd.daketthucdieutra = ?",
							StringPool.BLANK);
				}else{
					sql = StringUtil.replace(sql,
							"AND me_vesinhgiadinh.trangThai = ?",
							StringPool.BLANK);
				}
			}
			if (Validator.isNull(danhGiaKiemDem)) {

				sql = StringUtil.replace(sql,
						"AND me_thongtinkiemdemhogd.danhgiakiemdem = ?",
						StringPool.BLANK);
			}	
			
			if (Validator.isNull(tkKiemDemVien)) {

				sql = StringUtil.replace(sql,
						"AND me_kiemdemvien.TAIKHOAN = ?", StringPool.BLANK);
			}			
			if (Validator.isNull(tkGiamSatVien)) {

				sql = StringUtil.replace(sql,
						"AND GIAMSATVIEN_STRING", StringPool.BLANK);
			}else {
				sql = StringUtil.replace(sql,
						"AND me_kiemdemvien.TAIKHOAN = ?", StringPool.BLANK);
				sql = StringUtil.replace(sql,"AND GIAMSATVIEN_STRING",
						"	AND me_kiemdemvien.TAIKHOAN in (select me_kiemdemvien.TAIKHOAN  from me_kiemdemvien WHERE me_kiemdemvien.ID in (select ID from me_kiemdemvien WHERE me_kiemdemvien.idQuanLy= ?))");
				
			}		
			

			if (Validator.isNull(ngayKiemDem)) {

				sql = StringUtil.replace(sql,
						"AND DATE(me_thongtinkiemdemhogd.ngaykiemdem) = ?",
						StringPool.BLANK);
			}			
			
			if (Validator.isNull(namBaoCao) || Validator.equals(-1, namBaoCao)) {

				sql = StringUtil.replace(sql,
						"AND me_vesinhgiadinh.nambaocao = ?", StringPool.BLANK);
			}
			

			if (Validator.isNull(idNguoiTao) || Validator.equals(-1, idNguoiTao)) {

				sql = StringUtil
						.replace(sql, "AND me_vesinhgiadinh.idnguoitao = ?",
								StringPool.BLANK);
			}
			
			if (Validator.isNull(ngayTao)) {

				sql = StringUtil.replace(sql,
						"AND DATE(me_vesinhgiadinh.ngaytao) = ?",
						StringPool.BLANK);
			}




			if (Validator.isNull(advText)) {

				sql = StringUtil.replace(sql,
						"AND me_vesinhgiadinh.tenchuho LIKE ?",
						StringPool.BLANK);
			}
			if (Validator.isNull(namBaoCaoVstx) || Validator.equals(-1, namBaoCaoVstx)) {

				sql = StringUtil.replace(sql,
						"AND LOAI_DU_LIEU",	StringPool.BLANK);
			}

			if (Validator.isNotNull(namBaoCaoVstx) || !namBaoCaoVstx .trim().isEmpty())  {
				if (namBaoCaoVstx.equals("1") && ! Validator.isNull(namBaoCao)) { //diem kiem dem xay moi
					sql = StringUtil.replace(sql, "AND LOAI_DU_LIEU",	" AND me_vesinhgiadinh.namxaydung = ? ");
					
				} else if (namBaoCaoVstx.equals("2") ){
					sql = StringUtil.replace(sql, "AND LOAI_DU_LIEU",	" AND me_vesinhgiadinh.maungaunhien > 0  ");
					
				}
			}
			
			if (Validator.isNull(namBaoCaoVstx)) {

				sql = StringUtil.replace(sql,
						"AND LOAI_DU_LIEU",	StringPool.BLANK);
			}


			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			_log.info("==searchVeSinhGiaDinh=="+sql);
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

			if (Validator.isNotNull(thonXom)) {

				qPos.add(thonXom);
			}
			if(Validator.isNotNull(trangThai) && !Validator.equals(-2, trangThai)){
				if(trangThai.equals("-1")){
					//do co 2 dieu kien o 2 bang la vesinhgiadinh va thongtinkiemdemhogd
					//deu co gia tri  = 0, nen quy dinh lai tren form jsp 1 dieu kien = -1, khi dua vao ham search thi doi lai la 0
					trangThai = "0";
				}
				qPos.add(trangThai);
			}
			
			
			if (Validator.isNotNull(danhGiaKiemDem)) {

				qPos.add(danhGiaKiemDem);
			}		

		
			if (Validator.isNotNull(tkGiamSatVien))  {
				qPos.add(tkGiamSatVien);
				
			}else {
				if (Validator.isNotNull(tkKiemDemVien)) {

					qPos.add(tkKiemDemVien);
				}
			}

			if (Validator.isNotNull(ngayKiemDem)) {
				
				qPos.add(ngayKiemDem);
				_log.info("ngayKiemDem-="+ngayKiemDem+"=--=");
			}
			if (Validator.isNotNull(namBaoCao) && !Validator.equals(-1, namBaoCao)) {

				qPos.add(namBaoCao);
			}			
			if (Validator.isNotNull(idNguoiTao) && !Validator.equals(-1, idNguoiTao) ) {

				qPos.add(idNguoiTao);
			}			
			if (Validator.isNotNull(ngayTao)) {

				qPos.add(ngayTao);
				_log.info("ngayTao-="+ngayTao+"=--=");
			}


			if (Validator.isNotNull(advText)) {

				qPos.add("%"+advText+"%");
			}

	
			if (Validator.isNotNull(namBaoCaoVstx) || !namBaoCaoVstx .trim().isEmpty() )  {
				if (namBaoCaoVstx.equals("1") && ! Validator.isNull(namBaoCao) && !Validator.equals(-1, namBaoCaoVstx)) { //diem kiem dem xay moi
					qPos.add(namBaoCao);
				} 
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

	public List<VeSinhGiaDinh> getVeSinhGiaDinhMauNgauNhienOnlySVRaSoat(String maTinh,
			String maHuyen, String maXa, String loaiNhaTieuId,
			String trangThai, String namBaoCao, String namBaoCaoVstx,
			int start, int end) throws SystemException {
		Session session = null;
		try {
			int mauNgauNhien = 0;
			if(Validator.isNotNull(namBaoCao)){
				mauNgauNhien = Integer.parseInt(namBaoCao);
			}
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT * ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh)){
				query.append(" AND MATINH = ? ");
			}
			if (Validator.isNotNull(maHuyen)){
				query.append(" AND MAHUYEN = ? ");
			}
			if (Validator.isNotNull(maXa)){
				query.append(" AND MAXA = ? ");
			}
			if (Validator.isNotNull(loaiNhaTieuId)){
				query.append(" AND LOAINHATIEU = ? ");
			}
			if(Validator.isNotNull(trangThai)){
				query.append(" AND TRANGTHAI IN (0,8) ");
			}
			if (Validator.isNotNull(namBaoCaoVstx) ) {
				if(!(namBaoCaoVstx.equalsIgnoreCase("xaymoi"))){
					query.append(" AND MAUNGAUNHIEN = ? ");
				}
			} 
			
			query.append(" ORDER BY TRANGTHAI,MATINH , MAHUYEN , MAXA , THONXOM  , TENCHUHO ");
			_log.info("=getVeSinhGiaDinhSearchOnlySVRaSoat--SQL==" + query.toString()+"---");
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity("VeSinhGiaDinh", VeSinhGiaDinhImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
				
			if (Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
			}
			if (Validator.isNotNull(maXa)){
				qPos.add(maXa);
			}
			if (Validator.isNotNull(loaiNhaTieuId)){
				qPos.add(Long.valueOf(loaiNhaTieuId));
			}
			/*
			if(Validator.isNotNull(trangThai)){
				qPos.add(trangThai);
			}
			*/
			if (Validator.isNotNull(namBaoCaoVstx) ) {
				if(!(namBaoCaoVstx.equalsIgnoreCase("xaymoi"))){
					qPos.add(Long.valueOf(mauNgauNhien));
				}
			}
			
			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	public int countVeSinhGiaDinhMauNgauNhienOnlySVRaSoat(String maTinh, String maHuyen,
			String maXa, String loaiNhaTieuId, String trangThai,
			String namBaoCao, String namBaoCaoVstx) throws SystemException {
		Session session = null;
		try {
			int mauNgauNhien = 0;
			if(Validator.isNotNull(namBaoCao)){
				mauNgauNhien = Integer.parseInt(namBaoCao);
			}
			
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT count(*) as total ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh)){
				query.append(" AND MATINH = ? ");
			}
				
			if (Validator.isNotNull(maHuyen)){
				query.append(" AND MAHUYEN = ? ");
			}
				
			if (Validator.isNotNull(maXa)){
				query.append(" AND MAXA = ? ");
			}
				
			if (Validator.isNotNull(loaiNhaTieuId)){
				query.append(" AND LOAINHATIEU = ? ");
			}
			if(Validator.isNotNull(trangThai)){
				query.append(" AND TRANGTHAI IN (0,8) ");
			}
			
			if (Validator.isNotNull(namBaoCaoVstx) ) {
				if(!(namBaoCaoVstx.equalsIgnoreCase("xaymoi"))){
					query.append(" AND MAUNGAUNHIEN = ? ");
				}
			}
			
			_log.info("--countVeSinhGiaDinhMauNgauNhienOnlySVRaSoat==" + query.toString()+"--");
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
				
			if (Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
			}
			if (Validator.isNotNull(maXa)){
				qPos.add(maXa);
			}
			if (Validator.isNotNull(loaiNhaTieuId)){
				qPos.add(Long.valueOf(loaiNhaTieuId));
			}
			/*
			if(Validator.isNotNull(trangThai)){
				qPos.add(trangThai);
			}
			*/
			if (Validator.isNotNull(namBaoCaoVstx) ) {
				if(!(namBaoCaoVstx.equalsIgnoreCase("xaymoi"))){
					qPos.add(Long.valueOf(mauNgauNhien));
				}
			}
			
			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q,
					getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	
	public List<VeSinhGiaDinh> getVeSinhGiaDinhGroupByMaTinhBaoCaoHopNhatTU(
			String maTinh, String maHuyen, String maXa, String loaiNhaTieuId,
			String[] trangThai, int namBaoCao, int namToiThieu)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT DISTINCT  me_vesinhgiadinh.* FROM me_vesinhgiadinh  ");
			query.append(" LEFT JOIN me_thongtinkiemdemhogd ON me_vesinhgiadinh.id = me_thongtinkiemdemhogd.vesinhgiadinhid  ");
			query.append(" LEFT JOIN me_kiemdemvien ON me_thongtinkiemdemhogd.taikhoan = me_kiemdemvien.TAIKHOAN   ");
			query.append(" join me_kehoachkiemdemvesinh on me_thongtinkiemdemhogd.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh)){
				query.append(" AND me_vesinhgiadinh.MATINH = ? ");
			}
			if (Validator.isNotNull(maHuyen)){
				query.append(" AND me_vesinhgiadinh.MAHUYEN = ? ");
			}
			if (Validator.isNotNull(maXa)){
				query.append(" AND me_vesinhgiadinh.MAXA = ? ");
			}
			if (Validator.isNotNull(loaiNhaTieuId)){
				query.append(" AND me_thongtinkiemdemhogd.LOAINHATIEU = ? ");
			}
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				query.append(" AND me_thongtinkiemdemhogd.danhgiakiemdem IN ( ");
				String temp = "";
				for (int i = 0; i < trangThai.length; i++) {
					temp += ",?";
				}
				temp = temp.replaceFirst(",", "");
				query.append(temp);
				query.append(" ) ");
			}
			if (Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0) {
				query.append(" AND (  me_kehoachkiemdemvesinh.nam >= ?  AND me_kehoachkiemdemvesinh.nam <= ? ) ");
				query.append(" AND (  me_thongtinkiemdemhogd.namxaydung >= ?  AND me_thongtinkiemdemhogd.namxaydung <= ? ) ");
			}

			query.append(" GROUP BY me_vesinhgiadinh.MATINH ");
			query.append(" ORDER BY me_vesinhgiadinh.MATINH , me_vesinhgiadinh.MAHUYEN , me_vesinhgiadinh.MAXA , me_vesinhgiadinh.THONXOM, me_vesinhgiadinh.tenchuho  ");

			_log.debug("=getVeSinhGiaDinhGroupByMaTinhBaoCaoHopNhatTU==" + query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(VeSinhGiaDinhImpl.TABLE_NAME, VeSinhGiaDinhImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
				
			if (Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
			}
				
			if (Validator.isNotNull(maXa)){
				qPos.add(maXa);
			}
				
			if (Validator.isNotNull(loaiNhaTieuId)){
				qPos.add(Long.valueOf(loaiNhaTieuId));
			}
				
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				for (int i = 0; i < trangThai.length; i++) {
					qPos.add(trangThai[i].toString());
				}
			}
			if (Validator.isNotNull(namToiThieu) && namToiThieu > 0
					&& Validator.isNotNull(namBaoCao) && namBaoCao > 0) {
				qPos.add(namToiThieu);
				qPos.add(namBaoCao);
				qPos.add(namToiThieu);
				qPos.add(namBaoCao);
			}

			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<VeSinhGiaDinh> getVeSinhGiaDinhMauNgauNhien(String maTinh,String maHuyen, String maXa, String loaiNhaTieuId,String[] trangThai, String namBaoCao, String namBaoCaoVstx) throws SystemException {
		Session session = null;
		try {
			int mauNgauNhien = 0;
			int mauNgauNhienx10 = 0;
			if(Validator.isNotNull(namBaoCao)){
				mauNgauNhien = Integer.parseInt(namBaoCao);
				mauNgauNhienx10 = mauNgauNhien * 10;
			}
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT * ");
			query.append(" FROM me_vesinhgiadinh ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh)){
				query.append(" AND MATINH = ? ");
			}
			if (Validator.isNotNull(maHuyen)){
				query.append(" AND MAHUYEN = ? ");
			}
			if (Validator.isNotNull(maXa)){
				query.append(" AND MAXA = ? ");
			}
			if (Validator.isNotNull(loaiNhaTieuId)){
				query.append(" AND LOAINHATIEU = ? ");
			}
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				query.append(" AND TRANGTHAI IN ( ");
				String temp = "";
				for (int i = 0; i < trangThai.length; i++) {
					temp += ",?";
				}
				temp = temp.replaceFirst(",", "");
				query.append(temp);
				query.append(" ) ");
			}
			if (Validator.isNotNull(namBaoCaoVstx) ) {
				if(!(namBaoCaoVstx.equalsIgnoreCase("xaymoi"))){
					query.append(" AND ( MAUNGAUNHIEN = ? ");
					query.append(" OR MAUNGAUNHIEN = ? ) ");
				}
			} 
			
			query.append(" ORDER BY TRANGTHAI,MATINH , MAHUYEN , MAXA , THONXOM  , TENCHUHO ");
			_log.info("=getVeSinhGiaDinhMauNgauNhien--SQL==" + query.toString()+"---");
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity("VeSinhGiaDinh", VeSinhGiaDinhImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh)){
				qPos.add(maTinh);
			}
				
			if (Validator.isNotNull(maHuyen)){
				qPos.add(maHuyen);
			}
			if (Validator.isNotNull(maXa)){
				qPos.add(maXa);
			}
			if (Validator.isNotNull(loaiNhaTieuId)){
				qPos.add(Long.valueOf(loaiNhaTieuId));
			}
			if (ArrayUtil.isNotEmpty(trangThai) && trangThai.length > 0) {
				for (int i = 0; i < trangThai.length; i++) {
					qPos.add(trangThai[i].toString());
				}
			}
			if (Validator.isNotNull(namBaoCaoVstx) ) {
				if(!(namBaoCaoVstx.equalsIgnoreCase("xaymoi"))){
					qPos.add(Long.valueOf(mauNgauNhien));
					qPos.add(Long.valueOf(mauNgauNhienx10));
				}
			}
			
			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public HashMap<VeSinhGiaDinh, Integer>  getVeSinhGiaDinhThoiGianThuc(String maTinh,String maHuyen, String maXa, String loaiNhaTieuId,String[] danhGiaKiemDem, String namBaoCao, String namBaoCaoVstx) throws SystemException {
		Session session = null;
		try {
			int mauNgauNhien = 0;
			int mauNgauNhienx10 = 0;
			if (Validator.isNotNull(namBaoCao)) {
				mauNgauNhien = Integer.parseInt(namBaoCao);
				mauNgauNhienx10 = mauNgauNhien * 10;
			}
			session = openSession();
			StringBuilder query = new StringBuilder();
			
//			query.append(" SELECT gd.* ");
//			query.append(" FROM me_vesinhgiadinh as gd INNER JOIN me_thongtinkiemdemhogd as tt ON gd.id = tt.vesinhgiadinhid");
//			query.append("");
//			query.append(" WHERE 1 = 1 ");
			
			
			query.append(" SELECT DISTINCT gd.*, tt.danhgiakiemdem FROM me_vesinhgiadinh as gd ");
			query.append(" LEFT JOIN me_thongtinkiemdemhogd as tt ON gd.id = tt.vesinhgiadinhid ");
			query.append(" join me_kehoachkiemdemvesinh on tt.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh)) {
				query.append(" AND gd.MATINH = ? ");
			}
			if (Validator.isNotNull(maHuyen)) {
				query.append(" AND gd.MAHUYEN = ? ");
			}
			if (Validator.isNotNull(maXa)) {
				query.append(" AND gd.MAXA = ? ");
			}
			if (Validator.isNotNull(loaiNhaTieuId)) {
				query.append(" AND gd.LOAINHATIEU = ? ");
			}
			
			if (ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0) {
				query.append(" AND tt.danhgiakiemdem IN ( ");
				String temp = "";
				for (int i = 0; i < danhGiaKiemDem.length; i++) {
					temp += ",?";
				}
				temp = temp.replaceFirst(",", "");
				query.append(temp);
				query.append(" ) ");
			}
			
			if (Validator.isNotNull(namBaoCaoVstx)) {
				if (!(namBaoCaoVstx.equalsIgnoreCase("xaymoi"))) {
					query.append(" AND ( gd.MAUNGAUNHIEN = ? ");
					query.append(" OR gd.MAUNGAUNHIEN = ? ) ");
				}
			}
			
			query.append(" ORDER BY gd.TRANGTHAI, gd.MATINH, gd.MAHUYEN, gd.MAXA, gd.THONXOM, gd.TENCHUHO ");
			_log.info("=getVeSinhGiaDinhMauNgauNhien--SQL==" + query.toString() + "---");
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
//			q.addEntity("VeSinhGiaDinh", VeSinhGiaDinhImpl.class);
			
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
			if (Validator.isNotNull(loaiNhaTieuId)) {
				qPos.add(Long.valueOf(loaiNhaTieuId));
			}
			
			if (ArrayUtil.isNotEmpty(danhGiaKiemDem) && danhGiaKiemDem.length > 0) {
				for (int i = 0; i < danhGiaKiemDem.length; i++) {
					qPos.add(danhGiaKiemDem[i].toString());
				}
			}
			
			if (Validator.isNotNull(namBaoCaoVstx)) {
				if (!(namBaoCaoVstx.equalsIgnoreCase("xaymoi"))) {
					qPos.add(Long.valueOf(mauNgauNhien));
					qPos.add(Long.valueOf(mauNgauNhienx10));
				}
			}
			
			Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			HashMap<VeSinhGiaDinh, Integer> result = new HashMap<VeSinhGiaDinh, Integer>();
			VeSinhGiaDinh dmPortHarbour = null;
			int resultDanhGiaKiemDem = 0;
			while (itr.hasNext()) {
				Object[] a = itr.next();
				
				dmPortHarbour = new VeSinhGiaDinhImpl();
				dmPortHarbour.setId((Integer) a[0]);
				dmPortHarbour.setMaTinh((String) a[1]);
				dmPortHarbour.setMaHuyen((String) a[2]);
				dmPortHarbour.setMaXa((String) a[3]);
				
				if (a[4] != null) {
					dmPortHarbour.setThonXom((String) a[4]);
				}
				
				dmPortHarbour.setTenChuHo((String) a[5]);
				dmPortHarbour.setGioiTinhChuHo((Integer) a[6]);
				dmPortHarbour.setTrangThai((Integer) a[7]);
				dmPortHarbour.setNamBaoCao((Integer) a[8]);
				dmPortHarbour.setGhiChu((String) a[9]);
				dmPortHarbour.setNgayTao((Date) a[10]);
				dmPortHarbour.setIdNguoiTao((Integer) a[11]);
//				 dmPortHarbour.setchinhsach((String) a[12]);
				dmPortHarbour.setThanhPhanHoGD((Integer) a[13]);
				dmPortHarbour.setKinhDo((String) a[14]);
				dmPortHarbour.setViDo((String) a[15]);
				dmPortHarbour.setCoNhaTieu((Integer) a[16]);
				dmPortHarbour.setNhaTieuHVS((Integer) a[17]);
				dmPortHarbour.setLoaiNhaTieu((String) a[18]);
				dmPortHarbour.setDuocCaiTao((Integer) a[19]);
				dmPortHarbour.setNamXayDung((Integer) a[20]);
				dmPortHarbour.setNguonVon((Integer) a[21]);
				dmPortHarbour.setNgayKiemDem((Date) a[22]);
				dmPortHarbour.setNgayDanhGia((Date) a[23]);
//				 dmPortHarbour.idnguoidanhgia((Integer) a[24]);
				dmPortHarbour.setSoNguoiTrongHo((Integer) a[25]);
				dmPortHarbour.setThangXayDung((Integer) a[26]);
				dmPortHarbour.setMauNgauNhien((Integer) a[27]);
				resultDanhGiaKiemDem = (Integer) a[28];
				
				result.put(dmPortHarbour, resultDanhGiaKiemDem);
				
			}
			
			return result;
			
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<VeSinhGiaDinh> getVeSinhGiaDinhDLI12GroupByMaHuyen(String maTinh,
			String maHuyen, String maXa, String namBaoCao, String danhgiakiemdem) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT DISTINCT  me_vesinhgiadinh.* FROM me_vesinhgiadinh  ");
			query.append(" LEFT JOIN me_thongtinkiemdemhogd ON me_vesinhgiadinh.id = me_thongtinkiemdemhogd.vesinhgiadinhid  ");
			query.append(" LEFT JOIN me_kiemdemvien ON me_thongtinkiemdemhogd.taikhoan = me_kiemdemvien.TAIKHOAN   ");
			query.append(" join me_kehoachkiemdemvesinh on me_thongtinkiemdemhogd.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh)){
				query.append(" AND me_vesinhgiadinh.MATINH = ? ");
			}
			if (Validator.isNotNull(maHuyen)){
				query.append(" AND me_vesinhgiadinh.MAHUYEN = ? ");
			}
			if (Validator.isNotNull(maXa)){
				query.append(" AND me_vesinhgiadinh.MAXA = ? ");
			}
			
			if (Validator.isNotNull(namBaoCao)) {
				
				query.append(" AND me_kehoachkiemdemvesinh.nam = ? ");
			}
			if(Validator.isNotNull(danhgiakiemdem)){
				query.append("  AND me_thongtinkiemdemhogd.danhgiakiemdem = ? ");
			}

			query.append(" GROUP BY me_vesinhgiadinh.MAHUYEN, me_vesinhgiadinh.MAXA ");// them maxa
			query.append(" ORDER BY  me_vesinhgiadinh.MATINH , me_vesinhgiadinh.MAHUYEN , me_vesinhgiadinh.MAXA , me_vesinhgiadinh.THONXOM, me_vesinhgiadinh.tenchuho ");

			_log.info("=getVeSinhGiaDinhDLI12GroupByMaHuyen==" + query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(VeSinhGiaDinhImpl.TABLE_NAME, VeSinhGiaDinhImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh))
				qPos.add(maTinh);
			if (Validator.isNotNull(maHuyen))
				qPos.add(maHuyen);
			if (Validator.isNotNull(maXa))
				qPos.add(maXa);
			
			if (Validator.isNotNull(namBaoCao)) {
				qPos.add(namBaoCao);
			}
			if (Validator.isNotNull(danhgiakiemdem)) {
				qPos.add(danhgiakiemdem);
			}
			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(),
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countVeSinhGiaDinhDLI12GroupByMaHuyen(String maTinh,
			String maHuyen, String maXa, String namBaoCao, String danhgiakiemdem) throws SystemException {
		Session session = null;
		try {
			int mauNgauNhien = 0;
			if(Validator.isNotNull(namBaoCao)){
				mauNgauNhien = Integer.parseInt(namBaoCao);
			}
			
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT count(DISTINCT  me_vesinhgiadinh.id) as total FROM me_vesinhgiadinh  ");
			query.append(" LEFT JOIN me_thongtinkiemdemhogd ON me_vesinhgiadinh.id = me_thongtinkiemdemhogd.vesinhgiadinhid  ");
			//query.append(" LEFT JOIN me_kiemdemvien ON me_thongtinkiemdemhogd.taikhoan = me_kiemdemvien.TAIKHOAN   ");
			query.append(" join me_kehoachkiemdemvesinh on me_thongtinkiemdemhogd.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh)){
				query.append(" AND me_vesinhgiadinh.MATINH = ? ");
			}
			if (Validator.isNotNull(maHuyen)){
				query.append(" AND me_vesinhgiadinh.MAHUYEN = ? ");
			}
			if (Validator.isNotNull(maXa)){
				query.append(" AND me_vesinhgiadinh.MAXA = ? ");
			}
			
			if (Validator.isNotNull(namBaoCao)) {
				
				query.append(" AND me_kehoachkiemdemvesinh.nam = ?  AND  me_thongtinkiemdemhogd.namxaydung = ? ");
				
			}
			if(Validator.isNotNull(danhgiakiemdem)){
				query.append("  AND me_thongtinkiemdemhogd.danhgiakiemdem = ? ");
			}
			
			_log.info("--countVeSinhGiaDinhDLI12GroupByMaHuyen==" + query.toString()+"--");
			SQLQuery q = session.createSQLQuery(query.toString());
			q.addScalar("total", Type.INTEGER);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh))
				qPos.add(maTinh);
			if (Validator.isNotNull(maHuyen))
				qPos.add(maHuyen);
			if (Validator.isNotNull(maXa))
				qPos.add(maXa);
			
			if (Validator.isNotNull(namBaoCao)) {
				qPos.add(namBaoCao);
				qPos.add(namBaoCao);
			}
			if (Validator.isNotNull(danhgiakiemdem)) {
				qPos.add(danhgiakiemdem);
			}
			
			List<Integer> lstTotal = (List<Integer>) QueryUtil.list(q,
					getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	
	public List<VeSinhGiaDinh> getVeSinhGiaDinhDLI12ChiTiet(String maTinh,
			String maHuyen, String maXa, String namBaoCao, String danhgiakiemdem) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append(" SELECT DISTINCT  me_vesinhgiadinh.* FROM me_vesinhgiadinh  ");
			query.append(" LEFT JOIN me_thongtinkiemdemhogd ON me_vesinhgiadinh.id = me_thongtinkiemdemhogd.vesinhgiadinhid  ");
			//query.append(" LEFT JOIN me_kiemdemvien ON me_thongtinkiemdemhogd.taikhoan = me_kiemdemvien.TAIKHOAN   ");
			query.append(" join me_kehoachkiemdemvesinh on me_thongtinkiemdemhogd.kehoachkiemdemvesinhid = me_kehoachkiemdemvesinh.id ");
			query.append(" WHERE 1 = 1 ");

			if (Validator.isNotNull(maTinh)){
				query.append(" AND me_vesinhgiadinh.MATINH = ? ");
			}
			if (Validator.isNotNull(maHuyen)){
				query.append(" AND me_vesinhgiadinh.MAHUYEN = ? ");
			}
			if (Validator.isNotNull(maXa)){
				query.append(" AND me_vesinhgiadinh.MAXA = ? ");
			}
			
			if (Validator.isNotNull(namBaoCao)) {
				
				query.append(" AND me_kehoachkiemdemvesinh.nam = ?  AND  me_thongtinkiemdemhogd.namxaydung = ? ");
			}
			if(Validator.isNotNull(danhgiakiemdem)){
				query.append("  AND me_thongtinkiemdemhogd.danhgiakiemdem = ? ");
			}

			//query.append(" GROUP BY me_vesinhgiadinh.MAHUYEN, me_vesinhgiadinh.MAXA ");// them maxa
			query.append(" ORDER BY  me_vesinhgiadinh.MATINH , me_vesinhgiadinh.MAHUYEN , me_vesinhgiadinh.MAXA , me_vesinhgiadinh.THONXOM , me_vesinhgiadinh.tenchuho ");

			_log.debug("=getVeSinhGiaDinhDLI12ChiTiet==" + query.toString());

			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(VeSinhGiaDinhImpl.TABLE_NAME, VeSinhGiaDinhImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maTinh))
				qPos.add(maTinh);
			if (Validator.isNotNull(maHuyen))
				qPos.add(maHuyen);
			if (Validator.isNotNull(maXa))
				qPos.add(maXa);
			
			if (Validator.isNotNull(namBaoCao)) {
				qPos.add(namBaoCao);
				qPos.add(namBaoCao);
			}
			if (Validator.isNotNull(danhgiakiemdem)) {
				qPos.add(danhgiakiemdem);
			}
			return (List<VeSinhGiaDinh>) QueryUtil.list(q, getDialect(),
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public static final String FINDER_SQL = VeSinhGiaDinhFinder.class.getName() + ".searchVeSinhGiaDinh";
	
	public static final String COUNT_SQL = VeSinhGiaDinhFinder.class.getName() + ".searchCountVeSinhGiaDinh";

	Log _log = LogFactoryUtil.getLog(VeSinhGiaDinhFinderImpl.class);
}
