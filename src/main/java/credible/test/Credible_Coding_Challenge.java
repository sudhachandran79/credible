package credible.test;

//Importing packages

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.*;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import static credible.test.Constants.*;
import static credible.test.Utilities.*;
import static credible.test.PageElements.*;


public class Credible_Coding_Challenge {

    public static void main(String[] args) throws InterruptedException, IOException {

        // Create a new instance of the Firefox driver
        System.setProperty("webdriver.gecko.driver", "data_file/geckodriver");
        WebDriver driver = new FirefoxDriver();

        firstPageNavigate(driver);
        secondPageNavigate(driver);
        thirdPageNavigate(driver);

        //Assert Fail Message in the end page
        Assert.assertEquals(getText(driver.findElement(txtFailMessage)), FAILMESSAGEBOILERPLATE, "Incorrect fail message displayed");

        //Assert reminder button exist
        Assert.assertTrue(driver.findElement(btnFinalReminder).isDisplayed(), "Reminder button is not displayed");
        driver.quit();

    }

    private static void firstPageNavigate(WebDriver driver) throws InterruptedException, IOException {


        driver.get("http://www.credible.com");
        String loan = getData("loanAmount");
        if (driver.findElement(lnkPersonalLoanx).isDisplayed()) {
            System.out.println("I am seeing usual Page");
            driver.findElement(lnkPersonalLoanB).click();
            waitForElement(driver, driver.findElement(TxtLoanAmtB));
            driver.findElement(TxtLoanAmtB).click();

            setText(driver.findElement(TxtLoanAmtB), loan);
            driver.findElement(btnSubmit).click();
        } else {
            System.out.println("I am seeing the unusual Page");
            driver.findElement(tabPersonal).click();
            waitForElement(driver, driver.findElement(txtLoan));
            driver.findElement(txtLoan).click();

            setText(driver.findElement(txtLoan), loan);
            driver.findElement(btnFindRate).click();

        }
    }

    private static void secondPageNavigate(WebDriver driver) throws InterruptedException, IOException {

        System.out.println(driver.getCurrentUrl());
        waitForElement(driver, driver.findElement(txtHdr));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.credible.com/personal-loan/borrower/step/personal", "Incorrect Page Displayed");
        waitSecs(10);


        //Now Asserting the top blue line in the personal loan page

        Assert.assertTrue(driver.findElement(blueLinePersonal).isDisplayed(), "Personal Loan Request Blue Line missing");

        //Now Asserting the top message in the personal loan page

        Assert.assertEquals(getText(driver.findElement(txtHdr)), "Personal Loan Request", "Personal Loan Request is missing in the profile page");

        //Now Asserting the header in the personal loan page

        Assert.assertEquals(getText(driver.findElement(txtBigTitle)), PERSONALPAGEHDR, "Incorrect header message in profile page");

        click(driver.findElement(blankSelect1));
        waitSecs(2);
        setSelect(driver.findElement(sLcLoansDropdown), getData("loanPurpose"));
        waitSecs(2);

        click(driver.findElement(blankSelect2));
        waitSecs(2);

        setSelect(driver.findElement(sLcHighEduDropdown), getData("highEducation"));
        waitSecs(2);

        click(driver.findElement(blankSelect3));
        waitSecs(2);

        setSelect(driver.findElement(sLcEmpStatusDropdown), getData("employStatus"));
        waitSecs(2);

        setText(driver.findElement(txtdob), getData("dob"));
        waitSecs(2);

        click(driver.findElement(lnktooltip));
        Assert.assertTrue(driver.findElement(txttooltipinner).isDisplayed(), "Income  tooltip  is not showing up");

        //Now Asserting the tool tip for income

        Assert.assertEquals(getText(driver.findElement(txttooltipinner)), TOOLTIP_INCOME, "Mismatch in the tool tip message for income");

        setText(driver.findElement(txtannualInc), getData("annualInc"));
        waitSecs(2);

        click(driver.findElement(blankSelect4));
        waitSecs(2);

        setSelect(driver.findElement(sLcScoreDropdown), getData("creditScore"));
        waitSecs(2);

        click(driver.findElement(btnContinue));
        waitSecs(10);

    }

