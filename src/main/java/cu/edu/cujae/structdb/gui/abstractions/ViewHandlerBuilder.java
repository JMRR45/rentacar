package cu.edu.cujae.structdb.gui.abstractions;

import cu.edu.cujae.structdb.utils.TableType;

public class ViewHandlerBuilder {
    public static AbstractViewHandler build(TableType type) {
        AbstractViewHandler handler;
        switch (type) {
            case rol -> handler = new RolViewHandler();
            case user -> handler = new UserViewHandler();
            case model -> handler = new ModelViewHandler();
            default -> handler = new AuxiliaryViewHandler(type);
        }
        return handler;
    }
}
