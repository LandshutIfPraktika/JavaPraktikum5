package de.hawlandshut.sgheldd.Praktikum5;

/**
 * Created by s-gheldd on 6/2/15.
 */
public class Professor extends Person {
    private final String title;
    private boolean dean;
    private static boolean deanIsSet = false;

    Professor (String title, boolean dean, String name, String address, String dateOfBirth) throws Exception{
        super(name, dateOfBirth, address);
        this.title = title;
        if (deanIsSet && dean) {
            throw new Exception("Only one dean allowed");
        } else {
            this.dean = dean;
        }
    }

    public String getTitle() {
        return title;
    }

    public boolean isDean() {
        return dean;
    }

    public void setDean(boolean dean) throws Exception{
        if (deanIsSet && dean) {
            throw new Exception("Only one dean allowed");
        } else {
            this.dean = dean;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Professor professor = (Professor) o;

        if (dean != professor.dean) return false;
        return title.equals(professor.title);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (dean ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "title='" + title + '\'' +
                ", dean=" + dean +
                '}';
    }
}
