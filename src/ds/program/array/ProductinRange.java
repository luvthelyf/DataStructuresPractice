package ds.program.array;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductinRange {
    public static void main(String[] args) {
//        System.out.println(new ProductinRange().countNumbers(6, 20));
        System.out.println(new ProductinRange().listBackupFiles("715K 2009-09-23 system.zip~\n 179K 2013-08-14 to-do-list.xml~\n 645K 2013-06-19 blockbuster.mpeg~\n  536 2010-12-12 notes.html\n 688M 1990-02-11 delete-this.zip~\n  23K 1987-05-24 setup.png~\n 616M 1965-06-06 important.html\n  14M 1992-05-31 crucial-module.java~\n 192K 1990-01-31 very-long-filename.dll~"));
    }

    int pronic(int num) {
        int N = (int) Math.sqrt(num);
        if (N * (N + 1) <= num) {
            return N;
        }
        return N - 1;
    }

    private int countNumbers(int a, int b) {
        return pronic(b) - pronic(a - 1);
    }

    String listBackupFiles(String S) {
        String[] filesList = splitString(S, "\\n");
        int minLen = Integer.MAX_VALUE;
        for (String fileDetails : filesList) {
            fileDetails = fileDetails.trim();
//            System.out.println(fileDetails);
            if (fileDetails.endsWith("~")) {
                String[] fileDetailsSeparate = splitString(fileDetails, " ");
                String size = fileDetailsSeparate[0].trim();
                String date = fileDetailsSeparate[1].trim();
                String fileName = fileDetailsSeparate[2].trim();

//                System.out.println(fileName);
                String name = fileName.substring(0, fileName.lastIndexOf("."));
//                String name = splitString(fileDetailsSeparate[2].trim(), "\\.")[0];

                if (!size.isEmpty() && !date.isEmpty() && isSatisfyingConditions(size, date)) {
                    minLen = Math.min(minLen, name.length());
                }
            }
        }
        return (minLen == Integer.MAX_VALUE) ? "NO FILES" : String.valueOf(minLen);
    }

    private boolean isSatisfyingConditions(String sizeValue, String dateValue) {
        if (isSizeSatisfiable(sizeValue) && isDateSatisfiable(dateValue)) return true;
        return false;
    }

    private boolean isDateSatisfiable(String dateValue) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date firstDate = dateFormat.parse(dateValue);
            Date secondDate = dateFormat.parse("1990-01-31");

            if (firstDate.compareTo(secondDate) >= 0) return true;
        } catch (ParseException exception) {
            return false;
        }
        return false;
    }

    private boolean isSizeSatisfiable(String sizeValue) {
        int power = 1;
//        System.out.println(sizeValue);
        String size = sizeValue;
        if (sizeValue.endsWith("K")) {
            power = 10;
            size = sizeValue.substring(0, sizeValue.length() - 1);
        } else if (sizeValue.endsWith("M")) {
            power = 20;
            size = sizeValue.substring(0, sizeValue.length() - 1);
        } else if (sizeValue.endsWith("G")) {
            power = 30;
            size = sizeValue.substring(0, sizeValue.length() - 1);
        }

//        System.out.println(size + " " + power);
        int value = Integer.parseInt(size);

        if (power == 20 && value < 14) return true;
        else
            return power <= 20;
    }

    private String[] splitString(String s, String regex) {
        return s.split(regex);
    }
}
