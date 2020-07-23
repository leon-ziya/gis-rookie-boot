package cn.edu.cuhk.terra.ccu.common.exception;

import cn.edu.cuhk.terra.ccu.common.enums.EmBusinessError;
import cn.edu.cuhk.terra.ccu.common.util.StringUtil;
import org.springframework.validation.BindingResult;

public class DataValidate {

    public static void validateRequestParams(BindingResult bindingResult) throws BusinessException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, StringUtil.processValidationErrorString(bindingResult));
        }
    }
}
