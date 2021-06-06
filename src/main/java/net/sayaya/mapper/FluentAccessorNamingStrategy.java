package net.sayaya.mapper;

import org.mapstruct.ap.spi.DefaultAccessorNamingStrategy;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.TypeKind;
import java.beans.Introspector;

public class FluentAccessorNamingStrategy extends DefaultAccessorNamingStrategy {
	@Override
	public boolean isGetterMethod(ExecutableElement method) {
		if(method.getParameters().isEmpty() && !method.getReturnType().toString().equals( method.getEnclosingElement().asType().toString())) return method.getReturnType().getKind() != TypeKind.VOID;
		return super.isGetterMethod(method);
	}
	@Override
	public boolean isSetterMethod(ExecutableElement method) {
		String methodName = method.getSimpleName().toString();
		return methodName.startsWith( "set" ) && methodName.length() > 3 || isBuilderSetter( method );
	}
	protected boolean isBuilderSetter(ExecutableElement method) {
		return method.getParameters().size() == 1 && method.getReturnType().toString().equals( method.getEnclosingElement().asType().toString());
	}
	@Override
	public String getPropertyName(ExecutableElement getterOrSetterMethod) {
		String methodName = getterOrSetterMethod.getSimpleName().toString();
		if (methodName.startsWith( "is" ) || methodName.startsWith( "get" ) || methodName.startsWith( "set" )) return Introspector.decapitalize(methodName.substring(methodName.startsWith("is" ) ? 2 : 3 ) );
		else return methodName;
	}
}
