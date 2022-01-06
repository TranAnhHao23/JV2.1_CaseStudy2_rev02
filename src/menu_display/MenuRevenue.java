package menu_display;

import model.Service;

import java.util.Scanner;

import static menu_display.MenuDisplay.cyberManager;
import static menu_display.MenuDisplay.serviceManager;

public class MenuRevenue {
    Scanner scanner = new Scanner(System.in);
    MenuDisplay menuDisplay = new MenuDisplay();

    public MenuRevenue() {
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
                    if (menuDisplay.onlineComputer().contains(String.valueOf(idAddServices))) {
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
                    if (menuDisplay.onlineComputer().contains(String.valueOf(idPayment))) {
                        System.out.println("Tắt máy tính tiền");
                        System.out.println("Tổng tiền của máy" + idPayment + " = " + cyberManager.turnOffComputer(idPayment));
                    }else {
                        System.out.println("Máy đang offline bạn ôi");
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
        Service serviceAdd = null;
        for (Service service : serviceManager.displayService()) {
            System.out.println(service);
        }
        System.out.print("Bạn muốn chọn dịch vụ nào: ");
        int idService = scanner.nextInt();
        System.out.println("Số lượng bao nhiêu nhở?");
        int quantity = scanner.nextInt();
        for (Service service : serviceManager.displayService()) {
            if (service.getId() == idService) {
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


}
