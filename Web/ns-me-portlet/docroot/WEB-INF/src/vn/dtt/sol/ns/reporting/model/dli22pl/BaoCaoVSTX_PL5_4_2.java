
package vn.dtt.sol.ns.reporting.model.dli22pl;

import java.util.List;

public class BaoCaoVSTX_PL5_4_2 {
	
	private String nam;
	private String tenTinh;
	private String donViBaoCao;
	private String baoCaoSo;
	private List<DuLieuDong> lstDuLieuDong;
	
	
	
	public BaoCaoVSTX_PL5_4_2() {
	}

	public BaoCaoVSTX_PL5_4_2(String nam, String tenTinh, String baoCaoSo, List<DuLieuDong> lstDuLieuDong) {
		this.nam = nam;
		this.tenTinh = tenTinh;
		this.baoCaoSo = baoCaoSo;
		this.lstDuLieuDong = lstDuLieuDong;
	}
	
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
	
	public List<DuLieuDong> getLstDuLieuDong() {
		return lstDuLieuDong;
	}
	
	public void setLstDuLieuDong(List<DuLieuDong> lstDuLieuDong) {
		this.lstDuLieuDong = lstDuLieuDong;
	}
	
	public class DuLieuDong {
		
		private String stt;
		private String name;
		private String hoNgheo;
		private String hVS;
		private String tH;
		private String tD;
		private String hN;
		private String chim;
		private String khac;
		private String troCap;
		private String vayVon;
		private String tuXay;
		private String namHoanThanh;
		private String ghiChu;
		
		public DuLieuDong() {
		}
		
		public DuLieuDong(
			String stt, String name, String hoNgheo, String hVS, String tH, String tD, String hN, String chim, String khac, String troCap, String vayVon, String tuXay,
			String namHoanThanh, String ghiChu) {
			this.stt = stt;
			this.name = name;
			this.hoNgheo = hoNgheo;
			this.hVS = hVS;
			this.tH = tH;
			this.tD = tD;
			this.hN = hN;
			this.chim = chim;
			this.khac = khac;
			this.troCap = troCap;
			this.vayVon = vayVon;
			this.tuXay = tuXay;
			this.namHoanThanh = namHoanThanh;
			this.ghiChu = ghiChu;
		}
		
		public String getStt() {
			return stt;
		}
		
		public void setStt(String stt) {
			this.stt = stt;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getHoNgheo() {
			return hoNgheo;
		}
		
		public void setHoNgheo(String hoNgheo) {
			this.hoNgheo = hoNgheo;
		}
		
		public String gethVS() {
			return hVS;
		}
		
		public void sethVS(String hVS) {
			this.hVS = hVS;
		}
		
		public String gettH() {
			return tH;
		}
		
		public void settH(String tH) {
			this.tH = tH;
		}
		
		public String gettD() {
			return tD;
		}
		
		public void settD(String tD) {
			this.tD = tD;
		}
		
		public String gethN() {
			return hN;
		}
		
		public void sethN(String hN) {
			this.hN = hN;
		}
		
		public String getChim() {
			return chim;
		}
		
		public void setChim(String chim) {
			this.chim = chim;
		}
		
		public String getKhac() {
			return khac;
		}
		
		public void setKhac(String khac) {
			this.khac = khac;
		}
		
		public String getTroCap() {
			return troCap;
		}
		
		public void setTroCap(String troCap) {
			this.troCap = troCap;
		}
		
		public String getVayVon() {
			return vayVon;
		}
		
		public void setVayVon(String vayVon) {
			this.vayVon = vayVon;
		}
		
		public String getTuXay() {
			return tuXay;
		}
		
		public void setTuXay(String tuXay) {
			this.tuXay = tuXay;
		}
		
		public String getNamHoanThanh() {
			return namHoanThanh;
		}
		
		public void setNamHoanThanh(String namHoanThanh) {
			this.namHoanThanh = namHoanThanh;
		}
		
		public String getGhiChu() {
			return ghiChu;
		}
		
		public void setGhiChu(String ghiChu) {
			this.ghiChu = ghiChu;
		}
		
	}
	
}
