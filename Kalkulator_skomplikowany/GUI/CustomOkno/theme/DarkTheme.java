package Kalkulator_skomplikowany.GUI.CustomOkno.theme;

import java.awt.Color;

public class DarkTheme implements Theme {
    @Override
    public Color getFrameBorderColor() {
        return new Color(60, 63, 65, 204);
    }

    @Override
    public Color getDefaultBackgroundColor() {
        return new Color(60, 63, 65, 204);
    }

    @Override
    public Color getDefaultForegroundColor() {
        return new Color(60, 63, 65, 204);
    }

    @Override
    public Color getLightForegroundColor() {
        return new Color(60, 63, 65, 204);
    }

    @Override
    public Color getDefaultButtonHoverColor() {
        return new Color(101, 101, 101);
    }

    @Override
    public Color getDefaultButtonPressedColor() {
        return new Color(101,101,101);
    }

    @Override
    public Color getCloseButtonHoverColor() {
        return new Color(232,17,35);
    }

    @Override
    public Color getCloseButtonPressedColor() {
        return new Color(241,112,122);
    }
}
