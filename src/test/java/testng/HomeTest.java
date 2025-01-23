package testng;

import org.testng.annotations.Test;

public class HomeTest {

    @Test
    public void makeFoundation() {
        System.out.println("Make foundation : Foundation is created.");
    }

    @Test(dependsOnMethods = "makeFoundation")
    public void makeWalls() {
        System.out.println("Make walls : Walls are created.");
    }

    @Test(dependsOnMethods = "makeWalls")
    public void makeRoof() {
        System.out.println("Make roof : Roof is created.");
    }

    @Test(dependsOnMethods = {"makeWalls","makeRoof"})
    public void fixDoorsAndWindows() {
        System.out.println("Fix Doors And Windows :  Doors And Windows are created.");
    }

    @Test(dependsOnMethods = {"makeWalls","makeRoof"})
    public void supplyElectricityAndWater() {
        System.out.println("Supply Electricity And Water : Electricity And Water supplied.");
    }
}
