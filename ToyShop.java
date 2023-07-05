import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ToyShop {
    private List<Toy> toys;
    private ToyWriter toyWriter;
    private ToyResultService toyResultService;

    public ToyShop(ToyWriter toyWriter, ToyResultService toyResultService) {
        toys = new ArrayList<>();
        this.toyWriter = toyWriter;
        this.toyResultService = toyResultService;
    }

    public void addToy(int id, String name, int quantity, int weight) {
        Toy toy = new Toy(id, name, quantity, weight);
        toys.add(toy);
    }

    public void updateToyWeight(int toyId, int weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                return;
            }
        }
        System.out.println("Toy with ID " + toyId + " not found.");
    }

    public Toy getRandomToy() {
        int totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        Random random = new Random();
        int randomNumber = random.nextInt(totalWeight);

        int cumulativeWeight = 0;
        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randomNumber < cumulativeWeight) {
                if (toy.getQuantity() > 0) {
                    toy.setQuantity(toy.getQuantity() - 1);
                    return toy;
                } else {
                    System.out.println("No more quantity available for toy: " + toy.getName());
                    break;
                }
            }
        }

        return null;
    }

    public void saveToy(Toy toy) {
        toyWriter.saveToy(toy);
    }

    public void showResult(Toy toy) {
        toyResultService.showResult(toy);
    }
}