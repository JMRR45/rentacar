package cu.edu.cujae.structdb;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import cu.edu.cujae.structdb.gui.GuiManager;

public class Main {

    public static void main(String[] args) {
        // Para probar otros temas sustituir el paramétro de init()
        // Si quieres verlos todos pones com.formdev.flatlaf.intellijthemes.materialthemeuilite. y usas el IntelliSense
        GuiManager.init(new FlatArcDarkContrastIJTheme());
    }
}