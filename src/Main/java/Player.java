package Main.java;

import Main.java.Game;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Player {
    int playerNumber;
    String name;
    Game game;
    ArrayList<Button> lista_botones_auxiliar;
    Button button;
    State playerState;

    public Player(String name, Game game, int playerNumber, ArrayList<Button> lista_botones_auxiliar) {
        this.name = name;
        this.game = game;
        this.playerNumber = playerNumber;
        if (playerNumber == 1) {
            this.playerState = State.CROSS;
        } else if (playerNumber == 2) {
            this.playerState = State.NOUGH;
        }
        this.lista_botones_auxiliar = lista_botones_auxiliar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public void play(Button button) {

        int x = Integer.parseInt(button.getId().substring(7, 8));
        int y = Integer.parseInt(button.getId().substring(8, 9));

        if (game.getTurno() == 1 && game.getTurno() == getPlayerNumber()) {
            if (game.isValidPlay(x, y)) {
                game.setPlayOnBoard(State.CROSS, x, y);
                button.setGraphic(new ImageView("Main/resources/cross-sign.png"));
                //button.setText(board[x][y].toString());
                button.setDisable(true);
                if (lista_botones_auxiliar.size() > 1) {
                    lista_botones_auxiliar.remove(button);
                }
            }
            if (game.isWinner()) {
                game.endGame(button);
                button.setText(game.endGame(button).toString());
            } else if (game.isBoardFull()){
                //Empate
                button.setText("EMPATE");
            }
            game.printBoard();
            //game.changeTurn();
        }
        if (game.getTurno() == 2 && game.getTurno() == getPlayerNumber()) {
            if (game.isValidPlay(x, y)) {
                game.setPlayOnBoard(State.NOUGH, x, y);
                button.setGraphic(new ImageView("Main/resources/circle-sign.png"));
                //button.setText(board[x][y].toString());
                button.setDisable(true);
                if (lista_botones_auxiliar.size() > 1) {
                    lista_botones_auxiliar.remove(button);
                }
            }
            if (game.isWinner()) {
                game.endGame(button);
                button.setText(game.endGame(button).toString());
            } else if (game.isBoardFull()){
                //Empate
                button.setText("EMPATE");
            }
            game.printBoard();
            //game.changeTurn();
        }
    }
}
