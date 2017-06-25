package credible.test;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by sramachandran on 6/24/17.
 */
public class Utilities {

    static void setSelect(WebElement rootElement, String text) {

        /**
         * sets  the provided string  value to the given select (list) element
         * @param webElement
         * @param String
         *
         */

        System.out.println("Now setting the text for Select Element");
        List<WebElement> links = rootElement.findElements(By.tagName("li"));
        System.out.println("Total Options are " + links.size());
        for (int i = 1; i < links.size(); i++) {
            System.out.println(links.get(i).findElement(By.xpath(".//div")).getText());
            if (links.get(i).findElement(By.xpath(".//div")).getText().contains(text)) {
                links.get(i).findElement(By.xpath(".//div")).click();
                break;
            }
        }

    }

    static void setText(WebElement webElement, String text) {

        /**
         * sets  the provided string  value to the given element
         * @param webElement
         * @param String
         *
         */

        System.out.println("Now setting the text for webelement");
        webElement.sendKeys(text);
    }

    static String getText(WebElement webElement) {

        /**
         * get the text of  the provided element
         *
         * @param webElement
         * @return String value of the element data
         */

        System.out.println("Now getting the text for webelement");
        return webElement.getText();
    }

    static void click(WebElement webElement) {


        /**
         * clicks  the provided element
         *
         * @param webElement
         */

        System.out.println("Now clicking the webelement");
        webElement.click();
    }

    static void waitSecs(int secs) throws InterruptedException {


        /**
         * Waits for the provided seconds
         *
         * @param secs for the number wait seconds
         */

        Thread.sleep(secs * 1000);
    }

    static void waitForElement(WebDriver driver, WebElement element) {

        /**
         * Waits for the element to be clickable
         *
         * @param driver webdriver
         */


        WebDriverWait wait = new WebDriverWait(driver, 7000);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    static String getData(String key) throws IOException {
        /**
         * gets the data from the txt file and converts to JSON and returns the value of the key
         *
         * @param key data
         * @return string  input for the forms
         */

        BufferedReader reader = new BufferedReader(new FileReader("data_file/loanAmount.txt"));
        String outputJson = "";
        try {
            StringBuilder stringBuild = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                stringBuild.append(line);
                stringBuild.append("\n");
                line = reader.readLine();
            }
            outputJson = stringBuild.toString();
        } finally {
            reader.close();
        }

        JSONObject object = new JSONObject(outputJson);
        return object.getString(key);
    }

}
