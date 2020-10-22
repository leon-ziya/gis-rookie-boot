package cn.edu.lnnu.gis.rookie.common.exception;

import cn.edu.lnnu.gis.rookie.common.enums.EmBusinessError;
import lombok.Data;


@Data
public class CommonError {
    // 错误码
    private Integer errCode;

    // 错误描述
    private String errMsg;

    public CommonError(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public CommonError(EmBusinessError emBusinessError) {
        this.errCode = emBusinessError.getErrCode();
        this.errMsg = emBusinessError.getErrMsg();
    }
}
