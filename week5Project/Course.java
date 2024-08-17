package week5Project;

import java.util.List;

class Course{
    

    public Course(String courseName, Batch batch) {	//constructor
        this.courseName = courseName;
        this.batch = batch;
    }
    
    String courseName;
    
    public String getCourseName() {
        return courseName;
    }

    Batch batch;

    public Batch getBatch() {
        return batch;
    }
    
    List<StudentDetails> studDetails;

    public List<StudentDetails> getStudDetails() {
        return studDetails;
    }

    public void setStudDetails(StudentDetails studDetails1) {
        this.studDetails.add(studDetails1);
    }
}
