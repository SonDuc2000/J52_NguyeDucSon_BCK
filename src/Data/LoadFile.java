package Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Main.BangDiem;
import Main.MonHoc;
import Main.SinhVien;

public class LoadFile {
	
	public static String dirFile;
	public static ArrayList<SinhVien> sv;
	public static ArrayList<BangDiem> bd;
	public static ArrayList<MonHoc> mh;
	
	public static String getDirFile() {
		return dirFile;
	}
	public static void setDirFile(String dirFile) {
		LoadFile.dirFile = dirFile;
	}
	public static ArrayList<SinhVien> getSv() {
		return sv;
	}
	public static void setSv(ArrayList<SinhVien> sv) {
		LoadFile.sv = sv;
	}
	public static ArrayList<BangDiem> getBd() {
		return bd;
	}
	public static void setBd(ArrayList<BangDiem> bd) {
		LoadFile.bd = bd;
	}
	public static ArrayList<MonHoc> getMh() {
		return mh;
	}
	public static void setMh(ArrayList<MonHoc> mh) {
		LoadFile.mh = mh;
	}
	
	public static ArrayList<SinhVien> openFileSV(String dirfile) throws IOException{
		ArrayList<SinhVien> list = new ArrayList<>();
		
		String toFile = dirfile.concat("\\sinhvien_en.txt");
		FileReader file = new FileReader(toFile);
		BufferedReader buf = new BufferedReader(file);
		String line;
		while ((line = buf.readLine()) != null) {
			if(line.startsWith("#")) continue;
			String[] split = line.split(";");
			SinhVien sv = new SinhVien(split[0], split[1], split[2], split[3], split[4]);
			list.add(sv);
		}
		
		if(file != null) file.close();
		if(buf != null) buf.close();
		
		return list;
	}
	
	public static ArrayList<MonHoc> openFileMH(String dirfile) throws IOException {
		ArrayList<MonHoc> list = new ArrayList<>();
		String toFile = dirfile.concat("\\monhoc_en.txt");
		FileReader file = new FileReader(toFile);
		BufferedReader buf = new BufferedReader(file);
		String line;
		while((line = buf.readLine()) != null) {
			if(line.startsWith("#")) continue;
			String[] split = line.split(";");
			MonHoc mon = new MonHoc(split[0], split[1], Float.parseFloat(split[2]));
			list.add(mon);
		}
		
		if(file != null) file.close();
		if(buf != null) buf.close();
		
		return list;
	}
	
	public static void updateSV(String filrDir, ArrayList<SinhVien> lst) throws IOException {
		String toFile = filrDir.concat("\\sinhvien_en.txt");
		FileWriter file = new FileWriter(toFile);
		BufferedWriter buw = new BufferedWriter(file);
		String line = "#MaSV;HoDem;Ten;GioiTinh;NamSinh";
		buw.write(line);
		buw.newLine();
		for (SinhVien sinhVien : lst) {
			buw.write(sinhVien.toString());
			buw.newLine();
		}
		
		if(buw != null) buw.close();
		if(file != null) file.close();
		
	}
	
	public static ArrayList<BangDiem> openFileBD(String dirfile) throws IOException {
		ArrayList<BangDiem> list = new ArrayList<>();
		String toFile = dirfile.concat("\\diem.txt");
		FileReader file = new FileReader(toFile);
		BufferedReader buf = new BufferedReader(file);
		String line;
		while((line = buf.readLine()) != null) {
			if(line.startsWith("#")) continue;
			String split[] = line.split(";");
			BangDiem bangDiem = new BangDiem(split[0], split[1], Float.parseFloat(split[2]));
			list.add(bangDiem);
		}
		
		if(file != null) file.close();
		if(buf != null) buf.close();
		
		return list;
	}
	
	public static void openAllFile() {
		try {
			LoadFile.setSv(LoadFile.openFileSV(getDirFile()));
			LoadFile.setBd(LoadFile.openFileBD(getDirFile()));
			LoadFile.setMh(LoadFile.openFileMH(getDirFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getTen(String name) {
		int i = name.lastIndexOf(" ");
		if(i == -1)
			return "";
		return name.substring(i + 1);
	}
	
	public static String getHoDem(String name) {
		int i = name.lastIndexOf(" ");
		if(i == -1)
			return "";
		return name.substring(0, i);
	}
	
	public static String[] subString(String str) {
		String split[] = str.split(";");
		return split;
	}

}
