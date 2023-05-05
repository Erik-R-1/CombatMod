package net.erikr.combatmod.gui;

import net.erikr.combatmod.SharedVariables;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import static net.erikr.combatmod.gui.Gui.mc;

public class ScreenEditor extends Screen {

    protected ScreenEditor() {
        super(Text.literal("Editor"));
    }

    public static Screen INSTANCE = new ScreenEditor();

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        GuiDrawer.drawBoxMovable(matrices, mouseX, mouseY, SharedVariables.GuiBack, "chud", "Coordinates"); //coordinate hud
        GuiDrawer.drawBoxMovable(matrices, mouseX, mouseY, SharedVariables.GuiBack, "dhud", "Direction"); //direction hud
        GuiDrawer.drawBoxMovable(matrices, mouseX, mouseY, SharedVariables.GuiBack, "pins", "Inspector"); //pinspector
        GuiDrawer.drawBoxMovable(matrices, mouseX, mouseY, SharedVariables.GuiBack, "pinfo", "Info"); //pinfo
        GuiDrawer.drawBoxMovable(matrices, mouseX, mouseY, SharedVariables.GuiBack, "key", "Keystrokes"); //keystrokes
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        SharedVariables.MouseHeld = true;

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        SharedVariables.MouseHeld = false;
        SharedVariables.dragging = null;

        return super.mouseReleased(mouseX, mouseY, button);
    }
}