package coffee.synyx.frontpage.plugin.clock;

import org.junit.Ignore;
import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClockContentRendererTest {

    @Test
    @Ignore("TemplateEngine#process is final. waiting for Thymeleaf3 and ITemplateEngine")
    public void ensureRender() {

        final TemplateEngine templateEngine = mock(TemplateEngine.class);
        when(templateEngine.process(anyString(), any(Context.class))).thenReturn("rendered content");

        final ClockContentRenderer renderer = new ClockContentRenderer(templateEngine);
        final String actual = renderer.render();

        assertThat(actual).isEqualTo("rendered content");
    }
}
