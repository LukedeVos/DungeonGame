package Player;

import java.awt.Graphics;

public interface Character {
	
	public void tick();
	public void render(Graphics g);
	public void ability();
	public void collision();
	public void setX(int x);
	public void setY(int y);
	public void setCoords(int x, int y);
}
