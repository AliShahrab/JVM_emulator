package CUModule;

import java.util.ArrayList;

/**
 * Created by ali on 6/9/18.
 */
public class ControlSignal {
    private int[] b_bus_control = new int[9];
    private int[] c_bus = new int[9];
    private int[] memory_control = new int[5];
    private int[] ALU_shifter = new int[2];
    private int[] ALU_control = new int[6];
    private boolean dont_sign_extend;


    public ControlSignal(){
        for (int i = 0; i < b_bus_control.length; i++) {
            b_bus_control[i] = 0;
        }
        for (int i = 0; i < c_bus.length; i++) {
            c_bus[i] = 0;
        }
        for (int i = 0; i < memory_control.length; i++) {
            memory_control[i] = 0;
        }
        for (int i = 0; i < ALU_shifter.length; i++) {
            ALU_shifter[i] = 0;
        }
        for (int i = 0; i < ALU_control.length; i++) {
            ALU_control[i] = 0;
        }
        dont_sign_extend = false;
    }

    public int[] getB_bus_control() {
        return b_bus_control;
    }

    public int[] getC_bus() {
        return c_bus;
    }

    public int[] getMemory_control() {
        return memory_control;
    }

    public int[] getALU_shifter() {
        return ALU_shifter;
    }

    public int[] getALU_control() {
        return ALU_control;
    }

    public boolean isDont_sign_extend() {
        return dont_sign_extend;
    }

    public void setB_bus_control(int number_of_reg) {
        if( number_of_reg != -1){
            b_bus_control[number_of_reg] = 1;
        }
    }

    public void setC_bus(int index) {
            c_bus[index] = 1;
    }

    public void setMemory_control(String name) {
        if (name == null){
        }else if (name.equalsIgnoreCase("fetch")){
            memory_control[0] = 1;
        }else if(name.equalsIgnoreCase("write")){
            memory_control[1] = 1;
        }else if(name.equalsIgnoreCase("read")){
            memory_control[2] = 1;
        }else if (name.equalsIgnoreCase("fetch_w")){
            memory_control[3] = 1;
        }else if (name.equalsIgnoreCase("read_w")){
            memory_control[4] = 1;
        }
    }

    public void setALU_shifter(int shifter) {
        if (shifter == 2){
            this.ALU_shifter[0] = 1;
        }else if (shifter == 8){
            this.ALU_shifter[1] = 1;
        }
    }

    public void setALU_control(int[] ALU_control) {
        System.arraycopy(ALU_control, 0, this.ALU_control, 0, ALU_control.length);
    }

    public void setDont_sign_extend(boolean dont_sign_extend) {
        this.dont_sign_extend = dont_sign_extend;
    }
}
