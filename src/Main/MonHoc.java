package Main;

public class MonHoc {
	
	private String maMH;
	private String tenMH;
	private float heSo;
	
	public MonHoc() {}
	
	public MonHoc(String tenMH, float heSo) {
		this.tenMH = tenMH;
		this.heSo = heSo;
	}

	public MonHoc(String maMH, String tenMH, float heSo) {
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.heSo = heSo;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public float getHeSo() {
		return heSo;
	}

	public void setHeSo(float heSo) {
		this.heSo = heSo;
	}
	
	public void showMonHoc() {
		System.out.format("  %-10s|%30s|%10.1f\r", maMH, tenMH, heSo);
	}

}
