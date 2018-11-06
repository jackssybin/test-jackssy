package com.qding.test.calc.abstractfixcalc;

import com.qding.test.calc.Calculator;

import java.math.BigDecimal;

public class CalcFixHard extends AbstratCalcFix {

    @Override
    public BigDecimal calcFixFromFormula(String formula) {
        System.out.println("根据公式计算得值  CalcFixHard");
        analyzeFormula(formula);
        return new BigDecimal(Calculator.conversion(formula));
    }

    @Override
    public String analyzeFormula(String formula){
        System.out.println("解析计算公式  CalcFixHard");
        return "";
    }
}