    private static void thirdPageNavigate(WebDriver driver) throws InterruptedException, IOException {

        //Now Asserting the url of the page

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.credible.com/personal-loan/borrower/step/profile", "Incorrect Page Displayed");

        //Now Asserting the top message in the profile  page

        Assert.assertEquals(Utilities.getText(driver.findElement(txtHdr)), "Personal Loan Request", "Personal Loan Request is missing in the profile page");
        waitForElement(driver, driver.findElement(txtHdrPage2));

        //Now Asserting the header in the profile page

        Assert.assertEquals(Utilities.getText(driver.findElement(txtHdrPage2)), PROFILEPAGEHDR, "Incorrect header message in profile page");

        setText(driver.findElement(txtFirstName), getData("firstName"));
        waitSecs(2);

        setText(driver.findElement(txtLastname), getData("lastName"));
        waitSecs(2);

        setText(driver.findElement(txtPhone), getData("phone"));
        waitSecs(7);

        click(driver.findElement(lnktooltipPhHow));

        Assert.assertTrue(driver.findElement(txttooltipinner).isDisplayed());
        Assert.assertTrue(driver.findElement(txttooltipinner).isDisplayed(), "Phone  tooltip  is not showing up");

        //Now Asserting the tool tip for phone

        Assert.assertEquals(Utilities.getText(driver.findElement(txttooltipinner)), TOOLTIP_PHONE, "Mismatch in the tool tip message for income");
        waitSecs(2);

        click(driver.findElement(blankHousingStatus));
        waitSecs(2);

        setSelect(driver.findElement(sLcHousingStatDropdown), getData("houseStatus"));
        waitSecs(2);

        click(driver.findElement(txtmanualAddress));

        setText(driver.findElement(txtAddress), getData("address"));
        waitSecs(2);

        setText(driver.findElement(txtAddressUnit), getData("unit"));
        waitSecs(2);


        setText(driver.findElement(txtAddressCity), getData("city"));
        waitSecs(2);

        click(driver.findElement(stateLookup));
        waitSecs(2);

        setSelect(driver.findElement(sLcStateDropdown), getData("state"));
        waitSecs(2);


        setText(driver.findElement(txtAddresszip), getData("zip"));
        waitSecs(2);


        click(driver.findElement(blankCitizenStatus));
        waitSecs(2);

        setSelect(driver.findElement(sLcCitizenStatDropdown), getData("citizenStatus"));
        waitSecs(2);

        click(driver.findElement(lnktooltipCitWhy));
        Assert.assertTrue(driver.findElement(txttooltipinner).isDisplayed(), "Citizenship Status tooltip  is not showing up");


        //Now Asserting the tool tip for Citizenship Status

        Assert.assertEquals(Utilities.getText(driver.findElement(txttooltipinner)), TOOLTIP_CITIZEN, "Mismatch in the tool tip message for income");


        setText(driver.findElement(txtssn), getData("ssn"));
        waitSecs(2);

        click(driver.findElement(lnktooltipSSNWhy));
        Assert.assertTrue(driver.findElement(txttooltipinner).isDisplayed(), "SSN  tooltip  is not showing up");


        //Now Asserting the tool tip for SSN

        Assert.assertEquals(Utilities.getText(driver.findElement(txttooltipinner)), TOOLTIP_SSN, "Mismatch in the tool tip message for income");


        //Now providing the email with the format yourEmail+Jan01+1125@domain.com (your email + current date + current time @ domain name)

        Date todaysDate = new Date();
        Format formatter = new SimpleDateFormat("MMM");
        String mon = formatter.format(todaysDate);
        formatter = new SimpleDateFormat("dd");
        String day = formatter.format(todaysDate);
        formatter = new SimpleDateFormat("HH");
        String hr = formatter.format(todaysDate);
        formatter = new SimpleDateFormat("MM");
        String min = formatter.format(todaysDate);

        String myFormattedEmail = "Email+" + mon + day + "+" + hr + min + "@credible.com";
        System.out.println(myFormattedEmail);

        setText(driver.findElement(txtEmail), myFormattedEmail);
        click(driver.findElement(btnSubmit2));
        waitSecs(2);
        Assert.assertTrue(driver.findElement(txtPassword).isDisplayed());
        setText(driver.findElement(txtPassword), getData("password"));
        click(driver.findElement(btnSubmit2));
        waitSecs(20);
    }
}
