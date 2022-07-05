/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Classes.Article;
import Classes.Author;
import Classes.HashObject;
import Classes.KeyWord;
import UI.FunctionsUI;
import UI.GlobalUI;

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
     * Given and article, adds the article into the hash table and the other
     * data structures if its unique and returns true, if not only returns
     * false;
     *
     * @param articleToAdd
     * @return boolean
     */
    // addArticle is its own method and is not included in HashObject because
    // its necessary to know when the object added is an article
    public boolean addArticle(Article articleToAdd) {
        // the str given for hashing is the title in lowerCase 
        // this makes the search made by the user easier
        String beforeHash = FunctionsUI.trimWord(articleToAdd.getTitle().toLowerCase());
        int index = hashString(beforeHash);
        boolean isTitleInList = getTable()[index].isTitleInList(articleToAdd.getTitle());
        //addAuthorInAuxHT(articleToAdd)
        // addKeyWordInAuxHT(articleToAdd)

        if (isTitleInList) {
            return false;
        } else {
            getTable()[index].addEnd(articleToAdd);
            addTitleInList(articleToAdd);
            addAuthorInList(articleToAdd);
            addWordsInList(articleToAdd);
            return true;
        }

    }

//    public String trimWord(String word) {
//        String aux = word.trim();
//        char end = aux.charAt(word.length()-1);
//        if (end == '.') {
//            aux = aux.substring(0, aux.length()-1);
//        }
//        System.out.println(aux);
//        return aux;
//    }
    /**
     * Adds the article's title to the title list
     *
     * @param articleToAdd
     */
    public void addTitleInList(Article articleToAdd) {
        GlobalUI.getListTitles().addEnd(articleToAdd.getTitle());
    }

    /**
     * Create a new LinkedList with the Authors
     *
     * @param articleToAdd
     */
    public void addAuthorInList(Article articleToAdd) {

        LinkedList list = GlobalUI.getListAuthor();
        String authors = articleToAdd.getAuthors().getAuthorsString();
        String[] name = authors.split(",");

        for (int i = 0; i < name.length; i++) {
            name[i] = name[i].replace("-", " ");
            name[i] = FunctionsUI.trimWord(name[i]);
            
        }

        for (int i = 0; i < name.length; i++) {
            boolean aux = true;
            Node temp = list.getHead();
            for (int j = 0; j < list.getLength(); j++) {
                //Validate if an author is already added
                String elementAux = temp.getElement().toString().replace("-", " ");
                elementAux = FunctionsUI.trimWord(elementAux);
                
                if ( elementAux.equalsIgnoreCase(name[i])) {
                    aux = false;
                }

                temp = temp.getNext();
            }

            if (aux) {
                list.addEnd(name[i]);
            }

            addAuthorInAuxHT(articleToAdd, name[i]);

        }

        GlobalUI.setListAuthor(list);

    }

    /**
     * Create a new LinkedList with the keywords
     *
     * @param articleToAdd
     */
    public void addWordsInList(Article articleToAdd) {

        LinkedList list = GlobalUI.getListWords();
        String words = articleToAdd.getKeyWords().getAuthorsString();
        String[] name = words.split(",");

        for (int i = 0; i < name.length; i++) {
            name[i] = FunctionsUI.trimWord(name[i]);
        }

        for (int i = 0; i < name.length; i++) {
            boolean aux = true;
            Node temp = list.getHead();
            for (int j = 0; j < list.getLength(); j++) {
                //Validate if an author is already added
                if (temp.getElement().toString().equalsIgnoreCase(name[i])) {
                    aux = false;
                }

                temp = temp.getNext();
            }

            if (aux) {
                list.addEnd(name[i]);
            }

            addKeywordsInAuxHT(articleToAdd, name[i]);

        }

        GlobalUI.setListWords(list);

    }

    /**
     * Given and HashObject, add Them in the HT, or modify it if already exists
     *
     * @param hashObject
     */
    public void addHashObject(HashObject hashObject) {
        // the str given for hashing is the object key in lowerCase 
        // this makes the search made by the user easier
        int index = hashString(hashObject.getKey().toLowerCase());

        // código para buscar si el objeto ya está en el HT una vez encontrado el índice
//        boolean isObjectInList = getTable()[index].isHashObjectInList(hashObject.getKey());
//Código para añadir el objeto
        getTable()[index].addEnd(hashObject);
    }

    /**
     * Search article in HT by title return null if not found
     *
     * @param title
     * @return Article
     */
    public Article searchArticleByTitle(String title) {
        Article article = null;
        //all hashing must be in loweCase
        String trimmed = FunctionsUI.trimWord(title.toLowerCase());
        int index = hashString(trimmed);
        LinkedList articlesInIndex = getTable()[index];
        Node pointer = articlesInIndex.getHead();
        while (pointer != null) {
            if ((trimmed.toLowerCase()).equals(FunctionsUI.trimWord(((Article) pointer.getElement()).getTitle().toLowerCase()))) {
                article = ((Article) pointer.getElement());
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

    /**
     * Adds the key words in the HashTable if its not already there
     *
     * @param object
     */
    public void addWordInListOfRep(WordRepetition object) {
        if (object.getWord().contains(" ")) {
            int index = hashString(object.getWord().toLowerCase().replaceAll(" ", "_"));
            boolean isTitleInList = getTable()[index].isWordRepetitionIn(object);

            if (!isTitleInList) {
                getTable()[index].addEnd(object);
            }
        } else {
            int index = hashString(object.getWord().toLowerCase());
            boolean isTitleInList = getTable()[index].isWordRepetitionIn(object);

            if (!isTitleInList) {
                getTable()[index].addEnd(object);
            }
        }
    }

    /**
     * add article with authors hash
     *
     * @param articleToAdd
     * @param name
     */
    public void addAuthorInAuxHT(Article articleToAdd, String name) {
        Author author = new Author();
        author.setName(name);
        author.setTitle(articleToAdd.getTitle());
        GlobalUI.getAuthorHT().addHashObject(author);
    }

    /**
     * add article with keywords hash
     *
     * @param articleToAdd
     * @param name
     */
    public void addKeywordsInAuxHT(Article articleToAdd, String name) {
        KeyWord keyword = new KeyWord();
        keyword.setName(name);
        keyword.setTitle(articleToAdd.getTitle());
        GlobalUI.getKeywordsHT().addHashObject(keyword);
    }

}
