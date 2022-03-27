package erik.soekov;

public class Money {

    private int integralPart;
    private int decimalPart;


    public Money(int integralPart, int decimalPart) {
        this.integralPart = integralPart;
        this.decimalPart = decimalPart;
    }

    public int getIntegralPart() {
        return integralPart;
    }

    public int getDecimalPart() {
        return decimalPart;
    }
}
