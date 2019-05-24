public class Regles {
	private Cell [][] plateau;
	private int ligne = null;
	private int colonne = null;
	private Cell [] listeDeCoups = null;
	private int nbCoups = 0;
	private Cell coups;

	/* --------------------------------- CONSTRUCTEUR --------------------------------- */
	public regles(Cell[][] plateau)
	{
		this.plateau = plateau;
	}

	/* --------------------------------- REGLES --------------------------------- */ 
	//Règle 1
	public boolean regle1()
	{
		if ( this.nbCoups == 0)
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

	//listeDeCoups
	public Cell[] getListeDeCoups()
	{
		return this.listeDeCoups;
	}
	public void setListeDeCoups(Cell [] listeDeCoups)
	{
		this.listeDeCoups = listeDeCoups;
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