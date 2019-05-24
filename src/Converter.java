
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
                if (entiers[i][j] >= 32) {
                    if (entiers[i][j] >= 64) {
                        this.rowCase[i][j].setValue('M');
                    } else {
                        this.rowCase[i][j].setValue('F');
                    }
                } else {
                    if ((entiers[i][j] & 0x8) == 0x8) {
                        this.rowCase[i][j].addBorder("East");
                        entiers[i][j] -= 8;
                    }
                    if ((entiers[i][j] & 0x4) == 0x4) {
                        this.rowCase[i][j].addBorder("South");
                        entiers[i][j] -= 4;
                    }
                    if ((entiers[i][j] & 0x2) == 0x2) {
                        this.rowCase[i][j].addBorder("West");
                        entiers[i][j] -= 2;
                    }
                    if ((entiers[i][j] & 0x1) == 0x1) {
                        this.rowCase[i][j].addBorder("North");
                        entiers[i][j] -= 1;
                    }
                }
            }
        }
        int j = 0;
        for (int i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                if (j != 0 && !this.rowCase[i][j].getBorder("Top")) {
                    this.rowCase[i][j].setValue(this.rowCase[i][j].getValue());
                }
            }
        }

        return charac;
    }
}