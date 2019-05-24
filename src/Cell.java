public class Cell {

    public static enum State {
        NOT_PLAYED,
        HIM_PLAYED,
        ME_PLAYED
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

    public char getValue() {
        return this.c;
    }
    public State getState() {
        return this.state;
    }
}