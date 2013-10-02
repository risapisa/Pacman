package ca.ubc.cpsc210.pacman.model;

import java.awt.Color;

public class TrackerMonster extends Sprite {

	Board board;
	int x_location;
	int y_location;
	private char direction = 'R';
	
	// Requires: b is a valid board
	// Modifies: this
	// Effects:  remembers b
	public TrackerMonster(Board b) {
		board = b;
	}

	// Requires: b is a valid board and the position (x,y) is not a wall on b
	// Modifies: this
	// Effects:  remembers b, x and y
	public TrackerMonster(Board b, int x, int y) {
		this(b);
		x_location = x;
		y_location = y;
	}

	// Requires: nothing
	// Modifies: nothing
	// Effects:  returns the colour gray for a tracker monster
	@Override
	public Color getColor() {
		return Color.gray;
	}
	
	// Requires: nothing
	// Modifies: this, board
	// Effects:  moves the tracker monster in the direction of pacman if possible
	@Override
	public void makeMove() {
		char horiz_direction = getHorizontalDirectionToPacman();
		char vert_direction = getVerticalDirectionToPacman();
		
		int horiz_distance = Math.abs(getX() - board.getPacman().getX());
		int vert_distance  = Math.abs(getY() - board.getPacman().getY());
		
		setDirection(horiz_direction);
		boolean canMoveHoriz = canMakeMove();
		
		setDirection(vert_direction);
		boolean canMoveVert = canMakeMove();
		
		if (horiz_distance > vert_distance && canMoveHoriz) {
			setDirection(horiz_direction);
		} else if (vert_distance > horiz_distance && canMoveVert) {
			setDirection(vert_direction);
		} else if (canMoveHoriz) {
			setDirection(horiz_direction);
		} else if (canMoveVert) {
			setDirection(vert_direction);
		} else {
			// Can't move in the direction of pacman, so choose a random direction to keep moving.
			do {
				double random = Math.random();
				if (random < 0.25) setDirection('L');
				else if (random < 0.5) setDirection('U');
				else if (random < 0.75) setDirection('R');
				else setDirection('D');
			} while (!canMakeMove());
		}
		
		moveInCurrentDirection();
	}

	// Requires: nothing
	// Modifies: nothing
	// Effects:  returns the vertical direction to pacman on the current board
	private char getVerticalDirectionToPacman() {
		Sprite pacman = board.getPacman();
		int dy = y_location - pacman.getY();

		/* [TASK M2: This used to be dy < 0 ] */
		if (dy > 0) {
			return 'U';
		} else {
			return 'D';
		}
	}

	// Requires: nothing
	// Modifies: nothing
	// Effects:  returns the horizontal direction to pacman on the current board
	private char getHorizontalDirectionToPacman() {
		Sprite pacman = board.getPacman();
		int dx = x_location - pacman.getX();

		/* [TASK M2: This used to be dx < 0 ] */
		if (dx > 0) {
			return 'L';
		} else {
			return 'R';
		}
	}


	// Requires: position (x,y) is a valid position in the remembered board
	// Modifies: this
	// Effects:  remembers new position (x,y) 

	
	// Requires: That this sprite can move to the next square in its current direction
	// Modifies: this, board
	// Effects:  this location is updated based on its current heading, and board is updated to reflect the move
	@Override
	public void moveInCurrentDirection() {
		int new_x = x_location;
		int new_y = y_location;
		
		switch (getDirection()) {
		case 'S': break;
		case 'U':
			new_y = new_y - 1; break;
		case 'D':
			new_y = new_y + 1; break;
		case 'L':
			new_x = new_x - 1; break;
		case 'R':
			new_x = new_x + 1; break;
		default:
			throw new Error("Unknown direction: " + getDirection());
		}
		
		if (board.canMoveTo(new_x, new_y)) {
			board.moveTo(this, new_x, new_y);
		}
	}

	// Requires: nothing
	// Modifies: nothing
	// Effects:  returns true if this sprite can move to the next square in its current heading
		

	// Requires: nothing
	// Modifies: nothing
	// Effects:  returns the x position of this sprite
	public int getX() {
		return x_location;
	}

	// Requires: nothing
	// Modifies: nothing 
	// Effects:  returns the y position of this sprite
	public int getY() {
		return y_location;
	}

	// Requires: nothing
	// Modifies: nothing
	// Effects:  returns the current heading of this sprite
	public char getDirection() {
		return direction;
	}

	// Requires: nothing
	// Modifies: nothing
	// Effects:  returns the board that this sprite is active on
	public Board getBoard() {
		return board;
	}

	// Requires: c is a valid direction (U, D, L, R)
	// Modifies: this
	// Effects: changes the direction 
	public void setDirection(char direction) {
		this.direction = direction;
	}
}
