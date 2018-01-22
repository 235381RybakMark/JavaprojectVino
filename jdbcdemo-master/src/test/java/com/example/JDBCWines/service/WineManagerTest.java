package com.example.JDBCWines.service;
import com.example.JDBCWines.domain.Wine;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WineManagerTest {


    WineManagerJDBC WineManager = new WineManagerJDBC();

    private final static String[] WINENAME = {"Fresko", "Cote", "Kadarka", "Amareno", "Porto"};
    private final static String[] TASTENAME = {"wytrawne", "slodkie", "wytrawne", "slodkie", "polwytrawne"};
    private final static double[] COST = {12.99, 7.20, 18.75, 3.45, 17.20};
    private final static String[] YEAR = {"2013", "2018", "2017", "2013", "2018"};

    @Test
    public void checkConnection() {
        assertNotNull(WineManager.getConnection());
    }

    @Test
    public void checkAdding() {
        if (WINENAME.length == TASTENAME.length && TASTENAME.length == COST.length && TASTENAME.length == YEAR.length) {
            int i = 0;
            Wine[] Wine = new Wine[WINENAME.length];
            WineManager.clearWines();

            for (i = 0; i < WINENAME.length - 3; i++) {
                Wine[i] = new Wine(WINENAME[i], TASTENAME[i], COST[i], YEAR[i]);
                assertEquals(1, WineManager.addWine(Wine[i]));
            }

            List<Wine> Wines = WineManager.getAllWines();
            Wine[] WineRetrieved = new Wine[WINENAME.length];

            for (i = 0; i < WINENAME.length - 3; i++) {
                WineRetrieved[i] = Wines.get(i);

                assertEquals(WINENAME[i], WineRetrieved[i].getWinename());
                assertEquals(TASTENAME[i], WineRetrieved[i].getTastename());
                assertEquals((int) COST[i], (int) WineRetrieved[i].getCost());
                assertEquals(YEAR[i], WineRetrieved[i].getYear());
            }
        }
    }

    @Test
    public void checkAddingList() {
        WineManager.clearWines();
        List<Wine> listToAdd = new ArrayList<>();

        Wine Wine1 = new Wine(WINENAME[1], TASTENAME[2], COST[2], YEAR[2]);
        Wine Wine2 = new Wine(WINENAME[3], TASTENAME[3], COST[3], YEAR[3]);
        Wine Wine3 = new Wine(WINENAME[4], TASTENAME[4], COST[4], YEAR[4]);

        listToAdd.add(Wine1);
        listToAdd.add(Wine2);
        listToAdd.add(Wine3);

        WineManager.addAllWines(listToAdd);
        List<Wine> Wines = WineManager.getAllWines();

        assertEquals(3, Wines.size());
        WineManager.clearWines();
        listToAdd.clear();

        Wine1.setWinename(WINENAME[2]);
        listToAdd.add(Wine1);
        listToAdd.add(Wine2);
        listToAdd.add(Wine3);

        WineManager.addAllWines(listToAdd);
        Wines = WineManager.getAllWines();

        assertEquals(3, Wines.size());

    }

    @Test
    public void checkDeleting() {
        WineManager.clearWines();
        Wine Wine1 = new Wine("test", "test", 29, "2017");
        WineManager.addWine(Wine1);
        WineManager.removeWine("test");
        List<Wine> Wines = WineManager.getAllWines();
        assertEquals(0, Wines.size());
    }

    @Test
    public void checkDeletingSelected() {
    	Wine Wine1 = new Wine(WINENAME[2], TASTENAME[2], COST[2], YEAR[2]);
    	Wine Wine2 = new Wine(WINENAME[3], TASTENAME[3], COST[3], YEAR[3]);
    	Wine Wine3 = new Wine(WINENAME[4], TASTENAME[4], COST[4], YEAR[4]);
        
    	WineManager.clearWines();
        List<Wine> WineList = new ArrayList<>();
        WineList.add(Wine1);
        WineList.add(Wine2);
        WineList.add(Wine3);
        WineManager.addAllWines(WineList);
        WineList.remove(Wine1);
        WineList.remove(Wine3);
        WineManager.removeSelectedWines(WineList);
        List<Wine> Wines = WineManager.getAllWines();

        assertEquals(2, Wines.size());
        WineManager.removeSelectedWines(WineList);
        Wines = WineManager.getAllWines();

        assertEquals(2, Wines.size());
    }
}
