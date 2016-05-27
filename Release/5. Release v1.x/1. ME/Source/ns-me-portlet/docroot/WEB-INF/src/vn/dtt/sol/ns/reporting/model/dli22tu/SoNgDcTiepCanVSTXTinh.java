package vn.dtt.sol.ns.reporting.model.dli22tu;

import java.util.List;

public class SoNgDcTiepCanVSTXTinh {
	private String tenTinh;
	private List<SoNgDcTiepCanVSTXTinhDanhSach> lstSoNgDcTiepCanVSTXTinhDanhSach;

	public String getTenTinh() {
		return tenTinh;
	}
	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}
	public List<SoNgDcTiepCanVSTXTinhDanhSach> getLstSoNgDcTiepCanVSTXTinhDanhSach() {
		return lstSoNgDcTiepCanVSTXTinhDanhSach;
	}
	public void setLstSoNgDcTiepCanVSTXTinhDanhSach(
			List<SoNgDcTiepCanVSTXTinhDanhSach> lstSoNgDcTiepCanVSTXTinhDanhSach) {
		this.lstSoNgDcTiepCanVSTXTinhDanhSach = lstSoNgDcTiepCanVSTXTinhDanhSach;
	}

	
}
