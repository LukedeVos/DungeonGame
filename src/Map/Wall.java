package Map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall extends Rectangle implements Tile {

	private static final long serialVersionUID = 1L;
	public double x, y, velX, velY;
	public boolean visible = true;
	public Color color = Color.RED;
	
	public final int size = 60;
	
	public Wall(int x, int y){
		this.setBounds(x, y, size, size);
		
		this.x = x;
		this.y = y;
	}
	
	public void tick(){
		x += velX;
		y += velY;
		
		this.setBounds((int)x, (int)y, size, size);
	}
	
	public void render(Graphics g){
		//TODO Add an actual image
		g.setColor(color);
		g.fillRect((int)x, (int)y, size, size);
		g.setColor(Color.BLACK);
		g.drawRect((int)x, (int)y, size, size);
	}

	public void collision(){
		//TODO Add collision
	}

	public void visible(){
		//
		
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
