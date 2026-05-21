import java.util.*;

public class Main {


    public static void main(String[] args) {

        // 1.
        ArrayList<String> students = new ArrayList<>();
        students.add("Andrei");
        students.add("Maria");
        students.add("Ion");
        students.add("Elena");
        students.add("Mihai");

        System.out.println("All students: " + students);

        students.remove(2);
        System.out.println("After removing 3rd student: " + students);

        //2.
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(25);
        numbers.add(7);
        numbers.add(42);
        numbers.add(3);
        numbers.add(18);
        numbers.add(56);
        numbers.add(9);
        numbers.add(33);
        numbers.add(11);

        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        double average = (double) sum / numbers.size();

        System.out.println("Numbers: " + numbers);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Original: " + list);

        // 3
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }

        System.out.println("Reversed: " + list);

        //4
        String sentence = "Ana has apples and her friend has also apples.They love apples";

        String[] words = sentence.split(" ");

        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }

        System.out.println("Sentence: " + sentence);
        System.out.println("Unique words: " + uniqueWords);
        System.out.println("Count of unique words: " + uniqueWords.size());

        String input = "apple banana apple orange banana apple";

        //5
        String[] words2 = input.split(" ");

        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words2) {
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        System.out.println("Input: " + input);
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        //6
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Andrei Popescu", "0721123456");
        phoneBook.put("Maria Ionescu", "0740987654");
        phoneBook.put("Ion Georgescu", "0755111222");
        phoneBook.put("Elena Popa", "0762333444");


        String searchName = "Maria Ionescu";
        if (phoneBook.containsKey(searchName)) {
            System.out.println("Phone number for " + searchName + ": " + phoneBook.get(searchName));
        } else {
            System.out.println(searchName + " not found in phone book.");
        }


        System.out.println("\nAll contacts:");
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println("  " + entry.getKey() + " : " + entry.getValue());
        }

        //7
        List<Student> students2 = new ArrayList<>();
        students2.add(new Student("Andrei", 9));
        students2.add(new Student("Maria", 10));
        students2.add(new Student("Ion", 7));
        students2.add(new Student("Elena", 8));
        students2.add(new Student("Mihai", 6));

        System.out.println("\nAll students:");
        for (Student s2 : students2) {
            System.out.println("  " + s2);
        }


        Student topStudent = students2.get(0);
        for (Student s2 : students2) {
            if (s2.grade > topStudent.grade) {
                topStudent = s2;
            }
        }
        System.out.println("Student with highest grade: " + topStudent);


        students2.sort(Comparator.comparing(s -> s.name));
        System.out.println("\nSorted by name (alphabetically):");
        for (Student s : students2) {
            System.out.println("  " + s);
        }

        students2.sort((s1, s2) -> Integer.compare(s2.grade, s1.grade));
        System.out.println("Sorted by grade (descending):");
        for (Student s : students2) {
            System.out.println("  " + s);
        }

        //9


        List<Student> withDuplicates = new ArrayList<>();
        withDuplicates.add(new Student("Andrei", 9));
        withDuplicates.add(new Student("Maria", 10));
        withDuplicates.add(new Student("Andrei", 9));  // duplicate
        withDuplicates.add(new Student("Ion", 7));
        withDuplicates.add(new Student("Maria", 10));  // duplicate

        System.out.println("Before removing duplicates: " + withDuplicates);


        Set<Student> uniqueSet = new LinkedHashSet<>(withDuplicates);
        List<Student> noDuplicates = new ArrayList<>(uniqueSet);

        System.out.println("After removing duplicates: " + noDuplicates);
    }}
