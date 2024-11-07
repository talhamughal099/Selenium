package gulfAirTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

//import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlightBooking {
	
	static WebDriver driver = new ChromeDriver();
	

 // launch the Gulf Air site
	@BeforeClass
    public static void siteLaunch() {
    	
    	driver.manage().window().maximize();
        String baseURL = "https://www.gulfair.com/";
        driver.get(baseURL);
        
        assertNotNull(baseURL);
        
    }
	
	@Test
    public void pageTitle() {
		
		String siteTitle = driver.getTitle();
		System.out.println(siteTitle);
		
        String expectedTitle = "Travel with Us | Gulf Air";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }
    
    @Test
    public void CookiesAccept() {
    	
    	WebElement cookiesAccept = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-primary']"));
    	cookiesAccept.click();
    	
//    	assertTrue(true);
    }
    
    @Test
    public void tripRadioButton() {
    	WebElement valueSwap = driver.findElement(By.xpath("(//label[contains(text(), 'One-way')])[2]"));
    	valueSwap.click();
    	System.out.println("Value Swap to One way");
    	
    }
	
    public void selectCities(String departure, String destination) {
    	WebElement depatureCity = driver.findElement(By.name("destinationFrom"));
    	depatureCity.click();
    	depatureCity.sendKeys(departure);
    	
    	WebElement destinationCity = driver.findElement(By.name("destinationTo"));
    	destinationCity.click();
    	destinationCity.sendKeys(destination);
    	
    }
    
    public void selectTravelDates(String Date) {
        WebElement departureDateField = driver.findElement(By.name("date"));
        departureDateField.click();
        driver.findElement(By.xpath("//*[@id=\"{9880034F-F835-4013-9F35-D88423507789}\"]/div[4]/div/div/div/div/div/div/div/form/div[2]/div[1]/div/div[2]/div/div/div/input")).click(); // Replace date format as needed
    }
    
    @AfterClass
    public static void quitBrowser() {
        driver.quit();
        System.out.println("Browser Closed.");
    }
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		FlightBooking booking = new FlightBooking();
		
		try {
		booking.siteLaunch();
		Thread.sleep(5000);
		booking.pageTitle();
		booking.CookiesAccept();
		Thread.sleep(5000);
		booking.tripRadioButton();
		Thread.sleep(5000);
		
//		booking.selectCities("Lahore", "London");
//		booking.selectTravelDates("28 Nov 2024");
		} catch (Exception e) {
            System.out.println("Error during flight booking automation: " + e.getMessage());
		}finally {
            booking.quitBrowser();
        }
		
   }
		
}

