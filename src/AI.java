import java.awt.Point;
import java.util.*;

public class AI {
	private Board board;
	private Regles regle;

	public AI(Board initialBoard) {
		this.board = initialBoard;
		this.regle = new Regles(initialBoard);
	}

	// public Point play() {

	// }

	// public void interpret(Point himPlay) {
	// if (himPlay != null) {
	// this.board.put((int)himPlay.getX(), (int)himPlay.getY(), new Cell());

	// }
	// else {

	// }
	// }

	public boolean moiDedant(Cell c) {
		List<Cell> list = this.getMap().get(Character.valueOf(c.getValue()));
		for (Cell cell : list) {
			if (cell.getState() == Cell.State.ME_PLAYED) {
				return true;
			}
		}
		return false;
	}

	public boolean luiDedant(Cell c) {
		List<Cell> list = this.getMap().get(Character.valueOf(c.getValue()));
		for (Cell cell : list) {
			if (cell.getState() == Cell.State.HIM_PLAYED) {
				return true;
			}
		}
		return false;
	}

	public HashMap<Character, List<Cell>> getMap() {
		HashMap<Character, List<Cell>> hashMap = new HashMap<Character, List<Cell>>();
		for (int i = 0; i < this.board.getCells().length; i += 1) {
			for (int j = 0; j < this.board.getCells()[i].length; j += 1) {

				if (hashMap.get(this.board.getCells()[i][j].getValue()) != null) {
					List<Cell> list = new ArrayList<Cell>(hashMap.get(this.board.getCells()[i][j]));
					list.add(this.board.getCells()[i][j]);
					hashMap.put(this.board.getCells()[i][j].getValue(), list);
				} else {
					List<Cell> list = new ArrayList<Cell>();
					list.add(this.board.getCells()[i][j]);
					hashMap.put(this.board.getCells()[i][j].getValue(), list);
				}
			}
		}
		return hashMap;
	}

	public List<Cell> possibylities() {
		int x = this.board.getDernierCoup().getX();
		int y = this.board.getDernierCoup().getY();

		List<Cell> list = new LinkedList<Cell>();

		for (int i = 0; i < this.board.getCells().length; i += 1) {
			if (this.regle.regle5(this.board.getCells()[i][y])) {
				list.add(this.board.getCells()[i][y]);
			}
		}
		for (int i = 0; i < this.board.getCells().length; i += 1) {
			if (this.regle.regle5(this.board.getCells()[x][i])) {
				list.add(this.board.getCells()[x][i]);
			}
		}
		return list;
	}

	/*
	 * public Cell sortList(List<Cell> list) { int max = 0; Cell tmp = null; for
	 * (Cell cell : list) { if
	 * (this.getMap().get(Character.valueOf(cell.getValue())).size() > max) { tmp =
	 * cell; max = this.getMap().get(Character.valueOf(cell.getValue())).size(); } }
	 * return tmp; }
	 */

	public Cell jouerList(List<Cell> list) {
		int max_lui = 0;
		int max_moi = 0;
		Cell lui = null;
		Cell moi = null;

		int max_tmp = 0;
		Cell tmp = null;

		for (Cell cell : list) {
			// Le plus grand personne dedant
			if (!this.moiDedant(cell) && !this.luiDedant(cell)
					&& this.getMap().get(Character.valueOf(cell.getValue())).size() > max_moi) {
				moi = cell;
				max_moi = this.getMap().get(Character.valueOf(cell.getValue())).size();
			}
			// Le plus grand lui seul dedant
			if (!this.moiDedant(cell) && this.luiDedant(cell)
					&& this.getMap().get(Character.valueOf(cell.getValue())).size() > max_lui) {
				lui = cell;
				max_lui = this.getMap().get(Character.valueOf(cell.getValue())).size();
			}
			// Le plus grand tout court
			if (this.getMap().get(Character.valueOf(cell.getValue())).size() > max_tmp) {
				tmp = cell;
				max_tmp = this.getMap().get(Character.valueOf(cell.getValue())).size();
			}
		}

		if (lui == null && moi == null) {
			return tmp;
		} else {
			if (moi == null) {
				return lui;
			} else if (lui == null) {
				return moi;
			} else if (max_moi > max_lui) {
				return moi;
			} else {
				return lui;
			}
		}
	}

	public Cell jouerOuNon() {
		if (this.regle.partieContinue()) {
			this.regle.setNbCoups(this.regle.getNbCoups() + 1);
			return this.jouerList(this.possibylities());
		} else {
			return null;
		}
	}

	public Board getBoard() {
		return this.board;
	}
}
