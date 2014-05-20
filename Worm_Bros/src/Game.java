
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.List;
import java.awt.RenderingHints;
import java.util.*;
import java.util.Timer;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class Game extends JPanel{
	Worm worm = new Worm(this,true);
	Worm worm2 = new Worm(this, true);
	private Image img; 
	Food food = new Food (this);
	//Worm worm7;
	int score;
	static ArrayList<Worm> body = new ArrayList<Worm>();
	public void loadImg(){
		try{
		img = ImageIO.read(new File("C:/Users/Stephen/Pictures/stars.jpg"));
		
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	public void createFrame(){
	
		JFrame frame = new JFrame("Worms");
		
		frame.add(this);
		frame.setSize(600, 500);
		frame.setVisible(true);
		
    	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(img,0,0,null);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		worm.paint(g2d);
		worm2.paint(g2d);
		for (Worm b: body){
			b.paint(g2d);
		}
		food.paint(g2d);
		}
	
	public void move(){
		
		worm.finalizedMove();
		worm.move();
		worm2.move();
		for (Worm b: body){
			b.move();
		}
		if (worm.collision()){
			Game.body.add(new Worm(this, false));
			food.move();
			SoundTest.BITE.play();
			
		}
}
	
	
	
	public Game() {
		SoundTest.MUSIC.play();
		SoundTest.MUSIC.loop();
		
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
				if (worm.key == true){
					worm.keyPressed(e);	
				worm.key = false;
				}
				new Timer().schedule(new TimerTask() {
					public void run() {
							Worm.key = true;
						}
					}, 300);	
			}
		});
		setFocusable(true);
	}
	
	
	public static void main(String[] args)throws InterruptedException{
		Game game = new Game();
		game.createFrame();
		game.loadImg();
		while (true) {
			
			game.move();
			game.repaint();
			
			Thread.sleep(50);
			
			
		}
	}
}


