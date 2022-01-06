package manage;

import model.Computer;
import model.Service;

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

    public String displayComputerByID(int id) {
        if (checkIDComputer(id)) {
            for (Computer computer : computers) {
                if (computer.getId()==id){
                    return computer.displayPlayTime();
                }
            }
        }
        return "Nhầm ID à?";
    }

    public void addComputer(int id) {
        if (!checkIDComputer(id)) {
            computers.add(new Computer(id));
            writeComputerToCSV(displayComputers());
            System.out.println("Thêm vào thành công");
        } else {
            System.out.println("ID đã tồn tại!");
        }
    }

    public void updateComputerByID(int id, int idNew) {
        if (checkIDComputer(id)) {
            if (!checkIDComputer(idNew)) {
                for (Computer computer : computers) {
                    if (computer.getId() == id) {
                        computer.setId(idNew);
                        writeComputerToCSV(displayComputers());
                        System.out.println("Cập nhật thành công");
                        break;
                    }
                }
            } else {
                System.out.println("ID mới trùng với ID máy trong danh sách");
            }
        } else {
            System.out.println("ID không tồn tại trong danh sách!");
        }
    }

    public void deleteComputerByID(int id, int choice) {
        if (checkIDComputer(id)) {
            for (Computer computer : computers) {
                if (computer.getId() == id) {
                    if (choice == 1) {
                        computers.remove(computer);
                        writeComputerToCSV(displayComputers());
                        System.out.println("Xóa thành công");
                        break;
                    } else if (choice == 0) {
                        System.out.println("Ô bạn đùa tôi à? Lần nữa là ăn đòn đó");
                    }
                }
            }
        } else {
            System.out.println("ID không tồn tại trong danh sách!");
        }
    }

    public void changePlayPrice(double price) {
        if (price == Computer.playPrice) {
            System.out.println("Trùng rồi thì thay làm gì?");
        } else {
            Computer.playPrice = price;
            System.out.println("Thay đổi thành công rồi nhớ");
        }
        writeComputerToCSV(displayComputers());
    }

    public void addServiceToComputer(int id, Service serviceAdd) {
        for (Computer computer : computers) {
            if (computer.getId() == id) {
                computer.setServiceCash(serviceAdd.getPrice() * serviceAdd.getQuantity());
//                System.out.println(computer.totalCash());
            }
        }
    }

    public void turnOnComputer(int id) {
        if (checkIDComputer(id)) {
            for (Computer computer : computers) {
                if (computer.getId() == id) {
                    if (computer.getStatus().equals("Disable")) {
                        computer.setStatus("Available");
                        computer.setStartTime(System.currentTimeMillis() / 60000);
                        System.out.println(computer.getStatus());
                        System.out.println("Đã mở máy, chơi đi bạn");
                        writeComputerToCSV(displayComputers());
                        break;
                    } else {
                        System.out.println("Máy đang bật, không bật được lần nữa đâu");
                    }
                }
            }
        } else {
            System.out.println("Không có ID máy trong hệ thống");
        }
    }


    public double turnOffComputer(int id) {
        double totalCash = 0;
        if (checkIDComputer(id)) {
            for (Computer computer : computers) {
                if (computer.getId() == id) {
                    if (computer.getStatus().equals("Available")) {
                        computer.setStatus("Disable");
                        computer.setEndTime(System.currentTimeMillis() / 60000);
                        totalCash = computer.totalCash();
                        computer.setStartTime(0);
                        computer.setEndTime(0);
                        computer.setServiceCash(0);
                        writeComputerToCSV(displayComputers());
                        break;
                    }
                }
            }

        }
        return totalCash;
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
                String line;
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
