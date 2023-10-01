package com.laptrinhjavaweb.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "shortUrlControllerOfWeb")
public class ShortUrlController {

    @RequestMapping(value = {"/jsp-servlet"}, method = RequestMethod.GET)
    public ModelAndView jspServletCourse() {
        return new ModelAndView("redirect:/khoa-hoc-java-web-co-ban-jsp-servlet-jdbc-va-mysql");
    }

    @RequestMapping(value = "/academy", method = RequestMethod.GET)
    public ModelAndView academy() {
        return new ModelAndView("redirect:/dich-vu/khoa-hoc");
    }

    @RequestMapping(value = "/software", method = RequestMethod.GET)
    public ModelAndView software() {
        return new ModelAndView("redirect:/dich-vu/software");
    }

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public ModelAndView shop() {
        return new ModelAndView("redirect:/dich-vu/shop");
    }

    @RequestMapping(value = "/dich-vu/lam-thue-do-an-cntt", method = RequestMethod.GET)
    public ModelAndView thesis() {
        return new ModelAndView("redirect:/ho-tro-do-an-java-javascript-48");
    }

    @RequestMapping(value = "/lo-trinh-hoc-java", method = RequestMethod.GET)
    public ModelAndView javaRoadmap() {
        return new ModelAndView("redirect:/hoc-java-nguoi-moi-135");
    }

    @RequestMapping(value = "/lo-trinh-hoc-java-hosting", method = RequestMethod.GET)
    public ModelAndView javaHostingRoadmap() {
        return new ModelAndView("redirect:/lo-trinh-hoc-java-hosting-176");
    }

    @RequestMapping(value = "/java", method = RequestMethod.GET)
    public ModelAndView javaHome() {
        return new ModelAndView("redirect:/java-co-ban-63");
    }

    @RequestMapping(value = "/java-begin", method = RequestMethod.GET)
    public ModelAndView javaBegin() {
        return new ModelAndView("redirect:/java#begin");
    }

    @RequestMapping(value = "/java-experience", method = RequestMethod.GET)
    public ModelAndView javaExperience() {
        return new ModelAndView("redirect:/java#experience");
    }

    @RequestMapping(value = "/java-01", method = RequestMethod.GET)
    public ModelAndView java01() {
        return new ModelAndView("redirect:/java#java-01");
    }

    @RequestMapping(value = "/java-02", method = RequestMethod.GET)
    public ModelAndView java02() {
        return new ModelAndView("redirect:/java#java-02");
    }

    @RequestMapping(value = "/java-03", method = RequestMethod.GET)
    public ModelAndView java03() {
        return new ModelAndView("redirect:/java#java-03");
    }

    @RequestMapping(value = "/java-04", method = RequestMethod.GET)
    public ModelAndView java04() {
        return new ModelAndView("redirect:/java#java-04");
    }

    @RequestMapping(value = "/hoc-java-web", method = RequestMethod.GET)
    public ModelAndView javaWebStudy() {
        return new ModelAndView("redirect:/hoc-java-web-mien-phi-7");
    }

    @RequestMapping(value = "/hoc-java-hosting", method = RequestMethod.GET)
    public ModelAndView javaHostingStudy() {
        return new ModelAndView("redirect:/hoc-java-hosting-co-ban-mien-phi-177");
    }

    @RequestMapping(value = "/lo-trinh-hoc-java-web", method = RequestMethod.GET)
    public ModelAndView javaWebRoadmap() {
        return new ModelAndView("redirect:/lo-trinh-hoc-java-web-phan-1-21");
    }

    @RequestMapping(value = "/khai-niem-java-web", method = RequestMethod.GET)
    public ModelAndView meaningUrl() {
        return new ModelAndView("redirect:/nhung-bai-viet-tam-dac-55");
    }

    @RequestMapping(value = "/khoa-hoc-java", method = RequestMethod.GET)
    public ModelAndView javaCoursePart1() {
        return new ModelAndView("redirect:/khoa-hoc-java-phong-van-di-lam-78");
    }

