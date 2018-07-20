package Menus;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Start implements Menu{
	
	public int selection, maxSelect;
	
	public void keyPressed(ArrayList<Integer> k){
		if(k.contains(KeyEvent.VK_S)){
			selection++;
		}
		
		if(k.contains(KeyEvent.VK_W)){
			selection--;
		}
	}
	
	public void keyReleased(ArrayList<Integer> k){
		
	}

	public void optionPressed() {
		
	}

	public void render(Graphics g) {
		
	}
}
