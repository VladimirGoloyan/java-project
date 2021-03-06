public class SWManager extends SWEngineer implements Manager {
    //Fixed after HW1 feedback
    private Employee[] directReports;
    private int teamCap = 10;
    private int addIndex = 0;

    //Complexity O(1) as constructor of parent is also O(1)
    public SWManager(String name, String surname, int ssn, String title) {
        super(name, surname, ssn, title);
        directReports = new Employee[teamCap];
    }

    //Complexity O(1)
    public void mentorEmployee(Employee e){
        System.out.println("Mentoring " + e.getFullName());
    }

    //Complexity O(1)
    public void distributeTasks(){
        System.out.println("Distributing tasks to direct reports.");
    }

    //Complexity O(n) where n is equal to teamCap
    public void enlargeTeam(int i) {
        if (i < teamCap) {
            System.out.println("Number must be bigger than previous capacity");
        } 
        else if (directReports[0] == null) {
            directReports = new Employee[i];
        }
        
        Employee[] temp = new Employee[i];
        
        for (int j = 0; j < teamCap; j++) {
            temp[i] = directReports[i];
        }

        teamCap = i;
        directReports = temp;
    }

    //Complexity O(n) as enlargeTeam is O(n)    
    public void addDirectReport(Employee e){
        if(addIndex == teamCap){
            enlargeTeam(teamCap * 2);
        }

        directReports[addIndex] = e;
        addIndex++;
    }
    
    //Complexity O(1)
    private void doSWManagerWork(){
        System.out.println("Doing some SWManager work");
    }

     //Complexity O(1) as doSWManagerWork is O(1)
    void doWork() {
        doSWManagerWork();       
    }

    //Complexity O(1)
    @Override
    public void evaluateEmployee(Employee e) {
        System.out.println("Evaluating Employee : " + e.getFullName());
    }

    //Complexity O(1)
    @Override
    public void reviewSalary(Employee e) {
        System.out.println("Reviewing salary of Employee : " + e.getFullName());
    }

    //Complexity O(1)
    @Override
    public Employee[] getDirectReports() {
        return directReports;
    }

}
