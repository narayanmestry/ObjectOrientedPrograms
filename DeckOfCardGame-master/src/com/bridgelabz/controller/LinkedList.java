package com.bridgelabz.controller;

public class LinkedList {
	public int size;
	public Node front, rear;

	public LinkedList() {

	}

	public void linkedListQueue(String[][] set) {
		size = 0;
		front = null;
		rear = null;
	}

	public void insert(String data) {
		Node n = new Node();
		n.setData(data);
		n.setNext(rear);
		int indexOfData = DOKControl.getAppropriatePsition(data); // get index of particular card which come to insert
		int loc = 0; // into Queue
//		System.out.println(data + "==>" + indexOfData);

		if (front == null) {
			front = n;
			rear = n;
			rear.setNext(null);
		} else {

			rear.setNext(n);
			rear = n;

			n.setNext(null);
		}
		size++;
	}

	public void show(int i) {
		Node t;
		t = front;
		String label;

		label = DOKControl.getValidLabel(1, i);
		System.out.print(label + " : -->");
		while (t.getNext() != null) {
			System.out.print("\t" + t.getData());
			t = t.getNext();
		}
		System.out.print("\t" + t.getData());
		System.out.println(
				"\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

	}

	// Player Sort the Card
	public void sort(String[] sortCollection) {
		Node t1,t2;

		t1=front;
		String temp;
		
		for (int i = 0; i < sortCollection.length; i++) {

			String element = DOKControl.getElement(i);
			boolean present = isPresentAtList(element);
			int loc = getLocationOfFromList(element);
		
			if ((loc>=0&&loc<13)&& present) {
				
				//-------------
				t2 = front;
				for(int j =0;j<loc;j++)
				{
					t2 = t2.getNext();
				}
				temp = t1.getData();
				t1.setData(t2.getData());
				t2.setData(temp);
				
				if(t1.getNext()!=null)
				{				
					t1=t1.getNext();
				}
				else
				{
					t1=t1;
				}
			}
			
			
		}
		
		

	}

	private boolean  isPresentAtList(String element) {
		Node t;
		t = front;
		int flag = 0;
		while (t.getNext() != null) {
			if (element.equals(t.getData())) {
				flag = 1;
				break;
			}
			t = t.getNext();
		}
		if (element.equals(t.getData())) {
			flag = 1;
		}
		if(flag==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private int  getLocationOfFromList(String element) {
		Node t;
		t = front;
		int flag = 0,loc=0;
		while (t.getNext() != null) {
			if (element.equals(t.getData())) {
				flag = 1;
				break;
			}
			t = t.getNext();
			loc++;
		}
		if (element.equals(t.getData())) {
			flag = 1;
		}
		if(flag==1)
		{
			return loc;			
		}
		else
		{
			return 1000;
		}
	}

}



