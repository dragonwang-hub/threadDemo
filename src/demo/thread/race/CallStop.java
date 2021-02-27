package demo.thread.race;

public class CallStop {

    Animal animal;

    public CallStop(Animal animal) {
        this.animal = animal;
    }

    public void win() {
        animal.interrupt();
    }

}
