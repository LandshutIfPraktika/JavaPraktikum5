package de.hawlandshut.sgheldd.Praktikum5;

/**
 * Created by s-gheldd on 6/2/15.
 */
public class UniversityManagement {

    private final Room[] rooms;
    private final Person[] persons;
    static boolean exists  = false;

    public UniversityManagement( int personNumber, int roomNumber) throws Exception{
        if (exists) {
            throw new Exception("Only one UniversityManagement allowed");
        } else {
            this.rooms = new Room[roomNumber];
            this.persons = new Person[personNumber];
            this.exists = true;
        }
    }
}
