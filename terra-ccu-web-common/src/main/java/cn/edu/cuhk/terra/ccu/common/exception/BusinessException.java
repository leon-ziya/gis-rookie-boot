package cn.edu.cuhk.terra.ccu.common.exception;

import cn.edu.cuhk.terra.ccu.common.enums.EmBusinessError;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private CommonError commonError;

    // TODO: 停止使用简单的错误描述
    /*public BusinessException(String message){
        super(message);
    }

    public BusinessException(Throwable cause)
    {
        super(cause);
    }

    public BusinessException(String message, Throwable cause)
    {
        super(message,cause);
    }*/

    public BusinessException(EmBusinessError emBusinessError) {
        super(emBusinessError.getErrCode() + ",\t" + emBusinessError.getErrMsg());
        this.commonError = new CommonError(emBusinessError);
    }

    public BusinessException(EmBusinessError emBusinessError, String errMsg) {
        super(emBusinessError.getErrCode() + ",\t" + errMsg);
        this.commonError = new CommonError(emBusinessError);
        this.commonError.setErrMsg(errMsg);
    }

    public CommonError getCommonError() {
        return commonError;
    }
}
