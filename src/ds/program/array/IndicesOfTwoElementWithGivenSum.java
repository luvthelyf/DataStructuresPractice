package ds.program.array;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class DiscountRepository {
    HashMap<Integer, Float> discounts;
    public DiscountRepository() {
        discounts = new HashMap<>();
    }
    public void setDiscount(int price, float discount) {
        discounts.put(price, discount);
    }

    public void setDiscounts(@NotNull Map<Integer, Float> discounts) {
        this.discounts = new HashMap<>(discounts);
    }

    public Float getDiscountPercent(Integer price) {
        return discounts.getOrDefault(price, 1.0f);
    }
    public void setDiscountPercent(Integer price, Float discount) {
        discounts.put(price, discount);
    }
}
//
//class DiscountRepositoryTest {
//    @Test
//    public final void TestStoreRetrieve() {
//        DiscountRepository r = new DiscountRepository();
//        r.setDiscountPercent(100, 0.55f);
//        Assert.assertTrue(0.55f == r.getDiscountPercent(100));
//        Assert.assertFalse(0.55f == r.getDiscountPercent(200));
//    }
//    @Test
//    public final void TestSetDiscounts() {
//        HashMap<Integer, Float> m = new HashMap<>();
//        m.put(100, 0.90f);
//        m.put(200, 0.80f);
//        m.put(300, 0.70f);
//        DiscountRepository r = new DiscountRepository();
//        r.setDiscounts(m);
//        Assert.assertTrue(0.9f == r.getDiscountPercent(100));
//        Assert.assertTrue(0.7f == r.getDiscountPercent(300));
//    }
//}

public class IndicesOfTwoElementWithGivenSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {9, 12, 2, 7, 11, 15};
        int sum = 9;
        IndicesOfTwoElementWithGivenSum indices = new IndicesOfTwoElementWithGivenSum();
        System.out.println(Arrays.toString(indices.twoSum(arr, sum)));

    }
}
