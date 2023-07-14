package net.fkm.livepushertest.utils;

import net.fkm.livepushertest.application.LivePusherApplication;

public class AliyunPushUtils {

    /**
     * 推流域名 阿里云配置的推流域名
     */
    private static final String pushDomain = "auction-android.code520.com.cn";
    /**
     * 拉流域名 阿里云配置的拉流域名
     */
    private static final String pullDomain = "auction-live.code520.com.cn";
    /**
     * appName
     */
    private static final String appName = "auction-android";
    /**
     * 鉴权key: 阿里云创建了推流域名和播流域名过后，他给生成的，每个域名一个，
     * 推流用推流的key，播流用播流的key
     */
    private static final String pushKey = "V4gQlNcpJ24oltqD";
    private static final String pullKey = "e4tb88mNR5aF76yX";

    /**
     * @param time 十位数的时间戳
     * @return 推流的地址
     */
    public static String CreatePushUrl(String streamName, String time) {

        String strpush = "/" + appName + "/" + streamName + "-" + time + "-0-0-" + pushKey;
        String pushUrl = "rtmp://" + pushDomain + "/" + appName + "/" + streamName + "?auth_key=" + time + "-0-0-" + MD5Utils.getMD5(strpush);
        return pushUrl;
    }

    /**
     * @param time 十位数的时间戳
     *             //     * @param rand       这是用来标识的 否则同一个时间戳 生成的地址总是相同的
     *             随机数，建议使用UUID（不能包含中划线“-”，例如： 477b3bbc253f467b8def6711128c7bec 格式）
     * @return 播放流的地址 默认是flv  也可以更改此代码
     */
    public static String GetPlayUrl(String streamName, String time) {

//        String strviewrtmp1 = null;
//        String strviewflv1 = null;
//        String strviewm3u81 = null;
        String strviewrts1 = null;

//        String rtmpurl1 = null;
//        String flvurl1 = null;
//        String m3u8url1 = null;
        String rtsurl1 = null;

//        strviewrtmp1 = "/" + appName + "/" + streamName + "-" + time + "-0-0-" + pullKey;
//        strviewflv1 = "/" + appName + "/" + streamName + ".flv-" + time + "-0-0-" + pullKey;
//        strviewm3u81 = "/" + appName + "/" + streamName + ".m3u8-" + time + "-0-0-" + pullKey;
        strviewrts1 = "/" + appName + "/" + streamName + "-" + time + "-0-0-" + pullKey;

//        String rtmpAuthKey = time + "-0-0-" + MD5Utils.getMD5(strviewrtmp1);
//        String flvAuthKey = time + "-0-0-" + MD5Utils.getMD5(strviewflv1);
//        String m3u8AuthKey = time + "-0-0-" + MD5Utils.getMD5(strviewm3u81);
        String rtsAuthKey = time + "-0-0-" + MD5Utils.getMD5(strviewrts1);
//        rtmpurl1 = "rtmp://" + pullDomain + "/" + appName + "/" + streamName + "?auth_key=" + rtmpAuthKey;
//        flvurl1 = "http://" + pullDomain + "/" + appName + "/" + streamName + ".flv?auth_key=" + flvAuthKey;
//        m3u8url1 = "http://" + pullDomain + "/" + appName + "/" + streamName + ".m3u8?auth_key=" + m3u8AuthKey;
        rtsurl1 = "artc://" + pullDomain + "/" + appName + "/" + streamName + "?auth_key=" + rtsAuthKey;


        return rtsurl1;

    }

}
