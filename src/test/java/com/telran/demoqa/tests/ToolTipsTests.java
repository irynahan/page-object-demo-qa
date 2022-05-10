package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanel;
import com.telran.demoqa.pages.ToolTipsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getWidgetsPage();
        new SidePanel(driver).selectToolTips();
    }

    @Test
    public void hoverToolTipsWithAttributeTest() {
        new ToolTipsPage(driver).hoverToolTipsWithAttribute();
    }

    @Test
    public void hoverOnInputTest() {
        new ToolTipsPage(driver).hoverOnInputToSee();
    }
}