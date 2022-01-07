package login;

import manage.AccountManager;
import menu_display.MenuDisplay;
import model.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    AccountManager accountManager = new AccountManager();
    Scanner scanner = new Scanner(System.in);

    public Login() {
    }

    public void login() {
        int choice;
        boolean check = true;
        while (check) {
            try {
                do {

                    System.out.println("MENU ĐĂNG NHẬP");
                    System.out.println("1. Đăng nhập");
                    System.out.println("0. Thoát");
                    System.out.println("--------------");
                    System.out.print("Nhập lựa chọn: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.print("Username: ");
                            String userName = scanner.nextLine();
                            System.out.print("Password: ");
                            String password = scanner.nextLine();
                            if (checkAccountManager(userName, password)) {
                                MenuDisplay menuDisplay = new MenuDisplay();
                                System.out.println("Chào mừng quay trở lại");
                                menuDisplay.menuStart();
                            } else {
                                System.out.println("Sai mật khẩu hoặc tên đăng nhập");
                            }
                            break;
                        case 0:
                            System.out.println("Bái bai <3");
                            check = false;
                            break;
                        default:
                            System.out.println("Không có lựa chọn đó đâu bro!");
                            break;
                    }
                } while (choice != 0);
            } catch (Exception e) {
                System.err.println("Không được đâu sói ạ");
            }
        }
    }

    public boolean checkAccountManager(String userName, String password) {
        ArrayList<Account> accounts = accountManager.displayAccountManager();
        for (Account account : accounts) {
            if (account.getUserName().equals(userName) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
