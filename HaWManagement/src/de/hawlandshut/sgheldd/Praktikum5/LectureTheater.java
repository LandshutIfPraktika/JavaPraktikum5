package de.hawlandshut.sgheldd.Praktikum5;

/**
 * Created by s-gheldd on 5/27/15.
 */
public class LectureTheater extends BaseRoom implements Room {

    private final int seats;

    private boolean multiMedia;

    public LectureTheater(int seats, boolean multiMedia, String address, String number ){
        super(address,number);
        this.seats=seats;
        this.multiMedia=multiMedia;
    }


    public int getSeats() {
        return seats;
    }

    public boolean isMultiMedia() {
        return multiMedia;
    }

    public void setMultiMedia(boolean multiMedia) {
        this.multiMedia = multiMedia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LectureTheater that = (LectureTheater) o;

        if (seats != that.seats) return false;
        return multiMedia == that.multiMedia;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + seats;
        result = 31 * result + (multiMedia ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LectureTheater{" +
                "seats=" + seats +
                ", multiMedia=" + multiMedia +
                '}';
    }
}
