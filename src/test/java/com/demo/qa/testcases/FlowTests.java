package com.demo.qa.testcases;

import com.demo.qa.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlowTests extends TestBase {

    @Test(priority = 1, description = "Sisteme login olma, ürün arama ve seçme işlemi başarılı olmalıdır.", groups = {"fonktest", "group1"})
    public void flowTest(){


        try {
            Pages.navigationLinks().clickLoginForm();
            Pages.loginPage().loginMethod(true);
            Assert.assertTrue(Pages.loginPage().formSuccessfullySubmitted(), "giriş başarısızdır.");
            Pages.navigationLinks().clickingFlowMethod();
            Pages.flowPage().flowMethod();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
