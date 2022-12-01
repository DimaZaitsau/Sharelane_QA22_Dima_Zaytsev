import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SharelaneTests {

    WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void closeDriver()  {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void firstTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value = Continue]"));
        continueButton.click();

        zipCodeInput = driver.findElement(By.name("zip_code"));
        Assert.assertEquals(zipCodeInput.isDisplayed(), false);

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);
    }

    @Test
    public void zipCodeNegative()    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("22");
        WebElement continueButton = driver.findElement(By.cssSelector("[value = Continue]"));
        continueButton.click();

        zipCodeInput = driver.findElement(By.name("zip_code"));
        Assert.assertEquals(zipCodeInput.isDisplayed(), true);
    }

    @Test
    public void signUpPositiveTest()    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12787");

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Dima");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Diman");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("dkfjhhgifg54@fdib.com");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("DimaDiman444");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("DimaDiman444");
        WebElement registerButton = driver.findElement(By.cssSelector("[value = Register]"));
        registerButton.click();

        firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), false);
    }

    @Test
    public void signUpNegativeTest1()    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12787");

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Dima");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Diman");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("dkfjhhgifg54@fdib.com");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("DimaDiman444");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("ekjgnefltehrkelgonsfoi");
        WebElement registerButton = driver.findElement(By.cssSelector("[value = Register]"));
        registerButton.click();

        firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);
    }

    @Test
    public void signUpNegativeTest2()   {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12787");

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("      ");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("   ");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("    ");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("DimaDiman444");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("DimaDiman444");
        WebElement registerButton = driver.findElement(By.cssSelector("[value = Register]"));
        registerButton.click();

        firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);
    }

    @Test
    public void signUpNegativeTest3()   {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12787");

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Di  ma");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Diman");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("fkjdbnfdlbd@kjbe.com");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("DimaDiman444");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("DimaDiman444");
        WebElement registerButton = driver.findElement(By.cssSelector("[value = Register]"));
        registerButton.click();

        firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);
    }

    @Test
    public void signUpNegativeTest4()   {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12787");

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("");
        WebElement registerButton = driver.findElement(By.cssSelector("[value = Register]"));
        registerButton.click();

        firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);
    }

    @Test
    public void signUpNegativeTest5()   {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12787");

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys(" Dima ");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Diman");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("hbsdbbosbv@kjnsd.com");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("qwerty123");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("qwerty123");
        WebElement registerButton = driver.findElement(By.cssSelector("[value = Register]"));
        registerButton.click();

        firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);
    }

    @Test
    public void signUpNegativeTest6()   {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12787");

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("$%$%$%%$%%%$%");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("sdjhbf");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("wkefnlt656@kjnsd.com");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("qwerty123");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("qwerty123");
        WebElement registerButton = driver.findElement(By.cssSelector("[value = Register]"));
        registerButton.click();

        firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);
    }

    @Test
    public void signUpNegativeTest7()   {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12787");

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Dima,hsjdv");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("sdjhbf");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("wkefnlt656@kjnsd.com");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("qwerty123");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("qwerty123");
        WebElement registerButton = driver.findElement(By.cssSelector("[value = Register]"));
        registerButton.click();

        firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);
    }
}
