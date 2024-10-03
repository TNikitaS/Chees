public class CurdWithGarlic extends Cup{

    public CurdWithGarlic(){
        setName("Сыр творожный с чесноком и зеленью");
        setPrimeCost(90);
        setSellingPrice(110);
    }

    @Override
    public void addCap() {
        setPrimeCost(getPrimeCost()+5);
        setSellingPrice(getSellingPrice()+7);
    }

    @Override
    public void changingThePackaging() {
        setWidth(200);
        setPrimeCost(50);
        setSellingPrice(60);
    }
}
