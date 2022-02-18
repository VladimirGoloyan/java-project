package CompanyRoles;
public class SWEngineer extends Employee{
    
    public String title;

    //Complexity O(1) as constructor of parent is also O(1)
    public SWEngineer(String name, String surname, int ssn, String title) {
        super(name, surname, ssn);
        this.title = title;
    }

    //Complexity O(1)
    public String getTitle(){
        return this.title;
    }

    //Complexity O(1)
    public void setTitle(String s){
        this.title = s;
    }

    //Complexity O(1)
    private void doCoding(){
        System.out.println("Doing coding");
    }

    //Complexity O(1) as doCoding is O(1)
    @Override
    void doWork() {
        doCoding();       
    }
    
      
}
