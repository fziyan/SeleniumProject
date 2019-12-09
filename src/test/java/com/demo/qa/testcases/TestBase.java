package com.demo.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static com.demo.qa.base.Browser.driver;
import static com.demo.qa.base.Browser.initialization;

public class TestBase {

    @BeforeMethod
    public void setUp() {
        initialization();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //TimeUnit.SECONDS.sleep(10);
        driver.quit();
    }
}
