package com.yazlab.Service;

import com.yazlab.Entity.Input;
import com.yazlab.Repository.TextMongoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TextService {

    @Autowired
    TextMongoDb textMongoDbImpl;

    @Autowired
    Input input;


    public ArrayList<String> allText = new ArrayList<String>();

    public TextService(ArrayList<String> allText) {
        this.allText = allText;
    }

    public Object TextCollection() {
        return allText;
    }

    public Object TextCollection(String inputText) {
        allText.add(inputText);
        input.setText(inputText);
        textMongoDbImpl.save(input);
        return null;
    }

    public String mainMergeTexts() {

        String mergedText = mergeTexts(allText);
        input.setText(mergedText);
        textMongoDbImpl.save(input);
        return mergedText;
    }

    public static String mergeTexts(ArrayList<String> texts) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < texts.size(); i++) {
            String currentText = texts.get(i);
            int overlap = 0;
            if (i > 0) {
                overlap = getOverlap(texts.get(i - 1), currentText);
            }
            sb.append(currentText.substring(overlap));
        }
        return sb.toString();
    }

    public static int getOverlap(String text1, String text2) {
        int overlap = 0;
        int maxLength = Math.min(text1.length(), text2.length());
        for (int i = 1; i <= maxLength; i++) {
            if (text1.substring(text1.length() - i).equals(text2.substring(0, i))) {
                overlap = i;
            }
        }
        return overlap;
    }


}
