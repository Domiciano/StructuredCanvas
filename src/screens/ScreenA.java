package screens;

import control.MainWindow;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Avatar;

public class ScreenA extends BaseScreen{

	//Los objetos sobre el escenario
	private Avatar avatar;
	
	public ScreenA(Canvas canvas) {
		super(canvas);
		avatar = new Avatar(canvas);
	}

	@Override
	public void paint() {
		gc.setFill(Color.BLACK);
		gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
		
		avatar.paint();
	}

	@Override
	public void onClick(MouseEvent e) {
		MainWindow.SCREEN = (MainWindow.SCREEN + 1) % 2;
	}

	@Override
	public void onKey(KeyEvent e) {
		if(e.getCode().equals(KeyCode.A)) {
			avatar.moveXBy(-2);
		}else if(e.getCode().equals(KeyCode.W)) {
			avatar.moveYBy(-2);
		}else if(e.getCode().equals(KeyCode.S)) {
			avatar.moveYBy(2);
		}else if(e.getCode().equals(KeyCode.D)) {
			avatar.moveXBy(2);
		}
		
	}

}
