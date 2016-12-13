/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package hashtableassgn;

/**
 *
 * Vicky Lym
 * November 24, 2016
 */

// import java.util.*;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.io.FileWriter;
// import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;
  
 /* Class SSLNode */
 class SSLNode
 {    
     SSLNode left, right, parent;
     int data;
     String region;
     String state;
 
     /* Constructor */
     public SSLNode()
     {
         left = null;
         right = null;
         parent = null;
         data = 0;
         region = "";
         state = "";
     }
     /* Constructor */
     public SSLNode(int n, String rgn, String states)
     {
         left = null;
         right = null;
         parent = null;
         data = n;
         region = rgn;
         state = states;
     }     
 }    

/*  Vicky add more code
*/
     /* Class SSLNodeRegion */
 class SSLNodeR
 {    
     SSLNodeR leftR, rightR, parentR;
     String regionR;
     int dataR;
     String stateR;

 
     /* Constructor */
     public SSLNodeR()
     {
         leftR = null;
         rightR = null;
         regionR = "";
         dataR = 0;
         stateR = "";
     }
     /* Constructor */
     public SSLNodeR(String rgn, int n, String states)
     {
         leftR = null;
         rightR = null;
         regionR = rgn;
         dataR = n;
         stateR = states;
     }     
 }

class HashTableMethods
{
     public SSLNode root; 
     private Hashtable<Integer, SSLNode> table = new Hashtable<>();
   
   //Empty Constructor
   HashTableMethods() {}
   
   /*
      Hash algorithm used for string values
   */
   public int hashCode(String key)
   {
      int hash = 7; 
      
      for(int i = 0; i < key.length(); i++)
      {
         hash = hash * 31 + key.charAt(i);
      }
      
      return hash;  
   }
   
   public void insert(int key, SSLNode nodeVal, int n, String rgn, String states ) 
   {
      nodeVal = new SSLNode(n, rgn, states); 
      table.put(key, nodeVal);
   }
   
   public void delete(int key)
   {
      table.remove(key);
   }
   
   public boolean search(int key)
   {
      return table.containsKey(key);  
   }
   
   public SSLNode getValue(int key)
   {
      SSLNode nodeValue = table.get(key);
      return nodeValue;
   }
}

class HashTableMethodsR
{
     private SSLNodeR rootR; 
     private Hashtable<Integer, SSLNodeR> tableR = new Hashtable<>();
   
   //Empty Constructor
   HashTableMethodsR() {}
   
   /*
      Hash algorithm used for string values
   */
   public int hashCodeR(String keyR)
   {
      int hashR = 7; 
      
      for(int i = 0; i < keyR.length(); i++)
      {
         hashR = hashR * 31 + keyR.charAt(i);
      }
      
      return hashR;  
   }
   
   public void insertR(int keyR, SSLNodeR nodeValR, String rgn, String dma, String states) 
   {
      int dmaInt = Integer.parseInt(dma);
      nodeValR = new SSLNodeR(rgn, dmaInt, states); 
      tableR.put(keyR, nodeValR);
   }
   
   public void deleteR(int keyR)
   {
      tableR.remove(keyR);
   }
        /* Functions to search for an element */
     public boolean searchR(int keyR1, String regionStr)
     {
         boolean foundRegion = false;
         boolean result = false;
         foundRegion = searchR(keyR1, regionStr, result);
         return foundRegion;
     }
   public boolean searchR(int keyR, String regionStr, boolean again)
   {
         boolean foundR1 = false;
         String cvsSplitBy3 = ",";
         String[] piecesStr = regionStr.split(cvsSplitBy3);
         int sizeOfStrInput = piecesStr.length;
         String newRegionStr = "";
         if (!(sizeOfStrInput == 0))
         {   
             for (int i = 0; i < sizeOfStrInput; i++)
             {
               if (i == 0)
                  newRegionStr = newRegionStr + piecesStr[i];
               else
                newRegionStr = newRegionStr + " " + piecesStr[i];
             }
             regionStr = newRegionStr;
         }
       
         return foundR1;  
   }
   
   public boolean searchR1(int key)
   {
      return tableR.containsKey(key);  
   }
   
   public SSLNodeR getValueR(int keyR)
   {
      SSLNodeR nodeValueR = tableR.get(keyR);
      return nodeValueR;
   }
}
 
 /* Class SelfBalancingBinarySearchTreeTest */

