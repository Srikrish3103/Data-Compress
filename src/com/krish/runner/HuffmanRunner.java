package com.krish.runner;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

import com.krish.bitConverter.BitDecoder;
import com.krish.bitConverter.BitEncoder;
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
		String text="";
		/*
		 * FileOutputStream foutText=new FileOutputStream("C:/Test/Sample1.txt");
		 * ByteArrayOutputStream boutText=new ByteArrayOutputStream();
		 * boutText.write(text.getBytes()); boutText.writeTo(foutText);
		 * boutText.flush(); boutText.close(); foutText.close();
		 */
		String str="";
		BufferedReader buff=new BufferedReader(new FileReader("C:/Test/Sample1.txt"));
		while((str=buff.readLine())!=null)
		{
			text+=str;
		}
		
		//Getting unique object and their count from string
		HuffmanRunner runner = new HuffmanRunner();
		ArrayList<Object> uniqueObject = runner.findUniqueObjects(text);
		HashMap<Object, Integer> objectOccurrenceCount = new HashMap<Object, Integer>();
		for (int i = 0; i < uniqueObject.size(); i++) {
			objectOccurrenceCount.put(uniqueObject.get(i), runner.findObjectCount(uniqueObject.get(i), text));
		}

		//Encoding string
		HuffmanTree huffmanTree = new HuffmanTree();
		HuffmanNode model = huffmanTree.store(objectOccurrenceCount);
		String encodedText = "";
		for (int i = 0; i < text.length(); i++) {
			String tempText = "";
			char ch = text.charAt(i);
			encodedText += huffmanTree.getEncodedTextForCharacter(model, ch, tempText);
		}
		System.out.println("EncodedText "+encodedText);
		
		//Encoding byte format into bits and writing to a file
		BitEncoder bitEncoder=new BitEncoder(encodedText.getBytes()); 
		byte[] bits=bitEncoder.getBitFormat();
		int currentPosition=bitEncoder.getPosition();
		FileOutputStream fout=new FileOutputStream("C:/Test/Sample2.txt");
		ByteArrayOutputStream bout=new ByteArrayOutputStream();
		bout.write(bits);
		bout.writeTo(fout);
		bout.flush();
		bout.close();
		fout.close();
		
		//Decoding byte format from bits stored in file
		FileInputStream fin=new FileInputStream("C:/Test/Sample2.txt");
		byte[] bitsFromFile=new byte[bits.length];
		DataInputStream din=new DataInputStream(fin);
		for(int i=0;i<bitsFromFile.length;i++)
		{
			bitsFromFile[i]=din.readByte();
		}
		BitDecoder bitDecoder=new BitDecoder(bitsFromFile,currentPosition);
		String encodedTextFromFile=new String(bitDecoder.getByteFormat());
		System.out.println("Encoded Text from file "+encodedTextFromFile);
		
		String decodedText="";
		decodedText=huffmanTree.getDecodedText(model,model,encodedTextFromFile);
		System.out.println("Decoded Text based on text from file "+decodedText);
	}

}
