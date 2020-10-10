package org.gitti_gidiyor.pages;

import org.gitti_gidiyor.base.BasePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage {

    public void urunAra(String urun) throws InterruptedException {
        sendByXPath("input","data-cy","header-search-input",urun);
        Thread.sleep(2000);
        WebElement searchBar = findElementByXPath("input","data-cy","header-search-input");
        Thread.sleep(1000);
        Assert.assertEquals(searchBar.getAttribute("value"),urun);
        clickElementByXPath("button","data-cy","search-find-button");
        Thread.sleep(2000);
    }

    public void urunSepeteEkle() throws InterruptedException {
        List<WebElement> products = webDriver.findElements(By.xpath("//div[@class='clearfix']//ul//li//a[@class='product-link']"));


        Random random = new Random();
        int randomProduct = random.nextInt(products.size());
        int productNumberLi = randomProduct+1;

        WebElement clickedItem = findElementByXPathS("//div[@class='clearfix']//ul//li["+productNumberLi+"]//h3//span");
        String clickedItemString = clickedItem.getText();
        System.out.println("Clicked Item : "+clickedItemString);

        products.get(randomProduct).click();
        Thread.sleep(8000);

        clickElementByXPathS("//div[@id='sp-addbasket-button']//form//button//span[@class='action-text']");
        Thread.sleep(8000);

        webDriver.get("https://www.gittigidiyor.com/sepetim");
        Thread.sleep(8000);

        WebElement selectedItem = findElementByXPathS("//div[@class='text-box']//h2");
        String selectedItemString = selectedItem.getText();

        System.out.println("Selected Item : "+selectedItemString);
        Assert.assertEquals(clickedItemString,selectedItemString);
        Thread.sleep(5000);
    }
}
