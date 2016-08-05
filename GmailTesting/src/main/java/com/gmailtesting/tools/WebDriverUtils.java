package com.gmailtesting.tools;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class WebDriverUtils {

	private static long implicitlyWaitTimeout = 10L;
	private static WebDriver driver;

	private static HashMap<Long, WebDriver> browsers;

	static {
		browsers = new HashMap<Long, WebDriver>();
	}

	private WebDriverUtils() {
	}

	public static synchronized void load(String URI) {
		synchronized (WebDriverUtils.class) {
			getWebDriver().get(URI);
		}
	}

	public static synchronized WebDriver getWebDriver() {

		synchronized (WebDriverUtils.class) {

			driver = browsers.get(Thread.currentThread().getId());

			if (driver == null) {
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(implicitlyWaitTimeout, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				browsers.put(Thread.currentThread().getId(), driver);
				return driver;

			}
		}
		synchronized (WebDriverUtils.class) {
			return browsers.get(Thread.currentThread().getId());
		}
	}

	public static void setImplicitlyWaitTimeout(long implicitlyWaitTimeout) {
		driver.manage().timeouts().implicitlyWait(implicitlyWaitTimeout, TimeUnit.SECONDS);
	}

	static long getImplicitlyWaitTimeout() {
		return implicitlyWaitTimeout;
	}

	public static void close() {
		synchronized (WebDriverUtils.class) {
			getWebDriver().close();
			getWebDriver().quit();
			browsers.remove(Thread.currentThread().getId());
		}
	}

}