import CUModule.CU;
import CUModule.ControlSignal;
import DataPathModule.Bus;
import DataPathModule.DataPath;
import RamModule.Memory;


public class CPU {
    private DataPath dataPath = new DataPath();
    private CU cu = new CU();
    private Memory memory = new Memory();
    private Bus address_for_memory_read_write = new Bus();
    private Bus address_for_memory_fetch = new Bus();
    private Bus data_from_memory_fetch = new Bus();
    private Bus data_from_memory_read = new Bus();
    private Bus data_for_memory = new Bus();

    private void next_clock(){
        ControlSignal controlSignal = cu.getControlSignal();
        dataPath.setControlSignal(controlSignal);
        memory.setControlSignal(controlSignal);

        dataPath.next_clock();
        memory.next_clock();



        data_from_memory_fetch.setValue(memory.getData_for_fetch().getValue());
        dataPath.setData_from_memory_fetch(data_from_memory_fetch);

        data_from_memory_read.setValue(memory.getData_for_read().getValue());
        dataPath.setData_from_memory_read(data_from_memory_read);


        address_for_memory_fetch.setValue(dataPath.getAddress_for_memory_fetch().getValue());
        memory.setAddress_for_fetch(address_for_memory_fetch);

        address_for_memory_read_write.setValue(dataPath.getAddress_for_memory_read().getValue());
        memory.setAddress_for_read_write(address_for_memory_read_write);


        data_for_memory.setValue(dataPath.getData_for_memory().getValue());
        memory.setData_for_write(data_for_memory);



        cu.setZ(dataPath.get_Z());
        cu.setN(dataPath.get_N());

    }


    private void reset(){
        this.dataPath.reset();
        this.memory.reset();
        data_from_memory_fetch.setValue(memory.getData_for_fetch().getValue());
        dataPath.setData_from_memory_fetch(data_from_memory_fetch);

        data_from_memory_read.setValue(memory.getData_for_read().getValue());
        dataPath.setData_from_memory_read(data_from_memory_read);


        address_for_memory_fetch.setValue(dataPath.getAddress_for_memory_fetch().getValue());
        memory.setAddress_for_fetch(address_for_memory_fetch);

        address_for_memory_read_write.setValue(dataPath.getAddress_for_memory_read().getValue());
        memory.setAddress_for_read_write(address_for_memory_read_write);


        data_for_memory.setValue(dataPath.getData_for_memory().getValue());
        memory.setData_for_write(data_for_memory);



        cu.setZ(dataPath.get_Z());
        cu.setN(dataPath.get_N());
    }

    private CU getCu() {
        return cu;
    }

    public static void main(String[] args) {
        CPU cpu = new CPU();
        cpu.reset();
        cpu.memory.initial();
        example(cpu);
    }


    private static void example(CPU cpu){
        boolean end = true;
        while (end){
            cpu.getCu().pc_pc_1_add();
            cpu.getCu().fetch();
            cpu.next_clock();
            cpu.getCu().nop();
            cpu.getCu().fetch_w();
            cpu.next_clock();
            cpu.getCu().opc_mbr();
            cpu.next_clock();
            cpu.getCu().pc_pc_1_add();
            cpu.getCu().fetch();
            cpu.next_clock();
            int opcode = cpu.dataPath.get_opcode();
            if (opcode == 101){
                cpu.getCu().nop();
                cpu.getCu().fetch_w();
                cpu.next_clock();
                cpu.getCu().mdr_mbr();
                cpu.next_clock();
                cpu.getCu().h_4();
                cpu.next_clock();
                cpu.getCu().mar_sp_sp_h_add();
                cpu.next_clock();
                cpu.getCu().nop();
                cpu.getCu().write();
                cpu.next_clock();
            }
        }
    }


//    private static void test_2(CPU cpu){
//        cpu.getCu().pc_pc_1_add();
//        cpu.getCu().write();
//        cpu.next_clock();
//        cpu.getCu().nop();
//        cpu.getCu().read_w();
//        cpu.next_clock();
//        cpu.getCu().pc_pc_1_add();
//        cpu.getCu().fetch();
//        cpu.next_clock();
//        cpu.getCu().nop();
//        cpu.getCu().fetch_w();
//        cpu.next_clock();
//        cpu.getCu().pc_pc_1_add();
//        cpu.getCu().fetch();
//        cpu.next_clock();
//        cpu.getCu().nop();
//        cpu.getCu().fetch_w();
//        cpu.next_clock();
//        cpu.getCu().nop();
//        cpu.getCu().fetch();
//        cpu.next_clock();
//    }
//

//    private static void test_1(CPU cpu){
//        cpu.getCu().pc_pc_1_add();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().opc_mbr();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().mdr_mbr();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().h_4();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().mar_sp_sp_h_add();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().h_mbr();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().mar_sp_sp_h_sub();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().pc_pc_h_add();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().h_mbr_h_add();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().mar_sp();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().h_mdr();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().pc_pc_1_sub();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().mdr_mdr_h_add();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().mdr_mdr_h_sub();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().tos_mdr();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().h_tos();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().mar_lv_h_add();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//        cpu.getCu().mar_cpp_h_add();
//        cpu.next_clock();
//        cpu.dataPath.reset();
//    }
}
