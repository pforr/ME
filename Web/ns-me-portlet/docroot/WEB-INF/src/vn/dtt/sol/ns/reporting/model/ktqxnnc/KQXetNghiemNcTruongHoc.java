package vn.dtt.sol.ns.reporting.model.ktqxnnc;

import java.util.List;

public class KQXetNghiemNcTruongHoc {
	private String nam;
	private String tenTinh;
	private List<KQXetNghiemNcTruongHocDanhSach> lstKqXetNghiemNcTruongHocDanhSach;
	
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	public String getTenTinh() {
		return tenTinh;
	}
	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}
	public List<KQXetNghiemNcTruongHocDanhSach> getLstKqXetNghiemNcTruongHocDanhSach() {
		return lstKqXetNghiemNcTruongHocDanhSach;
	}
	public void setLstKqXetNghiemNcTruongHocDanhSach(
			List<KQXetNghiemNcTruongHocDanhSach> lstKqXetNghiemNcTruongHocDanhSach) {
		this.lstKqXetNghiemNcTruongHocDanhSach = lstKqXetNghiemNcTruongHocDanhSach;
	}
	
	
}
