package com.idea.plugin.codemars.gui.toolwindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.uiDesigner.core.GridLayoutManager;
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
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ToolWindowPanel extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String url = "http://blog.csdn.net/ml3947";
    private static final String urlStart = "http://";
    public ToolWindowPanel(Project project, ToolWindow toolWindow) {
        setBorder(new EmptyBorder(1, 1, 1, 1));
        setPreferredSize(new Dimension(300, 150));
        final JFXPanel webBrowser = new JFXPanel();
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
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
        add(webBrowser);
    }
}
