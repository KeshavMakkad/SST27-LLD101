package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;
    
    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = Objects.requireNonNull(csvReader, "csvReader cannot be null");
        this.profileService = Objects.requireNonNull(profileService, "profileService cannot be null");
    }
    
    @Override
    public int importFrom(Path csvFile) {
        Objects.requireNonNull(csvFile, "csvFile cannot be null");
        
        List<String[]> rows = csvReader.read(csvFile);
        int importedCount = 0;
        
        for (int i = 0; i < rows.size(); i++) {
            String[] row = rows.get(i);    
            if (i == 0 && isHeaderRow(row)) {
                continue;
            }
            if (isValidRow(row)) {
                try {
                    String id = row[0].trim();
                    String email = row[1].trim();
                    String displayName = row.length > 2 ? row[2].trim() : "";
                    profileService.createProfile(id, email, displayName);
                    importedCount++;
                } catch (Exception e) {
                    System.out.println("Skipping row " + (i + 1) + ": " + e.getMessage());
                }
            } else {
                System.out.println("Skipping invalid row " + (i + 1) + ": " + 
                    (row.length > 0 ? String.join(",", row) : "empty row"));
            }
        }
        
        return importedCount;
    }
    
    private boolean isHeaderRow(String[] row) {
        return row.length >= 2 && 
               "id".equalsIgnoreCase(row[0].trim()) && 
               "email".equalsIgnoreCase(row[1].trim());
    }
    
    private boolean isValidRow(String[] row) {
        if (row.length < 2) {
            return false;
        }
        
        String id = row[0].trim();
        String email = row[1].trim();
        
        if (id.isEmpty() || email.isEmpty()) {
            return false;
        }
        
        if (!email.contains("@")) {
            return false;
        }
        
        return true;
    }
}
