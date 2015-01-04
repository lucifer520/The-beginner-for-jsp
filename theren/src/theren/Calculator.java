package theren;

public class Calculator {

    // 字段根据表单来设计
    private double firstNumber;
    private double secondNumber;
    private double result;
    private char operator; // ‘+’

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public void calculate() {
        // 根据运算符 运算结果
        switch (this.operator) {
        case '+':
            this.result = this.firstNumber + this.secondNumber;
            break;
        case '-':
            this.result = this.firstNumber - this.secondNumber;
            break;
        case '*':
            this.result = this.firstNumber * this.secondNumber;
            break;
        case '/': {
            // 判断除数是否为0
            if (this.secondNumber == 0)
                throw new RuntimeException("除数不能为0");
            this.result = this.firstNumber / this.secondNumber;
            break;
        }
        default:
            // 不支持的运算
            throw new RuntimeException("不支持的运算符");
        }
    }
}
