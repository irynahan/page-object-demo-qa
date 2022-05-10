package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.LinksPage;
import com.telran.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getElementsPage();
    }

    @Test
    public void getAllLinksTest() {
        new SidePanel(driver).selectLinks();
        new LinksPage(driver).checkAllUrl();
    }

    @Test
    public void getBrokenLinksTest() {
        new SidePanel(driver).selectLinks();
        new LinksPage(driver).checkBrokenLinks();
    }

    @Test
    public void getBrokenLinks2Test() {
        new SidePanel(driver).selectBrokenLinksImages();
        new LinksPage(driver).checkBrokenLinks();
    }

    @Test
    public void getBrokenImagesTest() {
        new SidePanel(driver).selectBrokenLinksImages();
        new LinksPage(driver).checkBrokenImages();
    }


}
