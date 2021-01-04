/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class student_attendence_model {
    
    
    private String id ,present , date ;
    
    
    student_attendence_model(String id ,String present, String date){
        this.id =id ;
        this.present =present ;
        this.date = date ;
    }
    
    public String getid()
    {
        return id ;
    }
    public String getpresent()
    {
        return present ;
    }
     
    public String getdate()
    {
        return date ;
    }
    
}
