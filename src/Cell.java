// public class Cell {

// public static enum State {
// NOT_PLAYED, HIM_PLAYED, ME_PLAYED
// }

// private char c;
// private State state;

// private boolean borderNorth;
// private boolean borderWest;
// private boolean borderSouth;
// private boolean borderEast;
// private char name;

// private int x;
// private int y;

// public Cell(int x, int y) {
// this.c = 'M';
// this.state = State.NOT_PLAYED;
// this.x = x;
// this.y = y;
// }

// public Cell(char c, State state, int x, int y) {
// super(x,y);
// this.c = c;
// this.state = state;
// }

// public Cell clone() {
// return new Cell(this.c, this.state, this.x, this.y);
// }

// @Override
// public boolean equals(Object object) {
// if (object == null)
// return false;
// if (object.getClass() != this.getClass())
// return false;
// Cell cell = (Cell) object;
// if (this.c != cell.getValue())
// return false;
// if (this.state != cell.getState())
// return false;
// return true;
// }

// public void addBorder(String value) {
// if (value == "North") {
// this.borderNorth = true;
// } else if (value == "West") {
// this.borderWest = true;
// } else if (value == "South") {
// this.borderSouth = true;
// } else if (value == "East") {
// this.borderEast = true;
// }
// }

// @Override
// public String toString() {
// String string = new String("");
// string += "location : " + this + "\n";
// string += "c : " + this.c + "\n";
// string += "state : " + this.state + "\n";
// return string;
// }

// public char getValue() {
// return this.c;
// }

// public boolean getBorder(String s) {
// if (s == "North") {
// return this.borderNorth;
// } else if (s == "West") {
// return this.borderWest;
// } else if (s == "South") {
// return this.borderWest;
// } else if (s == "East") {
// return this.borderEast;
// } else {
// return false;
// }
// }

// public void setValue(char l) {
// this.c = l;
// }

// public State getState() {
// return this.state;
// }

// public int getX()
// {
// return this.x;
// }
// public int getY()
// {
// return this.y;
// }
// }