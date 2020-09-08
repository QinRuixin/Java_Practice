package leetcode;

import java.util.*;

/**
 * @author qin
 * @date 2020-09-07
 */
public class Q347 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        int[] res = (new Q347()).topKFrequent(nums, 10);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x1,x2)->x1[1]-x2[1]);

        Set<Map.Entry<Integer, Integer>> entries = counts.entrySet();
        for (Map.Entry<Integer, Integer> entry :
                entries) {
            if (minHeap.size() < k) {
                minHeap.add(new int[]{entry.getKey(),entry.getValue()});
            }else{
                if( entry.getValue() > minHeap.peek()[1] ){
                    minHeap.poll();
                    minHeap.add(new int[]{entry.getKey(),entry.getValue()});
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll()[0];
        }
        return res;
    }

//    public int[] topKFrequent(int[] nums, int k) {
//        HashMap<Integer, Integer> counts = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!counts.containsKey(nums[i])) {
//                counts.put(nums[i], 1);
//            } else {
//                counts.put(nums[i], counts.get(nums[i]) + 1);
//            }
//        }
//
//        Integer[] tempRes = new Integer[counts.size()];
//
//        Collection<Integer> values = counts.keySet();
//        int idx = 0;
//        for (Integer i:values) {
//            tempRes[idx++] = i;
//        }
//
//        Arrays.sort(tempRes, (o1, o2) -> counts.get(o2) - counts.get(o1));
////        Arrays.sort(numsss, Comparator.comparingInt(counts::get));
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = tempRes[i];
//        }
//
//        return res;
//    }
}
