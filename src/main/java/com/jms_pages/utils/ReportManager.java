package com.jms_pages.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

    private static ExtentReports extent;

    /**
     * Obtiene la instancia única de ExtentReports.
     *
     * @return ExtentReports instance.
     */
    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance("test-output/extent-report.html");
        }
        return extent;
    }

    /**
     * Crea una instancia de ExtentReports con ExtentSparkReporter.
     *
     * @param fileName Ruta del archivo de reporte.
     * @return ExtentReports instance.
     */
    public static ExtentReports createInstance(String fileName) {
        // Crear una instancia de ExtentSparkReporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);

        // Configurar el tema del reporte
        sparkReporter.config().setTheme(Theme.STANDARD); // Puedes cambiar a Theme.DARK si lo prefieres
        sparkReporter.config().setDocumentTitle("Reporte de Pruebas Automatizadas");
        sparkReporter.config().setReportName("Reporte de Automatización de Pruebas");
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        // Crear una instancia de ExtentReports y adjuntar el reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Configurar información del sistema (opcional)
        extent.setSystemInfo("Sistema Operativo", System.getProperty("os.name"));
        extent.setSystemInfo("Usuario", System.getProperty("user.name"));
        extent.setSystemInfo("Versión de Java", System.getProperty("java.version"));
        extent.setSystemInfo("Versión de Selenium", "4.9.1"); // Asegúrate de actualizar esto según tu versión
        extent.setSystemInfo("Framework", "TestNG");

        return extent;
    }
}
