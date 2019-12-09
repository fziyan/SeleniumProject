package com.demo.qa.pages;

import com.demo.qa.base.Browser;
import org.openqa.selenium.support.PageFactory;
import java.util.function.Supplier;

public class Pages {
    private static<T> T getPage(Supplier<T> construct) {
        T t = construct.get();
        PageFactory.initElements(Browser.driver, t);
        return t;
    }

    public static navigationLinks navigationLinks() {
        return getPage(navigationLinks::new);
    }
    public static loginPage loginPage(){
        return getPage(loginPage::new);
    }
    public static flowPage flowPage(){
        return getPage(flowPage::new);
    }


}
