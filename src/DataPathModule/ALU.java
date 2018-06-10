package DataPathModule;

class ALU {
    private boolean Z;
    private boolean N;


    Bus perform(Bus src, Bus h, int[] alu_control){
        Bus out = new Bus();
        if (alu_control[0] == 0 && alu_control[1] == 1 && alu_control[2] == 0 && alu_control[3] == 1 && alu_control[4] == 0 &&
                alu_control[5] == 0){
            out.setValue(src.getValue());
        }else if (alu_control[0] == 1 && alu_control[1] == 1 && alu_control[2] == 0 && alu_control[3] == 1 && alu_control[4] == 0 &&
                alu_control[5] == 1){
            out.setValue(src.getValue() + 1);
        }else if (alu_control[0] == 1 && alu_control[1] == 1 && alu_control[2] == 1 && alu_control[3] == 1 && alu_control[4] == 0 &&
                alu_control[5] == 0){
            out.setValue(src.getValue() + h.getValue());
        }else if (alu_control[0] == 1 && alu_control[1] == 1 && alu_control[2] == 1 && alu_control[3] == 1 && alu_control[4] == 1 &&
                alu_control[5] == 1){
            out.setValue(src.getValue() - h.getValue());
        }else if (alu_control[0] == 1 && alu_control[1] == 1 && alu_control[2] == 0 && alu_control[3] == 1 && alu_control[4] == 1 &&
                alu_control[5] == 0){
            out.setValue(src.getValue() - 1);
        }else if (alu_control[0] == 0 && alu_control[1] == 1 && alu_control[2] == 0 && alu_control[3] == 0 && alu_control[4] == 0 &&
                alu_control[5] == 0){
            out.setValue(0);
        }
        if (out.getValue() == 0){
            this.Z = true;
        }else if (out.getValue() < 0){
            this.N = true;
        }else {
            this.Z = false;
            this.N = false;
        }
        return out;
    }

    boolean get_Z() {
        return Z;
    }

    boolean get_N() {
        return N;
    }
}
