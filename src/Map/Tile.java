package Map;

import java.awt.Graphics;

public interface Tile {
	
	public void render(Graphics g);
	public void collision();
	public void visible();
	public void setX(int x);
	public void setY(int y);
	public void setVisible(boolean visible);
}
