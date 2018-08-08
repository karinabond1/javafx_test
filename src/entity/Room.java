package entity;

import javafx.beans.value.ObservableValue;

public class Room {
    private String  id;
    private String  korpus;
    private String  name;
    private String  count_place;
    private String  count_computers;
    private String  state_room;

    public Room(/*String id,*/ String korpus, String name, String count_place, String count_computers, String state_room) {
       // this.id = id;
        this.korpus = korpus;
        this.name = name;
        this.count_place = count_place;
        this.count_computers = count_computers;
        this.state_room = state_room;
    }

    public Room(String id, String korpus, String name, String count_place, String count_computers, String state_room) {
        // this.id = id;
        this.korpus = korpus;
        this.name = name;
        this.count_place = count_place;
        this.count_computers = count_computers;
        this.state_room = state_room;
    }

    public Room() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKorpus() {
        return korpus;
    }

    public void setKorpus(String korpus) {
        this.korpus = korpus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount_place() {
        return count_place;
    }

    public void setCount_place(String count_place) {
        this.count_place = count_place;
    }

    public String getCount_comp() {
        return count_computers;
    }

    public void setCount_comp(String count_computers) {
        this.count_computers = count_computers;
    }

    public String getState_room() {
        return state_room;
    }

    public void setState_room(String state_room) {
        this.state_room = state_room;
    }

    public void show(){
        System.out.println("id "+id+" korpus "+korpus+" name "+name+" count_place "+count_place+" count_comp "+count_computers+" state_room "+state_room);
    }

    public void showId(){
        System.out.println("id "+id);
    }


}
