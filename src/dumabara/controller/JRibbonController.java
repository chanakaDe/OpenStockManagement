/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumabara.controller;

import dumbara.view.Main;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComponent;
import org.pushingpixels.flamingo.api.common.CommandButtonDisplayState;
import org.pushingpixels.flamingo.api.common.JCommandButton;
import org.pushingpixels.flamingo.api.common.JCommandMenuButton;
import org.pushingpixels.flamingo.api.common.icon.ImageWrapperResizableIcon;
import org.pushingpixels.flamingo.api.common.icon.ResizableIcon;
import org.pushingpixels.flamingo.api.common.popup.JCommandPopupMenu;
import org.pushingpixels.flamingo.api.common.popup.JPopupPanel;
import org.pushingpixels.flamingo.api.common.popup.PopupPanelCallback;
import org.pushingpixels.flamingo.api.ribbon.JRibbonBand;
import org.pushingpixels.flamingo.api.ribbon.RibbonElementPriority;
import org.pushingpixels.flamingo.api.ribbon.resize.CoreRibbonResizePolicies;
import org.pushingpixels.flamingo.api.ribbon.resize.IconRibbonBandResizePolicy;

/**
 *
 * @author thisara
 */
public class JRibbonController {

    public static JCommandButton createButtonWithPopup(String text, ResizableIcon ri, final JCommandMenuButton... bt) {
        JCommandButton jcb = new JCommandButton(text, ri);
        jcb.setDisplayState(CommandButtonDisplayState.BIG);
        jcb.setCommandButtonKind(JCommandButton.CommandButtonKind.ACTION_AND_POPUP_MAIN_ACTION);
        jcb.setPopupCallback(new PopupPanelCallback() {
            @Override
            public JPopupPanel getPopupPanel(JCommandButton commandButton) {
                JCommandPopupMenu menu = new JCommandPopupMenu();
                for (int i = 0; i < bt.length; i++) {
                    menu.addMenuButton(bt[i]);
                }
                return menu;
            }
        });
        return jcb;
    }

    public static JCommandButton createButton(String text, ResizableIcon ri, ActionListener al) {
        JCommandButton jcb = new JCommandButton(text, ri);
        jcb.setDisplayState(CommandButtonDisplayState.BIG);
        jcb.setCommandButtonKind(JCommandButton.CommandButtonKind.ACTION_ONLY);
        jcb.addActionListener(al);
        return jcb;
    }

    public static JRibbonBand createRibbonBand(String title, ResizableIcon ri, JCommandButton bt) {
        JRibbonBand bandTest = new JRibbonBand(title, ri);
        bandTest.addCommandButton(bt, RibbonElementPriority.TOP);
        bandTest.setResizePolicies((List) Arrays.asList(new CoreRibbonResizePolicies.Mid2Mid(bandTest.getControlPanel()), new IconRibbonBandResizePolicy(bandTest.getControlPanel())));
        return bandTest;
    }

    public static JRibbonBand createRibbonBand(String title, ResizableIcon ri, JCommandButton... bt) {
        JRibbonBand bandTest = new JRibbonBand(title, ri);
        for (int i = 0; i < bt.length; i++) {
            bandTest.addCommandButton(bt[i], RibbonElementPriority.TOP);
        }
        bandTest.setResizePolicies((List) Arrays.asList(new CoreRibbonResizePolicies.Mid2Mid(bandTest.getControlPanel()), new IconRibbonBandResizePolicy(bandTest.getControlPanel())));
        return bandTest;
    }

    public static ResizableIcon getResizableIconFromResource(String resource) {
        return ImageWrapperResizableIcon.getIcon(Main.class.getClassLoader().getResource(resource), new Dimension(48, 48));
    }
}
