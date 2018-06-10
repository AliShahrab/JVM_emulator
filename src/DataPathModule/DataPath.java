package DataPathModule;

import CUModule.ControlSignal;

import java.util.ArrayList;
import java.util.HashMap;


public class DataPath {
    private Bus b_bus = new Bus();
    private Bus c_bus = new Bus();
    private Bus h_bus = new Bus();
    private ALU alu = new ALU();
    private Bus data_from_memory = new Bus();
    private Bus address_for_memory = new Bus();
    private Bus data_for_memory = new Bus();
    private HashMap<Integer, Integer> b_map;
    private HashMap<Integer, Integer> c_map;
    private boolean Z;
    private boolean N;
    private ControlSignal controlSignal;
    private ArrayList<Reg> regs = new ArrayList<>();


    public DataPath() {
        this.initial_regs();
        this.initial_hashing();
    }

    private void initial_hashing(){
        this.initial_b_hash();
        this.initial_c_bus();
    }

    private void initial_b_hash(){
        b_map = new HashMap<>();
        b_map.put(0, 1);
        b_map.put(1, 2);
        b_map.put(2, 3);
        b_map.put(3, 4);
        b_map.put(4, 5);
        b_map.put(5, 6);
        b_map.put(6, 7);
        b_map.put(7, 8);
        b_map.put(8, 9);
    }

    private void initial_c_bus(){
        c_map = new HashMap<>();
        c_map.put(0, 0);
        c_map.put(1, 1);
        c_map.put(2, 2);
        c_map.put(3, 5);
        c_map.put(4, 6);
        c_map.put(5, 7);
        c_map.put(6, 8);
        c_map.put(7, 9);
        c_map.put(8, 10);
    }
    private void initial_regs(){
        for (int i = 0; i < 11; i++) {
            regs.add(new Reg(0));
        }
        regs.get(5).setValue(194);
        regs.get(6).setValue(138);
        regs.get(7).setValue(82);
        regs.get(4).setValue(4);


        regs.get(0).setValue(1);
        regs.get(1).setValue(2);
        regs.get(2).setValue(3);
        regs.get(3).setValue(4);
        regs.get(4).setValue(5);
        regs.get(5).setValue(6);
        regs.get(6).setValue(7);
        regs.get(7).setValue(8);
        regs.get(8).setValue(9);
        regs.get(9).setValue(10);
        regs.get(10).setValue(11);
    }

    public Bus getData_for_memory() {
        return data_for_memory;
    }

    public Bus getAddress_for_memory() {
        return address_for_memory;
    }

    public void setData_from_memory(Bus data_from_memory) {
        this.data_from_memory.setValue(data_from_memory.getValue());
    }

    public boolean get_Z() {
        return Z;
    }

    public boolean get_N() {
        return N;
    }


    public void setControlSignal(ControlSignal controlSignal) {
        this.controlSignal = controlSignal;
    }
    public void reset(){
        regs.get(0).setValue(1);
        regs.get(1).setValue(2);
        regs.get(2).setValue(3);
        regs.get(3).setValue(4);
        regs.get(4).setValue(5);
        regs.get(5).setValue(6);
        regs.get(6).setValue(7);
        regs.get(7).setValue(8);
        regs.get(8).setValue(9);
        regs.get(9).setValue(10);
        regs.get(10).setValue(11);
    }


    public void next_clock(){
        b_bus.setValue(set_reg_of_b_bus().getValue());
        h_bus.setValue(regs.get(regs.size() - 1).getValue());
        c_bus.setValue(alu.perform(b_bus, h_bus, controlSignal.getALU_control()).getValue());
        this.Z = alu.get_Z();
        this.N = alu.get_N();
        this.change_reg_with_b_bus();
    }

    private Reg set_reg_of_b_bus(){
        int[] tmp = controlSignal.getB_bus_control();
        int index = -1;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != 0){
                index = i;
            }
        }
        return regs.get(b_map.get(index));
    }

    private void change_reg_with_b_bus(){
        int[] tmp = controlSignal.getC_bus();
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == 1){
                regs.get(c_map.get(i)).setValue(c_bus.getValue());
            }
        }
    }


}
