package coffee.synyx.frontpage.plugin.clock;

import coffee.synyx.frontpage.plugin.api.FrontpagePluginInterface;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;


@Service
public class FrontpagePluginInterfaceImpl implements FrontpagePluginInterface {

    private final Clock clock;

    @Autowired
    public FrontpagePluginInterfaceImpl(Clock clock) {

        this.clock = clock;
    }

    @Override
    public String render() {

        return "Hello CoffeeNet, it is " + Instant.now(clock).toString();
    }
}
