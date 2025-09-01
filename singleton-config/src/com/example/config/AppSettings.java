package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * FAULTY "Singleton": public constructor, getInstance() returns a NEW instance
 * each time,
 * not thread-safe, reload allowed anytime, mutable global state,
 * reflection+serialization-friendly.
 */
public class AppSettings implements Serializable {
    private final Properties props = new Properties();
    private static volatile AppSettings instance;

    private AppSettings() {
    }

    public static AppSettings getInstance() {
        if (instance == null) {
            synchronized (AppSettings.class) {
                if (instance == null) {
                    instance = new AppSettings();
                }
            }
        }
        return instance;
    }

    public static AppSettings getInstanceLazyMethod() { // Not thread safe
        if (instance == null) {
            instance = new AppSettings();
        }
        return instance;
    }

    public synchronized static AppSettings getInstanceThreadSafe() { // slow
        if (instance == null) {
            instance = new AppSettings();
        }
        return instance;
    }

    public static AppSettings getInstanceEagerLoading() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final AppSettings INSTANCE = new AppSettings();
    }

    public static AppSettings getInstanceEnum() {
        return SingletonEnum.INSTANCE.getAppSettings();
    }

    private enum SingletonEnum {
        INSTANCE;

        private final AppSettings appSettings;

        SingletonEnum() {
            appSettings = new AppSettings();
        }

        public AppSettings getAppSettings() {
            return appSettings;
        }
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
            System.out.println("Successfully loaded properties from: " + file);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}
