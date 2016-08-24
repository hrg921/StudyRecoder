package mp.hd3534.studyrecoder.Data;

import java.util.List;

/**
 * Created by hangeonho on 16. 8. 24..
 */
public class DataProcessHelper {

    public static int getHourSumByList(List<StudyData> studyDataList) {
        double hourSum = 0;

        for (StudyData studyData : studyDataList) {
            hourSum += studyData.getHour() + studyData.getMinute()/60 + studyData.getSecond()/3600;
        }

        return (int)hourSum;
    }

    public static int getMinuteSumByList(List<StudyData> studyDataList) {
        double minuteSum = 0;

        for (StudyData studyData : studyDataList) {
            minuteSum += studyData.getHour()*60 + studyData.getMinute() + studyData.getSecond()/60;
        }

        return (int)minuteSum;
    }

    public static int getHourSumByDay(StudyData studyData) {
        return studyData.getHour() + studyData.getMinute()/60 + studyData.getSecond()/3600;
    }

    public static int getMinuteSumByDay(StudyData studyData) {
        return studyData.getHour()*60 + studyData.getMinute() + studyData.getSecond()/60;
    }

}
