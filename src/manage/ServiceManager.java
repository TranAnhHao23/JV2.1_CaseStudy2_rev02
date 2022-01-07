package manage;

import model.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiceManager {
    private static final String PATH_SERVICE = "src/IOfile/databaseService.csv";
    ArrayList<Service> services = readServiceToCSV();
    Scanner scanner = new Scanner(System.in);

    public ServiceManager() {
    }

    public ArrayList<Service> displayService() {
        writeServiceToCSV(services);
        return services;
    }

    public void addService(String name, double price) {
        if (!checkNameService(name)) {
            services.add(new Service(name, price));
            writeServiceToCSV(services);
            System.out.println("Thêm dịch vụ thành công");
        } else {
            System.out.println("Đã có dịch vụ trong danh sách");
        }
    }

    public void updateService(String name) {
        if (checkNameService(name)) {
            System.out.print("Sửa tên dịch vụ: ");
            String nameNew = scanner.nextLine();
            if (!checkNameService(nameNew) || nameNew.equals(name)) {
                System.out.print("Sửa giá dịch vụ: ");
                double priceNew = scanner.nextDouble();
                scanner.nextLine();
                for (Service service : services) {
                    if (service.getName().equals(name)) {
                        service.setName(nameNew);
                        service.setPrice(priceNew);
                        writeServiceToCSV(services);
                        System.out.println("Sửa dịch vụ thành công");
                        break;
                    }
                }
            } else {
                System.out.println("Trùng tên trong danh sách dịch vụ rồi");
            }
        } else {
            System.out.println("Không tồn tại dịch vụ này trong danh sách");
        }
    }

    public void deleteService(String name) {
        if (checkNameService(name)) {
            for (Service service : services) {
                if (service.getName().equals(name)) {
                    services.remove(service);
                    writeServiceToCSV(services);
                    System.out.println("Sửa dịch vụ thành công");
                    break;
                }
            }
        } else {
            System.out.println("Không tồn tại dịch vụ này trong danh sách");
        }
    }


    public void writeServiceToCSV(ArrayList<Service> serviceList) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_SERVICE));
            for (Service service : serviceList) {
                bufferedWriter.write(service.getId() + "," + service.getName() + "," + service.getPrice());
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Service> readServiceToCSV() {
        ArrayList<Service> serviceList = new ArrayList<>();
        File file = new File(PATH_SERVICE);
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
                    serviceList.add(new Service(output[1], Double.parseDouble(output[2])));
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return serviceList;
    }

    public boolean checkNameService(String name) {
        for (Service service : services) {
            if (service.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
