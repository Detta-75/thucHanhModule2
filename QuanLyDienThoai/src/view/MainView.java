package view;

import controller.DienThoaiChinhHangController;
import controller.DienThoaiXachTayController;
import entity.DienThoaiChinhHang;
import entity.DienThoaiXachTay;

import java.util.List;
import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        int choice;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("-----CHƯƠNG QUẢN LÝ ĐIÊN THOẠI----");
            System.out.println("1. Quản lý điện thoại chính hãng. ");
            System.out.println("2. Quản lý điện thoại xách tay. ");
            System.out.println("0. Thoát");
            System.out.println("Mời bạn nhập lựa chọn: ");
            choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    menuDienThoaiChinhHang();
                    break;
                case 2:
                    menuDienThoaiXachTay();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Nhập sai mời nhập lại");
            }
        }
    }

    private static void menuDienThoaiXachTay() {
        DienThoaiXachTayController dienThoaiXachTayController = new DienThoaiXachTayController();
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("-------QUẢN LÝ ĐIÊN THOẠI XÁCH TAY-------");
            System.out.println("1. Thêm mới. ");
            System.out.println("2. Xóa. ");
            System.out.println("3. Hiển thị danh sách. ");
            System.out.println("4. Tìm kiếm. ");
            System.out.println("5. Thoát. ");
            System.out.println("Mời bạn nhập lựa chọn: ");
            List<DienThoaiXachTay> xachTays;
            choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    DienThoaiXachTay dienThoaiXachTay = inputXachTay(scanner);
                    dienThoaiXachTayController.save(dienThoaiXachTay);
                    System.out.println("Thêm mới thanh công");
                    break;
                case 2:
                    deleteIdXachTay(scanner, dienThoaiXachTayController);
                    break;
                case 3:
                    xachTays = dienThoaiXachTayController.getAll();
                    for (DienThoaiXachTay thoaiXachTay : xachTays) {
                        System.out.println(thoaiXachTay);
                    }
                    break;
                case 4:
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Nhập sai nhập lại");
            }
        }
    }

    private static void deleteIdXachTay(Scanner scanner, DienThoaiXachTayController dienThoaiXachTayController) {
        DienThoaiXachTay dienThoaiXachTay;
        System.out.println("Nhập ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        dienThoaiXachTay = dienThoaiXachTayController.findByID(id);
        if (dienThoaiXachTay == null) {
            System.out.println("Không tìm thấy để xóa");
        } else {
            System.out.println("Thông tin của đối tượng: \n" + dienThoaiXachTay);
            System.out.println("Bạn có chắc muốn xóa không (Y/N):");
            char confirm = scanner.nextLine().charAt(0);
            if (confirm == 'y') {
                dienThoaiXachTayController.remove(id);
                System.out.println("Xóa thành công");
            }
        }
    }

    private static DienThoaiXachTay inputXachTay(Scanner scanner) {
        System.out.println("Nhập ID");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên điên thoại:");
        String tenDienThoai = scanner.nextLine();
        System.out.println("Nhập giá bán:");
        double giaBan = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lượng: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất:");
        String nhaSX = scanner.nextLine();
        System.out.println("Nhâp quốc gia xách tay");
        String quocGiaXT = scanner.nextLine();
        System.out.println("Nhập trạng thái");
        String trangThai = scanner.next();
        DienThoaiXachTay dienThoaiXachTay = new DienThoaiXachTay(id,tenDienThoai,giaBan,soLuong,nhaSX,quocGiaXT,trangThai);
        return dienThoaiXachTay;
    }


    private static void menuDienThoaiChinhHang() {
        DienThoaiChinhHangController dienThoaiChinhHangController = new DienThoaiChinhHangController();
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("-------QUẢN LÝ ĐIÊN THOẠI CHÍNH HÃNG-------");
            System.out.println("1. Thêm mới. ");
            System.out.println("2. Xóa. ");
            System.out.println("3. Hiển thị danh sách. ");
            System.out.println("4. Tìm kiếm. ");
            System.out.println("5. Thoát. ");
            System.out.println("Mời bạn nhập lựa chọn: ");
            List<DienThoaiChinhHang> thoaiChinhHangs;
            choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    DienThoaiChinhHang dienThoaiChinhHang = inputChinhHang(scanner);
                    dienThoaiChinhHangController.save(dienThoaiChinhHang);
                    System.out.println("Thêm mới thành công");
                    break;
                case 2:
                    deleteIdChinhHang(scanner, dienThoaiChinhHangController);
                    break;
                case 3:
                    thoaiChinhHangs = dienThoaiChinhHangController.getAll();
                    for (DienThoaiChinhHang thoaiChinhHang : thoaiChinhHangs) {
                        System.out.println(thoaiChinhHang);
                    }
                    break;
                case 4:
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Nhập sai nhập lại");
            }
        }
    }

    private static void deleteIdChinhHang(Scanner scanner, DienThoaiChinhHangController dienThoaiChinhHangController) {
        DienThoaiChinhHang dienThoaiChinhHang;
        System.out.println("Nhập ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        dienThoaiChinhHang = dienThoaiChinhHangController.findByID(id);
        if (dienThoaiChinhHang == null) {
            System.out.println("Không tìm thấy để xóa");
        } else {
            System.out.println("Thông tin của đối tượng: \n" + dienThoaiChinhHang);
            System.out.println("Bạn có chắc muốn xóa không (Y/N):");
            char confirm = scanner.nextLine().charAt(0);
            if (confirm == 'y') {
                dienThoaiChinhHangController.remove(id);
                System.out.println("Xóa thành công");
            }
        }
    }

    private static DienThoaiChinhHang inputChinhHang(Scanner scanner) {
        System.out.println("Nhập ID");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên điên thoại:");
        String tenDienThoai = scanner.nextLine();
        System.out.println("Nhập giá bán:");
        double giaBan = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lượng: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất:");
        String nhaSX = scanner.nextLine();
        System.out.println("Nhâp thời gian bảo hành");
        int thoiGianBH = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập phạm vi bảo hành");
        String phamViBaoHanh = scanner.nextLine();
        DienThoaiChinhHang dienThoaiChinhHang = new DienThoaiChinhHang(id,tenDienThoai,giaBan,soLuong,nhaSX,thoiGianBH,phamViBaoHanh);
        return dienThoaiChinhHang;
    }

    private static int getChoice(Scanner scanner) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai, vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        }
        return choice;
    }
}
