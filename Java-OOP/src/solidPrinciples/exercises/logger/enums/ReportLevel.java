package solidPrinciples.exercises.logger.enums;

public enum ReportLevel {
    INFO(0),
    WARNING(1),
    ERROR(2),
    CRITICAL(3),
    FATAL(4);

    private int level;

    ReportLevel (int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
