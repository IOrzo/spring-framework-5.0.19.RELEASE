package org.springframework.xx;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xie yuan bing
 * @date 2020-11-09 15:31
 * @description
 */
public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private Set<String> obscenities;

	public ObscenityRemovingBeanFactoryPostProcessor(){
		this.obscenities = new HashSet<>();
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanNames = beanFactory.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
			StringValueResolver valueResolver = new StringValueResolver() {
				@Override
				public String resolveStringValue(String strVal) {
					if (isObscene(strVal)) {
						return "******";
					}
					return strVal;
				}
			};
			BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
			visitor.visitBeanDefinition(bd);
		}
	}

	public boolean isObscene (Object value) {
		String potentialObscenity = value.toString().toUpperCase();
		return this.obscenities.contains(potentialObscenity);
	}

	public void setObscenities(Set<String> obscenities) {
		this.obscenities.clear();
		for (String obscenity : obscenities) {
			this.obscenities.add(obscenity.toUpperCase());
		}
	}
}
