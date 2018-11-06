package com.qding.test.calc.abstractfixcalc;

public class CalcException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = -7873121326386072548L;
    private String code;

    public CalcException(String message) {
        super(message);
    }

    public CalcException(String code,String message) {
        super(message);
        this.code=code;
    }
}
