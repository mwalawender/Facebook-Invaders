package pl.is.facebookinvaders;

import android.content.Context;
import android.view.Display;
import android.view.View;

public class FIEngine {

	public static final int GAME_THREAD_DELAY = 4000;
	public static final int MENU_BUTTON_ALPHA = 0;
	public static final boolean HAPTIC_BUTTON_FEEDBACK = true;
	public static final int BACKGROUND_LAYER_ONE = R.drawable.backgroundstars;
	public static float SCROLL_BACKGROUND_1 = .002f;
	public static Context context;
	public static Display display;
	public static final int GAME_THREAD_FPS_SLEEP = (1000/60);
	

	public boolean onExit(View v) {
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
