package com.example.notifications;

public class WhatsAppDecorator implements Notifier {
    private final Notifier wrappedNotifier;
    private final String whatsAppUser;

    public WhatsAppDecorator(Notifier notifier, String whatsAppUser) {
        this.wrappedNotifier = notifier;
        this.whatsAppUser = whatsAppUser;
    }

    @Override
    public void notify(String text) {
        sendWhatsApp(text);
        wrappedNotifier.notify(text);
    }

    private void sendWhatsApp(String text) {
        System.out.println("[WHATSAPP -> " + whatsAppUser + "]: " + text);
    }
}
