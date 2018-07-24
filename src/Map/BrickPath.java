package Map;

import java.awt.Color;
import java.awt.Graphics;

public class BrickPath implements Tile{
	
	public int x, y;
	public boolean visible = true;
	public Color color = Color.DARK_GRAY;
	
	public BrickPath(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void render(Graphics g){
		
		//TODO Add an actual image
		g.setColor(color);
		g.drawRect(x, y, 60, 60);
		g.fillRect(x, y, 60, 60);
	}

	public void collision(){
		//This Tile does nothing special, this should remain empty
	}

	public void visible(){
		if(visible){
			color = Color.GRAY;
		} else {
			color = Color.DARK_GRAY;
		}
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	public void setVisible(boolean visible){
		this.visible = visible;
	}

}
