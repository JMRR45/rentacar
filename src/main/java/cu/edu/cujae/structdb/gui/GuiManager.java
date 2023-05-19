package cu.edu.cujae.structdb.gui;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import cu.edu.cujae.structdb.gui.insert.AuxiliaryInsertWindow;
import cu.edu.cujae.structdb.gui.insert.ModelInsertWindow;
import cu.edu.cujae.structdb.gui.insert.RolInsertWindow;
import cu.edu.cujae.structdb.gui.insert.UserInsertWindow;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Properties;

public class GuiManager {
    public enum FrameType {login, main};
    public enum DialogType {view, insertAuxiliary, insertModel, insertUser, insertRol}
    private interface AbstractFrame {
        void show();
    }
    private interface AbstractDialog {
        void show(Window parent, Object prop);
    }

    private static HashMap<FrameType, AbstractFrame> frames;
    private static HashMap<DialogType, AbstractDialog> dialogs;
    private static boolean darkTheme = true;

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
        openFrame(FrameType.login, null, null);
    }

    public static void changeTheme(Component component) {
        darkTheme = darkTheme ? false : true;
        try {
            if (darkTheme) {
                UIManager.setLookAndFeel(new FlatArcDarkContrastIJTheme());
                SwingUtilities.updateComponentTreeUI(component);
            } else {
                UIManager.setLookAndFeel(new FlatArcIJTheme());
                SwingUtilities.updateComponentTreeUI(component);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    /**
     * Este método permite levantar una nueva ventana.
     * @param toOpen Indentificador de la ventana que se debe abrir
     * @param toClose Ventana que se debe cerrar (si no se desea cerrar ninguna pasar null)
     */
    public static void openFrame(FrameType toOpen, Window toClose, Properties props) {
        if (toClose != null) {
            toClose.dispose();
        }
        frames.get(toOpen).show();
    }
    public static void openDialog(DialogType toOpen, Window parent, Object prop) {
        dialogs.get(toOpen).show(parent, prop);
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
        frames = new HashMap<>();
        dialogs = new HashMap<>();
        frames.put(FrameType.login, () -> {
            JFrame frame = new LoginWindow();
            frame.setLocationRelativeTo(null);
            frame.setIconImage(new ImageIcon("D:\\workspaces\\cujae\\rentacar\\src\\main\\java\\cu\\edu\\" +
                    "cujae\\structdb\\gui\\icons\\rent.png").getImage());
            frame.setVisible(true);
        });
        frames.put(FrameType.main, () -> {
            JFrame frame = new HomeWindow();
            frame.setLocationRelativeTo(null);
            frame.setIconImage(new ImageIcon("D:\\workspaces\\cujae\\rentacar\\src\\main\\java\\cu\\edu\\" +
                    "cujae\\structdb\\gui\\icons\\rent.png").getImage());
            frame.setVisible(true);
        });
        dialogs.put(DialogType.view, (parent, prop) -> {
            JDialog frame = new ViewWindow(prop);
            frame.setLocationRelativeTo(null);
            frame.setIconImage(new ImageIcon("D:\\workspaces\\cujae\\rentacar\\src\\main\\java\\cu\\edu\\" +
                    "cujae\\structdb\\gui\\icons\\rent.png").getImage());
            frame.setVisible(true);
        });
        dialogs.put(DialogType.insertAuxiliary, (parent, prop) -> {
            JDialog frame = new AuxiliaryInsertWindow(prop, parent);
            frame.setLocationRelativeTo(null);
            frame.setIconImage(new ImageIcon("D:\\workspaces\\cujae\\rentacar\\src\\main\\java\\cu\\edu\\" +
                    "cujae\\structdb\\gui\\icons\\rent.png").getImage());
            frame.setVisible(true);
        });
        dialogs.put(DialogType.insertModel, (parent, prop) -> {
            JDialog frame = new ModelInsertWindow(parent);
            frame.setLocationRelativeTo(null);
            frame.setIconImage(new ImageIcon("D:\\workspaces\\cujae\\rentacar\\src\\main\\java\\cu\\edu\\" +
                    "cujae\\structdb\\gui\\icons\\rent.png").getImage());
            frame.setVisible(true);
        });
        dialogs.put(DialogType.insertUser, (parent, dto) -> {
            JDialog frame = new UserInsertWindow(parent, dto);
            frame.setLocationRelativeTo(null);
            frame.setIconImage(new ImageIcon("D:\\workspaces\\cujae\\rentacar\\src\\main\\java\\cu\\edu\\" +
                    "cujae\\structdb\\gui\\icons\\rent.png").getImage());
            frame.setVisible(true);
        });
        dialogs.put(DialogType.insertRol, (parent, dto) -> {
            JDialog frame = new RolInsertWindow(parent, dto);
            frame.setLocationRelativeTo(null);
            frame.setIconImage(new ImageIcon("D:\\workspaces\\cujae\\rentacar\\src\\main\\java\\cu\\edu\\" +
                    "cujae\\structdb\\gui\\icons\\rent.png").getImage());
            frame.setVisible(true);
        });
    }
}
