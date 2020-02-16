package com.miles.lottery.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MethodConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.miles.lottery.bean.MethodParasBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * dubbo配置工具，用于获取dubbo 服务
 *
 * @author Hale
 */
@Component("dubboConfig")
public class DubboConfig {

    /**
     * 系统服务名称
     */
    @Value("${application.name}")
    private String applicationName;

    /**
     * 服务的拥有者
     */
    @Value("${application.owner}")
    private String applicationOwner;

    /**
     * zk地址
     */
    @Value("${zookeeper}")
    private String zookeeper;

    /**
     * 超时时间
     */
    @Value("${server.timeout}")
    private Integer serverTimeout;

    /**
     * 默认的组织，fql
     */
    private String organization = "fql";

    private static ApplicationConfig selfApplicationConfig = null;
    private static RegistryConfig selfRegistryConfig = null;

    /**
     * Destroy dubbo invoker bean in the ReferenceCache. 销毁缓存起来的dubbo invoker
     *
     * @param interfaceName 接口名字
     * @param version       接口版本号。
     * @param timeOut       超时时间。
     */
    public void destroy(String interfaceName, String group, String version, Integer timeOut) {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setApplication(getApplicationConfig());
        reference.setRegistry(getRegisterConfig());
        reference.setInterface(interfaceName); // 弱类型接口名
        reference.setVersion(version);
        reference.setGroup(group);
        reference.setTimeout(serverTimeout);
        if (timeOut != null) {
            reference.setTimeout(timeOut);
        }
        reference.setGeneric(true); // 声明为泛化接口

        ReferenceConfigCache.getCache().destroy(reference);
    }

    /**
     * Get the dubbo invoker from the ReferenceCache, If existed, or create a
     * new one. 根据接口名字跟版本号获取dubbo invoker
     *
     * @param interfaceName 接口名字
     * @param version       接口版本号
     * @param timeOut       接口超时时间
     * @return 返回接口跟版本对应的dubbo invoker
     */
    public GenericService getService(String interfaceName, String group, String version, String protocol, Integer timeOut, List<MethodParasBean> methods) {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setApplication(getApplicationConfig());
        reference.setRegistry(getRegisterConfig());
        reference.setInterface(interfaceName); // 弱类型接口名
        reference.setVersion(version);
        reference.setGroup(group);
        reference.setProtocol(protocol);
        reference.setTimeout(serverTimeout);
        if (timeOut != null) {
            reference.setTimeout(timeOut);
        }

        if (null != methods && !methods.isEmpty()) {
            List<MethodConfig> list = new ArrayList<>();

            for (MethodParasBean mp : methods) {
                MethodConfig methodConfig = new MethodConfig();
                methodConfig.setName(mp.getMethod());
                methodConfig.setValidation(Boolean.FALSE.toString());
                methodConfig.setTimeout(mp.getTimeout());
                list.add(methodConfig);
            }
            reference.setMethods(list);
        }

        reference.setGeneric(true); // 声明为泛化接口

        return ReferenceConfigCache.getCache().get(reference);
    }

    /**
     * Get applicationConfig.
     * <p>
     * 生成dubbo用的applicationConfig信息
     *
     * @return 生成applicationConfig信息
     */
    public ApplicationConfig getApplicationConfig() {
        if (selfApplicationConfig != null) {
            return selfApplicationConfig;
        } else {
            synchronized (this) {
                if (selfApplicationConfig != null) {
                    return selfApplicationConfig;
                }
                ApplicationConfig applicationConfig = new ApplicationConfig();
                applicationConfig.setName(applicationName);
                applicationConfig.setOwner(applicationOwner);
                applicationConfig.setOrganization(organization);
                selfApplicationConfig = applicationConfig;
            }
            return selfApplicationConfig;
        }
    }

    /**
     * Get Registry Info. 获取dubbo相关注册配置信息
     *
     * @return 返回dubbo的注册配置信息
     */
    public RegistryConfig getRegisterConfig() {
        if (null != selfRegistryConfig) {
            return selfRegistryConfig;
        } else {
            synchronized (this) {
                if (null != selfRegistryConfig) {
                    return selfRegistryConfig;
                }

                RegistryConfig registry = new RegistryConfig();
                registry.setAddress(zookeeper);
                registry.setRegister(false);
                selfRegistryConfig = registry;
            }

            return selfRegistryConfig;
        }
    }

}
