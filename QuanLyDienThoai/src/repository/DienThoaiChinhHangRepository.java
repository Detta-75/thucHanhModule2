package repository;

import entity.DienThoaiChinhHang;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiChinhHangRepository {

    public static final String DIENTHOAICHINHHANG_CSV = "src/data/dienthoaichinhhang.csv";

    public void save(DienThoaiChinhHang dienThoaiChinhHang) {
        File file = new File(DIENTHOAICHINHHANG_CSV);
        List<DienThoaiChinhHang> thoaiChinhHangs = new ArrayList<>();
        thoaiChinhHangs.add(dienThoaiChinhHang);
        writeFile(thoaiChinhHangs,true);
    }
    private void writeFile(List<DienThoaiChinhHang> thoaiChinhHangs, boolean append) {
        File file = new File(DIENTHOAICHINHHANG_CSV);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,append))) {
            for (DienThoaiChinhHang thoaiChinhHang : thoaiChinhHangs) {
                bufferedWriter.write(newEmployeeToString(thoaiChinhHang));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    private String newEmployeeToString(DienThoaiChinhHang chinhHang){
        return chinhHang.getId() + "," + chinhHang.getTenDienThoai() + "," + chinhHang.getGiaBan() + "," + chinhHang.getNhaSX() + "," + chinhHang.getThoiGianBH() + "," + chinhHang.getPhamViBaoHanh();
    }

    public DienThoaiChinhHang findById(int id) {
        List<DienThoaiChinhHang> thoaiChinhHangs = findAll();
        for (DienThoaiChinhHang chinhHang : thoaiChinhHangs) {
            if (chinhHang.getId() == id) {
                return chinhHang;
            }
        }
        return null;
    }

    public void remove(int id) {
        List<DienThoaiChinhHang> thoaiChinhHangs = findAll();
        for (DienThoaiChinhHang thoaiChinhHang : thoaiChinhHangs) {
            if (thoaiChinhHang.getId() == id) {
                thoaiChinhHangs.remove(thoaiChinhHang);
                break;
            }
        }
        writeFile(thoaiChinhHangs,false);
    }

    public List<DienThoaiChinhHang> findAll() {
        File file = new File(DIENTHOAICHINHHANG_CSV);
        List<DienThoaiChinhHang> thoaiChinhHangs = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
            String line;
            String s[];
            DienThoaiChinhHang thoaiChinhHang;
            while ((line = bufferedReader.readLine()) != null) {
                s = line.split(",");
                thoaiChinhHang = new DienThoaiChinhHang(Integer.parseInt(s[0]),s[1],Double.parseDouble(s[2]),Integer.parseInt(s[3]),s[4],Integer.parseInt(s[5]),s[6]);
                thoaiChinhHangs.add(thoaiChinhHang);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return thoaiChinhHangs;
    }
}
