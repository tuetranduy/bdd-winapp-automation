package org.tuetd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.tuetd.managers.LoggingManager;
import org.tuetd.managers.DriverManager;

public class CommonSteps {

    @Before
    public static void setUp() {
        setupDriver();
    }

    @After
    public static void tearDown() {
        tearDownDriver();
    }

    public static void setupDriver() {
        if (!DriverManager.isDriverSessionActive()) {
            DriverManager.createWindowsDriver();
            LoggingManager.logInfo(CommonSteps.class, "Opened an application");
        }
    }

    public static void tearDownDriver() {
        if (DriverManager.isDriverSessionActive()) {
            DriverManager.tearDownDriver();
        }
    }
}

