package com.qding.test.calc.abstractfixcalc;

import com.qding.test.calc.Calculator;

import java.math.BigDecimal;

public abstract  class AbstratCalcFix implements CalcFix {
    @Override
    public BigDecimal calcFixFromFormula(String formula) {
        System.out.println("根据公式计算得值  CalcFixHard");
        analyzeFormula(formula);
        return new BigDecimal(Calculator.conversion(formula));
    }

    public String analyzeFormula(String formula){
        System.out.println("解析计算公式  AbstratCalcFix="+formula);
        return formula;
    }

}
