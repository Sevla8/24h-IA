public class Board {

    public static int BOARD_X = 10;
    public static int BOARD_Y = 10;

    private Cell dernierCoup;
    private Cell avantDernierCoup;

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

    public Cell getDernierCoup()
    {
        return this.dernierCoup;
    }
    public void setDernierCoup(Cell c)
    {
        this.dernierCoup = c;
    }
    public Cell getAvantDernierCoup()
    {
        return this.avantDernierCoup;
    }
    public void setAvantDernierCoup(Cell c)
    {
        this.avantDernierCoup = c;
    }

    public Cell[][] getCells()
    {
        return this.cells;
    }
}