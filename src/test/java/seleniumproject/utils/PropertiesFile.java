package seleniumproject.utils;

import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

public  class PropertiesFile {

    static Properties properties = new Properties();
    public static Properties fetchFromPropertyFile() {

        try {
            InputStream inputStream = new FileInputStream("/home/vandanatiwari/IdeaProjects/seleinumLearning/src/test/java/config/config.properties");
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
}


    }


