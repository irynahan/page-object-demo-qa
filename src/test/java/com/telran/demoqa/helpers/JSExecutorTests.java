package com.telran.demoqa.helpers;

import com.telran.demoqa.data.UserData;
import com.telran.demoqa.pages.AlertPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanel;
import com.telran.demoqa.pages.TextBoxPage;
import com.telran.demoqa.tests.TestBase;
import org.testng.annotations.Test;

public class JSExecutorTests extends TestBase {

    @Test
    public void typeClickAndStyleWithJSTest() {
        new HomePage(driver).getElementsPage();
        new SidePanel(driver).selectTextBox();
        new JSExecutor(driver).typeNameEmailWithJS(UserData.USER_NAME, UserData.EMAIL).clickOnSubmitWithJS().isDisplayName().contains("irhan");
    }

    @Test
    public void checkBoxWithJSTest() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
        new JSExecutor(driver).checkBoxWithJS();
        new JSExecutor(driver).refreshBrowserWithJs().getTitlePageWithJS().getUrlPageWithJS().scrollWithJS();
    }


}
