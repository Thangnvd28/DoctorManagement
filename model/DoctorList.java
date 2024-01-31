
package model;

import java.util.ArrayList;
import java.util.List;

public class DoctorList {
    private List <Doctor> doctorList = new ArrayList<>();

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
    
    public boolean addList(Doctor dt) {
        for (Doctor doctor : doctorList) {
            if (doctor.getCode().equalsIgnoreCase(dt.getCode())) {
                return false;
            }
        }
        doctorList.add(dt);
        return true;
    }
    
    public boolean removeList(String code) {
        for (Doctor doctor : doctorList) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                doctorList.remove(doctor);
                return true;
            }
        }
        return false;

    }
    
    public int getListSize(){
        return doctorList.size();
    }
    
    public List<Doctor> searchDoctor (String input) throws Exception{
        List<Doctor> foundList = new ArrayList();
        for(Doctor doctor : doctorList){
            if(doctor.getCode().contains(input)|| doctor.getName().toLowerCase().contains(input.toLowerCase())){
                foundList.add(doctor);
            }
            if(foundList.size() == 0){
                throw new Exception("Database doesn't exist");
            }
        }
        return foundList;
    }

    @Override
    public String toString() {
        System.out.printf("%-10s | %-20s | %-15s | %10s\n\n", "Code", "Name", "Specialization", "Availability");
        for (Doctor dt : doctorList){
            dt.toString();
        }
        return "";
    }
    
    
}
