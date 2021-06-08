package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingText {
    String path;

    public ReadingText(String path) {
        this.path = path;
    }

    public ReadingText() {
    }

    public String getText() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null){
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();

    }
}
