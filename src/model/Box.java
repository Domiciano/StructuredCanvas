package model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Box {
	
	private Canvas canvas;
	private GraphicsContext gc;
	
	private int x;
	private int y;
	
	public Box(Canvas canvas, int x, int y) {
		this.canvas = canvas;
		this.gc = canvas.getGraphicsContext2D();
		this.x = x;
		this.y = y;
	}

	public void paint() {
		gc.setFill(Color.WHITE);
		gc.fillRect(x,y,20,20);
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
