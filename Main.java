package com.Internshala.JavaFX;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    public static void main(String[] args) {
        System.out.println("Main");
        launch(args);

    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Start");
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("app_layout.fxml")); //Connect main to fxml file
        VBox rootNode = loader.load();

        MenuBar menuBar =createMenu(); //menu bar
        rootNode.getChildren().add(0,menuBar);
        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();    //make application visible to user

    }

    private MenuBar createMenu(){

        Menu fileMenu =new Menu("File");        //file menu
        MenuItem newMenuItem = new MenuItem("New");

        newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");

        quitMenuItem.setOnAction(event ->{
            Platform.exit();
            System.exit(0);
        });


        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

        Menu helpMenu =new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");

        aboutApp.setOnAction(event -> aboutApp());

        helpMenu.getItems().addAll(aboutApp);
        //Menu Bar
        MenuBar menuBar =new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutApp()
    {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop Application");
        alertDialog.setHeaderText("Learning JAVAFX");
        alertDialog.setContentText("I am just a beginner but soon i will be pro");

        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");

        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);

        Optional<ButtonType> clickedBtn =alertDialog.showAndWait();

        if(clickedBtn.isPresent() && clickedBtn.get()==yesBtn)
        {
            System.out.println("Yes Button Clicked");
        }
        else
        {
            System.out.println("No Button Clicked");
        }

    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stop");
        super.stop();
    }
}
