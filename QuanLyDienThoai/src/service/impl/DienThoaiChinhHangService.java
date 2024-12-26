package service.impl;

import entity.DienThoaiChinhHang;
import repository.DienThoaiChinhHangRepository;
import service.IDienThoaiChinhHangService;

import java.util.Collections;
import java.util.List;

public class DienThoaiChinhHangService implements IDienThoaiChinhHangService {
    private static DienThoaiChinhHangRepository dienThoaiChinhHangRepository = new DienThoaiChinhHangRepository();
    @Override
    public List<DienThoaiChinhHang> getAll() {
        return dienThoaiChinhHangRepository.findAll();
    }

    @Override
    public void save(DienThoaiChinhHang dienThoaiChinhHang) {
        dienThoaiChinhHangRepository.save(dienThoaiChinhHang);
    }

    @Override
    public void remove(int id) {
        dienThoaiChinhHangRepository.remove(id);
    }

    @Override
    public DienThoaiChinhHang findById(int id) {
        return dienThoaiChinhHangRepository.findById(id);
    }


}
