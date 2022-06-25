/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Classes.Article;
import DataStructures.HashTable;
import DataStructures.LinkedList;
import DataStructures.Node;
import DataStructures.WordRepetition;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import main.FunctionsTXT;
import Classes.Author;
import Classes.KeyWord;
import javax.swing.JTextField;

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

    //FALTA JAVADOC
    public static void fillComboBoxWithListStrings(JComboBox<String> comboBox, LinkedList List) {
        comboBox.removeAllItems();
        int index = 0;
        Node pointer = List.getHead();
        while (pointer != null) {
            comboBox.insertItemAt((String) pointer.getElement(), index);
            index++;
            pointer = pointer.getNext();
        }
    }

    //FALTA JAVADOC
    public static void analyzeSummary(String key, JTextArea textArea) {
        if (key != null) {

            String textResult = "Nombre del trabajo: " + key + "\n";

            LinkedList list = GlobalUI.getArticleHT().getTable()[hashStringUpperC(key, GlobalUI.getArticleHT())];

            Node pointer = list.getHead();
            while (pointer != null && !((Article) pointer.getElement()).getTitle().equals(key)) {
                pointer = pointer.getNext();
            }

            textResult += "Autores: " + ((Article) pointer.getElement()).getAuthors().getAuthorsString() + "\n\n";
            String summary = ((Article) pointer.getElement()).getBody();

            String[] wordArray = summary.replaceAll("[,.;:'?!)(]", "").replace(" ", "\n").split("\n");
            String[] keyWordsArray = new String[((Article) pointer.getElement()).getKeyWords().getLength()];
            HashTable wordsHT = new HashTable();

            int index2 = 0;
            Node pointer5 = ((Article) pointer.getElement()).getKeyWords().getHead();
            while (pointer5 != null) {
                WordRepetition wordAndRepetition = new WordRepetition(((String) pointer5.getElement()));
                keyWordsArray[index2] = (String) pointer5.getElement();
                wordsHT.addWordInListOfRep(wordAndRepetition);
                index2++;
                pointer5 = pointer5.getNext();
            }

            for (int i = 0; i < wordArray.length; i++) {
                int index = FunctionsUI.hashStringUpperC(wordArray[i], wordsHT);
                try {
                    Node pointer1 = wordsHT.getTable()[index].getHead();
                    while (pointer1 != null) {
                        if (((WordRepetition) pointer1.getElement()).getWord().toLowerCase().equals(wordArray[i].toLowerCase())) {
                            int oldValue = ((WordRepetition) pointer1.getElement()).getRepetition();
                            ((WordRepetition) pointer1.getElement()).setRepetition(oldValue + 1);
                        }
                        pointer1 = pointer1.getNext();
                    }

                } catch (Exception e) {

                }
            }

            for (int i = 0; i < keyWordsArray.length; i++) {
                int indexHT = FunctionsUI.hashStringUpperC(keyWordsArray[i], wordsHT);

                Node pointer1 = wordsHT.getTable()[indexHT].getHead();
                while (pointer1 != null) {
                    if (((WordRepetition) pointer1.getElement()).getWord().equals(keyWordsArray[i])) {
                        String word = ((WordRepetition) pointer1.getElement()).getWord();
                        int quantity = ((WordRepetition) pointer1.getElement()).getRepetition();
                        textResult += word + ": " + String.valueOf(quantity) + "\n";
                    }
                    pointer1 = pointer1.getNext();
                }
            }

            textArea.setText(textResult);

        } else {
            JOptionPane.showMessageDialog(null, "Elija uno de los articulos");
        }
    }

    //FALTA JAVADOC
    public static int hashStringUpperC(String string, HashTable HT) {
        String str = string.toLowerCase();
        long hash = 5381;
        for (int i = 0; i < str.length(); i++) {
            // Multiply hash by 33 done by bit shift
            hash = (hash << 5) + hash;
            // add to hash ascii value of current char
            hash += (int) str.charAt(i);
        }
        // converts the hash to index
        int index = (int) (hash % HT.getSize());
        return (index < 0) ? index * -1 : index;
    }
    
    /**
     * Get author information from the SearchArticleUI and fill article titles information
     * @param comboBox
     * @param comboBox2 
     */

    public static void fillAuthorArticleTitleComboBox(JComboBox<String> comboBox, JComboBox<String> comboBox2) {

        if (comboBox2.getSelectedItem() != null) {
            String author = comboBox2.getSelectedItem().toString();
            int index = GlobalUI.getAuthorHT().hashString(author.toLowerCase());
            LinkedList list = GlobalUI.getAuthorHT().getTable()[index];
            //System.out.println(list.getHead().getElement());
            
            LinkedList list2 = new LinkedList();
            Node pointer = list.getHead();
            for (int i = 0; i < list.getLength(); i++) {
                list2.addEnd(((Author) pointer.getElement()).getTitle());
                pointer = pointer.getNext();
            }
            fillComboBoxWithListStrings(comboBox, list2);
        }else{
            JOptionPane.showMessageDialog(null, "Selecciona un autor");
        }

    }
    
    /**
     * Get article title and show information
     * @param comboBox 
     */
    
    
    public static void getArticleTitle(JComboBox<String> comboBox){
        if (comboBox.getSelectedItem() != null) {
            String title = comboBox.getSelectedItem().toString();
            findArticleByName(title);
            
        }else{
            JOptionPane.showMessageDialog(null, "Selecciona un articulo");
        }
    }
    
    /**
     * Get keyword information from the SearchArticleUI and fill article titles information
     * @param comboBox
     * @param textfield 
     */
    
    public static void fillKeyWordArticleTitleComboBox(JComboBox<String> comboBox, JTextField textfield) {
        LinkedList list2 = new LinkedList();
        if (!textfield.getText().equals("")) {
            String keyword = textfield.getText();
            int index = GlobalUI.getKeywordsHT().hashString(keyword.toLowerCase());
            LinkedList list = GlobalUI.getKeywordsHT().getTable()[index];
            //System.out.println(list.getHead().getElement());
            
            Node pointer = list.getHead();
            for (int i = 0; i < list.getLength(); i++) {
                list2.addEnd(((KeyWord) pointer.getElement()).getTitle());
                pointer = pointer.getNext();
            }
            fillComboBoxWithListStrings(comboBox, list2);
            
            if (list2.getLength() == 0 ) {
                JOptionPane.showMessageDialog(null, "Palabra clave no encontrada");
                
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Escriba una palabra clave");
        }
        
        textfield.setText("");
        
         
            
        

    }
    

}
