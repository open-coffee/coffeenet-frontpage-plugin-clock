package coffee.synyx.frontpage.plugin.clock;

import coffee.synyx.frontpage.plugin.api.ConfigurationDescription;
import coffee.synyx.frontpage.plugin.api.ConfigurationInstance;
import coffee.synyx.frontpage.plugin.api.FrontpagePlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
