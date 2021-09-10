package Exams.JavaAdvancedExamFebruary2020.guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    String name;
    int capacity;
    List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    //Features
    public void addPlayer(Player player) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        int index = -1;
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name)) {
                index = i;
            }
        }
        if (index != -1) {
            this.roster.remove(index);
            return true;
        }
        return false;
    }

    public void promotePlayer(String name) {
        int index = -1;
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).name.equals(name)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            this.roster.get(index).setRank("Member");
        }
    }

    public void demotePlayer(String name) {
        int index = -1;
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).name.equals(name)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            this.roster.get(index).setRank("Trial");
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> list = new ArrayList<>();
        for (Player player : this.roster) {
            if (player.getClazz().equals(clazz)) {
                list.add(player);
            }
        }
        for (Player player : list) {
            this.roster.remove(player);
        }

        return listToArr(list);
    }

    private Player[] listToArr(List<Player> list) {
        Player[] arr = new Player[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Players in the guild: %s:%n", this.name));
        for (int i = 0; i < this.roster.size(); i++) {
            output.append(this.roster.get(i).toString())
            .append(System.lineSeparator());
        }
        return output.toString();
    }
}
