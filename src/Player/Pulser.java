package Player;

import java.awt.Color;
import java.awt.Graphics;

public class Pulser implements Character {

	public double x, y, velX, velY;
	public int width, height;
	public boolean abilityReady = true;
	
	public Pulser(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		//TODO Add an actual image
		g.setColor(Color.WHITE);
		g.drawRect((int)x, (int)y, width, height);
		g.fillRect((int)x, (int)y, width, height);
	}

	public void ability(){
		if(abilityReady){
			
		}
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setVelX(double velX){
		this.velX = velX;
	}
	
	public void setVelY(double velY){
		this.velY = velY;
	}

	public void setCoords(int x, int y){
		this.x = x;
		this.y = y;
	}

}
