package com.kitabeli.application.exception;

public enum ErrorCode {

  PRODUCT_NAME_MISSING(1,"Product is empty"),
  DESCRIPTION_MISSING(2,"Description is empty"),
  CATEGORY_ID_MISSING(3,"Category id is empty"),
  INVENTORY_ID_MISSING(4,"Inventory id empty"),
  PRICE_MISSING(5,"Price is empty");


  private Integer subErrorCode;
  private String message;

  ErrorCode(final Integer subErrorCode, final String message) {
    this.subErrorCode = subErrorCode;
    this.message = message;
  }

  public static ErrorCode getEnumByMessage(final String message) {
    for (ErrorCode errorCode : ErrorCode.values()) {
      if (errorCode.getMessage().equalsIgnoreCase(message)) {
        return errorCode;
      }
    }
    return null;
  }

  public static ErrorCode getEnumBySubErrorCode(final Integer subErrorCode) {
    for (ErrorCode errorCode : ErrorCode.values()) {
      if (errorCode.getSubErrorCode() == subErrorCode) {
        return errorCode;
      }
    }
    return null;
  }

  public Integer getSubErrorCode() {
    return subErrorCode;
  }

  public String getMessage() {
    return message;
  }
}
