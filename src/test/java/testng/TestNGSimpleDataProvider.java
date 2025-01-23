package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGSimpleDataProvider {

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
              new Object[]{"Amal",25},
              new Object[]{"Kamal",30},
              new Object[]{"Sunil",45}
        };
    }

    @Test(dataProvider = "getData")
    public void testSimpleDataProvider(String name, int age) {
        System.out.printf("My name is %s and I'm %d years old.\n", name, age);
    }
}
