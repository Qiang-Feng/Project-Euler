import java.math.BigInteger;

public class Main
{
    public static int sum = 0;

    public static void main(String[] args)
    {
        for (int i = 2; i <= 99; i++)
        {
            for (int j = 2; j <= 99; j++)
            {
                String number = String.valueOf(new BigInteger(String.valueOf(i)).pow(j));
                int tempSum = 0;

                for (char num : number.toCharArray())
                {
                    tempSum += Integer.parseInt(String.valueOf(num));
                }

                if (tempSum > sum)
                {
                    sum = tempSum;
                }
            }
        }

        System.out.println(sum);
    }
}
