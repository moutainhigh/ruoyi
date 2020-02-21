package com.ruoyi.zh.controller;

import com.ruoyi.mina.config.SessionManage;
import com.ruoyi.mina.entity.Cmd;
import com.ruoyi.mina.entity.Msg;
import com.sun.xml.internal.ws.resources.SenderMessages;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.mina.core.session.IoSession;
import org.springframework.data.redis.util.ByteUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
@Api(tags = "发送消息")
public class SendMessageController {
//    @GetMapping("/test")
//    public void test(@RequestParam(name="msg") String msg){
//        SessionManage.sendMsg(msg);
//    }

//    @PreAuthorize("@ss.hasPermi('config:global:index')")
    @GetMapping("/start")
    @ApiOperation("开始 4")
    public void start(){
        Msg msg=new Msg();
        //经纬度
        msg.setBody("");
        msg.setCmd((byte)4);
        msg.setMagic("SPIMS");
        //经度
        byte[] lng_bytes=new byte[10];
        //纬度
        byte[] lat_bytes=new byte[10];
        msg.setBytes(ByteUtils.concat(lng_bytes,lat_bytes));
        SessionManage.sendMsg(msg);
    }

    @GetMapping("/stop")
    @ApiOperation("停止6")
    public void stop(){
        Msg msg=new Msg();
        msg.setBody("");
        msg.setCmd((byte)6);
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);
    }

    @GetMapping("/startCorrect")
    @ApiOperation("开始校正22")
    public void startCorrect(){
        Msg msg=new Msg();
        msg.setBody("");
        msg.setCmd((byte)22);
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);
    }

    @GetMapping("/stopCorrect")
    @ApiOperation("停止校正22")
    public void stopCorrect(){
        Msg msg=new Msg();
        msg.setBody("");
        msg.setCmd((byte)24);
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);
    }

    @GetMapping("/startWeather")
    @ApiOperation("开始获取天气")
    public void startWeather(){
        Msg msg=new Msg();
        msg.setBody("");
        msg.setCmd((byte) Cmd.StartWeather.getCmd());
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);
    }

    @GetMapping("/stopWeather")
    @ApiOperation("停止获取天气")
    public void stopWeather(){
        Msg msg=new Msg();
        msg.setBody("");
        msg.setCmd((byte) Cmd.StopWeather.getCmd());
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);
    }




    @GetMapping("/getMethod")
    @ApiOperation("获取方法")
    public void getMethod(){
        Msg msg=new Msg();
        msg.setBody("");
        msg.setCmd((byte) Cmd.GetMethod.getCmd());
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);
    }

    @GetMapping("/startGps")
    @ApiOperation("获取Gps")
    public void getGps(){
        Msg msg=new Msg();
        msg.setBody("");
        msg.setCmd((byte) Cmd.StartGps.getCmd());
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);
    }

    @GetMapping("/stopGps")
    @ApiOperation("停止获取Gps")
    public void stopGps(){
        Msg msg=new Msg();
        msg.setBody("");
        msg.setCmd((byte) Cmd.StopGps.getCmd());
        msg.setMagic("SPIMS");
        msg.setBytes(null);
        SessionManage.sendMsg(msg);
    }

}