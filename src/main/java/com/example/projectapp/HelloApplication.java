package com.example.projectapp;

import javafx.animation.PauseTransition;
import javafx.application.Application;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Group;
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
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static javafx.application.Application.launch;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {

        StackPane coverPage = new StackPane();
        Label welcomeLabel = new Label("Welcome to Airline Booking App");
        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        welcomeLabel.setTextFill(Color.WHITE);


        Image coverImage = new Image("/image1.jpg");
        ImageView coverImageView = new ImageView(coverImage);
        coverImageView.setFitHeight(800);
        coverImageView.setFitWidth(600);

        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            coverImageView.setFitWidth(newVal.doubleValue());
        });
        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            coverImageView.setFitHeight(newVal.doubleValue());
        });




        coverPage.getChildren().addAll(coverImageView, welcomeLabel);

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
        loginbutton.setOnAction(e-> flightsearchform());

        Label labelreg = new Label("not registered yet?");
        Hyperlink labelaccount = new Hyperlink(" Create an Account");
        labelaccount.setOnAction(e-> createaccount());


        HBox hboxaccount = new HBox();
        hboxaccount.setAlignment(Pos.CENTER);
        hboxaccount.getChildren().addAll(labelreg,labelaccount);


        Label label2 = new Label("__________or sign up with __________");

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
        root.setCenter(coverPage);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Airline booking app");
        stage.setScene(scene);
        stage.show();


        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(e -> {
            root.setCenter(loginBox);
        });
        pause.play();
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
        newlayout.setMaxWidth(600);

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
        newlayout1.setPadding(new Insets(20));

        Label createaccountlabel  = new Label("Create Account");
        createaccountlabel.setFont(new Font("Ariel",20));
        createaccountlabel.setAlignment(Pos.CENTER);

        Label name1label = new Label("First Name");
        name1label.setFont(new Font(16));
        TextField name1field= new TextField();
        name1field.setPromptText("First name");

        Label lastnamelabel = new Label("Last Name");
        lastnamelabel.setFont(new Font(16));
        TextField lastnamefield = new TextField();
        lastnamefield.setPromptText("Last name");

        Label emaillabel = new Label("Email Address");
        emaillabel.setFont(new Font(16));
        TextField emailtextfield = new TextField();
        emailtextfield.setPromptText("Email address");

        Label passwordlabel = new Label("Password");
        passwordlabel.setFont(new Font(16));
        PasswordField passwordField= new PasswordField();
        passwordField.setPromptText("Password");
        Label passwordtextlabel = new Label("Use at least 8 characters, including both letters and symbols");

        Button createbutton = new Button("Create");
        createbutton.setAlignment(Pos.CENTER);
        createbutton.setPrefWidth(250);
        createbutton.setStyle(
                "-fx-background-color: skyblue;"+
                        "-fx-text-fill: white;"+
                        "-fx-border-radius: 5px;"+
                        "-fx-text-weight: bold;"
        );
        createbutton.setOnAction(e-> System.exit(0));

        Button cancelbutton = new Button("Cancel");
        cancelbutton.setAlignment(Pos.CENTER);
        cancelbutton.setPrefWidth(250);
        cancelbutton.setOnAction(e-> System.exit(0));
        cancelbutton.setStyle(
                "-fx-background-color: skyblue;"+
                        "-fx-text-fill: white;"+
                        "-fx-border-radius: 5px;"+
                        "-fx-text-weight: bold;"
        );
        CheckBox acceptTerms = new CheckBox("I accept the Privacy Policy and Terms of Use.");

        newlayout1.setStyle(
                "-fx-background-color: white;"+
                        "-fx-border-radius: 15;"+
                        "-fx-background-radius:20;"+
                        "-fx-padding: 20;"

        );

        newlayout1.getChildren().addAll(createaccountlabel,name1label,
                name1field,lastnamelabel,lastnamefield,
                emaillabel,emailtextfield,passwordlabel,passwordField,passwordtextlabel,
                acceptTerms,createbutton,cancelbutton);

        StackPane root = new StackPane();
        root.setBackground(new Background(image1));
        root.getChildren().addAll(newlayout1);

        Scene scene = new Scene(root,550,550);
        newstage.setScene(scene);
        newstage.show();

    }

    public void flightsearchform(){
        Stage newstage1 = new Stage();
        newstage1.setTitle("Create flight search form");
        BackgroundImage image1 = new BackgroundImage(
                new Image("image1.jpg",true ),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(
                        100, 100, true, true, true, true
                )
        );
        VBox newlayout2 = new VBox(10);
        newlayout2.setAlignment(Pos.CENTER);
        newlayout2.setMaxWidth(400);
        newlayout2.setPadding(new Insets(20));

        Label flightsearchlabel = new Label("Flight Search");
        flightsearchlabel.setFont(new Font("Ariel",16));

        Label departurelabel = new Label("Departure City:");
        TextField departurefield = new TextField();
        departurefield.setPromptText("Enter your Departure City:");

        Label destinationlabel = new Label("Destination City;");
        TextField destinationfield = new TextField();
        destinationfield.setPromptText("Enter your Destination City:");

        Label departuredatelabel = new Label("Departure Date:");
        DatePicker departuredatepicker = new DatePicker();

        Label returndate= new Label("Return Date:");
        DatePicker returndatepicker = new DatePicker();

        Label flighttype = new Label("Flight Type:");
        RadioButton onewayradio = new RadioButton("One-Way");
        RadioButton roundtripradio = new RadioButton("Round-Trip");
        ToggleGroup flighttypegroup = new ToggleGroup();
        onewayradio.setToggleGroup(flighttypegroup);
        roundtripradio.setToggleGroup(flighttypegroup);

        Label classlabel = new Label("Class");
        ComboBox<String> classcombobox = new ComboBox<String >();
        classcombobox.getItems().addAll("Economy","Business Class");
        HBox citycombohbox = new HBox();
        citycombohbox.setSpacing(5);
        citycombohbox.setAlignment(Pos.CENTER);
        citycombohbox.getChildren().addAll(classlabel,classcombobox);



        Label travelerslabel = new Label("Number of Travelers");
        Spinner<Integer> travelersSpinner = new Spinner<>(1, 10, 1);

        Button searchButton = new Button("Search Flights");
        searchButton.setPrefWidth(200);
        searchButton.setStyle("-fx-background-color: skyblue; -fx-text-fill: white;");
        searchButton.setOnAction(e->flightsearchresultform());


        Button cancelbutton = new Button("Cancel");
        cancelbutton.setPrefWidth(250);
        cancelbutton.setStyle("-fx-background-color: skyblue;"+
                "-fx-text-fill: white;");
        cancelbutton.setOnAction(e->System.exit(0));

        newlayout2.setStyle(
                "-fx-background-color: white;"+
                        "-fx-border-radius: 15;"+
                        "-fx-background-radius:20;"+
                        "-fx-padding: 20;"

        );

        newlayout2.getChildren().addAll(
          flightsearchlabel,departurelabel,departurefield,
          destinationlabel,destinationfield,
                departuredatelabel,departuredatepicker,
                returndate,returndatepicker,
                flighttype,onewayradio,roundtripradio,
                travelerslabel,travelersSpinner,citycombohbox
                ,searchButton,cancelbutton

        );

        StackPane root = new StackPane();
        root.setBackground(new Background(image1));
        root.getChildren().addAll(newlayout2);
        Scene newscene = new Scene(root,550,550);
        newstage1.setScene(newscene);
        newstage1.show();

    }
    public void flightsearchresultform(){
        Stage newstage2 = new Stage();
        newstage2.setTitle("Flight Search Results");

        BackgroundImage image1 = new BackgroundImage(
                new Image("image1.jpg",true ),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(
                        100, 100, true, true, true, true
                )
        );
        VBox newlayout3 = new VBox(10);
        newlayout3.setAlignment(Pos.CENTER);
        newlayout3.setMaxWidth(450);
        newlayout3.setPadding(new Insets(20));

        Label label1 = new Label("Search Flights");
        label1.setFont(new Font("Ariel",18));
        newlayout3.getChildren().addAll(label1);


        ObservableList<Flight> flights = FXCollections.observableArrayList(
          new Flight("Flight 201" ,"Lahore to Islamabad"," 10:00AM"," Rs-20,000"),
                new Flight("Flight 202", "Lahore to Karachi","12:00AM" ," Rs-15,000"),
               new Flight("Flight 304" , "Karachi to Lahore" ,"2:00PM" ,"Rs-13,000"),
                new Flight("Flight 401"," Islamabad to Lahore", "8:00PM" ," Rs-25,000")


        );

        TableView<Flight> flightTable = new TableView<>();
        flightTable.setItems(flights);

        TableColumn<Flight, String> flightNumberColumn = new TableColumn<>("Flight Number");
        flightNumberColumn.setCellValueFactory(cellData -> cellData.getValue().flightNumberProperty());

        TableColumn<Flight, String> destinationColumn = new TableColumn<>("Destination");
        destinationColumn.setCellValueFactory(cellData -> cellData.getValue().destinationProperty());

        TableColumn<Flight, String> timeColumn = new TableColumn<>("Departure Time");
        timeColumn.setCellValueFactory(cellData -> cellData.getValue().timeProperty());

        TableColumn<Flight, String> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());

        flightTable.getColumns().add(flightNumberColumn);
        flightTable.getColumns().add(destinationColumn);
        flightTable.getColumns().add(timeColumn);
        flightTable.getColumns().add(priceColumn);


            newlayout3.getChildren().add(flightTable);

            newlayout3.setStyle(
                    "-fx-background-color: white;" +
                            "-fx-border-radius: 15;" +
                            "-fx-background-radius:20;" +
                            "-fx-padding: 20;"

            );


            StackPane root = new StackPane();
            root.setBackground(new Background(image1));
            root.getChildren().add(newlayout3);

            Scene newscene = new Scene(root, 550, 550);
            newstage2.setScene(newscene);
            newstage2.show();
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
