package rocks.coffee.frontpage.plugin.clock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocks.coffeenet.frontpage.plugin.api.ConfigurationDescription;
import rocks.coffeenet.frontpage.plugin.api.ConfigurationInstance;
import rocks.coffeenet.frontpage.plugin.api.FrontpagePlugin;

import java.util.Optional;


@Component
public class ClockPlugin implements FrontpagePlugin {

    private final ClockContentRenderer contentRenderer;

    @Autowired
    public ClockPlugin(ClockContentRenderer contentRenderer) {

        this.contentRenderer = contentRenderer;
    }

    @Override
    public String title(ConfigurationInstance configurationInstance) {

        return "Clock";
    }


    @Override
    public String content(ConfigurationInstance configurationInstance) {

        return contentRenderer.render();
    }

    @Override
    public String id() {
        return "clock";
    }

    @Override
    public Optional<ConfigurationDescription> getConfigurationDescription() {

        return Optional.empty();
    }
}
