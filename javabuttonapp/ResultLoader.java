package javabuttonapp;
import java.nio.file.*;
import java.io.IOException;
import org.json.JSONObject;

public class ResultLoader {
    public static void main(String[] args) {
        System.out.println("結果は！");
    }

    public static JSONObject loadResult(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            
            return new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

