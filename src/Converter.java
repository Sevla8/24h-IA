
public class Converter {
    private Cell[][] rowCase;

    public Converter(Cell[][] cas) {
        this.rowCase = cas;
    }

    public char[][] convert(int[][] entiers) {
        char lettre = 'a';
        char mer = 'M';
        int size = entiers.length;
        char[][] charac = new tab[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (entiers[i][j] & 0x8) {
                    this.rowCase[i][j].addBorder("East");
                    entiers[i][j] -= 8;
                }
                if (entiers[i][j] & 0x4) {
                    this.rowCase[i][j].addBorder("South");
                    entiers[i][j] -= 4;
                }
                if (entiers[i][j] & 0x2) {
                    this.rowCase[i][j].addBorder("West");
                    entiers[i][j] -= 2;
                }
                if (entiers[i][j] & 0x1) {
                    this.rowCase[i][j].addBorder("North");
                    entiers[i][j] -= 1;
                }

            }
        }
        int j = 0;
        for (int i = 0; i < size; i++) {
            this.rowCase[i][0].setRegionName(lettre);

            for (j = 0; j < size; j++) {
                if (j != 0 && !this.rowCase[i][j].getBorder("Top")) {
                    this.rowCase[i][j].setRegionName(this.rowCase[i][j].getRegionName());
                }
            }
        }

        return charac;
    }
}