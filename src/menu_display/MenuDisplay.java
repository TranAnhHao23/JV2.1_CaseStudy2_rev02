package menu_display;

import manage.AccountManager;
import manage.CyberManager;
import manage.ServiceManager;
import model.Account;
import model.Computer;
import model.Service;

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
            System.out.println("2. Thêm một máy mới vào danh sách"); // ok
            System.out.println("3. Sửa thông tin một máy trong danh sách"); // ok
            System.out.println("4. Xóa một máy trong danh sách"); // ok
            System.out.println("5. Quản lý dịch vụ"); // ok
            System.out.println("6. Chỉnh sửa tính tiền theo giờ"); // ok
            System.out.println("7. Tính tiền máy"); //
            System.out.println("8. Quản lý tài khoản đăng nhập"); // ok
            System.out.println("9. Quản lý doanh thu"); //
            System.out.println("10. Về menu đăng nhập"); // ok
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
                    System.out.print("Nhập ID máy để thêm vào nào: ");
                    int idAdd = scanner.nextInt();
                    cyberManager.addComputer(idAdd);
                    break;
                case 3:
                    System.out.print("Nhập ID máy để sửa tý thông tin nào: ");
                    int idUpdate = scanner.nextInt();
                    System.out.print("Nhập ID mới để cập nhật: ");
                    int idNew = scanner.nextInt();
                    cyberManager.updateComputerByID(idUpdate, idNew);
                    break;
                case 4:
                    System.out.print("Nhập ID máy để xóa nào: ");
                    int idDelete = scanner.nextInt();
                    cyberManager.deleteComputerByID(idDelete);
                    break;
                case 5:
                    menuServices();
                    break;
                case 6:
                    System.out.print("Thay đổi tý tiền tăng doanh thu nào: ");
                    double priceNew = scanner.nextDouble();
                    cyberManager.changePlayPrice(priceNew);
                    break;
                case 7:
                    totalPay();
                    break;
                case 8:
                    menuAccountManager();
                    break;
                case 9:
                    menuRevenue();
                    break;
                case 10:
                    System.out.println("Căm bách về menu đăng nhập nhớ");
                    break;
                case 0:
                    System.out.println("Bái bai");
                    System.exit(1);
                default:
                    System.out.println("Không có lựa chọn đó cho bạn đâu -_-");
                    break;
            }
        } while (choice != 10);
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

                case 2:

                case 0:
                    System.out.println("Bái bai");
                    break;
                default:
                    System.out.println("Không có lựa chọn đó cho bạn đâu -_-");
                    break;
            }
        } while (menuRevenueChoice != 0);
    }

    public void totalPay() {

    }

    public StringBuilder onlineComputer() {
        StringBuilder output = new StringBuilder();
        for (Computer computer : cyberManager.displayComputers()) {
            if (computer.getStatus().equals("Available")) {
                output.append(computer.getId()).append(" ");
            }
        }
        if (output.length() == 0) {
            return new StringBuilder("Không có máy nào đang bật");
        } else {
            return output;
        }
    }

    public StringBuilder offlineComputer() {
        StringBuilder output = new StringBuilder();
        for (Computer computer : cyberManager.displayComputers()) {
            if (computer.getStatus().equals("Disable")) {
                output.append(computer.getId()).append(" ");
            }
        }
        if (output.length() == 0) {
            return new StringBuilder("Không có máy nào đang tắt");
        } else {
            return output;
        }
    }
}