
package com.example.semesterproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.ScrollPane;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class HelloApplication extends Application {
 @Override
 public void start(Stage stage) {

  BorderPane root = new BorderPane();
  BackgroundImage image1 = new BackgroundImage(
          new Image("image1.jpg",true ),
         BackgroundRepeat.NO_REPEAT,
                 BackgroundRepeat.NO_REPEAT,
          BackgroundPosition.CENTER,
           new BackgroundSize(
          100, 100, true, true, true, true
           )
  );
  root.setBackground(new Background(image1));

  VBox loginBox = new VBox(15);
  loginBox.setAlignment(Pos.CENTER);
  loginBox.setMaxWidth(400);
  loginBox.setMaxHeight(400);
  loginBox.setPadding(new Insets(20));

  HBox airhbox = new HBox();


  Image airimage = new Image("imae3.jpg");
  ImageView airimageview = new ImageView(airimage);
  airimageview.setPreserveRatio(true);

 Label loginlabel = new Label("LOGIN");
 loginlabel.setFont(new Font(20));
 airhbox.getChildren().addAll(airimageview,loginlabel);

  TextField namefield = new TextField();
  namefield.setPromptText("Enter your name");
  namefield.setMaxWidth(350);

  TextField emailfield = new TextField();
  emailfield.setPromptText("Enter your email");
  emailfield.setMaxWidth(350);

  PasswordField passwordfield = new PasswordField();
  passwordfield.setPromptText("Enter your password");
  passwordfield.setMaxWidth(350);


  Hyperlink forgetpasswordlink = new Hyperlink("Forget Password?");
  forgetpasswordlink.setOnAction(e-> createforgetpasswordlink());

  Button loginbutton = new Button("Login");
  loginbutton.setPrefWidth(250);
  loginbutton.setTextFill(Color.WHITE);

  Label labelreg = new Label("not registered yet?");
  Hyperlink labelaccount = new Hyperlink(" Create an Account");
  labelaccount.setOnAction(e-> createaccount());


   HBox hboxaccount = new HBox();
   hboxaccount.setAlignment(Pos.CENTER);
   hboxaccount.getChildren().addAll(labelreg,labelaccount);


  Label label2 = new Label("______________or sign up with ____________");

HBox googlebox = new HBox();
googlebox.setAlignment(Pos.CENTER);
Image googleimage = new Image("image2.png");
ImageView googleimageview = new ImageView(googleimage);
googleimageview.setFitHeight(20);
googleimageview.setPreserveRatio(true);

  Hyperlink googlelink = new Hyperlink("Sign up with Google");
  googlelink.setStyle("-fx-text-fill: blue; -fx-font-size: 14");
  googlelink.setOnAction(e->  openwebpage ("https://www.google.co.uk/"));
  googlebox.getChildren().addAll(googleimageview,googlelink);

 loginbutton.setStyle(
          "-fx-background-color: skyblue;"+
                  "-fx-font-size: 14px;"+
                  "-fx-border-radius: 5px;"+
                  "-fx-border-color: black;"
  );

  loginBox.getChildren().addAll(
          airhbox,namefield,
          emailfield,passwordfield,
          forgetpasswordlink,loginbutton,
          hboxaccount,label2,googlebox
  );

  loginBox.setStyle(
          "-fx-background-color: white;"+
                  "-fx-border-radius: 15;"+
                  "-fx-background-radius:20;"+
                  "-fx-padding: 20;"

  );

  root.setCenter(loginBox);

  Scene scene = new Scene(root, 800, 600);
  stage.setTitle("Airline booking app");
  stage.setScene(scene);
  stage.show();
 }

 private void createforgetpasswordlink(){
    Stage newstage = new Stage();
    newstage.setTitle("Create new Password");

  BackgroundImage image1 = new BackgroundImage(
          new Image("image1.jpg",true ),
          BackgroundRepeat.NO_REPEAT,
          BackgroundRepeat.NO_REPEAT,
          BackgroundPosition.CENTER,
          new BackgroundSize(
                  100, 100, true, true, true, true
          )
  );
  VBox newlayout = new VBox(20);
  newlayout.setAlignment(Pos.CENTER);
  newlayout.setMaxHeight(400);
  newlayout.setMaxWidth(400);

  Label newpasswordlabel = new Label("New Password");
  newpasswordlabel.setFont(new Font(18));
  PasswordField passwordfield = new PasswordField();
  passwordfield.setPromptText("Enter your password");
  passwordfield.setMaxWidth(350);

  Label confirmpasswordlabel = new Label("Confirm new Password");
  confirmpasswordlabel.setFont(new Font(18));
  PasswordField resetpasswordfield = new PasswordField();
  resetpasswordfield.setPromptText("Re-enter your password");
  resetpasswordfield.setMaxWidth(350);

  Button submitbutton = new Button("Submit");
  submitbutton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
  submitbutton.setOnAction(e->newstage.close());

  Button cancelbutton = new Button("Cancel");
  cancelbutton.setStyle("-fx-background-color: Red; -fx-text-fill: white");
  cancelbutton.setOnAction(e->newstage.close());

  HBox buttonhbox = new HBox(20);
  buttonhbox.setAlignment(Pos.CENTER);
  buttonhbox.getChildren().addAll(submitbutton,cancelbutton);

  newlayout.getChildren().addAll(
          newpasswordlabel,passwordfield,
          confirmpasswordlabel,resetpasswordfield,buttonhbox
  );

  newlayout.setBackground(new Background(image1));
  newlayout.setStyle(
          "-fx-background-color: white;"+
                  "-fx-border-radius: 15;"+
                  "-fx-background-radius:20;"+
                  "-fx-padding: 20;"

  );

  StackPane root = new StackPane();
  root.setBackground(new Background(image1));
  root.getChildren().addAll(newlayout);

  Scene newscene = new Scene(root,550,550);
  newstage.setScene(newscene);
  newstage.show();

  }

  public void createaccount(){
  Stage newstage = new Stage();
   newstage.setTitle("Create new Password");

   BackgroundImage image1 = new BackgroundImage(
           new Image("image1.jpg",true ),
           BackgroundRepeat.NO_REPEAT,
           BackgroundRepeat.NO_REPEAT,
           BackgroundPosition.CENTER,
           new BackgroundSize(
                   100, 100, true, true, true, true
           )
   );


   VBox newlayout1 = new VBox(20);
   newlayout1.setAlignment(Pos.CENTER);
   newlayout1.setMaxHeight(400);
   newlayout1.setMaxWidth(400);

   StackPane root = new StackPane();
   root.setBackground(new Background(image1));
   root.getChildren().addAll(newlayout1);
  Scene scene = new Scene(root,550,550);
  newstage.setScene(scene);
  newstage.show();

  }


 private void openwebpage(String url) {
  try {
   Desktop.getDesktop().browse(new URI(url));
  } catch (IOException | URISyntaxException e) {
   e.printStackTrace();
  }
 }

public static void main(String[] args) {
 launch();
}
}








