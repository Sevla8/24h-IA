import java.awt.Point;
import java.util.*;

public class AI {
    private Board board;

    public AI(Board initialBoard) {
        this.board = initialBoard;
    }

    public Point play() {
        
    }

    // public void interpret(Point himPlay) {
    //     if (himPlay != null)
    // }

    public HashMap<Character, Integer> getSizeParcelle(char[][] cells) {
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for (int i = 0; i < cells.length; i += 1) {
			for (int j = 0; j < cells.length; j += 1) {
				if (hashmap.get(cells[i][j]) != null)
					hashmap.put(cells[i][j], hashmap.get(cells[i][j]) + 1);
				else 
					hashmap.put(cells[i][j], 1);
			}
		}
		return hashmap;
	}

	public HashMap<Cell, Integer> count(HashMap<Character, Integer> sizeParcelle) {
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();

		for (int i = 0; i < Board.BOARD_X; i += 1) {
			for (int j = 0; j < Board.BOARD_Y; j += 1) {
				if (hashMap.get(this.board.getCells()[i][j]) != null)
					hashMap.put(this.board.getCells()[i][j], sizeParcelle.get(this.board.getCells()[i][j].getValue()));
				else 
					hashMap.put(this.board.getCells()[i][j], 1);
			}
		}

		for (Map.Entry<Byte, Integer> entry : hashMap.entrySet()) {
			list.sortedAdd(new Node (entry.getKey(), entry.getValue(), null, null));
		}

		return list;
	}

	public Board getBoard() {
		return this.board;
	}
}
