package com.example.project2;



import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;


public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Ensure database table exists
        CreateTable.createNewTable();

        // Load your main scene
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication2.class.getResource("MainScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    @FXML
    private Button genInfo;

    @FXML
    private Button orderaDelivery;

    @FXML
    private Button orderOnSpot;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private Button genButton;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private Button proceed2;

    @FXML
    private RadioButton rdb;

    @FXML
    private RadioButton rdb4;

    @FXML
    private RadioButton rdb3;

    @FXML
    private RadioButton rdb2;

    @FXML
    private Button logIn;
    @FXML
    private Button backOne;
    @FXML
    private Button backTwo;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField username;


    @FXML
    private Button prooceed1;
    @FXML
    private Text cheeseCart;
    @FXML
    private Text pepperoniCart;
    @FXML
    private Text mushroomCart;
    @FXML
    private Text drinkCart;
    @FXML
    private Text total;
    @FXML
    private CheckBox deliver;
    @FXML
    private Button confirmation;

    int cheeseCount = 0, pepperoniCount = 0, mushroomCount = 0, drinkCount = 0;
    double totalPrice = 0.0;

    public void menuChoice() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication2.class.getResource("OrderOnSpot.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void menuChoice2() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication2.class.getResource("OrderaDelivery.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();


    }

    public void menuChoice3() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication2.class.getResource("GenInfo.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }


    public void menuChoice4() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication2.class.getResource("logIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void userChecker() throws IOException {
        if (username.getText().equals("Test") && pass.getText().equals("Test")) {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication2.class.getResource("OrderaDelivery.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
            Stage thisStage = (Stage) logIn.getScene().getWindow();
            thisStage.close();
        } else {
            Stage stage = (Stage) logIn.getScene().getWindow();
            stage.close();
        }
    }

    public void goBackOne() {
        Stage stage = (Stage) backOne.getScene().getWindow();
        stage.close();
    }

    public void goBackTwo() {
        Stage stage = (Stage) backTwo.getScene().getWindow();
        stage.close();
    }

    public void addCheeseToCart() {
        cheeseCount++;
        cheeseCart.setText("In cart: " + cheeseCount);
        totalPrice += 5.99;
        totalPrice = (double) Math.round(totalPrice * 100) / 100;
        total.setText("Total: " + totalPrice);
    }

    public void addPepperoniToCart() {
        pepperoniCount++;
        pepperoniCart.setText("In cart: " + pepperoniCount);
        totalPrice += 7.99;
        totalPrice = (double) Math.round(totalPrice * 100) / 100;
        total.setText("Total: " + totalPrice);
    }

    public void addMushroomToCart() {
        mushroomCount++;
        mushroomCart.setText("In cart: " + mushroomCount);
        totalPrice += 6.99;
        totalPrice = (double) Math.round(totalPrice * 100) / 100;
        total.setText("Total: " + totalPrice);
    }

    public void addDrinkToCart() {
        drinkCount++;
        drinkCart.setText("In cart: " + drinkCount);
        totalPrice += 2;
        totalPrice = (double) Math.round(totalPrice * 100) / 100;
        total.setText("Total: " + totalPrice);
    }

    public void removeCheeseFromCart() {
        if (cheeseCount > 0) {
            cheeseCount--;
            cheeseCart.setText("In cart: " + cheeseCount);
            totalPrice -= 5.99;
            totalPrice = (double) Math.round(totalPrice * 100) / 100;
            total.setText("Total: " + totalPrice);
        }
    }

    public void removePepperoniFromCart() {
        if (pepperoniCount > 0) {
            pepperoniCount--;
            pepperoniCart.setText("In cart: " + pepperoniCount);
            totalPrice -= 7.99;
            totalPrice = (double) Math.round(totalPrice * 100) / 100;
            total.setText("Total: " + totalPrice);
        }
    }

    public void removeMushroomFromCart() {
        if (mushroomCount > 0) {
            mushroomCount--;
            mushroomCart.setText("In cart: " + mushroomCount);
            totalPrice -= 6.99;
            totalPrice = (double) Math.round(totalPrice * 100) / 100;
            total.setText("Total: " + totalPrice);
        }
    }

    public void removeDrinkFromCart() {
        if (drinkCount > 0) {
            drinkCount--;
            drinkCart.setText("In cart: " + drinkCount);
            totalPrice -= 2;
            totalPrice = (double) Math.round(totalPrice * 100) / 100;
            total.setText("Total: " + totalPrice);
        }
    }

    public void delivery() {
        if (deliver.isSelected()) {
            totalPrice += 5;
            total.setText("Total: " + totalPrice);
        } else {
            totalPrice -= 5;
            total.setText("Total: " + totalPrice);
        }
    }

    public void cancelOrder() {
        cheeseCount = 0;
        pepperoniCount = 0;
        mushroomCount = 0;
        drinkCount = 0;
        cheeseCart.setText("In cart: 0");
        pepperoniCart.setText("In cart: 0");
        mushroomCart.setText("In cart: 0");
        drinkCart.setText("In cart: 0");
        totalPrice = 0.0;
        total.setText("Total: " + totalPrice);
        deliver.setSelected(false);

    }

    public void orderCheckout() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication2.class.getResource("Checkout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setScene(scene);
        stage.show();
        cancelOrder();
    }

    public void confirm() {
        Stage stage = (Stage) confirmation.getScene().getWindow();
        stage.close();
    }

    public void goBackThree() {
        Stage stage = (Stage) genButton.getScene().getWindow();
        stage.close();
    }

    public class DatabaseConnection {
        public static Connection connect() {
            // MySQL connection URL
            String url = "jdbc:mysql://localhost:3306/testdb"; // replace with your database name and host
            String user = "your_username"; // replace with your MySQL username
            String password = "your_password"; // replace with your MySQL password

            Connection conn = null;
            try {
                // Load the JDBC driver (optional, depends on the driver version)
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connection to MySQL has been established.");
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Class Not Found Exception: " + e.getMessage());
            }
            return conn;
        }
    }



    public class InsertData {
        public static void insert(String name, String email) {
            String sql = "INSERT INTO users(name, email) VALUES(?,?)";

            try (Connection conn = DatabaseConnection.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public void addUserToDatabase() {
            String name = username.getText();
            String email = pass.getText();
            InsertData.insert(name, email);

            username.clear();
            pass.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("User Added");
            alert.setHeaderText(null);
            alert.setContentText("User has been added to the database!");
            alert.showAndWait();
        }


        public void userChecker() throws IOException {
            if (username.getText().equals("Test") && pass.getText().equals("Test")) {
                addUserToDatabase();
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication2.class.getResource("OrderaDelivery.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.show();
                Stage thisStage = (Stage) logIn.getScene().getWindow();
                thisStage.close();
            } else {
                Stage stage = (Stage) logIn.getScene().getWindow();
                stage.close();
            }
        }

    }

    public class CreateTable {
        public static void createNewTable() {
            String url = "jdbc:sqlite:your-database-file.db";

            String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                    + "    id integer PRIMARY KEY,\n"
                    + "    name text NOT NULL,\n"
                    + "    email text NOT NULL\n"
                    + "    password text NOT NULL\n"
                    + ");";

            try (Connection conn = DatabaseConnection.connect();
                 Statement stmt = conn.createStatement()) {
                // create a new table
                stmt.execute(sql);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
