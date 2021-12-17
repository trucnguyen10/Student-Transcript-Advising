import java.awt.*;           //Use the Abstract Window Toolkit
import java.awt.event.*;     //Use the Abstract Window Toolkit event processing
import javax.swing.*;        //To use SWING interface components such as frames


/**
 * The Driver class presents a simple GUI that can be used to search courses. The
 * GUI allows the user to specify a department to use as a search criterion.
 * 
 * @author Computer Science Department 
 * @version November, 2007
 * @Code Modified: Truc Nguyen (HerSam) '25 & Issac Lammers '24
 * @Version: 25th November 2021
 */

public class GUIInterface implements ActionListener
{   private CourseHistory courses = new CourseHistory();
    private JFrame frame = new JFrame("DPU - Course History");
    private JButton submitButton = new JButton("SUBMIT");
    private JComboBox reportCombo = new JComboBox();  
  
    /*
     * The constructor for the Driver class creates the GUI and calls
     * a method to fill the report combo box with initial values. It
     * then displays this comboBox on the pane.
     */
    public GUIInterface()
    {         
       //By default a gridlayout has one row
       frame.getContentPane().setLayout(new GridLayout()); 
       fillReportCombo();
       submitButton.addActionListener(this);      //Add the search button's action    
       frame.getContentPane().add(submitButton);
       frame.pack();
       frame.setVisible(true);
   }
      
    
    /*
     * This method fills the reportCombo box with initial values.
     */
    public void fillReportCombo()
    { reportCombo.addItem("COURSE HISTORY");
      reportCombo.addItem("SUMMARY");
      reportCombo.addItem("DIST AREAS");
      reportCombo.addItem("COMPETENCY");
      reportCombo.addItem("FULLREPORT");
      reportCombo.addItem("SORTEDLIST");
      frame.getContentPane().add(reportCombo);
    }
    
    
    /*
     * This method is called when the user clicks on a button in the Interface.
     * The method checks to see if the user clicked on the SUBMIT button.  If so,
     * it prints the selected report.
     *
     */
    public void actionPerformed(ActionEvent event)
    { 
      if (event.getSource().equals(submitButton))
      {  
          String selectedReport = reportCombo.getSelectedItem().toString();
          if (selectedReport.equals("COURSE HISTORY") )
          {
          System.out.println();
          System.out.println("-----Course Histoty-----");
          courses.displayCourseHistory();
          }
      }
      if (event.getSource().equals(submitButton))
      {  
          String selectedReport = reportCombo.getSelectedItem().toString();
          if (selectedReport.equals("SUMMARY") )
          {
          System.out.println();    
          System.out.println("------ Summary Report -----");
          courses.displaySummary();
          }
      }
      if (event.getSource().equals(submitButton))
      {  
          String selectedReport = reportCombo.getSelectedItem().toString();
          if (selectedReport.equals("DIST AREAS"))
          {
          System.out.println();
          System.out.println("------ Distribution Area Report -----");
          courses.distAreaReport("AH");
          courses.distAreaReport("SS");
          courses.distAreaReport("SM");
          courses.distAreaReport("LA");
          }
        }
        if (event.getSource().equals(submitButton))
        {   String selectedReport = reportCombo.getSelectedItem().toString();
            if (selectedReport.equals("COMPETENCY") )
            {   
                System.out.println();
                System.out.println("-----Competency Report------");
                courses.comStatus("W");
                courses.comStatus("S");
                courses.comStatus("Q");
                courses.reportCom();
            }
        }
          if (event.getSource().equals(submitButton))
        {   String selectedReport = reportCombo.getSelectedItem().toString();
            if (selectedReport.equals("FULLREPORT") )
            {   
                System.out.println();
                System.out.println("----- Full Report -----");
                courses.displayFullReport();
            }
        }
        if (event.getSource().equals(submitButton))
        {   String selectedReport = reportCombo.getSelectedItem().toString();
            if (selectedReport.equals("SORTEDLIST") )
            {   
                System.out.println();
                System.out.println("----- Sorted Course List -----");
                courses.displaySortedGPA();
            }
        }
    }
      }
      
      
          
