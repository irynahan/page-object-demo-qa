package com.telran.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AutoCompletePage extends PageBase{

    public AutoCompletePage(WebDriver driver) {
        super(driver);
    }



    @FindBy (xpath = "//input[@id = 'autoCompleteMultipleInput']")
    WebElement typeMultipleColorNamesField;


    public AutoCompletePage selectMultipleColorName(String [] color) {
        for (int i = 0; i < color.length; i++){
            if (color[i] != null) {
                type(typeMultipleColorNamesField, color[i]);
                typeMultipleColorNamesField.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    @FindBy (xpath = "//input[@id = 'autoCompleteSingleInput']")
    WebElement typeSingleColorName;

    @FindBy (xpath = "//div[contains(@class, 'singleValue')]")
    WebElement textSingleColorName;

    public void selectSingleColorName(String color) {
        type(typeSingleColorName, color);
        typeSingleColorName.sendKeys(Keys.ENTER);
    }

    public String getTextFromSingleColorName() {
        return textSingleColorName.getText();
    }

    @FindBy (xpath = "//div[contains(@class,'multi-value__label')]")
    List <WebElement> selectedColorsList;

    public boolean  getTextFromMultipleColorName(String [] colors) {
        for (int i = 0; i < selectedColorsList.size(); i++){
            if(!selectedColorsList.get(i).getText().equals(colors[i])){
                return false;
            }
        }
        return colors.length == selectedColorsList.size();
    }


}
