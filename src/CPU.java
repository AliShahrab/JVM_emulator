import CUModule.CU;
import CUModule.ControlSignal;
import DataPathModule.Bus;
import DataPathModule.DataPath;
import RamModule.Memory;


public class CPU {
    private DataPath dataPath = new DataPath();
    private CU cu = new CU();
    private Memory memory = new Memory();
    private Bus address_for_memory = new Bus();
    private Bus data_from_memory = new Bus();
    private Bus data_for_memory = new Bus();

    private void next_clock(){
        ControlSignal controlSignal = cu.getControlSignal();
        dataPath.setControlSignal(controlSignal);
        memory.setControlSignal(controlSignal);

        dataPath.next_clock();
        memory.next_clock();

        data_from_memory.setValue(memory.get_data());
        dataPath.setData_from_memory(data_from_memory);

        address_for_memory.setValue(dataPath.getAddress_for_memory().getValue());
        memory.setAddress(address_for_memory);

        data_for_memory.setValue(dataPath.getData_for_memory().getValue());
        memory.setData_for_write(data_from_memory);

//        dataPath.setData_from_memory(data_from_memory);

        cu.setZ(dataPath.get_Z());
        cu.setN(dataPath.get_N());

    }

    private CU getCu() {
        return cu;
    }

    public static void main(String[] args) {
        CPU cpu = new CPU();
        test(cpu);
    }

    private static void test(CPU cpu){
        cpu.getCu().pc_pc_1_add();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().opc_mbr();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().mdr_mbr();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().h_4();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().mar_sp_sp_h_add();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().h_mbr();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().mar_sp_sp_h_sub();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().pc_pc_h_add();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().h_mbr_h_add();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().mar_sp();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().h_mdr();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().pc_pc_1_sub();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().mdr_mdr_h_add();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().mdr_mdr_h_sub();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().tos_mdr();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().h_tos();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().mar_lv_h_add();
        cpu.next_clock();
        cpu.dataPath.reset();
        cpu.getCu().mar_cpp_h_add();
        cpu.next_clock();
        cpu.dataPath.reset();
    }
}
