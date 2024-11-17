import java.util.ArrayList;

/* автор Терещенков Никита Сергеевич
 *
 * Задание по 1й лекции
 *
 * В данном коде реализована классовая модель реальной продукции,
 * выпускаемой на Ульяновском предприятии СимбирскМолПром
 */
public class Main {
    public static void main(String[] args) {

        ArrayList<Products> listObjects = new ArrayList<Products>();

        //создание объектов продукции и добавление их в список
        {
            Amber amber = new Amber(170);
            listObjects.add(amber);
            Amber amber2 = new Amber(400);
            listObjects.add(amber2);
            CurdCream curdCream = new CurdCream();
            listObjects.add(curdCream);
            CurdWithGarlic curdWithGarlic = new CurdWithGarlic();
            listObjects.add(curdWithGarlic);
        }
        Products.userInteraction(listObjects);
    }
}