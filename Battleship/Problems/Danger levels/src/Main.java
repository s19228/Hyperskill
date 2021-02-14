enum DangerLevel {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private int lvl;

    DangerLevel(int lvl) {
        this.lvl = lvl;
    }

    public int getLevel() {
        return lvl;
    }
}