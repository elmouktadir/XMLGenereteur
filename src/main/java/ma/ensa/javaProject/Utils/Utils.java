package ma.ensa.javaProject.Utils;

public class Utils {
    public static java.sql.Date getSqlDate(java.util.Date javaDate){
        return new java.sql.Date(javaDate.getTime());
    }
}
