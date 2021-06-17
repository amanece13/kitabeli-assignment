package com.kitabeli.application.util;

import com.kitabeli.application.exception.ErrorCode;
import com.kitabeli.application.model.ProductModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

@Slf4j
public class InputValidator {

    public static String validate(ProductModel productModel) {
        log.info("Validating product input dataset");
        String validationMessage = "";

        if(ObjectUtils.isEmpty(productModel.getName()))
            validationMessage+= ErrorCode.getEnumBySubErrorCode(1).getMessage() + " " + "\n";
        if(ObjectUtils.isEmpty(productModel.getDescription()))
            validationMessage+= ErrorCode.getEnumBySubErrorCode(2).getMessage() + " " + "\n";
        if(ObjectUtils.isEmpty(productModel.getCategoryId()))
            validationMessage+= ErrorCode.getEnumBySubErrorCode(3).getMessage() + " " + "\n";
        if(ObjectUtils.isEmpty(productModel.getInventoryId()))
            validationMessage+= ErrorCode.getEnumBySubErrorCode(4).getMessage() + " " + "\n";
        if(ObjectUtils.isEmpty(productModel.getPrice()))
            validationMessage+= ErrorCode.getEnumBySubErrorCode(5).getMessage() + " " + "\n";

        if(validationMessage.isEmpty())
            log.info("All validations have passed.");
        return validationMessage;
    }

}
