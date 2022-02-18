import CompanyRoles.Accountant;
import CompanyRoles.Company;
import CompanyRoles.Executive;
import CompanyRoles.FinanceManager;
import CompanyRoles.SWEngineer;
import CompanyRoles.SWManager;

public class main {
    public static void main(String[] args) {

        System.out.println("Main started.");

        Executive ceo = new Executive("Abigail", "James", 1);

        SWManager sen1 = new SWManager("John", "Green", 2, "Senior software engineer");
        SWManager sen2 = new SWManager("John", "Brown", 3, "Senior software engineer");

        SWEngineer jun1 = new SWEngineer("Hilary", "Something", 4, "Junior software engineer");
        SWEngineer jun2 = new SWEngineer("Debbie", "Anniston", 5, "Junior software engineer");
        SWEngineer jun3 = new SWEngineer("Adam", "Levine", 6, "Junior software engineer");
        SWEngineer jun4 = new SWEngineer("Leo", "Bonucci", 7, "Junior software engineer");

        SWEngineer mid1 = new SWEngineer("Ricardo", "Miller", 8, "Middle software engineer");
        SWEngineer mid2 = new SWEngineer("Tessa", "Davidson", 9, "Middle software engineer");

        FinanceManager fin = new FinanceManager("Rob", "Robson", 0004);

        Accountant acc1 = new Accountant("Evan", "Valet", 10);
        Accountant acc2 = new Accountant("Georgio", "Tuz", 11);

        Company comp = new Company("AUA", 20, ceo);

        comp.hireEmployee(sen1, ceo);
        comp.hireEmployee(sen2, ceo);

        comp.hireEmployee(mid1, sen1);
        comp.hireEmployee(jun1, sen1);
        comp.hireEmployee(jun2, sen1);

        comp.hireEmployee(mid2, sen2);
        comp.hireEmployee(jun3, sen2);
        comp.hireEmployee(jun4, sen2);

        comp.hireEmployee(fin, ceo);

        comp.hireEmployee(acc1, fin);
        comp.hireEmployee(acc2, fin);

        comp.printAllEmployeeNames();
    }

    
}
