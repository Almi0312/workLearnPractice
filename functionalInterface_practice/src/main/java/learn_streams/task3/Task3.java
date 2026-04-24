package learn_streams.task3;

public class Task3 {

    public static void main(String[] args) {
        Lazy<String> heavyResource = new Lazy<>(() -> {
            System.out.println("Вычисляем тяжёлый ресурс...");
            return "Данные после долгой загрузки";
        });
        System.out.print("выполняется 1 вариант ");
        System.out.println(heavyResource.get());
        System.out.print("выполняется 2 вариант ");
        System.out.println(heavyResource.get());
        System.out.print("выполняется 3 вариант ");
        System.out.println(heavyResource.get());
        System.out.print("выполняется 4 вариант ");
        System.out.println(heavyResource.get());
    }
}
