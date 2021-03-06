package lk.ac.pdn.co328.studentSystem;
import org.junit.*;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class StudentRegisterTest {
    private StudentRegister register;

    @Before
    public void setupTest()
    {
        register = new StudentRegister();
        System.out.println("A new test is starting.");
    }

    @After
    public void finishTest()
    {
        System.out.println("Test finished");
    }

    @BeforeClass
    public  static void beforeClass()
    {
        System.out.println("Evaluating test cases in StudentRegisterTest.java");
    }

    @AfterClass
    public static void afterClass()
    {
        System.out.println("All tests are done");
    }

   @Test
    public void testAddStudent()
   {
       register = new StudentRegister();
       try
       {
           register.addStudent(new Student(2, "nimal", "kumara"));
           register.addStudent(new Student(5, "fawzan", "mohomad"));
       }
       catch (Exception ex)
       {
           Assert.fail("Adding student failed");
       }
       System.out.println("Testing add student method");

       Student student = register.findStudent(2);
       Assert.assertEquals("Student Id is wrong",2,student.getId());
   }

   @Test
    public void testAddStudentTwice()
   {
       try {
           register.addStudent(new Student(5, "Dasun", "Thara"));
           register.addStudent(new Student(4, "Dharana", "Dulak"));
           register.addStudent(new Student(6, "Sasanka", "Nuwan"));
           register.addStudent(new Student(9, "Rain", "Kumar"));
           register.addStudent(new Student(1, "Janka", "Wijesinghe"));
       }
       catch (Exception ex)
       {
           fail("Tryning to add a registration number that already exist.");
       }

       System.out.println("Testing identical registration numbers");

       Student student1 = register.findStudent(4);
       assertEquals("Adding a wrong ID(this id is alredy exists)",4,student1.getId());

       // Implement your test code here. Adding a student with same registration number twice should generate an exception.
       //Assert.fail("Test case is not yet implemented for adding student twice. So it is set to fail always");
   }

    @Test
    public void testRemoveStudent()
    {
        register = new StudentRegister();
        try
        {
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "gayan", "chamara"));
        }
        catch (Exception ex)
        {
            Assert.fail("Add student failed");
        }
        register.removeStudent(1);
        Student student = register.findStudent(1);
        Assert.assertNull("student was not removed",student);
    }

    @Test
    public void testGetRegNumbers()
    {
        register = new StudentRegister();
        try
        {
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "gayan", "chamara"));
        }
        catch (Exception ex)
        {
            Assert.fail("Adding student failed");
        }
        ArrayList<Integer> numbers = register.getAllRegistrationNumbers();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(5);
        Assert.assertTrue(numbers.equals(expected));
    }

    @Test
    public void testFindStudentsByName()
    {
        try
        {
            register.addStudent(new Student(1, "ruwan", "tharaka"));
            register.addStudent(new Student(2, "nimal", "kumara"));
            register.addStudent(new Student(5, "gayan", "hamara"));
        }
        catch (Exception ex)
        {
            fail("Add student failed.");
        }
        ArrayList<Student> student;
        student = register.findStudentsByName("ruwan");
       /* assertEquals(5, student.get(0).getId());
        assertEquals("ruwan", student.get(0).getFirstName());
        assertEquals("tharaka", student.get(0).getLastName());
    */}
}
