/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author cesar
 */
public class PropertiesFile {
    public static Properties getConfigProperties() {
        Properties properties = new Properties();
        InputStream input = PropertiesFile.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(input);
        } catch (IOException ex) {
            return null;
        }
        return properties;
    }
        public static Properties getPropertiesAuthentication() {
        Properties properties = new Properties();
        InputStream input = PropertiesFile.class.getClassLoader().getResourceAsStream("authentication.properties");
        try {
            properties.load(input);
        } catch (IOException ex) {
            return null;
        }
        return properties;
    }
}
