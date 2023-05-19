package cu.edu.cujae.structdb.gui;

import cu.edu.cujae.structdb.gui.home.HomeWindow;
import cu.edu.cujae.structdb.gui.home.LoginWindow;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GuiManager {
    public enum WindowType {login, main};
    private interface AbstractGui {
        void show();
    }

    private static HashMap<WindowType, AbstractGui> windows;

    /**
     * Inicializa la interfaz gráfica y establece el tema a utilizar
     * @param theme
     */
    public static void init(javax.swing.LookAndFeel theme) {
        initWindows();
        try {
            UIManager.setLookAndFeel(theme);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        open(WindowType.login, null);
    }

    /**
     * Este método permite levantar una nueva ventana.
     * @param toOpen Indentificador de la ventana que se debe abrir
     * @param toClose Ventana que se debe cerrar (si no se desea cerrar ninguna pasar null)
     */
    public static void open(WindowType toOpen, Window toClose) {
        if (toClose != null) {
            toClose.dispose();
        }
        windows.get(toOpen).show();
    }

    /*
    Cuando se añade una nueva ventana al flujo de la app, se debe añadir en este metodo una entrada que la referencie
    en el HashMap windows. El código que se debe pegar es el siguiente:
    JFrame frame = <Aqui debe colocar el constructor de la ventana deseada>;
            frame.setLocationRelativeTo(null);
            frame.setIconImage(new ImageIcon("D:\\workspaces\\cujae\\rentacar\\src\\main\\java\\cu\\edu\\" +
                    "cujae\\structdb\\gui\\icons\\rent.png").getImage());
            frame.setVisible(true);
     */
    private static void initWindows() {
        windows = new HashMap<>();
        windows = new HashMap<>();
        windows.put(WindowType.login, () -> {
            JFrame frame = new LoginWindow();
            frame.setLocationRelativeTo(null);
            frame.setIconImage(new ImageIcon("D:\\workspaces\\cujae\\rentacar\\src\\main\\java\\cu\\edu\\" +
                    "cujae\\structdb\\gui\\icons\\rent.png").getImage());
            frame.setVisible(true);
        });
        windows.put(WindowType.main, () -> {
            JFrame frame = new HomeWindow();
            frame.setLocationRelativeTo(null);
            frame.setIconImage(new ImageIcon("D:\\workspaces\\cujae\\rentacar\\src\\main\\java\\cu\\edu\\" +
                    "cujae\\structdb\\gui\\icons\\rent.png").getImage());
            frame.setVisible(true);
        });
    }
}
