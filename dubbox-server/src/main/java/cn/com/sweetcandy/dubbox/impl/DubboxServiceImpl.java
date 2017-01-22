package cn.com.sweetcandy.dubbox.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import cn.com.sweetcandy.dubbox.service.DubboxService;

@Component
@Service(version = "1.0.0")
public class DubboxServiceImpl implements DubboxService {

	public Date getDate() {
		System.out.println(111);
		return new Date();
	}

}
