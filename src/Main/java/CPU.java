package Main.java;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CPU {
    int cpuPlayerNumber;
    Game game;
    ArrayList<Button> lista_botones_auxiliar;
    Button button;
    State cpuState;

    public CPU(Game game, int cpuPlayerNumber, ArrayList<Button> lista_botones_auxiliar) {
        this.game = game;
        this.cpuPlayerNumber = cpuPlayerNumber;
        this.lista_botones_auxiliar = lista_botones_auxiliar;
    }

    public int getCpuPlayerNumber() {
        return cpuPlayerNumber;
    }

    public void setCpuPlayerNumber(int cpuPlayerNumber) {
        this.cpuPlayerNumber = cpuPlayerNumber;
    }

    public void play() {
        int min = 0;
        int max = 8;

        button = lista_botones_auxiliar.get(ThreadLocalRandom.current().nextInt(min, lista_botones_auxiliar.size()));

        int x = Integer.parseInt(button.getId().toString().substring(7, 8));
        int y = Integer.parseInt(button.getId().toString().substring(8, 9));


        if (game.getTurno() == 1 && game.getTurno() == getCpuPlayerNumber()) {
            if (game.isValidPlay(x, y)) {
                cpuState = State.CROSS;
                game.setPlayOnBoard(cpuState, x, y);
                button.setGraphic(new ImageView("Main/resources/cross-sign.png"));
                button.setDisable(true);
                if (lista_botones_auxiliar.size() > 1) {
                    lista_botones_auxiliar.remove(button);
                }
                if (game.isWinner()) {
                    game.endGame(button);
                    button.setText(game.endGame(button).toString());
                } else if (game.isBoardFull()) {
                    //Empate
                    button.setText("EMPATE");
                }
                game.printBoard();
            }
        }

        if (game.getTurno() == 2 && game.getTurno() == getCpuPlayerNumber()) {
            if (game.isValidPlay(x, y)) {
                cpuState = State.NOUGH;
                game.setPlayOnBoard(cpuState, x, y);
                button.setGraphic(new ImageView("Main/resources/circle-sign.png"));
                button.setDisable(true);
                if (lista_botones_auxiliar.size() > 1) {
                    lista_botones_auxiliar.remove(button);
                }
                if (game.isWinner()) {
                    game.endGame(button);
                    button.setText(game.endGame(button).toString());
                } else if (game.isBoardFull()) {
                    //Empate
                    button.setText("EMPATE");
                }
                game.printBoard();
            }
        }


        /*switch (cpuPlayerNumber) {
            case 1:
                tempState = State.CROSS;
                game.setPlayOnBoard(tempState, x, y);
                game.printBoard();
                button.setGraphic(new ImageView("Main/resources/cross-sign.png"));
                if (game.isWinner()) {
                    game.endGame(button);
                } else if (game.isBoardFull()) {
                    //empate
                }
                if (lista_botones_auxiliar.size() > 1) {
                    lista_botones_auxiliar.remove(button);
                }
                //game.changeTurn();
                break;
            case 2:
                tempState = State.NOUGH;
                game.setPlayOnBoard(tempState, x, y);
                game.printBoard();
                button.setGraphic(new ImageView("Main/resources/circle-sign.png"));
                if (game.isWinner()) {
                    game.endGame(button);
                } else if (game.isBoardFull()) {
                    //empate
                }
                if (lista_botones_auxiliar.size() > 1) {
                    lista_botones_auxiliar.remove(button);
                }
                //game.changeTurn();
                break;
        }

    }
         */
    }
}

