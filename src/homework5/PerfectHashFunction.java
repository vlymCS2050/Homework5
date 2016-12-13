/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package perfecthashfunction;

/**
 *
 * @author rMBP
 */
public class PerfectHashFunction {

   public static void main(String[]args) {
      int match;
      int temp[] = new int[10];
      char inputChar[] = new char[]{'S','E','A','R','C','H','X','M','P','L'};
      System.out.println(inputChar);
      for (int M = 10; M < 100; M++) {
         for (int a = 1; a < 100; a++) {
            for (int i = 0; i < inputChar.length;i++) {
               temp[i] = (a * ((int)inputChar[i] - 65)) % M;
            }
            match = 0;
            for (int i = 0; i < inputChar.length; i++) {
               for (int k = i+1; k < temp.length; k++) {
                  if ((k != i) && (temp[k]==temp[i])){
                     match += 1;
                  }
               }
            }
            if (match==0){
               for (int i=0;i<temp.length;i++) {
                  temp[i] = (a * ((int)inputChar[i] - 65)) % M;
                  System.out.println(inputChar[i] + "=" + temp[i]);
               }
               System.out.println("The answer is: M = " + M + " a = " + a);
               System.exit(1);
            }
         }    
      }
   }
}

