package com.qding.test.calc.abstractfixcalc;

public class CalcFixEasyFactory implements FactoryCalc {
    @Override
    public CalcFix createCalcFix() {
        return new CalcFixEasy();
    }
}
