package webdriver.tutorial;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class RequestInfoPage extends LoadableComponent<RequestInfoPage> {

    private WebDriver driver;

    public RequestInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @Override
    protected void isLoaded() throws Error {
    	System.out.println("done loading: " + this.getClass().getName());
    	assertThat(driver.getTitle(), containsString("Request Info Today"));
    }
    
    @Override
    protected void load() {
    	System.out.println("loading " + this.getClass().getName() + "...");
    	driver.get("http://www.mills.edu/admission/graduate/request_info.php");
        driver = driver.switchTo().frame(0);
    }

    @FindBy(name="first_name_in")
    WebElement firstName;

    @FindBy(name="last_name_in")
    WebElement lastName;
    
    @FindBy(name="addr1_str1_in")
    WebElement address;
    
    @FindBy(name="addr1_city_in")
    WebElement city;
    
    @FindBy(name="addr1_stat_code_in")
    WebElement state;
    
    @FindBy(name="addr1_zip_in")
    WebElement zip;
    
    @FindBy(name="term_code_in")
    WebElement toe;
    
    @FindBy(name="majr_code_in")
    WebElement program;
    
    @FindBy(name="lend_code_in")
    WebElement learnedAbtMills;

    public void enterFirstName(String first) {
    	firstName.sendKeys(first);
    }

    public void enterLastName(String last) {
    	lastName.sendKeys(last);
    }
    
    public void enterAddress(String addy) {
    	address.sendKeys(addy);
    }
    
    public void enterCity(String c) {
    	city.sendKeys(c);
    }
    
    public void enterState(String st) {
    	state.sendKeys(st);
    }
    
    public void enterZIP(String z) {
    	zip.sendKeys(z);
    }
    
    public void enterTOE(String t) {
    	toe.sendKeys(t);
    }
    
    public void enterProgram(String pgm) {
    	program.sendKeys(pgm);
    }
    
    public void enterLearned(String lbm) {
    	learnedAbtMills.sendKeys(lbm);
    }
    
    public void reset() {
    	/**List<WebElement> inputList = driver.findElements(By.tagName("input"));
    	for (WebElement input : inputList) {
    		if (input.getAttribute("type").equals("reset")) {
    			input.click();
    			break;
    		}
    	}*/
    	WebElement reset = driver.findElement(By.xpath("//input[@type='reset']"));
    	System.out.println(reset.getAttribute("value"));
    	reset.click();
    }
    
    public void submit() {
    	WebElement input = driver.findElement(By.name("button_text_in"));
    	input.click();
    }
    
    public void setNames(String first, String last) {
    	firstName.sendKeys(first);
    	lastName.sendKeys(last);
    }
    
    public void setAddress(String a, String c, String s, String z) {
    	address.sendKeys(a);
    	city.sendKeys(c);
    	state.sendKeys(s);
    	zip.sendKeys(z);
    }
    
    
    
}
