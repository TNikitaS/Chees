//Класс продукции выпускаемой в стаканчиках
public abstract class Cup extends Products{

    protected Cup(){
        super();
        setWidth(400);
        setFatMassFraction(30);
        setSellingPrice(85);
    }
}
