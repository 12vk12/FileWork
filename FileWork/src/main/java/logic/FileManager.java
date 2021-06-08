package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {
    String text;
    int sentences = 0;
    int words = 0;
    double punctuationMarks = 0;
    double spaces = 0;
    int wordsWithAVowel = 0;
    int wordsWithAСonsonant = 0;
    double latinWords = 0.0;
    double сyrillicWords = 0.0;

    public FileManager() {
    }

    public FileManager(String text) {
        this.text = text;
        this.sentences = getSentences();
        this.words = getWords();
        this.punctuationMarks = getPunctuationMarks();
        this.spaces = getSpaces();
        this.wordsWithAVowel = getWordsWithAVowel();
        this.wordsWithAСonsonant = getWordsWithAСonsonant();
        this.latinWords = getLatinWords();
        this.сyrillicWords = getСyrillicWords();
    }

    public String getText() {
        return text;
    }

    public int getSentences() {
        String pattern = "([.!?])([\\s\\n])([A-Z&&А-Я]*)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(text);
        int count=0;
        while (m.find( )) {
            count++;
        }
        count++;
        return count;
    }

    public int getWords() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(text.split(" ")));
        for(int i = 0; i < list.size(); i++){
            words++;
        }
        return words;
    }

    public double getPunctuationMarks() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(text.split(" ")));
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).contains(",")) {
                punctuationMarks++;
            }
        }
        return punctuationMarks;
    }

    public double getSpaces() {
        return text.length() - text.replaceAll(" ", "").length();
    }

    public int getWordsWithAVowel() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(text.split(" ")));
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).matches("^(?ui:[аеёиоуыэюяaeiouy]).*")) {
                wordsWithAVowel++;
            }
        }
        return wordsWithAVowel;
    }

    public int getWordsWithAСonsonant() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(text.split(" ")));
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).matches("^(?ui:[йцкнгшщзхфвпрлджбтмсчqwrtplkjhgfdszxcvbnm]).*")) {
                wordsWithAСonsonant++;
            }
        }
        return wordsWithAСonsonant;
    }

    public double getLatinWords() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(text.split(" ")));
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).matches("^[a-zA-Z0-9]+$")) {
                latinWords++;
            }
        }
        return latinWords;
    }

    public double getСyrillicWords() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(text.split(" ")));
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).matches("^[а-яА-Я]+$")) {
                сyrillicWords++;
            }
        }
        return сyrillicWords;
    }

    @Override
    public String toString() {
        return
                "Количество предложений: " + sentences + "\n"+
                        "Количество слов: " + words + "\n"+
                        "Количество знаков препинания: " + punctuationMarks + "\n"+
                        "Количество пробелов: " + spaces + "\n"+
                        "Количество слов начинающихся с гласной буквы (латиница+кириллица): " + wordsWithAVowel + "\n"+
                        "Количество слов начинающихся с согласной буквы (латиница+кириллица): " + wordsWithAСonsonant+ "\n"+
                        "Количество слов (кириллица): " + getСyrillicWords()+ "\n"+
                        "Количество слов (латиница): " + getLatinWords()+ "\n"+
                        "Отношение слов на латинице к словам на кириллице: " + (getLatinWords() / getСyrillicWords()) + "\n"+
                        "Отношение латинских символов к кириллическим символам: " + (getСyrillicWords() / getLatinWords())+ "\n"+
                        "Отношение знаков препинания к символам (знаки + кол-во пробелов): " + (double)(getPunctuationMarks() / getSpaces());
    }
}
