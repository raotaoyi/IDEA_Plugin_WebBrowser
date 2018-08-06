package com.idea.plugin.codemars;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;

public class Demo {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static  String url ;
    private static final String urlStart = "http://";

    public static void main(String[] args) {


        JFrame jFrame=new JFrame();
        final JFXPanel webBrowser = new JFXPanel();
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                try {
                    url = new File("H:\\java\\JAVA----整理之后\\web开发项目示例\\springboot-learning-example-master" +
                             "\\chapter-5-spring-boot-data-jpa\\src\\main\\resources\\templates\\bookForm.html").toURL().toString();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                Group root = new Group();
                Scene scene = new Scene(root, WIDTH, HEIGHT);
                webBrowser.setScene(scene);
                Double widthDouble = new Integer(WIDTH).doubleValue();
                Double heightDouble = new Integer(HEIGHT).doubleValue();

                VBox box = new VBox(10);
                HBox urlBox = new HBox(10);
                final TextField urlTextField = new TextField();
                urlTextField.setText(url);
                Button go = new Button("go");
                urlTextField.setPrefWidth(WIDTH - 70);
                urlBox.getChildren().addAll(urlTextField, go);

                WebView view = new WebView();
                view.setMinSize(widthDouble, heightDouble);
                view.setPrefSize(widthDouble, heightDouble);
                final WebEngine eng = view.getEngine();
                eng.load(url);
                root.getChildren().add(view);

                box.getChildren().add(urlBox);
                box.getChildren().add(view);
                root.getChildren().add(box);
            }
        });

       /* final JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(webBrowser);*/
        jFrame.getContentPane().add(webBrowser);
        jFrame.setVisible(true);
    }

}
