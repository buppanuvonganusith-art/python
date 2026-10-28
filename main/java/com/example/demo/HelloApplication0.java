package com.example.demo;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication0 extends Application {

    @Override
    public void start(Stage stage) {

        // Create controls
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();

        Label presentLabel = new Label("Present:");
        CheckBox presentCheckBox = new CheckBox();

        Button createButton = new Button("Create Student");

        Label result = new Label();

        // Create form layout
        GridPane form = new GridPane();

        form.setHgap(10);
        form.setVgap(15);
        form.setAlignment(Pos.CENTER);

        form.add(nameLabel, 0, 0);
        form.add(nameField, 1, 0);

        form.add(ageLabel, 0, 1);
        form.add(ageField, 1, 1);

        form.add(presentLabel, 0, 2);
        form.add(presentCheckBox, 1, 2);

        form.add(createButton, 1, 3);

        // Set input field widths
        nameField.setPrefWidth(200);
        ageField.setPrefWidth(200);

        // Handle Create Student button click
        createButton.setOnAction(e -> {

            String name = nameField.getText().trim();

            // Validate name
            if (name.isEmpty()) {
                result.setText("Please enter a name.");
                return;
            }

            try {

                int age = Integer.parseInt(
                        ageField.getText().trim()
                );

                // Validate age
                if (age <= 0) {
                    result.setText(
                            "Age must be greater than 0."
                    );
                    return;
                }

                boolean present =
                        presentCheckBox.isSelected();

                // Create Student object
                Student student =
                        new Student(name, age, present);

                // Display Student information
                result.setText(
                        "Name: " + student.getName()
                                + "\nAge: " + student.getAge()
                                + "\nPresent: " + student.isPresent()
                );

            } catch (NumberFormatException ex) {

                result.setText(
                        "Please enter a valid number for age."
                );
            }
        });

        // Main layout
        VBox root = new VBox(
                25,
                form,
                result
        );

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        // Create scene
        Scene scene =
                new Scene(root, 500, 400);

        // Configure stage
        stage.setTitle("Student Registration");
        stage.setScene(scene);
        stage.show();
    }
}