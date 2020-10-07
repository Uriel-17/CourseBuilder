/**
 * Classes.java
 * @author Uriel Garcia
 * @author Andrew Nowinski
 * @author Alan Yee
 * @author Maninderjit Singh
 * CIS 22C
 */

import java.util.Comparator;

public class Classes implements Comparable<Classes>, Comparator<Classes> {


    private String CRN; //unique key
    private Double Credit;
    private String Subject;
    private String Course;
    private String Days;
    private String Time;
    private String Prof;
    private double Rating;

    /**
     * Constructor for the Classes class
     * @param CRN identification number for the class
     * @param Credit given per class
     * @param Subject of the class
     * @param Course specific class name
     * @param Days how many days the class takes place
     * @param Time the class takes place
     * @param Prof name of the professor teaching the
     * class
     * @param Rating the rating past students give
     * the teacher
     */
    public Classes(String CRN, Double Credit, String Subject, String Course,String Days, String Time, String Prof, double Rating) {

        this.CRN = CRN;

        this.Credit = Credit;

        this.Subject = Subject;

        this.Course = Course;

        this.Days = Days;

        this.Time = Time;

        this.Prof = Prof;

        this.Rating = Rating;

    }

    /**
     * Constructor for the Classes class
     * @param //CRN identification number for the class
     * @param //Subject of the class
     * @param //Days how many days the class takes place
     * @param //Time the class takes place
     * @param //Prof name of the professor teaching the
     * class
     * @param //Rating the rating past students give
     * the teacher
     */
    public Classes() {

        this.CRN = "0";

        this.Credit = 0.0;

        this.Subject = "Default Subject";

        this.Course = "Default Course";

        this.Days = "Default Day";

        this.Time = "Default Time";

        this.Prof = "Default Prof";

        this.Rating = 0;

    }

    /************************ Setters ******************************

     /**
     * Sets the CRN of the Class
     * @param CRN the Movie's title
     */
    public void setCRN(String CRN) {

        this.CRN = CRN;

    }

    /**
     * Sets the title of the Class
     * @param Subject the Movie's title
     */
    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    /**
     * Sets the title of the Class
     * @param Days the Movie's title
     */
    public void setDays(String Days) {
        this.Days = Days;
    }

    /**
     * Sets the title of the Class
     * @param Time the Movie's title
     */
    public void setTime(String Time) {
        this.Time = Time;
    }

    /**
     * Sets the title of the Class
     * @param Prof the Movie's title
     */
    public void setProf(String Prof) {
        this.Prof = Prof;
    }

    /**
     * Sets the title of the Class
     * @param Rating the Movie's title
     */
    public void setRating(double Rating) {
        this.Rating = Rating;
    }

    /**
     * Sets the Course of the Class
     * @param course
     */
    public void setCourse(String course) {

        this.Course = course;
    }

    /**
     * Sets the Credit of the Class
     * @param credit
     */
    public void setCredit(Double credit) {
        Credit = credit;
    }

    /************************ Getters ******************************

     /**
     * Accesses the CRN of the Class
     * @return the Class's title
     */
    public String getCRN() {
        return CRN;
    }

    /**
     * Accesses the subject of the Class
     * @return the Class's title
     */
    public String getSubject() {
        return Subject;
    }

    /**
     * Accesses the Days of the Class
     * @return the Class's title
     */
    public String getDays() {
        return Days;
    }

    /**
     * Accesses the Time of the Class
     * @return the Class's Time
     */
    public String getTime() {
        return Time;
    }

    /**
     * Accesses the Prof of the Class
     * @return the Class's Prof
     */
    public String getProf() {
        return Prof;
    }

    /**
     * Accesses the Rating of the Class
     * @return the Class's Rating
     */
    public double getRating() {
        return Rating;
    }

    /**
     * Accesses the Course of the Class
     * @return the Class's Course
     */
    public String getCourse() {
        return Course;
    }

    public Double getCredit() {
        return Credit;
    }


    /**
     * compares two object by the CRN
     * @param o the Classes object that will be compared to this
     * @return an integer with 0 being that they're equal,
     * a -1 meaning that this is less than the object being passed
     * and a 1 meaning that this is greater than the object
     */
    @Override public int compareTo(Classes o) {

        if(Integer.parseInt(this.getCRN()) == Integer.parseInt(o.getCRN())) {

            return 0;

        } else if(Integer.parseInt(this.getCRN()) != Integer.parseInt(o.getCRN())) {

            if(Integer.parseInt(this.getCRN()) < Integer.parseInt(o.getCRN())) {

                return -1;

            }
        }

        return 1;

    }


    /**
     * Prints the results by concatenating the
     * data into one string
     * @return the string in proper format
     */
    @Override public String toString() {
        String result = "CRN: " + CRN
                + "\nCredits: " + Credit
                + "\nSubject: " + Subject
                + "\nCourse: " + Course
                + "\nDays: " + Days
                + "\nTime: " + Time
                + "\nProfessor: " + Prof
                + "\nRating: " + Rating;

        return result;
    }

    /**
     * Determines whether two classes objects are
     * equal by comparing CRN number of the classes
     * @param //object of the second Classes
     * @return whether the Movies are equal
     */
    @Override public boolean equals(Object o) {

        if(o == this) {

            return true;

        } else if(!(o instanceof Classes)) {

            return false;

        } else {

            Classes L = (Classes) o;

            if(this.getCRN().equals(L.getCRN())) {

                return true;
            }

            return false;

        }


    }

    /**
     * Returns a consistent hash code for
     * each Movie by summing the Unicode values
     * of each character in the key
     * Key = title + director
     * @return the hash code
     */
    @Override public int hashCode() {
        int sum = 0;

        String key = CRN;

        for(int i = 0; i < key.length(); i++) {

            sum += (int) key.charAt(i);
        }


        return sum;
    }

    /**
     * Compares two Classes object by the second key (Rating) if the two
     * rating do not match then it will compare
     * by the name of the professor
     * @param o1 the first classes object
     * @param o2 the second classes object
     * @return an integer with 0 being that the objects match,
     * 1 being that o1 is greater than o2 and -1 being that o1
     * is less than o2
     */
    @Override public int compare(Classes o1, Classes o2) {

        if (o1.getRating() == o2.getRating()) {

            return 0;
        } else if (o1.getRating() != o2.getRating()) {

            if (o1.getRating() < o2.getRating()) {

                return -1;

            } else {

                return 1;
            }
        } else {

            return o1.getProf().compareTo(o2.getProf());


        }

    }
}

