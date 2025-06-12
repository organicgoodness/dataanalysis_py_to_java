// SparkJava.java
package otameshi.sparkjava;
import static spark.Spark.*;

public class SparkJava {
    public static void main(String[] args) {
        port(4567);

        get("/", (req, res) -> "<h2>Hello, Spark!<h2>/run-java");  // 追加
        // ターミナル(a.sh)で、curl -X POST http://localhost:4567/run-javaを実行する

        post("/run-java", (req, res) -> {
            System.out.println("Java code executed!");
            System.out.flush();
            return "Javaコードが実行されました！";
        });
    }
}
