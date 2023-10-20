package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.dto.TemplateDTO;
import com.laptrinhjavaweb.service.IPostService;
import com.laptrinhjavaweb.service.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.laptrinhjavaweb.constant.SystemConstant.OG_TITLE_HOME;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	private IPostService postService;

	@Autowired
	private ITemplateService templateService;

	@RequestMapping(value = "/trang-chu1", method = RequestMethod.GET)
	public ModelAndView homePage2() throws Exception {
		ModelAndView mav = new ModelAndView("web/home1");
		mav.addObject(SystemConstant.HOT_POST, postService.findByHotPost(SystemConstant.HOT_POST_YES));
		mav.addObject("slides", postService.findBySlidePost("YES"));
		PostDTO postDTO = postService.findBySeoUrl(SystemConstant.HOME_PAGE);
		postDTO.setCanonicalUrl(postDTO.getSeoUrl());
		postDTO.setOgUrl(postDTO.getSeoUrl());
		TemplateDTO page =  templateService.getTemplate(SystemConstant.PAGE_NAME_LANDING);
		mav.addObject(SystemConstant.CONTENT, page.getContent());
		mav.addObject(SystemConstant.MODEL, postDTO);
		return mav;
	}
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/home");
		List<ProductDTO> productHots=  productService.getProductHot();
		List<ProductDTO> productBanners=  new ArrayList<>();
		if  (productHots != null && !productHots.isEmpty()){
			productBanners.add(productHots.get(0));
		}
		List<ProductDTO> slide = productService.getSlide();
		mav.addObject("slides", slide);
		List<ProductDTO> productHot = productService.getProductHot();
		mav.addObject("producthots", productHot);
		List<ProductDTO> bestSellingProducts = productService.getBestSellingProducts();
		mav.addObject("bestSeller", bestSellingProducts);
		ProductCategoryDTO byCode = productCategoryService.findByCode("gach-lat-nen");
		mav.addObject("leftBanner", byCode);
		mav.addObject("productBanners", productBanners);
		List<NewDTO> newToHomePage = newService.getNewToHomePage();
		mav.addObject("news", newToHomePage);
		ConfigDTO supportCenter = configService.findOneByCode("SUPPORT_CENTER");
		mav.addObject("supportCenter", supportCenter);
		SeoFriendlyUrlService seoFriendlyUrlSvc = new SeoFriendlyUrlService();
		seoFriendlyUrlSvc.init(request, OG_TITLE_HOME, "", "");
		mav.addObject(SystemConstant.MODEL_SEO_PAGE, seoFriendlyUrlSvc.GetSeoPage());
		return mav;
	}

	@RequestMapping(value = "/loginAdmin", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("web/login");
		return mav;
	}

	@RequestMapping(value = "/nganluong_97e250c25e4103dbbb7a939116fd136c.html", method = RequestMethod.GET)
	public ModelAndView verifyNganLuong() {
		ModelAndView mav = new ModelAndView("web/nganluong_97e250c25e4103dbbb7a939116fd136c");
		return mav;
	}

	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/loginAdmin?accessDenied");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
}
