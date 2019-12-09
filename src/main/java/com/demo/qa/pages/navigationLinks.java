package com.demo.qa.pages;

import com.demo.qa.util.Logging;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class navigationLinks {


    @FindBy(xpath = "//a[@title = 'Giriş Yap']")
    @CacheLookup
    WebElement giris;

    @FindBy(id = "searchData")
    @CacheLookup
    WebElement searchBar;

    public void clickLoginForm()
    {
        try{
            Logging.logger.info("Giriş butonuna tıklanıyor..");
            giris.click();
        }
        catch (NoSuchElementException e){
            Logging.logger.error("Giriş butonu bulunamadı! Message:" +e.toString() + System.getProperty("line.seperator"));
        }
    }
    public void clickingFlowMethod()
    {
        try{
            Logging.logger.info("Arama alanına tıklandı..");
            searchBar.click();
        }
        catch (NoSuchElementException e){
            Logging.logger.error("İşlemn başarısızdır! Message:" +e.toString() + System.getProperty("line.seperator"));
        }
    }
}
