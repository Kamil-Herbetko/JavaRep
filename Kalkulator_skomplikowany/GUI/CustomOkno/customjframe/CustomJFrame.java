package Kalkulator_skomplikowany.GUI.CustomOkno.customjframe;

import Kalkulator_skomplikowany.GUI.CustomOkno.UserControls.ButtonType;
import Kalkulator_skomplikowany.GUI.CustomOkno.UserControls.ControlBoxJButton;
import Kalkulator_skomplikowany.GUI.CustomOkno.UserControls.IconJPanel;
import Kalkulator_skomplikowany.GUI.CustomOkno.customdecoration.CustomDecorationParameters;
import Kalkulator_skomplikowany.GUI.CustomOkno.customdecoration.CustomDecorationWindowProc;
import Kalkulator_skomplikowany.GUI.CustomOkno.theme.Theme;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomJFrame extends JFrame {
    final Theme theme;
    final CustomDecorationWindowProc windowProcEx;
    private WindowFrameType windowFrameType = WindowFrameType.NORMAL;
    private JPanel titleBar;
    private JPanel titleBarCustomContent;
    private JPanel controlBox;
    private JPanel frameContentPane;
    private JPanel iconContainer;
    private ControlBoxJButton closeBtn, minimizeBtn, restoreButton;
    private MouseAdapter closeBtnMouseAdapter, restoreBtnMouseAdapter, minimizeBtnMouseAdapter;

    public CustomJFrame(Theme theme, String title) throws HeadlessException {
        super(title);
        this.theme = theme;
        windowProcEx = new CustomDecorationWindowProc();
        initializeFrame();
    }

    public CustomJFrame(Theme theme, String title, WindowFrameType windowFrameType){
        this(theme,title);
        this.windowFrameType = windowFrameType;
        initializeFrame();
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        windowProcEx.init(getHwnd());
    }

    private WinDef.HWND getHwnd(){
        WinDef.HWND hwnd = new WinDef.HWND();
        hwnd.setPointer(Native.getComponentPointer(this));
        return hwnd;
    }

    public ControlBoxJButton getRestoreButton() {
        return restoreButton;
    }

    private void initializeFrame(){
        setLayout(new BorderLayout());

        frameContentPane = new JPanel();
        frameContentPane.setLayout(new BorderLayout());
        frameContentPane.setOpaque(false);
        setupFrameTitleBar();

        JPanel clientContentPane = new JPanel();
        clientContentPane.setLayout(new FlowLayout());
        clientContentPane.setOpaque(false);
        frameContentPane.add(clientContentPane);

        setContentPane(frameContentPane);
        setUndecorated(true);
        setBackground(theme.getDefaultBackgroundColor());


        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                CustomJFrame mainFrame = (CustomJFrame) e.getSource();
                if (mainFrame.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                    CustomDecorationParameters.setMaximizedWindowFrameThickness(12);
                    mainFrame.getRootPane().setBorder(BorderFactory.createLineBorder(mainFrame.getBackground(),
                            CustomDecorationParameters.getMaximizedWindowFrameThickness()));
                    if(mainFrame.getRestoreButton() != null){
                        mainFrame.getRestoreButton().setControlBoxButtonType(ButtonType.RESTORE);
                    }
                } else {
                    CustomDecorationParameters.setMaximizedWindowFrameThickness(0);
                    mainFrame.getRootPane().setBorder(BorderFactory.createLineBorder(theme.getFrameBorderColor(),
                            CustomDecorationParameters.getFrameBorderThickness()));
                    if(mainFrame.getRestoreButton() != null && mainFrame.getRestoreButton().controlBoxButtonType != ButtonType.MAXIMIZE){
                        mainFrame.getRestoreButton().setControlBoxButtonType(ButtonType.MAXIMIZE);
                    }
                }
            }
        });

        pack();
        CustomDecorationParameters.setControlBoxWidth(controlBox.getWidth() + 10);
    }

    private void setupFrameTitleBar(){
        if(windowFrameType == WindowFrameType.NONE){
            CustomDecorationParameters.setTitleBarHeight(0);
        } else {
            titleBar = new JPanel();
            titleBar.setLayout(new BorderLayout());
            titleBar.setOpaque(false);

            iconContainer = new JPanel();
            iconContainer.setOpaque(false);

            setupFrameControlBox();
            titleBar.add(controlBox, BorderLayout.EAST);

            titleBarCustomContent = new JPanel();
            titleBarCustomContent.setLayout(new FlowLayout(3,0,0));
            titleBarCustomContent.setOpaque(false);
            titleBarCustomContent.add(iconContainer);

            titleBar.add(titleBarCustomContent, BorderLayout.WEST);
            frameContentPane.add(titleBar, BorderLayout.NORTH);
        }
    }

    private void setupFrameControlBox(){
        controlBox = new JPanel();
        controlBox.setOpaque(false);

        if(windowFrameType == WindowFrameType.NORMAL){
            controlBox.setLayout(new GridLayout(1, 3, -1, 0));
            addMinimizeButton();
            addRestoreButton();
            addCloseButton();
        } else if(windowFrameType == WindowFrameType.TOOL){
            controlBox.setLayout(new GridLayout(1, 1, -1, 0));
            addCloseButton();
        }
    }

    private void addCloseButton(){
        closeBtn = new ControlBoxJButton(ButtonType.CLOSE,theme);
        closeBtn.setPreferredSize(new Dimension(50, CustomDecorationParameters.getTitleBarHeight()));
        closeBtn.setBackground(theme.getDefaultBackgroundColor());
        closeBtnMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        };
        closeBtn.addMouseListener(closeBtnMouseAdapter);
        controlBox.add(closeBtn);
    }

    private void addRestoreButton(){
        restoreButton = new ControlBoxJButton(ButtonType.MAXIMIZE, theme);
        restoreButton.setPreferredSize(new Dimension(50, CustomDecorationParameters.getTitleBarHeight()));
        restoreButton.setBackground(theme.getDefaultBackgroundColor());
        restoreBtnMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (getExtendedState() == JFrame.MAXIMIZED_BOTH)
                    setExtendedState(JFrame.NORMAL);
                else
                    setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        };
        restoreButton.addMouseListener(restoreBtnMouseAdapter);
        controlBox.add(restoreButton);
    }

    private void addMinimizeButton(){
        minimizeBtn = new ControlBoxJButton(ButtonType.MINIMIZE, theme);
        minimizeBtn.setPreferredSize(new Dimension(50, CustomDecorationParameters.getTitleBarHeight()));
        minimizeBtn.setBackground(theme.getDefaultBackgroundColor());
        minimizeBtnMouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setExtendedState(JFrame.ICONIFIED);
            }
        };
        minimizeBtn.addMouseListener(minimizeBtnMouseAdapter);
        controlBox.add(minimizeBtn);
    }

    public void addUserControlsToTitleBar(Component component){
        titleBarCustomContent.add(component);
        pack();
        CustomDecorationParameters.setExtraLeftReservedWidth(titleBarCustomContent.getWidth() + 10);
    }

    public int getTitleBarHeight(){
        pack();
        return titleBarCustomContent.getHeight();
    }

    public void setIcon(Image image){
        iconContainer.setLayout(new FlowLayout(1,0,0));
        iconContainer.setPreferredSize(new Dimension(
                CustomDecorationParameters.getIconWidth(),
                CustomDecorationParameters.getTitleBarHeight()));

        IconJPanel iconJPanel = new IconJPanel(image);
        iconContainer.add(iconJPanel);
        pack();
        CustomDecorationParameters.setExtraLeftReservedWidth(titleBarCustomContent.getWidth() + 10);
    }

    public void addJFrameCloseEventAdapter(MouseAdapter mouseAdapter){
        if(closeBtn != null){
            closeBtn.removeMouseListener(closeBtnMouseAdapter);
            closeBtn.addMouseListener(mouseAdapter);
        }
    }

    public void addJFrameRestoreEventAdapter(MouseAdapter mouseAdapter){
        if(restoreButton != null){
            restoreButton.removeMouseListener(closeBtnMouseAdapter);
            restoreButton.addMouseListener(mouseAdapter);
        }
    }

    public void addJFrameMinimizeEventAdapter(MouseAdapter mouseAdapter){
        if(restoreButton != null){
            closeBtn.removeMouseListener(closeBtnMouseAdapter);
            closeBtn.addMouseListener(mouseAdapter);
        }
    }

}
