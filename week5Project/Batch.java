package week5Project;

class Batch{

    public Batch(String b,String t){ //constructor
        batchTiming=b;

        trainerName=t;
    }
    
    String batchTiming;

    String trainerName;


    public String getBatchTiming() {
        return batchTiming;
    }

    public void setBatchTiming(String batchTiming) {
        this.batchTiming = batchTiming;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }


}

