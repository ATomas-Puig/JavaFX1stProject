package Main.java;

public enum State {
    EMPTY(10),
    CROSS(1),
    NOUGH(2);

    private final int value;

    State(int value) {
        this.value = value;
    }
}
