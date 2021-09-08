/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicMain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import LogicMain.Student;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author maxaj
 */
public class DatabaseHandler {

    // location of system database.
    private String url = "jdbc:ucanaccess://src/Database/RacesDB.mdb";

    private Connection conn = null;

    /**
     * Constructor for Database Handler. Creates the connection object to the
     * database.
     */
    public DatabaseHandler() {
        try {
            conn = connectDatabase();
        } catch (SQLException e) {
            System.err.println("[DB] - failed to connect to database\n" + e);
        }
    }

    /**
     * 34 * Attempts a connection to the database and returns a Connection
     *    } catch (ClassNotFoundException ex) {
            System.out.println("[DB] - driver error\n" + ex);
        }

        return c;
    } object if 35 * successful, null otherwise 36 * 37 * @return Connection
     * object c 38 * @throws SQLException 39
     */
    private Connection connectDatabase() throws SQLException {
        Connection c = null;
        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            c = DriverManager.getConnection(url);
            System.out.println("[DB] - connected");

        } catch (ClassNotFoundException ex) {
            System.out.println("[DB] - driver error\n" + ex);
        }

        return c;
    }

// sql methods to fetch information from the database.
    public Student[] getAllStudents() {
        System.out.println("[DB] - getting all Students");
        Student[] toRet = null;
        String sql = "SELECT * FROM Students";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet r = stmt.executeQuery();
            r.last();
            int count = r.getRow();
            toRet = new Student[count];
            r.beforeFirst();
            int cCount = 0;
            while (r.next()) {
// build Student object
                int id = r.getInt("StudentID");
                String f = r.getString("FName");
                String l = r.getString("SName");
                int g = r.getInt("AgeGroup");
                int s = r.getInt("DaysAbsent");
                Student cur = new Student(id, f, l, g, s);
//System.out.println(cur.toString());
                toRet[cCount] = cur;
                cCount++;
            }

            r.close();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("[DB] - someting went wrong" + e);
        }
        return toRet;
    }

    //Deletes All Students present in the Students Database
