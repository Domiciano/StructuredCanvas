package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import control.MainWindow;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Avatar {
	
	private Canvas canvas;
	private GraphicsContext gc;
	
	private int x=250;
	private int y=250;

	private ArrayList<Image> runImages;
	private ArrayList<Image> attackImages;
	
	private int state = 0;
	private int frame = 0;
	
	
	public Avatar(Canvas canvas) {
		this.canvas = canvas;
		gc = canvas.getGraphicsContext2D();
		runImages = new ArrayList<>();
		attackImages = new ArrayList<>();
		try {	
			for(int i=1 ; i<=10 ; i++) {
				File file = new File("src/image/Run ("+i+").png");
				Image image = new Image(new FileInputStream(file));
				runImages.add(image);
			}
			
			for(int i=1 ; i<=10 ; i++) {
				File file = new File("src/image/Attack ("+i+").png");
				Image image = new Image(new FileInputStream(file));
				attackImages.add(image);
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		
		
	}
	
	public void paint() {
		if(state == 0) {
			gc.drawImage(runImages.get(frame%10), x, y, 100,100);
			frame++;
		}else if(state == 1) {
			gc.drawImage(attackImages.get(frame), x, y, 100,100);
			frame++;
			if(frame == 10) {
				this.state = 0;
			}
		}
	}
	
	public void setState(int state) {
		this.state = state;
		this.frame = 0;
	}

	public void moveXBy(int i) {
		this.x += i;
	}
	
	public void moveYBy(int i) {
		this.y += i;	
	}

	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
