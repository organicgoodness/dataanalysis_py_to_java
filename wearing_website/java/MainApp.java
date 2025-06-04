import javax.swing.*;
import org.json.JSONObject;

public class MainApp {
    public static void main(String[] args) {
        PythonRunner.runPythonScript();
        JSONObject result = ResultLoader.loadResult("../data_content.json");

        if (result != null) {
            String display = String.format("name: %s\nage: %d\ntitle: %s\nedit title etc...",
                    result.getDouble("name"), result.getDouble("age"), result.get("title"));

            JOptionPane.showMessageDialog(null, display, "分析結果", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "結果の読み込みに失敗しました", "エラー", JOptionPane.ERROR_MESSAGE);
        }
    }
}

