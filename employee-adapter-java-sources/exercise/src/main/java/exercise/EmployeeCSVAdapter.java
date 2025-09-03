package exercise;

public class EmployeeCSVAdapter implements Employee {
    private final String[] tokens;
    
    public EmployeeCSVAdapter(EmployeeCSV employeeCSV) {
        this.tokens = employeeCSV.tokens();
    }
    
    @Override
    public String getId() {
        return tokens.length > 0 ? tokens[0] : "";
    }
    
    @Override
    public String getFirstName() {
        return tokens.length > 1 ? tokens[1] : "";
    }
    
    @Override
    public String getLastName() {
        return tokens.length > 2 ? tokens[2] : "";
    }
    
    @Override
    public String getEmail() {
        return tokens.length > 3 ? tokens[3] : "";
    }
}
