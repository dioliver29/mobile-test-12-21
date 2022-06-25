package dioliver.helpers;

import org.aeonbits.owner.ConfigFactory;

public class AppConfigDriver {
    public static AppConfig config = ConfigFactory.create(AppConfig.class, System.getProperties());

}

