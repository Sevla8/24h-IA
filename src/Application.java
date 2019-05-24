public class Application {

	public static void main(String[] args) {
		Client.initialize();
		boolean first = Client.instance().isFirstPlayer();
		String mapString = Client.instance().recieveMap();
		Board board = new Board(mapString);
		AI ai = new AI(board);

		boolean latch = Client.instance().isFirstPlayer();

		while(true) {
			Client.State state = Client.instance().getNextState();
			if(state != null) {
				if(state.equals(Client.State.IS_MINE_TURN)) {

					Point point = ai.play();
					Client.instance().sendPoint(point.x, point.y);

				} else if(state.equals(Client.State.IS_OPPONENT_TURN)) {

					Point point = Client.instance().getOpponentPoint();
					ai.interpret(point);

				} else if(state.equals(Client.State.IS_ILLEGAL_OPPONENT_SHOT)) {
					
					ai.interpret(null);

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