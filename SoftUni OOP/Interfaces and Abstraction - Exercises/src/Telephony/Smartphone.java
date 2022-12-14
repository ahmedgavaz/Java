package Telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();
        urls.stream().forEach(e -> {
            boolean bol = true;
            for (int i = 0; i < e.length(); i++) {
                if (Character.isDigit(e.charAt(i))) {
                    bol = false;
                    break;
                }
            }
            if (bol) {
                stringBuilder.append("Browsing: ").append(e).append("!").append(System.lineSeparator());
            } else {
                stringBuilder.append("Invalid URL!").append(System.lineSeparator());
            }
        });
        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        return String.valueOf(stringBuilder);
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        numbers.stream().forEach(e -> {
            boolean bol = true;
            for (int i = 0; i < e.length(); i++) {
                if (!Character.isDigit(e.charAt(i))) {
                    bol = false;
                    break;
                }
            }
            if (bol) {
                stringBuilder.append("Calling... ").append(e).append(System.lineSeparator());
            } else {
                stringBuilder.append("Invalid number!").append(System.lineSeparator());
            }
        });
        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        return String.valueOf(stringBuilder);
    }
}
