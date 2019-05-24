import java.util.ArrayList;
import java.util.List;

public class Converter {
    private Cell[][] rowCase;

    public Converter(Cell[][] cas) {
        this.rowCase = cas;
    }

    public char[][] convert(int[][] entiers) {
        char lettre = 'a';
        char mer = 'M';
        char foret = 'F';
        int size = entiers[0].length;
        char[][] charac = new char[size][size];
        List<Cell> liste = new ArrayList<Cell>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (entiers[i][j] >= 32) {
                    if (entiers[i][j] >= 64) {
                        this.rowCase[i][j].setValue(mer);
                    } else {
                        this.rowCase[i][j].setValue(foret);
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

                if (i != 0 && !this.rowCase[i][j].getBorder("North")) {
                    this.rowCase[i][j].setValue(this.rowCase[i - 1][j].getValue());
                    if (!liste.isEmpty()) {
                        while (!liste.isEmpty()) {
                            Cell tmpCell = liste.getFirst();
                            tmpCell.setValue(this.rowCase[i - 1][j].getValue());
                        }
                    }
                } else if (i != 0 && !this.rowCase[i][j].getBorder("West")) {
                    this.rowCase[i][j].setValue(this.rowCase[i][j - 1].getValue());
                    if (!liste.isEmpty()) {
                        while (!liste.isEmpty()) {
                            Cell tmpCell = liste.getFirst();
                            tmpCell.setValue(this.rowCase[i][j - 1].getValue());
                        }
                    }
                } else if (this.rowCase[i][j].getBorder("East")) {

                    liste.add(this.rowCase[i][j]);
                } else {
                    this.rowCase[i][j].setValue(lettre++);
                }
                charac[i][j] = this.rowCase[i][j].getValue();
            }

        }

        return charac;
    }
}