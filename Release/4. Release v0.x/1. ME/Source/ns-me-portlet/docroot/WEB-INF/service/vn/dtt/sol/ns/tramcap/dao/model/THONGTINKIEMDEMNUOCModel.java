/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.dtt.sol.ns.tramcap.dao.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the THONGTINKIEMDEMNUOC service. Represents a row in the &quot;me_thongtinkiemdemnuoc&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.dtt.sol.ns.tramcap.dao.model.impl.THONGTINKIEMDEMNUOCModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.dtt.sol.ns.tramcap.dao.model.impl.THONGTINKIEMDEMNUOCImpl}.
 * </p>
 *
 * @author khoa.vu
 * @see THONGTINKIEMDEMNUOC
 * @see vn.dtt.sol.ns.tramcap.dao.model.impl.THONGTINKIEMDEMNUOCImpl
 * @see vn.dtt.sol.ns.tramcap.dao.model.impl.THONGTINKIEMDEMNUOCModelImpl
 * @generated
 */
public interface THONGTINKIEMDEMNUOCModel extends BaseModel<THONGTINKIEMDEMNUOC> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a t h o n g t i n k i e m d e m n u o c model instance should use the {@link THONGTINKIEMDEMNUOC} interface instead.
	 */

	/**
	 * Returns the primary key of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the primary key of this t h o n g t i n k i e m d e m n u o c
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param primaryKey the primary key of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the ID of this t h o n g t i n k i e m d e m n u o c
	 */
	public long getId();

	/**
	 * Sets the ID of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param id the ID of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setId(long id);

	/**
	 * Returns the dau noi nuoc ID of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the dau noi nuoc ID of this t h o n g t i n k i e m d e m n u o c
	 */
	public long getDauNoiNuocId();

	/**
	 * Sets the dau noi nuoc ID of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param dauNoiNuocId the dau noi nuoc ID of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setDauNoiNuocId(long dauNoiNuocId);

	/**
	 * Returns the ke hoach kiem dem nuoc ID of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the ke hoach kiem dem nuoc ID of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getKeHoachKiemDemNuocId();

	/**
	 * Sets the ke hoach kiem dem nuoc ID of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param keHoachKiemDemNuocId the ke hoach kiem dem nuoc ID of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setKeHoachKiemDemNuocId(int keHoachKiemDemNuocId);

	/**
	 * Returns the ma tinh of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the ma tinh of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getMaTinh();

	/**
	 * Sets the ma tinh of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param maTinh the ma tinh of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setMaTinh(String maTinh);

	/**
	 * Returns the ma huyen of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the ma huyen of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getMaHuyen();

	/**
	 * Sets the ma huyen of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param maHuyen the ma huyen of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setMaHuyen(String maHuyen);

	/**
	 * Returns the ma xa of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the ma xa of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getMaXa();

	/**
	 * Sets the ma xa of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param maXa the ma xa of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setMaXa(String maXa);

	/**
	 * Returns the thon xom of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the thon xom of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getThonXom();

	/**
	 * Sets the thon xom of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param thonXom the thon xom of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setThonXom(String thonXom);

	/**
	 * Returns the ten chu ho of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the ten chu ho of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getTenChuHo();

	/**
	 * Sets the ten chu ho of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param tenChuHo the ten chu ho of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setTenChuHo(String tenChuHo);

	/**
	 * Returns the gioi tinh chu ho of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the gioi tinh chu ho of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getGioiTinhChuHo();

	/**
	 * Sets the gioi tinh chu ho of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param gioiTinhChuHo the gioi tinh chu ho of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setGioiTinhChuHo(int gioiTinhChuHo);

	/**
	 * Returns the ngay kiem dem of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the ngay kiem dem of this t h o n g t i n k i e m d e m n u o c
	 */
	public Date getNgayKiemDem();

	/**
	 * Sets the ngay kiem dem of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param ngayKiemDem the ngay kiem dem of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setNgayKiemDem(Date ngayKiemDem);

	/**
	 * Returns the tim thay nha of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the tim thay nha of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getTimThayNha();

	/**
	 * Sets the tim thay nha of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param timThayNha the tim thay nha of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setTimThayNha(int timThayNha);

	/**
	 * Returns the co nguoi o nha of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the co nguoi o nha of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getCoNguoiONha();

	/**
	 * Sets the co nguoi o nha of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param coNguoiONha the co nguoi o nha of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setCoNguoiONha(int coNguoiONha);

	/**
	 * Returns the ho ten nguoi tra loi of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the ho ten nguoi tra loi of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getHoTenNguoiTraLoi();

	/**
	 * Sets the ho ten nguoi tra loi of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param hoTenNguoiTraLoi the ho ten nguoi tra loi of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setHoTenNguoiTraLoi(String hoTenNguoiTraLoi);

	/**
	 * Returns the la chu ho khong of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the la chu ho khong of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getLaChuHoKhong();

	/**
	 * Sets the la chu ho khong of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param laChuHoKhong the la chu ho khong of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setLaChuHoKhong(int laChuHoKhong);

	/**
	 * Returns the gioi tinh nguoi tra loi of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the gioi tinh nguoi tra loi of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getGioiTinhNguoiTraLoi();

	/**
	 * Sets the gioi tinh nguoi tra loi of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param gioiTinhNguoiTraLoi the gioi tinh nguoi tra loi of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setGioiTinhNguoiTraLoi(String gioiTinhNguoiTraLoi);

	/**
	 * Returns the ten dan toc of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the ten dan toc of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getTenDanToc();

	/**
	 * Sets the ten dan toc of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param tenDanToc the ten dan toc of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setTenDanToc(String tenDanToc);

	/**
	 * Returns the kinh do of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the kinh do of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getKinhDo();

	/**
	 * Sets the kinh do of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param kinhDo the kinh do of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setKinhDo(String kinhDo);

	/**
	 * Returns the vi do of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the vi do of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getViDo();

	/**
	 * Sets the vi do of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param viDo the vi do of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setViDo(String viDo);

	/**
	 * Returns the so nguoi trong ho of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the so nguoi trong ho of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getSoNguoiTrongHo();

	/**
	 * Sets the so nguoi trong ho of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param soNguoiTrongHo the so nguoi trong ho of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setSoNguoiTrongHo(int soNguoiTrongHo);

	/**
	 * Returns the thanh phan ho gd of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the thanh phan ho gd of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getThanhPhanHoGd();

	/**
	 * Sets the thanh phan ho gd of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param thanhPhanHoGd the thanh phan ho gd of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setThanhPhanHoGd(int thanhPhanHoGd);

	/**
	 * Returns the chu ho dung ds of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the chu ho dung ds of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getChuHoDungDs();

	/**
	 * Sets the chu ho dung ds of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param chuHoDungDs the chu ho dung ds of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setChuHoDungDs(int chuHoDungDs);

	/**
	 * Returns the ly do khong dung ds of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the ly do khong dung ds of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getLyDoKhongDungDs();

	/**
	 * Sets the ly do khong dung ds of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param lyDoKhongDungDs the ly do khong dung ds of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setLyDoKhongDungDs(String lyDoKhongDungDs);

	/**
	 * Returns the ten chu ho hien tai of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the ten chu ho hien tai of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getTenChuHoHienTai();

	/**
	 * Sets the ten chu ho hien tai of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param tenChuHoHienTai the ten chu ho hien tai of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setTenChuHoHienTai(String tenChuHoHienTai);

	/**
	 * Returns the gioi tinh chu ho hien tai of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the gioi tinh chu ho hien tai of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getGioiTinhChuHoHienTai();

	/**
	 * Sets the gioi tinh chu ho hien tai of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param gioiTinhChuHoHienTai the gioi tinh chu ho hien tai of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setGioiTinhChuHoHienTai(int gioiTinhChuHoHienTai);

	/**
	 * Returns the dau noi chua of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the dau noi chua of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getDauNoiChua();

	/**
	 * Sets the dau noi chua of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param dauNoiChua the dau noi chua of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setDauNoiChua(int dauNoiChua);

	/**
	 * Returns the anh dau noi of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the anh dau noi of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getAnhDauNoi();

	/**
	 * Sets the anh dau noi of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param anhDauNoi the anh dau noi of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setAnhDauNoi(String anhDauNoi);

	/**
	 * Returns the thoi gian dau hop dong of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the thoi gian dau hop dong of this t h o n g t i n k i e m d e m n u o c
	 */
	public Date getThoiGianDauHopDong();

	/**
	 * Sets the thoi gian dau hop dong of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param thoiGianDauHopDong the thoi gian dau hop dong of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setThoiGianDauHopDong(Date thoiGianDauHopDong);

	/**
	 * Returns the thoi gian dau noi thuc te of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the thoi gian dau noi thuc te of this t h o n g t i n k i e m d e m n u o c
	 */
	public Date getThoiGianDauNoiThucTe();

	/**
	 * Sets the thoi gian dau noi thuc te of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param thoiGianDauNoiThucTe the thoi gian dau noi thuc te of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setThoiGianDauNoiThucTe(Date thoiGianDauNoiThucTe);

	/**
	 * Returns the voi nuoc chay khong of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the voi nuoc chay khong of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getVoiNuocChayKhong();

	/**
	 * Sets the voi nuoc chay khong of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param voiNuocChayKhong the voi nuoc chay khong of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setVoiNuocChayKhong(int voiNuocChayKhong);

	/**
	 * Returns the nuoc trong khong of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the nuoc trong khong of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getNuocTrongKhong();

	/**
	 * Sets the nuoc trong khong of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param nuocTrongKhong the nuoc trong khong of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setNuocTrongKhong(int nuocTrongKhong);

	/**
	 * Returns the mau nuoc of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the mau nuoc of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getMauNuoc();

	/**
	 * Sets the mau nuoc of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param mauNuoc the mau nuoc of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setMauNuoc(String mauNuoc);

	/**
	 * Returns the mui nuoc of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the mui nuoc of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getMuiNuoc();

	/**
	 * Sets the mui nuoc of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param muiNuoc the mui nuoc of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setMuiNuoc(String muiNuoc);

	/**
	 * Returns the vi nuoc of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the vi nuoc of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getViNuoc();

	/**
	 * Sets the vi nuoc of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param viNuoc the vi nuoc of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setViNuoc(String viNuoc);

	/**
	 * Returns the loai khac of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the loai khac of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getLoaiKhac();

	/**
	 * Sets the loai khac of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param loaiKhac the loai khac of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setLoaiKhac(String loaiKhac);

	/**
	 * Returns the da tung duc khong of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the da tung duc khong of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getDaTungDucKhong();

	/**
	 * Sets the da tung duc khong of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param daTungDucKhong the da tung duc khong of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setDaTungDucKhong(int daTungDucKhong);

	/**
	 * Returns the mau nuoc tung co of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the mau nuoc tung co of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getMauNuocTungCo();

	/**
	 * Sets the mau nuoc tung co of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param mauNuocTungCo the mau nuoc tung co of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setMauNuocTungCo(String mauNuocTungCo);

	/**
	 * Returns the mui nuoc tung co of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the mui nuoc tung co of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getMuiNuocTungCo();

	/**
	 * Sets the mui nuoc tung co of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param muiNuocTungCo the mui nuoc tung co of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setMuiNuocTungCo(String muiNuocTungCo);

	/**
	 * Returns the vi nuoc tung co of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the vi nuoc tung co of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getViNuocTungCo();

	/**
	 * Sets the vi nuoc tung co of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param viNuocTungCo the vi nuoc tung co of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setViNuocTungCo(String viNuocTungCo);

	/**
	 * Returns the loai khac tung co of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the loai khac tung co of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getLoaiKhacTungCo();

	/**
	 * Sets the loai khac tung co of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param loaiKhacTungCo the loai khac tung co of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setLoaiKhacTungCo(String loaiKhacTungCo);

	/**
	 * Returns the co be chua nuoc of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the co be chua nuoc of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getCoBeChuaNuoc();

	/**
	 * Sets the co be chua nuoc of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param coBeChuaNuoc the co be chua nuoc of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setCoBeChuaNuoc(int coBeChuaNuoc);

	/**
	 * Returns the tinh trang be of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the tinh trang be of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getTinhTrangBe();

	/**
	 * Sets the tinh trang be of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param tinhTrangBe the tinh trang be of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setTinhTrangBe(int tinhTrangBe);

	/**
	 * Returns the anh be chua of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the anh be chua of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getAnhBeChua();

	/**
	 * Sets the anh be chua of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param anhBeChua the anh be chua of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setAnhBeChua(String anhBeChua);

	/**
	 * Returns the bi mat nuoc of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the bi mat nuoc of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getBiMatNuoc();

	/**
	 * Sets the bi mat nuoc of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param biMatNuoc the bi mat nuoc of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setBiMatNuoc(int biMatNuoc);

	/**
	 * Returns the so lan mat nuoc of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the so lan mat nuoc of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getSoLanMatNuoc();

	/**
	 * Sets the so lan mat nuoc of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param soLanMatNuoc the so lan mat nuoc of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setSoLanMatNuoc(int soLanMatNuoc);

	/**
	 * Returns the so gio trung binh of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the so gio trung binh of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getSoGioTrungBinh();

	/**
	 * Sets the so gio trung binh of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param soGioTrungBinh the so gio trung binh of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setSoGioTrungBinh(int soGioTrungBinh);

	/**
	 * Returns the so se ry dong ho of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the so se ry dong ho of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getSoSeRyDongHo();

	/**
	 * Sets the so se ry dong ho of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param soSeRyDongHo the so se ry dong ho of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setSoSeRyDongHo(String soSeRyDongHo);

	/**
	 * Returns the chi so dong ho of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the chi so dong ho of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getChiSoDongHo();

	/**
	 * Sets the chi so dong ho of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param chiSoDongHo the chi so dong ho of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setChiSoDongHo(String chiSoDongHo);

	/**
	 * Returns the anh dong ho of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the anh dong ho of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getAnhDongHo();

	/**
	 * Sets the anh dong ho of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param anhDongHo the anh dong ho of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setAnhDongHo(String anhDongHo);

	/**
	 * Returns the ghi chu of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the ghi chu of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getGhiChu();

	/**
	 * Sets the ghi chu of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param ghiChu the ghi chu of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setGhiChu(String ghiChu);

	/**
	 * Returns the da ket thuc dieu tra of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the da ket thuc dieu tra of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getDaKetThucDieuTra();

	/**
	 * Sets the da ket thuc dieu tra of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param daKetThucDieuTra the da ket thuc dieu tra of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setDaKetThucDieuTra(int daKetThucDieuTra);

	/**
	 * Returns the ly do khong hoan thanh of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the ly do khong hoan thanh of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getLyDoKhongHoanThanh();

	/**
	 * Sets the ly do khong hoan thanh of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param lyDoKhongHoanThanh the ly do khong hoan thanh of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setLyDoKhongHoanThanh(String lyDoKhongHoanThanh);

	/**
	 * Returns the i mei of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the i mei of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getIMei();

	/**
	 * Sets the i mei of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param iMei the i mei of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setIMei(String iMei);

	/**
	 * Returns the tai khoan of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the tai khoan of this t h o n g t i n k i e m d e m n u o c
	 */
	@AutoEscape
	public String getTaiKhoan();

	/**
	 * Sets the tai khoan of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param taiKhoan the tai khoan of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setTaiKhoan(String taiKhoan);

	/**
	 * Returns the danh gia kiem dem of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @return the danh gia kiem dem of this t h o n g t i n k i e m d e m n u o c
	 */
	public int getDanhGiaKiemDem();

	/**
	 * Sets the danh gia kiem dem of this t h o n g t i n k i e m d e m n u o c.
	 *
	 * @param danhGiaKiemDem the danh gia kiem dem of this t h o n g t i n k i e m d e m n u o c
	 */
	public void setDanhGiaKiemDem(int danhGiaKiemDem);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(THONGTINKIEMDEMNUOC thongtinkiemdemnuoc);

	@Override
	public int hashCode();

	@Override
	public CacheModel<THONGTINKIEMDEMNUOC> toCacheModel();

	@Override
	public THONGTINKIEMDEMNUOC toEscapedModel();

	@Override
	public THONGTINKIEMDEMNUOC toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}