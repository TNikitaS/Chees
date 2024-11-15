import java.util.ArrayList;

public class GenericLesson<T extends Lego> {

    private T t;
    private int numberParts = 0;
    private ArrayList<String> objList = new ArrayList<String>();

    public T get() {
        return t;
    }

    public int getNumberParts() {
        return numberParts;
    }

    public ArrayList<String> getObjList() {
        return objList;
    }

    public void setNumberParts(int numberParts) {
        this.numberParts = numberParts;
    }

    public <M extends T> void sumClass(M lim) {
        setNumberParts(getNumberParts() + ((M) lim).getNumberParts());
        objList.add(((M) lim).getName());
    }
}
