/*
 * This is a DrawGraph class where graph is created.
 * 
 * Artem Novitckii
 * anov099
 * 207428057
 */

import javax.swing.*;
import java.awt.*;
import org.math.plot.*;

public class DrawGraph extends JPanel {
	private int xX,string_int,interval;
	
	/*
	 * This is overridden paintComponent method that draw the component of the graph.
	 * @param g Graphics g object
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.CYAN);
		g.drawLine(45, 270, 950, 270); //x-axis
		g.drawLine(50, 275, 50, 25 ); //y-axis
		g.drawString("Volume [bytes]",3,13); //Volume label
		g.drawString("Time [s]",450,314); //Time label
		g.drawString("0",30, 275); //0 label
		g.drawString("0", 47, 290); //0 label
		
		//ticks for x-axis
		string_int = 50;
		interval = 75;
		xX = 125;
		for (int i = 0; i <= 12; i++) {
			g.drawLine(xX, 270, xX, 275);
			g.drawString(String.valueOf(string_int), xX -10, 290);
			xX+= interval;
			string_int += 50;
		}
		
		
	}
	
}
