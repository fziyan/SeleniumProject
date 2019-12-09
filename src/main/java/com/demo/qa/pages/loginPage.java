package com.demo.qa.pages;

import com.demo.qa.util.Logging;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class loginPage {

    @FindBy(id = "email")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "loginButton")
    WebElement loginButton;


    @FindBy(xpath = "//a[@class = 'menuLink user']")
    WebElement loginSucces;

    public void loginMethod(boolean User) {

        try {

            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Songo\\Desktop\\DemoProject\\login.txt"));
            String p1 = lines.get(0);
            String p2 = lines.get(1);

                username.sendKeys(p1);
                password.sendKeys(p2);
                loginButton.click();


        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public boolean formSuccessfullySubmitted(){

        try
        {
            Logging.logger.info("Login başarılıdır.");
            return loginSucces.isDisplayed();
        } catch (NoSuchElementException e)
        {
            Logging.logger.error("Login başarısızdır.: " + e.toString() + System.getProperty("line.separator"));
            return false;
        }

    }

}
