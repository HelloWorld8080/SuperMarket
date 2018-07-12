package com.sm.Tools;

import com.alibaba.fastjson.JSON;
import com.sm.entity.Rechild;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

public class StringToJson {
    private static Map<String, String> map = null;

    public static Map<String, String> getString(HttpServletRequest request) {
        BufferedReader br;
        StringBuilder sb = null;
        String reqBody = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                    request.getInputStream()));
            String line = null;
            sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            reqBody = URLDecoder.decode(sb.toString(), "UTF-8");
            reqBody = reqBody.substring(reqBody.indexOf("{"));
            request.setAttribute("inputParam", reqBody);
            System.out.println("JsonReq reqBody>>>>>" + reqBody);
            map = (Map<String, String>) JSON.parse(reqBody);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }

}
