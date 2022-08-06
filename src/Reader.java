import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader
{
    public static ArrayList <String[]> read ()
    {
        //read file in with the start of the program
        ArrayList<String[]> libDVD = new ArrayList<String[]>();
        try (Scanner inFile1 = new Scanner(new File("C:\\programy\\Java\\Cwiczenia\\DVD Library\\DVDLib\\src\\DVDLibr.txt")))
        {

            while (inFile1.hasNext())
            {
                String [] tempLib = new String[3];
                tempLib [0] = inFile1.next();
                tempLib [1] = inFile1.next();
                tempLib [2] = inFile1.next();

                libDVD.add(tempLib);

            }
            inFile1.close();

        }
        catch (Exception e)
        {
            System.out.println("Się zesrało");
        }

        int sizeOfList = libDVD.size();
        int i;
        for (i = 0; i< sizeOfList; i++ )
        {
            String [] tempArr = new String[3];
            tempArr = libDVD.get(i);
            System.out.println(tempArr[0] + "  " + tempArr[1] + "  " + tempArr[2]  );
        }

        return libDVD;
    }

    public static String[] modifyMinus (ArrayList<String []> tempMinus, int number)
    {
        String [] tempMin = new String[3];
        tempMin=tempMinus.get(number);
        int tempNum = Integer.parseInt(tempMin[2]);
        if (tempNum>0)
        {
            tempNum--;
        }
        tempMin[2] = String.valueOf(tempNum);

        return tempMin;
    }

    public static String[] modifyPlus (ArrayList<String []> tempPlus, int number)
    {
        String [] tempPl = new String[3];
        tempPl=tempPlus.get(number);
        int tempNum = Integer.parseInt(tempPl[2]);
        tempNum++;
        tempPl[2] = String.valueOf(tempNum);

        return tempPl;
    }


}
