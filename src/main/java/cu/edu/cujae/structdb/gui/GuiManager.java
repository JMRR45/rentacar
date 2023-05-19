package cu.edu.cujae.structdb.gui;

import cu.edu.cujae.structdb.dto.model.UserDTO;
import cu.edu.cujae.structdb.gui.insert.AuxiliaryInsertWindow;
import cu.edu.cujae.structdb.gui.insert.ModelInsertWindow;
import cu.edu.cujae.structdb.gui.insert.UserInsertWindow;
import cu.edu.cujae.structdb.utils.TableType;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Properties;

public class GuiManager {
    public enum FrameType {login, main};
    public enum DialogType {view, insertAuxiliary, insertModel, insertUser}
    private interface AbstractFrame {
        void show();
    }
    private interface AbstractDialog {
        void show(Window parent, Object prop);
    }

    private static HashMap<FrameType, AbstractFrame> frames;
    private static HashMap<DialogType, AbstractDialog> dialogs;

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
    }
}
