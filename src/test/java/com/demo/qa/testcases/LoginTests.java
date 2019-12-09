package com.demo.qa.testcases;

import com.demo.qa.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test(priority = 0, description = "Login olunmalıdır.", groups = {"fonktest", "group1"})
    public void login() throws InterruptedException {

        Pages.navigationLinks().clickLoginForm();
        Pages.loginPage().loginMethod(true);
        Assert.assertTrue(Pages.loginPage().formSuccessfullySubmitted(), "giriş başarısızdır.");

    }
}
