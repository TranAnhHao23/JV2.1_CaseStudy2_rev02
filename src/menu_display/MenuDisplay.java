package menu_display;

import manage.AccountManager;
import manage.CyberManager;
import manage.ServiceManager;
import model.Account;
import model.Computer;
import model.Service;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuDisplay {
    Scanner scanner = new Scanner(System.in);
    CyberManager cyberManager = new CyberManager();
    AccountManager accountManager = new AccountManager();
    ServiceManager serviceManager = new ServiceManager();

    public MenuDisplay() {
    }

    public void menuStart() {
        int choice;
        do {
            System.out.println("             CHÀO MỪNG QUAY LẠI");
            System.out.println("----------PHẦN MỀM QUẢN LÝ PHÒNG MÁY----------");
            System.out.println("1. Hiển thị danh sách máy có trong quán"); // ok, thêm máy on máy off
            System.out.println("2. Bật máy, tính tiền"); // ok, done
            System.out.println("3. Thêm một máy mới vào danh sách"); // ok
            System.out.println("4. Sửa thông tin một máy trong danh sách"); // ok
            System.out.println("5. Xóa một máy trong danh sách"); // ok
            System.out.println("6. Quản lý dịch vụ"); // ok
            System.out.println("7. Chỉnh sửa tính tiền theo giờ"); // ok
            System.out.println("8. Tính tiền máy"); // ok
            System.out.println("9. Quản lý tài khoản đăng nhập"); // ok
            System.out.println("10. Quản lý doanh thu"); //
            System.out.println("11. Về menu đăng nhập"); // ok
            System.out.println("0. Thoát ứng dụng"); // ok
            System.out.println("-----------------------------------------------");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    if (!cyberManager.displayComputers().isEmpty()) {
                        for (Computer computer : cyberManager.displayComputers()) {
                            System.out.println(computer);
                        }
                        System.out.println("Các máy đang online: ");
                        System.out.println(onlineComputer());
                        System.out.println("Các máy đang offline: ");
                        System.out.println(offlineComputer());
                    } else {
                        System.out.println("Chưa có xiền mua máy");
                    }
                    break;
                case 2:
                    System.out.println("Các máy đang online: ");
                    System.out.println(onlineComputer());
                    System.out.println("Các máy đang offline: ");
                    System.out.println(offlineComputer());
                    System.out.print("Nhập máy muốn bật: ");
                    int idTurnOn = scanner.nextInt();
                    cyberManager.turnOnComputer(idTurnOn);
                    break;
                case 3:
                    System.out.print("Nhập ID máy để thêm vào nào: ");
                    int idAdd = scanner.nextInt();
                    cyberManager.addComputer(idAdd);
                    break;
                case 4:
                    System.out.print("Nhập ID máy để sửa tý thông tin nào: ");
                    int idUpdate = scanner.nextInt();
                    System.out.print("Nhập ID mới để cập nhật: ");
                    int idNew = scanner.nextInt();
                    cyberManager.updateComputerByID(idUpdate, idNew);
                    break;
                case 5:
                    System.out.print("Nhập ID máy để xóa nào: ");
                    int idDelete = scanner.nextInt();
                    cyberManager.deleteComputerByID(idDelete);
                    break;
                case 6:
                    menuServices();
                    break;
                case 7:
                    System.out.print("Thay đổi tý tiền tăng doanh thu nào: ");
                    double priceNew = scanner.nextDouble();
                    cyberManager.changePlayPrice(priceNew);
                    break;
                case 8:
                    menuRevenue();
                    break;
                case 9:
                    menuAccountManager();
                    break;
                case 10:
                    totalPay();
                    break;
                case 11:
                    System.out.println("Căm bách về menu đăng nhập nhớ");
                    break;
                case 0:
                    System.out.println("Bái bai");
                    System.exit(1);
                default:
                    System.out.println("Không có lựa chọn đó cho bạn đâu -_-");
                    break;
            }
        } while (choice != 11);
    }

    public void menuAccountManager() {
        int menuAccountChoice;
        do {
            System.out.println("1. Hiển thị tất cả tài khoản quản lý");
            System.out.println("2. Sửa một tài khoản quản lý");
            System.out.println("3. Xóa một tài khoản quản lý");
            System.out.println("4. Thêm một tài khoản quản lý");
            System.out.println("0. Thoát");
            System.out.println("------------------------------------");
            System.out.print("Chọn đi nào: ");
            menuAccountChoice = scanner.nextInt();
            scanner.nextLine();
            switch (menuAccountChoice) {
                case 1:
                    for (Account account : accountManager.displayAccountManager()) {
                        System.out.println(account);
                    }

                    break;
                case 2:
                    System.out.println("Nhập userName cần sửa");
                    String userNameUpdate = scanner.nextLine();
                    accountManager.updateAccountManager(userNameUpdate);
                    break;
                case 3:
                    System.out.println("Nhập userName cần xóa");
                    String userNameDelete = scanner.nextLine();
                    accountManager.deleteAccount(userNameDelete);
                    break;
                case 4:
                    System.out.print("userName thêm mới: ");
                    String userNameAdd = scanner.nextLine();
                    System.out.print("password đi: ");
                    String password = scanner.nextLine();
                    accountManager.addAccountManager(userNameAdd, password);
                    break;
                case 0:
                    System.out.println("Bái bai");
                    break;
                default:
                    System.out.println("Không có lựa chọn đó cho bạn đâu -_-");
                    break;
            }
        } while (menuAccountChoice != 0);
    }

    public void menuServices() {
        int menuServiceChoice;
        do {
            System.out.println("1. Hiển thị tất cả các dịch vụ");
            System.out.println("2. Thêm một dịch vụ");
            System.out.println("3. Sửa một dịch vụ theo tên");
            System.out.println("4. Xóa một dịch vụ theo tên");
            System.out.println("0. Thoát");
            System.out.println("-------------------------------");
            System.out.print("Chọn đi nào: ");
            menuServiceChoice = scanner.nextInt();
            scanner.nextLine();
            switch (menuServiceChoice) {
                case 1:
                    if (!serviceManager.displayService().isEmpty()) {
                        for (Service service : serviceManager.displayService()) {
                            System.out.println(service);
                        }
                    } else {
                        System.out.println("Chưa có dịch vụ nào cả huhu");
                    }
                    break;
                case 2:
                    System.out.print("Nhập tên dịch vụ thêm mới: ");
                    String serviceNameNew = scanner.nextLine();
                    System.out.print("Nhập giá dịch vụ thêm mới: ");
                    double servicePriceNew = scanner.nextDouble();
                    scanner.nextLine();
                    serviceManager.addService(serviceNameNew, servicePriceNew);
                    break;
                case 3:
                    System.out.print("Nhập tên dịch vụ cần sửa: ");
                    String serviceNameEdit = scanner.nextLine();
                    serviceManager.updateService(serviceNameEdit);
                    break;
                case 4:
                    System.out.print("Nhập tên dịch vụ cần xóa: ");
                    String serviceNameDelete = scanner.nextLine();
                    serviceManager.deleteService(serviceNameDelete);
                    break;
                case 0:
                    System.out.println("Bái bai");
                    break;
                default:
                    System.out.println("Không có lựa chọn đó cho bạn đâu -_-");
                    break;
            }
        } while (menuServiceChoice != 0);
    }

    public void menuRevenue() {
        int menuRevenueChoice;
        do {
            System.out.println("1. Thêm dịch vụ");
            System.out.println("2. Thanh toán");
            System.out.println("0. Quay về");
            System.out.println("---------------");
            System.out.print("Chọn đi nào: ");
            menuRevenueChoice = scanner.nextInt();
            scanner.nextLine();
            switch (menuRevenueChoice) {
                case 1:
                    System.out.print("Nhập ID máy muốn thêm dịch vụ: ");
                    int idAddServices = scanner.nextInt();
                    scanner.nextLine();
                    if (onlineComputer().contains(String.valueOf(idAddServices))) {
//                        selectService();
                        cyberManager.addServiceToComputer(idAddServices, selectService());
                    } else {
                        System.out.println("Máy đang offline bạn ôi");
                    }
                    break;
                case 2:
                    System.out.print("Nhập ID muốn thanh toán: ");
                    int idPayment = scanner.nextInt();
                    scanner.nextLine();
                    if (onlineComputer().contains(String.valueOf(idPayment))){
                        System.out.println("Tổng tiền phải thanh toán là: " + cyberManager.turnOffComputer(idPayment));
                    }
                    break;
                case 0:
                    System.out.println("Bái bai");
                    break;
                default:
                    System.out.println("Không có lựa chọn đó cho bạn đâu -_-");
                    break;
            }
        } while (menuRevenueChoice != 0);
    }

    private Service selectService() {
        int choice;
        Service serviceAdd = null;
        for (Service service : serviceManager.displayService()) {
            System.out.println(service);
        }
        System.out.print("Bạn muốn chọn dịch vụ nào: ");
        String nameService = scanner.nextLine();
        System.out.println("Số lượng bao nhiêu nhở?");
        int quantity = scanner.nextInt();
        for (Service service : serviceManager.displayService()) {
            if (service.getName().equals(nameService)) {
                serviceAdd = service;
                serviceAdd.setQuantity(quantity);
                System.out.println("Thêm thành công");
                break;
            }
        }
        if (serviceAdd == null) {
            System.out.println("Bạn nhập sai rồi đó");
        }
        System.out.println("Bạn muốn thêm gì nữa không. Nhấn 1 để thêm, nhấn 0 để thoát");
        return serviceAdd;
    }

    public void totalPay() {

    }

    public String onlineComputer() {
        String output = "";
        for (Computer computer : cyberManager.displayComputers()) {
            if (computer.getStatus().equals("Available")) {
                output += computer.getId() + " ";
            }
        }
        if (output.length() == 0) {
            return "Không có máy nào đang bật";
        } else {
            return output;
        }
    }

    public String offlineComputer() {
        String output = "";
        for (Computer computer : cyberManager.displayComputers()) {
            if (computer.getStatus().equals("Disable")) {
                output += computer.getId() + " ";
            }
        }
        if (output.length() == 0) {
            return "Không có máy nào đang tắt";
        } else {
            return output;
        }
    }
}
