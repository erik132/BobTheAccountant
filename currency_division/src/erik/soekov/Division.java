package erik.soekov;

import java.util.ArrayList;
import java.util.List;

public class Division {

    //Big decimal isn't in 2 parts as I hoped but more floatlike, otherwords inaccurate
    //difference between test cases 10, 7 and 10.01, 7 is a good example why.
    /*private static List<BigDecimal> currencyDivision(BigDecimal money, int people){
        List<BigDecimal> result = new ArrayList<>();
        if(people == 0){
            return result;
        }
        if(people == 1){
            result.add(money);
            return result;
        }
        int iterations = 0;
        BigDecimal hundred = new BigDecimal(100);
        BigDecimal fraction = new BigDecimal(0.01);
        BigDecimal bloated = money.multiply(hundred);
        BigDecimal surplus = new BigDecimal(bloated.intValue() % people);
        BigDecimal slice = bloated.subtract(surplus).divide(new BigDecimal(people), RoundingMode.HALF_UP).divide(hundred);

        for(; iterations < surplus.intValue(); iterations++) {
            result.add(slice.add(fraction));
        }
        for(; iterations < people; iterations++) {
            result.add(slice);
        }


        return result;
    }*/

    /**
     * The easy way to do this, but may not work in all cases where division can yield for example
     * 6.999999999 instead of 7 before integer conversion. The correct way to store money would be more like
     * class Money where the integral and decimal parts are separate, but I'm not really in a mood to define an
     * accurate and corrected division mechanic for this.
     */
    public static List<Double> currencyDivision(Double money, int people) {
        List<Double> result = new ArrayList<>();
        if (people == 0) {
            return result;
        }
        if (people == 1) {
            result.add(money);
            return result;
        }
        int iterations = 0;
        int bloated = (int) (money * 100);
        int surplus = bloated % people;
        Double slice = (double) ((bloated - surplus) / people) / 100;

        for (; iterations < surplus; iterations++) {
            result.add(slice + 0.01);
        }
        for (; iterations < people; iterations++) {
            result.add(slice);
        }

        return result;
    }

    public static void main(String[] args) {
        /*List<BigDecimal> result1 = currencyDivision(new BigDecimal(4),2);
        result1.stream().forEach(System.out::println);
        System.out.println("-------------------------------------");
        List<BigDecimal> result2 = currencyDivision(new BigDecimal(10),7);
        result2.stream().forEach(System.out::println);
        System.out.println("-------------------------------------");
        List<BigDecimal> result3 = currencyDivision(new BigDecimal(10.10),1);
        result3.stream().forEach(System.out::println);
        System.out.println("-------------------------------------");
        List<BigDecimal> result4 = currencyDivision(new BigDecimal(10.01),7);
        result4.stream().forEach(System.out::println);*/

        List<Double> result1 = currencyDivision(4.0, 2);
        result1.stream().forEach(System.out::println);
        System.out.println("-------------------------------------");
        List<Double> result2 = currencyDivision(10.0, 7);
        result2.stream().forEach(System.out::println);
        System.out.println("-------------------------------------");
        List<Double> result3 = currencyDivision(10.10, 1);
        result3.stream().forEach(System.out::println);
        System.out.println("-------------------------------------");
        List<Double> result4 = currencyDivision(10.01, 7);
        result4.stream().forEach(System.out::println);
        System.out.println("-------------------------------------");
        List<Double> result5 = currencyDivision(10.10, 7);
        result5.stream().forEach(System.out::println);

    }
}
