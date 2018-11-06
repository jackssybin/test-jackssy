package com.qding.test.zhengtai;

import java.util.Arrays;

/**
 * 数据变化-规范化工具类
 */
public class DataConversionUtils {



    /**
     * 最小-最大规范化
     *
     * @param arr
     * @return 规范化后的数组
     */
    public static double[] minMaxNormalize(double[] arr) {
        // 拷贝数组
        double[] tempArr = Arrays.copyOf(arr, arr.length);
        // 找到最大值和最小值
        double max = tempArr[0], min = tempArr[0];
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] > max) {
                max = tempArr[i];
            }
            if (tempArr[i] < min) {
                min = tempArr[i];
            }
        }
        System.out.println("================最大值:"+max+" 最小值:"+min+" ================");
        // 规范化
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = (tempArr[i] - min) / (max - min);
        }
        return tempArr;
    }


    /**
     * Z-score规范化
     * @param arr
     * @return 规范化后的数组
     */
    public static double[] zScoreNormalize(double[] arr) {
        // 拷贝数组
        double[] tempArr = Arrays.copyOf(arr, arr.length);
        // 求均值
        double sum = 0;
        for (double num : tempArr) {
            sum += num;
        }
        double mean = sum / tempArr.length;
        System.out.println("================均值:"+mean+" ================");
        // 求标准差
        double sum2 = 0;
        for (int i = 0; i < tempArr.length; i++) {
            sum2 += Math.sqrt((tempArr[i] - mean) * (tempArr[i] - mean));
        }
        double standardDivition = sum2 / (tempArr.length - 1);
        System.out.println("================标准差:"+standardDivition+" ================");
        // 标准化
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = (tempArr[i] - mean) / standardDivition;
        }
        return tempArr;

    }

    /**
     * 小数定标规范化
     * @param arr
     * @return 规范化后的数组
     */
    public static double[] decimalsNormalize(double[] arr){
        // 拷贝数组
        double[] tempArr = Arrays.copyOf(arr, arr.length);
        // 找到最大值
        double max = tempArr[0];
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] > max) {
                max = tempArr[i];
            }
        }
        // 确定j的值（j为使max(|v'|)<1的最小整数）
        int j = 0;
        while (Math.abs(max/Math.pow(10,j))>=1){
            j++;
        }
        // 规范化
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = tempArr[i] / Math.pow(10,j);
        }
        return tempArr;

    }





}
