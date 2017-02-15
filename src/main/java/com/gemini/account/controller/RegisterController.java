package com.gemini.account.controller;


import com.alibaba.fastjson.JSONObject;
import com.gemini.account.model.Register;
import com.gemini.account.utils.Content;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by Administrator on 2017/2/15.
 */


@Controller
@RequestMapping("/loginServer")
public class RegisterController {

    private static Logger log = LoggerFactory.getLogger(RegisterController.class);

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request) {
        try {
            BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuffer strBuffer = new StringBuffer();
            String registerStr = "";
            while ((registerStr = bufferedInputStream.readLine()) != null) {
                strBuffer.append(registerStr);
            }
            JSONObject jsonObject = JSONObject.parseObject(strBuffer.toString());
            String data = null;
            if (jsonObject.containsKey("data")) {
                data = (String) jsonObject.get("data");
            }
            JSONObject jsonRegister = JSONObject.parseObject(data);

            String email = (String) jsonObject.get(Content.EMAIL);
            String name = (String) jsonObject.get(Content.NAME);
            String pwd = (String) jsonObject.get(Content.PWD);




            //账号查重
            AccountNameCheck(name);
            EmailCheck(email);


            Register register = new Register();
            register.setEmail(email);
            register.setPassword(name);
            register.setUsername(pwd);
            System.out.println(register.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 账号查重
     * @param name
     */
    private void AccountNameCheck(String name) {

    }

    /**
     * 邮件查重
     * @param email
     */
    private void EmailCheck(String email) {

    }



}
