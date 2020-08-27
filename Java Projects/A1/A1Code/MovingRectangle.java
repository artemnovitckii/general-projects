/*
 *  ===============================================================================
 *  MovingRectangle.java : A shape that is an oval.
 *  A rectagnle has 4 handles shown when it is selected (by clicking on it).
 *  UPI: anov099
 *  Name: Artem Novitckii
 *  ===============================================================================
 */
import java.awt.*;
public class MovingRectangle extends MovingShape {
	
	public MovingRectangle(){
		this(0, 0, defaultWidth, defaultHeight, defaultMarginWidth, defaultMarginHeight, defaultBorderColor, defaultFillColor, defaultPath);
	}
	
	public MovingRectangle(int x_point, int y_point, int width, int height, int margin_width, int margin_height, Color border_color, Color fill_color, int pathType){
		super(x_point ,y_point ,width ,height ,margin_width ,margin_height ,border_color ,fill_color , pathType);
	}
	
	public void draw(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(fillColor);
		g.fillRect(topLeft.x, topLeft.y, width, height);
		g.setColor(borderColor);
		g.drawRect(topLeft.x, topLeft.y, width, height);
		drawHandles(g);
	}
	
	public boolean contains(Point mousePt) {
		Point EndPt = new Point(topLeft.x + width, topLeft.y + height);
		return (((mousePt.x >= topLeft.x) && (mousePt.x <= EndPt.x)) && ((mousePt.y >= topLeft.y)&&(mousePt.y <= EndPt.y)));
	}
	
}