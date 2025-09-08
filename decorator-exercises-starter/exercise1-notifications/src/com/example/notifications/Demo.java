package com.example.notifications;

/**
 * Starter demo that uses only the existing Email notifier.
 * TODOs guide you to add decorators and compose them.
 */
public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        base.notify("Baseline email only.");

        Notifier emailAndSms = new SmsDecorator(base, "+91-99999-11111");
        emailAndSms.notify("working email and sms");

        Notifier emailAndWhatsApp = new WhatsAppDecorator(base, "user_wa");
        emailAndWhatsApp.notify("working email and whatsapp");

        Notifier emailAndSlack = new SlackDecorator(base, "deployments");
        emailAndSlack.notify("working email ans slack");

        Notifier full = new SlackDecorator(
            new WhatsAppDecorator(base, "user_wa"), 
            "deployments"
        );
        full.notify("working full");

        Notifier allChannels = new SlackDecorator(
            new WhatsAppDecorator(
                new SmsDecorator(base, "+91-99999-11111"), 
                "user_wa"
            ), 
            "critical-alerts"
        );
        allChannels.notify("working all");
    }
}
