package com.boe.tww.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boe.tww.entity.User;
import com.boe.tww.jpa.UserJPA;
import com.boe.tww.util.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * 用户的Controller
 *
 * @author 唐万万
 * @create 2018-03-12 21:50
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserJPA userJPA;

    /**
     * 根据age查找
     * @return
     */
    @GetMapping("/age")
    public List<User> age20(int age) {
        return userJPA.nativeQuery(age);
    }

    /**
     * 分页
     * @param page
     * @return
     */
    @GetMapping("/cutPage")
    public List<User> cutPage(int page) {
        User user = new User();
        user.setSize(2);
        user.setPage(page);
        user.setSord("desc");
        ////创建分页对象
        //PageRequest pageRequest = new PageRequest(user.getPage() - 1, user.getSize());
        //获取排序对象
        Sort.Direction sort_direction = Sort.Direction.ASC.toString().equalsIgnoreCase(user.getSord())?Sort.Direction.ASC:Sort.Direction.DESC;
        //设置排序对象参数
        Sort sort = new Sort(sort_direction, user.getSidx());
        //创建分页对象
        PageRequest pageRequest = new PageRequest(user.getPage() - 1, user.getSize(), sort);
        return userJPA.findAll(pageRequest).getContent();
    }

    /**
     * 根据自定义条件删除SQL
     * @return
     */
    @RequestMapping("/deleteWhere")
    public String deleteWhere() {
        userJPA.deleteQuery("1", "1");
        return "删除成功";
    }

    /**
     * 获取用户列表方法
     *
     * @return
     */
    @GetMapping("/list")
    public List<User> list() {
        System.out.println(JSON.toJSONString(userJPA.findAll()));
        return userJPA.findAll();
    }

    /**
     * 添加更新用户
     *
     * @param user
     * @return
     */
    @GetMapping(value = "/save")
    public User save(User user) {
        return userJPA.save(user);
    }

    @GetMapping("/delete")
    public List<User> detele(Long id) {
        userJPA.deleteById(id);
        return userJPA.findAll();
    }

    @GetMapping("/login")
    public String login(String name, String password, HttpServletRequest request) {
        String result =  "登录成功";
        boolean flag = true;
       Optional<User> user = userJPA.findOne(new Specification<User>() {
           @Override
           public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
               criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
               return null;
           }
       });
        if (!user.isPresent()) {
            result = "用户不存在，登录失败";
            flag = false;
        } else if (!user.get().getPassword().equals(password)) {
            flag = false;
            result = "用户密码不相符，登录失败";
        }
        if (flag) {
            request.getSession().setAttribute("_session_user", user);
        }
        return result;
    }

    /**
     * 获取json格式的数据
     * @param request
     * @param name
     * @return
     * @throws Exception
     */
    @GetMapping("/loginJSON")
    public JSONObject login(HttpServletRequest request, String name) throws Exception
    {
        JSONObject obj = new JSONObject();
        obj.put("msg","用户："+name+"，登录成功。");
        //将返回值写入到请求对象中
        request.setAttribute(LoggerUtils.LOGGER_RETURN,obj);
        return obj;
    }

    /**
     * 测试logger
     * @return
     */
    @GetMapping("/logger")
    public String logger() {
        logger.debug("记录debug日志");
        logger.info("访问了logger方法");
        logger.error("记录error错误日志");
        return "logger";
    }
}
