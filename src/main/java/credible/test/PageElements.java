package credible.test;

import org.openqa.selenium.By;

/**
 * Created by sramachandran on 6/24/17.
 */
public class PageElements {

    //Intro page A elements

    public final static By tabPersonal = By.cssSelector("div.tab-personal");
    public final static By txtLoan = By.cssSelector("div.extended-find-my-rate>span>span>input");

    //Intro page B elements

    public final static By btnFindRate = By.cssSelector("button.btn.btn-primary.start.hidden-xs");
    public final static By lnkPersonalLoanx = By.xpath("//div[2]/div[3]/div/div/button");
    public final static By btnSubmit = By.xpath("//div[2]/div[2]/div/button");

    //Personal page elements

    public final static By txtHdr = By.cssSelector("h2");
    public final static By blueLinePersonal = By.cssSelector("td.step.personal.active");

    public final static By txtBigTitle = By.cssSelector("h3.big-title");
    public final static By txtdob = By.name("borrower_dob");
    public final static By txtannualInc = By.name("employment_income_yearly");
    public final static By btnContinue = By.cssSelector("div.next-step");
    public final static By blankSelect1 = By.cssSelector("span.select2-arrow");
    public final static By blankSelect2 = By.cssSelector("div.step>fieldset>div.row:nth-child(4)>div.col-md-6>div.form-group>span>div.select2-container.bootstrap-dropdown>a.select2-choice");//same will be used for second page housing status
    public final static By blankSelect3 = By.cssSelector("div.step>fieldset>div.row:nth-child(5)>div.col-md-6>div.form-group>span>div.select2-container.bootstrap-dropdown>a.select2-choice.select2-default");//can be reused for secondpage citizenshi[
    public final static By blankSelect4 = By.cssSelector("div.step>fieldset>div.row:nth-child(8)>div.col-md-6>div.form-group>span>div.select2-container.bootstrap-dropdown>a.select2-choice.select2-default");
    public final static By sLcLoansDropdown = By.id("select2-results-1");
    public final static By sLcHighEduDropdown = By.id("select2-results-2");
    public final static By sLcEmpStatusDropdown = By.id("select2-results-3");
    public final static By sLcScoreDropdown = By.id("select2-results-4");
    public final static By lnktooltip = By.cssSelector("span.tooltip-text");
    public final static By txttooltipinner = By.cssSelector("div.tooltip-inner");


    //Profile page elements
    public final static By txtFirstName = By.name("borrower_first_name");
    public final static By txtLastname = By.name("borrower_last_name");
    public final static By txtPhone = By.name("borrower_phone");
    public final static By lnktooltipPhHow = By.cssSelector("div.step>fieldset>div.row:nth-child(3)>div.col-md-6>div.form-group>span.tooltip-text");
    public final static By txtHdrPage2 = By.cssSelector("div.col-xs-12>div>div.base-form:nth-child(2)>div.step>fieldset>header>h3.big-title");


    public final static By blankHousingStatus = By.cssSelector("div.step>fieldset>div.row:nth-child(4)>div.col-md-6>div.form-group>span>div.select2-container.bootstrap-dropdown>a.select2-choice.select2-default");
    public final static By sLcHousingStatDropdown = By.id("select2-results-5");


    public final static By txtmanualAddress = By.cssSelector("a.to-manual-mode");
    public final static By txtAddress = By.name("current_address_street");
    public final static By txtAddressUnit = By.name("current_address_unit");
    public final static By txtAddressCity = By.name("current_address_city");
    public final static By stateLookup = By.cssSelector("div.bootstrap-address.manual>div.row.bootstrap-address-component>div.col-md-6:nth-child(2)>div.form-group>span>div.select2-container.bootstrap-search");
    public final static By txtAddresszip = By.name("current_address_zipcode");

    public final static By sLcStateDropdown = By.id("select2-results-6");
    public final static By blankCitizenStatus = By.cssSelector("div.step>fieldset>div.row>div.col-md-6>div.form-group>span>div.select2-container.bootstrap-dropdown>a.select2-choice.select2-default");
    public final static By sLcCitizenStatDropdown = By.id("select2-results-7");
    public final static By lnktooltipCitWhy = By.cssSelector("div.step>fieldset>div.row:nth-child(6)>div.col-md-6>div.form-group>span.tooltip-text");

    public final static By txtssn = By.name("borrower_ssn");
    public final static By lnktooltipSSNWhy = By.cssSelector("div.form-group.with-icon > span.tooltip-text");
    public final static By txtEmail = By.name("email");
    public final static By txtPassword = By.name("password");
    public final static By blueLineProfile = By.cssSelector("td.step.profile.active");


    public final static By btnSubmit2 = By.cssSelector("div.send-submission");

    public final static By lnkPersonalLoanB = By.xpath("//div[2]/div[3]/div/div/button");
    public final static By TxtLoanAmtB = By.cssSelector("div.credible-product.personal-loans>div.card.flipped>div.back>div#personal-loan-form>div.personal-form>span>span>input");


    //Results Page Elements
    public final static By btnFinalReminder = By.cssSelector("button.btn.btn-primary.reminder");
    public final static By txtFailMessage = By.cssSelector("div.title-section>h3.big-title");

}
