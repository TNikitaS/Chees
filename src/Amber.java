public class Amber extends Cup{

    public Amber(int width){
        setWidth(width);
        setName("Продукт плавленный с сыром \"Янтарь\"");
        setFatMassFraction(60);
        if (width == 170){
            setPrimeCost(45);
            setSellingPrice(54);
        } else {
            setPrimeCost(72);
        }
    }

    @Override
    public void addCap() {
        if (getWidth() == 170) {
            setPrimeCost(getPrimeCost()+2);
            setSellingPrice(getSellingPrice()+4);
        } else if(getWidth() == 400) {
            setPrimeCost(getPrimeCost()+4);
            setSellingPrice(getSellingPrice()+6);
        } else {
            setPrimeCost(getPrimeCost()+3);
            setSellingPrice(getSellingPrice()+4);
        }
    }

    @Override
    public void changingThePackaging() {
        setWidth(200);
        setPrimeCost(49);
        setSellingPrice(58);
    }
}
