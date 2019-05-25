import java.awt.Point;

public class Application {

	public static void main(String[] args) {
		Client.initialize();
		System.out.println("test");
		boolean first = Client.instance().isFirstPlayer();
		Board board = Client.instance().recieveMap();
		AI ai = new AI(board);

		boolean latch = Client.instance().isFirstPlayer();

		while(true) {
			Client.State state = Client.instance().getNextState();
			if(state != null) {
				if(state.equals(Client.State.IS_MINE_TURN)) {

					//Point point = ai.play();
					Point point = new Point(2, 4);
					Client.instance().sendPoint(point.x, point.y);

				} else if(state.equals(Client.State.IS_OPPONENT_TURN)) {

					Point point = Client.instance().getOpponentPoint();
					//ai.interpret(point);

				} else if(state.equals(Client.State.IS_ILLEGAL_OPPONENT_SHOT)) {
					
					//ai.interpret(null);

				} else if(state.equals(Client.State.IS_MINE_SHOT_ILLEGAL)) {
					
					//Do nothing
					System.err.println("Missed shot");

				} else if(state.equals(Client.State.IS_END_GAME)) {
					
					break;
				
				}
			}
		}
	}
}