package com.imooc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private  GirlService girlService;

    //查询女生列表，全部
    @GetMapping(value = "/girlList")
    public List<Girl> girlList() {

        return girlRepository.findAll();
    }

    /**
     * 新增一个女生
     *
     * @param cupSize
     * @param age
     * @return Girl
     */
    @PostMapping("/girlAdd")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @PostMapping("/deleteGirl/{id}")
    public void delGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 根据id查询一个女生
     *
     * @param id
     * @return gir
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {

        return girlRepository.findOne(id);

    }

    @PutMapping(value = "/updateGirl/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,@RequestParam("test") Integer age,
                           @RequestParam("cupSize") String cupSize
                           ) {
        Girl girl=new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);

    }
    //根据年龄查询
    @GetMapping(value = "/findByAge/{age}")
    public List<Girl> findByAge(@PathVariable("age")Integer age){
        return girlRepository.findByAge(age);

    }
    //事物。同时插入两条数据
    @GetMapping(value = "/insertTwo")
    public void indertTwo(){

     girlService.insertTwo();
    }
}
