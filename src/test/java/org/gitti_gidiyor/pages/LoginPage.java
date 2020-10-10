package org.gitti_gidiyor.pages;

import org.gitti_gidiyor.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage {

    public void girisYap() throws InterruptedException {
        Thread.sleep(2000);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@data-cy='header-user-menu']"))).build().perform();
        Thread.sleep(2000);
        clickElementByXPath("a","data-cy","header-login-button");
        Thread.sleep(3000);
    }

    public void girisBilgileri(String userName, String password) throws InterruptedException {
        findElementByXPathS("//div[@class='clearfix']//input[@name='kullanici']").sendKeys(userName);
        findElementByXPathS("//div[@class='clearfix']//input[@name='sifre']").sendKeys(password);
        findElementByXPathS("//input[@id='gg-login-enter']").click();
        Thread.sleep(3000);
    }

    public void adresGir(String password) throws InterruptedException {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div[@data-cy='header-user-menu']"))).build().perform();
        Thread.sleep(2000);
        clickElementByXPathS("//a[@title='Bilgilerim / Ayarlarım']");
        Thread.sleep(2000);
        clickElementByXPathS("//a[@href='/bana-ozel/adreslerim']");
        Thread.sleep(2000);
        findElementByXPathS("//input[@name='sifre']").sendKeys(password);
        Thread.sleep(2000);
        clickElementByXPathS("//input[@id='gg-login-enter']");
        clickElementByXPathS("//a[@id='AddAddress']");
        Thread.sleep(2000);
    }

    public void adresBilgileriGir(String baslik, String ad, String soyad, String sehir, String mahalle, String ilce, String postaKodu, String adres, String telefon) throws InterruptedException {
        sendByXPath("input", "name", "title", baslik);
        sendByXPath("input", "name", "name", ad);
        sendByXPath("input", "name", "surname", soyad);
        selectElement("//select[@id='cities']", sehir);
        selectElement("//select[@id='counties']", ilce);
        selectElement("//select[@id='neighborhoods']", mahalle);
        sendByXPath("input", "name", "zipCode", postaKodu);
        sendByXPath("textarea", "name", "address", adres);
        sendByXPath("input", "name", "phone", telefon);
        Thread.sleep(1000);
        clickElementByXPathS("//input[@id='AddressSave']");
        Thread.sleep(3000);
        WebElement adresOnay = findElementByXPathS("//div[@class='container']//span");
        String adresOnayString= adresOnay.getText();
        System.out.println(adresOnayString);
        Assert.assertEquals("Tebrikler. Adres ekleme işleminiz başarıyla tamamlandı.", adresOnayString);
    }
}
