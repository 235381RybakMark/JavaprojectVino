package com.example.shdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import com.example.shdemo.domain.Wine;
import com.example.shdemo.domain.Smak;
import com.example.shdemo.domain.Kolor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class WineManagerTest {

    @Autowired
    WineManager wineManager;
    
    private final String WINENAME_1 = "Fresco";
    private final String PANSTWONAME_1 = "Polska";
    private final double COST_1 = 12.99;
    private final int YOR_1 = 2018;
    
    private final String WINENAME_2 = "Carlo Rossi";
    private final String PANSTWONAME_2 = "USA";
    private final double COST_2 = 19.99;
    private final int YOR_2 = 1991;
    
    private final String WINENAME_3 = "Porto";
    private final String PANSTWONAME_3 = "Italia";
    private final double COST_3 = 30.99;
    private final int YOR_3 = 1991;
    
    Smak smak1 = new Smak("wytrawny");
    Smak smak2 = new Smak("slodkie");
    Smak smak3 = new Smak("slodkie");
    
    Kolor kolor1 = new Kolor("czerwone");
    Kolor kolor2 = new Kolor("biale");
    Kolor kolor3 = new Kolor("czerwone");
    
    @Test
    public void addWineCheck() {
        Wine wine = new Wine();

        wine.setWinename(WINENAME_1);
        wine.setBandname(PANSTWONAME_1);
        wine.setCost(COST_1);
        wine.setYor(YOR_1);

        wine.setSmak(smak1);
        wine.setKolor(kolor1);

        List<Wine> before = wineManager.getAllWines();
        wineManager.addWine(wine);
        List<Wine> after = wineManager.getAllWines();
        assertEquals(before.size() + 1, after.size());
    }

    @Test
    public void deleteWineCheck(){
    	Wine wine = new Wine();

        wine.setWinename(WINENAME_2);
        wine.setBandname(PANSTWONAME_2);
        wine.setCost(COST_2);
        wine.setYor(YOR_2);

        wine.setSmak(smak2);
        wine.setKolor(kolor2);

        wineManager.addWine(wine);
        List<Wine> before = wineManager.getAllWines();
        wineManager.deleteWine(wine);
        List<Wine> after = wineManager.getAllWines();
        assertEquals(before.size(), after.size()+1);
    }

    @Test
    public void addSmakCheck() {
        Smak smak = new Smak("polwutrawne");

        List<Smak> before = wineManager.getAllSmaks();

        wineManager.addSmak(smak);

        List<Smak> after = wineManager.getAllSmaks();

        assertEquals(before.size() + 1, after.size());
    }

    @Test
    public void deleteSmakCheck() {
    	Smak smak = new Smak("czerwone");

    	wineManager.addSmak(smak);

        List<Smak> before = wineManager.getAllSmaks();

        wineManager.deleteSmak(smak);

        List<Smak> after = wineManager.getAllSmaks();

        assertEquals(before.size(), after.size() + 1);
    }
    @Test
    public void addKolorCheck() {
        Kolor kolor = new Kolor("rozowe");

        List<Kolor> before = wineManager.getAllKolors();

        wineManager.addKolor(kolor);

        List<Kolor> after = wineManager.getAllKolors();

        assertEquals(before.size() + 1, after.size());
    }


    @Test
    public void deleteKolorCheck() {
    	Kolor kolor = new Kolor("biale");

    	wineManager.addKolor(kolor);

    	List<Kolor> before = wineManager.getAllKolors();

        wineManager.deleteKolor(kolor);

        List<Kolor> after = wineManager.getAllKolors();

        assertEquals(before.size(), after.size() + 1);
    }



    
}
