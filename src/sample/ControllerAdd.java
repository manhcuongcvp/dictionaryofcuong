package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerAdd {
    @FXML
    private TextField WordTarget;
    @FXML
    private TextField WordExplain;

    public void run() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ControllerAdd.fxml"));
            Scene scene = new Scene(root);
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Thêm từ mới");
            window.setScene(scene);
            window.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Submit (ActionEvent event) {
        String wordTarget = WordTarget.getText();
        String wordExplain = WordExplain.getText();

        if (Controller.DicM.checkLookup(Controller.Dic, wordTarget)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cảnh báo");
            alert.setHeaderText(null);
            alert.setContentText("Từ bạn nhập đã có trong từ điển!");
            alert.showAndWait();
            return;
        }

        if (wordTarget.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cảnh báo");
            alert.setHeaderText(null);
            alert.setContentText("Bạn chưa nhập từ (Eng)!");
            alert.showAndWait();
            return;
        }

        if (wordExplain.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cảnh báo");
            alert.setHeaderText(null);
            alert.setContentText("Bạn chưa nhập nghĩa (Vie)!");
            alert.showAndWait();
            return;
        }

        Controller.DicM.addWord(Controller.Dic, wordTarget, wordExplain);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cảnh báo");
        alert.setHeaderText(null);
        alert.setContentText("Thêm từ thành công!");
        alert.showAndWait();
    }

}
