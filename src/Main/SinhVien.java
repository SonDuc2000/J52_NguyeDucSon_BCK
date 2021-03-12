package Main;

public class SinhVien {
	private String maSv;
	private String hoDem;
	private String ten;
	private String gioiTinh;
	private String namSinh;
	public int id = 0;
	
	public SinhVien() {}
	
	public SinhVien(String hoDem, String ten, String gioiTinh, String namSinh) {
		this.hoDem = hoDem;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.namSinh = namSinh;
	}

	public SinhVien(String maSv, String hoDem, String ten, String gioiTinh, String namSinh) {
		this.maSv = maSv;
		this.hoDem = hoDem;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.namSinh = namSinh;
	}

	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}
	
	public String getFullName() {
		return hoDem + " " + ten;
	}
	
	public void showInfoSv() {
		System.out.format("  %-10s|%-25s|%-15s|%-15s|%-5s\r", maSv, hoDem, ten, gioiTinh, namSinh);
	}

	@Override
	public String toString() {
		return this.maSv + ";" + this.hoDem + ";" + this.ten + ";" + this.gioiTinh + ";" + this.namSinh;
	}
	
	

}
