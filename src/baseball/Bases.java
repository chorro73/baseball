package baseball;

import java.util.*;

public class Bases {
	public static final Player NO_RUNNER = new Player("EMPTY", "BASE", 0);
	private LinkedList<Player> bases;
	
	public Bases() {
		clearBases();
	}
	
	public void clearBases() {
		bases = new LinkedList<>();
		for (int i = 0; i < 3; i++) {
			bases.add(NO_RUNNER);
		}
	}
	
	public void advanceRunners(int numBases) {
		for (int i = 0; i < numBases; i++) {
			bases.addFirst(NO_RUNNER);
		}
	}
	
	/**
	 * @param base 1 for First Base, 2 for Second Base, 3 for Third Base
	 */
	public void putRunnerOn(Player runner, int base) {
		int index = base - 1;
		bases.set(index, runner);
	}
	
	public int getNumRunnersOn() {
		int result = 0;
		Iterator<Player> it = bases.iterator();
		for (int i = 0; i < 3; i++) {
			if (!it.next().equals(NO_RUNNER)) {
				result++;
			}
		}
		return result;
	}
	
	public Player getRunnerOnFirst() {
		return bases.get(0);
	}
	
	public Player getRunnerOnSecond() {
		return bases.get(1);
	}
	
	public Player getRunnerOnThird() {
		return bases.get(2);
	}
	
	public String scoreBoardString() {
		StringBuilder s = new StringBuilder();
		String[] nameStrings = new String[3];
		for (int i = 0; i < 3; i++) {
			if (bases.get(i) == NO_RUNNER)
				nameStrings[i] = "";
			else
				nameStrings[i] = bases.get(i).getLastName();
		}
		//second
		int gap = (28 - nameStrings[1].length()) / 2;
		s.append(String.format("%" + gap + "s[%s]\n\n", 
				"", nameStrings[1]));
		// first and third
		gap = (26 - (nameStrings[0].length() + nameStrings[2].length()));
		s.append(String.format("[%s]%" + gap + "s[%s]\n\n", nameStrings[2], "", nameStrings[0]));
		return s.toString();
	}
	
	@Override
	public String toString() {
		return bases.toString();
	}
	
}
