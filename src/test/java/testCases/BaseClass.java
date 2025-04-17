package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	Properties p;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(@Optional("chrome") String browser) throws IOException
	{
		//Loading properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		//Loading log file
		logger = LogManager.getLogger(this.getClass());
			
		switch(browser.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		default : System.out.println("Invalid browser"); return;
		
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();			
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
		
	}
	
	public String randomstring() 
	
	{
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return(generateString);
	}
	
	public String randomNumber() 
	
	{
		String generateNumber = RandomStringUtils.randomNumeric(10);
		return(generateNumber);
	}
	
    public String randomAlphaNumeric() 
	
	{
    	String generateString = RandomStringUtils.randomAlphabetic(5);
    	String generateNumber = RandomStringUtils.randomNumeric(10);
		return(generateString+"@"+generateNumber);
	}
    
    
    
}
