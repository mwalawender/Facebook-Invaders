package pl.is.facebookinvaders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class FIMainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		final FIEngine engine = new FIEngine();
		
		ImageButton start = (ImageButton)findViewById(R.id.btnStart);
		ImageButton exit = (ImageButton)findViewById(R.id.btnExit);
		
		start.getBackground().setAlpha(FIEngine.MENU_BUTTON_ALPHA);
		start.setHapticFeedbackEnabled(FIEngine.HAPTIC_BUTTON_FEEDBACK);
		
		exit.getBackground().setAlpha(FIEngine.MENU_BUTTON_ALPHA);
		exit.setHapticFeedbackEnabled(FIEngine.HAPTIC_BUTTON_FEEDBACK);
		
		start.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent game = new Intent(FIMainMenu.this,FIGame.class);
				startActivity(game);
			}
		});
		
		exit.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				boolean clean = false;
				clean = engine.onExit(v);
				if(clean)
				{
					int pid= android.os.Process.myPid();
					android.os.Process.killProcess(pid);
				}
			}
		});
	}

	
}
