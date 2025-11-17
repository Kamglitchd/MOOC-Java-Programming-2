/*
 * ==============================================================
 *   Project: 
 *   Author: KamGlitchd
 *   Created on: Nov 16, 2025
 * 
 *   Description: dictionary — 
 * 
 *   License: Personal / Educational Use Only
 *   (Modify and reuse freely for learning or personal work)
 * ==============================================================
 */
package dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class SaveableDictionary {
    private HashMap<String, String> translations;
    private String file;
    private Scanner fileReader;

    public SaveableDictionary() {
        translations = new HashMap<>();
    }

    public SaveableDictionary(String file) throws IOException {
        this();
        this.file = file;
        //Try to get file
        try {
            this.fileReader = new Scanner(Paths.get(file));
        } catch (IOException e) {
            this.fileReader = null; 
            System.err.println("Warning: Could not open file '" + file 
                    + e.getMessage());
        }
    }

    public boolean load() {
        // Check if the fileReader was initialized
        if (this.fileReader == null) {
            return false;
        }

        boolean wasSuccessful = false; // Flag to track data was loaded

        //Read word + translation split up by :
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] parts = line.split(":");

            String word = parts[0];
            String translation = parts[1];

            // Code to read a line and add translation ...
            add(word, translation);
            wasSuccessful = true;
        }
        return wasSuccessful;
    }

    //Saves the dictionary to the file, overwrites previous content
    public boolean save() {
        if (this.file == null) {
            return false;
        }
        
        try (FileWriter writer = new FileWriter(this.file)) {

            //Iterate over every key in translations
            for (String word : this.translations.keySet()) {
                String translation = this.translations.get(word);

                //Follow format: word:translation
                writer.write(word + ":" + translation + "\n");
            }

            // If the loop completes without error, the save was successful
            return true;
        } catch (IOException e) {
            System.out.println("Error saving dictionary to file: " + e.getMessage());
            return false;
        }
    }

    public void add(String words, String translation) {
        translations.putIfAbsent(words, translation);//Check if key exists and adds if not present
    }

//Checks if dictionary contains translation by either word
    public String translate(String word) {
        if (translations.containsValue(word)) {
            try {
                //To search by value, filter the keys as a set and find which one has that value
                String key = translations.entrySet().stream()
                        .filter(entry -> entry.getValue().equals(word))
                        .map(Map.Entry::getKey)
                        .findAny()
                        .orElseThrow(() -> new NoSuchElementException("Value not found"));
                return key;
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return translations.get(word);//If word is the key then just return value
    }

    public void delete(String word) {
        translations.remove(word);//Removal if String word is key
        List<String> toDelete = new ArrayList<>();

        //Removal if String word is value
        for (Map.Entry<String, String> entry : translations.entrySet()) {
            if (entry.getValue().equals(word)) {
                //Adds keys of the value to be deleted to the arraylist
                toDelete.add(entry.getKey());
            }
        }

        //Traverse list and removes all coresponding keys from map
        for (String string : toDelete) {
            translations.remove(string);
        }
    }
}
