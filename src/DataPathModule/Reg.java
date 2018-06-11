package DataPathModule;

class Reg {
    private int value;

    Reg(int value) {
        this.value = value;
    }

    void setValue(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
}
