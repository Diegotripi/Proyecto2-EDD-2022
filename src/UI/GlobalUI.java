/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Classes.Article;
import DataStructures.HashTable;
import DataStructures.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author isaac
 */
public class GlobalUI {

    private static final MainPage mainPage = new MainPage();
    private static final SearchArticlePage searchArticlePage = new SearchArticlePage();
    private static final AnalyzeArticlePage analyzeArticlePage = new AnalyzeArticlePage();

    private static final HashTable articleHT = new HashTable();
    private static final LinkedList listTitles = new LinkedList();
    private static  LinkedList listAuthors = new LinkedList();
    private static  LinkedList listWords = new LinkedList();
    private static  HashTable authorHT = new HashTable();
    private static  HashTable keywordsHT = new HashTable();
    

    /**
     * Opens proyect MainPage
     */
    public static void openMainPage() {
        getMainPage().setVisible(true);
        getAnalyzeArticlePage().setVisible(false);
        getSearchArticlePage().setVisible(false);
    }

    /**
     * Opens SearchArticlePage
     */
    public static void openSearchArticlePage() {
        getSearchArticlePage().getTitleSearchTextField().setText("");
        getSearchArticlePage().setVisible(true);
        getMainPage().setVisible(false);
    }

    /**
     * Opens AnalyzeArticlePage
     */
    public static void openAnalyzeArticlePage() {
        getAnalyzeArticlePage().setVisible(true);
        getMainPage().setVisible(false);
    }

    /**
     * Getter for Article HashTable
     *
     * @return articleHT
     */
    public static HashTable getArticleHT() {
        return articleHT;
    }

    /**
     * Getter for MainPage
     *
     * @return mainPage
     */
    public static MainPage getMainPage() {
        return mainPage;
    }

    /**
     * Getter for SearchArticlePage
     *
     * @return searchArticlePage
     */
    public static SearchArticlePage getSearchArticlePage() {
        return searchArticlePage;
    }

    /**
     * Getter for AnalyzeArticlePage
     *
     * @return analyzeArticlePage
     */
    public static AnalyzeArticlePage getAnalyzeArticlePage() {
        return analyzeArticlePage;
    }

    /**
     * Adds given article to HT, validates and informs if the article was
     * already in DB
     *
     * @param article
     */
    public static void addArticleToHT(Article article) {
        if (getArticleHT().addArticle(article)) {
            JOptionPane.showMessageDialog(null, "El artículo: '" + article.getTitle() + "' fue cargado con éxito!", "Proceso éxitoso", 1);
        } else {
            JOptionPane.showMessageDialog(null, "El artículo: '" + article.getTitle() + "' ya existe en la base de datos", "Advertencia", 0);
        }

    }
    
    //FALTA JAVADOC
    public static LinkedList getListTitles() {
        return listTitles;
    }
    
    /**
     * Return the authors list
     * @return listAuthors
     */
    public static LinkedList getListAuthor() {
        return listAuthors;
    }
    
    /**
     * Set an authors List 
     * @param list
     */
    public static void setListAuthor(LinkedList list) {
        GlobalUI.listAuthors = list;
    }
    
    /**
     * Return the words list 
     * @return listWords
     */

    public static LinkedList getListWords() {
        return listWords;
    }
    /**
     * set a words list in the globalUI
     * @param listWords 
     */
    public static void setListWords(LinkedList listWords) {
        GlobalUI.listWords = listWords;
    }
    
    /**
     * Return Author Hash Table
     * @return authorHt
     */
    public static HashTable getAuthorHT() {
        return authorHT;
    }
    
    /**
     * Set Author Hash Table
     * @param authorHT 
     */

    public static void setAuthorHT(HashTable authorHT) {
        GlobalUI.authorHT = authorHT;
    }
    /**
     * Return Keywords Hash Table
     * @return keywordsHT
     */

    public static HashTable getKeywordsHT() {
        return keywordsHT;
    }
    
    /**
     * Get Keywords Hash Table
     * @param keywordsHT 
     */

    public static void setKeywordsHT(HashTable keywordsHT) {
        GlobalUI.keywordsHT = keywordsHT;
    }
        
    
    

}
