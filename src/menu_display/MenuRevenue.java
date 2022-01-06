package menu_display;

import java.util.Scanner;

import static menu_display.MenuDisplay.revenueManager;

public class MenuRevenue {
    private Scanner scanner = new Scanner(System.in);

    public MenuRevenue() {
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
}
