package com.derekentringer.jetgrav;

import com.badlogic.gdx.Game;
import com.derekentringer.jetgrav.screen.GameScreen;

public class JetGrav extends Game {

    @Override
    public void create() {
        setScreen(new GameScreen());
    }

}