package menu_display;

import manage.AccountManager;
import manage.CyberManager;
import manage.RevenueManager;
import manage.ServiceManager;
import model.Computer;

import java.util.Scanner;

public class MenuDisplay {
    Scanner scanner = new Scanner(System.in);
    public static CyberManager cyberManager = new CyberManager();
    public static AccountManager accountManager = new AccountManager();
    public static ServiceManager serviceManager = new ServiceManager();
    public static RevenueManager revenueManager = new RevenueManager();

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
                case 12:
                    System.out.println("Hiển thị 1 máy cụ thể");
                    System.out.print("Nhập ID máy: ");
                    int idShow = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(cyberManager.displayComputerByID(idShow));
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
                    System.out.print("Bạn có chắc chắn muốn xóa? Bấm 1 để xóa - Bấm 0 để thôi: ");
                    int deleteSelect = scanner.nextInt();
                    cyberManager.deleteComputerByID(idDelete, deleteSelect);
                    break;
                case 6:
                    MenuService menuService = new MenuService();
                    menuService.menuServices();
                    break;
                case 7:
                    System.out.print("Thay đổi tý tiền tăng doanh thu nào: ");
                    double priceNew = scanner.nextDouble();
                    cyberManager.changePlayPrice(priceNew);
                    break;
                case 8:
                    MenuRevenue menuRevenue = new MenuRevenue();
                    menuRevenue.menuRevenue();
                    break;
                case 9:
                    MenuAccountManager menuAccountManager = new MenuAccountManager();
                    menuAccountManager.menuAccountManager();
                    break;
                case 10:
                    revenueManager.addRevenue();
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

    public void totalPay() {
        int menuTotalPayChoice;
        do {
            System.out.println("1. Tổng doanh thu từ đầu");
            System.out.println("2. Chốt doanh thu ngày hôm nay");
            System.out.println("3. Tổng doanh thu theo ngày");
            System.out.println("0.Quay lại");
            System.out.println("------------------");
            System.out.print("Chọn đi nào: ");
            menuTotalPayChoice = scanner.nextInt();
            scanner.nextLine();
            switch (menuTotalPayChoice) {
                case 1:
                    System.out.println(revenueManager.totalRevenue());
                    ;
                    break;
                case 2:
                    System.out.println(revenueManager.revenueToday());
                    ;
                    break;
                case 3:
                    System.out.print("Từ ngày (dd/MM/yyyy): ");
                    String dateStart = scanner.nextLine();
                    System.out.print("Đến ngày (dd/MM/yyyy): ");
                    String dateEnd = scanner.nextLine();
                    double revenuePeriod = revenueManager.revenuePeriod(dateStart, dateEnd);
                    if (revenuePeriod == -1 || dateStart.compareTo(dateEnd) >= 0) {
                        System.out.println("Có gì đó sai sai?");
                    } else {
                        System.out.println("Doanh thu từ " + dateStart + " đến " + dateEnd + " là: " + revenuePeriod);
                    }
                case 0:
                    System.out.println("Bái bai");
                    break;
                default:
                    System.out.println("Không có lựa chọn đó cho bạn đâu -_-");
                    break;
            }
        } while (menuTotalPayChoice != 0);
    }

    public String onlineComputer() {
        StringBuilder outputBuilder = new StringBuilder();
        for (Computer computer : cyberManager.readComputerToCSV()) {
            if (computer.getStatus().equals("Available")) {
                outputBuilder.append(computer.getId()).append(" ");
            }
        }
        String output = outputBuilder.toString();
        if (output.length() == 0) {
            return "Không có máy nào đang bật";
        } else {
            return output;
        }
    }

    public String offlineComputer() {
        StringBuilder outputBuilder = new StringBuilder();
        for (Computer computer : cyberManager.displayComputers()) {
            if (computer.getStatus().equals("Disable")) {
                outputBuilder.append(computer.getId()).append(" ");
            }
        }
        String output = outputBuilder.toString();
        if (output.length() == 0) {
            return "Không có máy nào đang tắt";
        } else {
            return output;
        }
    }

}
