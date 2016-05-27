package vn.dtt.sol.ns.reporting.model.dli12th;

import java.util.List;

public class SoNhaTieuHGDXayMoiHVS {
	private String nam;
	private String tenTinh;	
	private String donViBaoCao;
	private String baoCaoSo;
	private String baoCaoNgayThangNam;
	private String nguoiLap;
	private String nguoiDuyet;
	private List<SoNhaTieuHGDXayMoiHVSDanhSach> lstSoNhaTieuHGDXayMoiHVSDanhSach;
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
	public String getDonViBaoCao() {
		return donViBaoCao;
	}
	public void setDonViBaoCao(String donViBaoCao) {
		this.donViBaoCao = donViBaoCao;
	}
	public String getBaoCaoSo() {
		return baoCaoSo;
	}
	public void setBaoCaoSo(String baoCaoSo) {
		this.baoCaoSo = baoCaoSo;
	}
	public String getNguoiLap() {
		return nguoiLap;
	}
	public void setNguoiLap(String nguoiLap) {
		this.nguoiLap = nguoiLap;
	}
	public String getNguoiDuyet() {
		return nguoiDuyet;
	}
	public void setNguoiDuyet(String nguoiDuyet) {
		this.nguoiDuyet = nguoiDuyet;
	}
	public List<SoNhaTieuHGDXayMoiHVSDanhSach> getLstSoNhaTieuHGDXayMoiHVSDanhSach() {
		return lstSoNhaTieuHGDXayMoiHVSDanhSach;
	}
	public void setLstSoNhaTieuHGDXayMoiHVSDanhSach(
			List<SoNhaTieuHGDXayMoiHVSDanhSach> lstSoNhaTieuHGDXayMoiHVSDanhSach) {
		this.lstSoNhaTieuHGDXayMoiHVSDanhSach = lstSoNhaTieuHGDXayMoiHVSDanhSach;
	}
	public String getBaoCaoNgayThangNam() {
		return baoCaoNgayThangNam;
	}
	public void setBaoCaoNgayThangNam(String baoCaoNgayThangNam) {
		this.baoCaoNgayThangNam = baoCaoNgayThangNam;
	}
	
}
