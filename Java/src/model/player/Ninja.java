package model.player;

/**
 *
 */
public class Ninja implements Player {
    private int health;
    private int attack;
    private int defense;
    private int speed;
    private int level;
    private int exp;
    private int next;
    private String nama;
    private final int classId;
    /**
     * Default constructor
     */
    public Ninja(String nama) {
        this.nama = nama;
        classId = 1;
        health = 100;
        attack = 5;
        defense = 7;
        speed = 10;
        level = 1;
        exp = 0;
        next = 10;
    }
    /**
     * Menambah level player dan mengurangi nilai exp dengan nilai next.
     * Mengubah nilai next sesuai dengan rumus next * k + offset
     */
    @Override
    public void levelUp() {
        exp -= next;
        next = next * 3 / 2 + 5;
        level++;
        health += 10;
        attack += 1;
        defense += 1;
        speed += 3;
    }
    /**
     * Mengecek apakah player harus level up
     */
    public boolean isLeveling() {
        return exp >= next;
    }

    // Getter & Setter

    public int getHealth() {
        return health;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefense() {
        return defense;
    }
    public int getSpeed() {
        return speed;
    }
    public int getLevel() {
        return level;
    }
    public int getExp() {
        return exp;
    }
    public int getNext() {
        return next;
    }
    public String getNama() {
        return nama;
    }
    public int getClassId() {
        return classId;
    }
}