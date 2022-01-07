package menu_display;

import validate.Validate;

import java.util.Scanner;

import static menu_display.MenuDisplay.revenueManager;

public class MenuRevenue {
    private Scanner scanner = new Scanner(System.in);
    Validate validate = new Validate();

    public MenuRevenue() {
    }

    public void totalPay() {
        int menuTotalPayChoice;
        boolean check = true;
        while (check) {
            try {
                do {
                    System.out.println("1. Tổng doanh thu từ đầu");
                    System.out.println("2. Chốt doanh thu ngày hôm nay");
                    System.out.println("3. Tổng doanh thu theo ngày");
                    System.out.println("0.Quay lại");
                    System.out.println("------------------");
                    System.out.print("Chọn đi nào: ");
                    menuTotalPayChoice = Integer.parseInt(scanner.nextLine());
//            scanner.nextLine();
                    switch (menuTotalPayChoice) {
                        case 1:
                            System.out.println(revenueManager.totalRevenue());
                            break;
                        case 2:
                            System.out.println(revenueManager.revenueToday());
                            break;
                        case 3:
                            System.out.print("Từ ngày (dd/MM/yyyy): ");
                            String dateStart = scanner.nextLine();
                            System.out.print("Đến ngày (dd/MM/yyyy): ");
                            String dateEnd = scanner.nextLine();
                            if (validate.validateDate(dateStart) && validate.validateDate(dateEnd)) {
                                double revenuePeriod = revenueManager.revenuePeriod(dateStart, dateEnd);
                                if (dateStart.compareTo(dateEnd) >= 0) {
                                    System.out.println("Có gì đó sai sai? Ngày đầu lớn hơn ngày cuối???");
                                } else {
                                    System.out.println("Doanh thu từ " + dateStart + " đến " + dateEnd + " là: " + revenuePeriod);
                                }
                            } else {
                                System.out.println("Nhập ngày còn sai cơ mà?");
                            }
                            break;
                        case 0:
                            System.out.println("Bái bai");
                            check = false;
                            break;
                        default:
                            System.out.println("Không có lựa chọn đó cho bạn đâu -_-");
                            break;
                    }
                } while (menuTotalPayChoice != 0);
            } catch (Exception e){
                System.err.println("Không có đâu sói ạ");
            }
        }
    }
}
