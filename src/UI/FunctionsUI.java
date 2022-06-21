/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Classes.Article;
import DataStructures.HashTable;
import DataStructures.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import main.FunctionsTXT;
import DataStructures.Node;

/**
 *
 * @author isaac
 */
public class FunctionsUI {

    /**
     * Opens JFileChooser
     */
    public static void openJFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {

            FunctionsTXT.readArticleTxt(fileChooser.getSelectedFile());

        }
    }

    /**
     * Finds article given its key, informs the users if it exist and show
     * details
     *
     * @param title
     */
    public static void findArticleByName(String title) {
        if (title.isBlank()) {
            //  JOptionPane.showMessageDialog(null, "Error al leer el archivo, por favor intentar de nuevo", "Advertencia", 2);
            JOptionPane.showMessageDialog(null, "Por favor escribir un título para su búsqueda", "Advertencia", 2);
        } else {
            Article articleFound = GlobalUI.getArticleHT().searchArticleByTitle(title);
            if (articleFound == null) {
                JOptionPane.showMessageDialog(null, "El artículo: '" + title + "' no está registrado en la base de datos", "Advertencia", 0);
            } else {
                String info = articleFound.getArticlePrintableStr();
                JOptionPane.showMessageDialog(null, info, "Artículo encontrado", 1);
            }
        }
    }
    
//    public static void fillComboBoxArticles(HashTable HT){
////        Node pointer = GlobalUI.getArticleList().getHead();
////        int index = 0;
////        while (pointer != null){
////            String articleTitle = (String) pointer.getElement();
////            GlobalUI.getAnalyzeArticlePage().jComboBox1.insertItemAt(articleTitle, index);
////            index++;
////            pointer = pointer.getNext();
////        }
//        int index = 0;
//        for (int i = 0; i < HT.getSize(); i++) {
//            if (!HT.getTable()[i].isEmpty()) {
//                if (HT.getTable()[i].getLength() == 1) {
//                    String articleTitle = ((Article) HT.getTable()[i].getHead().getElement()).getTitle();
//                    GlobalUI.getAnalyzeArticlePage().jComboBox1.insertItemAt(articleTitle, index);
//                    index++;
//                } else {
//                    Node pointer = HT.getTable()[i].getHead();
//                    while (pointer != null) {
//                        String articleTitle = ((Article) HT.getTable()[i].getHead().getElement()).getTitle();
//                        GlobalUI.getAnalyzeArticlePage().jComboBox1.insertItemAt(articleTitle, index);
//                        index++;
//                        pointer = pointer.getNext();
//                    }
//            }
//        }
//        }
//    }

}
