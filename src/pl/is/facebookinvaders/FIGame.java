package pl.is.facebookinvaders;

import android.app.Activity;
import android.os.Bundle;

public class FIGame extends Activity {

	private FIGameView gameView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		gameView = new FIGameView(this);
		setContentView(gameView);
	}

	protected void onResume() {
		super.onResume();
		gameView.onResume();
	}

	protected void onPause() {
		super.onPause();
		gameView.onPause();

	}

}
