package service;

import entity.DienThoai;

import java.util.List;

public interface IService<T extends DienThoai> {
    List<T> getAll();

    void save(T t);

    void remove(int id);

    T findById(int id);
}
