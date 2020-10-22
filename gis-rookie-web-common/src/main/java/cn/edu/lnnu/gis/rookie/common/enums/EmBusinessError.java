package cn.edu.lnnu.gis.rookie.common.enums;


public enum EmBusinessError {
    // 通用的错误类型
    NO_OBJECT_FOUND(10001, "请求对象不存在"),
    NO_HANDLER_FOUND(10002, "找不到执行的路径操作"),
    BIND_EXCEPTION_ERROR(10003, "请求参数错误"),
    PARAMETER_VALIDATION_ERROR(10004, "请求参数校验失败"),
    UNSUPPORTED_METHOD(10005, "请求方法未支持"),
    UNSUPPORTED_MEDIA_CONTENT_TYPE(10006, "不支持的Content type"),
    UNKNOWN_ERROR(10099, "未知的异常"),

    // 用户服务相关的错误类型
    REGISTER_DUP_FAIL(20001, "用户已存在"),
    LOGIN_BY_TELEPHONE_FAIL(20002, "登陆手机号或密码错误"),
    LOGIN_BY_EMAIL_FAIL(20003, "登陆邮箱或密码错误"),
    SELLER_IS_NOT_EXISTS(20004, "商户不存在"),
    DISABLED_SHELLER_FAIL(20005, "商户已禁用"),

    // 权限相关错误类型
    ADMIN_PERMISSION_CHECK_CONTENT_TYPE_ERROR(30001, "admin权限仅支持 text/html 类型"),
    ADMIN_SHOULD_LONG_ERROR(30002, "管理员需要先登陆"),

    // 定义新的错误类型

    ;
    private Integer errCode;
    private String errMsg;

    EmBusinessError(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
