package ops;

import entity.Player;
import entity.Team;

import java.util.Random;

/**
 * The CricketMatch class represents a cricket match played between two teams.
 * It handles the match logic including playing innings, printing scorecards, and determining the match result.
 *
 * @author Niraj_Bhoyar
 */
public class CricketMatch implements Match {

    private Team teamA;
    private Team teamB;
    private Random random;

    /**
     * Constructs a CricketMatch with the specified teams.
     *
     * @param teamA the first team
     * @param teamB the second team
     */
    public CricketMatch(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.random = new Random();
    }

    private static final int TOTAL_EVENTS = 10;
    private static final int WIDE_BALL_EVENT = 0;
    private static final int RUNS_END_EVENT = 6;

    private final int[] possibleRuns = {1, 2, 3, 4, 6};

    /**
     * Plays an innings for the given batting and bowling teams.
     * The method simulates the events of a cricket innings including scoring runs, handling wide balls, and losing wickets.
     *
     * @param battingTeam the team that is batting
     * @param bowlingTeam the team that is bowling
     */
    @Override
    public void playInnings(Team battingTeam, Team bowlingTeam) {
        int currentBatsmanIndex = 0;
        Player currentBatsman = battingTeam.getPlayers().get(currentBatsmanIndex);

        for (int over = 0; over < 5; over++) {
            for (int ball = 0; ball < 6; ball++) {
                // Check if all 10 wickets are lost
                if (battingTeam.getWicketsLost() == 10) {
                    return; // Innings ends
                }

                int event = random.nextInt(TOTAL_EVENTS);

                if (event == WIDE_BALL_EVENT) {
                    battingTeam.addRuns(1); // Extra run for wide ball
                } else if (event <= RUNS_END_EVENT) {
                    int runs = getRandomRuns();
                    currentBatsman.addRuns(runs);
                    currentBatsman.incrementBallsFaced();
                    battingTeam.addRuns(runs); // Add runs to team score
                } else {
                    currentBatsman.setOut(true); // Player is out
                    battingTeam.incrementWicketsLost();
                    currentBatsmanIndex++;
                    if (currentBatsmanIndex < battingTeam.getPlayers().size()) {
                        currentBatsman = battingTeam.getPlayers().get(currentBatsmanIndex);
                    }
                }
                battingTeam.incrementBallsBowled();
            }
        }
    }

    /**
     * Prints the scorecard of the given team.
     * The scorecard includes details of each player's performance and the team's total runs, wickets lost, and balls bowled.
     *
     * @param team the team for which to print the scorecard
     */
    @Override
    public void printScorecard(Team team) {
        System.out.println("Scorecard for " + team.getName() + ":");
        team.getPlayers().forEach(player -> System.out.println(
                player.getName() +
                        (player.isCaptain() ? " (C)" : "") +
                        (player.isWicketKeeper() ? " (WK)" : "") +
                        " - Runs: " + player.getRunsScored() +
                        ", Balls: " + player.getBallsFaced() +
                        ", Out: " + player.isOut()));
        System.out.println("Total Runs: " + team.getTotalRuns());
        System.out.println("Wickets Lost: " + team.getWicketsLost());
        System.out.println("Balls Bowled: " + team.getBallsBowled());
    }

    /**
     * Plays the match between the two teams.
     * This includes playing innings for both teams, printing the scorecards, and determining the winner.
     */
    @Override
    public void playMatch() {
        System.out.println("Team A is batting...");
        playInnings(teamA, teamB);
        printScorecard(teamA);

        System.out.println("************ End of Inning *********");

        System.out.println("Team B is batting...");
        playInnings(teamB, teamA);
        printScorecard(teamB);

        if (teamA.getTotalRuns() > teamB.getTotalRuns()) {
            System.out.println("Team A wins!");
        } else if (teamB.getTotalRuns() > teamA.getTotalRuns()) {
            System.out.println("Team B wins!");
        } else {
            System.out.println("Match has drawn");
        }
    }

    /**
     * Generates a random number of runs from the possible runs array.
     *
     * @return the random number of runs
     */
    private int getRandomRuns() {
        return possibleRuns[random.nextInt(possibleRuns.length)];
    }
}
