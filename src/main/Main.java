/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Classes.Article;
import DataStructures.LinkedList;
import UI.GlobalUI;

/**
 *
 * @author isaac
 */
public class Main {

    /**
     * Main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GlobalUI.openMainPage();
        FunctionsTXT.loadExistingArticlesInDB();
    }

    public static void testHash() {
        

        for (int i = 0; i < 20; i++) {
            LinkedList authors = new LinkedList();
            authors.addEnd("Autor" + i + ".1");
            authors.addEnd("Autor" + i + ".2");
            authors.addEnd("Autor" + i + ".3");

            LinkedList keyWord = new LinkedList();
            keyWord.addEnd("Palabra" + i + ".1");
            keyWord.addEnd("Palabra" + i + ".2");
            keyWord.addEnd("Palabra" + i + ".3");

            String title = "Artículo " + i;
            String body = "Resumen" + i;

            Article art = new Article(title, authors, body, keyWord);

            GlobalUI.getArticleHT().addArticle(art);
        }
        
        GlobalUI.getArticleHT().printAllArticlesConsole();
        
        System.out.println("hol");

    }

}
