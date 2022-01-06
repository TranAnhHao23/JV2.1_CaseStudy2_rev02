package manage;

import model.Revenue;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static menu_display.MenuDisplay.cyberManager;

public class RevenueManager {
    private static final String PATH_REVENUE = "src/IOfile/databaseRevenue.csv";
    ArrayList<Revenue> revenues = readRevenueToCSV();

    public RevenueManager() {
    }

    public void addRevenue() {
        Date today = Calendar.getInstance().getTime();
        String stringDateToday = convertDateToString(today);
        double revenueToday = cyberManager.dailyRevenue;
        if (checkRevenueDate(stringDateToday)) {
            for (Revenue revenue : revenues) {
                if (revenue.getDate().equals(stringDateToday)) {
                    revenue.setDailyRevenue(revenue.getDailyRevenue() + revenueToday);
                }
            }
        } else {
            revenues.add(new Revenue(stringDateToday, revenueToday));
        }
        writeRevenueToCSV(revenues);
    }

    public ArrayList<Revenue> displayRevenue() {
        return revenues;
    }

    public double revenueToday() {
        Date today = Calendar.getInstance().getTime();
        String stringDateToday = convertDateToString(today);
        for (Revenue revenue : revenues) {
            if (revenue.getDate().equals(stringDateToday)) {
                return revenue.getDailyRevenue();
            }
        }
        return 0;
    }

    public double totalRevenue() {
        double total = 0;
        for (Revenue revenue : revenues) {
            total += revenue.getDailyRevenue();
        }
        return total;
    }

    public double revenuePeriod(String dateStart, String dateEnd) {
        int firstDateIndex = 0;
        int lastDateIndex = 0;
        double revenue = 0;
        if (checkRevenueDate(dateStart) && checkRevenueDate(dateEnd)) {
            for (int i = 0; i < revenues.size(); i++) {
                if (convertStringToDate(revenues.get(i).getDate()).compareTo(convertStringToDate(dateStart)) == 0) {
                    firstDateIndex = i;
                }
                if (convertStringToDate(revenues.get(i).getDate()).compareTo(convertStringToDate(dateEnd)) == 0) {
                    lastDateIndex = i;
                }
            }
            for (int i = firstDateIndex; i <= lastDateIndex; i++) {
                    revenue += revenues.get(i).getDailyRevenue();
            }
        } else {
            return -1;
        }
        return revenue;
    }

    public Date convertStringToDate(String dateString) {
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public String convertDateToString(Date date) {
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        String dateString = df.format(date);
        return dateString;
    }

    public void writeRevenueToCSV(ArrayList<Revenue> revenueList) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_REVENUE));
            for (Revenue revenue : revenueList) {
                bufferedWriter.write(revenue.getDate() + "," + revenue.getDailyRevenue());
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Revenue> readRevenueToCSV() {
        ArrayList<Revenue> revenueList = new ArrayList<>();
        File file = new File(PATH_REVENUE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    String[] output = line.split(",");
                    revenueList.add(new Revenue(output[0], Double.parseDouble(output[1])));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return revenueList;
    }

    public boolean checkRevenueDate(String date) {
        for (Revenue revenue : revenues) {
            if (convertStringToDate(revenue.getDate()).compareTo(convertStringToDate(date)) == 0) {
                return true;
            }
        }
        return false;
    }


}
