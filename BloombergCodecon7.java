//Problem        : Spiral Diagonals
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_65
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;

//Your submission should *ONLY* use the following class name
public class BloombergCodecon7 {
	/*
	 * Introduction

Problem: The Coin Game

You and a friend are playing a game. Being a computer scientist, and hating to lose, you write a program that will determine ahead of time whether you will win or not.

If you will not win, you will be a sore loser and refuse to play. If you will win, you will graciously agree to play and beat your friend.

This is likely the last game you will be playing with your friend, but in the mean time, the game rules are as follows:

There are two players: A and B.
There are N coins initially.
Players take turns picking up coins from the pile. The number of coins that any player can pick in one turn can be one of the numbers in a specific set S = {S[1], S[2], ..., S[I], ..., S[K]}.
In order for a player to select S[I] coins, atleast that many coins must be remaining.
Player A starts the game.
The winner is the player who is able topick up exactly all the remaining coins.
Write a program that given N and S will determine player A's strategy that will allow him to always win, regardless of what the other player does.

If there is a strategy that will guarentee A's victory, print the minumum number of coins A must select.


Input Specifications

Your program will take from STDIN

A number N ≤ 100 representing the number of coins
A number K ≤ 5 representing the size of set S
This will be followed by K lines where line I contains the value S[I] (1 ≤ I ≤ K).

Output Specifications

Based on the input,
If A has a winning strategy, print out the minimum number A can choose with their first turn and still be assured victory.
If no guaranteed winning strategy is available for A, print out -1

Sample Input/Output

INPUT
1 1 1 
OUTPUT
1
EXPLANATION
Player A wins by going first and taking the only coin.
INPUT
2 1 1 
OUTPUT
-1
EXPLANATION
Player A can only take 1 coin and player B will then take the second coin. It is not possible for player A to win.
INPUT
10 3 1 3 4 
OUTPUT
1
EXPLANATION
A picks 1 (leaving 9 coins)
If B picks 1 (leaving 8 coins)
Then A picks 1 (leaving 7 coins)
If B picks 1 (leaving 6 coins) - CASE A
Then A picks 4 (leaving 2 coins)
B has to pick 1 coin, leaving 1 - A wins
If B picks 3 (leaving 4 coins) - CASE B
Then A picks all 4 coins - A wins
If B picks 4 (leaving 3 coins)
Then A picks all 3 - A wins
If B picks 3 (leaving 6 coins)
This reduces to CASE A and A wins
If B picks 4 (leaving 5 coins)
Then A picks 3 (leaving 2 coins)
Then B must pick 1, leaving 1 - A wins
	 */
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numCoins = stdin.nextInt();
		int setSize = stdin.nextInt();
		stdin.nextLine();
		int[] possibilities = new int[setSize];
/*
		for (int a = 0; a < setSize; a++) {
			possibilities[a] = stdin.nextInt();
		}
*/
		int index = 0;

		while (stdin.hasNextLine()) {
			possibilities[index] = stdin.nextInt();
			index++;
			stdin.nextLine();
		}

		stdin.close();

		System.out.println(solveGame(numCoins, possibilities));

	}

	public static int solveGame(int numCoins, int[] possibilities) {

		int min = 2147000000;
		int answer = -1;
		for (int a = 0; a < possibilities.length; a++) {
			//System.out.println("Start with" + numCoins + " taking "
				//	+ possibilities[a]);
			//System.out.println("Outcome" + solveGameP2(numCoins - possibilities[a], possibilities));
			//System.out.println("DID YOU WIN???????????????" + solveGameP2(numCoins - possibilities[a], possibilities));
			if (possibilities[a] < min
					&& solveGameP2(numCoins - possibilities[a], possibilities)) {
			//	System.out.println("win");
				answer = possibilities[a];
				min = possibilities[a];
			//	System.out.println("**************************current record is " + min);
			}
		}
		return answer;
	}

	public static boolean solveGameP2(int numCoins, int[] possibilities) {
		boolean ret = true;
		if (numCoins < 0) {
			return false;
		}
		if (numCoins == 0) {
			//System.out.println("win");
			//System.out.println("I win this case, " + numCoins);
			return true;
		} else {
			for (int a = 0; a < possibilities.length; a++) {

				//System.out.println(numCoins
				//		+ "++++ is the number of coins remaining, enemy take"
				//		+ possibilities[a]);
				if (!ret) {
					return ret;
					
				}
				//System.out.println("Coins Left" + numCoins + " Enemy is taking " + possibilities[a]);
				ret = (ret && solveGameP1(numCoins - possibilities[a],
						possibilities));
				//System.out.println(solveGameP1(numCoins - possibilities[a],
						//possibilities));
			}
		}

		return ret;
	}

	public static boolean solveGameP1(int numCoins, int[] possibilities) {
		boolean ret = false;
		if (numCoins < 0) {
			
			return true;
		}
		if (numCoins == 0) {
			//System.out.println("You win this case, " + numCoins);
			// System.out.println("loss");
			return false;
		} else {
			for (int a = 0; a < possibilities.length; a++) {
			//	 System.out.println(numCoins +
			//	 "_______ is the number of coins remaining, I take " +
			//	 possibilities[a]);
				if (ret) {
					return true;
				} else {
					//System.out.println("Coins Left" + numCoins + " I am taking " + possibilities[a]);
					ret = (ret || solveGameP2(numCoins - possibilities[a],
							possibilities));
				}
			}
		}
		return ret;
	}
}
