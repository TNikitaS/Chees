/* автор Терещенков Никита Сергеевич
 *
 * Задание по 3-й лекции
 *
 */
public class Main {
    public static void main(String[] args) {
        Batman batman = new Batman();
        FireTruck fireTruck = new FireTruck();
        SuperMan superMan = new SuperMan();
        GenericLesson<Lego> genericLesson = new GenericLesson<>();

        batman.balanceAvailability();
        batman.Discriminant();
        System.out.println("Общее количество деталей: " + genericLesson.getNumberParts());
        genericLesson.sumClass(batman);
        System.out.println("Общее количество деталей: " + genericLesson.getNumberParts());
        genericLesson.sumClass(fireTruck);
        System.out.println("Общее количество деталей: " + genericLesson.getNumberParts());
        genericLesson.sumClass(superMan);
        System.out.println("Общее количество деталей: " + genericLesson.getNumberParts());
        System.out.println("Список суммированных конструкторов: " + genericLesson.getObjList());
    }
}

