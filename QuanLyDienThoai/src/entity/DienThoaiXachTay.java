package entity;

public class DienThoaiXachTay extends DienThoai{
    private String quocGiaXT;
    private String trangThai;

    public DienThoaiXachTay() {
    }

    public DienThoaiXachTay(int id, String tenDienThoai, double giaBan, int soLuong, String nhaSX, String quocGiaXT, String trangThai) {
        super(id, tenDienThoai, giaBan, soLuong, nhaSX);
        this.quocGiaXT = quocGiaXT;
        this.trangThai = trangThai;
    }

    public String getQuocGiaXT() {
        return quocGiaXT;
    }

    public void setQuocGiaXT(String quocGiaXT) {
        this.quocGiaXT = quocGiaXT;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return super.toString() + "," + quocGiaXT + "," +trangThai;
    }
}
