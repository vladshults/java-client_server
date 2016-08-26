package javafxevents;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author student
 */
public class JavaFXEvents extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        
        /*
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });*/
        
        EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
             @Override
            public void handle(MouseEvent event) {
                System.out.printf("Handler clicked on %s Is consumed: %s\n", 
                        event.getSource().getClass().getName(),
                        event.isConsumed()
                        );
                
                
            }
        };
        EventHandler<MouseEvent> filter = new EventHandler<MouseEvent>() {
             @Override
            public void handle(MouseEvent event) {
                //event.consume();
                System.out.printf("Filter clicked on %s Is consumed: %s\n", 
                        event.getSource().getClass().getName(),
                        event.isConsumed()
                        );
                
                            
            }
        };
        
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        
        
        
        btn.setOnMouseClicked(e->{
            System.out.printf("Set on click (%f, %f)\n", e.getX(), e.getY());
            btn.setVisible(false);
        });
        
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        root.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        Scene scene = new Scene(root, 300, 250);
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
