package cn.edu.cuhk.terra.ccu.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.util.Map;

public class JsonUtil {
    public final static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    public static String readFromResource(String path) throws IOException {
        URL url = JsonUtil.class.getResource(path);
        File file = new File(url.getPath());
        Long fileLength = file.length();
        byte[] fileContent = new byte[fileLength.intValue()];

        FileInputStream in = new FileInputStream(file);
        in.read(fileContent);
        in.close();

        return new String(fileContent, "UTF-8");
    }

    public static String formattedJson(String jsonStr, Map<String, Object> map) {
        String strSwap = jsonStr;

        for (String k : map.keySet()) {
            Object v = map.get(k);
            String regex = (v instanceof String && !k.toUpperCase().contains("EXPRESS")) ? "${%s}" : "\"${%s}\"";
            String varRegex = String.format(regex, k);
            strSwap = strSwap.replace(varRegex, v.toString());
        }

        // 去除express未匹配的行: express 必须单独占用一行
        StringBuilder builder = new StringBuilder();
        for (String line : strSwap.split("\n")) {
            if (!line.toUpperCase().contains("EXPRESS}")) {
                builder.append(line);
                builder.append("\n");
            } else {
                logger.warn("contains express   : Has not been replaced express in json script -> " + line);
            }
        }

        if (builder.toString().contains("${")) {
            throw new RuntimeException("Fail to format json : \n" + builder.toString());
        }

        return builder.toString();
    }


    // JSON拼接字段
    public static String getTerm(String field, Object value) {
        Double boost = 0.1;
        return getTerm(field, value, boost);
    }

    public static String getTerm(String field, Object value, Double boost) {
        String regex = (value instanceof String) ? "{\"term\": {\"%s\": { \"value\": \"%s\", \"boost\": %s}}}" : "{\"term\": {\"%s\": { \"value\": %s, \"boost\": %s}}}";
        return String.format(regex, field, value, boost);
    }

    // JSON拼接字段
    public static String getMatch(Object keyword) {
        Double boost = 0.1;
        String field = "name";
        return getMatch(field, keyword, boost);

    }

    public static String getMatch(String field, Object keyword, Double boost) {
        String regex = (keyword instanceof String) ? "{\"match\": {\"%s\": {\"query\": \"%s\",\"boost\": %s}}}" : "{\"match\": {\"%s\": {\"query\": %s, \"boost\": %s}}}";
        return String.format(regex, field, keyword, boost);
    }

    public static String getFilterOrderExpress(String field, Object value, Double wight) {
        String regex = "{\"filter\": {\"term\": {\"%s\": { \"value\": %s}}}, \"weight\": %s}";
        return String.format(regex, field, value, wight);
    }

}
