package pl.is.facebookinvaders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class FacebookInvaders2Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        new Handler().postDelayed(new Thread() {
        	@Override
        	public void run() {
        		
        		Intent mainMenu = new Intent(FacebookInvaders2Activity.this,
        				FIMainMenu.class);
        				FacebookInvaders2Activity.this.startActivity(mainMenu);
        				FacebookInvaders2Activity.this.finish();
        				overridePendingTransition(R.layout.fadein, R.layout.fadeout);
        	}
        	}, FIEngine.GAME_THREAD_DELAY);
    }
}