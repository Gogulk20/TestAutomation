package org.example.Codingtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coding {

    static List<String> getInput = new ArrayList<>();

    public static void main(String[] args) {
       /* Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Number of Strings: ");
        int getNumber = scanner.nextInt();
        scanner.nextLine();

        int i = 0;
        while(i < getNumber){
            String getString = scanner.nextLine();
            getInput.add(getString);
            i++;
        }

        System.out.println("================================");

        for(int j = 0; j < getInput.size(); j++){
            String firstString = getInput.get(j);
            String[] getFirstArray = firstString.split(" ");
            String first = getFirstArray[0];
            String second = getFirstArray[1];

            int getSecondNumber = Integer.parseInt(second);

            String formattedNumber = String.format("%03d", getSecondNumber);

            String formattedString = String.format("%-15s%s%n", first, formattedNumber);
            System.out.println(formattedString);
        }

        System.out.println("================================");*/
        int k = 1;
        for (int i=0; i<4 ; i++)
        {
            for(int j=1; j<=4-i; j++ )
            {
                System.out.print(k + "\t");
                k++;
            }
            System.out.println(" ");
        }
    }
}
