public class Board {

    public static int BOARD_X = 10;
    public static int BOARD_Y = 10;

    private Cell dernierCoup;
    private Cell avantDernierCoup;

    private Cell cells[][];

    public Board(String rawData, boolean binaryMode){
        this.cells = new Cell[BOARD_X][BOARD_Y];

        if(binaryMode) {
            //TODO
            
        } else {
            String[] splits = rawData.split("MAP=")[1].split("|");
            for(int y = 0; y < splits.length; y++) {
                String[] coords = splits[y].split(":");
                for(int x = 0; x < coords.length; x++) {
                    this.cells[x][y] = new Cell(coords[x].charAt(0), Cell.State.NOT_PLAYED, x, y);
                }
            }
        }
    }
    public Board(Cell cells[][]) {
        
        this.cells = new Cell[BOARD_X][BOARD_Y];
        for(int x = 0; x < BOARD_X; x++) {
            for(int y = 0; y < BOARD_Y; y++) {
                this.cells[x][y] = new Cell(x, y);
            }
        }

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