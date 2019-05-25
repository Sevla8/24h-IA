public class Regles {
	private int nbCoups = 0;
	Board board = null;

	/* --------------------------------- CONSTRUCTEUR --------------------------------- */
	public Regles(Board board)
	{
		this.board = board;
	}

	/* --------------------------------- REGLES --------------------------------- */ 
	//Règle 0
	public boolean regle0(Cell c)
	{
		Cell [][] cells = this.board.getCells();
		if (cells[c.getX()][c.getY()].getValue() != 'M' && cells[c.getX()][c.getY()].getValue() != 'F' 
			&& cells[c.getX()][c.getY()].getState() == Cell.State.NOT_PLAYED)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//Règle 1
	public boolean regle1(Cell c)
	{
		if ( this.nbCoups == 0 )
		{
			return regle0(c);
		}
		else
		{
			return false;
		}
	}

	//Règle 2
	public boolean regle2(Cell c)
	{
        if (this.board.getDernierCoup() != null )
        {
            if ( c.getX() == this.board.getDernierCoup().getX() || c.getY() == this.board.getDernierCoup().getY() )
            {
                return regle0(c);
            }
            else
            {
                return false;
            }
        }
        else{
            return true;
        }
		
	}

	//Règle 3
	public boolean regle3(Cell c)
	{
        if (this.board.getDernierCoup() != null )
        {
            if ( c.getValue() != this.board.getDernierCoup().getValue() )
            {
                return regle0(c);
            }
            else
            {
                return false;
            }
        }
        else<{
            return true;
        }
	}

	//Règle 4
	public boolean regle4(Cell c)
	{
        if ( this.board.getAvantDernierCoup() != null)
        {
            if ( c.getValue() != this.board.getAvantDernierCoup().getValue() )
            {
                return regle0(c);
            }
            else
            {
                return false;
            }
        }
        else
        {
            return true;
        }
	}

	//Règle 5
	public boolean regle5(Cell c)
	{
		if ( this.regle1(c) && this.regle2(c) && this.regle3(c) && this.regle4(c) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//Règle 6
	public boolean regle6()
	{
		Cell [][] cells = this.board.getCells();
		Cell c = null;

		for ( int i = 0 ; i < cells.length; i++ )
		{
			for ( int j = 0 ; j < cells[i].length ; j++ )
			{
				c = cells[i][j];
				if (this.regle2(c) && this.regle3(c) && this.regle4(c))
				{
					return true;
				}
			}
		}
		return false;
	}

	//Fin de Partie ?
	public boolean partieContinue()
	{
		if ( this.nbCoups < 56 && regle6() )
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	/* --------------------------------- ACCESSEUR --------------------------------- */ 
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
	public void setNbCoups(int nbCoups)
	{
		this.nbCoups = nbCoups;
	}

}