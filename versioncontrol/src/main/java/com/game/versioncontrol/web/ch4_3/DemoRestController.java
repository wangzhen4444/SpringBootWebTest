package com.game.versioncontrol.web.ch4_3;

import com.game.versioncontrol.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //1声明是控制器，并且返回数据时不需要@ResponseBody
@RequestMapping("/rest")
public class DemoRestController {
	
	@RequestMapping(value = "/getjson",
			produces={"application/json;charset=UTF-8"}) //2返回数据的媒体类型为json
	public DemoObj getjson (DemoObj obj){
		return new DemoObj(obj.getId()+1, obj.getName()+"yy");//3直接返回对象，对象会自动转换成json
	}
	@RequestMapping(value = "/getxml",
			produces={"application/xml;charset=UTF-8"})//4返回数据的媒体类型为xml
	public DemoObj getxml(DemoObj obj){
		return new DemoObj(obj.getId()+1, obj.getName()+"yy");//5直接返回对象，对象会自动转换成xml
	}

}
