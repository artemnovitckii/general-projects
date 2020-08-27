/*
 *  ===============================================================================
 *  MovingSquare.java : A shape that is an square.
 *  A square has 4 handles shown when it is selected (by clicking on it).
 *  UPI: anov099
 *  Name: Artem Novitckii
 *  ===============================================================================
 */
import java.awt.*;
public class MovingSquare extends MovingRectangle {
	
	public MovingSquare(){
		this(0, 0, defaultWidth, defaultHeight, defaultMarginWidth, defaultMarginHeight, defaultBorderColor, defaultFillColor, defaultPath);
	}
	
	public MovingSquare(int x_point, int y_point, int width, int height, int margin_width, int margin_height, Color border_color, Color fill_color, int pathType){
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
}