package com.robosh.validator;

import com.robosh.entities.User;
import com.robosh.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UpdateUserValidator implements Validator {

    private static final String CHECK_NAME = "[A-za-z\\p{IsCyrillic}.'-]{3,20}";
    private static final String CHECK_EMAIL = "[A-Za-z0-9+_.-]+@[a-z.-]+\\.[a-z]{2,8}";
    private static final String CHECK_PHONE = "[0-9\\+]{10,15}";
    private static final String CHECK_PASSWORD = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}";

    private UserService userService;

    public UpdateUserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;

        if (!user.getFirstName().matches(CHECK_NAME)) {
            errors.rejectValue("firstName", "userForm.invalid.name", "Invalid data");
        }
        if (!user.getLastName().matches(CHECK_NAME)) {
            errors.rejectValue("lastName", "userForm.invalid.name", "Invalid data");
        }

        if (!user.getEmail().matches(CHECK_EMAIL)) {
            errors.rejectValue("email", "userForm.invalid.email", "Invalid data");
        }

        if (userService.findByEmail(user.getEmail()) != null && !(userService.findByEmail(user.getEmail()).equals(user.getEmail()))) {
            errors.rejectValue("email", "userForm.email.duplicate", "Invalid data");
        }

        if (!user.getPhone().matches(CHECK_PHONE)) {
            errors.rejectValue("phone", "userForm.invalid.phone", "Invalid data");
        }

        if (!user.getPassword().matches(CHECK_PASSWORD)) {
            errors.rejectValue("password", "userForm.invalid.password", "Invalid data");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "userForm.different.password", "Invalid data");
        }
    }
}
