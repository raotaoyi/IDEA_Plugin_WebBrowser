package com.idea.plugin.codemars.gui.toolwindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public final class ToolWindowFactoryImpl implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull final Project project, @NotNull final ToolWindow toolWindow) {
        final ToolWindowPanel win = new ToolWindowPanel(project, toolWindow);
        toolWindow.getContentManager().addContent(ContentFactory.SERVICE.getInstance().createContent(win, "", false));
    }
}
