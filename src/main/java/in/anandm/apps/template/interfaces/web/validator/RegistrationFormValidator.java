/**
 * 
 */
package in.anandm.apps.template.interfaces.web.validator;

import in.anandm.apps.template.interfaces.web.dto.RegistrationFormDTO;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * @author anandm
 *
 */
@Component
public class RegistrationFormValidator extends AbstractValidator {

	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String GENDER = "gender";
	private static final String DOB = "dob";
	private static final String EMAIL_ID = "emailId";
	private static final String USER_ID = "userId";
	private static final String PASSWORD = "password";
	private static final String REPEAT_PASSWORD = "repeatPassword";

	@Override
	public boolean supports(Class<?> clazz) {

		return RegistrationFormDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if(validationRequired(FIRST_NAME)){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIRST_NAME, "NotEmpty.RegistrationFormDTO.firstName");
		}

		if(validationRequired(LAST_NAME)){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, LAST_NAME, "NotEmpty.RegistrationFormDTO.lastName");
		}

		if(validationRequired(GENDER)){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, GENDER, "NotEmpty.RegistrationFormDTO.gender");	
		}

		if(validationRequired(DOB)){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, DOB, "NotEmpty.RegistrationFormDTO.dob");	
		}

		if(validationRequired(EMAIL_ID)){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, EMAIL_ID, "NotEmpty.RegistrationFormDTO.emailId");	
		}


		if(validationRequired(USER_ID)){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, USER_ID, "NotEmpty.RegistrationFormDTO.userId");	
		}

		if(validationRequired(PASSWORD)){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, PASSWORD, "NotEmpty.RegistrationFormDTO.password");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, REPEAT_PASSWORD, "NotEmpty.RegistrationFormDTO.repeatPassword");

			if(!(errors.hasFieldErrors(PASSWORD) || errors.hasFieldErrors(REPEAT_PASSWORD))){
				RegistrationFormDTO registrationFormDTO = (RegistrationFormDTO) target;
				if(!registrationFormDTO.getPassword().equals(registrationFormDTO.getRepeatPassword())){
					errors.rejectValue(PASSWORD, "UnMatched.RegistrationFormDTO.password");
				}
			}
		}
	}

}
