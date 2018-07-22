import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Map<Integer, List<String>> dictionary = main.assignment(main.getWordFromFile());
        Scanner scanner = new Scanner(System.in);
        main.mainMenu(main, dictionary, scanner);


    }

    private void createWords(Main main, Map<Integer, List<String>> dictionary, Scanner scanner) {
        System.out.println("Wprowadź litery do złożenia słowa np. jdasjdbasdl");
        String word = scanner.nextLine();
        Map<String, Integer> wordFromUser = main.fillingTheMapOurWord(main, word);
        for (int i = 2; i <= word.length(); i++) {
            for (String s : dictionary.get(i)) {
                Map<String, Integer> wordFromDictionary = main.fillingTheMapOurWord(main, s);
                boolean flag = true;
                for (Map.Entry<String, Integer> stringIntegerEntry : wordFromDictionary.entrySet()) {
                    int x = wordFromUser.get(stringIntegerEntry.getKey());
                    int y = stringIntegerEntry.getValue();
                    if (y > x) {
                        flag = false;
                    }
                }
                if (flag) {
                    System.out.println(s);
                }
            }
        }
    }

    private Map<String, Integer> fillingTheMapOurWord(Main main, String word) {
        Map<String, Integer> mapWithOurWord = main.fillingTheMap();

        char[] wordInArray = main.wordToArray(word);
        for (char c : wordInArray) {
            mapWithOurWord.put(String.valueOf(c), mapWithOurWord.get(String.valueOf(c)) + 1);
        }
        return mapWithOurWord;
    }

    private char[] wordToArray(String word) {
        word = word.trim().toLowerCase();
        return word.toCharArray();
    }

    private Map<String, Integer> fillingTheMap() {
        Map<String, Integer> word = new HashMap<>();
        for (int i = 97; i < 123; i++) {
            word.put(String.valueOf((char) i), 0);
        }
        word.put("ą", 0);
        word.put("ć", 0);
        word.put("ę", 0);
        word.put("ł", 0);
        word.put("ń", 0);
        word.put("ś", 0);
        word.put("ó", 0);
        word.put("ż", 0);
        word.put("ź", 0);
        return word;
    }

    private void mainMenu(Main main, Map<Integer, List<String>> dictionary, Scanner scanner) {
        Flag:
        while (true) {
            System.out.println("Gotowy do działania wybierz opscje która Cię interesuje wpisując cyfre");
            System.out.println("1. Sprawdź czy słowo istnieje");
            System.out.println("2. Utwórz słowo z podanych liter");
            System.out.println("9. Exit");
            int choiceMenu = 0;
            while (true) {
                choiceMenu = Integer.parseInt(scanner.nextLine());
                if (Pattern.matches("[129]",String.valueOf(choiceMenu))) {
                    break;
                }
                System.out.println("Złe dane");
            }

            switch (choiceMenu) {
                case 1:
                    main.isWordExist(dictionary, scanner);
                    break;
                case 2:
                    main.createWords(main, dictionary, scanner);
                    System.out.println("------------------------------------------------------------------");
                    break;
                default:
                    System.out.println("Do zobaczenia");
                    break Flag;
            }
        }

    }

    private void isWordExist(Map<Integer, List<String>> dictionary, Scanner scanner) {
        System.out.println("Wprowadź słowo");
        String word = scanner.nextLine();
        while (word.length() > 14) {
            System.out.println("Za długie słowo wprowadź krótsze");
            word = scanner.nextLine();
        }
        word = word.trim().toLowerCase();
        List<String> nNumberWord = dictionary.get(word.length());
        if (nNumberWord.contains(word)) {
            System.out.println("Znalazłem twoje słowo które/którym jest : " + word);
        } else {
            System.out.println("Takie słowo nie istnieje jak : " + word);
        }
        System.out.println("------------------------------------------------------------------");
    }

    private List<String> getWordFromFile() {
        File file = new File("D:\\Główny folder MojaJava\\Moje programy\\Word_Generator\\src\\slowa.txt");

        List<String> wordList = null;
        try {
            wordList = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }

    private Map<Integer, List<String>> assignment(List<String> word) {
        Map<Integer, List<String>> dictionary = new HashMap<>();
        List<String> wordLengthOf1 = new ArrayList<>();
        List<String> wordLengthOf2 = new ArrayList<>();
        List<String> wordLengthOf3 = new ArrayList<>();
        List<String> wordLengthOf4 = new ArrayList<>();
        List<String> wordLengthOf5 = new ArrayList<>();
        List<String> wordLengthOf6 = new ArrayList<>();
        List<String> wordLengthOf7 = new ArrayList<>();
        List<String> wordLengthOf8 = new ArrayList<>();
        List<String> wordLengthOf9 = new ArrayList<>();
        List<String> wordLengthOf10 = new ArrayList<>();
        List<String> wordLengthOf11 = new ArrayList<>();
        List<String> wordLengthOf12 = new ArrayList<>();
        List<String> wordLengthOf13 = new ArrayList<>();
        int lengthWord;
        for (String s : word) {
            lengthWord = s.length();
            switch (lengthWord) {
                case 1:
                    wordLengthOf1.add(s);
                    break;
                case 2:
                    wordLengthOf2.add(s);
                    break;
                case 3:
                    wordLengthOf3.add(s);
                    break;
                case 4:
                    wordLengthOf4.add(s);
                    break;
                case 5:
                    wordLengthOf5.add(s);
                    break;
                case 6:
                    wordLengthOf6.add(s);
                    break;
                case 7:
                    wordLengthOf7.add(s);
                    break;
                case 8:
                    wordLengthOf8.add(s);
                    break;
                case 9:
                    wordLengthOf9.add(s);
                    break;
                case 10:
                    wordLengthOf10.add(s);
                    break;
                case 11:
                    wordLengthOf11.add(s);
                    break;
                case 12:
                    wordLengthOf12.add(s);
                    break;
                default:
                    wordLengthOf13.add(s);
            }
        }
        dictionary.put(1, wordLengthOf1);
        dictionary.put(2, wordLengthOf2);
        dictionary.put(3, wordLengthOf3);
        dictionary.put(4, wordLengthOf4);
        dictionary.put(5, wordLengthOf5);
        dictionary.put(6, wordLengthOf6);
        dictionary.put(7, wordLengthOf7);
        dictionary.put(8, wordLengthOf8);
        dictionary.put(9, wordLengthOf9);
        dictionary.put(10, wordLengthOf10);
        dictionary.put(11, wordLengthOf11);
        dictionary.put(12, wordLengthOf12);
        dictionary.put(13, wordLengthOf13);
        return dictionary;
    }
}
