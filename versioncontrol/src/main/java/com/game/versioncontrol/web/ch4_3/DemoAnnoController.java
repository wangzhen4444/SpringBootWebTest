package com.game.versioncontrol.web.ch4_3;

import javax.servlet.http.HttpServletRequest;

import com.game.versioncontrol.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller // 1 注解声明此类是一个控制器
@RequestMapping("/anno") //2映射此类的访问路径
public class DemoAnnoController {

	@RequestMapping(produces = "text/plain;charset=UTF-8")	// 3此方法未标注路径，因此使用类级别的路径/anno；produce可定制返回的response的媒体类型和字符集，或需返回值是json对象
	public @ResponseBody String index(HttpServletRequest request) { // 4演示可接受HttpServletRequest 作为参数，当然也可以接受HttpServletReponse作为参数。
		return "url:" + request.getRequestURL() + " can access";
	}

	@RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")// 5演示接受路径参数，并在方法参数前结合@PathVariable 使用，访问路径为/anno/pathvar/xx
	public @ResponseBody String demoPathVar(@PathVariable String str, //3
			HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access,str: " + str;
	}

	@RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8") //6演示常规的request参数获取，访问路径为/anno/requestParam?id=1
	public @ResponseBody String passRequestParam(Long id,
			HttpServletRequest request) {
		
		return "url:" + request.getRequestURL() + " can access,id: " + id;

	}

	@RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")//7演示解释参数到对象，访问路径为/anno/obj?id=1&name=xd
	@ResponseBody //8也可以用在方法上
		public String passObj(DemoObj obj, HttpServletRequest request) {
		
		 return "url:" + request.getRequestURL() 
		 			+ " can access, obj id: " + obj.getId()+" obj name:" + obj.getName();

	}

	@RequestMapping(value = { "/name1", "/name2" }, produces = "text/plain;charset=UTF-8")//9演示映射不同的路径到相同的方法
	public @ResponseBody String remove(HttpServletRequest request) {
		
		return "url:" + request.getRequestURL() + " can access";
	}

}
