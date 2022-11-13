package bt_WebDriver;

import bt_WebElement.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddNewTask extends BaseTest {
    public static void main(String[] args) {
        createDriver();

        loginHRSale();

        //Open 'Add New Task' form
        driver.findElement(By.xpath("//span[normalize-space()='Tasks']")).click();
        driver.findElement(By.xpath("//*[normalize-space()='Add Task']")).click();
        sleep(2);

        //Fill in form
        driver.findElement(By.xpath("//input[@name='task_name']")).sendKeys("Test");

        driver.findElement(By.xpath("//input[@name='start_date']")).click();
        driver.findElement(By.xpath("(//a[text()='08'])[1]")).click();
        driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();

        driver.findElement(By.xpath("//input[@name='end_date']")).click();
        driver.findElement(By.xpath("(//a[text()='11'])[2]")).click();
        driver.findElement(By.xpath("(//button[text()='OK'])[2]")).click();

        driver.findElement(By.xpath("//input[@name='task_hour']")).sendKeys("9");

        driver.findElement(By.xpath("//span[text()='Project']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Advertising Platform AD.']")).click();

        driver.findElement(By.xpath("//*[@name='summary']")).sendKeys("a brief statement or account of the main points of something");

        sleep(2);

        driver.findElement(By.xpath("//button[contains(.,'Save')]")).submit();

        sleep(2);

        closeDriver();



    }
}
