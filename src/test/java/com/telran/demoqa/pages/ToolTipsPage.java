package com.telran.demoqa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends PageBase{

    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "toolTipButton")
    WebElement toolTipButton;

    @FindBy(id = "buttonToolTip")
    WebElement toolTip;

    public ToolTipsPage hoverToolTipsWithAttribute() {

        click(toolTipButton);
        String expectedToolTip = toolTip.getAttribute("id");
        System.out.println("Retrived tooltip as: " + expectedToolTip);
        return this;
    }

    @FindBy(id = "toolTipTextField")
    WebElement toolTipTextField;

    @FindBy(id = "textFieldToolTip")
    WebElement toolTip2;

    public ToolTipsPage hoverOnInputToSee() {

        Actions actions = new Actions(driver);
        actions.moveToElement(toolTipTextField).perform();
        String toolTipText = toolTip2.getText();
        System.out.println(toolTipText);
        if (toolTipText.equalsIgnoreCase("You hovered over the text field")) {
            System.out.println("PASS: Tooltip matching expected value");
        } else {
            System.out.println("FAIL: tooltip Not matching expected value");
        }
        return this;
    }
}
