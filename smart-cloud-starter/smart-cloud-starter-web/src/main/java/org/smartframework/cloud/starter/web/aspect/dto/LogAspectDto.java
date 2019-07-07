package org.smartframework.cloud.starter.web.aspect.dto;

import java.util.Date;

import org.smartframework.cloud.starter.common.business.dto.BaseDto;
import org.smartframework.cloud.starter.common.business.security.dto.ReqHttpHeadersDto;
import org.smartframework.cloud.utility.DateUtil;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * 普通接口（除了feign以外的接口）切面日志Dto
 *
 * @author liyulin
 * @date 2019年4月9日下午5:00:23
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class LogAspectDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	/** 接口描述 */
	private String apiDesc;

	/** 调用的类方法 */
	private String classMethod;

	/** 请求发起时间 */
	@JSONField(format = DateUtil.FOROMAT_DATETIME_HH_MM_SS_SSS)
	private Date reqStartTime;

	/** 请求结束时间 */
	@JSONField(format = DateUtil.FOROMAT_DATETIME_HH_MM_SS_SSS)
	private Date reqEndTime;

	/** 请求处理时间,毫秒 */
	private Integer reqDealTime;

	/** 请求的参数信息 */
	private Object reqParams;
	
	/** 请求头 */
	private ReqHttpHeadersDto reqHttpHeaders;

	/** 响应数据 */
	private Object respData;
	
	/** 接口url */
	private String url;

	/** http请求方式 */
	private String httpMethod;

	/** 客户IP地址 */
	private String ip;

	/** 操作系统相关信息 */
	private String os;

	/** 异常堆栈信息 */
	private String exceptionStackInfo;

}