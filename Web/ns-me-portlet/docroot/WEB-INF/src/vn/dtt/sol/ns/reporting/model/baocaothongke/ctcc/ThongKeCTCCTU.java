package vn.dtt.sol.ns.reporting.model.baocaothongke.ctcc;

import java.util.List;

public class ThongKeCTCCTU {
	
	private String nam;
	private List<ThongKeCTCCTUDanhSach> lstThongKeCTCCTUDanhSach;
	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public List<ThongKeCTCCTUDanhSach> getLstThongKeCTCCTUDanhSach() {
		return lstThongKeCTCCTUDanhSach;
	}

	public void setLstThongKeCTCCTUDanhSach(
			List<ThongKeCTCCTUDanhSach> lstThongKeCTCCTUDanhSach) {
		this.lstThongKeCTCCTUDanhSach = lstThongKeCTCCTUDanhSach;
	}

	public class ThongKeCTCCTUDanhSach{
		private String tenTinh;
		private String huyen;
		private String xa;
		private int soCongTrinhHVS;
		private int soCongTrinhKoHVS;
		private int soChuaKiemDem;
		private int soDangKiemDem;
		private int soTong;
		
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
		public int getSoCongTrinhHVS() {
			return soCongTrinhHVS;
		}
		public void setSoCongTrinhHVS(int soCongTrinhHVS) {
			this.soCongTrinhHVS = soCongTrinhHVS;
		}
		public int getSoCongTrinhKoHVS() {
			return soCongTrinhKoHVS;
		}
		public void setSoCongTrinhKoHVS(int soCongTrinhKoHVS) {
			this.soCongTrinhKoHVS = soCongTrinhKoHVS;
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
		public int getSoTong() {
			return soTong;
		}
		public void setSoTong(int soTong) {
			this.soTong = soTong;
		}
		
	}
}
