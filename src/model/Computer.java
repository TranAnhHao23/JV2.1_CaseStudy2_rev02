package model;

public class Computer {
    private int id;
    private String status;
    private long startTime;
    private long endTime;
    public static double playPrice = 15000;

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

    public double serviceCash(Service service) {
        return service.getPrice() * service.getQuantity();
    }

    public double totalCash(Service service) {
        return playPrice + serviceCash(service);
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
}
