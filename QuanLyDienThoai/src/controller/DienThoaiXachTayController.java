package controller;

import entity.DienThoaiXachTay;
import service.IDienThoaiXachTayService;
import service.impl.DienThoaiXachTayService;

import java.util.List;

public class DienThoaiXachTayController {
    private IDienThoaiXachTayService dienThoaiXachTayService = new DienThoaiXachTayService();

    public void save(DienThoaiXachTay dienThoaiXachTay) {
        dienThoaiXachTayService.save(dienThoaiXachTay);
    }

    public DienThoaiXachTay findByID(int id) {
        return dienThoaiXachTayService.findById(id);
    }

    public void remove(int id) {
        dienThoaiXachTayService.remove(id);
    }

    public List<DienThoaiXachTay> getAll() {
        return dienThoaiXachTayService.getAll();
    }
}
