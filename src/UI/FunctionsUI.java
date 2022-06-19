/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Classes.Article;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import main.FunctionsTXT;

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

}
