package javabuttonapp;/*どのディレクトリのファイルか(コンパイル)*/

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import org.json.JSONObject;


public class MainApp {
    public static void main(String[] args) {
        PythonRunner.runPythonScript();
        
        JSONObject item = ResultLoader.loadResult("data_content.json");
        JSONArray array = new JSONArray(item);

        if (array != null) {
            for (int i = 0; i < array.length(); i++) {
                JSONObject person = array.getJSONObject(i);
                String display = String.format("name: %s\nage: %d\ntitle: %s\nedit title etc...",
                        person.getString("name"), person.getDouble("age"), person.getString("title"));

                JOptionPane.showMessageDialog(null, display, "分析結果", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "結果の読み込みに失敗しました", "エラー", JOptionPane.ERROR_MESSAGE);
        }
    }
}