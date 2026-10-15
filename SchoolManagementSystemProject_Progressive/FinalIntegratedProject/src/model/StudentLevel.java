package model;
public enum StudentLevel {
    ND1, ND2, HND1, HND2, LEVEL_100, LEVEL_200, LEVEL_300, LEVEL_400;
    public static StudentLevel fromInput(String value) {
        String normalized = value.trim().toUpperCase();
        if (normalized.matches("\\d{3}")) normalized = "LEVEL_" + normalized;
        return StudentLevel.valueOf(normalized);
    }
}
