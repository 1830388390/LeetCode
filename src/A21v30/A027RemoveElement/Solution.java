package A21v30.A027RemoveElement;
class Solution {
    static int i = 0;
    public int removeElement(int[] nums, int val) {
        for (int j=0;j<nums.length;j++){
            if (nums[j]!=val){
                int b =nums[j];
                nums[i] =b;
                j++;
                if (i<nums.length){i++;};
            }else {
                j++;
            }
        }System.out.println();
        return i+1;
    }
}