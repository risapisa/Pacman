package ca.ubc.cpsc210.pacman.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Board {


	private static int BOARD_WIDTH = 13;
	private static int BOARD_HEIGHT = 8;
	
	private static String BOARD_DEFN = "WWWWWWWWWWWWW" + 
									   "WDRDDDDDDMDDW" +
									   "WDWDWWWWWDWDW" +
									   "WDWDWDRDWDWDW" +
									   "WDWDDDWDDDWDW" +
									   "WDWWDWWWDWWDW" +
									   "WDDDDDPDDDDDW" +
									   "WWWWWWWWWWWWW";
	
	
	List<List<GridLocation>> board;
	
	Sprite pacman;
	List<Sprite> sprites;
//	List<TrackerMonster> trackerMonsters;

	
	// Requires: nothing
	// Modifies: this
	// Effects:  delegates board initialization to initBoard
	public Board() {
		initBoard();
	}

	// Requires: nothing
	// Modifies: this
	// Effects:  initializes a default board with food, monsters and pacman placed according to BOARD_DEFN
	private void initBoard() {
		pacman = new Pacman(this);
		sprites = new LinkedList<Sprite>();

		
		// Crazy board initialization code.
		board = new ArrayList<List<GridLocation>>(BOARD_HEIGHT);
		for (int i = 0; i < BOARD_HEIGHT; i++) {
			board.add(new ArrayList<GridLocation>(BOARD_WIDTH));
		}
		
		for (int i = 0; i < BOARD_DEFN.length(); i++) {
			char type = BOARD_DEFN.charAt(i);
			
			int x = i % BOARD_WIDTH;
			int y = i / BOARD_WIDTH;
			
			if (type == 'M') {
				TrackerMonster s = new TrackerMonster(this,x,y);
				sprites.add(s);
				board.get(y).add(new GridLocation('D', s));
			} else if (type == 'R') {
				RandomMonster s = new RandomMonster(this,x,y);
				sprites.add(s);
				board.get(y).add(new GridLocation('D', s));
			} else if (type == 'P') {
				pacman.setLocation(x,y);
				board.get(y).add(new GridLocation('E', pacman));
			} else {
				board.get(y).add(new GridLocation(type));
			}
		}
	}
	
	// Getter methods:
	// Requires: nothing
	// Modifies: nothing
	// Effects: returns the contents of the relevant field
	public int getBoardWidth() { return BOARD_WIDTH; }
	public int getBoardHeight() { return BOARD_HEIGHT; }
	public GridLocation getLocation(int x, int y) { return board.get(y).get(x);	}
	public List<List<GridLocation>> getGridRows() {	return board; }
	public List<Sprite> getTrackerMonsters() { return sprites; }

	// Requires: nothing
	// Modifies: this, pacman, trackerMonsters, randomMonsters
	// Effects: calls make move on pacman and each of the monsters on the board
	public void tickBoard() {
		pacman.makeMove();
		
		for (Sprite m : sprites) {
			m.makeMove();
		}
	}
	
	// Requires: nothing
	// Modifies: nothing
	// Effects: returns true if the game is over (either all the food is eaten, or pacman and a monster ovelap)
	public boolean isGameOver() {
		// Check to see if all the food pellets are gone
		boolean existsFood = false;
		for (List<GridLocation> row : getGridRows()) {
			for (GridLocation g : row) {
				if (g.isPassable()) {
					if (g.hasFood()) existsFood = true;
				}
			}
		}
		
		boolean pacmanCaught = false;
		for (Sprite m : sprites) {
			if (m.getX() == pacman.getX() &&
				m.getY() == pacman.getY()) 
				pacmanCaught = true;
		}
		
		return pacmanCaught || !existsFood;
	}

	// Requires: Nothing
	// Modifies: Nothing
	// Effects: returns true if new_x, new_y are within the bounds of the board, and not a wall GridLocation
	public boolean canMoveTo(int new_x, int new_y) {
		return new_x >= 0 && new_y >= 0 && new_x < BOARD_WIDTH && new_y < BOARD_HEIGHT 
			&& getLocation(new_x, new_y).isPassable();
	}

	// Requires: sprite is a valid Sprite on this board, and position (new_x, new_y) is a valid board position
	// Modifies: this, sprite
	// Effects:  moves the given sprite to the proper location on the board, and changes the (x,y) position of the sprite to reflect the move
	public void moveTo(Sprite sprite, int new_x, int new_y) {
		getLocation(sprite.getX(), sprite.getY()).removeSprite(sprite);
		getLocation(new_x, new_y).addSprite(sprite);
		sprite.setLocation(new_x, new_y);
	}
//	}

	
	// Requires: sprite is a valid TrackerMonster on this board, and position (new_x, new_y) is a valid board position
	// Modifies: this, sprite
	// Effects:  moves the given sprite to the proper location on the board, and changes the (x,y) position of the sprite to reflect the move
//	public void moveTo(TrackerMonster sprite, int new_x, int new_y) {
//		getLocation(sprite.getX(), sprite.getY()).removeSprite(sprite);
//		getLocation(new_x, new_y).addSprite(sprite);
//		sprite.setLocation(new_x, new_y);
//	}
	
	// Requires: sprite is a valid RandomMonster on this board, and position (new_x, new_y) is a valid board position
	// Modifies: this, sprite
	// Effects:  moves the given sprite to the proper location on the board, and changes the (x,y) position of the sprite to reflect the move
//	public void moveTo(RandomMonster sprite, int new_x, int new_y) {
//		getLocation(sprite.getX(), sprite.getY()).removeSprite(sprite);
//		getLocation(new_x, new_y).addSprite(sprite);
//		sprite.setLocation(new_x, new_y);
//	}

	// Requires: nothing
	// Modifies: nothing
	// Effects: returns the pacman associated with this game
	public Sprite getPacman() {
		return pacman;
	}
}
