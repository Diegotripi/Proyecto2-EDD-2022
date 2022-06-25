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
public class Author implements HashObject {

    private String name;
    private String title;
    

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
    /**
     * Set the author name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
     * @return 
     */
    public String getTitle() {
        return title;
    }
    /**
     * 
     * @param title 
     */

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
    
    

    
    
    
    
    
    

}
