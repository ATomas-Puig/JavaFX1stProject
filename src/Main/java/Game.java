package Main.java;

import javafx.scene.control.Button;

public class Game {
    private State[][] board;
    private int turno;
    private int numTiradas;

    public Game() {
        this.board = new State[3][3];
        initializeBoard();
        numTiradas = 0;
        turno = 1;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getNumTiradas() {
        return numTiradas;
    }

    public void setNumTiradas(int numTiradas) {
        this.numTiradas = numTiradas;
    }

    //Inicializar tablero
    public void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = State.EMPTY;
            }
        }
        numTiradas = 0;
    }

    //Cambiar el jugador
    public void changeTurn() {
        if (turno == 1) {
            turno = 2;
        } else if (turno == 2) {
            turno = 1;
        }
        numTiradas++;
    }

    //Controlar ganador
    //Probar de implementar tres fors (filas, columnas y diagonales)

    public boolean isRowWinner() {
        boolean winner;
        State firstRowState;
        for (int x = 0; x < 3; x++) {
            winner = true;
            firstRowState = board[x][0];
            if (firstRowState != State.EMPTY) {
                for (int y = 1; y < 3; y++) {
                    if (firstRowState != board[x][y]) {
                        winner = false;
                        break;
                    }
                }
                if (winner) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isColumnWinner() {
        boolean winner;
        State firstColumnState;
        for (int y = 0; y < 3; y++) {
            winner = true;
            firstColumnState = board[0][y];
            if (firstColumnState != State.EMPTY) {
                for (int x = 1; x < 3; x++) {
                    if (firstColumnState != board[x][y]) {
                        winner = false;
                        break;
                    }
                }
                if (winner) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isDiagonalWinner() {
        boolean winner = false;
        State firstDiagonalState;

        //Diagonal
        firstDiagonalState = board[0][0];
        if (firstDiagonalState != State.EMPTY) {
            winner = true;
            for (int x = 1; x < 3; x++) {
                if (firstDiagonalState != board[x][x]) {
                    winner = false;
                    break;
                }
            }
        }

        //Diagonal inversa
        firstDiagonalState = board[0][2];
        if (firstDiagonalState != State.EMPTY) {
            winner = true;
            for (int x = 1, y = 1; x < 3; x++, y--) {
                if (firstDiagonalState != board[x][y]) {
                    winner = false;
                    break;
                }
            }
        }
        return winner;
    }

    public boolean isWinner() {
        if (isRowWinner() || isColumnWinner() || isDiagonalWinner()) {
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == State.CROSS) {
                    System.out.print("X" + " ");
                } else if (board[x][y] == State.NOUGH) {
                    System.out.print("O" + " ");
                } else if (board[x][y] == State.EMPTY) {
                    System.out.print("-" + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isBoardFull() {
        if (numTiradas == 9) {
            return true;
        }
        return false;
    }

    public State endGame(Button button) {
        //disableButtons();
        int x = Integer.parseInt(button.getId().toString().substring(7, 8));
        int y = Integer.parseInt(button.getId().toString().substring(8, 9));

        return board[x][y];
    }

    public boolean isValidPlay(int x, int y) {

        if (board[x][y] == State.EMPTY) {
            return true;
        }
        return false;
    }

    public void setPlayOnBoard(State state, int x, int y) {
        board[x][y] = state;
    }
}
