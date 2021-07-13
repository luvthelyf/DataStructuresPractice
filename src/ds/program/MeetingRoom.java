package ds.program;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class MeetingRoom {
    private static class MeetingTime {
        int time;
        char type;

        public MeetingTime(int time, char type) {
            this.time = time;
            this.type = type;
        }
    }

    public static void main(String[] args) {
        MeetingRoom meetingRoom = new MeetingRoom();
        System.out.println(meetingRoom.numberOfMeetingRoom());
        meetingRoom.allPalindromicSubstring();
    }

    public int numberOfMeetingRoom() {
        // [1,10][10,20] 1 10 10 20
        int[][] meetingTime = new int[][]{{5, 10}, {1, 17}, {15, 20}, {0, 30}};
        List<MeetingTime> list = new ArrayList<>();
        for (int[] t : meetingTime) {
            list.add(new MeetingTime(t[0], 's'));
            list.add(new MeetingTime(t[1], 'e'));
        }
        list.sort(Comparator.comparingInt(o -> o.time));
        int count = 0;
        int max = 0;
        for (MeetingTime time : list) {
            count += (time.type == 's') ? 1 : -1;
            max = Math.max(max, count);
        }
        return max;
    }

    HashSet<String> set = new HashSet<>();

    public void allPalindromicSubstring() {
        StringBuilder ss = new StringBuilder();
        ss.append("abc");
        ss.reverse();
        System.out.println(ss);
        String input = "hellolle";//"kttssttkl";
        for (int i = 0; i < input.length(); i++) {
            addPalindromicSubstringToSet(input, i, i);
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1))
                addPalindromicSubstringToSet(input, i, i + 1);
        }
        System.out.println(set);
    }

    private void addPalindromicSubstringToSet(String input, int start, int end) {
        StringBuilder sb = new StringBuilder();
        String s;
        if (start == end) {
            sb.append(input.charAt(start));
        } else {
            sb.append(input.charAt(start)).append(input.charAt(end));
        }
        s = sb.toString();
        set.add(s);
        int l = start - 1;
        int r = end + 1;
        while (l >= 0 && r < input.length() && input.charAt(l) == input.charAt(r)) {
            s = input.charAt(l) + s + input.charAt(r);
            set.add(s);
            l--;
            r++;
        }
    }
}
