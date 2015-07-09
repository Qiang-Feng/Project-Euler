import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main
{
    public static String[] characters;

    public static char first = 'a';
    public static char second = 'a';
    public static char third = 'a';

    public static void main(String[] args)
    {
        try
        {
            byte[] encoded = Files.readAllBytes(Paths.get("N:/Project Euler/XOR/src/cipher.txt"));
            characters = new String(encoded).split(",");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        boolean finished = false;

        do
        {
            String finalOutput = "";
            char secretChar = 'a';
            int position = 1;

            for (String number : characters)
            {
                switch (position)
                {
                    case 1:
                        secretChar = first;
                        break;

                    case 2:
                        secretChar = second;
                        break;

                    case 3:
                        secretChar = third;
                        break;
                }

                if (position == 3)
                {
                    position = 1;
                }
                else
                {
                    position += 1;
                }

                finalOutput += (char) (Integer.parseInt(number) ^ (int) secretChar);
            }

            if (finalOutput.contains(" and "))
            {
                int total = 0;
                char[] totalArr = finalOutput.toCharArray();
                for (int number : totalArr)
                {
                    total += number;
                }
                System.out.println(total);
                System.out.println(finalOutput);
                //finished = true;
            }
            else
            {
                System.out.println(finalOutput);
            }

            if (third == 'z')
            {
                third = 'a';

                if (second < 'z')
                {
                    second += 1;
                }
                else
                {
                    second = 'a';

                    if (first < 'z')
                    {
                        first += 1;
                    }
                    else
                    {
                        //finished = true;
                    }
                }
            }
            else
            {
                third += 1;
            }
        }
        while (!finished);
    }
}