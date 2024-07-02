import entity.Player;
import entity.Team;
import ops.CricketMatch;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Test class for the CricketMatch class.
 * This class contains unit tests to validate the functionality of a cricket match between two teams.
 *
 * @author Niraj_Bhoyar
 */
public class CricketMatchTest {

    /**
     * Tests the match result to ensure the cricket match runs correctly and produces valid results.
     * It creates two teams with 11 players each, initializes a cricket match between them,
     * and plays the match. The test then asserts that the total runs and balls bowled are within expected limits.
     */
    @Test
    public void testMatchResult() {
        List<Player> teamAPlayers = new ArrayList<>();
        List<Player> teamBPlayers = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            //if i==0, it sets 1st player as Captain, and similarly 2nd as wicket keeper with i==1.
            teamAPlayers.add(new Player("Team A Player " + (i + 1), i == 0, i == 1));
            teamBPlayers.add(new Player("Team B Player " + (i + 1), i == 0, i == 1));
        }

        Team teamA = new Team("Team A", teamAPlayers);
        Team teamB = new Team("Team B", teamBPlayers);

        CricketMatch match = new CricketMatch(teamA, teamB);
        match.playMatch();

        // Assertions to validate the match result
        assertTrue(teamA.getTotalRuns() >= 0);
        assertTrue(teamB.getTotalRuns() >= 0);
        assertTrue(teamA.getBallsBowled() <= 30);
        assertTrue(teamB.getBallsBowled() <= 30);
    }
}
