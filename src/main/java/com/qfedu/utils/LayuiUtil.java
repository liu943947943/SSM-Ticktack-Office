package com.qfedu.utils;
import com.qfedu.vo.LayuiVo;


public class LayuiUtil {
    public static LayuiVo exec(int count, Object obj){
    	LayuiVo resultVo = new LayuiVo();
        if (count > 0){
            resultVo.setCode(1);
            resultVo.setMsg("操作成功");
            resultVo.setData(obj);
        }else {
            resultVo.setCode(1001);
            resultVo.setMsg("操作失败");
        }
        return resultVo;
    }

    public static  LayuiVo execOk(){
    	LayuiVo resultVo = new LayuiVo();
        resultVo.setCode(1);
        resultVo.setMsg("OK");
        return resultVo;
    }
    public static  LayuiVo execOk(Integer count,Object obj){
    	LayuiVo resultVo = new LayuiVo();
        resultVo.setCode(1);
        resultVo.setMsg("OK");
        resultVo.setData(obj);
        resultVo.setCount(count);
        return resultVo;
    }

    public static  LayuiVo execERROR(){
    	LayuiVo resultVo = new LayuiVo();
        resultVo.setCode(0);
        resultVo.setMsg("ERROR");
        return resultVo;
    }
    public static  LayuiVo execERROR(Integer count,Object obj){
    	LayuiVo resultVo = new LayuiVo();
        resultVo.setCode(0);
        resultVo.setMsg("ERROR");
        resultVo.setData(obj);
        resultVo.setCount(count);
        return resultVo;
    }

}
