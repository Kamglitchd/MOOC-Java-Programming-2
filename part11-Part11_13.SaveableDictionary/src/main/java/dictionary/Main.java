package dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    //Check if a word exists in the dictionary
    public static boolean checkTranslation(SaveableDictionary dict, String word, String expected) {
        try {
            String content = Files.readString(Paths.get("words.txt"));
            if (content.contains(word + ":" + expected)) {
                System.out.println("Verification successful: File contains the"
                        + " new entry: " + word + ":" + expected);
                return true;
            } else {
                System.out.println("Verification failed: File is missing the"
                        + " new entry: " + word + ":" + expected);
                System.out.println("File Content:\n" + content);
                return false;
            }
        } catch (IOException e) {
            System.out.println("Error reading file for verification: " 
                    + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        // You can test your dictionary here
        String fileName = "words.txt";

        // --- 1. Load, Modify, and Save ---
        System.out.println("--- STEP 1: Load, Modify, and Save ---");
        try {
            //Load file
            SaveableDictionary dictionaryToSave = new SaveableDictionary(fileName);
            if (dictionaryToSave.load()) {
                System.out.println("Initial load successful.");
            } else {
                System.out.println("Initial load failed or file was empty.");
            }

            //Add new translation
            String newWord = "kissa";
            String newTranslation = "cat";
            dictionaryToSave.add(newWord, newTranslation);
            System.out.println("Added new translation: " + newWord + " = " 
                    + newTranslation);

            if (dictionaryToSave.save()) {
                System.out.println("Successfully saved the dictionary to " 
                        + fileName);
            } else {
                System.out.println("Save failed.");
                return;
            }

        } catch (Exception e) {
            System.out.println("An error occurred during the save process: " 
                    + e.getMessage());
            e.printStackTrace();
            return;
        }

        System.out.println("\n--- STEP 2: Verification (Checking the saved file)"
                + " ---");
        // Check the file to see if the content was updated
        //checkTranslation handles verification
        if (checkTranslation(null, "kissa", "cat")) {
            System.out.println("TEST PASSED: Save was successful, new entry"
                    + " found in file.");
        } else {
            System.out.println("TEST FAILED: The new entry was not written to "
                    + "the file correctly.");
        }

    }
}
