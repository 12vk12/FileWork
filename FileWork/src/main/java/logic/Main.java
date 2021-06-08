package logic;


import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/input/Shantaram.txt")));
            BufferedWriter findCirilic = new BufferedWriter(new FileWriter("src/main/resources/output/CirilicOutputShantaram.txt"));
            BufferedWriter findLatin = new BufferedWriter(new FileWriter("src/main/resources/output/LatinOutputShantaram.txt"));
            BufferedWriter findInfo = new BufferedWriter(new FileWriter("src/main/resources/output/InfoOutputShantaram.txt"))) {

            String text;

            while((text = br.readLine()) != null){
                boolean result = Pattern.matches(".*\\p{InCyrillic}.*", text);
                if(result) {
                    findCirilic.write(text + "\n");
                    findCirilic.flush();
                }else {
                    findLatin.write(text + "\n");
                    findLatin.flush();
                }
            }

            ReadingText readingText = new ReadingText("src/main/resources/input/Shantaram.txt");
            String readingAllText = readingText.getText();
            FileManager fileManager = new FileManager(readingAllText);
            String reworkedText = fileManager.toString();

            File myFile = new File("src/main/resources/input/Shantaram.txt");
            String absolutePath = myFile.getAbsolutePath();
            String nameFile = myFile.getName();
            long sizeFile = myFile.length()/1024;
            boolean read = myFile.canRead();
            boolean write = myFile.canWrite();
            findInfo.write("Абсолютный путь файла - " + absolutePath + ", имя файла - " + nameFile + "\n");
            findInfo.write("Размер файла - " + sizeFile + " Кб" + "\n");
            findInfo.write("Вы " + (read ? "" : "не ") + "можете читать файл" + "\n");
            findInfo.write("Вы " + (write ? "" : "нe ") + "можете записывать в файл" + "\n");
            findInfo.write(reworkedText);
            findInfo.flush();

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
