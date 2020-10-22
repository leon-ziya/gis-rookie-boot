package cn.edu.lnnu.gis.rookie.common.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil {
    // MD5加密
    public static String encodeByMd5(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(messageDigest.digest(str.getBytes("utf-8")));
    }

    // 处理字段校验失败信息
    public static String processValidationErrorString(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError fieldError: bindingResult.getFieldErrors()) {
            stringBuilder.append(fieldError.getDefaultMessage() + ",");
        }

        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
