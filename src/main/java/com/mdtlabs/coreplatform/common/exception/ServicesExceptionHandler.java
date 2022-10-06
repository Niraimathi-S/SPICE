package com.mdtlabs.coreplatform.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
//import javax.validation.*;
//import javax.validation.ConstraintViolationException;

import org.springframework.http.*;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mdtlabs.coreplatform.common.logger.SpiceLogger;
import com.mdtlabs.coreplatform.common.util.StringUtil;


/**
 * This class is used to handle TeleCounselorException.
 *
 * @author Vigneshkumar Created on 30 Jun 2022
 */
@ControllerAdvice
public class ServicesExceptionHandler extends ResponseEntityExceptionHandler {

    private ExceptionResolver resolver;

    @PostConstruct
    public final void initiateErrorCodeToResolver() {
        resolver = new ExceptionResolverImpl();
    }

    /**
     *
     * @param runtimeException
     * @return
     */
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(value = InvalidPathException.class)
    @ResponseBody
    public ErrorMessage runtimeExceptionHandler(RuntimeException runtimeException) {
        SpiceLogger.logError(
                StringUtil.constructString(runtimeException.getClass().getName(), ExceptionConstants.MESSAGE_GENERIC,
                        getErrorStackString(runtimeException)));

        return resolver.resolveError(HttpStatus.INTERNAL_SERVER_ERROR, runtimeException.getMessage());
    }

    /**
     *
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        System.out.println("----------------------Inside MethodArgumentNotValidException handler---------------------------------------------");
        SpiceLogger.logError(StringUtil.constructString(ex.getClass().getName(),
                ExceptionConstants.MESSAGE_GENERIC, getErrorStackString(ex)));
        List rejectedValues = ex.getBindingResult().getAllErrors().stream().map(a -> a.getDefaultMessage())
                .collect(Collectors.toList());
// to get list of field names that violates constraint
//		String stringArg =
//				String.valueOf(rejectedValues.stream().reduce((string1, string2) -> string1 + ", " + string2));
        return handleExceptionInternal(ex, resolver.resolveError(HttpStatus.BAD_REQUEST, rejectedValues.toString()),
                headers, status, request);
    }

    /**
     *
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = DataConflictException.class)
    @ResponseBody
    protected final ErrorMessage handleDataConflict(DataConflictException exception) {
        System.out.println("----------------------Inside DataConflictException handler---------------------------------------------");
        SpiceLogger.logError(StringUtil.constructString(exception.getClass().getName(),
                ExceptionConstants.MESSAGE_GENERIC, getErrorStackString(exception)));
        System.out.println("----------------------end of DataConflictException handler---------------------------------------------");
        return resolver.resolveError(HttpStatus.CONFLICT, exception.getMessage());
    }

    /**
     *
     * @param servicesException
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = SpiceValidation.class)
    @ResponseBody
    protected final ErrorMessage handleSpiceValidation(ServicesException servicesException) {
        System.out.println("----------------------Inside spice validation handler---------------------------------------------");
        SpiceLogger.logError(
                StringUtil.constructString(servicesException.getClass().getName(), ExceptionConstants.MESSAGE_GENERIC,
                        getErrorStackString(servicesException)));
        System.out.println("----------------------end of spicevalidation handler---------------------------------------------");
        return resolver.resolveError(HttpStatus.BAD_REQUEST, servicesException.getMessage());
    }

    /**
     *
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BadRequestException.class)
    @ResponseBody
    protected final ErrorMessage handleBadRequest(BadRequestException exception) {
        System.out.println("----------------------Inside spice validation handler---------------------------------------------");

        SpiceLogger.logError(
        		StringUtil.constructString(exception.getClass().getName(), ExceptionConstants.MESSAGE_GENERIC,
                        getErrorStackString(exception)));
        System.out.println("----------------------end of spicevalidation handler---------------------------------------------");
        return resolver.resolveError(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    /**
     *
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = DataNotFoundException.class)
    @ResponseBody
    protected final ErrorMessage handleDataNotFoundException(DataNotFoundException exception) {
        System.out.println(
                "----------------------Inside DataNotFoundException handler---------------------------------------------");
        SpiceLogger.logError(
        		StringUtil.constructString(exception.getClass().getName(), ExceptionConstants.MESSAGE_GENERIC,
                        getErrorStackString(exception)));
        System.out.println(
                "----------------------end of DataNotFoundException handler---------------------------------------------");

        System.out.println("_____________________exception.getMessage()\n" + exception.getMessage());
        return resolver.resolveError(HttpStatus.NOT_FOUND, exception.getMessage());
    }

//    /**
//     *
//     * @param validationException
//     * @return
//     */
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(value = ConstraintViolationException.class)
//    @ResponseBody
//    public ErrorMessage handleConstraintViolationException(ConstraintViolationException validationException) {
//        System.out.println("----------------------start of ConstraintViolationException handler---------------------------------------------");
//        SpiceLogger.logError(
//        		StringUtil.constructString(validationException.getClass().getName(), ExceptionConstants.MESSAGE_GENERIC,
//                        getErrorStackString(validationException)));
//        System.out.println("----------------------Endof ConstraintViolationException handler---------------------------------------------");
//        return resolver.resolveError(HttpStatus.BAD_REQUEST,
//                validationException.getConstraintViolations().stream().map(a -> a.getMessage())
//                        .collect(Collectors.toList()).toString());
//    }

    /**
     *
     * @param validationException
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = TransactionSystemException.class)
    @ResponseBody
    public ErrorMessage handleTransactionSystemException(TransactionSystemException validationException) {
        System.out.println("----------------------start of TransactionSystemException handler---------------------------------------------");
        SpiceLogger.logError(
        		StringUtil.constructString(validationException.getClass().getName(), ExceptionConstants.MESSAGE_GENERIC,
                        getErrorStackString(validationException)));
        System.out.println("----------------------Endof TransactionSystemException handler---------------------------------------------");
        return resolver.resolveError(HttpStatus.BAD_REQUEST, validationException.getMessage());
    }

    /**
     *
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorMessage exceptionHandler(Exception exception) {
    	SpiceLogger.logError(
    			StringUtil.constructString(exception.getClass().getName(), ExceptionConstants.MESSAGE_GENERIC,
                        getErrorStackString(exception)));

        return resolver.resolveError(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }

    /**
     *
     * @param error
     * @return
     */
    private String getErrorStackString(Exception error) {
        StringWriter writer = new StringWriter();
        error.printStackTrace(new PrintWriter(writer));
        return writer.toString();
    }
}
