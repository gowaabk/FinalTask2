//15. Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
//значение внутренней̆ int переменной̆ на 1 при нажатии “Завести новое
//животное” Сделайте так, чтобы с объектом такого типа можно было работать в
//блоке try-with-resources. Нужно бросить исключение, если работа с объектом
//типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
//считать в ресурсе try, если при заведении животного заполнены все поля.

package Task_13_15;

public class Counter {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void add() {
        this.count++;
    }
}