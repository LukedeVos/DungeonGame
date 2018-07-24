package Main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

import Map.BrickPath;
import Map.Tile;
import Player.Character;
import Player.Pulser;

public class Main extends Canvas implements Runnable {
	//test

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 960, HEIGHT = WIDTH / 12 * 9 + 20, SCALE = 2;
	public final String TITLE = "UNKNOWN RPG";
	private static Main game = new Main();
	private static JFrame frame = new JFrame(game.TITLE);
	
	private boolean running = false;
	private boolean paused = false;
	private Thread thread;
	Random rand = new Random();
	
	public Character p;
	private ArrayList<Integer> keyP = new ArrayList<Integer>();
	private ArrayList<Integer> keyR = new ArrayList<Integer>();
	
	private Tile[][] map = new Tile[50][50];
	
	private int frames;
	private int playerSize = 50;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	BufferedImageLoader loader = new BufferedImageLoader();
	
	public void init(){
		requestFocus();
		addKeyListener(new KeyInput(this));
		
		p = new Pulser(20, 20, playerSize, playerSize);
		
//		try {
//			
//		} catch(IOException e){
//			e.printStackTrace();
//		}
	}
	
	public void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void stop(){
		if(!running){
			return;
		}
		running = false;
		try {
			thread.join();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		System.exit(1);
	}

	public void run(){
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		long timer = System.currentTimeMillis();

		// Game loop starts here
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1){
				if(!paused){
					tick();
					render();
				}
				updates++;
				delta--;
			}
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + " ticks, Fps " + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public void loadMap(){
		for(int x = 0; x < map.length; x++){
			for(int y = 0; y < map[0].length; y++){
				map[x][y] = new BrickPath(x * 60, y * 60);
			}
		}
	}
	
	public void tick(){
		p.tick();
		p.setCoords(getWidth() / 2 - playerSize, getHeight() / 2 - playerSize / 2);
	}
	
	public void render(){
		frames++;

		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		//////////////////////////////////
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		
		p.render(g);
		
		//////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public void keyPressed(KeyEvent k){
		boolean previouslyPressed = false;
		for(int i = 0; i < keyP.size(); i++){
			if(keyP.get(i) == k.getKeyCode()){
				previouslyPressed = true;
			}
		}
		
		if(!previouslyPressed){
			keyP.add(k.getKeyCode());
		}
		
		//Game exit
		if(keyP.contains(KeyEvent.VK_ESCAPE)){
			frame.setVisible(false);
			System.exit(0);
			frame.dispose();
		}
		
	}

	public void keyReleased(KeyEvent k){
		for(int i = 0; i < keyP.size(); i++){
			if(keyP.get(i) == k.getKeyCode()){
				keyP.remove(i);
			}
		}
		
		keyR.add(k.getKeyCode());
		
	}
	
	public static void main(String args[]){
		frame.add(game);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.pack();
		frame.setVisible(true);
		game.start();
	}
	
	public BufferedImage getSpriteSheet(String path){
		if(path == ""){
			
		}
		return null;
	}
}
