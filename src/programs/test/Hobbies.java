package programs.test;

import java.util.*;

public class Hobbies {

    private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();

    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
    }

    public List<String> findHobbyists(String hobby) {
        List<String> mList = new ArrayList<>();
            for (Map.Entry<String, String[]> entry : hobbies.entrySet()) {
                String[] values = entry.getValue();
                for (int i = 0; i < values.length; i++) {
                    if (values[i].equals(hobby)) {
                        mList.add(entry.getKey());
                    }
                }
        }
        return mList;
    }

    public static void main(String[] args) {
        Hobbies hobbies = new Hobbies();
        hobbies.add("John", "Piano", "Puzzles", "Yoga");
        hobbies.add("Adam", "Drama", "Fashion", "Pets");
        hobbies.add("Mary", "Magic", "Pets", "Reading");

        System.out.println(Arrays.toString(hobbies.findHobbyists("Yoga").toArray()));
    }
}