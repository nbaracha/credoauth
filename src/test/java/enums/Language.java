package enums;

public enum Language {
    GE("GE", "ქართული"),
    EN("EN", "English"),
    RU("RU", "Русский");

    private final String code;
    private final String label;

    Language(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}