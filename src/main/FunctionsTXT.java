/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Classes.Article;
import DataStructures.LinkedList;
import DataStructures.Node;
import UI.GlobalUI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author isaac
 */
public class FunctionsTXT {

    /**
     * Reads txt selected by user and adds it to the hash table if valid
     *
     * @param file
     */
    public static void readArticleTxt(File file) {

        if (file.getAbsolutePath().endsWith(".txt")) {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea usar el arhivo: " + file.getName() + " ?", "Confirmación", JOptionPane.YES_NO_OPTION, 3);
            if (confirm == 0) {
                String txt = "";
                try {
                    BufferedReader bf = new BufferedReader(new FileReader(file));

                    String line;
                    while ((line = bf.readLine()) != null) {
                        txt += line + "\n";
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al leer el archivo, por favor intentar de nuevo", "Advertencia", 2);
                }

                if (isTxtFormatValid(txt)) {
                    GlobalUI.addArticleToHT(convertStrToArticle(txt));
                    GlobalUI.addArticleToList(convertStrToArticle(txt));
                } else {
                    JOptionPane.showMessageDialog(null, "El archivo seleccionado no tiene el formato correcto, por favor intentar de nuevo", "Advertencia", 2);
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo se aceptan archivos tipo (.txt), por favor intentar de nuevo", "Advertencia", 2);
        }

    }

    /**
     * Checks if the format of the txt if valid
     *
     * @param txt
     * @return boolean
     */
    public static boolean isTxtFormatValid(String txt) {
        String lower = txt.toLowerCase();
        return ((lower.contains("autores")) && (lower.contains("resumen")) && (lower.contains("palabras claves")));
    }

    /**
     * converts a str read from txt into an article Object
     *
     * @param txt
     * @return Article
     */
    public static Article convertStrToArticle(String txt) {
//        System.out.println(txt);
        String title = "";
        LinkedList authors = new LinkedList();
        String body = "";
        LinkedList keyWords = new LinkedList();

        String[] indiviualLines = txt.split("\n");

        // 0 = Title, 1 = Authors, 2 = Body, 3 = keyWords
        int controlNumber = 0;

        for (String line : indiviualLines) {
            switch (controlNumber) {
                case 0:
                    if (line.toLowerCase().equals("autores")) {
                        controlNumber++;
                        title = title.trim();
                    } else {
                        title += line.trim() + " ";
                    }

                    break;
                case 1:
                    if (line.toLowerCase().equals("resumen")) {
                        controlNumber++;
                    } else {
                        authors.addEnd(line);
                    }
                    break;
                case 2:
                    if (line.toLowerCase().contains("palabras claves:")) {
                        controlNumber++;
                        String[] splitAux = line.split(":");
                        String[] keyWordSplit = splitAux[1].split(",");
                        for (String auxKeyWord : keyWordSplit) {
                            keyWords.addEnd(auxKeyWord.trim());
                        }

                    } else {
                        body += line + "\n";
                    }
                    break;
                case 3:
                    String[] lastKeyWordSplit = line.split(",");
                    for (String auxKeyWord : lastKeyWordSplit) {
                        keyWords.addEnd(auxKeyWord.trim());
                    }
                    break;
            }
        }

        Article article = new Article(title, authors, body, keyWords);

        return article;
    }

    /**
     * Loads the articles in local DB and adds them into the article HT
     */
    public static void loadExistingArticlesInDB() {
        String path = "src\\main\\DB.txt";
        LinkedList allArticlesStr = new LinkedList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));

            String text = "";
            String line;
            while ((line = bf.readLine()) != null) {
                if (line.equals("/")) {
                    allArticlesStr.addEnd(text);
                    text = "";
                } else {
                    text += line + "\n";
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer los archivos guardados en la base de datos, no se dispone de ningún artículo en este momento", "Advertencia", 2);
        }

        Node pointer = allArticlesStr.getHead();
        while (pointer != null) {
            // THe DB already validates that every article is unique
            GlobalUI.getArticleHT().addArticle((convertStrToArticle((String) (pointer.getElement()))));
            GlobalUI.getArticleList().addEnd(convertStrToArticle((String) (pointer.getElement())).getTitle());
            System.out.println("1");
            pointer = pointer.getNext();
        }
    }
}
