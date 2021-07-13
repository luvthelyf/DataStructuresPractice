package ds.program.array;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeDiffMin {
    public static void main(String[] args) throws ParseException {
//        String str[] = new String[]{"1:10pm", "4:40am", "5:00pm"};
//        String str[] = new String[]{"10:00am", "11:45pm", "5:00am", "6:02am", "5:02pm"};
//        String str[] = new String[]{"11:45pm", "11:45am"};
        String str[] = new String[]{"10:00am", "11:45pm", "5:00am", "12:01am"};

//        System.out.println((int)(Math.random() + 0.5));
        System.out.println(findMinTime(str));
//        String s = "abcd";
//        System.out.println(s+null);

    }

    public static String TimeDifference(String[] strArr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < strArr.length; i++) {
            String st = strArr[i];
            String[] hrMin = st.substring(0, st.length() - 2).split(":");
            int hh = Integer.parseInt(hrMin[0]);
            int mm = Integer.parseInt(hrMin[1]);
            if (st.endsWith("pm")) {
                if (hh != 12)
                    hh = (hh + 12);
            } else {
                if (hh == 12) hh = 0;
            }
            set.add((hh * 60) + mm);
        }
        System.out.println(set);
        int result = Integer.MAX_VALUE;
        int prevVal = 0;
        int first = 0;
        for (Integer element : set) {
            if (prevVal == 0) first = element;
            if (prevVal != 0) {
                int diff1 = element - prevVal;
                if (result > diff1) result = diff1;
            }
            prevVal = element;
        }

        if (result > 1440 - prevVal + first) result = 1440 - prevVal + first;
        return String.valueOf(result);
    }


    private static int findMinTime(String[] str) {
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mma");
        int time[] = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            Date date = null;
            try {
                date = parseFormat.parse(s);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String[] split = displayFormat.format(date).split(":");
            int hour = Integer.parseInt(split[0]) * 60;
            int minu = Integer.parseInt(split[1]);
            int result = hour + minu;
            time[i] = result;
        }
        for (int i = 0; i < time.length; i++) {
            System.out.print(time[i] + " ");
        }
        System.out.println();
        Arrays.sort(time);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < time.length - 1; i++) {
            if (diff > (time[i + 1] - time[i])) {
                diff = (time[i + 1] - time[i]);
            }
        }
        if (diff > 1440 - time[time.length - 1] + time[0])
            diff = 1440 - time[time.length - 1] + time[0];
        return diff;
    }


//    public static int StockPicker(int[] arr) {
//        // code goes here
//
//        if (arr.length == 0) return 0;
//        int buy = arr[0], max = Integer.MIN_VALUE;
//
//        for (int i = 1; i < arr.length; i++) {
//            max = Math.max(max, arr[i] - buy);
//            buy = Math.min(buy, arr[i]);
//        }
//        if (max == Integer.MIN_VALUE) return -1;
//        return max;
//
//    }
//
//    public static void main (String[] args) {
//        // keep this function call here
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        int str[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            str[i] = s.nextInt();
//        }
//        System.out.print(StockPicker(str));
//    }

}
