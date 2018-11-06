package com.qding.test.zhengtai;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DataStatisticsUtilsTest {

    private static final Logger logger = LoggerFactory.getLogger(DataConversionUtilsTest.class);

//    double value = newBigDecimal(num).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    double[] arr = new double[]{1.2,2,3,3,5,4.6,5.6,6.7,7.7,99};


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testStatic() throws Exception {
        logger.info("==================原始数据==================");
        for(double dd: arr){
            logger.info("=========="+dd);
        }
        double dd = 0d;
        logger.info("==================最大值==================");
        dd=DataStatisticsUtils.getMax(arr);
        logger.info(""+dd);
        logger.info("==================最小值==================");
        dd=DataStatisticsUtils.getMin(arr);
        logger.info(""+dd);
        logger.info("==================求和==================");
        dd=DataStatisticsUtils.getSum(arr);
        logger.info(""+dd);
        logger.info("==================均值==================");
        dd=DataStatisticsUtils.getMean(arr);
        logger.info(""+dd);
        logger.info("==================众数==================");
        dd=DataStatisticsUtils.getMode(arr);
        logger.info(""+dd);
        logger.info("==================中位数==================");
        dd=DataStatisticsUtils.getMedian(arr);
        logger.info(""+dd);
        logger.info("==================中列数==================");
        dd=DataStatisticsUtils.getMidrange(arr);
        logger.info(""+dd);
        logger.info("==================四分位数==================");
        double[] dda=DataStatisticsUtils.getQuartiles(arr);
        for(double ddasfsa :dda){
            logger.info(""+ddasfsa);
        }
        logger.info("==================极差==================");
        dd=DataStatisticsUtils.getRange(arr);
        logger.info(""+dd);
        logger.info("==================四分位数极差==================");
        dd=DataStatisticsUtils.getQuartilesRange(arr);
        logger.info(""+dd);
        logger.info("==================截断均值==================");
        dd=DataStatisticsUtils.getTrimmedMean(arr,20);
        logger.info(""+dd);
        logger.info("==================方差==================");
        dd=DataStatisticsUtils.getVariance(arr);
        logger.info(""+dd);
        logger.info("==================绝对平均偏差(AAD)==================");
        dd=DataStatisticsUtils.getAbsoluteAverageDeviation(arr);
        logger.info(""+dd);
        logger.info("==================中位数绝对偏差(MAD)==================");
        dd=DataStatisticsUtils.getMedianAbsoluteDeviation(arr);
        logger.info(""+dd);
        logger.info("==================标准差==================");
        dd=DataStatisticsUtils.getStandardDevition(arr);
        logger.info(""+dd);
    }

}
