package Guide.a2最长的可整合子数组的长度;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num == 0){
            System.out.println(0);
            return;
        }
        int[] nums = new int[num];
        for(int i = 0;i<num;i++){
            nums[i] = sc.nextInt();
        }
        int res = 1;
        Arrays.sort(nums);
        int tmp = 1;
        for(int i = 1;i<num;i++){
            if(nums[i] - nums[i - 1] <= 1){
                tmp++;
            }else{
                tmp = 1;
            }
            res = Integer.max(tmp,res);
        }
        System.out.println(res);
    }
}