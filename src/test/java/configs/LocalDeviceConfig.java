package configs;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:localdevice.properties"})

public interface LocalDeviceConfig extends Config {
    @Key("DeviceName")
    @DefaultValue("Pixel 7 Pro API 33")
    String getDeviceName();

    @Key("PlatformVersion")
    @DefaultValue("13.0")
    String getPlatformVersion();

    @Key("AppPackage")
    @DefaultValue("org.wikipedia.alpha")
    String getAppPackage();

    @Key("AppActivity")
    @DefaultValue("org.wikipedia.main.MainActivity")
    String getAppActivity();
}