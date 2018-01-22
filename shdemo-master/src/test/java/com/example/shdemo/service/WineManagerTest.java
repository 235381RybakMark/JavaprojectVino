package com.example.shdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import com.example.shdemo.domain.Wine;
import com.example.shdemo.domain.Serial;
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
    
    private final String SONGNAME_1 = "Sad but True";
    private final String BANDNAME_1 = "Metallica";
    private final double COST_1 = 15.99;
    private final int YOR_1 = 1991;
    
    private final String SONGNAME_2 = "Enter Sandman";
    private final String BANDNAME_2 = "Metallica";
    private final double COST_2 = 2.99;
    private final int YOR_2 = 1991;
    
    private final String SONGNAME_3 = "Nothing else Matters";
    private final String BANDNAME_3 = "Metallica";
    private final double COST_3 = 30.99;
    private final int YOR_3 = 1991;
    
    Serial serial1 = new Serial("qwert");
    Serial serial2 = new Serial("asdfg");
    Serial serial3 = new Serial("zxcvb");
    
    Kolor kolor1 = new Kolor("Heavy Metal");
    Kolor kolor2 = new Kolor("Metal");
    Kolor kolor3 = new Kolor("Thrash Metal");
    
    @Test
    public void addWineCheck() {
        Wine wine = new Wine();

        wine.setWinename(SONGNAME_1);
        wine.setTastename(BANDNAME_1);
        wine.setCost(COST_1);
        wine.setYear(YOR_1);

        wine.setSerial(serial1);
        wine.setKolor(kolor1);

        List<Wine> before = wineManager.getAllWines();
        wineManager.addWine(wine);
        List<Wine> after = wineManager.getAllWines();
        assertEquals(before.size() + 1, after.size());
    }

    @Test
    public void deleteWineCheck(){
    	Wine wine = new Wine();

        wine.setWinename(SONGNAME_2);
        wine.setTastename(BANDNAME_2);
        wine.setCost(COST_2);
        wine.setYear(YOR_2);

        wine.setSerial(serial2);
        wine.setKolor(kolor2);

        wineManager.addWine(wine);
        List<Wine> before = wineManager.getAllWines();
        wineManager.deleteWine(wine);
        List<Wine> after = wineManager.getAllWines();
        assertEquals(before.size(), after.size()+1);
    }

    @Test
    public void addSerialCheck() {
        Serial serial = new Serial("werty");

        List<Serial> before = wineManager.getAllSerials();

        wineManager.addSerial(serial);

        List<Serial> after = wineManager.getAllSerials();

        assertEquals(before.size() + 1, after.size());
    }

    @Test
    public void deleteSerialCheck() {
    	Serial serial = new Serial("sdfgh");

    	wineManager.addSerial(serial);

        List<Serial> before = wineManager.getAllSerials();

        wineManager.deleteSerial(serial);

        List<Serial> after = wineManager.getAllSerials();

        assertEquals(before.size(), after.size() + 1);
    }
    @Test
    public void addKolorCheck() {
        Kolor kolor = new Kolor("Pop");

        List<Kolor> before = wineManager.getAllKolors();

        wineManager.addKolor(kolor);

        List<Kolor> after = wineManager.getAllKolors();

        assertEquals(before.size() + 1, after.size());
    }


    @Test
    public void deleteKolorCheck() {
    	Kolor kolor = new Kolor("Rock");

    	wineManager.addKolor(kolor);

    	List<Kolor> before = wineManager.getAllKolors();

        wineManager.deleteKolor(kolor);

        List<Kolor> after = wineManager.getAllKolors();

        assertEquals(before.size(), after.size() + 1);
    }



    
}
