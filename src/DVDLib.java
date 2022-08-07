import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.in;
import static java.lang.System.out;

public class DVDLib
{
    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<String[]> libDVD1 = new ArrayList<String[]>();
        libDVD1 = Reader.read();

        //create a client

        Client client1 = new Client();
        int clientNum;
        int numberDVD;
        ArrayList<ArrayList<String[]>> clients = new ArrayList<ArrayList<String[]>>();


        for (; ; )
        {
            out.println("Menu: " + "\n" + "1.Create new client" + "\n" + "2.Add DVD to particular client" + "\n" +
                    "3.Give back a particular DVD from particular client" + "\n" + "4.Print library's state" + "\n " + "5.Print clients");
            String selection = input.nextLine();
            switch (selection)
            {
                case "1":
                    clientNum = clients.size();
                    System.out.println("Choose DVD's number to borrow");
                    String newLine = input.nextLine();
                    numberDVD = Integer.parseInt(newLine);
                    clients.add( client1.newClient(clientNum, libDVD1, numberDVD-1 ));
                    libDVD1.set(numberDVD-1, (Reader.modifyMinus(libDVD1, numberDVD-1)));
                    break;

                case "2":

                    System.out.println("Choose client");
                    newLine = input.nextLine();
                    clientNum = Integer.parseInt(newLine)-1;
                    System.out.println("Choose DVD's number to borrow");
                    newLine = input.nextLine();
                    numberDVD = Integer.parseInt(newLine)-1;
                    clients.set(clientNum, (ArrayList<String[]>) client1.addToClient(clients.get(clientNum), libDVD1, numberDVD));
                    libDVD1.set(numberDVD, (Reader.modifyMinus(libDVD1, numberDVD)));
                    break;

                case "3":
                    //give dvd back
                    clients.set(0, (ArrayList<String[]>) client1.giveBack(clients.get(0), "Rancho"));
                    libDVD1.set(client1.getIndex()-2, (Reader.modifyPlus(libDVD1, client1.getIndex()-2))) ;
                    break;

                case "4":
                    Reader.print(libDVD1);
                    break;

                case "5":
                    Client.printClients (clients);
                    break;



            }

        }





    }
}
