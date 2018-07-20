package Menus;

import java.awt.Graphics;
import java.util.ArrayList;

public interface Menu {
	
	public void optionPressed();
	public void render(Graphics g);
	public void keyPressed(ArrayList<Integer> k);
	public void keyReleased(ArrayList<Integer> k);
}
