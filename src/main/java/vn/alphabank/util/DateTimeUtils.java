package vn.alphabank.util;

import org.apache.logging.log4j.util.Strings;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class DateTimeUtils {
    /**
     * Ham chuyen doi kieu date de truyen di trong webservice *
     *
     * @param dt
     * @return
     * @throws DatatypeConfigurationException
     */
    public static XMLGregorianCalendar convertDate4Ws(Date dt) throws DatatypeConfigurationException {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(dt);
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
    }

    /**
     * Parse string to date by format
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date stringToDate(String dateStr, String format) {
        if (Strings.isBlank(dateStr))
            return null;

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static String convertStringToDateFormat(String date, String format) {
        Date dateIn = stringToDate(date, "yyyy-MM-dd");
        return convertToDateFormat(dateIn, format);
    }

    public static String convertToDateFormat(Date date, String format) {
        if (Objects.isNull(date))
            return null;

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String convertToFolderName(String date) {
        Date dateRequest = stringToDate(date, "dd/MM/yyyy HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String folderName = dateFormat.format(dateRequest);
        return folderName;
    }

    public static String getCurrentDateTime(String format) {
        Date date = new Date();
        return convertToDateFormat(date, format);
    }
}
