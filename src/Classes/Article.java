/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DataStructures.LinkedList;
import DataStructures.Node;

/**
 *
 * @author isaac
 */
public class Article {

    private String title;
    private LinkedList authors;
    private String body;
    private LinkedList keyWords;

    /**
     * Constructor for Article
     *
     * @param title
     * @param authors
     * @param body
     * @param keyWords
     */
    public Article(String title, LinkedList authors, String body, LinkedList keyWords) {
        this.title = title;
        this.authors = authors;
        this.body = body;
        this.keyWords = keyWords;
    }

    /**
     * Returns a string of the Article info
     *
     * @return info
     */
    public String getArticlePrintableStr() {
        String info = getTitle() + "\n" + "Autores: ";
        Node pointer = getAuthors().getHead();
        while (pointer != null) {
            if (pointer.getNext() != null) {
                info += (String) (pointer.getElement()) + ", ";
            } else {
                info += (String) (pointer.getElement());
            }

            pointer = pointer.getNext();
        }
//        info += "\n" + "Resumen: " + getBody() + "\n" + "Palabras clave: ";
        info +=  "\n" + "Palabras clave: ";

        Node temp = getKeyWords().getHead();
        while (temp != null) {
            if (temp.getNext() != null) {
                info += (String) (temp.getElement()) + ", ";
            } else {
                info += (String) (temp.getElement());
            }
            temp = temp.getNext();
        }

        return info;

    }

    /**
     * Getter for title
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for title
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for authors
     *
     * @return authors
     */
    public LinkedList getAuthors() {
        return authors;
    }

    /**
     * Setter for authors
     *
     * @param authors
     */
    public void setAuthors(LinkedList authors) {
        this.authors = authors;
    }

    /**
     * Getter for body
     *
     * @return body
     */
    public String getBody() {
        return body;
    }

    /**
     * Setter for body
     *
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Getter for keyWords
     *
     * @return keyWords
     */
    public LinkedList getKeyWords() {
        return keyWords;
    }

    /**
     * Setter for keyWords
     *
     * @param keyWords
     */
    public void setKeyWords(LinkedList keyWords) {
        this.keyWords = keyWords;
    }

}
