import java.awt.Point;
import java.util.*;

public class AI {
    private Board board;



    public AI(Board initialBoard) {
        this.board = initialBoard;
    }

    // public Point play() {
        
    // }

    // public void interpret(Point himPlay) {
    //     if (himPlay != null) {
    // 		this.board.put((int)himPlay.getX(), (int)himPlay.getY(), new Cell());

    //     }
    //     else {

    //     }
    // }

    public HashMap<Character, List<Cell>> getMap() {
		HashMap<Character, List<Cell>> hashMap = new HashMap<Character, List<Cell>>();
		for (int i = 0; i < this.board.getCells().length; i += 1) {
			for (int j = 0; j < this.board.getCells()[i].length; j += 1) {

				if (hashMap.get(this.board.getCells()[i][j].getValue()) != null) {
					List<Cell> list = new ArrayList<Cell>(hashMap.get(this.board.getCells()[i][j]));
					list.add(this.board.getCells()[i][j]);
					hashMap.put(this.board.getCells()[i][j].getValue(), list);
				}
				else {
    				List<Cell> list = new ArrayList<Cell>();
    				list.add(this.board.getCells()[i][j]);
					hashMap.put(this.board.getCells()[i][j].getValue(), list);
				}
			}
		}
		return hashMap;
	}

	public Board getBoard() {
		return this.board;
	}
}
