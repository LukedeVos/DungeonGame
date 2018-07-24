package Map;

import java.awt.Color;
import java.awt.Graphics;

public class Wall implements Tile{

	public double x, y, velX, velY;
	public boolean visible = true;
	public Color color = Color.RED;
	
	public Wall(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void render(Graphics g){
		//TODO Add an actual image
		g.setColor(color);
		g.fillRect((int)x, (int)y, 60, 60);
		g.setColor(Color.BLACK);
		g.drawRect((int)x, (int)y, 60, 60);
	}

	public void collision(){
		//
		
	}

	public void visible(){
		//
		
	}

	public void tick(){
		//
		
	}

	public double getX(){
		//
		return 0;
	}

	public double getY(){
		//
		return 0;
	}

	public double getVelX(){
		//
		return 0;
	}

	public double getVelY(){
		return 0;
	}

	public void setVel(double velX, double velY){
		//
		
	}

	public void setCoords(int x, int y){
		//
		
	}

	public void setVisible(boolean visible){
		//
		
	}

}
