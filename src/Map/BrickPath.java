package Map;

import java.awt.Color;
import java.awt.Graphics;

public class BrickPath implements Tile{
	
	public double x, y, velX, velY;
	public boolean visible = true;
	public Color color = Color.DARK_GRAY;
	
	public BrickPath(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void tick(){
		x += velX;
		y += velY;
	}
	
	public void render(Graphics g){
		
		//TODO Add an actual image
		g.setColor(color);
		g.fillRect((int)x, (int)y, 60, 60);
		g.setColor(Color.BLACK);
		g.drawRect((int)x, (int)y, 60, 60);
	}

	public boolean collision(){
		//This Tile does nothing special, this should remain empty
		
		return false;
	}

	public void visible(){
		if(visible){
			color = Color.GRAY;
		} else {
			color = Color.DARK_GRAY;
		}
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double getVelX(){
		return velX;
	}
	
	public double getVelY(){
		return velY;
	}
	
	public void setVel(double velX, double velY){
		this.velX = velX;
		this.velY = velY;
	}
	
	public void setCoords(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void setVisible(boolean visible){
		this.visible = visible;
	}

}
