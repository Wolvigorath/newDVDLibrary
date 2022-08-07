import java.lang.reflect.Array;
import java.util.ArrayList;

public class Client
{
    public int numberOf = 0;
    private int index;

    public ArrayList<String []> newClient (int clientNumber, ArrayList <String []> libDVD, int DVDnumber)
    {
        String [] libDVDtemp = new String[3];
        libDVDtemp = libDVD.get(DVDnumber);
        String [] clientBody = new String[4];
        clientBody[0] = String.valueOf(clientNumber);
        clientBody[1]= libDVDtemp [0];
        clientBody[2] = libDVDtemp[1];
        clientBody[3] = String.valueOf(1);

        ArrayList <String []> theClient = new ArrayList<String[]>();
        theClient.add(0, clientBody);
        return theClient;
    }

    public Object addToClient (ArrayList <String []> clientOfNumber, ArrayList <String []> libDVD, int DVDnumber)
    {
        String [] libDVDtemp = new String[3];
        libDVDtemp = libDVD.get(DVDnumber);
        String [] clientBody = new String[4];
        clientBody[1]= libDVDtemp [0];
        clientBody[2] = libDVDtemp[1];
        clientBody[3] = String.valueOf(1);

        //ArrayList <String []> theClient = new ArrayList<String[]>();
        clientOfNumber.add(clientBody);
        return clientOfNumber;
    }

    public Object giveBack (ArrayList<String []> clientOfNumGb, String title)
    {
        //check if there is a DVD
        int g=0;
        int j=-1;
        for (int i=0; i<clientOfNumGb.size(); i++)
        {
            String [] clientTemp = new String[4];
            clientTemp = clientOfNumGb.get(i);
            if(clientTemp [2].equals(title))
            {
                g++;
                j = i;
            }
            else
            {
               // System.out.println("brak szukanego filmu");
            }
        index = Integer.parseInt(clientTemp[1]);
        }

        if (g>0 && j!=-1)
        {
           clientOfNumGb.remove(j);
        }
        return  clientOfNumGb;
    }

    public int getIndex ()
    {
        index = this.index;

        return index;
    }

    public static void printClients (ArrayList <ArrayList <String []>> listOfClients)
    {
        int size = listOfClients.size();

        for (int i=0; i< size; i++)
        {
            ArrayList <String []> particularClient = new ArrayList<String []>();
            particularClient = listOfClients.get(i);
            int partSize = particularClient.size();
            for (int g=0; g<partSize; g++)
            {
                String [] tabClient = new String[4];
                tabClient = particularClient.get(g);
                if (g==0)
                {
                    System.out.println(tabClient [0] + " " + tabClient [1] + " " + tabClient[2] + " " + tabClient [3] );
                }
                if (g>0)
                {
                    System.out.println(" " + " " + tabClient [1] + " " + tabClient[2] + " " + tabClient [3]);
                }

            }
        }
    }

}
