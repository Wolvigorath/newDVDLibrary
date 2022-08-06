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
        ArrayList<String[]> libDVD1 = new ArrayList<String[]>();
        libDVD1 = Reader.read();

        //create a client

        Client client1 = new Client();
        int clientNum=1;
        int numberDVD=3;
        ArrayList<ArrayList<String[]>> clients = new ArrayList<ArrayList<String[]>>();
        clientNum = clients.size();
        clients.add( client1.newClient(clientNum, libDVD1, numberDVD-1 ));
        libDVD1.set(numberDVD-1, (Reader.modifyMinus(libDVD1, numberDVD-1)))  ;
        clients.set(clientNum, (ArrayList<String[]>) client1.addToClient(clients.get(clientNum), libDVD1, numberDVD));
        libDVD1.set(numberDVD, (Reader.modifyMinus(libDVD1, numberDVD)))  ;

        //give dvd back
        clients.set(0, (ArrayList<String[]>) client1.giveBack(clients.get(0), "Rancho"));
        libDVD1.set(client1.getIndex()-2, (Reader.modifyPlus(libDVD1, client1.getIndex()-2)))  ;
    }
}
