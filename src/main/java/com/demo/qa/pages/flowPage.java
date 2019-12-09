package com.demo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class flowPage {

    @FindBy(id = "searchData")
    WebElement searchBar;

    @FindBy(xpath = "//a[contains(@class, 'searchBtn')]")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id='contentListing']/div/div/div[2]/div[4]/a[2]")
    WebElement pageTwo;

    @FindBy(xpath = "//section[@class ='group listingGroup resultListGroup import-search-view']//li[7]//img")
    WebElement clickProduct;

    @FindBy(xpath = "//a[contains(@class, 'btn btnGrey btnAddBasket')]")
    WebElement addBtnBasket;

    @FindBy(xpath = "//h1[@class='proName']")
    WebElement productName;

    @FindBy(xpath = "//div[@class = 'newPrice']/ins")
    WebElement productPrice;

    @FindBy(xpath = "//a[@class ='btn btnBlack btnGoBasket']")
    WebElement btnGoBasket;

    @FindBy(xpath = "//span[contains(@class, 'removeProd svgIcon svgIcon_trash') ]")
    WebElement deleteProduct;

    @FindBy(xpath = "//a[@class = 'prodDescription']")
    WebElement basketProductName;

    @FindBy(xpath = "//div[@class = 'priceArea']/span")
    WebElement basketProductPrice;

    @FindBy(xpath = "//span[@class = 'spinnerUp spinnerArrow']")
    WebElement spinnerUp;

    @FindBy(xpath = "//span[@class = 'spinnerDown spinnerArrow']")
    WebElement spinnerDown;

    @FindBy(name = "quantity")
    WebElement spinnerField;

    String p1;
    String p2;
    char[] data;

    public void flowMethod() throws InterruptedException{

        searchBar.sendKeys("Bilgisayar");
        searchButton.click();
        Thread.sleep(2000);
        pageTwo.click();         //2. sayfaya tıklar.
        clickProduct.click();    //2. sayfada bir ürüne tıklanır.
        writeFileProduct(productName.getText(), productPrice.getText());
        addBtnBasket.click();    //ürün sepete eklenir.
        readFileProduct();
        Thread.sleep(2000);
        btnGoBasket.click();     // sepete git
        Thread.sleep(3000);
        spinnerUp.click();
        System.out.println(spinnerField.getAttribute("value"));
        deleteProduct.click();   //ürünü sil
    }
    public String writeFileProduct(String productName, String productPrice){

        File file = new File("test.txt" );

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(productName  + "  " + productPrice);
            fileWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return productPrice;
    }

    public void readFileProduct(){

        // File file = new File("test.txt");
        try {
                /*FileReader fileReader = new FileReader(file);
                data = new char[(int) file.length()];
                fileReader.read(data);
            fileReader.close();*/

            Scanner scanner = new Scanner(new File("C:\\Users\\Songo\\Desktop\\DemoProject\\test.txt"));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
