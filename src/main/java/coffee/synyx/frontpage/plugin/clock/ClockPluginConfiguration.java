package coffee.synyx.frontpage.plugin.clock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;


@Configuration
class ClockPluginConfiguration {

    @Bean("plugin.clock.defaultClock")
    Clock clock() {

        return Clock.systemDefaultZone();
    }
}
