package ca.ubc.cpsc210.pacman.model;

import java.awt.Color;

public abstract class Sprite {

	Board board;
	int x_location;
	int y_location;
	private char direction = 'R';
	
//Fields:
	public int getX() {
		return x_location;
	}

	public int getY() {
		return y_location;
	}

	public char getDirection() {
		return direction;
	}

	public Board getBoard() {
		return board;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}
	
	public Sprite() {
		super();
	}

//Methods:
	public abstract Color getColor();

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
	

	public abstract void makeMove();
		


	public void setLocation(int x, int y) {
		x_location = x;
		y_location = y;
	}

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
	
	

}