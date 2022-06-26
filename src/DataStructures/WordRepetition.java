/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author marti
 */
public class WordRepetition {
    String word;
    int repetition;

    /**
     * Constructor for WordRepetition
     * @param word 
     */
    public WordRepetition(String word) {
        this.word = word;
        this.repetition = 0;
    }

    /**
     * Getter for word
     * @return 
     */
    public String getWord() {
        return word;
    }

    /**
     * Setter for word
     * @param title 
     */
    public void setWord(String title) {
        this.word = word;
    }

    /**
     * Getter for the repetition number
     * @return 
     */
    public int getRepetition() {
        return repetition;
    }

    /**
     * Setter for the repetition number
     * @param repetition 
     */
    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }
  
}
