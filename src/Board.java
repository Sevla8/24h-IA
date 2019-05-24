public class Board {

    public static int BOARD_X = 100;
    public static int BOARD_Y = 100;

    private Cell cells[][];

    public Board(){
        this.cells = new Cell[BOARD_X][BOARD_Y];
        for(int x = 0; x < BOARD_X; x++) {
            for(int y = 0; y < BOARD_Y; y++) {
                this.cells[x][y] = new Cell();
            }
        }
    }
    public Board(Cell cells[][]) {
        super();

        for(int x = 0; x < BOARD_X; x++) {
            for(int y = 0; y < BOARD_Y; y++) {
                this.cells[x][y] = cells[x][y].clone();
            }
        }
    }

    public Board clone() {
        return new Board(this.cells);
    }

    public Cell at(int x, int y) {
        return this.cells[x][y].clone();
    }

    public void put(int x, int y, Cell cell) {
        this.cells[x][y] = cell.clone();
    }
}