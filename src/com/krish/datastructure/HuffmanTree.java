package com.krish.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
	
	private ArrayList<HuffmanNode> huffmanNodes;
	private PriorityQueue<HuffmanNode> priorityQueue;
	private HuffmanNode rootNode;
	
	public HashMap<Object,String> store(HashMap<Object,Integer> occurenceCount)
	{
		huffmanNodes=new ArrayList<HuffmanNode>();
		priorityQueue = new PriorityQueue<HuffmanNode>();
		for(Map.Entry<Object,Integer> entry:occurenceCount.entrySet())
		{
			HuffmanNode node=new HuffmanNode(entry.getKey(),entry.getValue());
			huffmanNodes.add(node);
			priorityQueue.add(node);
		}
		rootNode=encode();
		return encodeText(occurenceCount,rootNode);
	}
	
	private HashMap<Object,String> encodeText(HashMap<Object,Integer> occurenceCount,HuffmanNode rootNode)
	{
		HashMap<Object,String> encodedText=new HashMap<Object,String>();
		for(Map.Entry<Object,Integer> entry:occurenceCount.entrySet())
		{
			getEncodedText(entry.getKey(),rootNode,"");
		}
		return null;
	}
	
	private void getEncodedText(Object object,HuffmanNode rootNode,String text)
	{
		if(rootNode!=null)
		{
		if(rootNode.left==null && rootNode.right==null && rootNode.getObject().toString().equals(object.toString()))
		{
			System.out.println(rootNode.getObject().toString()+""+text);
			return;
		}
		getEncodedText(object,rootNode.left,text+"0");
		getEncodedText(object,rootNode.right,text+"1");
		}
	}
	
	private HuffmanNode encode()
	{
		HuffmanNode rootNode=null;
		while(priorityQueue.size()>1)
		{
			HuffmanNode node1=(HuffmanNode)priorityQueue.poll();
			HuffmanNode node2=(HuffmanNode)priorityQueue.poll();
			HuffmanNode node3=new HuffmanNode("~",node1.getFrequency()+node2.getFrequency());
			node3.left=node1;
			node3.right=node2;
			priorityQueue.add(node3);
			rootNode=node3;
		}
		return rootNode;
	}
	
}
