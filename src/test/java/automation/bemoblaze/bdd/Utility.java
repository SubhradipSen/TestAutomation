package automation.bemoblaze.bdd;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utility {

    final static Logger logger = LoggerFactory.getLogger(Utility.class);
    public static final String CHROME_DRIVER_LOCATION = "chromedriver.exe";
    public static final String GECKO_DRIVER_LOCATION = "geckodriver.exe";
    public static String price = "";
    public static final String BROWSER_CHROME = "chrome";
    public static final String BROWSER_FF = "firefox";

    //Launches application under test on a specified by user 
    public static void launchURL(String url, String browser) throws Exception {
    	
        if (BROWSER_CHROME.equalsIgnoreCase(browser)) {
        	System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
        	WebDriver driver = new ChromeDriver();
        	driver.get(url);
        	driver.manage().window().maximize(); 	
        } else if (BROWSER_FF.equalsIgnoreCase(browser)) {
         	System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_LOCATION);
        	WebDriver driver = new FirefoxDriver();
        	driver.get(url);
        	driver.manage().window().maximize();
        } else {
            logger.error("No web browser specified");
            throw new Exception("Please specify a web browser name to run test script");
        }
    }

    //Clicks on a web element. xpath of the corresponding web element needs to be passed as argument 
    public static void webElementClick(SelenideElement webElement) throws Exception {
    	
    	WebDriverWait wait = new WebDriverWait(getWebDriver(), 10);
    	wait.until(ExpectedConditions.presenceOfElementLocated((By) webElement));
    	
        if(webElement.exists()){
            webElement.click();
        } else {
            throw new Exception("Web element "+ webElement +"is not displayed");
        }
    }

    //Verifies the existence of a web element on browser. xpath of the corresponding web element needs to be passed as argument 
    public static void webElementPresent(SelenideElement webElement) throws Exception {
    	WebDriverWait wait = new WebDriverWait(getWebDriver(), 10);
    	wait.until(ExpectedConditions.presenceOfElementLocated((By) webElement));
    	if(!webElement.exists()) {
            throw new Exception("Web element "+ webElement +"is not displayed");
        }
    }

  //Verifies the absence of a web element on browser. xpath of the corresponding web element needs to be passed as argument. 
    public static void webElementNotExists(SelenideElement webElement) throws Exception {
        if(!webElement.exists()) {
            System.out.println("Correcponding Web Element is not present");
        }
        else {
        	throw new Exception("Web element "+ webElement +"is displayed");
        }
    }
    
    //Clicks on 'OK' button on the alert window
    public static void handleAlert(boolean acceptAlert) {
    	try {
            if (acceptAlert) {
                getWebDriver().switchTo().alert().accept();
            } else {
                getWebDriver().switchTo().alert().dismiss();
            }
    	}
    	catch (Exception e) {
    		System.out.println(e);
    	}
    	finally {
    		System.out.println("Alert box is not displayed after an item is added to cart.");
    	}


    }
    //Deletes an item from shopping cart page. The exact name of the product needs to be passed as argument 
    public static void deleteItemFromCart(String laptopName) {
        SelenideElement deleteRow = $$("#tbodyid > tr").find(Condition.text(laptopName));
        deleteRow.findElement(By.linkText("Delete")).click();
        logger.info("The following item has been removed from cart: "+ laptopName);
    }

    //Retrieves the price of a product from product details page. xpath of the corresponding web element needs to be passed as argument.
    public static String retrievePrice(SelenideElement webElement) throws Exception {

        if(webElement.exists()) {
            String[] arrSplit = webElement.getText().split(" ");
            logger.info("Selected laptop's price1 : "+arrSplit[0]);
            arrSplit =arrSplit[0].split("\\$");
            logger.info("Selected laptop's price2 : "+arrSplit[0]);
            price = arrSplit[1];
            logger.info("Selected laptop's price3 : "+price);
            return price;
        } else {
            throw new Exception("Web element "+ webElement +"is not displayed");
        }
    }
    
    //Validates that the price displayed in shopping cart after deletion of Dell Laptop matches wth Sony Vaio i5 price. xpath of the corresponding web element needs to be passed as argument 
    public static void validateCartValue(SelenideElement webElement) throws Exception {

        if(webElement.exists()) {
        	String  cartValue = webElement.getText();
            cartValue = cartValue + " USD";
            if(cartValue==price) {
            	System.out.println("Correct price is displayed");
            } else {
                throw new Exception("Incorrect price is displayed on cart");
            }
            
        } else {
            throw new Exception("Web element "+ webElement +"is not displayed");
        }
    }
    
    //Retrieves the Purchase Info and prints purchase order in console
    public static void logPurchaseInfo(SelenideElement webElement) throws Exception {

        if(webElement.exists()) {
        	String purchaseInfo =webElement.getText();
            System.out.println(purchaseInfo);
            
            String[] arrSplit = purchaseInfo.split("Amount: ");
            System.out.println("Purchase Order "+arrSplit[0]);
            arrSplit = arrSplit[1].split("Card");
            System.out.println("Sony Vaio i5 price is" + price);
            
        } else {
            throw new Exception("Purchase failure");
        }
    }
    
	 public static void addToCartHandleAlert(SelenideElement webElement) throws Exception {
	    	WebDriverWait wait = new WebDriverWait(getWebDriver(), 10);
	    	wait.until(ExpectedConditions.presenceOfElementLocated((By) webElement));

		 try {
			
			if(webElement.exists())	{
				webElement.click();
				System.out.println("A TC");
				
				/*
				 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_ENTER);
				 * robot.keyRelease(KeyEvent.VK_ENTER);
				 */
				Runtime.getRuntime().exec("wscript C:\\Users\\Subhradip\\eclipse-workspace\\TestAutomation\\type.vbs");
				
				//getWebDriver().switchTo().alert().accept();
				System.out.println("Product has successfully been added to cart");
				
			} else {
				 throw new Exception("Webelement "+ webElement +"is not displayed");
			}
		} catch (Exception e) {
			 System.out.println(e);
		}
	 } 
    
}
