package cn.edu.whu.irlab.ir_nlp.controller;

import cn.edu.whu.irlab.ir_nlp.service.analysis.DivideWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author fangrf
 * @version 1.0
 * @date 2018-10-30 9:51
 * @desc 分词的交互层
 **/
@RestController
public class AnalysisController {

    @Autowired
    private DivideWord divideWord;

    @RequestMapping(value = "/analysis")
    public ModelMap analysisController(String data){
        //DivideWord dw=new DivideWord();//调用分词
        String responseText = null;
        DivideWord dw=new DivideWord();//调用分词
        try {
            responseText = dw.divide(data, 7);//最大正向匹配
        } catch (IOException e) {
            e.printStackTrace();
        }
        //	String responseText = dw.left_to_right_divide(text, 4);//最大正向匹配的从左向右
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("results",responseText);
        return modelMap;

    }
}
