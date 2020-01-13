package org.smartframework.cloud.starter.swagger.validators.plugins.parameter;

import static springfox.bean.validators.plugins.Validators.annotationFromParameter;

import javax.validation.constraints.NotBlank;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.google.common.base.Optional;

import lombok.extern.slf4j.Slf4j;
import springfox.bean.validators.plugins.Validators;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterContext;

@Component
@Order(Validators.BEAN_VALIDATOR_PLUGIN_ORDER)
@Slf4j
public class NotBlankParameterAnnotationPlugin implements ParameterBuilderPlugin {

	@Override
	public boolean supports(DocumentationType delimiter) {
		// we simply support all documentationTypes!
		return true;
	}

	@Override
	public void apply(ParameterContext context) {
		Optional<NotBlank> notBlank = annotationFromParameter(context, NotBlank.class);

		if (notBlank.isPresent()) {
			log.debug("@NotBlank present: setting parameter as required");
			context.parameterBuilder().allowEmptyValue(false).required(true);
		}
	}
}