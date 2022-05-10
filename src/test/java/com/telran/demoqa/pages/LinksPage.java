package com.telran.demoqa.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class LinksPage extends PageBase{

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    public LinksPage checkAllUrl() {

        String url = "";
        System.out.println("Total links on the web lage: " + allLinks.size());

        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    public LinksPage checkBrokenLinks() {
        for (int i = 0; i < allLinks.size(); i++) {
            WebElement el = allLinks.get(i);
            String url = el.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    private void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.setConnectTimeout(5000);
            connect.connect();
            if (connect.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + connect.getResponseMessage() + " is a broken link");
            } else {
                System.out.println(linkUrl + " - " + connect.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + e.getMessage() + " - is a broken link");
        }
    }

    @FindBy(tagName = "img")
    List<WebElement> images;

    public LinksPage checkBrokenImages() {
        System.out.println("We have " + images.size() + " " + "images");

        for (int index = 0; index < images.size(); index++) {
            WebElement image = this.images.get(index);
            String imageUrl = image.getAttribute("src");
            System.out.println("URL of image " + (index + 1) + " is: " + imageUrl);
            verifyLinks(imageUrl);

            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                    System.out.println("***************************************");
                } else {
                    System.out.println("DISPLAY - BROKEN");
                    System.out.println("***************************************");
                }
            }catch (Exception e) {
                System.out.println("Error Occurred");
            }
        }
        return this;
    }
}
