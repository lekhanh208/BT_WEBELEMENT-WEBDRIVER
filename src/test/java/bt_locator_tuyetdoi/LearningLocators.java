package bt_locator_tuyetdoi;

import bt_WebElement.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.time.Duration;

import static java.awt.SystemColor.window;

public class LearningLocators extends BaseTest {
    //Save xpath into variables String
    public static String username = "/html/body/div[1]/div/div/div/div[2]/div/form/div[1]/div[1]/input";
    public static String password = "/html/body/div[1]/div/div/div/div[2]/div/form/div[1]/div[2]/input";
    public static String loginButton = "/html/body/div[1]/div/div/div/div[2]/div/form/div[3]/div[1]/button";
    public static String projectMenu = "/html/body/nav/div/div/ul/li[10]/a";
    public static String addProjectButton = "/html/body/div[2]/div/div[4]/div/nav/div/a[3]";
    public static String titleField = "/html/body/div[2]/div/div[4]/div/div[1]/form/div[1]/div/div[2]/div/div[1]/div/input";
    public static String clientField = "/html/body/div[2]/div/div[4]/div/div[1]/form/div[1]/div/div[2]/div/div[2]/div/span/span[1]/span/span[1]";
    public static String estimatedHourField = "/html/body/div[2]/div/div[4]/div/div[1]/form/div[1]/div/div[2]/div/div[3]/div/div/input";
    public static String priorityField = "/html/body/div[2]/div/div[4]/div/div[1]/form/div[1]/div/div[2]/div/div[4]/div/span/span[1]/span/span[1]";
    public static String clientOption = "/html/body/span/span/span[2]/ul/li[1]";
    public static String priorityOption = "/html/body/span/span/span[2]/ul/li[2]";
    public static String startdateField = "/html/body/div[2]/div/div[4]/div/div[1]/form/div[1]/div/div[2]/div/div[5]/div/div/input";
    public static String enddateField = "/html/body/div[2]/div/div[4]/div/div[1]/form/div[1]/div/div[2]/div/div[6]/div/div/input";
    public static String summaryField = "/html/body/div[2]/div/div[4]/div/div[1]/form/div[1]/div/div[2]/div/div[7]/div/textarea";
    public static String saveButton = "/html/body/div[2]/div/div[4]/div/div[1]/form/div[1]/div/div[3]/button[2]/span[1]";
    public static void main(String[] args){


        //Create browser by Chrome
        createDriver();

        //Open eCommerce web
        driver.get("https://app.hrsale.com/");
        sleep(1);

        //Login with correct username and password
        driver.findElement(By.xpath(username)).sendKeys("frances.burns");
        sleep(1);

        driver.findElement(By.xpath(password)).sendKeys("frances.burns");
        sleep(1);

        driver.findElement(By.xpath(loginButton)).click();
        sleep(5);


        //Open Project item in navigation menu
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement projectElement = driver.findElement(By.xpath(projectMenu));
        js.executeScript("arguments[0].scrollIntoView(true)", projectElement);
        sleep(1);
        projectElement.click();
        sleep(1);

        //Scroll down web to find Add new project button
        js.executeScript("window.scrollBy(0,250)", "");
        sleep(1);

        //Open form Add new project
        driver.findElement(By.xpath(addProjectButton)).click();
        sleep(1);

        //Fill form "Add New Project"
        //Enter Tittle field
        driver.findElement(By.xpath(titleField)).sendKeys("Selenium");
        sleep(1);

        //Select Client = Cedric Kelly
        driver.findElement(By.xpath(clientField)).click();
        driver.findElement(By.xpath(clientOption)).click();
        sleep(1);

        //Enter Estimated Hour
        driver.findElement(By.xpath(estimatedHourField)).sendKeys("8");
        sleep(1);

        //Select Priority = High
        driver.findElement(By.xpath(priorityField)).click();
        driver.findElement(By.xpath(priorityOption)).click();
        sleep(1);

        //Select Start Date
        driver.findElement(By.xpath(startdateField)).click();
        driver.findElement(By.xpath("/html/body/div[9]/div/div[1]/div[3]/div[1]/table/tbody/tr[5]/td[3]/a")).click();
        driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/button[4]")).click();
        sleep(1);

        //Select End Date
        driver.findElement(By.xpath(enddateField)).click();
        driver.findElement(By.xpath("/html/body/div[10]/div/div[1]/div[3]/div[1]/table/tbody/tr[5]/td[7]/a")).click();
        driver.findElement(By.xpath("/html/body/div[10]/div/div[2]/button[4]")).click();
        sleep(1);

        //Enter Summary
        driver.findElement(By.xpath(summaryField)).sendKeys("Automation test");
        sleep(1);

        //Click Save button
        driver.findElement(By.xpath(saveButton)).click();

        //Close browser
        closeDriver();
    }
}
