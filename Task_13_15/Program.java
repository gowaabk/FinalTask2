//13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
//14. Написать программу, имитирующую работу реестра домашних животных.
//В программе должен быть реализован следующий функционал:
//14.1 Завести новое животное
//14.2 определять животное в правильный класс
//14.3 увидеть список команд, которое выполняет животное
//14.4 обучить животное новым командам
//14.5 Реализовать навигацию по меню
//15. Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
//значение внутренней̆ int переменной̆ на 1 при нажатии “Завести новое
//животное” Сделайте так, чтобы с объектом такого типа можно было работать в
//блоке try-with-resources. Нужно бросить исключение, если работа с объектом
//типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
//считать в ресурсе try, если при заведении животного заполнены все поля.

package Task_13_15;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {

    static List<Dog> dog = new ArrayList<>();
    static List<Cat> cat = new ArrayList<>();
    static List<Hamster> hamster = new ArrayList<>();
    static List<Horse> horse = new ArrayList<>();
    static List<Camel> camel = new ArrayList<>();
    static List<Donkey> donkey = new ArrayList<>();
    static Counter count = new Counter();

    public static void menu() {
        System.out.println("Меню:");
        System.out.println("1. Вывод списка всех животных с их командами");
        System.out.println("2. Завести новое животное");
        System.out.println("3. Обучить животное новым командам");
        System.out.println("0. Выйти");
        System.out.println();
        System.out.print("Введите необходимое действие цифрой меню: ");
    }

    public static void showAnimals() {
        int i = 1;
        for (Cat cat : cat) {
            System.out.println(i + ". " + cat);
            i++;
        }
        for (Dog dog : dog) {
            System.out.println(i + ". " + dog);
            i++;
        }
        for (Hamster humster : hamster) {
            System.out.println(i + ". " + humster);
            i++;
        }
        for (Horse horse : horse) {
            System.out.println(i + ". " + horse);
            i++;
        }
        for (Camel camel : camel) {
            System.out.println(i + ". " + camel);
            i++;
        }
        for (Donkey donkey : donkey) {
            System.out.println(i + ". " + donkey);
            i++;
        }
        System.out.println();
    }

    public static class NoFullData extends RuntimeException {
        public NoFullData(String errorMessage, Throwable err) {
            super(errorMessage, err);
        }
    }

    public static void addAnimal() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите имя животного: ");
            String name_animal = scanner.nextLine();
            System.out.print("Введите дату рождения животного (Формат dd.MM.yyyy): ");
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            format.setLenient(false);
            Date date_of_birth = new Date();
            String commands;
            try {
                date_of_birth = format.parse(scanner.nextLine());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.print("Введите номер группы животного (1. Pets, 2. Pack): ");
            int i;
            i = Integer.parseInt(scanner.nextLine());
            if (i == 1) {
                System.out.print("Введите номер вида животного (1. cat, 2. dog, 3. hamster): ");
                int x = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите команды которыми владеет животное: ");
                commands = scanner.nextLine();
                switch (x) {
                    case 1:
                        cat.add(new Cat(name_animal, date_of_birth, commands));
                        break;
                    case 2:
                        dog.add(new Dog(name_animal, date_of_birth, commands));
                        break;
                    case 3:
                        hamster.add(new Hamster(name_animal, date_of_birth, commands));
                        break;
                    default:
                        break;
                }
            } else {
                System.out.print("Введите номер вида животного (1. horse, 2. camel, 3. donkey): ");
                int y = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите команды которыми владеет животное: ");
                commands = scanner.nextLine();
                switch (y) {
                    case 1:
                        horse.add(new Horse(name_animal, date_of_birth, commands));
                        break;
                    case 2:
                        camel.add(new Camel(name_animal, date_of_birth, commands));
                        break;
                    case 3:
                        donkey.add(new Donkey(name_animal, date_of_birth, commands));
                        break;
                    default:
                        break;
                }
            }
            if ((Objects.equals(name_animal, "")) || (Objects.equals(date_of_birth, new Date(0))) || (i > 2)) {
                throw new NoFullData("Недостаточно данных о животном!", null);
            } else {
                count.add();
            }
        } catch (NoFullData e) {
        }
        // finally {
        //     if(scanner!=null)
        //         scanner.close();
        // }
    }

    public static void trainingСommands() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер группы животного (1. Pets, 2. Pack): ");
        int i;
        i = Integer.parseInt(scanner.nextLine());
        switch (i) {
            case 1: {
                System.out.print("Введите номер вида животного (1. cat, 2. dog, 3. humster): ");
                i = Integer.parseInt(scanner.nextLine());
                int n = 1;
                switch (i) {
                    case 1:
                        for (Cat cat : cat) {
                            System.out.println(n + ". " + cat);
                            n++;
                        }
                        System.out.print("Введите номер животного из списка: ");
                        n = Integer.parseInt(scanner.nextLine());
                        System.out.print("Введите новые команды животного: ");
                        cat.get(n - 1).setCommands(scanner.nextLine());
                        break;
                    case 2:
                        for (Dog dog : dog) {
                            System.out.println(n + ". " + dog);
                        }
                        System.out.print("Введите номер животного из списка: ");
                        n = Integer.parseInt(scanner.nextLine());
                        System.out.print("Введите новые команды животного: ");
                        dog.get(n - 1).setCommands(scanner.nextLine());
                        break;
                    case 3:
                        for (Hamster hamster : hamster) {
                            System.out.println(n + ". " + hamster);
                        }
                        System.out.print("Введите номер животного из списка: ");
                        n = Integer.parseInt(scanner.nextLine());
                        System.out.print("Введите новые команды животного: ");
                        hamster.get(n - 1).setCommands(scanner.nextLine());
                        break;
                    default:
                        break;
                }
                break;
            }
            case 2: {
                System.out.print("Введите номер вида животного (1. horse, 2. camel, 3. donkey): ");
                i = Integer.parseInt(scanner.nextLine());
                int n = 1;
                switch (i) {
                    case 1:
                        for (Horse horse : horse) {
                            System.out.println(n + ". " + horse);
                        }
                        System.out.print("Введите номер животного из списка: ");
                        n = Integer.parseInt(scanner.nextLine());
                        System.out.print("Введите новые команды животного: ");
                        horse.get(n - 1).setCommands(scanner.nextLine());
                        break;
                    case 2:
                        for (Camel camel : camel) {
                            System.out.println(n + ". " + camel);
                        }
                        System.out.print("Введите номер животного из списка: ");
                        n = Integer.parseInt(scanner.nextLine());
                        System.out.print("Введите новые команды животного: ");
                        camel.get(n - 1).setCommands(scanner.nextLine());
                        break;
                    case 3:
                        for (Donkey donkey : donkey) {
                            System.out.println(n + ". " + donkey);
                        }
                        System.out.print("Введите номер животного из списка: ");
                        n = Integer.parseInt(scanner.nextLine());
                        System.out.print("Введите новые команды животного: ");
                        donkey.get(n - 1).setCommands(scanner.nextLine());
                        break;
                    default:
                        break;
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            menu();
            int i = Integer.parseInt(scanner.nextLine());
            switch (i) {
                case 1:
                    showAnimals();
                    break;
                case 2:
                    addAnimal();
                    break;
                case 3:
                    trainingСommands();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Данный пункт отсутствует!");
            }
        }
    }
}
