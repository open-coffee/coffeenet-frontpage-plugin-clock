package coffee.synyx.frontpage.plugin.clock;

import org.junit.Test;


import java.time.Clock;
import java.time.Instant;
import java.time.ZonedDateTime;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

import static java.time.ZoneOffset.UTC;


public class FrontpagePluginInterfaceImplTest {

    @Test
    public void clockHasCorrectTime() {

        final Instant fixedInstant = ZonedDateTime.of(2018, 11, 13, 0, 0, 0, 0, UTC).toInstant();
        final Clock clock = Clock.fixed(fixedInstant, UTC);
        final FrontpagePluginInterfaceImpl sut = new FrontpagePluginInterfaceImpl(clock);

        final String render = sut.content();
        assertThat(render, is("Hello CoffeeNet, it is 2018-11-13 01:00:00"));
    }
}
