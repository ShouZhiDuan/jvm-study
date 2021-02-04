package com.demo.jvm;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = JvmStudyDszApplication.class)
class JvmStudyDszApplicationTests {

    @Value("classpath:method.json")
    Resource resource;


    @Test
    public void genInserSQL() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        StringBuffer message=new StringBuffer();
        String line = null;
        while((line = br.readLine()) != null) { message.append(line); }
        String defaultString=message.toString();
        List<ResearchMethod> list = JSON.parseArray(defaultString, ResearchMethod.class);
        String prefix = "INSERT INTO research_method VALUES ( ";
        String postfix = " ) ON CONFLICT (id) DO UPDATE  SET ";
        String allSQL = "";
        for (ResearchMethod method : list){
            String sql = "";
            List<String> values = new ArrayList<>();
            values.add(method.id+"");
            values.add(method.blocked+"");
            values.add("'"+method.description.replaceAll("'","''")+"'");
            values.add("'"+method.descriptionZh.replaceAll("'","''")+"'");
            values.add("'"+method.name.replaceAll("'","''")+"'");
            values.add("'"+method.nameDB.replaceAll("'","''")+"'");
            values.add("'"+method.nameZh.replaceAll("'","''")+"'");
            String join = String.join(",",values);
            sql = prefix + join + postfix;
            String blocked = "blocked=" + method.blocked + ",";
            String description = " description='" + method.description.replaceAll("'","''") + "',";
            String description_zh = " description_zh='" + method.descriptionZh.replaceAll("'","''") + "',";
            String name = " name='" + method.name.replaceAll("'","''") + "',";
            String name_db = " name_db='" + method.nameDB.replaceAll("'","''") + "',";
            String name_zh = " name_zh='" + method.nameZh.replaceAll("'","''") + "';\n";
            sql = sql + blocked + description + description_zh + name + name_db + name_zh;
            allSQL += sql;
        }
        PrintWriter pw = new PrintWriter(new FileWriter("D:\\sql-bak"+File.separator+"research_method.sql"));
        pw.print(allSQL);
        pw.flush();
        pw.close();
    }


    @Test
    public void testDouNiu() throws InterruptedException {
        Thread.sleep(1000);
        System.err.println("======>里把东涛做庄，做1000块钱。开始。。。。。。<======");
        System.err.println("======>你们快西下。。。。。。<======");
        Thread.sleep(1000);
        System.err.println("======>东东剪之，不得了。。。。。。<======");
        Thread.sleep(1000);
        System.err.println("======>段景阳下：100到底。。。。。。<======");
        Thread.sleep(1000);
        System.err.println("======>小火下：100头尼。。。。。。<======");
        Thread.sleep(1000);
        System.err.println("======>旺旺下：200 300 500。。。。。。<======");
        Thread.sleep(1000);
        System.err.println("======>线点能西尼。。。。。。<======");
        Thread.sleep(1000);
        System.err.println("庄家牛之");
        Thread.sleep(300);
        System.err.println("东东3字大");
        Thread.sleep(300);
        System.err.println("景阳缪点");
        Thread.sleep(300);
        System.err.println("旺旺标西");
        System.err.println("======>焖之庄。。。。。。<======");
    }





}
