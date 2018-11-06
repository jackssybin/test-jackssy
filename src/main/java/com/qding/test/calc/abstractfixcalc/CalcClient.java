package com.qding.test.calc.abstractfixcalc;

public class CalcClient {

    public static void main(String[] args){
        FactoryCalc factory;
        String formula="[iasdfa]";
        factory = new CalcFixEasyFactory();

        factory.createCalcFix().calcFixFromFormula("");

        factory = new CalcFixHardFactory();
        factory.createCalcFix().calcFixFromFormula("");
    }
}
