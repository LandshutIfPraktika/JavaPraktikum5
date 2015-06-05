package de.hawlandshut.sgheldd.Praktikum5;

/**
 * Created by s-gheldd on 5/27/15.
 */
public abstract class BaseRoom implements Room {

    private final String address;
    private final String number;

    public BaseRoom(String address, String number) throws NullPointerException{
        if (address == null || number == null){
            throw new NullPointerException();
        }
        this.address=address;
        this.number=number;
    }

    public String getAddress(){
        return this.address;
    }

    public String getNumber(){
        return this.address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseRoom baseRoom = (BaseRoom) o;

        if (!address.equals(baseRoom.address)) return false;
        return number.equals(baseRoom.number);

    }

    @Override
    public int hashCode() {
        int result = address.hashCode();
        result = 31 * result + number.hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "BaseRoom{" +
                "address='" + address + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
