package cn.com.sweetcandy.dubbox.controller;

import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.com.sweetcandy.dubbox.service.DubboxService;

@RestController
public class HomeController {
	@Reference(version = "1.0.0")
	DubboxService dubboxService;

	@RequestMapping("/")
	public Object index() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		return "当前时间为:" + df.format(dubboxService.getDate());
	}
}
