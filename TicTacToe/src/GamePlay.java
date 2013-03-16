public class GamePlay {
	private static int GAME_MAP_DIM = 3;

	private static int Empty_FIELD = 0;

	private static int PLAYER_TURN_X = 1;
	private static int PLAYER_TURN_O = 2;

	private static int TIE = 3;
	private static int CONT = 4;

	private int[][] gameMap;
	private int currPlayerTurn;

	public GamePlay() {
		initiatGame();
	}

	private void initiatGame() {
		gameMap = new int[GAME_MAP_DIM][GAME_MAP_DIM];
		currPlayerTurn = PLAYER_TURN_X;
	}

	private boolean isEmpty() {
		for (int i = 0; i < GAME_MAP_DIM; i++) {
			for (int j = 0; j < GAME_MAP_DIM; j++) {
				if (gameMap[i][j] == Empty_FIELD) {
					return true;
				}
			}
		}
		return false;
	}

	private void switchPlayer() {
		if (currPlayerTurn == PLAYER_TURN_X) {
			currPlayerTurn = PLAYER_TURN_O;
		} else {
			currPlayerTurn = PLAYER_TURN_X;
		}
	}

	public int getCurrPlayerTurn() {
		return currPlayerTurn;
	}

	public int play(int x, int y) {
		if (gameMap[x][y] == Empty_FIELD) {
			gameMap[x][y] = currPlayerTurn;
			return updateGame(x, y);
		}
		return 0;

	}

	private int updateGame(int i, int j) {
		if (gameMap[i][j] == gameMap[(i + 1) % GAME_MAP_DIM][j]
				&& gameMap[i][j] == gameMap[(i + 2) % GAME_MAP_DIM][j]) {
			return currPlayerTurn;
		} else if (gameMap[i][j] == gameMap[i][(j + 1) % GAME_MAP_DIM]
				&& gameMap[i][j] == gameMap[i][(j + 2) % GAME_MAP_DIM]) {
			return currPlayerTurn;
		} else if (gameMap[i][j] == gameMap[(i + 1) % GAME_MAP_DIM][(j + 1)
				% GAME_MAP_DIM]
				&& gameMap[i][j] == gameMap[(i + 2) % GAME_MAP_DIM][(j + 2)
						% GAME_MAP_DIM]) {
			return currPlayerTurn;
		} else if (!isEmpty()) {
			return TIE;
		}
		switchPlayer();
		return CONT;
	}

	public static void main(String[] args) {

	}

}
