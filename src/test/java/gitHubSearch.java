import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class gitHubSearch {
    private  static WebDriver driver;
    @BeforeAll
    public static void setupDriver(){
        WebDriverManager.chromedriver().setup(); // this specifies that the webdriver we will be using in our project is chromedriver
        driver = new ChromeDriver(); // we instantiated a chromedriver, i.e we created an object of chromedriver. We could have created a firefox or edge driver
        driver.manage   ().window().maximize(); // we maximized the window of our browser
    }
    @Test
    public void checkGitHub(){


            driver.get("https://www.github.com"); //we open the github homepage, which is the entry point of our program

            WebElement searchInput= driver.findElement(By.cssSelector("[name='q']"));
            String repoName="Selenium";
            searchInput.sendKeys(repoName); // Now we just entered Selenium into the search bar
            searchInput.sendKeys(Keys.ENTER); // Now we pressed the enter button

            List<String> repos =driver.findElements(By.cssSelector(".repo-list-item")).stream()
                    .map(element ->element.getText().toLowerCase()).collect(Collectors.toList());

            List<String> expected =repos.stream().filter(item-> item.contains(repoName)).collect(Collectors.toList());
            //let's now compare the actual result to the expected result
            Assertions.assertEquals(expected,repos);

        }

        @AfterAll
    public static void tearDown(){

            driver.quit(); // To automatically close the window even if the test fails
        }
}
