//Problem        : Spiral Diagonals
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_65
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;
/*
Introduction

A number spiral begins with the number 1 and moves to the right in a clockwise direction. For example, a 5 by 5 number spiral appears as follows:

21	22	23	24	25
20	7	8	9	10
19	6	1	2	11
18	5	4	3	12
17	16	15	14	13
Write a program that will calculate the sum of the numbers on the diagonals for any given odd spiral size (i.e. where 1 is in the middle of the spiral).


Input Specifications

Your program will take
A positive, odd integer N that describes how big the spiral should be

Output Specifications

Print out the sum of the numbers along the diagonal starting at the top left of the grid.

Sample Input/Output

INPUT
5 
OUTPUT
101
EXPLANATION
From the above diagram, it can be verified that 21 + 7 + 1 + 3 + 13 + 17 + 5 + 9 + 25 = 101.
*/
public class BloombergCodecon3
{
    public static void main(String[] args)
    {
       int input = 0;
       Scanner stdin = new Scanner(System.in);
       while(stdin.hasNextLine()) 
       {
           input = stdin.nextInt();
           stdin.nextLine();
       }
       stdin.close();
       int a = input * input;
       int sum = 0;
       int count = 0;
       int iterator = input+1;
       while(a >= 1 && iterator > 0){
    	   sum += a;
    	   if (count%4 == 0){
    		   iterator = iterator - 2;
  
    	   }
    	   count++;
    	   
    	   a -= iterator;
    	   //System.out.println(sum + ", " + a );
        }
       System.out.println(sum);
    }

}
