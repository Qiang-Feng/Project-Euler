import java.math.BigInteger;

public class Main
{
    public static void main(String[] args)
    {
        int total = 0;
        String sum = String.valueOf(new BigInteger(String.valueOf(2)).pow(1000));

        for (char num : sum.toCharArray())
        {
            total += Integer.parseInt(String.valueOf(num));
        }

        System.out.println(total);
    }
}
