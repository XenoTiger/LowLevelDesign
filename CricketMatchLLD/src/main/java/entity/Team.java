package entity;

import java.util.List;

/**
 * Represents a cricket team with its name, players, and match statistics.
 *
 * @author Niraj_Bhoyar
 */
public class Team {

    private String name;
    private List<Player> players;
    private int totalRuns;
    private int wicketsLost;
    private int ballsBowled;

    /**
     * Constructs a new Team with the specified name and list of players.
     *
     * @param name    The name of the team.
     * @param players The list of players in the team.
     */
    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
        this.totalRuns = 0;
        this.wicketsLost = 0;
        this.ballsBowled = 0;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    /**
     * Adds runs to the team's total score.
     *
     * @param runs The runs to be added to the team's total score.
     */
    public void addRuns(int runs) {
        this.totalRuns += runs;
    }

    public int getWicketsLost() {
        return wicketsLost;
    }

    /**
     * Increments the count of wickets lost by 1.
     */
    public void incrementWicketsLost() {
        this.wicketsLost += 1;
    }

    /**
     * Retrieves the number of balls bowled by the team.
     *
     * @return The number of balls bowled by the team.
     */
    public int getBallsBowled() {
        return ballsBowled;
    }

    /**
     * Increments the count of balls bowled by 1.
     */
    public void incrementBallsBowled() {
        this.ballsBowled += 1;
    }


}
