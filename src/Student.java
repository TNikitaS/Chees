import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {

    private String name;
    private String group;
    private int course;
    private double averageGrades;
    private int studentIDCard;
    private static int countStudent = 0;
    private Random random = new Random();
    private static ArrayList<Student> listStudents = new ArrayList<>();
    private HashMap<String, Integer> mapGradesBySubject = new HashMap<>();
    final static ArrayList<String> listSubject = new ArrayList<>(Stream
            .of("история", "культурология", "философия", "логика",
                    "этика", "социология", "экономика", "правоведение",
                    "высшая математика", "иностранный язык", "физкультура")
            .collect(Collectors.toList()));
    final static ArrayList<String> listName = new ArrayList<>(Stream
            .of("Анна", "Мария", "Юлия", "Алёна", "Анастасия",
                    "Екатерина", "Дарья", "Ксения", "Кристина", "Алиса", "Яна",
                    "Ольга", "Александра", "Светлана", "Елизавета", "Маргарита",
                    "Елена", "Агата", "Юлиана", "Ирина", "Алина", "Арина", "Валерия",
                    "Виктория", "Диана", "Ева", "Карина", "Каролина", "Марина",
                    "Наталья", "Варвара", "Василиса", "Вера", "Любовь", "Марьяна",
                    "Надежда", "Оксана", "Регина", "Софья", "Татьяна", "Алла",
                    "Ангелина", "Вероника", "Евгения", "Жанна", "Лилия", "Милана",
                    "Полина", "Рената", "Эльвира", "Максим", "Михаил", "Александр",
                    "Дмитрий", "Денис", "Илья", "Андрей", "Даниил", "Артём", "Иван",
                    "Алексей", "Никита", " Павел", " Евгений", "Антон", "Лев", "Эльдар",
                    "Григорий", "Владимир", "Руслан").
            collect(Collectors.toList()));

    Student(String group) {
        countStudent += 1;
        generateName();
        setGroup(group);
        setCourse(random.nextInt(1, 5));
        setStudentIDCard(countStudent);
        fillingMapGradesBySubject();
        averageGradeCalculation();
        listStudents.add(this);
    }

    Student(String group, String name) {
        countStudent += 1;
        setName(name);
        setGroup(group);
        setCourse(random.nextInt(1, 5));
        setStudentIDCard(countStudent);
        fillingMapGradesBySubject();
        averageGradeCalculation();
        listStudents.add(this);
    }

    Student(String group, String name, int course) {
        countStudent += 1;
        setName(name);
        setGroup(group);
        setCourse(course);
        setStudentIDCard(countStudent);
        fillingMapGradesBySubject();
        averageGradeCalculation();
        listStudents.add(this);
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public double getAverageGrades() {
        return averageGrades;
    }

    public int getStudentIDCard() {
        return studentIDCard;
    }

    public static ArrayList<Student> getListStudents() {
        return listStudents;
    }

    public HashMap<String, Integer> getMapGradesBySubject() {
        return mapGradesBySubject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setAverageGrades(double averageGrades) {
        this.averageGrades = averageGrades;
    }

    public void setStudentIDCard(int studentIDCard) {
        this.studentIDCard = studentIDCard;
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("На курсе номер: " + course + ". Обучаются следующие студенты:");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.print(student.getName());
                System.out.println(" |Средний балл = " + student.getAverageGrades());
            }
        }
    }

    public void averageGradeCalculation() {
        double sumGrades = 0;
        for (Map.Entry<String, Integer> map : mapGradesBySubject.entrySet()) {
            sumGrades += map.getValue();
        }
        setAverageGrades(sumGrades / mapGradesBySubject.size());
    }

    public static void removingUnderachievingStudents() {
        Iterator<Student> iteratorRemove = listStudents.iterator();
        while (iteratorRemove.hasNext()) {
            if (iteratorRemove.next().getAverageGrades() < 3) {
                iteratorRemove.remove();
            }
        }
        for (Student student : listStudents) {
            student.setCourse(student.getCourse() + 1);
        }
    }

    private void fillingMapGradesBySubject() {
        for (String item : listSubject) {
            mapGradesBySubject.put(item, random.nextInt(1, 6));
        }
    }

    private void generateName() {
        setName(listName.get(random.nextInt(listName.size())));
    }
}
