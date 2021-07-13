package ds.program.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NestedListWeightSum2 {
    private static class NestedInteger {
        private int value;
        private List<NestedInteger> nestedIntegerList;

        public NestedInteger() {
            this.value = Integer.MIN_VALUE;
            nestedIntegerList = new ArrayList<>();
        }

        public NestedInteger(int value) {
            this.value = value;
            this.nestedIntegerList = null;
        }

        public boolean isInteger() {
            return this.value != Integer.MIN_VALUE;
        }

        public Integer getInteger() {
            return value;
        }

        public void setInteger(int value) {
            this.value = value;
        }

        public void add(NestedInteger ni) {
            nestedIntegerList.add(ni);
        }

        public List<NestedInteger> getList() {
            return nestedIntegerList;
        }

        @Override
        public String toString() {
            return "NestedInteger{" +
                    (value == Integer.MIN_VALUE ? "" : "value=" + value + ", ") +
                    "nestedIntegerList=" + nestedIntegerList +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<NestedInteger> nestedIntegerList = new ArrayList<>();
//[[1,1],2,[1,1]]
        NestedInteger first = new NestedInteger();
        first.add(new NestedInteger(1));
        first.add(new NestedInteger(1));
        NestedInteger second = new NestedInteger(2);
        NestedInteger third = new NestedInteger();
        third.add(new NestedInteger(1));
        third.add(new NestedInteger(1));
        nestedIntegerList.add(first);
        nestedIntegerList.add(second);
        nestedIntegerList.add(third);

//[1,[4,[6]]]
//        NestedInteger first = new NestedInteger(1);
//        NestedInteger second = new NestedInteger();
//        second.add(new NestedInteger(4));
//        NestedInteger third = new NestedInteger();
//        third.add(new NestedInteger(6));
//        second.add(third);
//
//        nestedIntegerList.add(first);
//        nestedIntegerList.add(second);

// [[0],[0],[0],[0],[0]]
//        NestedInteger first = new NestedInteger();
//        first.add(new NestedInteger(0));
//        NestedInteger second = new NestedInteger();
//        second.add(new NestedInteger(0));
//        NestedInteger third = new NestedInteger();
//        third.add(new NestedInteger(0));
//        NestedInteger fourth = new NestedInteger();
//        fourth.add(new NestedInteger(0));
//        NestedInteger fifth = new NestedInteger();
//        fifth.add(new NestedInteger(0));
//        nestedIntegerList.add(first);
//        nestedIntegerList.add(second);
//        nestedIntegerList.add(third);
//        nestedIntegerList.add(fourth);
//        nestedIntegerList.add(fifth);
        System.out.println(new NestedListWeightSum2().depthSumInverse(nestedIntegerList));
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        reverseDepthSumUtil(nestedList, 1);

        System.out.println(map);
        int sum = 0;
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (Integer item : list) {
                sum += item * (maxDepth - key + 1);

            }
        }
        return sum;
    }
    int maxDepth = 0;

    HashMap<Integer, List<Integer>> map = new HashMap<>();

    private void reverseDepthSumUtil(List<NestedInteger> input, int count) {
        maxDepth = Math.max(maxDepth, count);
        for (NestedInteger nestedInteger : input) {
            if (!nestedInteger.isInteger()) {
                reverseDepthSumUtil(nestedInteger.getList(), count + 1);
            } else {
                List<Integer> list = map.getOrDefault(count, new ArrayList<>());
                list.add(nestedInteger.getInteger());
                map.put(count, list);
            }
        }
    }
}
