public class WithHam extends Cup{

    public WithHam(){
        setName("Продукт плавленный с ветчиной");
        setFatMassFraction(50);
        setPrimeCost(68);
    }

    @Override
    public void addCap() {
        setPrimeCost(getPrimeCost()+4);
        setSellingPrice(getSellingPrice()+6);
    }

    @Override
    public void changingThePackaging() {
        setWidth(200);
        setPrimeCost(38);
        setSellingPrice(46);
    }
}
