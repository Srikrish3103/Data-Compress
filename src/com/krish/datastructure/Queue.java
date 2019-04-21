package com.krish.datastructure;

import java.util.Collections;

public class Queue {

	Object[] objects;
	int front, rear;
	int currentSize;

	Queue(int size) {
		objects = new Object[size];
		front = -1;
		rear = -1;
		currentSize = 0;
	}

	public void push(Object object) {
		if (front == -1 && rear == -1) {
			front++;
			rear++;
		}
		if(rear==objects.length)
		{
			rear=0;
		}
		objects[rear++] = object;
		currentSize++;
		sort();
	}

	public Object pop() {
		currentSize--;
		if(front == -1) 
		{ 
		    System.out.println("Queue is empty");
		} 
		if(front==objects.length)
		{
			front=0;
		}
		return objects[front++];
	}

	public void sort() {
		if (currentSize > 1) {
			for (int i = 0; i < objects.length - 1; i++) {
				for (int j = i + 1; j < objects.length; j++) {
					if (objects[i] != null && objects[j] != null) {
						HuffmanNode object1 = (HuffmanNode) objects[i];
						HuffmanNode object2 = (HuffmanNode) objects[j];
						if (object1.getFrequency() > object2.getFrequency()) {
							HuffmanNode temp = (HuffmanNode) objects[i];
							objects[i] = objects[j];
							objects[j] = temp;
						}
					}
				}
			}
		}
	}
	
	public int size()
	{
		return currentSize;
	}

	/*
	 * public static void main(String[] args) { Queue queue = new Queue(5);
	 * queue.push(new HuffmanNode("A", 5)); queue.push(new HuffmanNode("B", 3));
	 * queue.push(new HuffmanNode("C", 2)); queue.push(new HuffmanNode("D", 1));
	 * queue.push(new HuffmanNode("E", 11)); System.out.println(((HuffmanNode)
	 * queue.pop()).getObject().toString()); System.out.println(((HuffmanNode)
	 * queue.pop()).getObject().toString()); System.out.println(((HuffmanNode)
	 * queue.pop()).getObject().toString()); System.out.println(((HuffmanNode)
	 * queue.pop()).getObject().toString()); System.out.println(((HuffmanNode)
	 * queue.pop()).getObject().toString()); }
	 */

}
