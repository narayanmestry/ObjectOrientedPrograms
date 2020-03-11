package com.bridgelabz.Driver;


import com.bridgelabz.controller.DOKControl;
import com.bridgelabz.controller.LinkedList;

public class DeckOFCard {

	public static void main(String[] args) {
		String cards[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace" };
		String[][] set = new String[4][13];
		String[] suffled = new String[52];
		int flag = 0; // flag = 0 indicate card in sorted format
		LinkedList linkedlist = new LinkedList();	
		
		set = DOKControl.getSetOFCard(cards, set); // Get Collection of Card
		System.out.println("********************Collection Of All Cards********************");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		DOKControl.display(set, flag); // Display Sorted collection

		suffled = DOKControl.getSuffle(set, suffled); // Get all card Suffelld
	
		
		set = DOKControl.distribute(suffled, set); // Distribute to player

		flag = 1; // flag = 1 indicate card get Suffled
		
		System.out.println("\n\n********************Distributed Cards to Players********************");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");		
		DOKControl.display(set, flag); // Display Distributed card to Player
		

		/**************************************************************
		 * Using LinkedList :
		 */
	
		System.out.println("\n\n********************Using Queue--LinkedList ==> Distributed Cards to Players********************");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		DOKControl.linkedListQueue(set);		// Pass set to Implement Using LinkedList
		
		
	}
}
