/*
 * Copyright 2023 Syntarou YOSHIDA.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jp.synthtarou.cceditor.view.common;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import jp.synthtarou.cceditor.Main;
import static jp.synthtarou.cceditor.common.CCUtilities.centerWindow;
import static jp.synthtarou.cceditor.common.CCUtilities.getOwnerWindow;

/**
 *
 * @author Syntarou YOSHIDA
 */
public class CCPromptUtil {
    public static void showDialog(Container parent, JPanel panel) {
        Container cont = getOwnerWindow(parent);
        String title = Main.TITLE;

        JDialog child = null;
        if (cont instanceof Window) {
            Window W = (Window) cont;
            child = new JDialog(W, title);
        } else if (cont instanceof Dialog) {
            Dialog D = (Dialog) cont;
            child = new JDialog(D, title);
        } else {
            child = new JDialog((Window) parent, title);
        }
        child.setModal(true);
        child.getContentPane().add(panel, "Center");
        child.pack();

        centerWindow(child);
        panel.requestFocusInWindow();
        child.setVisible(true);
    }
    
    public static void closeAnyway(IPrompt prompt) {
        Component c = prompt.getAsPanel();
        while(c != null) {
            c = c.getParent();
            if (c == null) {
                break;
            }
            if (c instanceof Dialog || c instanceof Window) {
                c.setVisible(false);
                return;
            }
        }
    }

    private static void closeWithValidate(IPrompt prompt) {
        // implementation example
        if (prompt.validatePromptResult()) {
            closeAnyway(prompt);
        }
    }

    public static void showFrame(JPanel panel) {
        String title = Main.TITLE;
        
        JFrame child = null;
        child = new JFrame(title);
        child.getContentPane().add(panel, "Center");
        child.pack();

        centerWindow(child);
        panel.requestFocusInWindow();
        child.setVisible(true);
    }

    public static Object showPrompt(Container parent, IPrompt prompt) {
        Container cont = getOwnerWindow(parent);
        String title = prompt.getPromptTitle();

        JDialog child = null;
        if (title == null) {
            title = Main.TITLE;
        }
        if (cont instanceof Window) {
            Window W = (Window) cont;
            child = new JDialog(W, title);
        } else if (cont instanceof Dialog) {
            Dialog D = (Dialog) cont;
            child = new JDialog(D, title);
        } else {
            child = new JDialog((Window) parent, title);
        }
        child.setModal(true);
        child.getContentPane().add(prompt.getAsPanel(), "Center");
        child.pack();

        Dimension size = prompt.getPromptSize();
        if (size != null) {
            child.setSize(size);
        }
        centerWindow(child);
        prompt.getAsPanel().requestFocusInWindow();
        child.setVisible(true);
        
        Object result = prompt.getPromptResult();
        return result;
    }
}