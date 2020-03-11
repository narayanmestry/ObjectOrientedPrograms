package com.bridgelabz.controller;

import java.util.Random;

public class DOKControl {

	static LinkedList[] player = new LinkedList[4];
	static String sortCollection[] = { "C-ace", "D-ace", "H-ace", "S-ace", // 3
			"C-king", "D-king", "H-king", "S-king", // 7
			"C-queen", "D-queen", "H-queen", "S-queen", // 11
			"C-jack", "D-jack", "H-jack", "S-jack", // 15
			"C-10", "D-10", "H-10", "S-10", // 19
			"C-9", "D-9", "H-9", "S-9", // 23
			"C-8", "D-8", "H-8", "S-8", // 27
			"C-7", "D-7", "H-7", "S-7", // 31
			"C-6", "D-6", "H-6", "S-6", // 35
			"C-5", "D-5", "H-5", "S-5", // 39
			"C-4", "D-4", "H-4", "S-4", // 43
			"C-3", "D-3", "H-3", "S-3", // 47
			"C-2", "D-2", "H-2", "S-2" };// 51

	static {
		for (int i = 0; i < 4; i++) {
			player[i] = new LinkedList(); // Create 4 Player object of LinkedList
		}
	}
	
	// Collect the Cards
	public static String[][] getSetOFCard(String[] cards, String[][] set) {
		int i, j;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 13; j++) {
				if (i == 0) {
					set[i][j] = "C-" + cards[j];
				} else if (i == 1) {
					set[i][j] = "D-" + cards[j];
				} else if (i == 2) {
					set[i][j] = "H-" + cards[j];
				} else if (i == 3) {
					set[i][j] = "S-" + cards[j];
				}
			}
		}
		return set;
	}

	// Display the cards
	public static void display(String[][] set, int flag) {
		int i, j;
		String label;
		for (i = 0; i < 4; i++) {
			label = getValidLabel(flag, i);
			System.out.print(label + " : -->");
			for (j = 0; j < 13; j++) {
				System.out.print("\t" + set[i][j]);
			}
			System.out.println(
					"\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}

	public static String getValidLabel(int flag, int i) {
		String label = null;

		if (i == 0) {
			if (flag == 1) {
				return "player 1";
			} else {
				return "CLUB    ";
			}
		} else if (i == 1) {
			if (flag == 1) {
				return "player 2";
			} else {
				return "DIMOND  ";
			}
		} else if (i == 2) {
			if (flag == 1) {
				return "player 3";
			} else {
				return "HEART   ";
			}
		} else if (i == 3) {
			if (flag == 1) {
				return "player 4";
			} else {
				return "SPADES  ";
			}
		}
		return null;

	}

	public static String[] getSuffle(String[][] set, String[] suffled) {
		int n[] = new int[52];
		int i, j, k = 0;
		n = getSuffledNumberArray(n);
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 13; j++) {
				suffled[n[k]] = set[i][j];
				k++;
			}
		}
		return suffled;

	}

	// return suffled array of number
	private static int[] getSuffledNumberArray(int[] n) {

		int i, j, flag = 1;

		System.out.println();
		Random rand = new Random();

		for (i = 1; i < n.length;) {
			int number = 1 + rand.nextInt(51);
			flag = 0;
			for (j = 1; j < n.length; j++) {
				if (n[j] == number) {
					flag = 1; // indicate element present so next for generate random number
					break;
				}
			}
			if (flag == 0) { // if flag remain 0 then place number in array
				n[i] = number;
				i++;
			}
		}

		/*
		 * for(i=0;i<n.length;i++) { System.out.print(","+n[i]);
		 * 
		 * }
		 */
		return n;

	}

	public static String[][] distribute(String[] suffled, String[][] set) {
		int i, j, k = 0;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 13; j++) {
				set[i][j] = suffled[k];
				k++;
			}
		}
		return set;
	}

	/********************************
	 * \
	 * 
	 * @param set : Pass to implement using Queue - Linked List
	 */
	public static void linkedListQueue(String[][] set) {
		/*
		 * for (int i = 0; i < 4; i++) { player[i] = new LinkedList(); // Create 4
		 * Player object of LinkedList }
		 */
		int i, j;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 13; j++) {
				player[i].insert(set[i][j]); // Insert Data Means Distribute the Card Player Wise
			}
			
		}

		for (i = 0; i < 4; i++) {
			player[i].show(i); // show data 4 Player object of LinkedList
			System.out.println();
		}
		
		for (i = 0; i < 4; i++) {
			player[i].sort(sortCollection); // show data 4 Player object of LinkedList
			System.out.println();
		}
		
		for (i = 0; i < 4; i++) {
			player[i].show(i); // show data 4 Player object of LinkedList
			System.out.println();
		}
		
	}

	public static int getAppropriatePsition(String element) {
		int i;
		for (i = 0; i < sortCollection.length; i++) {

			if (element.equalsIgnoreCase(sortCollection[i])) {
				break;
			}
		}

		return i;
	}

	public static String getElement(int i) {
		return sortCollection[i];
	}

}