    @RequestMapping(value = "/khoa-hoc-java-core", method = RequestMethod.GET)
    public ModelAndView javaCoursePart2() {
        return new ModelAndView("redirect:/khoa-hoc-java-phong-van-di-lam-78");
    }

    @RequestMapping(value = "/khoa-hoc-java-cost", method = RequestMethod.GET)
    public ModelAndView javaCourseCost() {
        return new ModelAndView("redirect:/khoa-hoc-java#cost");
    }

    @RequestMapping(value = "/khoa-hoc-java-content", method = RequestMethod.GET)
    public ModelAndView javaCourseContent() {
        return new ModelAndView("redirect:/khoa-hoc-java#content");
    }

    @RequestMapping(value = "/khoa-hoc-java-roadmap", method = RequestMethod.GET)
    public ModelAndView javaCourseRoadmap() {
        return new ModelAndView("redirect:/khoa-hoc-java#roadmap");
    }

    @RequestMapping(value = "/khoa-hoc-java-web", method = RequestMethod.GET)
    public ModelAndView javaWebCourse() {
        return new ModelAndView("redirect:/khoa-hoc-java-web-co-ban-den-nang-cao");
    }

    @RequestMapping(value = "/khoa-hoc-java-web-cost", method = RequestMethod.GET)
    public ModelAndView javaWebCourseCost() {
        return new ModelAndView("redirect:/khoa-hoc-java-web-co-ban-den-nang-cao#cost");
    }

    @RequestMapping(value = "/khoa-hoc-java-web-test", method = RequestMethod.GET)
    public ModelAndView javaWebCourseTest() {
        return new ModelAndView("redirect:/khoa-hoc-java-web-co-ban-den-nang-cao#test");
    }

    @RequestMapping(value = "/khoa-hoc-java-web-content", method = RequestMethod.GET)
    public ModelAndView javaWebCourseContent() {
        return new ModelAndView("redirect:/khoa-hoc-java-web-co-ban-den-nang-cao#content");
    }

    @RequestMapping(value = "/khoa-hoc-java-web-roadmap", method = RequestMethod.GET)
    public ModelAndView javaWebCourseRoadMap() {
        return new ModelAndView("redirect:/khoa-hoc-java-web-co-ban-den-nang-cao#roadmap");
    }

    @RequestMapping(value = "/khoa-hoc-deploy", method = RequestMethod.GET)
    public ModelAndView deployServerCoursePart1() {
        return new ModelAndView("redirect:/khoa-hoc-deploy-java-web-len-hosting-84");
    }

    @RequestMapping(value = "/khoa-hoc-java-hosting", method = RequestMethod.GET)
    public ModelAndView deployServerCoursePart2() {
        return new ModelAndView("redirect:/khoa-hoc-deploy-java-web-len-hosting-84");
    }

    @RequestMapping(value = "/deploy-java-web-hosting", method = RequestMethod.GET)
    public ModelAndView deployJavaWebHosting() {
        return new ModelAndView("redirect:/khoa-hoc-deploy-java-web-len-hosting-84");
    }

    @RequestMapping(value = "/support-deploy-hosting", method = RequestMethod.GET)
    public ModelAndView supportDeployHosting() {
        return new ModelAndView("redirect:/deploy-project-hosting-146");
    }

    @RequestMapping(value = "/spring-boot-01", method = RequestMethod.GET)
    public ModelAndView springBoot01() {
        return new ModelAndView("redirect:/hoc-spring-boot-viet-api-web-service-185");
    }

    @RequestMapping(value = "/spring-boot-02", method = RequestMethod.GET)
    public ModelAndView springBoot02() {
        return new ModelAndView("redirect:/hoc-spring-boot-2-0-x-thiet-ke-website-ban-hang-159");
    }

    @RequestMapping(value = "/spring-mvc-01", method = RequestMethod.GET)
    public ModelAndView springMVC01() {
        return new ModelAndView("redirect:/hoc-spring-mvc-khong-su-dung-spring-boot-186");
    }

