package com.mygdx.firstgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class PauseScreen implements Screen {

    final Drop game;
    final GameScreen gameScreen;
    OrthographicCamera camera;
    Rectangle pauseButton;

    public PauseScreen(final Drop game, final GameScreen gameScreen) {
        this.game = game;
        this.gameScreen = gameScreen;
        gameScreen.pause();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        pauseButton = new Rectangle(100, 150, 200, 20);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Game paused. Press on text to resume", 100, 150);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            Vector3 touchPoint = new Vector3();
            touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            //TODO: Figure out where text is in relation to button / how to draw rectangle
            Gdx.app.log("Info", "X = " + touchPoint.x + ", Y = " + touchPoint.y);
            if (pauseButton.contains(touchPoint.x, touchPoint.y)) {
                game.setScreen(gameScreen);
                gameScreen.resume();
                dispose();
            }
        }
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