// public class SelfBalancingBinarySearchTreeTest
public class HashTableAssgn
{   
    public static void main(String[] args)
    {            
        HashTableMethods hashTableF = new HashTableMethods();
        HashTableMethodsR hashTableFR = new HashTableMethodsR();

        SSLNode ssl6 = new SSLNode();
        SSLNodeR ssl7 = new SSLNodeR();
        
        boolean found = false;
        boolean foundR = false;

        System.out.println("\nHash Table Assignment");          
        char ch;
        int numberOfCollisions = 0;
        
        int[] metricsVal = new int[2];
        int[] metricsValR = new int[2];
        String cvsSplitBy2 = ",";
        String cvsSplitBy4 = "?";
        // String lineNxt = " ";

        int lenRegion = 0;
        String fileName = "dma.txt";
        
        int collisions = 0;
        int collisionsR = 0;
        
        int lenMaxRegion = 0;
        long cpuTime = 0;
        lenMaxRegion = readFile(fileName, hashTableF, hashTableFR, collisions, collisionsR);
                
        /*  Perform tree operations  */
        Scanner keyboardInput = new Scanner(System.in);
        // Scanner scan = new Scanner(System.in).useDelimiter(cvsSplitBy2);

        do    
        {
            System.out.println("\n Hash Table Operations\n");
            // System.out.println("Choose 0 for list of statistics from file input");
            // System.out.println(" ");
            System.out.println("Following are options for the DMA Code Key List");
            System.out.println("1. insert");
            System.out.println("2. search");
            System.out.println("3. delete from");
            System.out.println(" ");
            System.out.println("Following are options for the Region Key List");
            System.out.println("4. insert");
            System.out.println("5. search");
            System.out.println("6. delete from");
            
            int choice = keyboardInput.nextInt();            
            switch (choice)
            {
            case 0 :      
                System.out.println();    
                break;        
            case 1 : 
                System.out.println("Enter DMA code, Region, and State element separated by commas to insert");
                System.out.println("For Region, Replace any space with a comma.");
                System.out.println("Region will be case sensitive.");
                String lineNxt = keyboardInput.next();
                String[] pieces = lineNxt.split(cvsSplitBy2);
                boolean stoploop = false;

                int sizeOfInput = pieces.length;
                String piecesState = "";
                if (sizeOfInput == 3)
                    piecesState = pieces[2];
                else
                {
                    int sizeOfRegionInput = sizeOfInput - 2;
                    int sizeOf2ndInput = 2;
                    
                    if (sizeOfRegionInput > 1)
                    {
                        for (int i = 2; i < sizeOfRegionInput+1; i++)
                        {
                            if (i < sizeOfRegionInput+1)
                                pieces[1] = pieces[1] + " ";
                            pieces[1] = pieces[1] + pieces[i];
                            sizeOf2ndInput = sizeOf2ndInput + 1;
                        }
                    }
                    piecesState = pieces[sizeOf2ndInput];
                }               
                try {
                int dmacode = Integer.parseInt(pieces[0]);
   
                lenRegion = (pieces[1].length());
                if (lenMaxRegion < lenRegion)
                   lenMaxRegion = lenRegion;
                
                if (hashTableF.search(dmacode))
                {
                   collisions ++;
                }

                hashTableF.insert(dmacode, ssl6, dmacode, pieces[1], pieces[2]);
 
                } catch (Exception e)
                {     
                // dma code,region,state
                    System.out.println("First line of input is bad data or Headings");
                    System.out.println("Will read second record to see if valid data");
                }
                // sbbst.insert( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter DMA Code element to search");
                boolean foundDMACode = false; 
                int dmaCodeInput = keyboardInput.nextInt();
                foundDMACode = hashTableF.search( dmaCodeInput );
                if (foundDMACode)
                {
                   ssl6 = hashTableF.getValue(dmaCodeInput);
                   String regionNameS = ssl6.region;
                   String stateNameS = ssl6.state;
                                     
                   System.out.println("Search result : (" + dmaCodeInput + ") Found " + regionNameS + "," + stateNameS);
                }
                else
                    System.out.println("Search result : " + dmaCodeInput + "NOT Found");                  
                break;                                            
       
            case 3 : 
                System.out.println("Enter DMA code to delete");
                int dmaCodeInt = keyboardInput.nextInt();            
                boolean foundInt = false;
                if (foundInt != hashTableF.search(dmaCodeInt))
                {
                   System.out.println("Found DMA Code (" + dmaCodeInt + ") Will Delete it");
                   hashTableF.delete(dmaCodeInt);
                   System.out.println("Is DMA Code (" + dmaCodeInt + ") still in table? " + hashTableF.getValue(dmaCodeInt));
                }
                else
                {
                   System.out.println("DMA Code (" + dmaCodeInt + ") NOT Found in table...CANNOT Delete it");
                } 
                break; 
                
            case 4 : 
                String regionNameR1 = "";
                int dmaCodeR1 = 0;
                String dmaCodeRS1 = "";
                String stateNameR1 = "";
                int sizeOfInputRegionR1 = 0;
                System.out.println("Enter Region, DMA Code, and State element separated by commas to insert");
                System.out.println("For Region, Replace any space with a comma.");
                System.out.println("Region will be case sensitive.");
                String lineNxtR = keyboardInput.next();
                String[] piecesR1 = lineNxtR.split(cvsSplitBy2);
                boolean stoploopR = false;

                int sizeOfInputR1 = piecesR1.length;
                String piecesStateR1 = "";
                if (sizeOfInputR1 == 3)
                {
                    regionNameR1 = piecesR1[0];
                    dmaCodeRS1 = piecesR1[1];
                    stateNameR1 = piecesR1[2];  
                }
                else
                {
                    sizeOfInputRegionR1 = sizeOfInputR1 - 2;
                    dmaCodeRS1 = piecesR1[sizeOfInputRegionR1];
                    stateNameR1 = piecesR1[sizeOfInputRegionR1+1];
                    for (int i = 0; i < sizeOfInputRegionR1; i++)
                    {
                        if ((i < sizeOfInputRegionR1) && (i != 0))
                           regionNameR1 = regionNameR1 + " ";  
                        regionNameR1 = regionNameR1 + piecesR1[i];

                    }
                }              
                try {
                boolean duplicateRegion = false;
                lenRegion = (regionNameR1.length());
                if (lenMaxRegion < lenRegion)
                   lenMaxRegion = lenRegion;
                
                int hashRegion = hashTableFR.hashCodeR(regionNameR1);
                
                boolean foundRegn = false;
         
                if (foundRegn != hashTableFR.searchR1(hashRegion))
                {
                   collisionsR ++;
                }

                hashTableFR.insertR(hashRegion, ssl7, regionNameR1, dmaCodeRS1, stateNameR1);
 
                } catch (Exception e)
                {     
                // dma code,region,state
                    System.out.println("First line of input is bad data or Headings");
                    System.out.println("Will read second record to see if valid data");
                }
                break;                
                
            case 5 : 
                System.out.println("Enter Region element to search. Replace any space with a comma.");
                System.out.println("Case sensitive, too.");    
                String searchItemRB = keyboardInput.next();
                String[] piecesRD = searchItemRB.split(cvsSplitBy2); 
                int sizeOfInputRD = piecesRD.length;
                String searchItemR = "";
                for (int i = 0; i < sizeOfInputRD; i++)
                {
                    if ((i < sizeOfInputRD) && (i != 0))
                        searchItemR = searchItemR + " ";    
                    searchItemR = searchItemR + piecesRD[i];
                } 
                
                int hashRegionS = hashTableFR.hashCodeR(searchItemR);
                
                boolean foundRegn = false;

                if(foundRegn != hashTableFR.searchR1(hashRegionS))
                {
                   ssl7 = hashTableFR.getValueR(hashRegionS);
                   String regionNameSD = ssl7.regionR;
                   String stateNameSD = ssl7.stateR;
                   int dmaCodeData = ssl7.dataR;
                  System.out.println("Search result : " + searchItemR + "," + stateNameSD + " Found (" + dmaCodeData +")");
                }
                else
                    System.out.println("Search result : " + searchItemR + "NOT Found"); 
       
                break;    
 
            case 6 :                
                System.out.println("Enter Region element to delete. Replace any space with a comma.");
                System.out.println("Case sensitive, too.");    
                String deleteItemR = keyboardInput.next();
                String[] piecesRD1 = deleteItemR.split(cvsSplitBy2); 
                int sizeOfInputRD1 = piecesRD1.length;
                deleteItemR = "";
                for (int i = 0; i < sizeOfInputRD1; i++)
                {
                    if ((i < sizeOfInputRD1) && (i != 0 ))
                        deleteItemR = deleteItemR + " ";
                    deleteItemR = deleteItemR + piecesRD1[i];                    
                } 
                
                int hashRegionD = hashTableFR.hashCodeR(deleteItemR);
                
                boolean foundRegn1 = false;

                if(foundRegn1 != hashTableFR.searchR1(hashRegionD))
                {
                  ssl7 = hashTableFR.getValueR(hashRegionD);
                  String regionNameSDR = ssl7.regionR;
                  String stateNameSDR = ssl7.stateR;
                  int dmaCodeDataR = ssl7.dataR;
                  System.out.println(deleteItemR + " was found, its value is: " + regionNameSDR + "," + stateNameSDR + " (" + dmaCodeDataR +")");
                  System.out.println("Found Region " + deleteItemR + " Will Delete it");
                  hashTableFR.deleteR(hashRegionD);
                  System.out.println("Is Region " + deleteItemR + "still in table? " + hashTableFR.searchR1(hashRegionD));
                }
                else
                {
                  System.out.println(deleteItemR + " was NOT found, therefore no value");
                 } 

                break;    

            default : 
                System.out.println("Wrong Entry \n "); 
                break;   
            }

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = keyboardInput.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
        keyboardInput.close();
    }
    
    public static int readFile(String fileNm, HashTableMethods hashTableF1, HashTableMethodsR hashTableFR1, int collisionsRF, int collisionsRF1)
    {   
        SSLNode ssl8 = new SSLNode();
        SSLNodeR ssl9 = new SSLNodeR(); 
        int rowsCols = 100;
        String[] multDMA = new String[rowsCols + rowsCols + rowsCols];   
        String[] multRegion = new String[rowsCols + rowsCols + rowsCols];
        int indxDMA = 0;
        int indxRegion = 0;
        int tempIndx = 0;
        String tempInt;
 
        double estimatedTime = 0;
        int regionLenMax = 0;
        int regionLen = 0;

        int recCount = 0;

        String s = "";
        String cvsSplitBy = ",";
        String line = " ";

        File file = new File(fileNm);
        // File homedir = new File(System.getProperty("user.home"));
        // System.getProperties().list(System.out);
        
        // String path = System.getProperty("user.dir");
        // String otherFolder = path + "\\other";
        // System.out.println("dmatxt file path" + otherFolder);
        
        try {
            long startTime = System.nanoTime(); 
            Scanner fileScan = new Scanner(file);
            do 
            {
                line = fileScan.nextLine();	// get the first line of the file
                // process the current line by adding it to the array
                String[] piecesF = line.split(cvsSplitBy);
                try {
                    int dmacodeF = Integer.parseInt(piecesF[0]);
                    regionLen = (piecesF[1].length());
                    if (regionLenMax < regionLen)
                       regionLenMax = regionLen;
                    recCount = recCount + 1;
                    // ssl8 = SSLNode(dmacodeF, piecesF[1], piecesF[2]);
                    if (hashTableF1.search(dmacodeF))
                    {
                        collisionsRF++;
                    }
                    hashTableF1.insert(dmacodeF, ssl8, dmacodeF, piecesF[1], piecesF[2]);
                    int regionKey = 0;
                    String stophere = "";
                    regionKey = hashTableFR1.hashCodeR(piecesF[1]);
                    // if (piecesF[1].equals("Columbus"))
                    //    stophere = "yes";
                    
                    if (hashTableFR1.searchR1(regionKey))
                    {
                        collisionsRF1++;
                    }
                    String dmacodeFS = Integer.toString(dmacodeF);
                    hashTableFR1.insertR(regionKey, ssl9, piecesF[1], dmacodeFS, piecesF[2]);   
                    
                } catch (Exception e)
                {     
                      // dma code,region,state
                      System.out.println("\nFirst line of input is bad data or Headings");
                      System.out.println("Will read second record to see if valid data");
                }
       
                // get the next line until the entire file has been read
            } while (fileScan.hasNextLine());
            long stopTime = System.nanoTime();
            estimatedTime = (stopTime - startTime) / 1000000.0;
            System.out.println("\nCPU Time is combination of DMA Code and Region Key Order");
            System.out.println("CPU Time is " + estimatedTime + " milliseconds");
            
            System.out.println("\nPart 3 - Key as DMA Code with " + collisionsRF + " collisions");
            System.out.println("Part 4 - Key as Region with " + collisionsRF1 + " collisions");
            
            System.out.printf("\nNumber of Records read %,d \n", recCount);

            fileScan.close();

            // return regionLenMax;
        // } catch (FileNotFoundException e) {
        } catch (Exception e) {
            System.out.println("Exception reading " + fileNm);
            e.printStackTrace();
        }

        return regionLenMax;
    }
}


