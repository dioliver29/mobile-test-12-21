package dioliver.drivers;

import com.codeborne.selenide.WebDriverProvider;
import dioliver.helpers.AppConfigDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {


    @Override
    public WebDriver createDriver( Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", AppConfigDriver.config.login());
        mutableCapabilities.setCapability("browserstack.key", AppConfigDriver.config.password());

        // Set URL of the application under test
//        mutableCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        mutableCapabilities.setCapability("app", AppConfigDriver.config.appUrl());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", AppConfigDriver.config.device());
        mutableCapabilities.setCapability("os_version", AppConfigDriver.config.os_version());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", AppConfigDriver.config.project());
        mutableCapabilities.setCapability("build", AppConfigDriver.config.build());
        mutableCapabilities.setCapability("name", AppConfigDriver.config.name());
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(AppConfigDriver.config.remoteUrl());
        }  catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
