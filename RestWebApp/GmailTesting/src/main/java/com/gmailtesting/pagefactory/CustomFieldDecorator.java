package com.gmailtesting.pagefactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class CustomFieldDecorator extends DefaultFieldDecorator {

	public CustomFieldDecorator(SearchContext searchContext) {
		super(new DefaultElementLocatorFactory(searchContext));
	}

	@Override
	public Object decorate(ClassLoader loader, Field field) {
		
		Class<?> clazz = field.getType();
		try {
			clazz.getConstructor(WebElement.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Class<?> decoratableClass = clazz;
		
		
		if (decoratableClass != null) {
			ElementLocator locator = factory.createLocator(field);
			if (locator == null) {
				return null;
			}
			
			WebElement proxy = proxyForLocator(loader, locator);
			try {
				return clazz.getConstructor(WebElement.class).newInstance(proxy);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
}