package ru.gb.domain;

public class Calculator {
    private double firstNum = 0;
    private double secondNum = 0;
    private double result = 0;
    private int oper = 1;

    public Calculator() {
    }

    public double getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public double getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    public double getResult() {
        switch (this.oper) {
            case 1:
                this.result = this.firstNum + this.secondNum;
                break;
            case 2:
                this.result = this.firstNum - this.secondNum;
                break;
            case 3:
                this.result = this.firstNum / this.secondNum;
                break;
            case 4:
                this.result = this.firstNum * this.secondNum;
                break;
        }
        return result;
    }

    public int getOper() {
        return oper;
    }

    public void setOper(int oper) {
        this.oper = oper;
    }
}
