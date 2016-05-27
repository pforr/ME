package vn.dtt.sol.ns.reporting.model.baocaothongke.searchhelp.vesinh;

import java.util.List;

public class ThongKeVeSinhSearch {
	private String thoiDiem;
	private List<ThongKeVeSinhSearchDanhSach> lstThongKeVeSinhSearchDanhSach;
	public String getThoiDiem() {
		return thoiDiem;
	}


	public void setThoiDiem(String thoiDiem) {
		this.thoiDiem = thoiDiem;
	}


	public List<ThongKeVeSinhSearchDanhSach> getLstThongKeVeSinhSearchDanhSach() {
		return lstThongKeVeSinhSearchDanhSach;
	}


	public void setLstThongKeVeSinhSearchDanhSach(
			List<ThongKeVeSinhSearchDanhSach> lstThongKeVeSinhSearchDanhSach) {
		this.lstThongKeVeSinhSearchDanhSach = lstThongKeVeSinhSearchDanhSach;
	}


	public class ThongKeVeSinhSearchDanhSach{
		private String tenTinh;
		private String huyen;
		private String xa;
		private String thon;
		private String tenChuHo;
		private String trangThaiKD;
		private String ketQuaKD;
		private String kiemDemVien;
		private String GSV;
		private String ngayKD;
		private String namXD;
		private String loaiDL;
		private String ngTao;
		private String ngayNhap;
		private String namBaoCao;
		public String getTenTinh() {
			return tenTinh;
		}
		public void setTenTinh(String tenTinh) {
			this.tenTinh = tenTinh;
		}
		public String getHuyen() {
			return huyen;
		}
		public void setHuyen(String huyen) {
			this.huyen = huyen;
		}
		public String getXa() {
			return xa;
		}
		public void setXa(String xa) {
			this.xa = xa;
		}
		public String getThon() {
			return thon;
		}
		public void setThon(String thon) {
			this.thon = thon;
		}
		public String getTenChuHo() {
			return tenChuHo;
		}
		public void setTenChuHo(String tenChuHo) {
			this.tenChuHo = tenChuHo;
		}
		public String getTrangThaiKD() {
			return trangThaiKD;
		}
		public void setTrangThaiKD(String trangThaiKD) {
			this.trangThaiKD = trangThaiKD;
		}
		public String getKetQuaKD() {
			return ketQuaKD;
		}
		public void setKetQuaKD(String ketQuaKD) {
			this.ketQuaKD = ketQuaKD;
		}
		public String getKiemDemVien() {
			return kiemDemVien;
		}
		public void setKiemDemVien(String kiemDemVien) {
			this.kiemDemVien = kiemDemVien;
		}
		public String getGSV() {
			return GSV;
		}
		public void setGSV(String gSV) {
			GSV = gSV;
		}
		public String getNgayKD() {
			return ngayKD;
		}
		public void setNgayKD(String ngayKD) {
			this.ngayKD = ngayKD;
		}
		public String getNamXD() {
			return namXD;
		}
		public void setNamXD(String namXD) {
			this.namXD = namXD;
		}
		
		public String getLoaiDL() {
			return loaiDL;
		}
		public void setLoaiDL(String loaiDL) {
			this.loaiDL = loaiDL;
		}
		public String getNgTao() {
			return ngTao;
		}
		public void setNgTao(String ngTao) {
			this.ngTao = ngTao;
		}
		public String getNgayNhap() {
			return ngayNhap;
		}
		public void setNgayNhap(String ngayNhap) {
			this.ngayNhap = ngayNhap;
		}
		public String getNamBaoCao() {
			return namBaoCao;
		}
		public void setNamBaoCao(String namBaoCao) {
			this.namBaoCao = namBaoCao;
		}
		
	}
}
