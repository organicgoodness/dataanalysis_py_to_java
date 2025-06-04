import java.io.*;

public class PythonRunner {
    public static void main(String[] args) {
        System.out.println("こんにちは！");
    }
    public static void runPythonScript() {
        try {
            ProcessBuilder pb = new ProcessBuilder("python3", "../python/analysis.py");
            pb.redirectErrorStream(true);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream())
            );
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("[Python] " + line);
            }

            int exitCode = process.waitFor();
            System.out.println("Python終了コード: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

