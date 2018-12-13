package leetcode;

import java.util.*;

/**
 * @program: leetcode
 * @description: leetcode中级
 * @author: Ya
 * @create: 2018-12-10 00:29
 **/
public class Leetcode {


    //leetcode34在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int mid = binarySearch(nums, target, 0, nums.length - 1);
        if (mid == -1) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int left = searchRangeLeft(nums, target, 0, mid - 1);
        int right = searchRangeRight(nums, target, mid + 1, nums.length - 1);
        if (left == -1) {
            res[0] = mid;
        } else {
            res[0] = left;
        }
        if (right == -1) {
            res[1] = mid;
        } else {
            res[1] = right;
        }

        return res;

    }

    private int binarySearch(int[] nums, int key, int start, int end) { //返回查到的下标
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == key) {
            return mid;
        } else if (nums[mid] > key) {
            return binarySearch(nums, key, start, mid - 1);
        } else {
            return binarySearch(nums, key, mid + 1, end);
        }
    }

    private int searchRangeLeft(int[] nums, int target, int start, int end) {
        if (start > end) { //退出递归条件
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) { //命中，继续从mid往左寻找：1.若未找到，返回mid 2.若找到,返回找到的下标
            return searchRangeLeft(nums, target, start, mid - 1) == -1 ? mid : searchRangeLeft(nums, target, start, mid - 1);
        } else {//未命中，从mid往右找
            return searchRangeLeft(nums, target, mid + 1, end);
        }
    }

    private int searchRangeRight(int[] nums, int target, int start, int end) {
        if (start > end) { //退出递归条件
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {//命中，继续从mid往右寻找。1.若未找到，返回mid 2.若找到,返回找到的下标
            return searchRangeRight(nums, target, mid + 1, end) == -1 ? mid : searchRangeRight(nums, target, mid + 1, end);
        } else {//未命中, 从mid 往左找
            return searchRangeRight(nums, target, start, mid - 1);
        }
    }


    //寻找峰值
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        return findPeakElement(nums, 0, nums.length - 1);
    }

    public int findPeakElement(int[] nums, int start, int end) {

        int mid = (start + end) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        if (nums[mid] < nums[mid - 1]) {
            int p = mid - 1;
            while (p > start) {
                if (nums[p] > nums[p - 1]) {
                    return p;
                } else {
                    p--;
                }
            }
        }
        if (nums[mid] < nums[mid + 1]) {
            int p = mid + 1;
            while (p < end) {
                if (nums[p] > nums[p + 1]) {
                    return p;
                } else {
                    p++;
                }
            }
        }
        findPeakElement(nums, start, mid);
        findPeakElement(nums, mid, start);
        return -2;
    }

    //数组中的第K个最大元素
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //前K个高频元素
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        System.out.println(hashMap);

        ArrayList<Integer>[] list = new ArrayList[nums.length + 1];
        for (int key : hashMap.keySet()) {
            int value = hashMap.get(key);

            if (list[value] == null) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(key);
                list[value] = temp;
            } else {
                list[value].add(key);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] != null) {
                res.addAll(list[i]);
            }
        }
        return res;
    }
}
