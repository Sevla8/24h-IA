public class Regles {
	private int ligne = null;
	private int colonne = null;
	private int nbCoups = 0;
	private Cell coups;
	Board board = null;

	/* --------------------------------- CONSTRUCTEUR --------------------------------- */
	public regles(Board board)
	{
		this.board = board;
	}

	/* --------------------------------- REGLES --------------------------------- */ 
	//Règle 1
	public boolean regle1()
	{
		Cell [][] cells = this.board.getCells();
		if ( this.nbCoups == 0 )
		{
			if (cells[this.coups.getX()][this.coups.getY()].getValue() != 'M' && cells[this.coups.getX()][this.coups.getY()].getValue() != 'F' 
				&& cells[this.coups.getX()][this.coups.getY()].getState() == Cell.State.NOT_PLAYED)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	//Règle 2
	public boolean regle2()
	{
		
	}

	/* --------------------------------- ACCESSEUR --------------------------------- */ 
	//ligne
	public int getLigne()
	{
		return this.ligne;
	}
	public void setLigne(int ligne)
	{
		this.ligne = ligne;
	}

	//colonne
	public int getColonne()
	{
		return this.colonne;
	}
	public void setColonne(int colonne)
	{
		this.colonne = colonne;
	}

	//Board
	public Board getBoard()
	{
		return this.board;
	}
	public void setBoard(Board board)
	{
		this.board = board;
	}

	//nbDeCoups
	public int getNbCoups()
	{
		return this.nbCoups;
	}
	public void setNbCoups()
	{
		this.nbCoups = nbCoups;
	}

}