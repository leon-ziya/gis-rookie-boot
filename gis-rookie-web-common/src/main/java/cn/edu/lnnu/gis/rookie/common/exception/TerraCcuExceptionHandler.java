package cn.edu.lnnu.gis.rookie.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @Author scott
 * @Date 2019
 */
@RestControllerAdvice
@Slf4j
public class TerraCcuExceptionHandler {

	/**
	 * 处理一切未定义的报错
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public Result<?> handleException(Exception e){
		return Result.error("操作失败，"+e.getMessage());
	}

	/**
	 * 处理业务逻辑中的异常
	 */
	@ExceptionHandler(BusinessException.class)
	public Result<?> handleBusinessException(BusinessException e){
		return Result.error(e.getCommonError().getErrCode(), e.getCommonError().getErrMsg());
	}

}
