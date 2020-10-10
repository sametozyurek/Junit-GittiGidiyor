package org.gitti_gidiyor.base;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver webDriver;
    public WebDriverWait wait;

    @Before
    public void beforeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        webDriver=new ChromeDriver(chromeOptions);

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        this.webDriver.get("https://www.gittigidiyor.com/");
        Thread.sleep(2000);
        clickElementByXPathS("//a[@class='styles__AlertClose-tyj39b-3 bcfLkR']");
    }

    public WebElement findElementByXPath(String tag, String element, String xpath){
        WebElement webElement = webDriver.findElement(By.xpath("//"+tag+"[@"+element+"='"+xpath+"']"));
        return webElement;
    }

    public WebElement findElementByXPathS(String xpath){
        WebElement element = webDriver.findElement(By.xpath(xpath));
        return element;
    }

    public void clickElementByXPath(String tag,String element, String xpath){
        webDriver.findElement(By.xpath("//"+tag+"[@"+element+"='"+xpath+"']")).click();
    }

    public void clickElementByXPathS(String xpath){
        webDriver.findElement(By.xpath(xpath)).click();
    }

    public void selectElement(String xpath, String text){
        Select select = new Select(findElementByXPathS(xpath));
        select.selectByVisibleText(text);
    }

    public void waitElementUntilDisplay(String tag, String element, String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//"+tag+"[@"+element+"='"+xpath+"']")));
    }

    public void sendByXPath(String tag,String element, String xpath, String text){
        webDriver.findElement(By.xpath("//"+tag+"[@"+element+"='"+xpath+"']")).sendKeys(text);
    }

    public void callMainPage(){
        webDriver.get("https://www.gittigidiyor.com/");
        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.gittigidiyor.com/");
    }

    @After
    public void afterTest(){
        this.webDriver.quit();
    }
}
