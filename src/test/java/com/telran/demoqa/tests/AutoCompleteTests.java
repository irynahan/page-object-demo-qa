package com.telran.demoqa.tests;

import com.telran.demoqa.pages.AutoCompletePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getWidgetsPage();
        new SidePanel(driver).selectAutoComplete();
    }

    @Test
    public void multipleColorNamesTest() {
        String [] colors = new String[]{"Red","Green", "Black"};
        new AutoCompletePage(driver).selectMultipleColorName(colors);
        Assert.assertTrue(new AutoCompletePage(driver).getTextFromMultipleColorName(colors));
    }

    @Test
    public void singleColorNameTest() {
        new AutoCompletePage(driver).selectSingleColorName("Blue");
        Assert.assertEquals(new AutoCompletePage(driver).getTextFromSingleColorName() ,"Blue");
    }


}
