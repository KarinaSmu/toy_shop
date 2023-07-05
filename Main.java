public class Main {
    public static void main(String[] args) {
        ToyWriter toyWriter = new ToyFileWriter();
        ToyResultService toyResultService = new ConsoleToyResultService();
        ToyShop toyShop = new ToyShop(toyWriter, toyResultService);

        // Добавление новых игрушек и изменение веса
        toyShop.addToy(1, "Teddy Bear", 5, 20);
        toyShop.addToy(2, "Doll", 10, 30);
        toyShop.addToy(3, "Car", 8, 50);

        toyShop.updateToyWeight(1, 10); // Изменение веса игрушки с ID 1 на 10
        toyShop.updateToyWeight(3, 70); // Изменение веса игрушки с ID 3 на 70

        // Розыгрыш игрушек
        Toy randomToy = toyShop.getRandomToy();
        if (randomToy != null) {
            toyShop.saveToy(randomToy);
            toyShop.showResult(randomToy);
        }
    }
}