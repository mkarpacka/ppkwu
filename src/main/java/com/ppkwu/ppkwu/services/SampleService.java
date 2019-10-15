package com.ppkwu.ppkwu.services;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@NoArgsConstructor
public class SampleService {

    public String reverse(String stringToReverse) {

        String reverse = "";

        for (int i = stringToReverse.length() - 1; i >= 0; i--) {
            reverse = reverse + stringToReverse.charAt(i);
        }
        return reverse;
    }

    public HashMap recognizeCharacter(String stringToRecognize) {
        ArrayList digits = new ArrayList();
        ArrayList lowerCaseLetters = new ArrayList();
        ArrayList upperCaseLetters = new ArrayList();
        ArrayList signs = new ArrayList();

        HashMap hashMap = new HashMap();

        for (int i = 0; i < stringToRecognize.length(); i++) {
            if (Character.isDigit(stringToRecognize.charAt(i))) {
                digits.add(stringToRecognize.charAt(i));
            } else if (Character.isLowerCase(stringToRecognize.charAt(i))) {
                lowerCaseLetters.add(stringToRecognize.charAt(i));
            } else if (Character.isUpperCase(stringToRecognize.charAt(i))) {
                upperCaseLetters.add(stringToRecognize.charAt(i));
            } else {
                signs.add(stringToRecognize.charAt(i));
            }
        }

        hashMap.put("digits", digits);
        hashMap.put("lowercaseletters", lowerCaseLetters);
        hashMap.put("uppercaseletters", upperCaseLetters);
        hashMap.put("signs", signs);

        return hashMap;

    }
}
