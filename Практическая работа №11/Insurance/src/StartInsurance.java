public class StartInsurance {
    public static void main(String[] args) {
        HashTable<Insurance> ht = new HashTable<>(10);
        ht.add(new Insurance(123,"yandex","ivanov"));
        ht.add(new Insurance(1005,"google","nikolaev"));
        ht.add(new Insurance(5,"amazon","axenov"));

        System.out.println("Вывод до рехеширования");
        ht.print();
        ht.add(new Insurance(2005,"netflix","ivanov"));
        ht.add(new Insurance(3005,"tesla","nikolaev"));

        System.out.println("Вывод после рехеширования");
        ht.print();
        System.out.println("\n");

        ht.search(1005);
        System.out.println("\n");

        ht.delete(1005);
        System.out.println("\n");

        System.out.println("Вывод после удаления элемента");
        ht.print();
    }
}
