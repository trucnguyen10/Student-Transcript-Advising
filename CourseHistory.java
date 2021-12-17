import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


/**
 * @Code Modified by: Truc Nguyen '25 (HerSam) & Issac Lammers '24
 * @Version: 25th November 2021
 */
//NOTES:  You will need the import statements that appear at the top of this file, so you should
//leave them in place.  Follow the list of steps on the project writeup to complete the CourseHistory
//class that is started below.  This entire block of comments should be deleted when you are done. 


public class CourseHistory
{
    private ArrayList<CompletedCourse> courseList; 
    public CourseHistory()
    {  
       courseList = new ArrayList<CompletedCourse>();  
       String department;
       String courseNumber;
       String semester;
       String credit;
       String grade;
       String competency; 
       String distributionArea;
       try
       {
           FileReader reader = new FileReader("finishedcourses.txt");
           Scanner in = new Scanner(reader);
       
           while(in.hasNextLine())   
           {  department = in.nextLine();  
              courseNumber = in.nextLine();
              semester = in.nextLine();
              credit = in.nextLine();
              grade = in.nextLine();
              competency = in.nextLine();
              distributionArea = in.nextLine(); 
              courseList.add(new CompletedCourse(department, courseNumber, semester, credit, grade,competency, distributionArea));
              //theCourse.displayCourse();//You will be replacing this line 
              
          }
          in.close();  //Close the file when we are done reading it
       } catch (IOException exception)
       {
          System.out.println("Error processing file: " + exception);
       }   
    }
        
      

    /*
     * You will be completing this method.  When completed the method should
     * print all of the courses in the ArrayList which have a department that
     * matches the parameter.  Remember to use .equals to compare strings.
     */
    
    //The method displays courses the students has done by going through every elements in
    //the arraylist and call the displayCoure method. 
    public void displayCourseHistory()
    {
         for(int i=0; i< courseList.size(); i++)
        {   
            courseList.get(i).displayCourse();
        }        
    }
    /* The method displays the GPA and total credits earned. 
    First, create variables to store the values
    Second, create a loop to going through all elements then calculate: 
        + Count the worth credit of a course by checking if its grade greater than 0
        + Calculate the total grade, consider the contribution of half and full credit by multiplying the grade of course with the its credit 
    Third, quit the for loop, calculate the GPA and print out the calculated results 
     */
    public void displaySummary()
    {
        double GPA = 0.0;
        double numCredit = 0.0;
        double sumCredit = 0.0;
        double gradeCredit = 0.0;  
        for (int i = 0; i < courseList.size(); i++)
        {
            if(courseList.get(i).getGrade() > 0)
            {
                sumCredit += courseList.get(i).getCredit();
            }
            gradeCredit += courseList.get(i).getCredit() * courseList.get(i).getGrade();
            numCredit += courseList.get(i).getCredit();
        }
        GPA = gradeCredit / numCredit;
        System.out.println("Total credits earned is: " + sumCredit);
        System.out.println("Cumulative GPA: " + GPA);
    }
    /* A method displays the Distribution Area.
    First, display all course of the selected distribution area by call the displayCoure method
    Second, count the credits completed in that distribution area if satisfying the selected area and the grade greater than 0
    Third, Print out the result have just calculated
    */
     public void distAreaReport(String distArea)
    {
        System.out.println(""); 
        for (int i = 0; i < courseList.size(); i++)
        {
            if (courseList.get(i).getDistArea().equals(distArea))
            {
                    courseList.get(i).displayCourse();
            }
        }
        double credit = 0;
        for (int i = 0; i < courseList.size(); i++)
        {
            if (courseList.get(i).getDistArea().equals(distArea))
            {
                if(courseList.get(i).getGrade() > 0)
                    credit += courseList.get(i).getCredit();
            }
        }
        System.out.println("Total number of credits successfully completed in " + distArea + " is: " + credit);
    }
    /* The method counts and return the credits for single competency by check if 
    it matches the selected competency and the grade > 0 */
    public int countCreCom(String competency)
    {
        int count = 0;
        for (int i = 0; i < courseList.size(); i++)
        {
            if(courseList.get(i).getCompetency().equals(competency) && courseList.get(i).getGrade() > 0) 
            count++;
        }
        return count;
    }
    /* The method display if the student has conpleted the competency requierement or not by using the 
    return result of countCreCom method as the condition to check. 
    If the return value is greater than 0 (completed) if not then incompleted. 
    */
    public void comStatus(String competency)
    {
        if (countCreCom(competency) > 0) 
        System.out.println(competency + " Competency status:  Completed");
        else 
        System.out.println(competency + " Competency status:  Incompleted");
    }
    /* The method display the status of competency 
    Use the return result of the countCreCom method as the condition for if and else if staments to 
    check and print out the status of competency    
    */
    public void reportCom()
    {
        if (countCreCom("W") > 0 && countCreCom("Q") > 0 && countCreCom("S") > 0)
        System.out.println("All competencies completed") ;
        else if (countCreCom("W") > 0||  countCreCom("Q") > 0|| countCreCom("S") > 0 )
        System.out.println("Competencies Partially Completed");
        else if (countCreCom("W") ==  0 &&  countCreCom("Q") == 0 && countCreCom("S") == 0 )
        System.out.println("No competencies completed");
    }
    /* The method give the full report: the summary report, the distribution area report, and the competency report 
    by calling the written methods and plug in the value for the parameter 
    */
    public void displayFullReport()
    {
        displaySummary();
        System.out.println("Distribution Area Summary");
        distAreaReport("AH");
        distAreaReport("SS");
        distAreaReport("SM");
        distAreaReport("LA");
        System.out.println("Competency Summary");
        comStatus("W");
        comStatus("S");
        comStatus("Q");
        reportCom();
    }
    /* The method display course sorted by GPA
    Create a new arraylist to and store the value to sort to not affect the original arraylist
    Use the sorted algorithms to sort new arraylist by GPA and call displayCourse method to display 
    */
    public void displaySortedGPA()
    {
        ArrayList <CompletedCourse> temp = new ArrayList<CompletedCourse>();
        temp = courseList; 
        for (int i = 0; i < temp.size() - 1; i++)
        {
            for (int j = 0; j < temp.size() - 1; j++)
            {
                if (temp.get(j).getGrade() < temp.get(j+1).getGrade()) 
                temp.set(j, temp.set(j+1, temp.get(j)));
            }
        }
        for (int i = 0; i < temp.size(); i++)
           temp.get(i).displayCourse();
        }
    }












