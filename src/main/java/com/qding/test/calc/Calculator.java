package com.qding.test.calc;
import com.qding.test.calc.abstractfixcalc.CalcException;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  算数表达式求值
 *  直接调用Calculator的类方法conversion()
 *  传入算数表达式，将返回一个浮点值结果
 *  如果计算过程错误，将返回一个NaN
 */
public class Calculator {

    DecimalFormat dFormat = new DecimalFormat("#.0000");
    // 后缀式栈
    private Stack<String> postfixStack = new Stack<String>();
    // 运算符栈
    private Stack<Character> opStack = new Stack<Character>();
    // 运用运算符ASCII码-40做索引的运算符优先级
    private int[] operatPriority = new int[] { 0, 3, 2, 1, -1, 1, 0, 2 };

    public static Double conversion(String expression) {
        double result = 0;
        Calculator cal = new Calculator();
        try {
            expression = transform(expression);
            result = cal.calculate(expression);
        } catch (Exception e) {
            // e.printStackTrace();
            // 运算错误返回NaN
            return 0.0 / 0.0;
        }
        return result;
    }

    /**
     * 将表达式中负数的符号更改
     *
     * @param expression
     *            例如-2+-1*(-3E-2)-(-1) 被转为 ~2+~1*(~3E~2)-(~1)
     * @return
     */
    private static String transform(String expression) {
        char[] arr = expression.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '-') {
                if (i == 0) {
                    arr[i] = '~';
                } else {
                    char c = arr[i - 1];
                    if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == 'E' || c == 'e') {
                        arr[i] = '~';
                    }
                }
            }
        }
        if(arr[0]=='~'||arr[1]=='('){
            arr[0]='-';
            return "0"+new String(arr);
        }else{
            return new String(arr);
        }
    }

    /**
     * 按照给定的表达式计算
     * @param expression
     *            要计算的表达式例如:5+12*(3+5)/7
     * @return
     */
    public double calculate(String expression)throws CalcException {
        Stack<String> resultStack = new Stack<String>();
        prepare(expression);
        // 将后缀式栈反转
        Collections.reverse(postfixStack);
        // 参与计算的第一个值，第二个值和算术运算符
        String firstValue, secondValue, currentValue;
        while (!postfixStack.isEmpty()) {
            currentValue = postfixStack.pop();
            // 如果不是运算符则存入操作数栈中
            if (!isOperator(currentValue.charAt(0))) {
                currentValue = currentValue.replace("~", "-");
                resultStack.push(currentValue);
            } else {// 如果是运算符则从操作数栈中取两个值和该数值一起参与运算
                secondValue = resultStack.pop();
                firstValue = resultStack.pop();

                // 将负数标记符改为负号
                firstValue = firstValue.replace("~", "-");
                secondValue = secondValue.replace("~", "-");

                String tempResult = calculate(firstValue, secondValue, currentValue.charAt(0));
                resultStack.push(tempResult);
}
        }
                return getFormatDecimal(Double.valueOf(resultStack.pop()));
                }

    /**
     * 数据准备阶段将表达式转换成为后缀式栈
     * @param expression
     */
    private void prepare(String expression) {
        // 运算符放入栈底元素逗号，此符号优先级最低
        opStack.push(',');
        char[] arr = expression.toCharArray();
        // 当前字符的位置
        int currentIndex = 0;
        // 上次算术运算符到本次算术运算符的字符的长度便于或者之间的数值
        int count = 0;
        // 当前操作符和栈顶操作符
        char currentOp, peekOp;

        for (int i = 0; i < arr.length; i++) {
            currentOp = arr[i];
            // 如果当前字符是运算符
            if (isOperator(currentOp)) {
                if (count > 0) {
                    // 取两个运算符之间的数字
                    postfixStack.push(new String(arr, currentIndex, count));
                }
                peekOp = opStack.peek();
                // 遇到反括号则将运算符栈中的元素移除到后缀式栈中直到遇到左括号
                if (currentOp == ')') {
                    while (opStack.peek() != '(') {
                        postfixStack.push(String.valueOf(opStack.pop()));
                    }
                    opStack.pop();
                } else {
                    while (currentOp != '(' && peekOp != ',' && compare(currentOp, peekOp)) {
                        postfixStack.push(String.valueOf(opStack.pop()));
                        peekOp = opStack.peek();
                    }
                    opStack.push(currentOp);
                }
                count = 0;
                currentIndex = i + 1;
            } else {
                count++;
            }
        }
        // 最后一个字符不是括号或者其他运算符的则加入后缀式栈中
        if (count > 1 || (count == 1 && !isOperator(arr[currentIndex]))) {
            postfixStack.push(new String(arr, currentIndex, count));
        }

        while (opStack.peek() != ',') {
            // 将操作符栈中的剩余的元素添加到后缀式栈中
            postfixStack.push(String.valueOf(opStack.pop()));
        }
    }

    /**
     * 判断是否为算术符号
     *
     * @param c
     * @return
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }

    /**
     * 利用ASCII码-40做下标去算术符号优先级
     * @param cur
     * @param peek
     * @return
     */
    public boolean compare(char cur, char peek) {// 如果是peek优先级高于cur，返回true，默认都是peek优先级要低
        boolean result = false;
        if (operatPriority[(peek) - 40] >= operatPriority[(cur) - 40]) {
            result = true;
        }
        return result;
    }

    /**
     * 按照给定的算术运算符做计算
     * @param firstValue
     * @param secondValue
     * @param currentOp
     * @return
     */
    private String calculate(String firstValue, String secondValue, char currentOp) {
        String result = "";
        switch (currentOp) {
            case '+':
                result = String.valueOf(ArithHelper.add(firstValue, secondValue));
                break;
            case '-':
                result = String.valueOf(ArithHelper.sub(firstValue, secondValue));
                break;
            case '*':
                result = String.valueOf(ArithHelper.mul(firstValue, secondValue));
                break;
            case '/':
                result = String.valueOf(ArithHelper.div(firstValue, secondValue));
                break;
        }
        return result;
    }

    private double getFormatDecimal(double num) {
        String yearString = dFormat.format(num);
        Double temp = Double.valueOf(yearString);
        return temp;
    }

    public static boolean judgeExpression(String formula){
        if(judgeContainsStr(formula)){
            System.out.println("公式中不能包含字母");
            return false;
        }
        int top = 0;// 计数，左括号 1，右括号 -1，最后总和0则匹配
        boolean flag = true;// true 表示匹配
         formula = "(((1+(2)-6))";// 表达式
        formula="[index]/[index1]+[index2]";
        char[] biao = formula.toCharArray();// 将字符串转化成字符数组
        System.out.println("表达式:      " + formula);
        // 遍历表达式中所有字符
        for (int i = 0; i < biao.length; i++){
            // 如果是(则加1，进栈
            if (biao[i] == '('||biao[i] == '['){
                top++;
            }else if (biao[i] == ')'||biao[i] == ']'){// 如果是)则-1，出栈
                if (!(top == 0)){
                    top--;
                }
                else {//top == 0,无左括号却有一个右括号，有一个右括号不匹配
                    System.out.println("括号不匹配 - -");
                    flag = false;
                    break;
                }
            }else if(biao[i] == '+'||biao[i] == '-'||biao[i] == '*'||biao[i] == '/'){
                if(i==0){
                    flag = false;
                    System.out.println("运算符不能在表达式开始");
                    break;
                }else if(i==biao.length-1){
                    flag = false;
                    System.out.println("运算符不能在表达式末尾");
                    break;
                }
            }
        }
        System.out.println("----");

        // 循环结束时两种可能
        if (top == 0 && flag){
            System.out.println("括号匹配");// 出循环stack空
        }
        else if (top != 0 && flag){
            System.out.println("括号不匹配");// 出循环时stack不空
        }
        return flag ;
    }

    /**
     * 该方法主要使用正则表达式来判断字符串中是否包含字母
     * @author fenggaopan 2015年7月21日 上午9:49:40
     * @param cardNum 待检验的原始卡号
     * @return 返回是否包含
     */
    public static boolean judgeContainsStr(String cardNum) {
        String regex=".*[a-zA-Z]+.*";
        Matcher m= Pattern.compile(regex).matcher(cardNum);
        return m.matches();
    }

}