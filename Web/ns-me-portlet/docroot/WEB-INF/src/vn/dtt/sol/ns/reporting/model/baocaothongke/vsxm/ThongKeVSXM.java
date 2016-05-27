package vn.dtt.sol.ns.reporting.model.baocaothongke.vsxm;

import java.util.List;

public class ThongKeVSXM {
	private String tenTinh;
	private String nam;
	private List<ThongKeVSXMDanhSach> lstThongKeVSXMDanhSach;
	
	public String getTenTinh() {
		return tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public List<ThongKeVSXMDanhSach> getLstThongKeVSXMDanhSach() {
		return lstThongKeVSXMDanhSach;
	}

	public void setLstThongKeVSXMDanhSach(
			List<ThongKeVSXMDanhSach> lstThongKeVSXMDanhSach) {
		this.lstThongKeVSXMDanhSach = lstThongKeVSXMDanhSach;
	}

	public class ThongKeVSXMDanhSach{
		private String huyen;
		private String xa;
		private int soHoTrongKeHoach;
		private int soHVSXM;
		private int soHVS;
		private int soKoHVS;
		private int soKoNhaTieu;
		private int soTongDaKetThucDieuTra;
		private int soChuaKiemDem;
		private int soDangKiemDem;
		private int soTongDangDieuTra;
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
		public int getSoHoTrongKeHoach() {
			return soHoTrongKeHoach;
		}
		public void setSoHoTrongKeHoach(int soHoTrongKeHoach) {
			this.soHoTrongKeHoach = soHoTrongKeHoach;
		}
		public int getSoHVSXM() {
			return soHVSXM;
		}
		public void setSoHVSXM(int soHVSXM) {
			this.soHVSXM = soHVSXM;
		}
		public int getSoHVS() {
			return soHVS;
		}
		public void setSoHVS(int soHVS) {
			this.soHVS = soHVS;
		}
		public int getSoKoHVS() {
			return soKoHVS;
		}
		public void setSoKoHVS(int soKoHVS) {
			this.soKoHVS = soKoHVS;
		}
		public int getSoKoNhaTieu() {
			return soKoNhaTieu;
		}
		public void setSoKoNhaTieu(int soKoNhaTieu) {
			this.soKoNhaTieu = soKoNhaTieu;
		}
		public int getSoTongDaKetThucDieuTra() {
			return soTongDaKetThucDieuTra;
		}
		public void setSoTongDaKetThucDieuTra(int soTongDaKetThucDieuTra) {
			this.soTongDaKetThucDieuTra = soTongDaKetThucDieuTra;
		}
		public int getSoChuaKiemDem() {
			return soChuaKiemDem;
		}
		public void setSoChuaKiemDem(int soChuaKiemDem) {
			this.soChuaKiemDem = soChuaKiemDem;
		}
		public int getSoDangKiemDem() {
			return soDangKiemDem;
		}
		public void setSoDangKiemDem(int soDangKiemDem) {
			this.soDangKiemDem = soDangKiemDem;
		}
		public int getSoTongDangDieuTra() {
			return soTongDangDieuTra;
		}
		public void setSoTongDangDieuTra(int soTongDangDieuTra) {
			this.soTongDangDieuTra = soTongDangDieuTra;
		}
		
	}
}
