package me.wky.model;

public class Hero {
    private String name;
    private int xp;
    private String level;

    private void updateLevel(){
        if (this.xp < 1000){
            this.level = "Ferro";
        } else if (this.xp < 2000){
            this.level = "Bronze";
        } else if (this.xp < 5000) {
            this.level = "Prata";
        } else if (this.xp < 7000) {
            this.level = "Ouro";
        } else if (this.xp < 8000) {
            this.level = "Ouro";
        } else if (this.xp < 9000) {
            this.level = "Ascendente";
        } else if (this.xp < 10000) {
            this.level = "Imortal";
        } else {
            this.level = "Radiante";
        }
    }

    public Hero(String name) {
        this.name = name;
        this.xp = 0;
        updateLevel();
    }

    public void winBattle(){
        this.xp += 100;
        updateLevel();
    }

    public String getName() {
        return name;
    }

    public String heroToString(){
        return "O Herói de nome " + this.name + " está no nível de " + this.level + " pois tem " + this.xp + " pontos de XP.";
    }
}
