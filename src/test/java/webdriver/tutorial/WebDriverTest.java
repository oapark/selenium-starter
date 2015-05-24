package webdriver.tutorial;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverTest {

WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
    }

    @Test
    public void testWebDriver() {
        /**driver.get("http://www.mills.edu");

        String expected = "Liberal Arts College";
        String title = driver.getTitle();
        Assert.assertTrue(title.startsWith(expected));

        assertTextPresent("div#footer .addr", "5000 MacArthur Blvd");
        assertLinkPresent();
        assertPartialLinkPresent();
        assertClassnamePresent("div#header .logo");
        assertTagNamePresent("ul");//assertTagNamePresent("ol");
        assertIdPresent("footer");
        assertNamePresent("q");
        assertCSSSelectorPresent("div.logo");
        assertXPathPresent("//div[@id='footer']");
        assertTextfieldPresent("q");
        
        
        assertTextPresent("5000 MacArthur Blvd");
        
        takeScreenshot("screenshot.png");
        //clickLinkPresent("About Mills");
        //title = driver.getTitle();
        //assertTitle(title, "California College for Women");
        //pause(10000);
        search("ICS");
        //assertTextPresent("Interdisciplinary");
        //pause(3000);
        
     	**/
        
        
        
        driver.get("http://www.mills.edu/admission/graduate/request_info.php");
        //driver.get("https://mymills1.mills.edu:9003/prod/bwskwpro.P_WebProspectMain?prel_code_in=GRAD&button_text_in=Continue");

        driver = driver.switchTo().frame(0);
        
        
        //selectMonthDayYear("December", "01", "1900");
        assertMonth("12");
        assertDay("01");
        assertYear("1900");
    	assertTermOfEntry("201509");
    	assertOptionListDisplayed("GWEB");
    	listOptionsSelected();
    	//clickReset();
    	multipleSelections(0,2,3);
    	clickAttReset();
        pause(3000);
        
        driver.switchTo().defaultContent();
        
        
        
        
        
        /**
        driver.get("http://www.mills.edu");
        clickLinkAssertPage("Graduate Programs", "Graduate Academics, Graduate School, Mills College");
        clickLinkAssertPage("REQUEST INFO TODAY", "Request Info Today | Graduate School | Grad Programs | Mills College");
        assertNavigation("back", "Graduate Academics, Graduate School, Mills College");
        assertNavigation("forward", "Request Info Today | Graduate School | Grad Programs | Mills College");
        assertNavigation("", "Request Info Today | Graduate School | Grad Programs | Mills College");
        getCookies();
        
        pause(3000);
        **/
        

    }

    @After
    public void cleanup() {
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
    
    public void takeScreenshot(String name) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void assertTextPresent(String css, String expectedText) {
        
    	WebElement we = driver.findElement(By.cssSelector(css));
        String actualText = we.getText();
        Assert.assertTrue(actualText.contains(expectedText));
        
                
    }
    
    public void assertLinkPresent() {
    	WebElement link = driver.findElement(By.linkText("Home"));
    	Assert.assertNotNull(link);
    }
    
    public void assertPartialLinkPresent() {
    	WebElement link = driver.findElement(By.partialLinkText("Athletics &"));
    	Assert.assertNotNull(link);
    }
    
    public void assertClassnamePresent(String a) {
    	WebElement className = driver.findElement(By.cssSelector(a));
    	String actualText = className.getText();
    	Assert.assertNotNull(actualText);
    }
    
    public void assertTagNamePresent(String a) {
    	WebElement tagName = driver.findElement(By.tagName(a));
    	String actualText = tagName.getText();
    	Assert.assertNotNull(actualText);
    }
    
    public void assertIdPresent(String a) {
    	WebElement id = driver.findElement(By.id(a));
    	String actualText = id.getText();
    	Assert.assertNotNull(actualText);
    }
    
    public void assertNamePresent(String a) {
    	WebElement name = driver.findElement(By.name(a));
    	String actualText = name.getText();
    	Assert.assertNotNull(actualText);
    }
     
    public void assertCSSSelectorPresent(String a) {
    	WebElement selector = driver.findElement(By.cssSelector(a));
    	String actualText = selector.getText();
    	Assert.assertNotNull(actualText);
    }
    
    public void assertXPathPresent(String a) {
    	WebElement xpth = driver.findElement(By.xpath(a));
    	String actualText = xpth.getText();
    	Assert.assertNotNull(actualText);
    }
    
    public void assertTextfieldPresent(String a) {
    	WebElement tf = driver.findElement(By.name(a));
    	Assert.assertNotNull(tf);
    }
    
    
    
    public void assertTextPresent(String text) {
    	WebElement txt = driver.findElement(By.cssSelector("body"));
    	String actualText = txt.getText();
    	Assert.assertTrue(actualText.contains(text));
    }
   
    public void clickLinkAssertPage(String ltxt, String title) {
    	WebElement link = driver.findElement(By.partialLinkText(ltxt));
    	link.click();
    	assertTitle(title);
    }
    
    public void assertTitle(String title) {
    	String pageTitle = driver.getTitle();
    	Assert.assertTrue(pageTitle.equals(title));
    }
    
    public void search(String a) {
    	WebElement search = driver.findElement(By.name("q"));
    	search.sendKeys(a);
    	search = driver.findElement(By.name("search"));
    	search.click();
    }
    
    
    
    
    
    
    
    public void selectMonthDayYear(String m, String d, String yr) {
    	//Select drop = new Select(driver.findElement(By.id("addr1_from_mm_in")));
    	//drop.selectByVisibleText(m);
    	//driver.switchTo().f
    	//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://mymills1.mills.edu:9003/prod/bwskwpro.P_WebProspectMain?prel_code_in=GRAD&button_text_in=Continue']")));
    	//WebElement value = driver.findElement(By.name("addr1_from_mm_in"));
    	//Assert.assertNotNull(value);
    	
    	
    	Select drop = new Select(driver.findElement(By.name("addr1_from_mm_in")));
    	drop.selectByVisibleText(m);
    	drop = new Select(driver.findElement(By.name("addr1_from_dd_in")));
    	drop.selectByVisibleText(d);
    	WebElement yearTextBox = driver.findElement(By.name("addr1_from_yyyy_in"));
    	yearTextBox.clear();
    	yearTextBox.sendKeys(yr);
    }
    
    public void assertMonth(String m) {
    	Select drop = new Select(driver.findElement(By.name("addr1_from_mm_in")));
    	drop.selectByValue(m);
    	WebElement assMonth = driver.findElement(By.name("addr1_from_mm_in"));
    	String str = assMonth.getAttribute("value");
    	//System.out.println(str);
    	Assert.assertTrue(str.equals(m));	
    }
    
    public void assertDay(String d) {
    	Select drop = new Select(driver.findElement(By.name("addr1_from_dd_in")));
    	drop.selectByValue(d);
    	WebElement assDay = driver.findElement(By.name("addr1_from_dd_in"));
    	String str = assDay.getAttribute("value");
    	//System.out.println(str);
    	Assert.assertTrue(str.equals(d));
    }
    
    public void assertYear(String yr) {
    	WebElement yearTextBox = driver.findElement(By.name("addr1_from_yyyy_in"));
    	yearTextBox.clear();
    	yearTextBox.sendKeys(yr);
    	String str = yearTextBox.getAttribute("value");
    	Assert.assertTrue(str.equals(yr));
    	//System.out.println(str);
    }
    
    public void assertTermOfEntry(String toe) {
    	Select entry = new Select(driver.findElement(By.name("term_code_in")));
    	entry.selectByValue(toe);
    	WebElement assTOE = driver.findElement(By.name("term_code_in"));
    	String str = assTOE.getAttribute("value");
    	Assert.assertTrue(str.equals(toe));
    	//System.out.println(str);
    }
    
    public void assertOptionListDisplayed(String opStr) {
    	Select option = new Select(driver.findElement(By.name("lend_code_in")));
    	option.deselectAll();
    	option.selectByValue(opStr);
    	//WebElement assOLD = driver.findElement(By.name("lend_code_in"));
    	//String str = assOLD.getAttribute("value");
    	//Assert.assertTrue(str.equals(opStr));
    	//System.out.println(str);
    }
    
    public void clickReset() {
    	WebElement reset = driver.findElement(By.xpath("//td[@class='dddefault']/input[@type='reset']"));
    	reset.click();
    }
    
    
    public void clickAttReset() {
    	//WebElement reset = driver.findElement(By.tagName("input"));
    	List<WebElement> reset = driver.findElements(By.tagName("input"));
    	for (WebElement in : reset) {
    		if (in.getAttribute("type").equals("reset")) {
    			in.click();
    			break;
    		}
    	}
    }
    
    
    public void listOptionsSelected() {
    	Select op = new Select(driver.findElement(By.name("lend_code_in")));
    	List<WebElement> options = op.getOptions();
    	for (WebElement option : options) {
    		String str = option.getText();
    		if (option.isSelected()) {
    			System.out.println(str + " is selected.");
    		} else {
    			System.out.println(str);
    		}
    	}
    }
    
    public void multipleSelections(int first, int third, int fourth) {
    	Select op = new Select(driver.findElement(By.name("lend_code_in")));
    	List<WebElement> options = op.getOptions();
    	op.deselectAll();
    	Actions action = new Actions(driver);
    	action.keyDown(Keys.CONTROL)
    		.click(options.get(first))
    		.click(options.get(third))
    		.click(options.get(fourth))
    		.keyUp(Keys.CONTROL)
    		.build()
    		.perform();
    	System.out.println("\nNEWLIST\n");
    	listOptionsSelected();
    }
    
    public void assertNavigation(String dir, String title) {
    	if (dir.equals("back")) {
    		driver.navigate().back();
    	} else if (dir.equals("forward")){
    		driver.navigate().forward();
    	} else //otherwise refresh {
    		driver.navigate().refresh();
    	assertTitle(title);
    }
    
    public void getCookies() {
    	Set<Cookie> cookies = driver.manage().getCookies();
    	for (Cookie cookie : cookies) {
    		System.out.println(cookie);
    	}
    }
}
