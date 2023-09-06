package queue;

public class AnimalShelter  {

    public AnimalShelter(){

    }

    private Queue catQueue =new Queue<>();

    private Queue dogQueue =new Queue<>();
    public Queue getCatQueue() {
        return catQueue;
    }

    public Queue getDogQueue() {
        return dogQueue;
    }



    public void enqueue( Animal animal) {
        if(animal.species =="cat"){
            this.catQueue.enqueue(animal);
        }else if(animal.species =="dog"){
            this.dogQueue.enqueue(animal); }


    }

    public Animal dequeue(String pref ){
        if (pref == "cat" && !catQueue.isEmpty())
            return (Animal) catQueue.dequeue();
        else if (pref == "dog" && !dogQueue.isEmpty())
            return (Animal) dogQueue.dequeue();
            return null;
    }


}
