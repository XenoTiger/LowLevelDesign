package entity;

/**
 * Represents a player in a cricket team with attributes such as name, role (captain or wicket keeper),
 * batting statistics (runs scored, balls faced), and out status.
 *
 * @author Niraj_Bhoyar
 */
public class Player {

    private String name;
    private boolean isCaptain;
    private boolean isWicketKeeper;
    private int runsScored;
    private int ballsFaced;
    private boolean isOut;


    /**
     * Constructs a new Player with the specified name, captaincy status, and wicket keeper status.
     *
     * @param name           The name of the player.
     * @param isCaptain      Whether the player is the captain of the team.
     * @param isWicketKeeper Whether the player is the wicket keeper of the team.
     */
    public Player(String name, boolean isCaptain, boolean isWicketKeeper) {
        this.name = name;
        this.isCaptain = isCaptain;
        this.isWicketKeeper = isWicketKeeper;
        this.runsScored = 0;
        this.ballsFaced = 0;
        this.isOut = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public boolean isWicketKeeper() {
        return isWicketKeeper;
    }

    public int getRunsScored() {
        return runsScored;
    }

    /**
     * Adds runs scored by the player.
     *
     * @param runs The runs to be added to the player's score.
     */
    public void addRuns(int runs) {
        this.runsScored += runs;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    /**
     * Increments the count of balls faced by the player.
     */
    public void incrementBallsFaced() {
        this.ballsFaced += 1;
    }

    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean out) {
        isOut = out;
    }
}
