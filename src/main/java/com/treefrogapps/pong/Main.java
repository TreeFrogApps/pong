package com.treefrogapps.pong;

import com.treefrogapps.pong.controller.PongController;
import com.treefrogapps.pong.view.PongView;
import io.reactivex.schedulers.Schedulers;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.inject.Inject;
import java.util.logging.Logger;

public class Main extends Application {

    public final static Logger LOGGER = Logger.getLogger("PongLogger");


    @Inject PongView pongView;
    @Inject PongController pongController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override public void start(Stage primaryStage) {

        DaggerMainComponent.builder().build().inject(this);
        pongView.attachStage(primaryStage);
        pongController.attachView(pongView);
    }

    @Override
    public void stop() {
        pongController.onShutdown();
    }
}