package bolaleka.swingy.model.characters;


public class Character {
   
    String name;
    Hero hero;

   public Character(String name) {
       this.name = name;
       this.hero = new Hero();
   }

   public Character(){

   }

   public void  setName(String name) {
       this.name = name;
   }
   public String getName() {
       return name;
   }

   public Hero getHero() {
       return hero;
   }

   public void setHeroHP(int hp) {
       this.hero.HP = hp;
   }



}
