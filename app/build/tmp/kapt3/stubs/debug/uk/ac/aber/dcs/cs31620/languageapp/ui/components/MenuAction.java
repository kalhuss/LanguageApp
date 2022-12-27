package uk.ac.aber.dcs.cs31620.languageapp.ui.components;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u000bB\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0001\u0001\f\u00a8\u0006\r"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/ui/components/MenuAction;", "", "label", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(ILandroidx/compose/ui/graphics/vector/ImageVector;)V", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getLabel", "()I", "Settings", "Luk/ac/aber/dcs/cs31620/languageapp/ui/components/MenuAction$Settings;", "app_debug"})
public abstract class MenuAction {
    private final int label = 0;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.ui.graphics.vector.ImageVector icon = null;
    
    private MenuAction(int label, androidx.compose.ui.graphics.vector.ImageVector icon) {
        super();
    }
    
    public final int getLabel() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.ui.graphics.vector.ImageVector getIcon() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/ui/components/MenuAction$Settings;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/components/MenuAction;", "()V", "app_debug"})
    public static final class Settings extends uk.ac.aber.dcs.cs31620.languageapp.ui.components.MenuAction {
        @org.jetbrains.annotations.NotNull()
        public static final uk.ac.aber.dcs.cs31620.languageapp.ui.components.MenuAction.Settings INSTANCE = null;
        
        private Settings() {
            super(0, null);
        }
    }
}