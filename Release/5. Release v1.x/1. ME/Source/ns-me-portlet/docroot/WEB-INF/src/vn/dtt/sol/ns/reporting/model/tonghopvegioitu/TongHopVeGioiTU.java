package vn.dtt.sol.ns.reporting.model.tonghopvegioitu;

import java.util.List;

public class TongHopVeGioiTU {
	private String nam;
	private int tongSo11;
	private int chuHoNam11;
	private int chuHoNu11;
	
	private int tongSo12;
	private int chuHoNam12;
	private int chuHoNu12;
	
	private int tongSo22;
	private int chuHoNam22;
	private int chuHoNu22;
	private List<TongHopVeGioiTUDanhSach> lstTongHopVeGioiTUDanhSach11;
	private List<TongHopVeGioiTUDanhSach> lstTongHopVeGioiTUDanhSach12;
	private List<TongHopVeGioiTUDanhSach> lstTongHopVeGioiTUDanhSach22;
	
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	
	public int getTongSo11() {
		return tongSo11;
	}
	public void setTongSo11(int tongSo11) {
		this.tongSo11 = tongSo11;
	}
	public int getChuHoNam11() {
		return chuHoNam11;
	}
	public void setChuHoNam11(int chuHoNam11) {
		this.chuHoNam11 = chuHoNam11;
	}
	public int getChuHoNu11() {
		return chuHoNu11;
	}
	public void setChuHoNu11(int chuHoNu11) {
		this.chuHoNu11 = chuHoNu11;
	}
	public int getTongSo12() {
		return tongSo12;
	}
	public void setTongSo12(int tongSo12) {
		this.tongSo12 = tongSo12;
	}
	public int getChuHoNam12() {
		return chuHoNam12;
	}
	public void setChuHoNam12(int chuHoNam12) {
		this.chuHoNam12 = chuHoNam12;
	}
	public int getChuHoNu12() {
		return chuHoNu12;
	}
	public void setChuHoNu12(int chuHoNu12) {
		this.chuHoNu12 = chuHoNu12;
	}
	public int getTongSo22() {
		return tongSo22;
	}
	public void setTongSo22(int tongSo22) {
		this.tongSo22 = tongSo22;
	}
	public int getChuHoNam22() {
		return chuHoNam22;
	}
	public void setChuHoNam22(int chuHoNam22) {
		this.chuHoNam22 = chuHoNam22;
	}
	public int getChuHoNu22() {
		return chuHoNu22;
	}
	public void setChuHoNu22(int chuHoNu22) {
		this.chuHoNu22 = chuHoNu22;
	}
	public List<TongHopVeGioiTUDanhSach> getLstTongHopVeGioiTUDanhSach11() {
		return lstTongHopVeGioiTUDanhSach11;
	}
	public void setLstTongHopVeGioiTUDanhSach11(
			List<TongHopVeGioiTUDanhSach> lstTongHopVeGioiTUDanhSach11) {
		this.lstTongHopVeGioiTUDanhSach11 = lstTongHopVeGioiTUDanhSach11;
	}
	public List<TongHopVeGioiTUDanhSach> getLstTongHopVeGioiTUDanhSach12() {
		return lstTongHopVeGioiTUDanhSach12;
	}
	public void setLstTongHopVeGioiTUDanhSach12(
			List<TongHopVeGioiTUDanhSach> lstTongHopVeGioiTUDanhSach12) {
		this.lstTongHopVeGioiTUDanhSach12 = lstTongHopVeGioiTUDanhSach12;
	}
	public List<TongHopVeGioiTUDanhSach> getLstTongHopVeGioiTUDanhSach22() {
		return lstTongHopVeGioiTUDanhSach22;
	}
	public void setLstTongHopVeGioiTUDanhSach22(
			List<TongHopVeGioiTUDanhSach> lstTongHopVeGioiTUDanhSach22) {
		this.lstTongHopVeGioiTUDanhSach22 = lstTongHopVeGioiTUDanhSach22;
	}

	public class TongHopVeGioiTUDanhSach{
		private String tenTinh;
		private int tongSo;
		private int chuHoNam;
		private int chuHoNu;
		public String getTenTinh() {
			return tenTinh;
		}
		public void setTenTinh(String tenTinh) {
			this.tenTinh = tenTinh;
		}
		public int getTongSo() {
			return tongSo;
		}
		public void setTongSo(int tongSo) {
			this.tongSo = tongSo;
		}
		public int getChuHoNam() {
			return chuHoNam;
		}
		public void setChuHoNam(int chuHoNam) {
			this.chuHoNam = chuHoNam;
		}
		public int getChuHoNu() {
			return chuHoNu;
		}
		public void setChuHoNu(int chuHoNu) {
			this.chuHoNu = chuHoNu;
		}
		
		
		
		
	}
}
