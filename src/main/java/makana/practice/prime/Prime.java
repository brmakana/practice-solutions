package makana.practice.prime;

import java.math.BigInteger;

public class Prime {
    public void checkPrime(Integer... integers) {
        for (Integer i : integers) {
            if (BigInteger.valueOf(i).isProbablePrime(1)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }
}
