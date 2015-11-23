package com.derekentringer.jetgrav.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.derekentringer.jetgrav.JetGrav;
import com.derekentringer.jetgrav.util.constant.GameConstants;

public class DesktopLauncher {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = GameConstants.GAME_WIDTH;
        config.height = GameConstants.GAME_HEIGHT;
		new LwjglApplication(new JetGrav(), config);
	}

}