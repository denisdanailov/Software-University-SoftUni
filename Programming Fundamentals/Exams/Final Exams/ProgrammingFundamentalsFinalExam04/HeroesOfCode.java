package Exams.FinalExams.ProgrammingFundamentalsFinalExam04;

import java.util.*;

public class HeroesOfCode {

    public static class Hero {
        String heroName;
        int hp;
        int mp;

        public Hero(String name, int healthPoints, int manaPoints) {
            this.heroName = name;
            this.hp = healthPoints;
            this.mp = manaPoints;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Запазване на героите в мап
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Hero> heroMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            int hp = Integer.parseInt(tokens[1]);
            int mp = Integer.parseInt(tokens[2]);
            Hero newHero = new Hero(name, hp, mp);
            heroMap.put(name, newHero);
        }
        //Започване на играта
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" - ");
            String action = tokens[0];
            String heroName = tokens[1];
            switch (action) {
                case "CastSpell":
                    int mp = Integer.parseInt(tokens[2]);
                    String spell = tokens[3];
                    if (heroMap.get(heroName).mp >= mp) {
                        heroMap.get(heroName).mp -= mp;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spell, heroMap.get(heroName).mp);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spell);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attackerName = tokens[3];
                    if (heroMap.get(heroName).hp - damage > 0) {
                        heroMap.get(heroName).hp -= damage;
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attackerName, heroMap.get(heroName).hp);
                    } else {
                        heroMap.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attackerName);
                    }
                    break;
                case "Recharge":
                    int manaPoints = Integer.parseInt(tokens[2]);
                    if (heroMap.get(heroName).mp + manaPoints <= 200) {
                        heroMap.get(heroName).mp += manaPoints;
                        System.out.printf("%s recharged for %d MP!%n", heroName, manaPoints);
                    } else {
                        System.out.printf("%s recharged for %d MP!%n", heroName, 200 - heroMap.get(heroName).mp);
                        heroMap.get(heroName).mp = 200;
                    }
                    break;
                case "Heal":
                    int hp = Integer.parseInt(tokens[2]);
                    if (heroMap.get(heroName).hp + hp <= 100) {
                        heroMap.get(heroName).hp += hp;
                        System.out.printf("%s healed for %d HP!%n", heroName, hp);
                    } else {
                        System.out.printf("%s healed for %d HP!%n", heroName, 100 - heroMap.get(heroName).hp);
                        heroMap.get(heroName).hp = 100;
                    }
                    break;
            }
            input = scan.nextLine();
        }
        //Сортировка по hp и по име и принтиране
        heroMap.entrySet().stream()
                .sorted((a, b) -> {
                    int hpSort = Integer.compare(b.getValue().hp, a.getValue().hp);
                    if (hpSort == 0) {
                        return a.getKey().compareTo(b.getKey());
                    } else {
                        return hpSort;
                    }
                })
                .forEach(entrySet -> {
                    System.out.println(entrySet.getKey());
                    System.out.printf("HP: %d%n", entrySet.getValue().hp);
                    System.out.printf("MP: %d%n", entrySet.getValue().mp);
                });
    }
}
