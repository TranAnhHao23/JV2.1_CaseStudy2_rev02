package model;

import java.time.LocalDateTime;

public class Computer {
    private int id;
    private String status;
    private long startTime;
    private long endTime;
    public static double playPrice = 15000;
    private double serviceCash = 0;

    public Computer() {
    }

    public Computer(int id) {
        this.id = id;
        this.status = "Disable";
        this.startTime = 0;
        this.endTime = 0;
    }

    public Computer(int id, String status, long startTime, long endTime) {
        this.id = id;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public double getPlayPrice() {
        return playPrice;
    }

    public void setPlayPrice(double playPrice) {
        this.playPrice = playPrice;
    }

    public double playCash() {
        return (endTime - startTime) * playPrice;
    }

    public void setServiceCash(double serviceCash) {
        this.serviceCash += serviceCash;
    }

    public double totalCash() {
        return playCash() + serviceCash;
    }

    @Override
    public String toString() {
        return "Computer {" +
                "id = " + id +
                ", status = " + status +
                ", startTime = " + startTime +
                ", endTime = " + endTime +
                ", playPrice = " + playPrice +
                '}';
    }

    public String displayPlayTime() {
        if (status.equals("Disable")){
            return toString();
        } else {
            return "Computer {" +
                    "id = " + id +
                    ", status = " + status +
                    ", startTime = " + startTime +
                    ", durationTime = " + (System.currentTimeMillis()/60000 - startTime) +
                    ", playFee = " + playPrice*(System.currentTimeMillis()/60000 - startTime) +
                    ", servicesFee = " + serviceCash +
                    '}';
        }
    }


//    public class DailyRevenue{
//        private String date;
//        private double revenue;
//
//        public DailyRevenue() {
//        }
//
//        public DailyRevenue(String date, double revenue) {
//            this.date = date;
//            this.revenue = revenue;
//        }
//
//
//    }
}
