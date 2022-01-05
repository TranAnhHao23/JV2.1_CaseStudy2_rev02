package manage;

import model.Computer;

import java.io.*;
import java.util.ArrayList;

public class CyberManager {
    private static final String PATH_COMPUTER = "src/IOfile/databaseComputers.csv";
    ArrayList<Computer> computers = readComputerToCSV();

    public CyberManager() {
    }

    public ArrayList<Computer> displayComputers() {
        return computers;
    }

    public void addComputer(int id) {
        if (!checkIDComputer(id)) {
            computers.add(new Computer(id));
            writeComputerToCSV(computers);
            System.out.println("Thêm vào thành công");
        } else {
            System.out.println("ID đã tồn tại!");
        }
    }

    public void updateComputerByID(int id, int idNew){
        if (checkIDComputer(id)) {
            if (!checkIDComputer(idNew)){
                for (Computer computer:computers) {
                    if (computer.getId() == id){
                        computer.setId(idNew);
                        writeComputerToCSV(computers);
                        System.out.println("Cập nhật thành công");
                        break;
                    }
                }
            } else{
                System.out.println("ID mới trùng với ID máy trong danh sách");
            }
        } else {
            System.out.println("ID không tồn tại trong danh sách!");
        }
    }

    public void deleteComputerByID(int id){
        if (checkIDComputer(id)){
            for (Computer computer:computers) {
                if (computer.getId() == id){
                    computers.remove(computer);
                    writeComputerToCSV(computers);
                    System.out.println("Xóa thành công");
                    break;
                }
            }
        } else {
            System.out.println("ID không tồn tại trong danh sách!");
        }
    }

    public void changePlayPrice(double price){
        if (price == Computer.playPrice){
            System.out.println("Trùng rồi thì thay làm gì?");
        } else {
            Computer.playPrice = price;
            System.out.println("Thay đổi thành công rồi nhớ");
        }
        writeComputerToCSV(computers);
    }




    public void writeComputerToCSV(ArrayList<Computer> computerList) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_COMPUTER));
            for (Computer computer : computerList) {
                bufferedWriter.write(computer.getId() + "," + computer.getStatus() + "," + computer.getStartTime() + "," + computer.getEndTime());
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Computer> readComputerToCSV() {
        ArrayList<Computer> computerList = new ArrayList<>();
        File file = new File(PATH_COMPUTER);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    String[] output = line.split(",");
                    computerList.add(new Computer(Integer.parseInt(output[0]), output[1], Long.parseLong(output[2]), Long.parseLong(output[3])));
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return computerList;
    }

    public boolean checkIDComputer(int id) {
        for (Computer computer : computers) {
            if (computer.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
