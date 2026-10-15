package model;
public enum Grade {
    A, B, C, D, E, F;
    public static Grade fromScore(double score) {
        if (score < 0 || score > 100) throw new IllegalArgumentException("Score must be between 0 and 100.");
        if (score >= 70) return A;
        if (score >= 60) return B;
        if (score >= 50) return C;
        if (score >= 45) return D;
        if (score >= 40) return E;
        return F;
    }
}
