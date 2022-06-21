/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Classes.Article;
import DataStructures.HashTable;
import javax.swing.JOptionPane;
import DataStructures.LinkedList;

/**
 *
 * @author isaac
 */
public class GlobalUI {

    private static final MainPage mainPage = new MainPage();
    private static final SearchArticlePage searchArticlePage = new SearchArticlePage();
    private static final AnalyzeArticlePage analyzeArticlePage = new AnalyzeArticlePage();

    private static final  HashTable articleHT = new HashTable();
    private static LinkedList articleList = new LinkedList();
    
    public static void start() {
        System.out.println("ndndwnwdn");
    }

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
    
        /**
     * Getter for LinkedList
     *
     * @return articleList
     */
    public static LinkedList getArticleList() {
        return articleList;
    }
    
    /**
     * Adds given article title to a list, validates and informs if the article was
     * already in the list 
     *
     * @param article
     */
    public static void addArticleToList(Article article) {
        System.out.println("1");
        if (!getArticleHT().isArticleIn(article)) {
            System.out.println("2");
            getArticleList().addEnd(article.getTitle());
        } 
    }

}
