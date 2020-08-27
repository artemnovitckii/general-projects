/*
 *  ===============================================================================
 *  MovingQuadPie.java : A shape that is an quad pie.
 *  A quiadpie has 4 handles shown when it is selected (by clicking on it).
 *  UPI: anov099
 *  Name: Artem Novitckii
 *  ===============================================================================
 */
import java.awt.*;
public class MovingQuadPie extends MovingOval {
	
	protected int value;
	
	public MovingQuadPie(){
		this(0, 0, defaultWidth, defaultHeight, defaultMarginWidth, defaultMarginHeight, defaultBorderColor, defaultFillColor, defaultPath);
	}
	
	public MovingQuadPie(int x_point, int y_point, int width, int height, int margin_width, int margin_height, Color border_color, Color fill_color, int pathType){
		super(x_point ,y_point ,width ,height ,margin_width ,margin_height ,border_color ,fill_color , pathType);
	}
	
	public void setWidth(int w) { 
		width = w;
		height = w;
	}

    public void setHeight(int h) { 
		height = h;
		width = h;
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.WHITE); //inside cirlce
		g.fillOval(topLeft.x, topLeft.y, width, height);


		g.setColor(Color.BLUE); //making pie pieces 
		g.fillArc(topLeft.x, topLeft.y, width, height ,0,90);
		g.fillArc(topLeft.x, topLeft.y, width, height ,180,90);
		
		value = (int) (Math.min(width,height)/10);
		g2d.setStroke(new BasicStroke(value));
		g.setColor(Color.ORANGE); //border color
		g.drawOval(topLeft.x, topLeft.y, width, height);
		
		
		g.setColor(fillColor); //changing arc colours
		g.fillArc(topLeft.x, topLeft.y, width, height ,0,90);
		g.fillArc(topLeft.x, topLeft.y, width, height ,180,90);
		
		value = (int) (Math.min(width,height)/10);
		g.setColor(borderColor); //customizing outside cirlce/border
		g2d.setStroke(new BasicStroke(value));
		g.setColor(borderColor); //border color
		g.drawOval(topLeft.x, topLeft.y, width, height);
		
		drawHandles(g);
		g2d.setStroke(new BasicStroke());
	}

}