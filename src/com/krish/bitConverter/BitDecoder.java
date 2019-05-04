package com.krish.bitConverter;

public class BitDecoder {
 byte[] bits;
 byte[] bytes;
 int currentPosition;
 public BitDecoder(byte[] bits,int currentPosition)
 {
	 this.bits=bits;
	 this.bytes=new byte[(bits.length-1)*8+(currentPosition)];
	 this.currentPosition=currentPosition;
	 retrieveInByteFormat();
 }
 public void retrieveInByteFormat()
 {
	 int j=0;
	 int pos=0;
	 byte tempBits;
	 int i=0;
	 for(;i<bits.length-1;i++)
	 {
		 pos=0;
		 tempBits=0;
		 while(pos<8 && j<=bytes.length-1)
		 {
			 tempBits=(byte)((bits[i]>>(7-pos)) & 1);
			 if(tempBits==0)
			 {
				 bytes[j]='0';
			 }
			 else if(tempBits==1)
			 {
				 bytes[j]='1';
			 }
			 pos++;
			 j=j+1;
		 }
	 }
	 pos=0;
	 tempBits=0;
	 while(pos<currentPosition && j<=bytes.length-1)
	 {
		 tempBits=(byte)((bits[i]>>((currentPosition-1)-pos)) & 1);
		 if(tempBits==0)
		 {
			 bytes[j]='0';
		 }
		 else if(tempBits==1)
		 {
			 bytes[j]='1';
		 }
		 pos++;
		 j=j+1;
	 }
  }
 public byte[] getByteFormat()
 {
	 return bytes;
 }
}
