package coffee.synyx.frontpage.plugin.clock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
class ClockContentRenderer {

    private final TemplateEngine templateEngine;

    @Autowired
    ClockContentRenderer(@Qualifier("clockTemplateEngine") TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    String render() {
        Context context = new Context();
        return templateEngine.process("clock", context);
    }
}
