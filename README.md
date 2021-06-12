# Student-Management-System
A programme using java swing

## This Project is done in 2nd year 2nd semister
## Course : CSE-2203  Database Management System



### Setup
In order to setup this program download this software.You should also have xammp app installed.

Now,
Unzip the rar file from the link and add those files in xammp folder .
https://github.com/NaheedRayan/Readme-Images/tree/master/Student_Management_System_xampp_data
Restart xampp start MySQL and open database and table to make sure its working.

## This Programe is only handled by admin




## This is the Structure of the Program
You can see in jPanel2 its of type null.The reason behind it is that if you want to add button on top of picture(jLabel)
its type has to be null .Moreover the picture(jLabel51) should be at the bottom to show other elements .Or else you will not 
see other elements.

Now , in the options panel we have used card layout , Because the left part has to be static and the right part has to be 
dynamic ie.it changes when menu button is clicked.

![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/01.1.JPG?raw=true)


In this picture we can see the library structure of the programe
You have to download the mysql connector from https://www.softpedia.com/get/Internet/Servers/Database-Utils/MySQL-Connector-J.shtml
and jCalender from https://toedter.com/jcalendar/ and add them to the librarys

![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/01.2.JPG?raw=true)

This is the schema of the app .I would not say the app is perfect .There are rooms from improvement .Just modify it as per your likings😁
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/01.JPG?raw=true)

## These are pictures of different table structure in xampp 
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/02.JPG?raw=true)
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/03.JPG?raw=true)
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/04.JPG?raw=true)
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/05.JPG?raw=true)
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/06.JPG?raw=true)
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/07.JPG?raw=true)
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/08.JPG?raw=true)

## These are the screen shots of the program
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/09.JPG?raw=true)
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/10.JPG?raw=true)
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/11.JPG?raw=true)
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/12.JPG?raw=true)
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/13.JPG?raw=true)
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/14.JPG?raw=true)
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/15.JPG?raw=true)
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/16.JPG?raw=true)
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/17.JPG?raw=true)
![alt text](https://github.com/NaheedRayan/Readme-Images/blob/master/Student_Management_System/18.JPG?raw=true)

## What i learned .
To be frank I learned a lot .
The using of splitview is hard .Because it creates much clutter in code.
So maintainence becomes very hard.I learned it the hard way.

## some tips
this code is for fetching and linking image from db

```
byte[] image = rs.getBytes("picture") ;
                
ImageIcon myImg = new ImageIcon(image) ;
Image img = myImg.getImage().getScaledInstance(jLabelPic.getWidth(),jLabelPic.getHeight(),Image.SCALE_SMOOTH);
ImageIcon myPicture = new ImageIcon(img) ;
jLabelPic.setIcon(myPicture);
```


This piece of code is used for refreshing the table
```
DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();             
tableModel.setRowCount(0);
```

## Copy the Student_Management_System_xampp_data folder in the xampp directory and run the project



------------------------------------------------------------------------The End ❤❤❤❤🖤---------------------------------------------------------------------------
