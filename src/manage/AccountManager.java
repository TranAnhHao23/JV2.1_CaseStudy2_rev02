package manage;

import model.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
    private static final String PATH_ACCOUNT = "src/IOFile/databaseAccountManager.csv";
    ArrayList<Account> accounts = readAccountManagerToCSV();
    Scanner scanner = new Scanner(System.in);

    public AccountManager() {
    }

    public ArrayList<Account> displayAccountManager() {
        return accounts;
    }

    public void addAccountManager(String userName, String password) {
        if (!checkAccountExist(userName)) {
            accounts.add(new Account(userName, password));
            writeAccountManagerToCSV(accounts);
            System.out.println("Thêm tài khoản thành công!");
        } else {
            System.out.println("Tài khoản đã tồn tại!");
        }
    }

    public void updateAccountManager(String userName) {
        if (checkAccountExist(userName)) {
            System.out.print("userName mới: ");
            String newUserName = scanner.nextLine();
            if (!checkAccountExist(newUserName)) {
                System.out.print("password mới: ");
                String password = scanner.nextLine();
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getUserName().equals(userName)) {
                        accounts.get(i).setUserName(newUserName);
                        accounts.get(i).setPassword(password);
                        writeAccountManagerToCSV(accounts);
                        System.out.println("Cập nhật tài khoản thành công!");
                        break;
                    }
                }
            } else {
                System.out.println("UserName mới đã tồn tại trong danh sách!");
            }
        } else {
            System.out.println("Không tồn tại tài khoản trong danh sách!");
        }
    }

    public void deleteAccount(String userName) {
        if (checkAccountExist(userName)) {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getUserName().equals(userName)) {
                    accounts.remove(accounts.get(i));
                    writeAccountManagerToCSV(accounts);
                    System.out.println("Xóa tài khoản thành công!");
                    break;
                }
            }
        } else {
            System.out.println("Không tồn tại tài khoản trong danh sách!");
        }
    }

    public void writeAccountManagerToCSV(ArrayList<Account> accountList) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_ACCOUNT));
            for (Account account : accountList) {
                bufferedWriter.write(account.getUserName() + "," + account.getPassword());
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Account> readAccountManagerToCSV() {
        ArrayList<Account> accountList = new ArrayList<>();
        File file = new File(PATH_ACCOUNT);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line; // lỡ tay xóa "" không biết có làm sao không
                while ((line = bufferedReader.readLine()) != null) {
                    String[] output = line.split(",");
                    accountList.add(new Account(output[0], output[1]));
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return accountList;
    }

    public boolean checkAccountExist(String userName) {
        for (Account account : accounts) {
            if (account.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
}
