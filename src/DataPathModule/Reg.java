package DataPathModule;

class Reg {
    private int value;
//    private Boolean enable = false;

    Reg(int value) {
        this.value = value;
    }

//    public void setEnable(Boolean enable) {
//        this.enable = enable;
//    }

    void setValue(int value) {
        this.value = value;
    }

//    public Boolean getEnable() {
//        return enable;
//    }

    int getValue() {
        return value;
    }
}
