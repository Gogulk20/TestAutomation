package org.example.Codingtest;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.io .*;
import java.math .*;
import java.security .*;
import java.text .*;
import java.util .*;
import java.util.concurrent .*;
import java.util.regex .*;

public class Tables {
    // tables
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(bufferedReader.readLine().trim());
//        for(int i = 1; i<=10; i++){
//            int result = N*i;
//            System.out.println(N + " x " + i + " = " + result );
//        }
//        bufferedReader.close();
//    }
//public static void main(String []argh){
//    Scanner in = new Scanner(System.in);
//    int t=in.nextInt();
//     for(int i=0;i<t;i++){
//        int a = in.nextInt();
//        int b = in.nextInt();
//        int n = in.nextInt();
//        int currentValue = a;
//        for(int j = 0; j < n; j++) {
//            currentValue += (Math.pow(2, j) * b);
//            System.out.print(currentValue + " ");
//            }
//        System.out.println();
//    }
//    in.close();
//}


//    class Result {
//
//        /*
//         * Complete the 'findDay' function below.
//         *
//         * The function is expected to return a STRING.
//         * The function accepts following parameters:
//         *  1. INTEGER month
//         *  2. INTEGER day
//         *  3. INTEGER year
//         */
//
//        public static String findDay(int month, int day, int year) {
//            LocalDate date = LocalDate.of(year, month, day);
//            return date.getDayOfWeek().name();
//        }
//

//            public static void main(String[] args) throws IOException {
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//                int month = Integer.parseInt(firstMultipleInput[0]);
//
//                int day = Integer.parseInt(firstMultipleInput[1]);
//
//                int year = Integer.parseInt(firstMultipleInput[2]);
//
//                String res = Result.findDay(month, day, year);
//
//                bufferedWriter.write(res);
//                bufferedWriter.newLine();
//
//                bufferedReader.close();
//                bufferedWriter.close();
//            }
//        }
//
public static void main(String[] args){
    int k = 1;
    for (int i=0; i<4 ; i++){
        for(int j=1; j<=4-i;j++ ){
            System.out.print(k);
            k++;
        }
    }
    }

}

