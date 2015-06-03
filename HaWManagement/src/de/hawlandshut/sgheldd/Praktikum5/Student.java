package de.hawlandshut.sgheldd.Praktikum5;

/**
 * Created by s-gheldd on 6/2/15.
 */
public class Student extends Person {
    private final String registrationNumber;
    private final String majorSubject;

    public Student( String registrationNumber, String majorSubject, String name, String address, String dateOfBirth) {
        super(name, address, dateOfBirth);
        this.registrationNumber = registrationNumber;
        this.majorSubject = majorSubject;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getMajorSubject() {
        return majorSubject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        if (!registrationNumber.equals(student.registrationNumber)) return false;
        return majorSubject.equals(student.majorSubject);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + registrationNumber.hashCode();
        result = 31 * result + majorSubject.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", majorSubject='" + majorSubject + '\'' +
                '}';
    }
}
