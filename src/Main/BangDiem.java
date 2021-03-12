package Main;

public class BangDiem {
	private String idSV;
	private String idMH;
	private float diem;
	
	public BangDiem() {}
	
	public BangDiem(String idSV, String idMH, float diem) {
		this.idSV = idSV;
		this.idMH = idMH;
		this.diem = diem;
	}

	public String getIdSV() {
		return idSV;
	}
	public void setIdSV(String idSV) {
		this.idSV = idSV;
	}
	public String getIdMH() {
		return idMH;
	}
	public void setIdMH(String idMH) {
		this.idMH = idMH;
	}
	public float getDiem() {
		return diem;
	}
	public void setDiem(float diem) {
		this.diem = diem;
	}
	
	public void showBangDiem() {
		System.out.format("  %-10s%-10s%10.2f\r", idSV, idMH, diem);
	}

}
