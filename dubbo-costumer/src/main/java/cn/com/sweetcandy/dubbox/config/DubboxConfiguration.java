package cn.com.sweetcandy.dubbox.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.rpc.Exporter;

@Configuration
@ConditionalOnClass(Exporter.class)
public class DubboxConfiguration {
	@Value("${dubbo.application.name}")
	private String applicationName;

	@Value("${dubbo.registr.protocol}")
	private String protocol;

	@Value("${dubbo.registry.address}")
	private String registryAddress;

	@Value("${dubbo.protocol.name}")
	private String protocolName;

	@Value("${dubbo.protocol.port}")
	private int protocolPort;

	@Value("${dubbo.provider.timeout}")
	private int timeout;

	/**
	 * 设置dubbo扫描包
	 * 
	 * @param packageName
	 * @return
	 */
	@Bean
	public static AnnotationBean annotationBean(@Value("${dubbo.annotation.package}") String packageName) {
		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setPackage(packageName);
		return annotationBean;
	}

	/**
	 * 注入dubbo上下文
	 * 
	 * @return
	 */
	@Bean
	public ApplicationConfig applicationConfig() {
		// 当前应用配置
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName(this.applicationName);
		return applicationConfig;
	}

	/**
	 * 注入dubbo注册中心配置,基于zookeeper
	 * 
	 * @return
	 */
	@Bean
	public RegistryConfig registryConfig() {
		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setProtocol(protocol);
		registry.setAddress(registryAddress);
		return registry;
	}

	/**
	 * 默认基于dubbo协议提供服务
	 * 
	 * @return
	 */
	/*
	 * @Bean public ProtocolConfig protocolConfig() { // 服务提供者协议配置
	 * ProtocolConfig protocolConfig = new ProtocolConfig();
	 * protocolConfig.setName(protocolName);
	 * protocolConfig.setPort(protocolPort); protocolConfig.setThreads(200);
	 * System.out.println("默认protocolConfig：" + protocolConfig.hashCode());
	 * return protocolConfig; }
	 */

	/**
	 * dubbo消费
	 * 
	 * @param applicationConfig
	 * @param registryConfig
	 * @param protocolConfig
	 * @return
	 */
	@Bean(name = "defaultConsumer")
	public ConsumerConfig providerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig) {
		ConsumerConfig providerConfig = new ConsumerConfig();
		return providerConfig;
	}

}
