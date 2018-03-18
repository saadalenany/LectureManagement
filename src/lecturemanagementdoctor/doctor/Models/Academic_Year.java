package lecturemanagementdoctor.doctor.Models;

/**
 *
 * @author Saad Alenany
 */
public class Academic_Year {

    private int Academic_Year_id;
    private int academic_year;

    public Academic_Year(int year_id, int academic_year) {
        this.Academic_Year_id = year_id;
        this.academic_year = academic_year;
    }

    public Academic_Year(int academic_year) {
        this.academic_year = academic_year;
    }

    public int getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(int academic_year) {
        this.academic_year = academic_year;
    }

    public int getAcademic_Year_id() {
        return Academic_Year_id;
    }

    public void setAcademic_Year_id(int Academic_Year_id) {
        this.Academic_Year_id = Academic_Year_id;
    }

    @Override
    public String toString() {
        return "Academic_Year{" + "year_id=" + Academic_Year_id + ", academic_year=" + academic_year + '}';
    }

}
