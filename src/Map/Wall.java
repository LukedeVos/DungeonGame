package Map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Main.Main;

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
		if(!this.intersects(Main.p.collision())){
			g.setColor(color);
		} else {
			g.setColor(Color.GREEN);
		}
		g.fillRect((int)x, (int)y, size, size);
		g.setColor(Color.BLACK);
		g.drawRect((int)x, (int)y, size, size);
	}

	public boolean collision(){
		//TODO Add collision
		boolean canMoveX = true;
		boolean canMoveY = true;
		
		//Set bounds to where they would be if the movement on the X-axis would succeed
		this.setBounds((int)(x + velX), (int)y, size, size);
		
		//Check if this would collide with the Player
		if(this.intersects(Main.p.collision())){
			canMoveX = false;
		}
		
		//Reset bounds
		this.setBounds((int)x, (int)y, size, size);
		
		
		//Set bounds to where they would be if the movement on the Y-axis would succeed
		this.setBounds((int)x, (int)(y + velY), size, size);
		
		//Check if this would collide with the Player
		if(this.intersects(Main.p.collision())){
			canMoveY = false;
		}
		
		//Reset Bounds
		this.setBounds((int)x, (int)y, size, size);
		
		//Returns true if there is an intersection between Player and Wall, returns false otherwise
		return !(canMoveX && canMoveY);
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
