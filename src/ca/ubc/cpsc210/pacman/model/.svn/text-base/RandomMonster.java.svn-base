package ca.ubc.cpsc210.pacman.model;

import java.awt.Color;


public class RandomMonster extends Sprite {

	
	// Requires: b is a valid board
	// Modifies: this
	// Effects:  remembers b
	public RandomMonster(Board b) {
		board = b;
	}

	// Requires: b is a valid board and the position (x,y) is not a wall on b
	// Modifies: this
	// Effects:  remembers b, x and y
	public RandomMonster(Board b, int x, int y) {
		this(b);
		x_location = x;
		y_location = y;
	}

	@Override
	public Color getColor() {
		return Color.CYAN;
	}

/*	@Override
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
*/
	@Override
	public void makeMove() {
		do {
			double random = Math.random();
			if (random < 0.25) setDirection('L');
			else if (random < 0.5) setDirection('U');
			else if (random < 0.75) setDirection('R');
			else setDirection('D');
		} while (!canMakeMove());
		
		moveInCurrentDirection();
	}

/*	@Override
//	public void setLocation(int x, int y) {
//		x_location = x;
//		y_location = y;
	}
*/
/*	@Override
	public boolean canMakeMove() {
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
		
		return board.canMoveTo(new_x, new_y);
	}
	*/
}
