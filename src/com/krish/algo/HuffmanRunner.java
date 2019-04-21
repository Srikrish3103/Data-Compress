package com.krish.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

import com.krish.datastructure.HuffmanNode;
import com.krish.datastructure.HuffmanTree;

public class HuffmanRunner {
	
	private int sizeOf(Object data) {
		char[] c = data.toString().toCharArray();
		return c.length * 2 * 8;
	}

	private ArrayList<Object> findUniqueObjects(Object data) {
		String dataText = data.toString();
		ArrayList<Object> uniqueObjects = new ArrayList<Object>();
		for (int i = 0; i < dataText.length(); i++) {
			char c = dataText.charAt(i);
			if (!uniqueObjects.contains((Character)c)) {
				uniqueObjects.add(c);
			}
		}
		return uniqueObjects;
	}
	
	public void display(HuffmanNode tree)
	{
		if(tree!=null)
		{
			System.out.println(tree.getObject().toString()+" "+tree.getFrequency());
			display(tree.getLeft());
			display(tree.getRight());
		}
	}

	public static void main(String[] args) {
		String text = "AABACAABBDABACAAAABC";
		HuffmanRunner runner = new HuffmanRunner();
		
		//ArrayList<Object> objects=encoder.findUniqueObjects(text);
		
		HashMap<Object,Integer> occurrenceCount=new HashMap<Object,Integer>();
		occurrenceCount.put("D",150);
		occurrenceCount.put("C",30);
		occurrenceCount.put("B",51);
		occurrenceCount.put("A",11);
		
		HuffmanTree huffmanTree=new HuffmanTree();
		huffmanTree.store(occurrenceCount);
//		HuffmanNode tree=huffmanTree.store(occurrenceCount);
//		runner.display(tree);
	}
	
}
