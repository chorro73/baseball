package baseball;

import java.util.*;

public class Game {
	private List<Player> awayTeam;
	private List<Player> homeTeam;
	private int currentAwayHitter;
	private int currentHomeHitter;
	private int inning;
	private boolean isBottom;
	private int awayScore;
	private int homeScore;
	private LinkedList<Player> bases;

	public Game(List<Player> awayTeam, List<Player> homeTeam) {
		this.awayTeam = awayTeam;
		this.homeTeam = homeTeam;
		currentAwayHitter = 0;
		currentHomeHitter = 0;
		inning = 1;
		isBottom = false;
		awayScore = 0;
		homeScore = 0;
		bases = new LinkedList<>();
		for (int i = 0; i < 3; i++) {
			bases.push(null);
		}
	}

	/**
	 * Update the game to reflect a single by the current hitter.
	 */
	public void single() {
		Player currentHitter = getCurrentBatter();
		bases.push(currentHitter);
		currentHitter.single(countRuns());
	}
	
	/**
	 * Checks how many runners scored on the last hit, and clears the bases structure
	 * to keep only the current base runners. Adjusts score accordingly.
	 * @return
	 */
	private int countRuns() {
		// TODO: count runs
		// TODO: clear bases
		// TODO: increments scores
		return 0;
	}
	
	private Player getCurrentBatter() {
		return isBottom ? homeTeam.get(currentHomeHitter) : awayTeam.get(currentAwayHitter);
	}

	public static void main(String[] args) {
		Game g = new Game(new ArrayList<Player>(), new ArrayList<Player>());
		System.out.println(g.bases.size());
	}

}
