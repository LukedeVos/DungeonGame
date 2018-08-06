package Player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pulser extends Rectangle implements Character {

	private static final long serialVersionUID = 1L;
	public double x, y, velX, velY;
	public int width, height;
	public boolean abilityReady = true;
	
	public Pulser(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.setBounds(x, y, width, height);
	}
	
	public void tick() {
		
	}
	
	public Rectangle collision(){
		return this.getBounds();
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
		
		this.setBounds(x, y, width, height);
	}

}
