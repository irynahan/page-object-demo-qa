package com.telran.demoqa.helpers;


import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Factory;

public class JSExecutor extends PageBase {

    JavascriptExecutor js;
    public JSExecutor(EventFiringWebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public JSExecutor typeNameEmailWithJS(String name, String email) {
        if (name != null && email != null) {
            js.executeScript("document.getElementById('userName').value='" + name + "';");
            js.executeScript("document.getElementById('userName').style.border='2px solid red';");

            js.executeScript("document.getElementById('userEmail').value='" + email + "';");

            WebElement element = driver.findElement(By.id("userName"));
            System.out.println(element.getText() + " by text");
            System.out.println(element.getAttribute("value") + " by value");
        }
        return this;
    }

    public JSExecutor clickOnSubmitWithJS() {

        js.executeScript("document.querySelector('#submit').style.backgroundColor='Red';");
        js.executeScript("document.querySelector('#submit').click();");
        return this;
    }

    @FindBy(id = "name")
    WebElement name;

    public String isDisplayName() {
        return name.getText();
    }

    public JSExecutor checkBoxWithJS() {
        //to handle check box
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=false;");
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=true;");
        return this;
    }

    public JSExecutor alertWithJS() {
        //to generate alert pop window
        js.executeScript("alert('Hello world');");
        return this;
    }

    public JSExecutor refreshBrowserWithJs() {
        //to refresh browser window using JavaScript
        js.executeScript("history.go(0);");
        return this;
    }

    public JSExecutor getTitlePageWithJS() {
        //to get the Title of our web page
        String stringText = js.executeScript("return document.title;").toString();
        System.out.println("*******************************" + "\n" + stringText);
        return this;
    }

    public JSExecutor getUrlPageWithJS() {
        //to get the URL of our page
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("********************************" + "\n" + "URL -> " + url);
        return this;
    }

    public JSExecutor scrollWithJS() {
        //to perform vertical scroll down by 100 pixels
        js.executeScript("window.scrollBy(0,100);");
        return this;
    }
}
