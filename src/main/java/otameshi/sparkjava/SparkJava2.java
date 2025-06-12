// SparkJava.java
package otameshi.sparkjava;
import static spark.Spark.*;

public class SparkJava2 {
    public static void main(String[] args) {
        port(4500);

        // POSTリクエストを受け取って.shを実行
        post("/run-script", (req, res) -> {
            try {
                ProcessBuilder pb = new ProcessBuilder("/bin/bash", "a.sh");
                pb.redirectErrorStream(true);
                Process process = pb.start();

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder output = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }

                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    return output.toString();
                } else {
                    return "エラー: 終了コード " + exitCode + "\n" + output;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "エラーが発生しました: " + e.getMessage();
            }
        });
    }
}
