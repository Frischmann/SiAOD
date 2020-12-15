public class Insurance {
    int number;
    String company;
    String surname;

    public Insurance(int number, String company, String surname) {
        this.number = number;
        this.company = company;
        this.surname = surname;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Insurance {" +
                "number=" + number +
                ", company='" + company + '\'' +
                ", surname='" + surname + '\'' +
                '}'+"\n";
    }
}
