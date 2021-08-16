package AssociativeArrays.Exercise;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String symbol = "";
        String userName = "";
        String force = "";

        Map<String, List<String>> mapList = new LinkedHashMap<>();
        List<String> forceList = new ArrayList<>();
        while (!input.equals("Lumpawaroo")) {
            String[] tokens = input.split(" ");
            symbol = findSymbol(tokens);
            switch (symbol) {
                case "|":
                    userName = findUsername(tokens, symbol);
                    force = findForce(tokens, symbol);
                    mapList = myMapList(mapList, userName, force, symbol, forceList);
                    if (!forceList.contains(force)) {
                        forceList.add(force);
                    }
                    break;
                case "->":
                    userName = findUsername(tokens, symbol);
                    force = findForce(tokens, symbol);
                    mapList = myMapList(mapList, userName, force, symbol, forceList);
                    if (!forceList.contains(force)) {
                        forceList.add(force);
                    }
                    break;
            }
            input = scan.nextLine();
        }

        mapList.entrySet().stream().filter(entry -> entry.getValue().size() > 0)
                .sorted((a,b) -> {
                    int sortedResult = Integer.compare(b.getValue().size(),a.getValue().size());
                            if (sortedResult == 0) {
                                sortedResult = a.getKey().compareTo(b.getKey());
                            }
        return sortedResult;
                })
                .forEach(entry -> {
                    System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                    entry.getValue().stream().sorted().forEach(user -> System.out.println("! " + user));
                });
    }

    public static String findSymbol(String[] tokens) {
        String symbol = "";
        if (tokens[1].equals("|") || tokens[1].equals("->")) {
            symbol = tokens[1];
        } else {
            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i].equals("|") || tokens[i].equals("->")) {
                    symbol = tokens[i];
                    break;
                }
            }
        }
        return symbol;
    }

    public static String findUsername(String[] tokens, String symbol) {
        String userName = "";
        if (symbol.equals("->")) {
            userName = tokens[0];
            for (int i = 1; i < tokens.length; i++) {
                if (!tokens[i].equals(symbol)) {
                    userName += " " + tokens[i];
                } else {
                    break;
                }
            }
            return userName;
        } else {
            int index = 0;
            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i].equals(symbol)) {
                    index = i;
                    break;
                }
            }
            userName = tokens[index + 1];

            if (index + 1 < tokens.length - 1) {
                for (int i = index + 2; i < tokens.length; i++) {
                    userName += " " + tokens[i];
                }
            }
            return userName;
        }
    }

    public static String findForce(String[] tokens, String symbol) {
        String force = "";
        if (symbol.equals("->")) {
            int index = 0;
            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i].equals(symbol)) {
                    index = i;
                    break;
                }
            }
            force = tokens[index + 1];
            if (index + 1 < tokens.length - 1) {
                for (int i = index + 2; i < tokens.length; i++) {
                    force += " " + tokens[i];
                }
            }
            return force;
        } else {
            force = tokens[0];
            for (int i = 1; i < tokens.length; i++) {
                if (!tokens[i].equals(symbol)) {
                    force += " " + tokens[i];
                } else {
                    break;
                }
            }
            return force;
        }
    }

    public static boolean mapListContainsUsername(Map<String,List<String>> mapList, List<String> forceList, String userName) {
        boolean containsUserName = false;
        if (forceList.size() > 0) {
            for (int i = 0; i < forceList.size(); i++) {
                String currentForce = forceList.get(i);
                if (mapList.size() > 0) {
                    if (mapList.get(currentForce).contains(userName)) {
                        containsUserName = true;
                        break;
                    }
                }
            }
        }
        return  containsUserName;
    }

    public static String findKey(Map<String,List<String>> mapList,List<String> forceList, String userName) {
        String force = "";
        if (forceList.size() > 0) {
            for (int i = 0; i < forceList.size(); i++) {
                String currForce = forceList.get(i);
                if (mapList.get(currForce).contains(userName)) {
                    force = currForce;
                    break;
                }
            }
        }
        return force;
    }

    public static Map<String,List<String>> myMapList(Map<String,List<String>> mapList, String userName, String force, String symbol, List<String> forceList) {
        if (!mapListContainsUsername(mapList, forceList,userName)) {
            if (mapList.containsKey(force)) {
                if (!mapList.get(force).contains(userName)) {
                    mapList.get(force).add(userName);
                    if (symbol.equals("->")) {
                        System.out.printf("%s joins the %s side!%n", userName, force);
                    }
                }
            } else {
                List<String> usernameList = new ArrayList<>();
                usernameList.add(userName);
                mapList.put(force, usernameList);
                if (symbol.equals("->")) {
                    System.out.printf("%s joins the %s side!%n", userName, force);
                }
            }
        } else {
            mapList.get(findKey(mapList,forceList,userName)).remove(userName);
            if (mapList.containsKey(force)) {
                if (!mapList.get(force).contains(userName)) {
                    mapList.get(force).add(userName);
                    if (symbol.equals("->")) {
                        System.out.printf("%s joins the %s side!%n", userName, force);
                    }
                }
            } else {
                List<String> usernameList = new ArrayList<>();
                usernameList.add(userName);
                mapList.put(force, usernameList);
                if (symbol.equals("->")) {
                    System.out.printf("%s joins the %s side!%n", userName, force);
                }
            }
        }
        return mapList;
    }
}
