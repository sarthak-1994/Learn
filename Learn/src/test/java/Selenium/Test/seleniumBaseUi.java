package Selenium.Test;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class seleniumBaseUi {

    public  WebDriver driver;

   @BeforeTest()
    public void setup()  {
       driver= WebDriverManager.chromedriver().create();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
       WebDriverRunner.setWebDriver(driver);
   }


   @Test()
    public void launchURl() throws InterruptedException {

       open("https://www.amazon.in/");
       $(By.cssSelector("#twotabsearchtextbox")).sendKeys("tshirt");
       ElementsCollection searchSuggestionList= $$(".s-suggestion-container");
       Thread.sleep(3000);
       for (SelenideElement ele: searchSuggestionList) {
          // System.out.println("Element text:"+ele.getText());
           Assert.assertTrue(ele.getText().contains("shirt"));
       }
       searchSuggestionList.get(0).click();
       ElementsCollection priceOptions=  $$("#priceRefinements>ul>li");
       Thread.sleep(3000);
       SelenideElement element = $("#priceRefinements");
       JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
       js.executeScript("arguments[0].scrollIntoView(true);", element);
       WebElement priceElement = priceOptions.get(2);
       System.out.println(priceElement.getText());
       js.executeScript("arguments[0].click();", priceElement);
       Actions builder = new Actions(WebDriverRunner.getWebDriver());
       builder.moveToElement(priceElement).click(priceElement);
       builder.perform();
       Thread.sleep(500);
       driver.findElement(By.xpath("//span[contains(text(),'₹300 - ₹500')]")).click();
       priceOptions.get(2).click();
           Thread.sleep(3000);
           ElementsCollection prices= $$(".a-price-whole");
           System.out.println("Element text:"+prices);
           for (SelenideElement ele:prices) {
               Assert.assertEquals(ele.getText(),"300");
           }

      //sign in driver.findElement(By.cssSelector("#nav-signin-tooltip .nav-action-inner")).click();
   }

   @AfterTest()
    public void tearDown(){
    //   driver.quit();
   }


}
