package com.jms_pages.utils;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

/**
 * Clase para leer datos desde archivos JSON
 */
public class JsonDataReader {

    /**
     * DataProvider para TestNG que lee datos de login.
     *
     * @return Object[][] con los datos de login.
     */
    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/test/resources/testdata/loginData.json")) {
            JSONArray loginList = (JSONArray) parser.parse(reader);
            Object[][] data = new Object[loginList.size()][1];
            for (int i = 0; i < loginList.size(); i++) {
                data[i][0] = (JSONObject) loginList.get(i);
            }
            return data;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return new Object[][]{};
        }
    }

    /**
     * DataProvider para TestNG que lee datos de formulario.
     *
     * @return Object[][] con los datos de formulario.
     */
    /* @DataProvider(name = "formData")
    public static Object[][] getFormData() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/test/resources/testdata/formData.json")) {
            JSONArray formList = (JSONArray) parser.parse(reader);
            Object[][] data = new Object[formList.size()][1];
            for (int i = 0; i < formList.size(); i++) {
                data[i][0] = (JSONObject) formList.get(i);
            }
            return data;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return new Object[][] {};
        }
    } */
}
