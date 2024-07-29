package com.zemoso.madhurendra.extentReports;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ExtentReportTest extends BaseTest {

    @Before
    public void setUpTest() {
        test = extent.createTest("ExtentReportTest", "Sample Test to demonstrate ExtentReports");
    }

    @After
    public void tearDownTest() {
        if (test.getStatus().toString().equalsIgnoreCase("pass")) {
            test.pass("Test Passed");
        } else {
            test.fail("Test Failed");
        }
    }

    @Test
    public void testExampleSuccess() {
        driver.get("https://www.browserstack.com/");
        String title = driver.getTitle();
        test.info("Navigated to BrowserStack");
        assertTrue(title.contains("BrowserStack"));
        test.info("Title contains 'BrowserStack'");
    }

    @Test
    public void testExampleFailure() {
        driver.get("https://www.browserstack.com/");
        String title = driver.getTitle();
        test.info("Navigated to BrowserStack");
        assertTrue("Title should contain 'NonExistingTitle'", title.contains("NonExistingTitle"));
        test.info("Title does not contain 'NonExistingTitle'");
    }
}
