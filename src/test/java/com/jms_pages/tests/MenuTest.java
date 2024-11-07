package com.jms_pages.tests;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.jms_pages.base.BaseTest;
import com.jms_pages.pages.MenuPage;
import com.jms_pages.utils.JsonDataReader;

public class MenuTest extends BaseTest {

    private WebDriver driver;
    private MenuPage menuPage;

    /**
     * Inicializa el WebDriver y la página de Login antes de cada método.
     */
    @BeforeMethod
    public void initialize() {
        driver = com.jms_pages.utils.DriverManager.getInstance().getDriver();
        driver.get("https://demo.ozcart.com/_v5/"); // Reemplaza con la URL real
        menuPage = new MenuPage(driver);
    }

    /**
     * Test deselección del menú en la opción Accessories->Bags-> Evening Bags
     *
     */
    @Test(dataProvider = "loginData", dataProviderClass = JsonDataReader.class)
    public void testMenu(JSONObject loginData) {
        test = extent.createTest("Selección de menú -> Evening Bags");

        try {

            menuPage.selectEveningBags();

            // Aquí puedes agregar verificaciones adicionales, por ejemplo:
            // Assert.assertTrue(dashboardPage.isLoggedIn());
            test.log(Status.PASS, "La selección de la opción 'EveningBags' fue exitosa");
        } catch (Exception e) {
            test.log(Status.FAIL, "Selección de menú fallida. Error: " + e.getMessage());
            Assert.fail("Selección de menú fallida. Error: " + e.getMessage());
        }
    }
}