//    public void deleteAllStudents() {
//        System.out.println("[DB] - deleting all Students");
//        try {
//            String sql = "DELETE * FROM tblStudents";
//            Statement stmt = conn.createStatement();
//            int res = stmt.executeUpdate(sql);
//            System.out.println("[DB] ]- num deleted - " + res);
//            stmt.close();
//        } catch (SQLException e) {
//            System.err.println("[DB] - error deleting fam - " + e);
//        }
//    }

    //Queries the Database and returns the Student object with a matching ID 
    public Student getStudentFromID(int inID) {
        Student cur = null;
        System.out.println("[DB] - getting student from ID");
        Student[] toRet = null;
        String sql = "SELECT * FROM Students WHERE StudentID = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, inID);

            ResultSet r = stmt.executeQuery();

// build Student object
            while (r.next()) {

                int id = r.getInt("StudentID");
                String f = r.getString("FName");
                String l = r.getString("SName");
                int g = r.getInt("AgeGroup");
                int s = r.getInt("DaysAbsent");
                cur = new Student(id, f, l, g, s);
//System.out.println(cur.toString());
            }
            r.close();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("[DB] - someting went wrong fam " + e);
        }
        return cur;
    }

    

    //Counts the number of races linked to a Student object 
    public int countNumberRaces(int inID) {
        int count = 0;
        String sql = "SELECT COUNT(*) as raceCount FROM Results WHERE StudentID = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, inID);

            ResultSet r = stmt.executeQuery();

            while (r.next()) {
                count = r.getInt("raceCount");
            }
            r.close();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("[DB] - someting went wrong " + e);
        }

        return count;
    }

    //Updates the Student Database with the updated student student object 
    public void updateStudent(Student student) {
        try {
            String sql = "UPDATE Students SET FName = ?, SName = ?, AgeGroup = ?, DaysAbsent = ? WHERE StudentID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getfName());
            stmt.setString(2, student.getlName());
            stmt.setInt(3, student.getAge());
            stmt.setInt(4, student.getAttend());
            stmt.setInt(5, student.getId());
            stmt.executeUpdate();
            System.out.println("Student: " + student.getfName() + " " + student.getlName() + " updated succesfully.");
        } catch (SQLException e) {
            System.out.println("[DB] - Error - updateStudent/n" + e);
        }
    }

    //Inserts a new student into the Student Database
    public void insertStudent(Student student) {
        try {
            String sql = "INSERT INTO Students (FName,SName,AgeGroup,DaysAbsent) VALUES(?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, student.getfName());
            stmt.setString(2, student.getlName());
            stmt.setInt(3, student.getAge());
            stmt.setInt(4, student.getAttend());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[DB] - Error - insertStudent/n" + e);
        }
    }

    //Retrieves all Race objects from the Races Database
    public Race[] getAllRaces() {
        System.out.println("[DB] - getting all Races");
        Race[] toRet = null;
        String sql = "SELECT * FROM Races";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet r = stmt.executeQuery();
            r.last();
            int count = r.getRow();
            toRet = new Race[count];
            r.beforeFirst();
            int cCount = 0;
            while (r.next()) {
// build Student object
                int id = r.getInt("RaceID");
                int dist = r.getInt("Distance");
                Calendar cal = Calendar.getInstance();
                cal.setTime(r.getDate("RaceDate"));

                Race cur = new Race(dist, id, cal);
//System.out.println(cur.toString());
                toRet[cCount] = cur;
                cCount++;
            }

            r.close();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("[DB] - someting went wrong" + e);
        }
        return toRet;
    }

    //Returns a Race Object whoms ID correlates to the one specified by the user
    public Race getRaceFromID(int inID) {
        Race cur = null;
        System.out.println("[DB] - getting race from ID");
        Student[] toRet = null;
        String sql = "SELECT * FROM Races WHERE RaceID = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, inID);

            ResultSet r = stmt.executeQuery();

// build Student object
            while (r.next()) {

                int id = r.getInt("RaceID");
                int dist = r.getInt("Distance");
                Calendar cal = Calendar.getInstance();
                cal.setTime(r.getDate("RaceDate"));

                cur = new Race(dist, id, cal);
//System.out.println(cur.toString());
            }
            r.close();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("[DB] - someting went wrong fam " + e);
        }
        return cur;
    }

    //Returns a student object and Race Time from both the Races Table and Students table using a specified Student ID
    public String[] getStudentsAndTimesFromRaceID(int inID) {
        SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
        System.out.println("[DB] - getting all Students");
        String[] toRet = null;
        String sql = "SELECT RaceID, StudentID, TimeRun, FName, SName FROM Results, Students WHERE Results.StudentID = Students.StudentID AND RaceID = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            stmt.setInt(1, inID);

            ResultSet r = stmt.executeQuery();
            r.last();
            int count = r.getRow();
            toRet = new String[count];
            r.beforeFirst();
            int cCount = 0;
            while (r.next()) {
// build Student object
                String FName = r.getString("FName");
                String SName = r.getString("SName");
                int sID = r.getInt("StudentID");
                int rID = r.getInt("RaceID");

                Calendar cal = Calendar.getInstance();
                cal.setTime(r.getTimestamp("TimeRun"));

                String cur = FName + ", " + SName + ", " + form.format(cal.getTime());

//System.out.println(cur.toString());
                toRet[cCount] = cur;
                cCount++;
            }

            r.close();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("[DB] - someting went wrong" + e);
        }
        return toRet;
    }

    //Returns a Student object using a specified string
    public Integer getStudentFromName(String inFName, String inLName) {
        System.out.println("[DB] - getting student from name");
        int id = 0;
        try {

            String sql = "SELECT StudentID FROM Students WHERE FName = ? AND SName = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, inFName);
            stmt.setString(2, inLName);
            ResultSet r = stmt.executeQuery();

            while (r.next()) {

                id = r.getInt("StudentID");

//System.out.println(cur.toString());
            }
            r.close();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("[DB] - someting went wrong fam " + e);
        }
        return id;
    }

    public Results getResultFromID(int inRID, int inSID) {
        Results cur = null;
        System.out.println("[DB] - getting result from ID");
        Student[] toRet = null;
        String sql = "SELECT * FROM Results WHERE StudentID = ? AND RaceID = ?  ";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, inSID);
            stmt.setInt(2, inRID);

            ResultSet r = stmt.executeQuery();