    @RequestMapping(value = "/spring-mvc-02", method = RequestMethod.GET)
    public ModelAndView springMVC02() {
        return new ModelAndView("redirect:/springmvc#spring-mvc-02");
    }

    @RequestMapping(value = "/jsp-servlet-01", method = RequestMethod.GET)
    public ModelAndView jspServlet01() {
        return new ModelAndView("redirect:/jsp-servlet#jsp-servlet-01");
    }

    @RequestMapping(value = "/jsp-servlet-02", method = RequestMethod.GET)
    public ModelAndView jspServlet02() {
        return new ModelAndView("redirect:/jsp-servlet#jsp-servlet-02");
    }

    @RequestMapping(value = "/thiet-ke-website", method = RequestMethod.GET)
    public ModelAndView website() {
        return new ModelAndView("redirect:/thiet-ke-website-44");
    }

    @RequestMapping(value = "/ho-tro-do-an", method = RequestMethod.GET)
    public ModelAndView support() {
        return new ModelAndView("redirect:/ho-tro-do-an-java-javascript-48");
    }

    @RequestMapping(value = "/soft", method = RequestMethod.GET)
    public ModelAndView soft() {
        return new ModelAndView("redirect:/huong-dan-cai-dat-phan-mem-4");
    }

    @RequestMapping(value = "/tao-project-spring-boot", method = RequestMethod.GET)
    public ModelAndView createSpringBootProject() {
        return new ModelAndView("redirect:/huong-dan-tao-project-spring-boot-co-ban-10");
    }

    @RequestMapping(value = "/tao-project-spring-boot-01", method = RequestMethod.GET)
    public ModelAndView createSpringBootProject01() {
        return new ModelAndView("redirect:/huong-dan-tao-project-spring-boot-co-ban-10#tao-project-spring-boot-01");
    }

    @RequestMapping(value = "/tao-project-spring-boot-02", method = RequestMethod.GET)
    public ModelAndView createSpringBootProject02() {
        return new ModelAndView("redirect:/huong-dan-tao-project-spring-boot-co-ban-10#tao-project-spring-boot-02");
    }
    @RequestMapping(value = "/tao-project-spring-boot-03", method = RequestMethod.GET)
    public ModelAndView createSpringBootProject03() {
        return new ModelAndView("redirect:/huong-dan-tao-project-spring-boot-co-ban-10#tao-project-spring-boot-03");
    }
    @RequestMapping(value = "/tao-project-spring-boot-04", method = RequestMethod.GET)
    public ModelAndView createSpringBootProject04() {
        return new ModelAndView("redirect:/huong-dan-tao-project-spring-boot-co-ban-10#tao-project-spring-boot-04");
    }

    @RequestMapping(value = "/tao-project-spring-boot-05", method = RequestMethod.GET)
    public ModelAndView createSpringBootProject05() {
        return new ModelAndView("redirect:/huong-dan-tao-project-spring-boot-co-ban-10#tao-project-spring-boot-05");
    }

    @RequestMapping(value = "/tao-project-spring-boot-06", method = RequestMethod.GET)
    public ModelAndView createSpringBootProject06() {
        return new ModelAndView("redirect:/huong-dan-tao-project-spring-boot-co-ban-10#tao-project-spring-boot-06");
    }

    @RequestMapping(value = "/tao-project-spring-boot-07", method = RequestMethod.GET)
    public ModelAndView createSpringBootProject07() {
        return new ModelAndView("redirect:/huong-dan-tao-project-spring-boot-co-ban-10#tao-project-spring-boot-07");
    }

    @RequestMapping(value = {"/support","q-a","sharing","/dich-vu/support"}, method = RequestMethod.GET)
    public ModelAndView supportQuestionSharing() {
        return new ModelAndView("redirect:/trang-chu");
    }

    @RequestMapping(value = {"/zalo"}, method = RequestMethod.GET)
    public ModelAndView zaloGroup() {
        return new ModelAndView("redirect:/nhom-zalo-thong-bao-180");
    }
}
