package coffee.synyx.frontpage.plugin.clock;

import org.junit.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

import static java.time.ZoneOffset.UTC;


public class FrontpagePluginInterfaceImplTest {

    @Test
    public void clockHasCorrectTime() {

        Clock clock = Clock.fixed(LocalDateTime.of(2018, 11, 13, 0, 0).toInstant(UTC), ZoneId.of(UTC.toString()));
        final FrontpagePluginInterfaceImpl sut = new FrontpagePluginInterfaceImpl(clock);

        final String render = sut.render();
        assertThat(render, is("Hello CoffeeNet, it is 2018-11-13T00:00:00Z"));
    }
}
