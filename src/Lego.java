public abstract class Lego {
    private String name;
    private String difficultyLevel;
    private int numberParts;
    private int ageLimit;

    public Lego() {
        setName("Конструктор|");
    }

    public String getName() {
        return name;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getNumberParts() {
        return numberParts;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public void setNumberParts(int numberParts) {
        this.numberParts = numberParts;
    }

    public void balanceAvailability() {
        CheckingDivisibility<Integer> thirTeen = x -> x % 13 == 0;
        System.out.print("Набор " + getName());
        if (thirTeen.checkDivisibility(getNumberParts())) {
            System.out.println(" Разложен без остатка");
        }
        System.out.println(" Разложен с остатком");
    }

    public void Discriminant() {
        CalculateDiscriminant<Double> D = (a, b, c) -> b * b - 4 * a * c;
        System.out.println("Дискриминант равен: " + D.calculateDiscriminant(15.86, 37.23 + getAgeLimit(), 2.983));
    }
}
