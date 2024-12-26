package service.impl;

import entity.DienThoaiXachTay;
import repository.DienThoaXachTayRepository;
import service.IDienThoaiXachTayService;

import java.util.Collections;
import java.util.List;

public class DienThoaiXachTayService implements IDienThoaiXachTayService {
    private static DienThoaXachTayRepository dienThoaXachTayRepository = new DienThoaXachTayRepository();
    @Override
    public List<DienThoaiXachTay> getAll() {
        return dienThoaXachTayRepository.findAll();
    }

    @Override
    public void save(DienThoaiXachTay dienThoaiXachTay) {
        dienThoaXachTayRepository.save(dienThoaiXachTay);
    }

    @Override
    public void remove(int id) {
        dienThoaXachTayRepository.remove(id);
    }

    @Override
    public DienThoaiXachTay findById(int id) {
        return dienThoaXachTayRepository.findById(id);
    }

}
