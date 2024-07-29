package com.zemoso.madhurendra.tookScreenshot;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static org.junit.Assert.assertTrue;

public class ScreenshotTest extends BaseTest {

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            takeScreenshot(description.getMethodName());
        }

        @Override
        protected void succeeded(Description description) {}
    };

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
}
