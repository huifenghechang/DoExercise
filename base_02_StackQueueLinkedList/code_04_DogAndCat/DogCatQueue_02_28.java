package code_04_DogAndCat;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue_02_28 {
    public static class Pet{
        private String type;

        public Pet(String type){
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public static class Cat extends Pet{
        public Cat(){
            super("Cat");
        }
    }

    public static class Dog extends Pet{
        public Dog(){
            super("Dog");
        }
    }

    public static class PetObject{
        Pet pet;
        int count;

        public PetObject(Pet pet,int count){
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet(){
            return this.pet;
        }

        public int getCount() {
            return count;
        }

        public String getPetType(){
            return this.pet.type;
        }
    }
    public static class DogAndCatQueue{
        private Queue<PetObject> catQueue;
        private Queue<PetObject> dogQueue;
        private int count;

        public DogAndCatQueue(){
            this.catQueue = new LinkedList<>();
            this.dogQueue = new LinkedList<>();
            this.count = 0;
        }

        public void add(Pet pet){
            if (pet.getType().equals("Cat")){
                this.catQueue.offer(new PetObject(pet,this.count++));
            }else if (pet.getType().equals("Dog")){
                this.dogQueue.offer(new PetObject(pet,this.count++));
            }else {
                throw new RuntimeException("The type is incorrect!");
            }
        }

        public void pollAll(){
            while (!dogQueue.isEmpty()&&!catQueue.isEmpty()){
                if (dogQueue.peek().getCount() > catQueue.peek().getCount()){
                    dogQueue.poll();
                }else {
                    catQueue.poll();
                }
            }

            while (!dogQueue.isEmpty()){
                dogQueue.poll();
            }

            while (!catQueue.isEmpty()){
                catQueue.poll();
            }
        }

        public Pet pollCat(){
            if (!catQueue.isEmpty()){
                return catQueue.poll().getPet();
            }else {
                throw  new RuntimeException("The catQueue is Empty");
            }
        }

        public Pet pollDog(){
            if (!dogQueue.isEmpty()){
                return dogQueue.poll().getPet();
            }else {
                throw new RuntimeException("The dogQueue is Empty");
            }
        }


    }


}
