package configs;

import drivers.BrowserstackDriver;
import drivers.LocalDriver;

public class DeviceHostConfig {
    private static String host = System.getProperty("deviceHost", "emulation");

    public static String getConfig() {
        switch (host) {
            case ("android"):
            case ("ios"):
                return BrowserstackDriver.class.getName();
            default:
                return LocalDriver.class.getName();
        }
    }
}