package com.example.config;

public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("Testing different singleton implementations:");

        AppSettings instance1 = AppSettings.getInstance();
        AppSettings instance2 = AppSettings.getInstance();
        System.out.println("Double-checked locking - Same instance: " + (instance1 == instance2));
        System.out.println("Instance 1 hash: " + System.identityHashCode(instance1));
        System.out.println("Instance 2 hash: " + System.identityHashCode(instance2));

        AppSettings lazy1 = AppSettings.getInstanceLazyMethod();
        AppSettings lazy2 = AppSettings.getInstanceLazyMethod();
        System.out.println("\nLazy method - Same instance: " + (lazy1 == lazy2));
        System.out.println("Lazy 1 hash: " + System.identityHashCode(lazy1));
        System.out.println("Lazy 2 hash: " + System.identityHashCode(lazy2));

        AppSettings sync1 = AppSettings.getInstanceThreadSafe();
        AppSettings sync2 = AppSettings.getInstanceThreadSafe();
        System.out.println("\nThread-safe method - Same instance: " + (sync1 == sync2));
        System.out.println("Sync 1 hash: " + System.identityHashCode(sync1));
        System.out.println("Sync 2 hash: " + System.identityHashCode(sync2));

        AppSettings eager1 = AppSettings.getInstanceEagerLoading();
        AppSettings eager2 = AppSettings.getInstanceEagerLoading();
        System.out.println("\nEager loading - Same instance: " + (eager1 == eager2));
        System.out.println("Eager 1 hash: " + System.identityHashCode(eager1));
        System.out.println("Eager 2 hash: " + System.identityHashCode(eager2));

        AppSettings enum1 = AppSettings.getInstanceEnum();
        AppSettings enum2 = AppSettings.getInstanceEnum();
        System.out.println("\nEnum singleton - Same instance: " + (enum1 == enum2));
        System.out.println("Enum 1 hash: " + System.identityHashCode(enum1));
        System.out.println("Enum 2 hash: " + System.identityHashCode(enum2));

        System.out.println("\nAll methods return same global instance: " +
                (instance1 == lazy1 && lazy1 == sync1 && sync1 == eager1));
        System.out.println("Note: Different singleton methods create different instances in this implementation");
    }
}
