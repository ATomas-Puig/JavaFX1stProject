package Controllers;

import Main.java.CPU;
import Main.java.Game;
import Main.java.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class TicTacToe implements Initializable {

    //Botones a inicializar
    @FXML
    Button button_00, button_01, button_02, button_10, button_11, button_12, button_20, button_21, button_22, button_start;
    ArrayList<Button> lista_botones;
    ArrayList<Button> lista_botones_auxiliar;

    @FXML
    RadioButton check_1, check_2, check_3;
    List<RadioButton> lista_radio_buttons;
    private int numTiradas;

    Game game = new Game();

    //Jugadores
    Player p1 = new Player("Antonio", game, 1, lista_botones_auxiliar);
    Player p2 = new Player("José", game, 2, lista_botones_auxiliar);
    CPU cpu1 = new CPU(game, 1, lista_botones_auxiliar);
    CPU cpu2 = new CPU(game, 2, lista_botones_auxiliar);

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lista_botones = new ArrayList<>(Arrays.asList(button_00, button_01, button_02, button_10, button_11, button_12, button_20, button_21, button_22));
        lista_botones_auxiliar = new ArrayList<>(lista_botones);
        lista_radio_buttons = Arrays.asList(check_1, check_2, check_3);
        ToggleGroup group1 = new ToggleGroup();
        for (RadioButton button : lista_radio_buttons) {
            button.setToggleGroup(group1);
        }

        p1 = new Player("Antonio", game, 1, lista_botones_auxiliar);
        p2 = new Player("José", game, 2, lista_botones_auxiliar);
        cpu1 = new CPU(game, 1, lista_botones_auxiliar);
        cpu2 = new CPU(game, 2, lista_botones_auxiliar);
        //disableButtons();
    }

    public void disableButtons() {
        for (Button disabledButton : lista_botones) {
            disabledButton.setDisable(true);
        }
    }

    public void disableMenuButtons() {
        for (RadioButton radioButton : lista_radio_buttons) {
            radioButton.setDisable(true);
        }
        button_start.setDisable(true);
    }

    public void enableMenuButtons() {
        for (RadioButton radioButton : lista_radio_buttons) {
            radioButton.setDisable(false);
        }
        button_start.setDisable(false);
    }

    public void enableButtons() {
        for (Button enabledButton : lista_botones) {
            enabledButton.setGraphic(null);
            enabledButton.setText(null);
            enabledButton.setDisable(false);
        }
    }

    //Métodos de click para botones
    public int onStartButtonClicked(MouseEvent mouseEvent) {
        
        Button startButton = (Button) mouseEvent.getSource();
        game.initializeBoard();
        //Comprobar el modo de juego

        if (check_1.isSelected()) {
            //game.initializeBoard();
            disableMenuButtons();
            CPU cpu1 = new CPU(game, 1, lista_botones_auxiliar);
            CPU cpu2 = new CPU(game, 2, lista_botones_auxiliar);
            while (!game.isBoardFull()) {
                cpu1.play();
                cpu2.play();
            }
        } else if (check_2.isSelected()) {
            //game.initializeBoard();
            disableMenuButtons();
            CPU cpu = new CPU(game, 1, lista_botones_auxiliar);
            Player player = new Player("Antoñico", game, 2, lista_botones_auxiliar);
            //while (!game.isBoardFull()) {
            cpu.play();
            //button_00.setOnMouseClicked(mouseEvent1 -> player.play(button_00));
            //player.play(button);
        }
        //} else if (check_3.isSelected()) {
        //   enableButtons();
        //   disableMenuButtons();
        //}
        //game.initializeBoard();
        return gameSelected;
    }


    int gameSelected = 0;

    public int gameSelected() {
        if (check_1.isSelected()) gameSelected = 1;
        if (check_2.isSelected()) gameSelected = 2;
        if (check_3.isSelected()) gameSelected = 3;

        return gameSelected;
    }


    public void onMouseClicked(MouseEvent mouseEvent) {


        gameSelected = gameSelected();
        mouseEvent.consume();

        Button button = (Button) mouseEvent.getSource();

        String coordenate = (button.getId().toString().charAt(7) + " " + button.getId().toString().charAt(8));

        //Comprobar modo de juego.
        if (gameSelected == 1) {

            //game.initializeBoard();
            disableMenuButtons();

            while (!game.isBoardFull()) {

                cpu1.play();
                cpu2.play();
            }

        } else if (gameSelected == 2) {
            //game.initializeBoard();
            disableMenuButtons();

            //while (!game.isBoardFull()) {
            cpu1.play();
            p2.play(button);
            //}
        } else if (gameSelected == 3) {
            //game.initializeBoard();

            //while (!game.isBoardFull()) {

            p1.play(button);
            p2.play(button);
            //}
            //enableButtons();
            //disableMenuButtons();
        }
        //game.initializeBoard();
        game.changeTurn();
    }

        /*if (game.getTurno() == 1) {
            p1.play();
            System.out.println(game.getTurno());
        } else if (game.getTurno() == 2) {
            p2.play();
            System.out.println(game.getTurno());
        }/*
        /*int x = Integer.parseInt(button.getId().toString().substring(7, 8));
        int y = Integer.parseInt(button.getId().toString().substring(8, 9));

        //button.setText(GridPane.getColumnIndex());
        switch (game.getTurno()) {
            case 1:
                if (game.isValidPlay(x, y)) {
                    game.setPlayOnBoard(State.CROSS, x, y);
                    button.setGraphic(new ImageView("Main/resources/cross-sign.png"));
                    //button.setText(board[x][y].toString());
                    button.setDisable(true);
                }
                if (game.isWinner()) {
                    button.setText("GANADOR");
                }
                game.printBoard();
                game.changeTurn();
                break;
            case 2:
                if (game.isValidPlay(x, y)) {
                    game.setPlayOnBoard(State.NOUGH, x, y);
                    button.setGraphic(new ImageView("Main/resources/circle-sign.png"));
                    //button.setText(board[x][y].toString());
                    button.setDisable(true);
                }
                if (game.isWinner()) {
                    button.setText("GANADOR");
                }
                game.printBoard();
                game.changeTurn();
                break;
        }*/


    void player() {

    }
}
