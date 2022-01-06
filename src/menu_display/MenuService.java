package menu_display;

import model.Service;

import java.util.Scanner;

import static menu_display.MenuDisplay.serviceManager;

public class MenuService {
    Scanner scanner = new Scanner(System.in);

    public MenuService() {
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
}
