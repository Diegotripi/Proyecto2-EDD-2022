/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author isaac
 */
public class KeyWord implements HashObject {

    private String keyWord;
    private String title;

    /**
     * Gets Keyword in order to hash
     *
     * @return String
     */
    @Override
    public String getKey() {
        return getKeyWord();
    }

    /**
     * Getter for keyword
     *
     * @return keyWord
     */
    public String getKeyWord() {
        return keyWord;
    }
    
    /**
     * Set the author name
     * @param name 
     */
    public void setName(String name) {
        this.keyWord = name;
    }
    /**
     * Get the article title
     * @return 
     */
    public String getTitle() {
        return title;
    }
    /**
     * Set the article title
     * @param title 
     */

    public void setTitle(String title) {
        this.title = title;
    }

}
