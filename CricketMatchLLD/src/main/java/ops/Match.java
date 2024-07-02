package ops;

import entity.Team;

public interface Match {

    void playInnings(Team battingTeam, Team bowlingTeam);
    void printScorecard(Team team);
    void playMatch();
}
