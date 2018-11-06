package com.qding.test.calc.abstractfixcalc;

public class CalcFixHardFactory implements FactoryCalc {
    @Override
    public CalcFix createCalcFix() {
        return new CalcFixHard();
    }
}
