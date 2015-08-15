package pl.is.facebookinvaders;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;

public class FIGameRenderer implements Renderer {

	private FIBackground background = new FIBackground();
	private float bgScroll1;

	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub

		try {
			Thread.sleep(FIEngine.GAME_THREAD_FPS_SLEEP);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		scrollBackground1(gl);
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE);
		
	}

	private void scrollBackground1(GL10 gl) {

		if (bgScroll1 == Float.MAX_VALUE) {
			bgScroll1 = 0f;
		}
		/*
		 * This code just resets the scale and translate of the Model matrix
		 * mode, we are not moving it
		 */
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glPushMatrix();
		gl.glScalef(1f, 1f, 1f);
		gl.glTranslatef(0f, 0f, 0f);

		gl.glMatrixMode(GL10.GL_TEXTURE);
		gl.glLoadIdentity();
		gl.glTranslatef(0.0f, bgScroll1, 0.0f); // scrolling the texture

		background.draw(gl);
		gl.glPopMatrix();
		bgScroll1 += FIEngine.SCROLL_BACKGROUND_1;
		gl.glLoadIdentity();
	}

	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub

		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrthof(0f, 1f, 0f, 1f, -1f, 1f);

	}

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		gl.glEnable(GL10.GL_TEXTURE_2D);
		gl.glClearDepthf(1.0f);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE);
		
		background.loadTexture(gl,FIEngine.BACKGROUND_LAYER_ONE,
				FIEngine.context);

	}

}
