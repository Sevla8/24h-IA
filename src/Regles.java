public class Regles {
	private Cell [][] plateau;
	private int ligne = null;
	private int colonne = null;
	private int nbCoups = 0;
	private Cell coups;
	Board board =null;

	/* --------------------------------- CONSTRUCTEUR --------------------------------- */
	public regles(Board board)
	{
		this.board = board;
	}

	/* --------------------------------- REGLES --------------------------------- */ 
	//Règle 1
	public boolean regle1()
	{
		if ( this.nbCoups == 0 )
		{
			if (this.plateau[this.coups.getX()][this.coups.getY()].getValue() != 'M' && this.plateau[this.coups.getX()][this.coups.getY()].getValue() != 'F' 
				&& this.plateau[this.coups.getX()][this.coups.getY()].getState() == Cell.State.NOT_PLAYED)
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
	//plateau
	public Cell[][] getPlateau()
	{
		return this.plateau;
	}
	public void setPlateau(Cell[][] plateau)
	{
		this.plateau = plateau;
	}

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