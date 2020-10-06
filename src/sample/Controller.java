package sample;

import Dictionary.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Controller extends Application implements Initializable {
    @FXML
    private TextField WordTarget;
    @FXML
    private TextArea LookUpZone;
    @FXML
    private TextArea SearcherZone;

    private ControllerAdd controllerAdd = new ControllerAdd();

    public static Dictionary Dic = new Dictionary();
    public static DictionaryManagement DicM = new DictionaryManagement();


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
        this.DicM.insertFromFile(Dic);
    }

    public void ShowAllWord (ActionEvent event) {
        SearcherZone.clear();
        for (int i = 0; i < this.Dic.getSize(); i++) {
            String tempString = Dic.getWord(i).getWord_target();
                SearcherZone.appendText(tempString + "\n");
        }
    }

    public void ChangeInput (KeyEvent event) {
        String wordTarget = WordTarget.getText();

        String wordExplain = DicM.dictionaryLookup(Dic, wordTarget);
        LookUpZone.setText(wordExplain + "\n");

        SearcherZone.clear();
        for (int i = 0; i < this.Dic.getSize(); i++) {
            String tempString = Dic.getWord(i).getWord_target();
            if (wordTarget.equals("")) break;
            if (tempString.contains(wordTarget) == true)
                SearcherZone.appendText(tempString + "\n");
        }
    }

    public static boolean contains (String temp) {
        String wordExplain = DicM.dictionaryLookup(Dic, temp);
        if (wordExplain.equals("The word is not exist in dictionary")) {
            return true;
        }
        return false;
    }

    public void openAddWindow() {
        controllerAdd.run();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
