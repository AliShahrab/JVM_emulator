package RamModule;

import CUModule.ControlSignal;
import DataPathModule.Bus;


public class Memory {
    private int[] data = new int[256];
    private ControlSignal controlSignal = new ControlSignal();
    private int address;
    private Bus data_for_write = new Bus();
    private Bus data_for_read = new Bus();
    public void setData_for_write(Bus data_for_write) {
        this.data_for_write = data_for_write;
    }

    public void setControlSignal(ControlSignal controlSignal) {
        this.controlSignal = controlSignal;
    }

    public void setAddress(Bus address) {
        this.address = address.getValue();
    }

    public void next_clock(){
        int[] tmp = controlSignal.getMemory_control();
        if ((tmp[0] == 1) || (tmp[2] == 1)){
            data_for_read.setValue(data[address]);
        }else if (tmp[1] == 1){
            data[address] = data_for_write.getValue();
        }
    }

    public int get_data(){
        return data_for_read.getValue();
    }
}
