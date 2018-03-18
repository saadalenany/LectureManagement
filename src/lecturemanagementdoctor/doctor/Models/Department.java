package lecturemanagementdoctor.doctor.Models;

/**
 *
 * @author Saad Alenany
 */
public class Department {

    private int Department_id;
    private String department_name;

    public Department(int department_id, String department_name) {
        this.Department_id = department_id;
        this.department_name = department_name;
    }

    public Department(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getDepartment_id() {
        return Department_id;
    }

    public void setDepartment_id(int Department_id) {
        this.Department_id = Department_id;
    }

    @Override
    public String toString() {
        return "Department{" + "department_id=" + Department_id + ", department_name=" + department_name + '}';
    }

}
