package webdriver.tutorial;

//import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.FindBy;

public class TestRequestInfoPage {

    private WebDriver driver;
    private RequestInfoPage page;

    @Before
    public void before() {
        driver = new FirefoxDriver();
                
        page = new RequestInfoPage(driver);

        page.get();
    }

    @Test
    public void testSubmitData() {
        page.enterFirstName("firstname");
        page.enterLastName("lastname");
        page.enterAddress("123 Address Ave.");
        page.enterCity("Some City");
        page.enterState("CA");
        page.enterZIP("12345");
        page.enterTOE("Fall 2016");
        page.enterProgram("English, MFA Fiction");
        page.enterLearned("Graduate fair");
        pause(5000);
        page.reset();
        page.submit();
        page.setNames("My", "Name");
        page.setAddress("123 Address", "Some City", "NY", "10101");
        
        pause(5000);
    }
    
    @After
    public void cleanUp() {
    	if (driver != null) {
    		driver.quit();
    	}
    }
    
    
    public void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
}
