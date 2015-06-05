package de.hawlandshut.sgheldd.Praktikum5;

import java.util.Arrays;

/**
 * Created by s-gheldd on 6/2/15.
 */
public class UniversityManagement {

    private final Room[] rooms;
    private final Person[] persons;
    static boolean exists = false;

    public UniversityManagement(int personNumber, int roomNumber) throws Exception {
        if (exists) {
            throw new Exception("Only one UniversityManagement allowed");
        } else {
            this.rooms = new Room[roomNumber];
            this.persons = new Person[personNumber];
            this.exists = true;
        }
    }

    public void addPerson(Person person) {

        for (int i = 0; i < persons.length; i++) {
            if (persons[i] == null){
                persons[i] = person;
            } else if (person.equals(persons[i])){
                return;
            }
        }
    }

    public void addRoom(Room room){

        for (int i = 0;i < rooms.length;i++){
            if (rooms[i] == null){
                rooms[i] = room;
            } else if (room.equals(rooms[i])){
                return;
            }
        }
    }

    public Room[] getRooms(){
        int lastRoom = this.rooms.length-1;
        for (;lastRoom >= 0 && rooms[lastRoom]==null; lastRoom--){}
        Room[] returnRooms = new Room[lastRoom+1];
        for (int i = 0; i <= lastRoom; i++){
            returnRooms[i]=rooms[i];
        }
        return returnRooms;
    }

    public Person[] getPersons(){
        int lastPerson = this.persons.length-1;
        for (;lastPerson >= 0 && persons[lastPerson]==null; lastPerson--){}
        Person[] returnPersons = new Person[lastPerson+1];
        for (int i = 0; i <= lastPerson; i++){
            returnPersons[i]=persons[i];
        }
        return returnPersons;
    }

    public void printAllRooms(){
        String output = "";
        for(Room room :this.rooms){
            if (room != null){
                output += room.toString() + "\n";
            }
        }
        System.out.print(output);
    }

    public void printAllPersons(){
        String output = "";
        for(Person person : this.persons){
            if(person != null){
                output += person.toString() + "\n";
            }
        }
        System.out.print(output);
    }

    public void printAllStudents(){
        String output = "";
        for (Person person : this.persons){
            if(person != null && person instanceof Student){
                output += person + "\n";
            }
        }
        System.out.print(output);
    }

    public void printAllProfessors(){
        String output = "";
        for (Person person : this.persons){
            if(person != null && person instanceof Professor){
                output += person + "\n";
            }
        }
        System.out.print(output);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UniversityManagement that = (UniversityManagement) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(rooms, that.rooms)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(persons, that.persons);

    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(rooms);
        result = 31 * result + Arrays.hashCode(persons);
        return result;
    }

    @Override
    public String toString() {
        return "UniversityManagement{" +
                "rooms=" + Arrays.toString(rooms) +
                ", persons=" + Arrays.toString(persons) +
                '}';
    }
}
