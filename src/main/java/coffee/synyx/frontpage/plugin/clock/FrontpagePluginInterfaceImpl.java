package coffee.synyx.frontpage.plugin.clock;

import coffee.synyx.frontpage.plugin.api.FrontpagePluginInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;

import java.time.Clock;

import static java.time.Instant.now;
import static java.time.ZoneId.systemDefault;
import static java.time.format.DateTimeFormatter.ofPattern;


@Component
public class FrontpagePluginInterfaceImpl implements FrontpagePluginInterface {

    private final Clock clock;

    @Autowired
    public FrontpagePluginInterfaceImpl(@Qualifier("plugin.clock.defaultClock") Clock clock) {

        this.clock = clock;
    }

    @Override
    public String title() {

        return "Clock";
    }


    @Override
    public String content() {

        return "Hello CoffeeNet, it is "
            + ofPattern("yyyy-MM-dd hh:mm:ss").withZone(systemDefault()).format(now(clock));
    }
}
