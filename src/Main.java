public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.append(String.valueOf(i));
        }

        list.remove(String.valueOf(99));

        list.insert(String.valueOf(40), 56);

        list.prepend(String.valueOf(40));

        String value = list.get(9);

        if (list.contains(value)) {
            list.remove(value);
        }

        list.insert(value, 44);

        //System.out.println(list);

        if (list.isLooped()) {
            System.out.println("Looped!");
        } else {
            System.out.println(list);
        }
    }
}