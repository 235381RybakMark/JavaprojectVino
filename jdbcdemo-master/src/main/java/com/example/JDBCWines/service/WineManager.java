package com.example.JDBCWines.service;

import java.util.List;

import com.example.JDBCWines.domain.Wine;

public interface WineManager {

    public int addWine(Wine song);

    public List<Wine> getAllWines();

    public void addAllWines(List<Wine> list);

    public void removeWine(String winename);

    public void removeSelectedWines(List<Wine> list);

}
