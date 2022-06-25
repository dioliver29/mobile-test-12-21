package dioliver.helpers;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:credential.properties"
})


public interface AppConfig extends Config {

    String login();
    String password();
    String appUrl();
    String device();
    String os_version();
    String project();
    String build();
    String name();
    String remoteUrl();


}
