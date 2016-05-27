package vn.dtt.sol.ns.reporting.model.ktqxnnctu;

import java.util.List;

public class KQXetNghiemNcTU {
	private String nam;
	private List<KQXetNghiemNcTruongHocTU> lstXetNghiemNcTruongHocTU;
	private List<KQXetNghiemNcTramYTeTU> lstXetNghiemNcTramYTeTU;
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	public List<KQXetNghiemNcTruongHocTU> getLstXetNghiemNcTruongHocTU() {
		return lstXetNghiemNcTruongHocTU;
	}
	public void setLstXetNghiemNcTruongHocTU(
			List<KQXetNghiemNcTruongHocTU> lstXetNghiemNcTruongHocTU) {
		this.lstXetNghiemNcTruongHocTU = lstXetNghiemNcTruongHocTU;
	}
	public List<KQXetNghiemNcTramYTeTU> getLstXetNghiemNcTramYTeTU() {
		return lstXetNghiemNcTramYTeTU;
	}
	public void setLstXetNghiemNcTramYTeTU(
			List<KQXetNghiemNcTramYTeTU> lstXetNghiemNcTramYTeTU) {
		this.lstXetNghiemNcTramYTeTU = lstXetNghiemNcTramYTeTU;
	}
	
	public class KQXetNghiemNcTruongHocTU{
		private String tenTinh;
		private String huyenXa;
		private String tenTruong;
		private String soPhieuXetNghiem;
		private int datHayKo;
		//private List<KQXetNghiemNcTruongHocTUDanhSach> lstXetNghiemNcTruongHocTUDanhSach;
		public String getTenTinh() {
			return tenTinh;
		}
		public void setTenTinh(String tenTinh) {
			this.tenTinh = tenTinh;
		}
		public String getHuyenXa() {
			return huyenXa;
		}
		public void setHuyenXa(String huyenXa) {
			this.huyenXa = huyenXa;
		}
		public String getTenTruong() {
			return tenTruong;
		}
		public void setTenTruong(String tenTruong) {
			this.tenTruong = tenTruong;
		}
		public String getSoPhieuXetNghiem() {
			return soPhieuXetNghiem;
		}
		public void setSoPhieuXetNghiem(String soPhieuXetNghiem) {
			this.soPhieuXetNghiem = soPhieuXetNghiem;
		}
		public int getDatHayKo() {
			return datHayKo;
		}
		public void setDatHayKo(int datHayKo) {
			this.datHayKo = datHayKo;
		}
		
	}
	
	public class KQXetNghiemNcTramYTeTU{
		private String tenTinh;
		private String huyen;
		private String tenTramYTe;
		private String soPhieuXetNghiem;
		private int datHayKo;
		//private List<KQXetNghiemNcTramYTeTUDanhSach> lstXetNghiemNcTramYTeTUDanhSach;
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
		public String getTenTramYTe() {
			return tenTramYTe;
		}
		public void setTenTramYTe(String tenTramYTe) {
			this.tenTramYTe = tenTramYTe;
		}
		public String getSoPhieuXetNghiem() {
			return soPhieuXetNghiem;
		}
		public void setSoPhieuXetNghiem(String soPhieuXetNghiem) {
			this.soPhieuXetNghiem = soPhieuXetNghiem;
		}
		public int getDatHayKo() {
			return datHayKo;
		}
		public void setDatHayKo(int datHayKo) {
			this.datHayKo = datHayKo;
		}
		
	}
}
