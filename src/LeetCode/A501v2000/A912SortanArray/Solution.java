package LeetCode.A501v2000.A912SortanArray;

/**
 * 归并排序
 * 时间复杂度O(nlog(n))
 * 空间复杂度O(n)
 * 稳定
 */
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] tmp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid, tmp);
        mergeSort(nums, mid + 1, right, tmp);
        merge(nums, left, right, mid, tmp);
    }

    private void merge(int[] nums, int left, int right, int mid, int[] tmp) {
        int start = left, midStart = mid + 1, index = left;
        while (start <= mid && midStart <= right) {
            if (nums[start] > nums[midStart]) {
                tmp[index++] = nums[midStart++];
            } else {
                tmp[index++] = nums[start++];
            }
        }

        while (start <= mid) {
            tmp[index++] = nums[start++];
        }

        while (midStart <= right) {
            tmp[index++] = nums[midStart++];
        }

        while (left <= right) {
            nums[left] = tmp[left++];
        }
    }
}

/**
 * 快速排序
 * 时间复杂度O(nlog(n)),最坏情况(有序) O(n^2)
 * 空间复杂度O(log(n))
 * 不稳定
 */
class Solution2 {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int privo = nums[(start + end) / 2];
        int left = start, right = end;
        while (left <= right) {
            while (left <= right && nums[left] < privo) {
                left++;
            }
            while (left <= right && nums[right] > privo) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
}