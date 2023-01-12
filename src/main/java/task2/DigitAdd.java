package task2;

import java.util.ArrayList;

public class DigitAdd {
    public static int transform(int number){
        ArrayList digits = new ArrayList();
        while(number > 0){
            int digit = number%10 + 1;
            digits.add(digit);
            number /= 10;
        }
        StringBuilder newNumber = new StringBuilder();
        for(int i = digits.size()-1; i>=0;i--){
            newNumber.append(digits.get(i));
        }
        return Integer.valueOf(newNumber.toString());
    }

    public static void main(String[] args) {
        System.out.println(transform(153));
    }
}
