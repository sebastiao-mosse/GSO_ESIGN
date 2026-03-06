package com.esign.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController{


    @RequestMapping(value = "/error", method=RequestMethod.GET)
    public String handleError(HttpServletRequest request)
    {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String error = "";
        if(status!=null && Integer.valueOf(status.toString()) == HttpStatus.NOT_FOUND.value())
        {error = errorType("404", "PAGE NOT FOUND !") ;
        }
        if(status!=null && Integer.valueOf(status.toString()) == HttpStatus.FORBIDDEN.value())
        {error = errorType("403", "ACCESS FORBIDDEN. USE YOUR CREDENTIALS!");
        }
        
        if(status!=null && Integer.valueOf(status.toString()) == HttpStatus.UNAUTHORIZED.value())
        {error = errorType("401", "UNAUTHORIZED");
        }
        
        if(status!=null && Integer.valueOf(status.toString()) == HttpStatus.INTERNAL_SERVER_ERROR.value())
        {error = errorType("500", "INTERNAL SERVER ERROR");
        }
        
        //ACRESCENTAR O ERRO 500- INTERNAL SERVER ERROR
        
        return error;   

    }
    
    public String errorType(String httpError, String description) 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>"+httpError + " - "+ description + "</h2>");
        return sb.toString();
    }

    @Override
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return null;
    }

}