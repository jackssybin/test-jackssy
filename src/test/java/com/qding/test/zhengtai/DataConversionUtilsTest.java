package com.qding.test.zhengtai;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DataConversionUtilsTest {

    private static final Logger logger = LoggerFactory.getLogger(DataConversionUtilsTest.class);


    @Before
    public void setUp() throws Exception {
    }
    double[] arr = new double[]{1.2,2,3,3,5,4.6,5.6,6.7,7.7,99};

    @Test
    public void testzScoreNormalize() throws Exception {
        double[] test =DataConversionUtils.zScoreNormalize(arr);
        StringBuffer sb = new StringBuffer();
        for(double d:test){
            sb.append(d).append("\n");
        }
        logger.info("====================================zScoreNormalize正太====================================");
        logger.info(sb.toString());
    }

    @Test
    public void testzminMaxNormalize() throws Exception {
        double[] test =DataConversionUtils.minMaxNormalize(arr);

        StringBuffer sb = new StringBuffer();
        for(double d:test){
            sb.append(d).append("\n");
        }
        logger.info("====================================testzminMaxNormalize最大最小合适====================================");
        logger.info(sb.toString());

    }

    @Test
    public void testdecimalsNormalize() throws Exception {
        double[] test =DataConversionUtils.decimalsNormalize(arr);
        StringBuffer sb = new StringBuffer();
        for(double d:test){
            sb.append(d).append("\n");
        }
        logger.info("====================================testdecimalsNormalize小数化====================================");
        logger.info(sb.toString());
    }

}
