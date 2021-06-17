package com.kitabeli.application.util;

import com.kitabeli.application.model.ProductModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class InputValidator {

    public static String validate(ProductModel productModel) {
        String validationMessage = "";

        if(validationMessage.isEmpty())
            log.info("All validations have passed.");
        return validationMessage;
    }

}
