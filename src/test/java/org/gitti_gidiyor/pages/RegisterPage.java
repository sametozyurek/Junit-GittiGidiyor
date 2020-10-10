package org.gitti_gidiyor.pages;

import org.gitti_gidiyor.base.BasePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegisterPage extends BasePage {

    public void kullaniciKayit() throws InterruptedException {
        Thread.sleep(2000);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@data-cy='header-user-menu']"))).build().perform();
        Thread.sleep(2000);
        clickElementByXPath("a","data-cy","header-register-button");
        Thread.sleep(3000);
    }

    public void kayitOl(String name, String surname, String email, String password, String phoneNumber) throws InterruptedException {
        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.gittigidiyor.com/kayit-ol");
        sendByXPath("input","name","name",name);
        sendByXPath("input","name","surname",surname);
        sendByXPath("input","name","email",email);
        sendByXPath("input","name","passwd",password);
        sendByXPath("input","name","gsmData",phoneNumber);
        clickElementByXPath("label","for","informed-email");
        Thread.sleep(3000);
    }
}
