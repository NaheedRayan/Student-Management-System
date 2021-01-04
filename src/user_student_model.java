/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class user_student_model {
    
    private String username , id , phone_number ,department ,batch ,session;
    
    public user_student_model(String username , String id , String phone_number , String department , String batch ,String session)
    {
        this.username = username ;
        this.id = id ;
        this.phone_number = phone_number ;
        this.department = department ;
        this.batch = batch ;
        this.session = session ;
    }
    
  
    public String getusername()
    {
        return username ;
    }
    public String getid()
    {
        return id ;
    }
     
    public String getphone_number()
    {
        return phone_number ;
    }
    public String getdepartment()
    {
        return department ;
    }
    public String getbatch()
    {
        return batch ;
    }
    public String getsession()
    {
        return session ;
    }
   
    
}
