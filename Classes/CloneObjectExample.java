public class CloneObjectExample implements Cloneable {

    private int studentNumber;
    private String fullName;
    private double average;

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    int getStudentNumber() {
        return studentNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    String getFullName() {
        return fullName;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    double getAverage() {
        return average;
    }

    CloneObjectExample(int studentNumber, String fullName, double average) {
        this.studentNumber = studentNumber;
        this.fullName = fullName;
        this.average = average;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {

        try {
            CloneObjectExample student1 = new CloneObjectExample(150160144, "Jane_Kotlin", 3.5);
            CloneObjectExample student2 = (CloneObjectExample) student1.clone();

            System.out.println(student1.getFullName() + " " + student1.getStudentNumber() + " " + student1.getAverage());
            System.out.println(student2.getFullName() + " " + student2.getStudentNumber() + " " + student2.getAverage());

        } catch (CloneNotSupportedException e) {
        }

    }

}
