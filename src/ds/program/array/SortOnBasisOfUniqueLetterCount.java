package ds.program.array;


import java.util.*;

public class SortOnBasisOfUniqueLetterCount {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int k = 0;
            while (k <= n) {
                String line = sc.nextLine();
                arrayList.add(line);
                k++;
            }

            ArrayList<String> outputList = customSortingAlgo(arrayList);
            for (String item : outputList) {
                System.out.println(item);
            }
        }
    }

    private static ArrayList<String> customSortingAlgo(ArrayList<String> arrayList) {

        TreeMap<String, Integer> map = new TreeMap<>();


        for (String item : arrayList) {
            char[] temp = new char[26];
            int len = item.length();
            for (int i = 0; i < len; i++) {
                char c = item.charAt(i);
                if (c < 'A' || c > 'Z') {
                    continue;
                }
                temp[c - 'A'] = 1;
            }
            int count = 0;
            for (int i = 0; i < 26; i++) count += temp[i];
            map.put(item, count);

        }

        List<Map.Entry<String, Integer>> newList = new LinkedList<>(map.entrySet());

        Collections.sort(newList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        ArrayList<String> finalOutput = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : newList) {
            map.put(entry.getKey(), entry.getValue());
            System.out.println(entry.getKey()+"-->"+entry.getValue());

            finalOutput.add(entry.getKey());
        }
        return finalOutput;
    }
}
