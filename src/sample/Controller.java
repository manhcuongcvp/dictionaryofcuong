package sample;

import Dictionary.*;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class Controller extends Application implements Initializable {
    @FXML
    private TextField WordTarget;
    @FXML
    private TextArea LookUpZone;
    @FXML
    private TextArea SearcherZone;
    @FXML
    private Button addButton, deleteButton, modifyButton, voiceButton;

    private ControllerAdd controllerAdd = new ControllerAdd();
    private ControllerRemove controllerRemove = new ControllerRemove();
    private ControllerModify controllerModify = new ControllerModify();

    public static Dictionary Dic = new Dictionary();
    public static DictionaryManagement DicM = new DictionaryManagement();


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root, 750, 600));
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
        String wordTarget = WordTarget.getText().toLowerCase();

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

    public void SaveAnyWay (ActionEvent event) throws IOException {
        this.DicM.dictionaryExportToFile(this.Dic);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText("Lưu thay đổi thành công!");
        alert.showAndWait();
    }

    public void VoiceText(ActionEvent e) throws EngineException {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us" + ".cmu_us_kal.KevinVoiceDirectory");
        Central.registerEngineCentral("com.sun.speech.freetts" + ".jsapi.FreeTTSEngineCentral");
        Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));

        Voice voice;
        voice = VoiceManager.getInstance().getVoice("kevin16");
        if (voice != null) {
            voice.allocate();
        } try {
            voice.setRate(190);
            voice.setPitch(150);
            voice.setVolume(3);
            voice.speak(WordTarget.getText());
        } catch (Exception e1) {
                e1.printStackTrace();
        }
    }

    public void openAddWindow() {
        controllerAdd.run();
    }
    public void openRemoveWindow() {
        controllerRemove.run();
    }
    public void openModifyWindow() {
        controllerModify.run();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
