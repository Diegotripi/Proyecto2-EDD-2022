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

}
