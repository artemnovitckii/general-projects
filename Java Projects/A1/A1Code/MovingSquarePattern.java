/*
 *  ===============================================================================
 *  MovingSquarePattern.java : A shape that is an square pattern.
 *  A square pattern has 4 handles shown when it is selected (by clicking on it).
 *  UPI: anov099
 *  Name: Artem Novitckii
 *  ===============================================================================
 */
import java.awt.*;
public class MovingSquarePattern extends MovingSquare  {
	
	private int increment =  Math.min(width,height) /10;
	
	public MovingSquarePattern(){
		super();
	}
	
	public MovingSquarePattern(int x_point, int y_point, int width, int height, int margin_width, int margin_height, Color border_color, Color fill_color, int pathType){
		super(x_point ,y_point ,width ,height ,margin_width ,margin_height ,border_color ,fill_color , pathType);
	}
	
	public void draw(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(fillColor);
		g.drawRect(topLeft.x, topLeft.y, width, height);
		
		increment = 0;
		for(int i = 0; i < 10; i++){
			g.drawLine(topLeft.x, (int)(topLeft.y+increment),(int)(topLeft.x+increment),topLeft.y+Math.min(width,height));
			increment += Math.min(width,height) /10;
		}
		increment = Math.min(width,height) /10;
		
		for(int i = 0; i < 10; i++){
			g.drawLine((int)(topLeft.x + increment),topLeft.y,topLeft.x + width, (int)(topLeft.y + increment));
			increment += Math.min(width,height) /10;
		}
		
		drawHandles(g);
	}
}
	