// build Student object
            while (r.next()) {

                int rID = r.getInt("RaceID");
                int sID = r.getInt("StudentID");
                Calendar cal = Calendar.getInstance();
                cal.setTime(r.getTimestamp("TimeRun"));

                cur = new Results(rID, sID, cal);
//System.out.println(cur.toString());
            }
            r.close();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("[DB] - someting went wrong fam " + e);
        }
        return cur;
    }

    //Updates the Results Database 
    public void updateResult(int inSID, int inRID, Calendar inCal) {
        System.out.println("[DB] - Updating result");
        SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");

        try {
            String sql = "UPDATE Results SET TimeRun = ?  WHERE StudentID = ? AND RaceID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setTimestamp(1, new java.sql.Timestamp(inCal.getTimeInMillis()));
            stmt.setInt(2, inSID);
            stmt.setInt(3, inRID);

            stmt.executeUpdate();
            System.out.println("Result updated succesfully to: " + form.format(inCal.getTime()));
        } catch (SQLException e) {
            System.out.println("[DB] - Error - updateStudent/n" + e);
        }
    }

    //Inserts a new result into the Results database 
    public void insertResult(int inSID, int inRID, Calendar inCal) {
        System.out.println("[DB] - Inserting new result");
        SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");

        try {
            String sql = "INSERT INTO Results (RaceID, StudentID, TimeRun) VALUES(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setTimestamp(3, new java.sql.Timestamp(inCal.getTimeInMillis()));
            stmt.setInt(2, inSID);
            stmt.setInt(1, inRID);

            stmt.executeUpdate();
            System.out.println("Result updated succesfully to: " + form.format(inCal.getTime()));
        } catch (SQLException e) {
            System.out.println("[DB] - Error - updateStudent/n" + e);
        }
    }

    //Inserts a new Race into the Races Database
    public void insertRace(int dist, Calendar inCal) {
        System.out.println("[DB] - Inserting new race");
        SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");

        try {
            String sql = "INSERT INTO Races ( Distance, RaceDate) VALUES(?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setTimestamp(2, new java.sql.Timestamp(inCal.getTimeInMillis()));
            stmt.setInt(1, dist);

            stmt.executeUpdate();
            System.out.println("Result updated succesfully to: " + form.format(inCal.getTime()));
        } catch (SQLException e) {
            System.out.println("[DB] - Error - updateStudent/n" + e);
        }
    }

    //Updates a race in the Races Database using a specifeid Race ID to find the Race to be updated
    public void updateRace(int rID, int dist, Calendar inCal) {
        System.out.println("[DB] - Updating race");
        SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");

        try {
            String sql = "UPDATE Races SET RaceDate = ?, Distance = ? WHERE RaceID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setTimestamp(1, new java.sql.Timestamp(inCal.getTimeInMillis()));
            stmt.setInt(2, dist);
            stmt.setInt(3, rID);

            stmt.executeUpdate();
            System.out.println("Result updated succesfully to: " + form.format(inCal.getTime()));
        } catch (SQLException e) {
            System.out.println("[DB] - Error - updateStudent/n" + e);
        }
    }

    //Queries the Races Database, using specified Distance and Date to find the Race and returns an array of matching races
    public Race[] searchRaces(int inID, Calendar inCal) {
        System.out.println("[DB] - getting all Races from search");
        Race[] toRet = null;
        String sql = "SELECT * FROM Races WHERE Distance = ? AND RaceDate = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            stmt.setInt(1, inID);
            stmt.setTimestamp(2, new java.sql.Timestamp(inCal.getTimeInMillis()));
            ResultSet r = stmt.executeQuery();
            r.last();
            int count = r.getRow();
            toRet = new Race[count];
            r.beforeFirst();
            int cCount = 0;
            while (r.next()) {
// build Student object
                int id = r.getInt("RaceID");
                int dist = r.getInt("Distance");
                Calendar cal = Calendar.getInstance();
                cal.setTime(r.getDate("RaceDate"));

                Race cur = new Race(dist, id, cal);
//System.out.println(cur.toString());
                toRet[cCount] = cur;
                cCount++;
            }

            r.close();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("[DB] - someting went wrong" + e);
        }
        return toRet;
    }

    public Race[] searchRaces(int inID) {
        System.out.println("[DB] - getting all Races from search");
        Race[] toRet = null;
        String sql = "SELECT * FROM Races WHERE Distance = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            stmt.setInt(1, inID);

            ResultSet r = stmt.executeQuery();
            r.last();
            int count = r.getRow();
            toRet = new Race[count];
            r.beforeFirst();
            int cCount = 0;
            while (r.next()) {
// build Student object
                int id = r.getInt("RaceID");
                int dist = r.getInt("Distance");
                Calendar cal = Calendar.getInstance();
                cal.setTime(r.getDate("RaceDate"));

                Race cur = new Race(dist, id, cal);
//System.out.println(cur.toString());
                toRet[cCount] = cur;
                cCount++;
            }

            r.close();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("[DB] - someting went wrong" + e);
        }
        return toRet;
    }

    //Queries the Races Database, using specified Date to find the Race and returns an array of matching races
    public Race[] searchRaces(Calendar inCal) {
        System.out.println("[DB] - getting all Races from search");
        Race[] toRet = null;
        String sql = "SELECT * FROM Races WHERE RaceDate = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            stmt.setTimestamp(1, new java.sql.Timestamp(inCal.getTimeInMillis()));
            ResultSet r = stmt.executeQuery();
            r.last();
            int count = r.getRow();
            toRet = new Race[count];
            r.beforeFirst();
            int cCount = 0;
            while (r.next()) {
// build Student object
                int id = r.getInt("RaceID");
                int dist = r.getInt("Distance");
                Calendar cal = Calendar.getInstance();
                cal.setTime(r.getDate("RaceDate"));

                Race cur = new Race(dist, id, cal);
//System.out.println(cur.toString());
                toRet[cCount] = cur;
                cCount++;
            }

            r.close();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("[DB] - someting went wrong" + e);
        }
        return toRet;
    }

}
