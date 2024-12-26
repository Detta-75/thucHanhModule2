package entity;

public class DienThoai {
    private int id;
    private String tenDienThoai;
    private double giaBan;
    private int soLuong;
    private String nhaSX;

    public DienThoai() {
    }

    public DienThoai(int id, String tenDienThoai, double giaBan, int soLuong, String nhaSX) {
        this.id = id;
        this.tenDienThoai = tenDienThoai;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.nhaSX = nhaSX;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSX() {
        return nhaSX;
    }

    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }

    @Override
    public String toString() {
        return id + "," + tenDienThoai + "," + giaBan + "," + soLuong + "," + nhaSX;
    }
}
