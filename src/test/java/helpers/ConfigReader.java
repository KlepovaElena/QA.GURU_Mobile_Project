package helpers;

import configs.AuthConfig;
import configs.DeviceConfig;
import configs.LocalDeviceConfig;
import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    INSTANCE;

    private static final DeviceConfig DEVICE_CONFIG =
            ConfigFactory.create(DeviceConfig.class, System.getProperties());

    public DeviceConfig getDeviceConfig() {
        return DEVICE_CONFIG;
    }

    private static final AuthConfig AUTH_CONFIG =
            ConfigFactory.create(AuthConfig.class, System.getProperties());

    public AuthConfig getAuthConfig() {
        return AUTH_CONFIG;
    }

    private static final LocalDeviceConfig LOCAL_DEVICE_CONFIG =
            ConfigFactory.create(LocalDeviceConfig.class, System.getProperties());

    public LocalDeviceConfig getLocalDeviceConfig() {
        return LOCAL_DEVICE_CONFIG;
    }
}