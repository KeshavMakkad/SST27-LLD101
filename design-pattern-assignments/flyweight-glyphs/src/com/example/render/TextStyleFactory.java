package com.example.render;

import java.util.HashMap;
import java.util.Map;

public class TextStyleFactory {
    private static final Map<String, TextStyle> styleCache = new HashMap<>();

    public static TextStyle getTextStyle(String font, int size, boolean bold) {
        String key = font + "|" + size + "|" + (bold ? "B" : "");
        
        TextStyle style = styleCache.get(key);
        if (style == null) {
            style = new TextStyle(font, size, bold);
            styleCache.put(key, style);
        }
        
        return style;
    }

    public static int getCacheSize() {
        return styleCache.size();
    }
}
