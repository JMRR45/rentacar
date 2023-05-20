package cu.edu.cujae.structdb;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import cu.edu.cujae.structdb.gui.GuiManager;
import org.mindrot.jbcrypt.BCrypt;

public class Main {

    public static void main(String[] args) {
        // Para probar otros temas sustituir el paramétro de init()
        // Si quieres verlos todos pones com.formdev.flatlaf.intellijthemes.materialthemeuilite. y usas el IntelliSense
        GuiManager.init(new FlatArcDarkContrastIJTheme());
        System.out.println(BCrypt.hashpw("admin", BCrypt.gensalt(10)));
    }
}