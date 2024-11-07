package com.jms_pages.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.jms_pages.utils.DriverManager;
import com.jms_pages.utils.ReportManager;

/**
 * Clase base para todas las pruebas. Configura y finaliza los reportes de
 * ExtentReports.
 */
public class BaseTest {

    protected ExtentReports extent;
    protected ExtentTest test;

    /**
     * Método que se ejecuta antes de todas las pruebas de la clase. Inicializa
     * ExtentReports.
     */
    @BeforeClass
    public void setUp() {
        extent = ReportManager.getInstance();
    }

    /**
     * Método que se ejecuta después de todas las pruebas de la clase. Cierra el
     * WebDriver y escribe los reportes.
     */
    @AfterClass
    public void tearDown() {
        DriverManager.getInstance().quitDriver();
        extent.flush();
    }
}
