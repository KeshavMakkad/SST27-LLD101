package com.example.notifications;

public class SlackDecorator implements Notifier {
    private final Notifier wrappedNotifier;
    private final String slackChannel;

    public SlackDecorator(Notifier notifier, String slackChannel) {
        this.wrappedNotifier = notifier;
        this.slackChannel = slackChannel;
    }

    @Override
    public void notify(String text) {
        sendSlack(text);
        wrappedNotifier.notify(text);
    }

    private void sendSlack(String text) {
        System.out.println("[SLACK -> #" + slackChannel + "]: " + text);
    }
}
