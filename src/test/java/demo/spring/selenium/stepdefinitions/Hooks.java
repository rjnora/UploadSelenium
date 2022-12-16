package demo.spring.selenium.stepdefinitions;

import demo.spring.selenium.SpringContextConfiguration;
import demo.spring.selenium.config.ConfigProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = {SpringContextConfiguration.class})
public class Hooks {
    @Autowired
    private WebDriver driver;

    @Autowired
    private ConfigProperties properties;

    @Before
    public void openBrowser() {
        driver.get(properties.getUrl());
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        Thread.sleep(5000);
//        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
//        }
        driver.quit();
    }
}