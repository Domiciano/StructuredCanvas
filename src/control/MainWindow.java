package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import screens.ScreenA;
import screens.ScreenB;

public class MainWindow implements Initializable {

	@FXML
	private Canvas canvas;
	private GraphicsContext gc;
	
	public static int SCREEN = 0;
	
	private ScreenA screenA;
	private ScreenB screenB;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		screenA = new ScreenA(canvas);
		screenB = new ScreenB(canvas);
		
		gc = canvas.getGraphicsContext2D();
		canvas.setFocusTraversable(true);
		
		new Thread(() -> {
			while (true) {
				paint();
				pause(50);
			}
		}).start();
		
		
		
		initEvents();
	}
	
	private void paint() {
		switch(SCREEN) {
			case 0:
				screenA.paint();
			break;
			
			case 1:
				screenB.paint();
				break;
		}
		
	}

	public void initEvents() {	
		canvas.setOnMouseClicked(e -> {
			switch(SCREEN) {
			case 0:
				screenA.onClick(e);
				break;
				
			case 1:
				screenB.onClick(e);
				break;
			}
		});
		
		canvas.setOnKeyPressed(e -> {
			switch(SCREEN) {
			case 0:
				screenA.onKey(e);
				break;
				
			case 1:
				screenB.onKey(e);
				break;
			}
		});
	}

	private void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
