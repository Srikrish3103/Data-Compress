package com.krish.datastructure;

import java.util.Comparator;

public class HuffmanNode implements Comparable<HuffmanNode>{
	
	Object object;
	int frequency;
	HuffmanNode left,right;
	
	public HuffmanNode(Object object, int frequency) {
		this.object = object;
		this.frequency = frequency;
		this.left=null;
		this.right=null;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	public HuffmanNode getLeft() {
		return left;
	}

	public HuffmanNode getRight() {
		return right;
	}
	
	@Override
    public int compareTo(HuffmanNode node) {
        return ((Integer)this.getFrequency()).compareTo((Integer)node.getFrequency());
    }
	
}
