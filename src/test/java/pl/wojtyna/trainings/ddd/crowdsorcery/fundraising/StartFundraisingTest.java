package pl.wojtyna.trainings.ddd.crowdsorcery.fundraising;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wojtyna.trainings.ddd.crowdsorcery.investment.invest.Investor;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Starting fundraising")
class StartFundraisingTest {

    // @formatter:off
    @DisplayName(
        """
         given George,
         when George starts fundraising,
         then fundraising is started
        """
    )
    // @formatter:on
    @Test
    void test() {
        // given
        var system = new FundraisingSystem();
        var george = new Investor();
        var projectForm = new ProjectForm();

        // when
        var events = system.startFundraising().by(george).basedOn(projectForm);

        // then
        assertThat(events.hasOccurredEventOfType(ProjectFundraisingStarted.class)).isTrue();
    }
}
