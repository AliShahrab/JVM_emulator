package RamModule;

import CUModule.ControlSignal;
import DataPathModule.Bus;


public class Memory {
    private static final int MEMORY_SIZE = 512;
    private int[] data = new int[MEMORY_SIZE];
    private ControlSignal controlSignal = new ControlSignal();
    private int address_for_read_write;
    private int address_for_fetch;
    private Bus data_for_write = new Bus();
    private Bus data_for_read = new Bus();
    private Bus data_for_fetch = new Bus();

    public Memory(){
    }

    public void reset(){
        for (int i = 0; i < data.length; i++) {
            data[i] = 0;
        }
    }

    public void initial(){
        data[0] = 101;
        data[1] = 321;
    }

    public void setData_for_write(Bus data_for_write) {
        this.data_for_write.setValue(data_for_write.getValue());
    }

    public void setControlSignal(ControlSignal controlSignal) {
        this.controlSignal = controlSignal;
    }


    public void setAddress_for_fetch(Bus address) {
        address_for_fetch = address.getValue();
    }

    public void setAddress_for_read_write(Bus address){
        address_for_read_write = address.getValue();
    }

    public Bus getData_for_read() {
        return data_for_read;
    }

    public Bus getData_for_fetch() {
        return data_for_fetch;
    }

    public void next_clock(){
        int[] tmp = controlSignal.getMemory_control();

        if (tmp[0] == 1){
            this.data_for_fetch.setValue(data[address_for_fetch]);
        }else if (tmp[1] == 1){
            data[address_for_read_write] = data_for_write.getValue();
        }else if (tmp[2] == 1){
            data_for_read.setValue(data[address_for_read_write]);
        }
    }
}
