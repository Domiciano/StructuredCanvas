package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
	private Image image;
	
	public Avatar(Canvas canvas) {
		this.canvas = canvas;
		gc = canvas.getGraphicsContext2D();
		
		File file = new File("src/image/mario.png");
		System.out.println(file.exists());
		try {
			image = new Image(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paint() {
		gc.drawImage(image, x, y);
		
		if(MainWindow.FRAMES % 100 == 0) {
			x=0;
			y=0;
		}
	}

	public void moveXBy(int i) {
		this.x += i;
	}
	
	public void moveYBy(int i) {
		this.y += i;	
	}
	
}
