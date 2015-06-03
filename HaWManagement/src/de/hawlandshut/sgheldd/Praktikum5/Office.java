package de.hawlandshut.sgheldd.Praktikum5;

/**
 * Created by s-gheldd on 5/27/15.
 */
public class Office extends BaseRoom implements Room{
    private final double size;

    private Professor owner;

    public Office(Professor owner, double size, String address, String number){
        super(address,number);

        this.owner = owner;
        this.size = size;
    }


    public Professor getOwner(){
        return this.owner;
    }

    public double getSize(){
        return this.size;
    }

    public void setOwner(Professor owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Office office = (Office) o;

        if (Double.compare(office.size, size) != 0) return false;
        return owner.equals(office.owner);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(size);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + owner.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Office{" +
                "size=" + size +
                ", owner=" + owner +
                '}';
    }
}
