package ViatorCalendar;

import io.restassured.RestAssured;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static Properties config;
    public static final org.apache.log4j.Logger logger = LogManager.getLogger(TestBase.class);

    @BeforeClass
    public void setup() throws IOException {
        TestBase.setBaseURI("https://tbx.backend.staging.travel.theculturetrip.com/");

        config = new Properties();
        FileInputStream fis = new FileInputStream("E:\\LearningMe\\AvailabilityCalendar\\src\\test\\java\\constants\\config.properties");
        config.load(fis);
    }


    public static void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
        PropertyConfigurator.configure("E:\\LearningMe\\AvailabilityCalendar\\src\\main\\java\\log4j.properties");
        logger.trace("This is a debug message");
        logger.info("This is an info message");
    }

}
