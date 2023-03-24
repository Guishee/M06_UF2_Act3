package com.example.act3uf2m06.Model;

import com.example.act3uf2m06.Model.Clients;

import java.util.List;

public interface HibernateDao {
    List<Clients> getAll();
    Clients getById(int id);
    void save(Clients c);
    void update(Clients c);
    void delete(Clients c);
}
