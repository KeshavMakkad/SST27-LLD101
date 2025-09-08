package com.example.notifications;

public class SmsDecorator implements Notifier {
    private final Notifier wrappedNotifier;
    private final String phoneNumber;

    public SmsDecorator(Notifier notifier, String phoneNumber) {
        this.wrappedNotifier = notifier;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void notify(String text) {
        sendSms(text);
        wrappedNotifier.notify(text);
    }

    private void sendSms(String text) {
        System.out.println("[SMS -> " + phoneNumber + "]: " + text);
    }
}
