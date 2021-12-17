/**
 * The CompletedCourse class allows information about courses taken by a student to be stored and manipulated.
 * Each Course has a department, a course number, a semester taken, a number of credits, and a grade. 
 * Each course also has a competency status field which can be W (writing), Q (quantitatve), S (speaking). 
 * If the course is not a W, Q, or S course its competency field should be X.  Each course also has a group field
 * which can be any of the distAreas SS, SM, AH, LA (or NONE if the course does not carry distArea credit).
 * 
 * Methods are provided to construct a new course, to print a course, and to access any of the courses 
 * instance fields.
 * @author Computer Science Department 
 * @version November 2007, Version 1.0
 */


public class CompletedCourse
{   String department;    //For example "CSC"
    String courseNumber;  //For example 121
    String semesterTaken; //For example 10708  or 20708
    double credit;        //The number of credits the course is worth, for example 1.0, .5, .25 
    double grade;         //For example 4.0, 3.67, 3.33, 3.0, 2.67, 2.33, 2.0, 1.67, 1.33, 1.0, 0.0
    String competency;    //Can be 'W', 'Q', 'S', or 'X' (for none)
    String distArea;      //Can be AH, SS, SM, LA or NONE (for no distArea). 

   
    /* Constructor for a Course.  This method takes initial values for the course's fields as 
     * parameters and then assigns the instance fields values based on these parameters.
     * @param initDepartment - Value to initialize department instance field to.
     * @param initCourseNumber - Value to initialize course number instance field to.
     * @param initSemesterTaken - Value to initalize the semesterTaken field to
     * @param initCredit - Value to initialize credit instance field to.
     * @param initGrade - Value to initialize the grade field to.
     * @param initCompetency - Value to initialize competency instance field to.
     * @param initDistArea - Value to initialize distArea instance field to.
     */
    public CompletedCourse(String initDepartment, String initCourseNumber, String initSemesterTaken, 
                          String initCredit,  String initGrade, String initCompetency, String initDistArea)
    {
       department = initDepartment.toUpperCase();     //Convert initDepartment to upper case and store it
       courseNumber = initCourseNumber;
       semesterTaken = initSemesterTaken;
       credit = Double.parseDouble(initCredit);       //Convert initCredit to a double and store it
       grade = Double.parseDouble(initGrade);         //Convert initGrade to a double and store it
       competency = initCompetency.toUpperCase();
       distArea = initDistArea;               
    }

    
    
    /* This method displays all of the fields for a Course with the department and course
     * number displayed together (e.g., CSC121).  The number of credits the course is worth
     * are also displayed along with an indication of whether or not the course carries group
     * or competency credit.
     */
    public void displayCourse()
    {
      System.out.println("******************************************");
      System.out.println("Course: " + semesterTaken + " ==> " + department + courseNumber);
      
      System.out.println ("Credit attempted: " + credit);
      System.out.println ("Grade: " + grade);

      if ( competency.equals("X") || competency.equals("x"))
         System.out.println ("Competency: NONE");
      else
         System.out.println ("Competency: " + competency);
     
      if (! distArea.equals("NONE"))   
         System.out.println ("distArea: " + distArea);
      else
         System.out.println ("distArea: NONE");
    }
    
    
    /* Simple accessor that returns the department for a course.
     * @return - A String which is the department for the Course.
     */
    public String getDepartment()
    {  return department;
    }
    
    
    /* Simple accessor that returns the course Number for a course.
     * @return - An String which is the course number for the Course.
     */
    public String getCourseNumber()
    {  return courseNumber;
    }
    
    
     /* Simple accessor that returns the semesterTaken for a course.
     * @return - An String which is the course number for the Course.
     */
    public String getSemesterTaken()
    {  return semesterTaken;
    }
    
    /* Simple accessor that returns the competency status for a course.
     * @return - A String (W, Q, S) which is competency for the Course or X
     * if there is no competency for this course.
     */
    public String getCompetency()
    {  return competency;
    }
    
    
    /* Simple accessor that returns the number of credits the course is worth.
     * @return - A double which is the number of credits the course is worth.
     */
    public double getCredit()
    {  return credit;
    }
    
    
     /* Simple accessor that returns the grade earned in the course.
     * @return - A double which is the grade for the Course.
     */
    public double getGrade()
    {  return grade;
    }
    
    
    /* Simple accessor that returns the distArea the course belongs to.
     * @return - A String which is the distArea of NONE if there is no distArea for this course.
     */
    public String getDistArea()
    {  return distArea;
    }
}

