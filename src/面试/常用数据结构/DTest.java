package 面试.常用数据结构;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
用户使用 Keep进行训练后，会把训练记录保存到服务器。Keep 服务器记录了每条训练记录的用户名、训练开始时间和训练结束时间。
我们希望制作一个用户训练时长的排行榜,按平均训练时长降序排序。当用户训练时长相同时,按用户名升序排序。
在计算时,有如下要求
1.平均训练时长精确到分钟，向下取整
2.训练时长大于等于24小时的训练数据将被视为无效数据，不计入统计
3.如果—个用户没有有效的训练记录，则他不计入排行榜中
 */
public class DTest {
    public String[] findRankingList(String[] nameList, String[] startTimeList, String[] endTimeList) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < nameList.length; i++) {
            try {
                int time = map.getOrDefault(nameList[i], 0) + totalTime(startTimeList[i], endTimeList[i]);
                if(time == 0) {
                    continue;
                }
                map.put(nameList[i], time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        TreeMap<Integer, String> sort = new TreeMap<>();
        for (String mame : map.keySet()) {
            sort.put(map.get(mame), mame);
        }
        return sort.values().toArray(new String[0]);
    }
    public static int totalTime(String startTime,String endTime) throws ParseException {
        SimpleDateFormat formatter =   new SimpleDateFormat( "yyyy-MM-dd" );
        Date startDate = formatter.parse(startTime);
        long st = startDate.getTime();
        Date endDate =  formatter.parse(endTime);
        long et = endDate.getTime();
        long ts2 = et - st;
        if(ts2 >= 60*24) {
            return 0;
        }
        return (int) ( ts2 / (60 * 1000));
    }
}
