package coffee.synyx.frontpage.plugin.clock;

import coffee.synyx.frontpage.plugin.api.FrontpagePluginInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClockPlugin implements FrontpagePluginInterface {

    private final ClockContentRenderer contentRenderer;

    @Autowired
    public ClockPlugin(ClockContentRenderer contentRenderer) {

        this.contentRenderer = contentRenderer;
    }

    @Override
    public String title() {

        return "Clock";
    }


    @Override
    public String content() {

        return contentRenderer.render();
    }
}
