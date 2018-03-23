package coffee.synyx.frontpage.plugin.clock;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZonedDateTime;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

import static java.time.Clock.systemDefaultZone;
import static java.time.ZoneId.systemDefault;


public class FrontpagePluginInterfaceImplTest {

    @Test
    public void hasCorrectTitle() {

        final String title = new FrontpagePluginInterfaceImpl(systemDefaultZone()).title();
        assertThat(title, is("Clock"));
    }


    @Test
    public void clockHasCorrectTime() {

        final Instant fixedInstant = ZonedDateTime.of(2018, 11, 13, 0, 0, 0, 0, systemDefault()).toInstant();
        final Clock clock = Clock.fixed(fixedInstant, systemDefault());
        final FrontpagePluginInterfaceImpl sut = new FrontpagePluginInterfaceImpl(clock);

        final String content = sut.content();
        assertThat(content, is("Hello CoffeeNet, it is 2018-11-13 12:00:00"));
    }
}
