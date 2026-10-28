package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {

        // Name
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        // Age
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();

        // Attendance status
        CheckBox presentCheckBox = new CheckBox("Present");

        // Button
        Button createButton = new Button("Create Student");

        // Output
        Label result = new Label();

        // Event handler
        createButton.setOnAction(e -> {

            String name = nameField.getText();

            int age = Integer.parseInt(
                    ageField.getText()
            );

            boolean present =
                    presentCheckBox.isSelected();

            Student student =
                    new Student(name, age, present);

            result.setText(
                    "Name: " + student.getName()
                            + "\nAge: " + student.getAge()
                            + "\nPresent: " + student.isPresent()
            );
        });

        // Layout
        VBox root = new VBox(
                10,
                nameLabel,
                nameField,
                ageLabel,
                ageField,
                presentCheckBox,
                createButton,
                result
        );

        root.setAlignment(Pos.CENTER);

        nameField.setMaxWidth(200);
        ageField.setMaxWidth(200);

        // Scene
        Scene scene = new Scene(root, 450, 450);

        // Stage
        stage.setTitle("Student Registration");
        stage.setScene(scene);
        stage.show();
    }
}
