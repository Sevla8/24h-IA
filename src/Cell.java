public class Cell {
    private boolean borderNorth;
    private boolean borderWest;
    private boolean borderSouth;
    private boolean borderEast;
    private char name;

    public static enum State {
        NOT_PLAYED, HIM_PLAYED, ME_PLAYED
    }

    private char c;
    private State state;

    public Cell() {
        this.c = 'M';
        this.state = State.NOT_PLAYED;
    }

    public Cell(char c, State state) {
        this.c = c;
        this.state = state;
    }

    public Cell clone() {
        return new Cell(this.c, this.state);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (object.getClass() != this.getClass())
            return false;
        Cell cell = (Cell) object;
        if (this.c != cell.getValue())
            return false;
        if (this.state != cell.getState())
            return false;
        return true;
    }

    public void addBorder(String value) {
        if (value == "North") {
            this.borderNorth = true;
        } else if (value == "West") {
            this.borderWest = true;
        } else if (value == "South") {
            this.borderSouth = true;
        }else if(value == "")
    }

    @Override
    public String toString() {
        String string = new String("");
        string += "location : " + this + "\n";
        string += "c : " + this.c + "\n";
        string += "state : " + this.state + "\n";
        return string;
    }

    public char getValue() {
        return this.c;
    }

    public State getState() {
        return this.state;
    }
}