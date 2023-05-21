package config;

public enum ExecutionMode {
    LOCAL("local"),GRID("grid");
    private String value;
    ExecutionMode (String value) {
        this.value = value;
    }
}
