package menu_display;

import model.Account;

import java.util.Scanner;

import static menu_display.MenuDisplay.accountManager;

public class MenuAccountManager {
    Scanner scanner = new Scanner(System.in);

    public MenuAccountManager() {
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
                    System.out.print("Nhập userName cần sửa: ");
                    String userNameUpdate = scanner.nextLine();
                    accountManager.updateAccountManager(userNameUpdate);
                    break;
                case 3:
                    System.out.print("Nhập userName cần xóa: ");
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
}
