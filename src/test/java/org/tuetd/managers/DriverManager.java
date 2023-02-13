package org.tuetd.managers;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.options.WindowsOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {

    private static final ThreadLocal<WindowsDriver> drivers = new ThreadLocal<>();

    public static synchronized WindowsDriver getDriver() {
        return drivers.get();
    }

    public static synchronized void setDrivers(WindowsDriver driver) {
        drivers.set(driver);
    }

    public static synchronized Boolean doesDriverExist() {
        return getDriver() != null;
    }

    public static synchronized Boolean isDriverSessionActive() {
        return getDriverSessionId() != null;
    }

    private static synchronized SessionId getDriverSessionId() {
        SessionId sessionId = null;

        if (doesDriverExist()) {
            sessionId = DriverManager.getDriver().getSessionId();
        }

        return sessionId;
    }

    public static WindowsDriver createWindowsDriver() {
        LoggingManager.logInfo(DriverManager.class, "=== Creating new windows driver ===");

        WindowsDriver driver = null;
        WindowsOptions capabilities = new WindowsOptions();
        capabilities.setCapability("app", "SymplastAcquisitionInc.SymplastPractice_nttdm19prm2hj!App");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "windows");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "windows");

        try {
            driver = new WindowsDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        } catch (MalformedURLException exception) {
            LoggingManager.logError(DriverManager.class, "Error when creating iOS driver", exception);
        }

        setDrivers(driver);
        return driver;
    }

    public static void tearDownDriver() {
        WindowsDriver driver = getDriver();

        if (driver != null) {
            driver.quit();
        }
    }
}
