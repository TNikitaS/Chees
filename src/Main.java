/* автор Терещенков Никита Сергеевич
 *
 * Задание по 4-й лекции
 */
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("ПСбд");
        Student student2 = new Student("ПСбд");
        Student student3 = new Student("ПСбд");
        Student student4 = new Student("ПСбд");
        Student student5 = new Student("ПСбд");
        Student student6 = new Student("ПСбд");
        Student student7 = new Student("ПСбд");
        Student student8 = new Student("ПСбд");
        Student student9 = new Student("ПСбд");
        Student student10 = new Student("ПСбд");
        Student student11 = new Student("ПСбд");
        Student student12 = new Student("ПСбд");
        Student student13 = new Student("ПСбд");
        Student student14 = new Student("ПСбд");
        Student student15 = new Student("ПСбд");
        Student student16 = new Student("ПСбд");
        Student student17 = new Student("ПСбд");
        Student student18 = new Student("ПСбд");
        Student student19 = new Student("ПСбд");
        Student student20 = new Student("ПСбд");
        Student.printStudents(Student.getListStudents(),1);
        Student.removingUnderachievingStudents();
        Student.printStudents(Student.getListStudents(),2);
    }
}
