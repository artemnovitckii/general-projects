/*
 * This is a Host Class where the information of each Packet class gets sorted.
 * 
 * Artem Novitckii
 * anov099
 * 207428057
 */

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Host implements Comparable<Host>{
	private String ip;
	
	/*
	 * This is a constructor of Host class
	 * @param address String object
	 */
	public Host(String address){
	    this.ip = address;
	}
	
	/*
	 * This methods overrides toString 
	 * @return IP which is a string of address
	 */
	public String toString(){
	    return ip;
	}
	
	/*
	 * This methods compares IP addresses of 2 objects
	 * This is overridden method 
	 * @param other Host object
	 * @return integer
	 */
	public int compareTo(Host other){
		String[] host = ip.split("\\.");
	    String[] host2 = other.ip.split("\\.");
	        for(int i = 0; i<4;i++){
	            if (Integer.valueOf(host[i]) > Integer.valueOf(host2[i])){
	                return 1;
	            }
	            else if (Integer.valueOf(host[i]) < Integer.valueOf(host2[i])){
	                return -1;
	            }
	        }
	        return 0;
	}
	
	/*
	 * This method sorts sources IP addresses which a list of Host objects and makes sure that there are no duplicates in sorted list.
	 * @param packets which is ArrayList of Packet objects
	 * @return srcStringArray which is an ArrayList of String objects.
	 */
	public static ArrayList<String> getUniqueSortedSourceHosts(ArrayList<Packet> packets) {
	    Set<String> setA = new HashSet<String>();
	    for(Packet obj: packets){
	        if(obj.getSourceHost().matches("^((\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.){3}(\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))$")){
	            setA.add(obj.getSourceHost());
	        }
	    }
	    ArrayList<Host> list = new ArrayList<Host>();
	    for(String o : setA){
	        list.add(new Host(o));
	    }
	    Collections.sort(list);
	    
	    ArrayList<String> srcStringArray = new ArrayList<String>();
	    for (Host o : list) {
	    	srcStringArray.add(o.toString());
	    }
	    return srcStringArray;
	    
	    
	}
	
	/*
	 * This method sorts destination IP addresses which a list of Host objects and makes sure that there are no duplicates in sorted list.
	 * @param packets which is ArrayList of Packet objects
	 * @return destStringArray which is an ArrayList of String objects.
	 */
	public static ArrayList<String> getUniqueSortedDestHosts(ArrayList<Packet> packets){
	    Set<String> setA = new HashSet<String>();
	    for(Packet obj: packets){
	        if(obj.getSourceHost().matches("^((\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.){3}(\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))$")){
	            setA.add(obj.getDestinationHost());
	        }
	    }
	    ArrayList<Host> list = new ArrayList<Host>();
	    for(String o : setA){
	        list.add(new Host(o));
	    }
	    Collections.sort(list);
	    
	    ArrayList<String> destStringArray = new ArrayList<String>();
	    for (Host o : list) {
	    	destStringArray.add(o.toString());
	    }
	    return destStringArray;
	    
	    
	}
	

	    
}
	

