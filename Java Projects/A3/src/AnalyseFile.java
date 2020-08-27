/*
 * This is a AnalyseFile Class where the file is being read and passed to Packet class.
 * 
 * Artem Novitckii
 * anov099
 * 207428057
 */

import java.util.*;
import java.io.*;

public class AnalyseFile {
	
	/*
	 * This methods reads the file taken
	 * @param f File object
	 * @return packetList which is a ArrayList of Packet objects that holds each line of input file in form of Packet class
	 */
	public ArrayList<Packet> createValidPacketList(File f) {
	    String line;
	    ArrayList<Packet> packetList = new ArrayList<Packet>();
	    Scanner input = null;
	    try{
	        input = new Scanner(f);
	        while (input.hasNext()){
	            line = input.nextLine();
	            String[] lines = line.split("\t");
	            if (lines[2].matches("^((\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.){3}(\\d|([1-9]\\d)|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))$")){
	                packetList.add(new Packet(line)); 
	            }
	        }
	        input.close();
	    }
	    catch(FileNotFoundException e){
	        System.out.print(f + " (The system cannot find the file specified)");
	    }
	    return packetList;
	}
}
