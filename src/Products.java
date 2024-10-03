import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//Класс продукции выпускаемой на предприятии
public abstract class Products implements iAddCap, iChangingThePackaging{

    DecimalFormat decFormat = new DecimalFormat("#.##");
    private String name;
    private int width;
    private int fatMassFraction;
    private int primeCost;
    private int sellingPrice;
    //количество продукции, которую заказал пользователь
    private static int countProduct;
    private static final int MIN_COUNT_PRODUCT = 400;
    private static final int MAX_COUNT_PRODUCT = 25000;


    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getFatMassFraction() {
        return fatMassFraction;
    }

    public int getPrimeCost() {
        return primeCost;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setFatMassFraction(int fatMassFraction) {
        this.fatMassFraction = fatMassFraction;
    }

    public void setPrimeCost(int primeCost) {
        this.primeCost = primeCost;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void outNameProducts(){
        System.out.println(name + " МДЖ " + fatMassFraction
                           + "%, вес нетто " + width + " грамм");
    }

    //метод взаимодействия с пользователем
    public static void userInteraction(List<Products> listObjects) {
        Scanner in = new Scanner(System.in);
        String cycleStatus = "Y";
        int indexObject;
        int totalOrderPrice = 0;
        while (cycleStatus.equalsIgnoreCase("y")) {
            System.out.println("Продукция доступная для приобретения");
            for (int i = 0; i <= listObjects.size() - 1; i++) {
                System.out.print(i + 1 + ") ");
                listObjects.get(i).outNameProducts();
            }
            System.out.print("Для осуществления заказа введите номер " +
                             "продукции, которую желаете заказать: ");
            try {
                indexObject = in.nextInt()-1;
                System.out.println("Желаете выполнить заказ продукции " +
                                   "в специальной таре 200 грамм ? Y/N: ");
                if (in.next().equalsIgnoreCase("y")) {
                    listObjects.get(indexObject).changingThePackaging();
                }
                System.out.print("Введите количество упаковок: ");
                countProduct = in.nextInt();
                while (countProduct < MIN_COUNT_PRODUCT || countProduct > MAX_COUNT_PRODUCT) {
                    if (countProduct< MIN_COUNT_PRODUCT) {
                        System.out.println(ConsoleColors.RED + "ВНИМАНИЕ нельзя заказать меньше "
                                + MIN_COUNT_PRODUCT + " едениц продукции");
                    } else {
                        System.out.println(ConsoleColors.RED + "ВНИМАНИЕ нельзя заказать больше "
                                + MAX_COUNT_PRODUCT + " едениц продукции");
                    }
                    System.out.println("Повторите ввод количества продукции" + ConsoleColors.RESET);
                    countProduct = in.nextInt();
                }
                System.out.print("Желаете добавить в упаковку пластиковую крышечку ? Y/N: ");
                if (in.next().equalsIgnoreCase("y")) {
                    listObjects.get(indexObject).addCap();
                }
                totalOrderPrice = totalOrderPrice +
                                  listObjects.get(indexObject).calculationOfCost(countProduct);
                System.out.println("Расчитанная цена заказа: " + totalOrderPrice + "руб");
                System.out.println("Желаете сделать ещё один заказ ? Y/N: ");
                cycleStatus = in.next();
                listObjects.remove(indexObject);
            } catch (InputMismatchException h) {
                System.out.println(ConsoleColors.RED + "ВНИМАНИЕ введёно некорректное значение");
                System.out.println("Повторите ввод данных"  + ConsoleColors.RESET);
                sleepProgram(2);
            } catch (Exception h) {
                System.out.println(ConsoleColors.RED + "ВНИМАНИЕ введённого " +
                                   "номера продукции не существует");
                System.out.println("Повторите ввод номера продукции"  + ConsoleColors.RESET);
                sleepProgram(2);
            }
        }
        in.close();
    }

    private int calculationOfCost(int productQuantity) {
        return productQuantity*getSellingPrice();
    }

    private static void sleepProgram(int timeSleepSeconds){
        try {
            TimeUnit.SECONDS.sleep(timeSleepSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
