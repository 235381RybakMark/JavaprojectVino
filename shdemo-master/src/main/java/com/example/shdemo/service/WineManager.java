package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Serial;
import com.example.shdemo.domain.Kolor;
import com.example.shdemo.domain.Wine;


public interface WineManager {
	
	void addWine(Wine wine);
	void deleteWine(Wine wine);
	List<Wine> getAllWines();
	void updateWine(Wine oldwine, Wine newwine);
	
	void addSerial(Serial serial);
	void deleteSerial(Serial serial);
	List<Serial> getAllSerials();
	
	void addKolor(Kolor kolor);
	void deleteKolor(Kolor kolor);
	List<Kolor> getAllKolors();

}
