package screens;

import control.MainWindow;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ScreenA extends BaseScreen{

	public ScreenA(Canvas canvas) {
		super(canvas);
	}

	@Override
	public void paint() {
		gc.setFill(Color.BLUE);
		gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
	}

	@Override
	public void onClick(MouseEvent e) {
		MainWindow.SCREEN = (MainWindow.SCREEN + 1) % 2;
	}

	@Override
	public void onKey(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
