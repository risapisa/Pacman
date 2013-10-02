package ca.ubc.cpsc210.pacman.model;

import java.util.LinkedList;
import java.util.List;

public class GridLocation {
	
	private List<Sprite> Monsters = new LinkedList<Sprite>();
	private Sprite pacman = null;
	//private Sprite sprite = null;
	private boolean hasFood = false;
	private boolean isWall = false;
	
	// Requires: type is a valid grid location type (W, D, or E)
	// Modifies: this
	// Effects: sets up this as the proper type, a Wall, Food Location, or Empty
	public GridLocation(char type) {
		switch (type) {
		case 'W':
			isWall = true; break;
		case 'D':
			addFood(); break;
		case 'E': 
			break;
		default:
			throw new Error("Unknown grid location type.");
		}
	}
	

	// Requires: a valid grid type type, and a Sprite s
	// Modifies: this
	// Effects:  remembers s, and sets up this location given by the type type
	public GridLocation(char type, Sprite s) {
		this(type);
		addSprite(s);
	}

	// Requires: nothing
	// Modifies: nothing
	// Effects:  returns false if this location is a wall
	public boolean isPassable() {
		return !isWall;
	}
	
	// Requires: nothing
	// Modifies: nothing
	// Effects:  returns true if this location has food
	public boolean hasFood() {
		return hasFood;
	}
	
	// Requires: nothing
	// Modifies: nothing
	// Effects:  returns true if this location has a TrackerMonster, RandomMonster or Pacman in it
	public boolean hasSprite() {
		return !Monsters.isEmpty() || pacman != null;
	}
	
	// Requires: nothing
	// Modifies: this
	// Effects:  removes s as a Sprite of this location if it was here in the first place
	public void removeSprite(Sprite s) {
		if (s instanceof Pacman) 
			pacman = null;
			else 
		Monsters.remove(s);	
	}
	
	
	// Requires: s is a valid Sprite on the board
	// Modifies: this
	// Effects:  adds s to this location
	public void addSprite(Sprite s) {
		if (s instanceof Pacman) {
			pacman= s;
			consumeFood();
			} else {
			Monsters.add(s);
	}
	}
		

	// Requires: nothing 
	// Modifies: nothing
	// Effects:  returns Pacman (if any) at this grid location (null if none)
	public Sprite getPacman() {
		return pacman;
	}
	
	// Requires: nothing 
	// Modifies: nothing
	// Effects:  returns the top sprite of Sprite (if any) at this grid location (null if none)
	public Sprite getMonster() {
		return Monsters.isEmpty() ? null : Monsters.get(0);
	}

	public void consumeFood() {
		hasFood = false;
	}

	public void addFood() {
		hasFood = true;		
	}
}
