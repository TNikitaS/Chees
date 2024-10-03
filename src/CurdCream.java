public class CurdCream extends Cup{

    public CurdCream(){
        setName("Сыр сливочный творожный");
        setPrimeCost(85);
        setSellingPrice(104);
    }

    @Override
    public void addCap() {
        setPrimeCost(getPrimeCost()+5);
        setSellingPrice(getSellingPrice()+7);
    }

    @Override
    public void changingThePackaging() {
        setWidth(200);
        setPrimeCost(45);
        setSellingPrice(57);
    }
}
