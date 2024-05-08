package com.thorn.bbs.security.component;


import cn.hutool.core.collection.CollUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thorn.bbs.modules.ums.model.UmsResource;
import com.thorn.bbs.modules.ums.model.UmsResourceCategory;
import com.thorn.bbs.modules.ums.service.UmsResourceCategoryService;
import com.thorn.bbs.modules.ums.service.UmsResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>描述: 资源初始化 </p>
 * <p>创建时间: 2024/5/8 14:38 </p>
 *
 * @author thorn.lin
 * @version v1.0
 **/
@Component
public class ResourceInitManager implements ApplicationContextAware {

    @Resource
    private UmsResourceService resourceService;

    @Resource
    private UmsResourceCategoryService categoryService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> controllers = applicationContext.getBeansWithAnnotation(RestController.class);

        //缓存
        Map<String, UmsResourceCategory> map = Maps.newHashMap();
        List<UmsResourceCategory> umsResourceCategories = categoryService.listAll();
        if (CollUtil.isNotEmpty(umsResourceCategories)) {
            map = umsResourceCategories.stream().collect(Collectors.toMap(UmsResourceCategory::getName, c -> c));
        }
        Map<String, UmsResource> resouceMap = Maps.newHashMap();
        List<UmsResource> umsResources = resourceService.list();
        if (CollUtil.isNotEmpty(umsResources)) {
            resouceMap = umsResources.stream().collect(Collectors.toMap(UmsResource::getUrl, c -> c));
        }

        List<UmsResource> wait4CreateResource = Lists.newArrayList();
        //遍历每个controller层
        for (Map.Entry<String, Object> entry : controllers.entrySet()) {
            Object value = entry.getValue();
            Class<?> controllerClass = AopUtils.getTargetClass(value);
            Api annotation = controllerClass.getAnnotation(Api.class);
            String key = annotation.description().concat("-").concat(controllerClass.getSimpleName());
            UmsResourceCategory umsResourceCategory = null;
            if (!map.containsKey(key)) {
                umsResourceCategory = new UmsResourceCategory();
                umsResourceCategory.setName(key);
                umsResourceCategory.setSort(0);
                categoryService.save(umsResourceCategory);
            } else {
                umsResourceCategory = map.remove(key);
            }

            //添加资源
            RequestMapping baseMapping = controllerClass.getAnnotation(RequestMapping.class);
            String[] basePaths = baseMapping.path();

            Method[] methods = controllerClass.getMethods();
            for (Method method : methods) {
                RequestMapping subMapping = method.getAnnotation(RequestMapping.class);
                ApiOperation apiMapping = method.getAnnotation(ApiOperation.class);
                String[] subPaths = subMapping.path();

                for (String basePath : basePaths) {
                    for (String subPath : subPaths) {
                        String url = basePath.concat("/").concat(subPath).replace("//", "/");
                        if (!resouceMap.containsKey(url)) {
                            UmsResource umsResource = new UmsResource();
                            umsResource.setUrl(url);
                            umsResource.setName(apiMapping.value());
                            umsResource.setDescription(apiMapping.value());
                            umsResource.setCategoryId(umsResourceCategory.getId());
                            wait4CreateResource.add(umsResource);
                        } else {
                            resouceMap.remove(url);
                        }

                    }
                }
            }

        }

        if (CollUtil.isNotEmpty(map)) {
            categoryService.removeByIds(map.values().stream().map(UmsResourceCategory::getId).collect(Collectors.toList()));
        }
        resourceService.saveBatch(wait4CreateResource);
        if (CollUtil.isNotEmpty(resouceMap)) {
            resourceService.removeByIds(resouceMap.values().stream().map(UmsResource::getId).collect(Collectors.toList()));
        }

    }
}