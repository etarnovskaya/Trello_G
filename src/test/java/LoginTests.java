import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com");

    }

    @Test
    public void testLoginAtlassiantPositive() throws InterruptedException {
        //click login button
        wd.findElement(By.cssSelector("[href='login']")).click();
//fill email input
        wd.findElement(By.id("user")).click();// focus
       wd.findElement(By.id("user")).clear();
       wd.findElement(By.id("user")).sendKeys("rochman.elena@gmail.com");
//proceed to atlassian account
       wd.findElement(By.id("login")).click();
       Thread.sleep(3000);
//fill pasword field
       wd.findElement(By.id("password")).click();
       wd.findElement(By.id("password")).clear();
       wd.findElement(By.id("password")).sendKeys("12345.com");
       //lastSubmitLoginButton
       wd.findElement(By.cssSelector("#login-submit")).click();

       Thread.sleep(10000);

        Assert.assertTrue(wd.findElement(By.cssSelector("button[title='rochman.elena (rochmanelena)']")).isDisplayed());
    };




    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

}
