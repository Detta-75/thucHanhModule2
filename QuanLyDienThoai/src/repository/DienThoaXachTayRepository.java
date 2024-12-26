package repository;

import entity.DienThoaiXachTay;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DienThoaXachTayRepository {
    public static final String DIENTHOAIXACHTAY_CSV = "src/data/dienthoaixachtay.csv";

    public void save(DienThoaiXachTay dienThoaiXachTay) {
        File file = new File(DIENTHOAIXACHTAY_CSV);
        List<DienThoaiXachTay> thoaiXachTays = new ArrayList<>();
        thoaiXachTays.add(dienThoaiXachTay);
        writeFile(thoaiXachTays,true);
    }

    private void writeFile(List<DienThoaiXachTay> thoaiXachTays, boolean append) {
        File file = new File(DIENTHOAIXACHTAY_CSV);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,append))) {
            for (DienThoaiXachTay thoaiXachTay : thoaiXachTays) {
                bufferedWriter.write(newEmployeeToString(thoaiXachTay));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    private String newEmployeeToString(DienThoaiXachTay chinhHang){
        return chinhHang.getId() + "," + chinhHang.getTenDienThoai() + "," + chinhHang.getGiaBan() + "," + chinhHang.getNhaSX() + "," + chinhHang.getQuocGiaXT() + "," + chinhHang.getTrangThai();
    }

    public DienThoaiXachTay findById(int id) {
        List<DienThoaiXachTay> thoaiXachTays = findAll();
        for (DienThoaiXachTay thoaiXachTay : thoaiXachTays) {
            if (thoaiXachTay.getId() == id) {
                return thoaiXachTay;
            }
        }
        return null;
    }

    public void remove(int id) {
        List<DienThoaiXachTay> xachTays = findAll();
        for (DienThoaiXachTay dienThoaiXachTay : xachTays) {
            if (dienThoaiXachTay.getId() == id) {
                xachTays.remove(dienThoaiXachTay);
                break;
            }
        }
        writeFile(xachTays,false);
    }

    public List<DienThoaiXachTay> findAll() {
        File file = new File(DIENTHOAIXACHTAY_CSV);
        List<DienThoaiXachTay> thoaiXachTays = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            String[] s;
            DienThoaiXachTay thoaiXachTay;
            while ((line = bufferedReader.readLine()) != null) {
                s = line.split(",");
                thoaiXachTay = new DienThoaiXachTay(
                        Integer.parseInt(s[0]),
                        s[1],
                        Double.parseDouble(s[2]),
                        Integer.parseInt(s[3]),
                        s[4],
                        s[5],
                        s[6]
                );
                thoaiXachTays.add(thoaiXachTay);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi: Đọc file thất bại");
        }
        return thoaiXachTays;
    }
}
