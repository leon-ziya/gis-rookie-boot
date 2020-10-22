package cn.edu.lnnu.gis.rookie.modules.demo.controller;

import cn.edu.lnnu.gis.rookie.common.exception.BusinessException;
import cn.edu.lnnu.gis.rookie.common.enums.EmBusinessError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "CCU管理控制台-功能测试")
@RestController
@RequestMapping("/test/admin")
public class HelloCcuController {

    @ApiOperation("演示hello方法")
    @GetMapping(value="/hello")
    public Result<String> hello(){
        Result<String> result = new Result<>();
        result.setResult("hello word!");
        result.setSuccess(true);
        return result;
    }

    @ApiOperation("演示一个报错")
    @GetMapping(value="/createAnError")
    public Result<String> createAnError(){
        Result<String> result = new Result<>();
        result.setResult("hello word!");
        result.setSuccess(true);

        if (true) {
            throw new RuntimeException("演示一个报错..");
        }

        return result;
    }

    @ApiOperation("演示自定义报错")
    @GetMapping(value="/createKnownError")
    public Result<String> createKnownError(){
        Result<String> result = new Result<>();
        result.setResult("hello word!");
        result.setSuccess(true);

        if (true) {
            throw new BusinessException(EmBusinessError.UNKNOWN_ERROR);
        }

        return result;
    }

    @AutoLog(value = "向在线管理写入日志")
    @ApiOperation("在线日志显示")
    @GetMapping(value="/onlineLog")
    public Result<String> onlineLog(){
        Result<String> result = new Result<>();
        result.setResult("日志在线显示!");
        result.setSuccess(true);
        return result;
    }


}
