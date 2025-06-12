package javabuttonapp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        try {
            // JSONファイルを文字列として読み込み
            String jsonText = new String(Files.readAllBytes(Paths.get("data_content.json")), StandardCharsets.UTF_8);

            // JSONArrayとしてパース
            JSONArray array = new JSONArray(jsonText);

            // ループして中身を表示
            if (array != null) {
                for (int i = 0; i < array.length(); i++) {
                    JSONObject item = array.getJSONObject(i);
                    String name = item.getString("name");
                    int age = item.getInt("age");
                    System.out.println("Name: " + name + ", Age: " + age);

                    //JSONObject person = array.getJSONObject(i);
                    String display = String.format("name: %s\nage: %d\ntitle: %s\nedit title etc...",
                            item.getString("name"), item.getInt("age"), item.getString("title"));

                    JOptionPane.showMessageDialog(null, display, "分析結果", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "結果の読み込みに失敗しました", "エラー", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException e) {
            System.out.println("ファイル読み込みエラー: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("パースエラー: " + e.getMessage());
        }
    }
}
