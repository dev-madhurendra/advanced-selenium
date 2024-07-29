package com.zemoso.madhurendra.handleCSVFile;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CSVTest {
    private WebDriver driver;
    private List<String[]> results;

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            results.add(new String[]{description.getMethodName(), "FAILED"});
        }

        @Override
        protected void succeeded(Description description) {
            results.add(new String[]{description.getMethodName(), "PASSED"});
        }
    };

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        results = new ArrayList<>();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        CSVUtils.writeCSV("test-result.csv", results);
    }

    @Test
    public void testExampleSuccess() {
        driver.get("https://www.browserstack.com/");
        assertTrue(true);
    }

    @Test
    public void testExampleFailure() {
        driver.get("https://www.browserstack.com/");
        assertTrue(false);
    }

    @Test
    public void testWithDataFromCSV() {
        List<String[]> testData = CSVUtils.readCSV("test-data.csv");

        for (String[] data : testData) {
            String url = data[0];
            String expectedTitle = data[1];

            driver.get(url);
            String actualTitle = driver.getTitle();
            assertTrue(actualTitle.contains(expectedTitle));
        }
    }
}
