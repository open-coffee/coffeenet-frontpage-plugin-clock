package rocks.coffee.frontpage.plugin.clock;

import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class ClockPluginConfigurationTest {

    @Test
    public void ensureClockTemplateResolver() {

        final ClockPluginConfiguration configuration = new ClockPluginConfiguration();
        final TemplateResolver templateResolver = configuration.clockTemplateResolver();
        // initialize, otherwise #getPrefix throws org.thymeleaf.exceptions.NotInitializedException
        templateResolver.initialize();

        assertThat(templateResolver).isInstanceOf(ClassLoaderTemplateResolver.class);
        assertThat(templateResolver.getPrefix()).isEqualTo("templates/clock/");
        assertThat(templateResolver.getSuffix()).isEqualTo(".html");
        assertThat(templateResolver.getTemplateMode()).isEqualTo("HTML5");
        assertThat(templateResolver.getCharacterEncoding()).isEqualTo("UTF-8");
    }

    @Test
    public void ensureClockTemplateEngine() {

        final ClockPluginConfiguration configuration = new ClockPluginConfiguration();
        final TemplateEngine templateEngine = configuration.clockTemplateEngine();

        assertThat(templateEngine).isInstanceOf(SpringTemplateEngine.class);

        final Set<ITemplateResolver> templateResolvers = templateEngine.getTemplateResolvers();
        assertThat(templateResolvers).hasSize(1);

        final ITemplateResolver clockTemplateResolver = templateResolvers.iterator().next();
        assertThat(clockTemplateResolver).isInstanceOf(ClassLoaderTemplateResolver.class);
    }
}
