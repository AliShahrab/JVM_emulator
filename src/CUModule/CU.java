package CUModule;

import java.util.HashMap;

public class CU {
    private ControlSignal controlSignal = new ControlSignal();
    private boolean Z;
    private boolean N;


    public void setZ(boolean z) {
        Z = z;
    }

    public void setN(boolean n) {
        N = n;
    }

    private HashMap<String, Integer> map_of_b;
    private HashMap<String, Integer> map_of_c;

    public ControlSignal getControlSignal() {
        return controlSignal;
    }

    public CU(){
        map_of_c = new HashMap<>();
        map_of_b = new HashMap<>();
        map_of_c.put("mar", 0);
        map_of_c.put("mdr", 1);
        map_of_c.put("pc", 2);
        map_of_c.put("sp", 3);
        map_of_c.put("lv", 4);
        map_of_c.put("cpp", 5);
        map_of_c.put("tos", 6);
        map_of_c.put("opc", 7);
        map_of_c.put("h", 8);
        map_of_b.put("mdr", 0);
        map_of_b.put("pc", 1);
        map_of_b.put("mbr", 2);
        map_of_b.put("4", 3);
        map_of_b.put("sp", 4);
        map_of_b.put("lv", 5);
        map_of_b.put("cpp", 6);
        map_of_b.put("tos", 7);
        map_of_b.put("opc", 8);
    }

    public void pc_pc_1_add(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("pc"));
        controlSignal.setC_bus(map_of_c.get("pc"));
        controlSignal.setMemory_control(null);
        controlSignal.setALU_control(create_alu_control("src+1"));
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void opc_mbr(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("mbr"));
        controlSignal.setC_bus(map_of_c.get("opc"));
        controlSignal.setMemory_control(null);
        controlSignal.setALU_control(create_alu_control("src"));
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void mdr_mbr(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("mbr"));
        controlSignal.setC_bus(map_of_c.get("mdr"));
        controlSignal.setMemory_control(null);
        controlSignal.setALU_control(create_alu_control("src"));
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void h_4(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("4"));
        controlSignal.setC_bus(map_of_c.get("h"));
        controlSignal.setMemory_control(null);
        controlSignal.setALU_control(create_alu_control("src"));
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void mar_sp_sp_h_add(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("sp"));
        controlSignal.setC_bus(map_of_c.get("mar"));
        controlSignal.setC_bus(map_of_c.get("sp"));
        controlSignal.setMemory_control(null);
        controlSignal.setALU_control(create_alu_control("src+h"));
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void mar_sp_sp_h_sub(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("sp"));
        controlSignal.setC_bus(map_of_c.get("mar"));
        controlSignal.setC_bus(map_of_c.get("sp"));
        controlSignal.setALU_control(create_alu_control("src-h"));
        controlSignal.setMemory_control(null);
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void h_mbr(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("mbr"));
        controlSignal.setC_bus(map_of_c.get("h"));
        controlSignal.setALU_control(create_alu_control("src"));
        controlSignal.setMemory_control(null);
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void pc_pc_h_add(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("pc"));
        controlSignal.setC_bus(map_of_c.get("pc"));
        controlSignal.setALU_control(create_alu_control("src+h"));
        controlSignal.setMemory_control(null);
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void h_mbr_h_add(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("mbr"));
        controlSignal.setC_bus(map_of_c.get("h"));
        controlSignal.setALU_control(create_alu_control("src+h"));
        controlSignal.setMemory_control(null);
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void mar_sp(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("sp"));
        controlSignal.setC_bus(map_of_c.get("mar"));
        controlSignal.setALU_control(create_alu_control("src"));
        controlSignal.setMemory_control(null);
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void h_mdr(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("mdr"));
        controlSignal.setC_bus(map_of_c.get("h"));
        controlSignal.setALU_control(create_alu_control("src"));
        controlSignal.setMemory_control(null);
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void pc_pc_1_sub(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("pc"));
        controlSignal.setC_bus(map_of_c.get("pc"));
        controlSignal.setALU_control(create_alu_control("src-1"));
        controlSignal.setMemory_control(null);
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void mdr_mdr_h_add(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("mdr"));
        controlSignal.setC_bus(map_of_c.get("mdr"));
        controlSignal.setALU_control(create_alu_control("src+h"));
        controlSignal.setMemory_control(null);
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void mdr_mdr_h_sub(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("mdr"));
        controlSignal.setC_bus(map_of_c.get("mdr"));
        controlSignal.setALU_control(create_alu_control("src-h"));
        controlSignal.setMemory_control(null);
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void tos_mdr(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("mdr"));
        controlSignal.setC_bus(map_of_c.get("tos"));
        controlSignal.setALU_control(create_alu_control("src"));
        controlSignal.setMemory_control(null);
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void h_tos(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("tos"));
        controlSignal.setC_bus(map_of_c.get("h"));
        controlSignal.setALU_control(create_alu_control("src"));
        controlSignal.setMemory_control(null);
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }


    public void mar_lv_h_add(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("lv"));
        controlSignal.setC_bus(map_of_c.get("mar"));
        controlSignal.setALU_control(create_alu_control("src+h"));
        controlSignal.setMemory_control(null);
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void mar_cpp_h_add(){
        controlSignal = new ControlSignal();
        controlSignal.setB_bus_control(map_of_b.get("cpp"));
        controlSignal.setC_bus(map_of_c.get("mar"));
        controlSignal.setALU_control(create_alu_control("src+h"));
        controlSignal.setMemory_control(null);
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void nop(){
        controlSignal = new ControlSignal();
        controlSignal.setMemory_control(null);
        controlSignal.setDont_sign_extend(false);
        controlSignal.setALU_shifter(0);
    }

    public void fetch(){
        controlSignal.setMemory_control("fetch");
    }

    public void write(){
        controlSignal.setMemory_control("write");
    }

    public void read(){
        controlSignal.setMemory_control("read");
    }

    public void fetch_w(){
        controlSignal.setMemory_control("fetch_w");
    }

    public void read_w(){
        controlSignal.setMemory_control("read_w");
    }

    private static int[] create_alu_control(String name){
        int[] result = new int[6];
        if (name.equalsIgnoreCase("src+1")){
            result[0] = 1;
            result[1] = 1;
            result[3] = 1;
            result[5] = 1;
        }else if (name.equalsIgnoreCase("src")){
            result[1] = 1;
            result[3] = 1;
        }else if (name.equalsIgnoreCase("src+h")){
            result[0] = 1;
            result[1] = 1;
            result[2] = 1;
            result[3] = 1;
        }else if (name.equalsIgnoreCase("src-h")){
            result[0] = 1;
            result[1] = 1;
            result[2] = 1;
            result[3] = 1;
            result[4] = 1;
            result[5] = 1;
        }else if (name.equalsIgnoreCase("src-1")){
            result[0] = 1;
            result[1] = 1;
            result[3] = 1;
            result[4] = 1;
        }else if (name.equalsIgnoreCase("0")){
            result[1] = 1;
        }
        return result;
    }

}
