/*
 * This is a Packet Class where the file taken will get processed and information needed will be returned
 * 
 * Artem Novitckii
 * anov099
 * 207428057
 */

import java.util.*;
import java.io.*;

public class Packet {
	private double timestamp;
    private String srcHost;
    private String destHost;
    private int ipPacketSize;

    /*
     * This is a constructor of Packet class where a passed down file will be analyzed and divided into information blocks.
     * @param s String object
     */
	public Packet(String s){
	    String[] array = s.split("\t",-1);
	    if (array[2].matches("^((\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.){3}(\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))$")){
	        srcHost = array[2]; 
	    }
	    else{
	        srcHost = "";
	    }
	    if (array[4].matches("^((\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.){3}(\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))$")){
	        destHost = array[4]; 
	    }
	    else{
	        destHost = "";
	    }
	    
	    if (array[1].matches("^\\d+\\.\\d+")){
	        timestamp = Double.parseDouble(array[1]);
	    }
	    
	    if (array[7].matches("\\d+")){
	        ipPacketSize = Integer.valueOf(array[7]);
	    }
	}
	
	/*
	 * This methods returns IP address of the source
	 * @return srcHost which is a string of source IP address
	 */
	public String getSourceHost(){
	    return srcHost;
	}
	
	/*
	 * This methods returns IP address of the destination
	 * @return destHost which is a string of source IP address
	 */
	public String getDestinationHost(){
	    return destHost;
	}
	
	/*
	 * This methods returns the time you took to deliver data from source to destination
	 * @return timestamp which is a string of time
	 */
	public double getTimeStamp(){
	    return timestamp;
	}
	
	/*
	 * This methods returns packet size
	 * @return ipPacketSize which is  a string of packet size
	 */
	public int getIpPacketSize(){
	    return ipPacketSize;
	}
	
	/*
	 * This methods overrides toString method
	 * @return returns a string in a format of source IP, destination IP,time taken and size of packet
	 */
	public String toString(){
	    return String.format("src=%s, dest=%s, time=%.2f, size=%d",
	    srcHost, destHost, timestamp, ipPacketSize);
	    }
}
