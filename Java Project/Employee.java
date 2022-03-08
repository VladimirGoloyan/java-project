
abstract class Employee {
    // Fixed after HW1 feedback
    private String name;
    private String surname;
    private int ssn;
    private int performanceScore;

    abstract void doWork();

    // Complexity O(1)
    public void takeVacation() {
        System.out.println(this.name + ' ' + this.surname + " is going on a vacation.");
    }

    // Complexity O(1)
    public Employee(String name, String surname, int ssn) {
        this.name = name;
        this.surname = surname;
        this.ssn = ssn;
    }

    public Employee(String name, String surname, int ssn, int score) {
        this.name = name;
        this.surname = surname;
        this.ssn = ssn;
        this.performanceScore = score;
    }

    // Complexity O(1)
    public String getName() {
        return this.name;
    }

    // Complexity O(1)
    public String getSurname() {
        return this.surname;
    }

    // Complexity O(1)
    public String getFullName() {
        return this.name + ' ' + this.surname;
    }

    // Complexity O(1)
    public int getSSN() {
        return this.ssn;
    }

    public int getPerformanceScore() {
        return this.performanceScore;
    }

    // Complexity O(1)
    public void setName(String n) {
        this.name = n;
    }

    // Complexity O(1)
    public void setSurname(String s) {
        this.surname = s;
    }

    public void setPerformanceScore(int s) {
        this.performanceScore = s;
    }
    // no setter for ssn as I think it cannot be changed

    public String toString(){
        return this.name + " " + this.surname + " ";
    }
}
