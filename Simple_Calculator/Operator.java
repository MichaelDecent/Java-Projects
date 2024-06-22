public class Operator {
    protected double value1;
    protected double value2;
    protected String ops;


    public void setOps(String operator) {
        this.ops = operator;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }

    public double add(double value1, double value2) {
        return value1 + value2;
    }

    public double subtract(double value1, double value2) {
        return value1 - value2;
    }

    public double multiply(double value1, double value2) {
        return value1 * value2;
    }

    public double divide(double value1, double value2) {
        return value1 / value2;
    }

    public double modulus(double value1, double value2) {
        return value1 % value2;
    }

}