package vn.dtt.sol.ns.reporting.model.baocaothongke.searchhelp.daunoinuoc;

import java.util.List;

public class ThongKeDauNoiNuocSearch {
	private String thoiDiem;
	
	private List<ThongKeDauNoiNuocSearchDanhSach> lstThongKeDauNoiNuocSearchDanhSach;
	
	
	public String getThoiDiem() {
		return thoiDiem;
	}


	public void setThoiDiem(String thoiDiem) {
		this.thoiDiem = thoiDiem;
	}


	public List<ThongKeDauNoiNuocSearchDanhSach> getLstThongKeDauNoiNuocSearchDanhSach() {
		return lstThongKeDauNoiNuocSearchDanhSach;
	}


	public void setLstThongKeDauNoiNuocSearchDanhSach(
			List<ThongKeDauNoiNuocSearchDanhSach> lstThongKeDauNoiNuocSearchDanhSach) {
		this.lstThongKeDauNoiNuocSearchDanhSach = lstThongKeDauNoiNuocSearchDanhSach;
	}


	public class ThongKeDauNoiNuocSearchDanhSach{
		private String tenTinh;
		private String huyen;
		private String xa;
		private String thon;
		private String tramCap;
		private String tenChuHo;
		private String trangThaiKD;
		private String ketQuaKD;
		private String ngayKD;
		private String kiemDemVien;
		private String GSV;
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
		public String getTramCap() {
			return tramCap;
		}
		public void setTramCap(String tramCap) {
			this.tramCap = tramCap;
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
		public String getNgayKD() {
			return ngayKD;
		}
		public void setNgayKD(String ngayKD) {
			this.ngayKD = ngayKD;
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
		public String getNamBaoCao() {
			return namBaoCao;
		}
		public void setNamBaoCao(String namBaoCao) {
			this.namBaoCao = namBaoCao;
		}
		
	}
}
