package com.qding.test.leetcode.easy;

//Example:
//        Given nums = [2, 7, 11, 15], target = 9,
//
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].

public class TwoSum01 {

    static int[] nums = {2, 7, 11, 15};
    static int target=13;
    public static  void main(String[] args){
        twoSum(nums,target);
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i= 0 ,length=nums.length;i<length ;i++){

            for(int j=i+1 ;j< length ;j++){
                if(nums[i]+ nums[j]==target){
                    int[] newNum = { i, j };
                    System.out.println("["+i+","+j+"]");
                    return newNum;
                }
            }

        }
        return  null;
    }

}
