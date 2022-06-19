/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Classes.Article;

/**
 *
 * @author isaac
 */
public class HashTable {

    private final LinkedList[] table;
    private final int size;

    /**
     * Constructor for HashTable
     */
    public HashTable() {
        this.size = 599;
        this.table = new LinkedList[this.size];
        fillTable();
    }

    /**
     * fills HashTable with empty linkedLists
     */
    private void fillTable() {
        for (int i = 0; i < getSize(); i++) {
            getTable()[i] = new LinkedList();
        }
    }

    /**
     * Prints all articles info in console
     */
    public void printAllArticlesConsole() {
        for (int i = 0; i < getSize(); i++) {
            if (!getTable()[i].isEmpty()) {
                Node pointer = getTable()[i].getHead();
                System.out.println("Índice: " + i);

                while (pointer != null) {
                    System.out.println(((Article) pointer.getElement()).getArticlePrintableStr());
                    System.out.println("\n");
                    pointer = pointer.getNext();
                }
            }
        }

    }

    /**
     * Hash function djb2, converts str into HashTable index and returns it
     *
     * @param str
     * @return HashTable index
     */
    public int hashString(String str) {
        long hash = 5381;
        for (int i = 0; i < str.length(); i++) {
            // Multiply hash by 33 done by bit shift
            hash = (hash << 5) + hash;
            // add to hash ascii value of current char
            hash += (int) str.charAt(i);
        }
        // converts the hash to index
        int index = (int) (hash % getSize());
        return (index < 0) ? index * -1 : index;
    }

    /**
     * Given and article, adds the article into the hash table if its unique
     * adds it and return true, if not only return false;
     *
     * @param articleToAdd
     * @return boolean
     */
    public boolean addArticle(Article articleToAdd) {
        // the str given for hashing is the title in lowerCase 
        // this makes the search made by the user easier
        int index = hashString(articleToAdd.getTitle().toLowerCase());
        boolean isTitleInList = getTable()[index].isTitleInList(articleToAdd.getTitle());

        if (isTitleInList) {
            return false;
        } else {
            getTable()[index].addEnd(articleToAdd);
            return true;
        }

    }

    /**
     * Search article in HT by title return null if not found
     *
     * @param title
     * @return Article
     */
    public Article searchArticleByTitle(String title) {
        Article article= null;
        //all hashing must be in loweCase
        int index = hashString(title.toLowerCase());
        LinkedList articlesInIndex = getTable()[index];
        Node pointer = articlesInIndex.getHead();
        while (pointer != null) {
            if ((title.toLowerCase()).equals( ((Article) pointer.getElement()).getTitle().toLowerCase() )) {
                article = ((Article)pointer.getElement());
            }
            pointer = pointer.getNext();
        }
        
        return article;
    }

    /**
     * Getter for table
     *
     * @return table
     */
    public LinkedList[] getTable() {
        return table;
    }

    /**
     * Getter for size
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

}
