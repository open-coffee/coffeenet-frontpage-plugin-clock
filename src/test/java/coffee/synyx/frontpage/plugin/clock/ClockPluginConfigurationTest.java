package coffee.synyx.frontpage.plugin.clock;

import org.junit.Test;

import java.time.Clock;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class ClockPluginConfigurationTest {

    @Test
    public void isSystemDefaultZone() {

        ClockPluginConfiguration clockConf = new ClockPluginConfiguration();
        assertThat(clockConf.clock().getZone()).isEqualTo(Clock.systemDefaultZone().getZone());
    }
}
