package com.krish.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
	
	private ArrayList<HuffmanNode> huffmanNodes;
	private PriorityQueue<HuffmanNode> priorityQueue;
	private HuffmanNode rootNode;
	
	public HuffmanNode store(HashMap<Object,Integer> occurenceCount)
	{
		priorityQueue = new PriorityQueue<HuffmanNode>();
		for(Map.Entry<Object,Integer> entry:occurenceCount.entrySet())
		{
			HuffmanNode node=new HuffmanNode(entry.getKey(),entry.getValue());
			priorityQueue.add(node);
		}
		return encode();
	}
	
	private HuffmanNode encode()
	{
		HuffmanNode rootNode=null;
		while(priorityQueue.size()>1)
		{
			HuffmanNode node1=(HuffmanNode)priorityQueue.poll();
			HuffmanNode node2=(HuffmanNode)priorityQueue.poll();
			HuffmanNode node3=new HuffmanNode('+',node1.getFrequency()+node2.getFrequency());
			node3.left=node1;
			node3.right=node2;
			priorityQueue.add(node3);
			rootNode=node3;
		}
		return rootNode;
	}
	
	public String getEncodedTextForCharacter(HuffmanNode node,char ch,String text)
	{
		String encodedText="";
		if(node!=null)
		{
			if(node.left==null && node.right==null && ((Character)node.getObject())==ch)
			{
				return text;
			}
			encodedText+=getEncodedTextForCharacter(node.left,ch,text+"0");
			encodedText+=getEncodedTextForCharacter(node.right,ch,text+"1");
		}
		return encodedText;
	}
	
}
