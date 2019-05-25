import java.awt.Point;
import java.util.Random;

public class Application {

	public static void main(String[] args) {
        Client.initialize();
		boolean first = Client.instance().isFirstPlayer();
		Board board = Client.instance().recieveMap();
		AI ai = new AI(board);

		boolean latch = Client.instance().isFirstPlayer();

		while(true) {
			Client.State state = Client.instance().getNextState();
			if(state != null) {
				if(state.equals(Client.State.IS_MINE_TURN)) {
                        /*Random r = new Random();
                        int x;
                        int y;
                        while (true){
                            x = r.nextInt(10);
                            y = r.nextInt(10);
                            if(ai.getRegles().regle2(board.getCells()[x][y])) break;
                        }*/
                        Cell celu = ai.jouerOuNon();
                        if (celu != null) {Client.instance().sendPoint(celu.getX(), celu.getY());}
                        else {System.out.println("Partie Terminée");}
				} else if(state.equals(Client.State.IS_OPPONENT_TURN)) {
                    System.out.println("Is opponent turn");
                    Point point = Client.instance().getOpponentPoint();
                    Cell cell= new Cell(point.x, point.y);
                    board.setLesDernierCoups(cell);
                    //board.setDernierCoup(board.getCells()[point.getX()][point.getY()]);
					//ai.interpret(point);

				} else if(state.equals(Client.State.IS_ILLEGAL_OPPONENT_SHOT)) {
                    System.out.println("Is illegal opponent shot");					
					//ai.interpret(null);

				} else if(state.equals(Client.State.IS_MINE_SHOT_ILLEGAL)) {
                    System.out.println("Is mine illegal shot");															
					//Do nothing
					System.err.println("Missed shot");
				} else if(state.equals(Client.State.IS_END_GAME)) {
					
					break;
				
				}
			}
		}
	}
}