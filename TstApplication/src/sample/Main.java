package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    Label response;

    @Override
    public void start(Stage myStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        // Określa nazwę obszaru roboczego
        myStage.setTitle("Prezentacja list");
// Tworzy panel FlowPane, który zostanie użyty jako węzeł korzenia; w tym
// przypadku odstępy pomiędzy komponentami wynoszą 10
        FlowPane rootNode = new FlowPane(10, 10);
// Wyrównuje kontrolki na scenie do środka
        rootNode.setAlignment(Pos.CENTER);
// Tworzy obiekt sceny
        Scene myScene = new Scene(rootNode, 270, 150);
// Zapisuje obiekt sceny w obszarze roboczym
        myStage.setScene(myScene);
// Tworzy etykietę
        response = new Label("Wybierz środek transportu");
// Tworzy listę ObservableList elementów, które zostaną wyświetlone
// w kontrolce ListView
        ObservableList<String> transportTypes =
                FXCollections.observableArrayList("Pociąg", "Samochód", "Samolot");
// Tworzy listę - kontrolkę ListView
        ListView<String> lvTransport = new ListView<String>(transportTypes);
// Określa preferowaną szerokość i wysokość listy
        lvTransport.setPrefSize(80, 80);
// Pobiera aktualnie używany model wyboru
        MultipleSelectionModel<String> lvSelModel;
        lvSelModel = lvTransport.getSelectionModel();
// Określa obiekt nasłuchujący, który będzie obsługiwał zmianę
// zaznaczonego elementu listy
        lvSelModel.selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> changed,
                                        String oldVal, String newVal) {
// Wyświetla zaznaczony element listy
                        response.setText("Wybranym środkiem transportu jest: " + newVal);
                    }
                });

// Dodaje etykietę i listę do grafu sceny
        rootNode.getChildren().addAll(lvTransport, response);
// Wyświetla obszar roboczy i scenę
        myStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
