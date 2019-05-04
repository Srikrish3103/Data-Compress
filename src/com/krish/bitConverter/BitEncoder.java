package com.krish.bitConverter;

public class BitEncoder
{
    byte[] bits;
    byte[] bytes;
    int currentPosition;
    public BitEncoder(byte[] bytes) throws Exception
    {
    	this.bits=new byte[(int)Math.ceil(bytes.length/8)+1];
    	this.bytes=bytes;
    	this.currentPosition=0;
    	storeInBitFormat();
    }
    public void storeInBitFormat() throws Exception
    {	
    	int pos=0;
    	int j=0;
    	byte tempBits;
    	for(int i=0;i<bits.length;i++)
    	{	
     		pos=0;
    		tempBits=0;
    		while(pos<8 && j<=bytes.length-1)
    		{
    			byte temp=bytes[j];
    			tempBits=(byte)(tempBits<<1);
	    		if(temp=='0')
	    		{
	    			tempBits=(byte)(tempBits|0);
	    		}
	    		else if(temp=='1')
	    		{
	    			tempBits=(byte)(tempBits|1);
	    		}
	    		pos++;
	    		j=j+1;
    		}
    		bits[i]=tempBits;
    	}
    	currentPosition=pos;
    }
    public byte[] getBitFormat()
    {
    	return bits;
    }
    public int getPosition()
    {
    	return currentPosition;
    }
}
