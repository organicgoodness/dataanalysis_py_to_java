package java_reading_json;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class JsonArrayUpdater {
    public static void main(String[] args) throws Exception {
        String content = Files.readString(Paths.get("data_content.json"), StandardCharsets.UTF_8);
        JSONArray array = new JSONArray(content);

        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            if ("Alice".equals(obj.getString("name"))) {
                obj.put("age", 28); // Aliceの年齢更新
            }
        }

        Files.write(Paths.get("data_content.json"), array.toString(2).getBytes(StandardCharsets.UTF_8));
        System.out.println("更新完了");
    }
}
