package cn.edu.lnnu.gis.rookie.common.exception;

import cn.edu.lnnu.gis.rookie.common.util.StringUtil;
import cn.edu.lnnu.gis.rookie.common.enums.EmBusinessError;
import org.springframework.validation.BindingResult;

public class DataValidate {

    public static void validateRequestParams(BindingResult bindingResult) throws BusinessException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, StringUtil.processValidationErrorString(bindingResult));
        }
    }
}
