package com.krish.runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

import com.krish.datastructure.HuffmanNode;
import com.krish.datastructure.HuffmanTree;

public class HuffmanRunner {

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
	
	private int findObjectCount(Object object,String text)
	{
		int count=0;
		for(int i=0;i<text.length();i++)
		{
			if((Character)object==text.charAt(i))
			{
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String text = "DAABACAABBDABACAAAABC";
		HuffmanRunner runner = new HuffmanRunner();
		
		ArrayList<Object> uniqueObject=runner.findUniqueObjects(text);
		HashMap<Object,Integer> objectOccurrenceCount=new HashMap<Object,Integer>();
		for(int i=0;i<uniqueObject.size();i++)
		{
			objectOccurrenceCount.put(uniqueObject.get(i),runner.findObjectCount(uniqueObject.get(i),text));
			System.out.println(runner.findObjectCount(uniqueObject.get(i),text));
		}
		
		HuffmanTree huffmanTree=new HuffmanTree();
		HuffmanNode model=huffmanTree.store(objectOccurrenceCount);
		
		String encodedText="";
		for(int i=0;i<text.length();i++)
		{
			String tempText="";
			char ch=text.charAt(i);
			encodedText+=huffmanTree.getEncodedTextForCharacter(model, ch, tempText);
		}
		System.out.println(encodedText);
		
		/*
		 * String decodedText=huffmanTree.getDecodedText(model,encodedText);
		 * System.out.println(decodedText);
		 */
	}
	
}
