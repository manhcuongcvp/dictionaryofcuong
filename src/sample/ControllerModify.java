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


public class ControllerModify {
    @FXML
    private TextField WordTarget;
    @FXML
    private TextField WordExplain;

    public void run() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ControllerModify.fxml"));
            Scene scene = new Scene(root);
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Sửa từ");
            window.setScene(scene);
            window.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Submit (ActionEvent event) {
        String wordTarget = WordTarget.getText();
        String wordExplain = WordExplain.getText();

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

        if (Controller.DicM.checkLookup(Controller.Dic, wordTarget) == false) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cảnh báo");
            alert.setHeaderText(null);
            alert.setContentText("Từ bạn nhập chưa có trong từ điển!");
            alert.showAndWait();
            return;
        }

        Controller.DicM.modifyWord(Controller.Dic, wordTarget, wordExplain);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText("Sửa từ thành công!");
        alert.showAndWait();
    }

}
