package entity;

public class KlassRoom implements Comparable<KlassRoom> {
    int maxCountPlace;
    String name;
    KlassRoomType klassRoomType;
    boolean isActive;
    int countPC;
    String telefon;

    @Override
    public int compareTo(KlassRoom o) {
        return this.name.compareToIgnoreCase(o.name);
    }
}
