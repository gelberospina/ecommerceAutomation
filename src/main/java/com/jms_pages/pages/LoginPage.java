package com.jms_pages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Clase que representa la página de Login utilizando Page Factory Pattern
 */
public class LoginPage {

    private WebDriver driver;

    // Page elements
    @FindBy(xpath = "//button[@name='boton']")
    private WebElement btnLogin;

    @FindBy(xpath = "//button[@name='boton']")
    private WebElement userInput;

    @FindBy(xpath = "//button[@name='boton']")
    private WebElement btnNext;

    @FindBy(xpath = "//button[@name='boton']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@name='boton']")
    private WebElement btnVerify;

    /**
     * Constructor de la página de Login.
     *
     * @param driver WebDriver instance.
     */
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Métodos para interactuar con los elementos
    public void clickLoginButton() {
        btnLogin.click();
    }

    /**
     * Ingresa el nombre de usuario.
     *
     * @param username Nombre de usuario.
     */
    public void enterUsername(String username) {
        userInput.sendKeys(username);
    }

    public void clickNextButton() {
        btnNext.click();
    }

    /**
     * Ingresa la contraseña.
     *
     * @param password Contraseña.
     */
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickVerify() {
        btnVerify.click();
    }

    /**
     * Realiza el proceso completo de login.
     *
     * @param username Nombre de usuario.
     * @param password Contraseña.
     */
    public void login(String username, String password) {
        clickLoginButton();
        enterUsername(username);
        clickNextButton();
        enterPassword(password);
        clickVerify();

    }
}
