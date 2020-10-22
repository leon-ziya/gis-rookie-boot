package cn.edu.lnnu.gis.rookie.modules.device.vehicle.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lnnu.gis.rookie.modules.device.vehicle.entity.CcuSysAutoDrivedVehicle;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import cn.edu.lnnu.gis.rookie.modules.device.vehicle.service.ICcuSysAutoDrivedVehicleService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 自动驾驶车辆
 * @Author: jeecg-boot
 * @Date:   2020-07-16
 * @Version: V1.0
 */
@Api(tags="自动驾驶车辆")
@RestController
@RequestMapping("/device/vehicle/ccuSysAutoDrivedVehicle")
@Slf4j
public class CcuSysAutoDrivedVehicleController extends JeecgController<CcuSysAutoDrivedVehicle, ICcuSysAutoDrivedVehicleService> {
	@Autowired
	private ICcuSysAutoDrivedVehicleService ccuSysAutoDrivedVehicleService;

	/**
	 * 分页列表查询
	 *
	 * @param ccuSysAutoDrivedVehicle
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "自动驾驶车辆-分页列表查询")
	@ApiOperation(value="自动驾驶车辆-分页列表查询", notes="自动驾驶车辆-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(CcuSysAutoDrivedVehicle ccuSysAutoDrivedVehicle,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CcuSysAutoDrivedVehicle> queryWrapper = QueryGenerator.initQueryWrapper(ccuSysAutoDrivedVehicle, req.getParameterMap());
		Page<CcuSysAutoDrivedVehicle> page = new Page<CcuSysAutoDrivedVehicle>(pageNo, pageSize);
		IPage<CcuSysAutoDrivedVehicle> pageList = ccuSysAutoDrivedVehicleService.page(page, queryWrapper);
		return Result.ok(pageList);
	}

	/**
	 *   添加
	 *
	 * @param ccuSysAutoDrivedVehicle
	 * @return
	 */
	@AutoLog(value = "自动驾驶车辆-添加")
	@ApiOperation(value="自动驾驶车辆-添加", notes="自动驾驶车辆-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody CcuSysAutoDrivedVehicle ccuSysAutoDrivedVehicle) {
		ccuSysAutoDrivedVehicleService.save(ccuSysAutoDrivedVehicle);
		return Result.ok("添加成功！");
	}

	/**
	 *  编辑
	 *
	 * @param ccuSysAutoDrivedVehicle
	 * @return
	 */
	@AutoLog(value = "自动驾驶车辆-编辑")
	@ApiOperation(value="自动驾驶车辆-编辑", notes="自动驾驶车辆-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody CcuSysAutoDrivedVehicle ccuSysAutoDrivedVehicle) {
		ccuSysAutoDrivedVehicleService.updateById(ccuSysAutoDrivedVehicle);
		return Result.ok("编辑成功!");
	}

	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "自动驾驶车辆-通过id删除")
	@ApiOperation(value="自动驾驶车辆-通过id删除", notes="自动驾驶车辆-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		ccuSysAutoDrivedVehicleService.removeById(id);
		return Result.ok("删除成功!");
	}

	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "自动驾驶车辆-批量删除")
	@ApiOperation(value="自动驾驶车辆-批量删除", notes="自动驾驶车辆-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.ccuSysAutoDrivedVehicleService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}

	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "自动驾驶车辆-通过id查询")
	@ApiOperation(value="自动驾驶车辆-通过id查询", notes="自动驾驶车辆-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		CcuSysAutoDrivedVehicle ccuSysAutoDrivedVehicle = ccuSysAutoDrivedVehicleService.getById(id);
		if(ccuSysAutoDrivedVehicle==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(ccuSysAutoDrivedVehicle);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param ccuSysAutoDrivedVehicle
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CcuSysAutoDrivedVehicle ccuSysAutoDrivedVehicle) {
        return super.exportXls(request, ccuSysAutoDrivedVehicle, CcuSysAutoDrivedVehicle.class, "自动驾驶车辆");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CcuSysAutoDrivedVehicle.class);
    }

}
