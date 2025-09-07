package com.example.report;
import java.nio.file.*; import java.util.*;

public class App {
    public static void main(String[] args) {
        Map<String,Object> data = Map.of("name", "Quarterly");
        ReportBundleFacade rbf = new ReportBundleFacade();
        Path zip = rbf.export(data, Path.of("out"), "report");
        System.out.println("Wrote " + zip);
    }
}
