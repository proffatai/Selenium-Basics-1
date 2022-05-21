import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumRunner {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); // this specifies that the webdriver we will be using in our project is chromedriver
        WebDriver driver = new ChromeDriver(); // we instantiated a chromedriver, i.e we created an object of chromedriver. We could have created a firefox or edge driver
        driver.manage   ().window().maximize(); // we maximized the window of our browser
        driver.get("https://www.amazon.com"); //we open the amazon homepage, which is the entry point of our program

        WebElement searchInput= driver.findElement(By.cssSelector("#twotabsearchtextbox")); // with the aid of chroPath, we figured
        //that the search bar on amazon can be accessed via the css selector #twotabsearchtextbox. Now we have to pass it as an argument
        //to the By.cssSelector() in ""

        //What we just did is that, we just automated our script to identify the seach bar
        searchInput.sendKeys("iphone"); // Now we just entered iphone into the search bar
        searchInput.sendKeys(Keys.ENTER); // Now we pressed the enter button




        //driver.quit(); // To automatically close the window
    }
}
