package javafxapp;

import javafx.application.Application;
//import javafx.event.Event;
import javafx.fxml.FXMLLoader;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
import javafx.scene.*;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ListView;
//import javafx.scene.control.ProgressBar;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Pane;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.scene.text.Text;

import javafx.stage.Stage;

public class JavaFXApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GridPane.fxml"));
        Scene scene = new Scene(root);
        
        //Scene scene = new Scene(createPane(), 550, 550);
        stage.setTitle("JavaFXML App");
        stage.setScene(scene);
        stage.show();
    }
    /*
    private void btnFindClick(Event ev){
        System.out.println("Find!");
    }
    private void btnCancelClick(Event ev){
        System.out.println("Try to Cancel!"); 
    }
    private Pane createPane(){
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));        
        
        Text title = new Text("File finder");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        root.add(title, 0, 0, 2, 1);
        
        Label pathL = new Label("Input path:");
        root.add(pathL, 0, 1);
        
        TextField path = new TextField("C:\\Program Files");
        path.setId("pathId");
        root.add(path, 1, 1);
        
        Label endL = new Label("File ends with:");
        root.add(endL, 0, 2);
        
        TextField end = new TextField(".pdf");
        end.setId("endId");
        root.add(end, 1, 2);

        Button btnFind = new Button();
        btnFind.setText("Find");
        btnFind.setOnAction(this::btnFindClick);
        root.add(btnFind,0,3);
            
        HBox box=new HBox();
        Button btnCancel = new Button();
        btnCancel.setText("Cancel");
        btnCancel.setOnAction(this::btnCancelClick);
        
        ProgressBar bar=new ProgressBar();
        bar.setId("barId");
        bar.setMinWidth(200);
        bar.setTranslateX(100);
        bar.setProgress(0);

        box.getChildren().add(btnCancel);
        box.getChildren().add(bar);
        root.add(box,1,3);
        
        ListView<String> list = new ListView<>();
        list.setMinWidth(500);
        list.setId("listId");
        root.add(list,0,4,2,1);
        
        return root;
    }*/
}
