package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Smak;
import com.example.shdemo.domain.Kolor;
import com.example.shdemo.domain.Wine;


public interface WineManager {
	
	void addWine(Wine wine);
	void deleteWine(Wine wine);
	List<Wine> getAllWines();
	void updateWine(Wine oldwine, Wine newwine);
	
	void addSmak(Smak smak);
	void deleteSmak(Smak smak);
	List<Smak> getAllSmaks();
	
	void addKolor(Kolor kolor);
	void deleteKolor(Kolor kolor);
	List<Kolor> getAllKolors();

}
