/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DataStructures.LinkedList;

/**
 *
 * @author isaac
 */
public class Author implements HashObject {

    private String name;

    /**
     * Gets name in order to hash
     *
     * @return String
     */
    @Override
    public String getKey() {
        return this.getName();
    }

    /**
     * Getter for name
     *
     * @return name
     */
    public String getName() {
        return name;
    }
    

    
    
    
    
    
    

}
