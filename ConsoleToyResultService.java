class ConsoleToyResultService implements ToyResultService {
    public void showResult(Toy toy) {
        System.out.println("The toy \"" + toy.getName() + "\" was selected as the prize!");
    }
}
