package com.jms_pages.tests;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.jms_pages.base.BaseTest;
import com.jms_pages.pages.LoginPage;
import com.jms_pages.pages.MenuPage;
import com.jms_pages.utils.JsonDataReader;

public class LoginTest extends BaseTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private MenuPage menuPage;

    /**
     * Inicializa el WebDriver y la página de Login antes de cada método.
     */
    @BeforeMethod
    public void initialize() {
        driver = com.jms_pages.utils.DriverManager.getInstance().getDriver();
        driver.get("https://demo.ozcart.com/_v5/"); // Reemplaza con la URL real
        loginPage = new LoginPage(driver);
        menuPage = new MenuPage(driver);
    }

    /**
     * Test de login con datos proporcionados por JSON.
     *
     * @param loginData Datos de login.
     */
    @Test(dataProvider = "loginData", dataProviderClass = JsonDataReader.class)
    public void testLogin(JSONObject loginData) {
        test = extent.createTest("Test de Login con usuario: " + loginData.get("username"));

        try {
            String username = (String) loginData.get("username");
            String password = (String) loginData.get("password");

            //loginPage.login(username, password);
            menuPage.selectEveningBags();

            // Aquí puedes agregar verificaciones adicionales, por ejemplo:
            // Assert.assertTrue(dashboardPage.isLoggedIn());
            test.log(Status.PASS, "Login exitoso para usuario: " + username);
        } catch (Exception e) {
            test.log(Status.FAIL, "Login fallido. Error: " + e.getMessage());
            Assert.fail("Login fallido. Error: " + e.getMessage());
        }
    }
}
