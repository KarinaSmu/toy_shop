import java.io.FileWriter;
import java.io.IOException;

class ToyFileWriter implements ToyWriter {
    public void saveToy(Toy toy) {
        try {
            FileWriter writer = new FileWriter("toys.txt", true);
            writer.write(toy.getId() + "," + toy.getName() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

