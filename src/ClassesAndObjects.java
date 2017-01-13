/**
 * Created by alexandraqin on 4/14/15.
 */
public class ClassesAndObjects {

  public static void main (String args[]) {
    Cat garfield = new Cat("Garfield");
    Cat pinkPanther = new Cat("Pink Panther");
    Cat catWoman = new Cat("Catwoman");

    garfield.setFavoriteFood("Lasagna");
    garfield.setAge(12);

    pinkPanther.setFavoriteFood("Diamonds");
    pinkPanther.setAge(21);

    catWoman.setFavoriteFood("Batman");
    catWoman.setAge(33);

    adoption(new Person(), garfield);
    System.out.println(isFree(garfield));
  }

  private static boolean isOlder(Cat firstCat, Cat secondCat) {
    return firstCat.getAge() > secondCat.getAge();
  }

  private static void makeBestFriends(Cat one, Cat two){
    one.setFavoriteFood(two.getFavoriteFood());
  }

  private static Cat makeKitten(Cat one, Cat two){
    String newName = one.getName()+two.getName();
    Cat cat = new Cat();
    cat.setAge(0);
    cat.setName(newName);
    return cat;
  }

  private static void adoption(Person person, Cat catAdopted){
    if(catAdopted.getName().equals("Catwoman")){
      System.out.println("Catwoman will never be adopted");
      throw new IllegalStateException("Catwoman is immune to adoption");
    }
    catAdopted.setOwner(person);
  }

  private static boolean isFree(Cat cat){
    return cat.getOwner() == null;
  }

  private static boolean isSibling(Cat one, Cat two) {
    return one.getOwner() == two.getOwner();
  }
}
