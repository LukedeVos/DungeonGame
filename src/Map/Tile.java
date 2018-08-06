package Map;

import java.awt.Graphics;

public interface Tile {
	
	public void render(Graphics g);
	public boolean collision();
	public void visible();
	public void tick();
	public double getX();
	public double getY();
	public double getVelX();
	public double getVelY();
	public void setVel(double velX, double velY);
	public void setCoords(int x, int y);
	public void setVisible(boolean visible);
}
