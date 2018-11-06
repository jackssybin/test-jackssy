package com.qding.test.calc;

import bsh.Interpreter;

import java.text.DecimalFormat;
import java.util.*;

public class TestBsh {

    public static void main(String[] args) {
//        String rule = "a + b * c - d / e +sum";
//        List<ParaVo> list = test.setParam();
        String rule = "$index1$ + $index2$ * $index3$";
        TestBsh test= new TestBsh();
        List<ParaVo> list = test.setParamIndex();
        String retValue = test.calcPoint(rule, list);
        System.out.println("计算结果为：" + retValue);
    }

    private List<ParaVo> setParamIndex(){
        List<ParaVo> list = new ArrayList<ParaVo>();
        ParaVo vo = new ParaVo();
        vo.setName("$index1$");
        vo.setValue(1);
        list.add(vo);

        vo = new ParaVo();
        vo.setName("$index2$");
        vo.setValue(2);
        list.add(vo);

        vo = new ParaVo();
        vo.setName("$index3$");
        vo.setValue(3);
        list.add(vo);

        return list;
    }

    private List<ParaVo> setParam(){
        List<ParaVo> list = new ArrayList<ParaVo>();
        ParaVo vo = new ParaVo();
        vo.setName("a");
        vo.setValue(1);
        list.add(vo);

        vo = new ParaVo();
        vo.setName("b");
        vo.setValue(2);
        list.add(vo);

        vo = new ParaVo();
        vo.setName("c");
        vo.setValue(3);
        list.add(vo);

        vo = new ParaVo();
        vo.setName("d");
        vo.setValue(4);
        list.add(vo);

        vo = new ParaVo();
        vo.setName("e");
        vo.setValue(5);
        list.add(vo);

        vo = new ParaVo();
        vo.setName("sum");
        vo.setValue(6);
        list.add(vo);

        return list;
    }

    private String calcPoint(String rule, List<ParaVo> list){
        String value = "0";
        try {
            Interpreter interpreter = new Interpreter();
            for(ParaVo vo : list){
                interpreter.set(vo.getName(), vo.getValue());
            }
            double va = (Double) interpreter.eval(rule);
            System.out.println(interpreter.get("result"));
            DecimalFormat df = new DecimalFormat("#.00");
            value = df.format(va);
        } catch (Exception e) {
            e.printStackTrace();
            value = "-1";
        }
        return value;
    }
}
