package model;

import static menu_display.MenuDisplay.cyberManager;
public class Revenue {
    private String date;
    private double dailyRevenue = 0;

    public Revenue() {
    }

    public Revenue(String date, double dailyRevenue) {
        this.date = date;
        this.dailyRevenue = dailyRevenue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDailyRevenue() {
        return dailyRevenue;
    }

    public void setDailyRevenue(double dailyRevenue) {
        this.dailyRevenue = dailyRevenue;
    }

    @Override
    public String toString() {
        return "Revenue{" +
                "date='" + date + '\'' +
                ", dailyRevenue=" + dailyRevenue +
                '}';
    }
}
