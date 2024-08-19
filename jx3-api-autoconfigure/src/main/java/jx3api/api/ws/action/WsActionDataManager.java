package jx3api.api.ws.action;

import jx3api.api.ws.data.BaseWsData;
import jx3api.api.ws.data.WsActionData;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ws action 管理类
 *
 * @author Grafie
 * @since 1.0.0
 */
public class WsActionDataManager {
    /**
     * 处理器集合
     */
    private static final Map<Integer, Class<BaseWsData>> ACTION_DATA_MAP = new HashMap<>();

    /**
     * 初始化
     */
    public void init(List<String> scanBasePackage) throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        // 创建 ClassPathScanningCandidateComponentProvider 对象
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        // 添加过滤器，只扫描指定注解的组件
        scanner.addIncludeFilter(new AnnotationTypeFilter(WsActionData.class));
        // 扫描指定包下的所有候选组件
        Set<AnnotatedBeanDefinition> annotatedBeanDefinitions = new HashSet<>();
        for (String basePackage : scanBasePackage) {
            annotatedBeanDefinitions.addAll(findAnnotatedBeanDefinitions(scanner, basePackage));
        }
        // 查询注解参数及实例化对象
        for (AnnotatedBeanDefinition annotatedBeanDefinition : annotatedBeanDefinitions) {
            String componentName = annotatedBeanDefinition.getBeanClassName();
            AnnotationMetadata annotationMetadata = annotatedBeanDefinition.getMetadata();
            Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(WsActionData.class.getName());
            Object newInstance = Class.forName(componentName).getDeclaredConstructor().newInstance();
            if (newInstance instanceof BaseWsData) {
                ACTION_DATA_MAP.put((int) annotationAttributes.get("actionCode"), (Class<BaseWsData>) newInstance.getClass());
            }
        }
    }

    private static Set<AnnotatedBeanDefinition> findAnnotatedBeanDefinitions(ClassPathScanningCandidateComponentProvider scanner, String basePackage) {
        Set<AnnotatedBeanDefinition> annotatedBeanDefinitions = new HashSet<>();
        // 扫描指定包下的所有候选组件
        for (BeanDefinition beanDefinition : scanner.findCandidateComponents(basePackage)) {
            if (beanDefinition instanceof AnnotatedBeanDefinition) {
                annotatedBeanDefinitions.add((AnnotatedBeanDefinition) beanDefinition);
            }
        }
        return annotatedBeanDefinitions;
    }

    /**
     * 根据actionCode获取解析器
     *
     * @param action ws事件中的action
     * @return 对应的处理器
     */
    public static Class<BaseWsData> getWsDataByAction(Integer action) {
        return ACTION_DATA_MAP.get(action);
    }
}
