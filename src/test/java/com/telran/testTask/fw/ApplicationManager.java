package com.telran.testTask.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    public ItemHelper getItem() {
        return item;
    }

    public CategoryHelper getCategory() {
        return category;
    }

    public HomePageHelper getHomePage() {
        return homePage;
    }

    ItemHelper item;
    CategoryHelper category;
    HomePageHelper homePage;

    public void stop() {
        wd.quit();
    }

    public void init() {
        wd = new ChromeDriver();
        wd.get("https://yandex.ru/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        item = new ItemHelper(wd);
        category = new CategoryHelper(wd);
        homePage = new HomePageHelper(wd);
    }

}
