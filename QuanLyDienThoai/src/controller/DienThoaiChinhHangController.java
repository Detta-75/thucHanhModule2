package controller;

import entity.DienThoaiChinhHang;
import service.IDienThoaiChinhHangService;
import service.impl.DienThoaiChinhHangService;

import java.util.List;

public class DienThoaiChinhHangController {
    private IDienThoaiChinhHangService dienThoaiChinhHangService = new DienThoaiChinhHangService();

    public void save(DienThoaiChinhHang dienThoaiChinhHang) {
        dienThoaiChinhHangService.save(dienThoaiChinhHang);
    }

    public DienThoaiChinhHang findByID(int id) {
        return dienThoaiChinhHangService.findById(id);
    }

    public void remove(int id) {
        dienThoaiChinhHangService.remove(id);
    }

    public List<DienThoaiChinhHang> getAll() {
        return dienThoaiChinhHangService.getAll();
    }
}
