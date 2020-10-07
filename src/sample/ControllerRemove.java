package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;

public class ControllerRemove {
    @FXML
    private TextField WordTarget;

    public void run() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ControllerRemove.fxml"));
            Scene scene = new Scene(root);
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Xóa từ khỏi từ điển");
            window.setScene(scene);
            window.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Submit (ActionEvent event) {
        String wordTarget = WordTarget.getText();

        if (Controller.DicM.checkLookup(Controller.Dic, wordTarget) == false) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cảnh báo");
            alert.setHeaderText(null);
            alert.setContentText("Từ bạn nhập chưa có trong từ điển!");
            alert.showAndWait();
            return;
        }

        if (wordTarget.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cảnh báo");
            alert.setHeaderText(null);
            alert.setContentText("Bạn chưa nhập từ!");
            alert.showAndWait();
            return;
        }

        Controller.DicM.removeWord(Controller.Dic, wordTarget);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText("Xóa từ thành công");
        alert.showAndWait();
    }
}
