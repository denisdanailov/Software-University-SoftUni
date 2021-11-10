package interfacesAndAbstraction.exercises.militaryElite;

import interfacesAndAbstraction.exercises.militaryElite.additionalClasses.Mission;
import interfacesAndAbstraction.exercises.militaryElite.additionalClasses.Repair;
import interfacesAndAbstraction.exercises.militaryElite.interfaces.*;
import interfacesAndAbstraction.exercises.militaryElite.soldierClasses.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<Integer, Private> privateMap = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            switch (type) {
                case "Private":
                    int id = Integer.parseInt(tokens[1]);
                    String firstName = tokens[2];
                    String lastName = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Private prv = new PrivateImpl(id,firstName, lastName,salary);
                    privateMap.put(id, prv);
                    System.out.println(prv);
                    break;
                case "LieutenantGeneral":
                    id = Integer.parseInt(tokens[1]);
                    firstName = tokens[2];
                    lastName = tokens[3];
                    salary = Double.parseDouble(tokens[4]);

                    LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);

                    if (tokens.length > 5) {
                        for (int i = 5; i < tokens.length; i++) {
                            int prvId = Integer.parseInt(tokens[i]);
                            Private aPrivate = privateMap.get(prvId);
                            lieutenantGeneral.addPrivate(aPrivate);
                        }
                    }

                    System.out.println(lieutenantGeneral);
                    break;
                case "Engineer":
                    id = Integer.parseInt(tokens[1]);
                    firstName = tokens[2];
                    lastName = tokens[3];
                    salary = Double.parseDouble(tokens[4]);
                    String corps = tokens[5];

                    if (corps.equals("Airforces") || corps.equals("Marines")) {
                        Engineer engineer = new EngineerImpl(id, firstName, lastName, salary, corps);

                        if (tokens.length > 6) {
                            for (int i = 6; i < tokens.length; i += 2) {
                                String partName = tokens[i];
                                int hoursWorked = Integer.parseInt(tokens[i + 1]);
                                Repair repair = new Repair(partName, hoursWorked);
                                engineer.addRepair(repair);
                            }
                        }

                        System.out.println(engineer);
                    }
                    break;
                case "Commando":
                    id = Integer.parseInt(tokens[1]);
                    firstName = tokens[2];
                    lastName = tokens[3];
                    salary = Double.parseDouble(tokens[4]);
                    corps = tokens[5];

                    if (corps.equals("Airforces") || corps.equals("Marines")) {
                        Commando commando = new CommandoImpl(id, firstName, lastName, salary, corps);

                        if (tokens.length > 6) {
                            for (int i = 6; i < tokens.length; i += 2) {
                                String codeName = tokens[i];
                                String state = tokens[i + 1];
                                if (state.equals("inProgress") || state.equals("finished")) {
                                    Mission mission = new Mission(codeName, state);
                                    commando.addMission(mission);
                                }
                            }
                        }

                        System.out.println(commando);
                    }
                    break;
                case "Spy":
                    id = Integer.parseInt(tokens[1]);
                    firstName = tokens[2];
                    lastName = tokens[3];
                    String codeNumber = tokens[4];

                    Spy spy = new SpyImpl(id, firstName, lastName, codeNumber);

                    System.out.println(spy);
                    break;
            }

            input = scan.nextLine();
        }
    }
}
