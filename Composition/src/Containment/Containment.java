package Containment;
import java.util.*;

// Containment (Composition) Example: Hospital → Department → Doctor → Specialist

class Specialist {
    String name;
    int credits;

    Specialist(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    void showSpecialist() {
        System.out.println("   Specialist : " + name + " | Credits : " + credits);
    }
}

class Doctors {
    String doctorName;
    List<Specialist> specialists;

    Doctors(String doctorName) {
        this.doctorName = doctorName;
        this.specialists = (List<Specialist>) new ArrayList<>();
    }

    void addSpecialist(Specialist s) {
        specialists.add(s);
    }

    void showDoctor() {
        System.out.println(" Doctor : " + doctorName);
        for (Specialist s : specialists) {
            s.showSpecialist();
        }
    }
}

class Department {
    String departmentName;
    List<Doctors> doctors;

    Department(String departmentName) {
        this.departmentName = departmentName;
        this.doctors = new ArrayList<>();
    }

    void addDoctor(Doctors d) {
        doctors.add(d);
    }

    void showDepartment() {
        System.out.println("Department : " + departmentName);
        for (Doctors d : doctors) {
            d.showDoctor();
        }
    }
}

class Hospitals {
    String hospitalName;
    List<Department> departments;

    Hospitals(String hospitalName) {
        this.hospitalName = hospitalName;
        this.departments = (List<Department>) new ArrayList<>();
    }

    void addDepartment(Department d) {
        departments.add(d);
    }

    void showHospital() {
        System.out.println("\nHospital Name : " + hospitalName);
        for (Department d : departments) {
            d.showDepartment();
        }
    }
}

public class Containment {
    public static void main(String[] args) {

        // Create Specialists
        Specialist sp1 = new Specialist("Heart Specialist", 4);
        Specialist sp2 = new Specialist("Eye Specialist", 3);
        Specialist sp3 = new Specialist("Ear Specialist", 5);
        Specialist sp4 = new Specialist("Bone Specialist", 5);
        Specialist sp5 = new Specialist("Gynecologist", 4);
        Specialist sp6 = new Specialist("Therapist", 4);
        Specialist sp7 = new Specialist("Physician", 3);
        Specialist sp8 = new Specialist("Psychologist", 5);

        // Create Doctors and assign specialists
        Doctors d1 = new Doctors("Dr. S. A. Shivakar");
        d1.addSpecialist(sp1);
        d1.addSpecialist(sp2);
        d1.addSpecialist(sp3);

        Doctors d2 = new Doctors("Dr. Bhambre");
        d2.addSpecialist(sp4);
        d2.addSpecialist(sp5);
        d2.addSpecialist(sp6);
        d2.addSpecialist(sp7);

        Doctors d3 = new Doctors("Dr. Houle");
        d3.addSpecialist(sp8);

        // Create Departments
        Department cardiology = new Department("Cardiology Department");
        cardiology.addDoctor(d1);

        Department general = new Department("General Medicine Department");
        general.addDoctor(d2);
        general.addDoctor(d3);

        // Create Hospitals
        Hospitals h1 = new Hospitals("Jape Hospital");
        h1.addDepartment(cardiology);
        h1.addDepartment(general);

        Hospitals h2 = new Hospitals("Sudarshan Hospital");
        h2.addDepartment(general);

        // Display
        h1.showHospital();
        h2.showHospital();
    }
}
