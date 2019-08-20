package com.robosh.validator;

import com.robosh.entities.User;
import com.robosh.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private static final String SPACE = "[\\s]";
    private static final String CHECK_NAME = "[A-za-z\\p{IsCyrillic}.'-]{3,20}";
    private static final String CHECK_EMAIL = "[A-Za-z0-9+_.-]+@[a-z.-]+\\.[a-z]{2,8}";
    private static final String CHECK_PHONE = "[0-9\\+]{10,15}";
    private static final String CHECK_PASSWORD = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}";

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Required");
        if (!user.getFirstName().matches(CHECK_NAME)) {
            errors.rejectValue("firstName", "userForm.invalid.name");
        }
        if (!user.getLastName().matches(CHECK_NAME)) {
            errors.rejectValue("lastName", "userForm.invalid.name");
        }

        if(!user.getEmail().matches(CHECK_EMAIL)){
            errors.rejectValue("email", "Size.userForm.username");
        }
        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "userForm.email.duplicate");
        }
        if(!user.getPhone().matches(CHECK_PHONE)){
            errors.rejectValue("phone", "userForm.invalid.phone");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");

        if (user.getPassword().matches(CHECK_PASSWORD)) {
            errors.rejectValue("password", "userForm.invalid.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "userForm.different.password");
        }
    }
}
