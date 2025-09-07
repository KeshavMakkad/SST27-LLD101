package com.example.render;

public class App {
    public static void main(String[] args) {
        Renderer r = new Renderer();
        String text = "Hello Flyweight! ".repeat(2000);
        int cost = r.render(text);
        
        System.out.println("Cost=" + cost);
        System.out.println("Text length: " + text.length() + " characters");
        System.out.println("Cached styles: " + TextStyleFactory.getCacheSize());
        
        TextStyle style1 = TextStyleFactory.getTextStyle("Inter", 14, false);
        TextStyle style2 = TextStyleFactory.getTextStyle("Inter", 14, false);
        System.out.println("Same style instances reused: " + (style1 == style2));
    }
}
