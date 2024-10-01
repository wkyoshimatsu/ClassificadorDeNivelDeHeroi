package me.wky;

import me.wky.model.Hero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String gameMessage = """
            Ei...
            Você aí?
            Sim
            Você mesmo!
            Qual é o seu nome?""";
        System.out.println(gameMessage);

        Scanner scanner = new Scanner(System.in);
        String heroName =  scanner.next();
        Hero hero = new Hero(heroName);

        System.out.println(hero.heroToString());

        gameMessage = """
            Olá %s!
            Vamos iniciar a sua heróica jornada.""".formatted(hero.getName());
        System.out.println(gameMessage);

        while (true){
            int numberOfBattles;
            do {
                System.out.println("Quantas batalhas vai lutar?");
                numberOfBattles = scanner.nextInt();
            } while (numberOfBattles < 1);

            System.out.println("Iniciar as batalhas!");

            int battlesWinned = 0;
            for (int i = 0; i < numberOfBattles; i++) {
                if (Math.random() >= 0.5f){
                    hero.winBattle();
                    battlesWinned++;
                }
            }

            gameMessage = """
            Parabéns %s!
            Você venceu %d das suas %d batalhas!
            Você adquiriu %d XPs.
            """.formatted(hero.getName(), battlesWinned, numberOfBattles, battlesWinned * 100);
            System.out.println(gameMessage);

            System.out.println(hero.heroToString());

            char escolha;
            do {
                System.out.println("Quer continuar a sua jornada? S/N");
                escolha = scanner.next().toLowerCase().charAt(0);
            } while (escolha != 's' && escolha != 'n');

            if (escolha == 'n'){
                System.out.printf("Até a próxima jornada %s.\n",hero.getName());
                break;
            }
        }
    }
}