package coffee.synyx.frontpage.plugin.clock;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ClockPluginTest {

    @Test
    public void hasCorrectTitle() {

        final ClockContentRenderer contentRenderer = mock(ClockContentRenderer.class);
        final String title = new ClockPlugin(contentRenderer).title();
        assertThat(title).isEqualTo("Clock");
    }

    @Test
    public void hasCorrectId() {

        final ClockContentRenderer contentRenderer = mock(ClockContentRenderer.class);
        final String id = new ClockPlugin(contentRenderer).id();
        assertThat(id).isEqualTo("clock");
    }


    @Test
    public void clockHasCorrectTime() {

        final ClockContentRenderer contentRenderer = mock(ClockContentRenderer.class);
        final ClockPlugin sut = new ClockPlugin(contentRenderer);

        when(contentRenderer.render()).thenReturn("rendered content");

        final String content = sut.content();
        assertThat(content).isEqualTo("rendered content");
    }
}
