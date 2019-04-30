package com.krish.runner;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
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
			if (!uniqueObjects.contains((Character) c)) {
				uniqueObjects.add(c);
			}
		}
		return uniqueObjects;
	}

	private int findObjectCount(Object object, String text) {
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if ((Character) object == text.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		String text = "To decode the encoded data we require the Huffman tree. We iterate through the binary encoded data. To find character corresponding to current bits, we use following simple steps.\n" + 
				"\n" + 
				"    We start from root and do following until a leaf is found.\n" + 
				"    If current bit is 0, we move to left node of the tree.\n" + 
				"    If the bit is 1, we move to right node of the tree.\n" + 
				"    If during traversal, we encounter a leaf node, we print character of that particular leaf node and then again continue the iteration of the encoded data starting from step 1.\n" + 
				"\n" + 
				"The below code takes a string as input, it encodes it and save in a variable encodedString. Then it decodes it and print the original string.\n" + 
				"\n" + 
				"The below code performs full Huffman Encoding and Decoding of a given input data.";
		HuffmanRunner runner = new HuffmanRunner();
		
		ByteArrayOutputStream bout=new ByteArrayOutputStream();
		bout.write(text.getBytes());
		FileOutputStream fout=new FileOutputStream("C:/Test/Sample1.txt");
		bout.writeTo(fout);
		
		ArrayList<Object> uniqueObject = runner.findUniqueObjects(text);
		HashMap<Object, Integer> objectOccurrenceCount = new HashMap<Object, Integer>();
		for (int i = 0; i < uniqueObject.size(); i++) {
			objectOccurrenceCount.put(uniqueObject.get(i), runner.findObjectCount(uniqueObject.get(i), text));
			System.out.println(runner.findObjectCount(uniqueObject.get(i), text));
		}

		HuffmanTree huffmanTree = new HuffmanTree();
		HuffmanNode model = huffmanTree.store(objectOccurrenceCount);

		String encodedText = "";
		for (int i = 0; i < text.length(); i++) {
			String tempText = "";
			char ch = text.charAt(i);
			encodedText += huffmanTree.getEncodedTextForCharacter(model, ch, tempText);
		}
		System.out.println("EncodedText "+encodedText);
		
		bout.write(text.getBytes());
		fout=new FileOutputStream("C:/Test/Sample2.txt");
		bout.writeTo(fout);

		String decodedText="";
		decodedText=huffmanTree.getDecodedText(model,model,encodedText);
		System.out.println("Decoded Text "+decodedText);
	}

}
