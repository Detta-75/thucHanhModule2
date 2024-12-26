package entity;

public class DienThoaiChinhHang extends DienThoai{
    private int thoiGianBH;
    private String phamViBaoHanh;

    public DienThoaiChinhHang() {
    }

    public DienThoaiChinhHang(int id,String tenDienThoai, double giaBan, int soLuong, String nhaSX, int thoiGianBH, String phamViBaoHanh) {
        super(id, tenDienThoai, giaBan, soLuong, nhaSX);
        this.thoiGianBH = thoiGianBH;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public int getThoiGianBH() {
        return thoiGianBH;
    }

    public void setThoiGianBH(int thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String toString() {
        return super.toString() + "," + thoiGianBH + "," + phamViBaoHanh;
    }
}
