package week5Project;

class StudentDetails{
    int id;

    String studName;

    String courseName;

    String trainerName;
    
    int pendingPay;
    
    public int getPendingPay() {
        return pendingPay;
    }

    public void setPendingPay(int pendingPay) {
        this.pendingPay = pendingPay;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudName() {
        return studName;
    }
 
    public void setStudName(String studName) {
        this.studName = studName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentDetails(int id, String studName, String courseName, String trainerName, int pendingPay) { //constructor
        this.id = id;
        this.studName = studName;
        this.courseName = courseName;
        this.trainerName = trainerName;
        this.pendingPay = pendingPay;
    }
}
