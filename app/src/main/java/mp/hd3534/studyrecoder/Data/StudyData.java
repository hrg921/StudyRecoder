package mp.hd3534.studyrecoder.Data;

/**
 * Created by hangeonho on 16. 8. 22..
 */
public class StudyData {

    private int _id;
    private int year;
    private int month;
    private int date;
    private int hour;
    private int minute;
    private int second;

    public StudyData(int year, int month, int date, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.date = date;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public StudyData(int _id, int year, int month, int date, int hour, int minute, int second) {
        this(year, month, date, hour, minute, second);
        this._id = _id;
    }

    public int get_id() {
        return _id;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
}
