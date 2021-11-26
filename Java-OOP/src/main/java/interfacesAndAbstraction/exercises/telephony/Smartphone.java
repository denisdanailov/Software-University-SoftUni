package interfacesAndAbstraction.exercises.telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder strBuild = new StringBuilder();
        if (checkEmptyString(urls)) {
            for (int i = 0; i < urls.size(); i++) {
                if (isUrlValid(urls.get(i))) {
                    strBuild.append("Browsing: " + urls.get(i) + "!")
                            .append(System.lineSeparator());
                } else {
                    strBuild.append("Invalid URL!")
                            .append(System.lineSeparator());
                }
            }
        }
        return strBuild.toString().trim();
    }

    private boolean isUrlValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String call() {
        StringBuilder strBuild = new StringBuilder();
        if (checkEmptyString(urls)) {
            for (int i = 0; i < numbers.size(); i++) {
                if (isNumberValid(numbers.get(i))) {
                    strBuild.append("Calling... " + numbers.get(i))
                            .append(System.lineSeparator());
                } else {
                    strBuild.append("Invalid number!")
                            .append(System.lineSeparator());
                }
            }
        }
        return strBuild.toString().trim();
    }

    private boolean isNumberValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkEmptyString(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("")) {
                return false;
            }
        }
        return true;
    }
}
