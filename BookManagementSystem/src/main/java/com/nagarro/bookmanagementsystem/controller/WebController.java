package com.nagarro.bookmanagementsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.bookmanagement.service.LibraryService;
import com.nagarro.bookmanagement.util.JSONresolver;
import com.nagarro.bookmanagementsystem.constants.StringConstants;
import com.nagarro.bookmanagementsystem.entities.BookEntity;
import com.nagarro.bookmanagementsystem.entities.UserEntity;

@Controller
public class WebController {

	@Autowired
	LibraryService libraryService;

	RestTemplate rt = new RestTemplate();

	/*
	 * @Autowired LibrarianDaoImpl usrdao; //
	 */
	@RequestMapping("/loginpage")
	public String homeRedirector(HttpServletRequest request, HttpServletResponse response) {
		String usrtype = request.getParameter("UsrType");
		if (usrtype.equals(StringConstants.NEW_USER)) {
			return StringConstants.CREATE_USER;
		} else {
			return StringConstants.LOGIN;
		}
	}

	// ---------------------user selection page------------------------
	@RequestMapping("/newuser")
	public ModelAndView createUser(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		UserEntity user = libraryService.getLibraryUser(request.getParameter(StringConstants.USER_NAME));
		if (user != null) {
			mv.addObject("error", "User Name Allready Taken Please use a diffrent User Name");
			mv.setViewName(StringConstants.CREATE_USER);
		} else {
			user = new UserEntity();
			setUserDetails(request, user);
			libraryService.insert(user);
			mv.setViewName(StringConstants.LOGIN);
		}
		return mv;
	}

	// ----------------------------------------------------------------------------------------------------------------
	@RequestMapping("/usersession")
	public ModelAndView loginuser(ModelAndView mv, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserEntity user = libraryService.getLibraryUser(request.getParameter(StringConstants.USER_NAME));
		if (user != null) {
			if (user.getPassWord().equals(request.getParameter("passWord"))) {
				httpSessionFunc(request);
				// =-----------=----------------=-------------------=------------------------
				JSONresolver jresolver = new JSONresolver(StringConstants.GET_URL);
				jresolver.convertJSON(mv);
				mv.setViewName(StringConstants.USER_SESSION);
			} else {
				mv.addObject("error", "Incorrect Password ");
				mv.setViewName(StringConstants.LOGIN);
			}
		} else {
			mv.addObject("error", "User Name Incorrect ");
			mv.setViewName(StringConstants.LOGIN);
		}
		return mv;
	}

	private void httpSessionFunc(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("UserName", request.getParameter(StringConstants.USER_NAME));
	}

	// ----------------------logout redirector page---------------------
	@RequestMapping("/logout")
	public ModelAndView logutRedirector(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) {
		request.removeAttribute("UserName");
		mv.clear();
		mv.setViewName(StringConstants.LOGIN);
		return mv;
	}

	// --------------Cancel request page -----------------------------
	@RequestMapping("/redirectsession")
	public ModelAndView redirectToUserSessionAfterCancel(ModelAndView mv, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONresolver jresolver = new JSONresolver(StringConstants.GET_URL);
		jresolver.convertJSON(mv);
		mv.setViewName(StringConstants.USER_SESSION);
		return mv;

	}

	// ----------------------Add Book page----------------------
	@RequestMapping("/addbookinfo")
	public ModelAndView redirectToAddBookPage(ModelAndView mv, HttpServletRequest request,
			HttpServletResponse response) {
		mv.setViewName("addbookinfo");
		return mv;
	}

	// --------------------------redirect to user after add------------------
	@RequestMapping("/bookinfo")
	public ModelAndView redirectToUsersessionPageAfterAdd(ModelAndView mv, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BookEntity bookEntity = new BookEntity();
		setBookDetails(request, bookEntity);
		BookEntity bk = rt.postForObject(StringConstants.POST_URL, bookEntity, BookEntity.class);
		if (bk != null) {
			JSONresolver jresolver = new JSONresolver(StringConstants.GET_URL);
			jresolver.convertJSON(mv);
			mv.setViewName(StringConstants.USER_SESSION);
		} else {
			mv.addObject("error", "Book Code allready exist");
			mv.setViewName("addbookinfo");
		}
		return mv;
	}

	// ---------------------Update book page---------------------------
	@RequestMapping("/update")
	public ModelAndView redirectToupdateBookPage(ModelAndView mv, HttpServletRequest request,
			HttpServletResponse response) {
		mv.setViewName("updatebookinfo");
		return mv;
	}

	// ------------------redirect to user after update---------------------------
	@RequestMapping("/updatebookinfo")
	public ModelAndView redirectToUsersessionAfterUpdate(ModelAndView mv, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BookEntity bookEntity = new BookEntity();
		setBookDetails(request, bookEntity);
		rt.put(StringConstants.POST_URL+"/" + bookEntity.getBookCode(), bookEntity, BookEntity.class);
		JSONresolver jresolver = new JSONresolver(StringConstants.GET_URL);
		jresolver.convertJSON(mv);
		mv.setViewName(StringConstants.USER_SESSION);
		return mv;
	}
	//------------------redirect after delete---------------------------------
	@RequestMapping("/delete")
	public ModelAndView redirectToUsersessionAfterDelete(ModelAndView mv, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		rt.delete(StringConstants.POST_URL+"/" + request.getParameter("product_id").trim());
		JSONresolver jresolver = new JSONresolver(StringConstants.GET_URL);
		jresolver.convertJSON(mv);
		mv.setViewName(StringConstants.USER_SESSION);
		return mv;
	}
	//-------------------------------------------------------------------------
	private void setBookDetails(HttpServletRequest request, BookEntity bookEntity) {
		bookEntity.setBookCode(request.getParameter(StringConstants.BOOK_CODE));
		bookEntity.setBookName(request.getParameter("bookName"));
		bookEntity.setAuthorName(request.getParameter("authorName"));
		bookEntity.setCurrDate(request.getParameter("currDate"));
	}

	private void setUserDetails(HttpServletRequest request, UserEntity user) {
		user.setEmail(request.getParameter("emailID"));
		user.setUserName(request.getParameter(StringConstants.USER_NAME));
		user.setName(request.getParameter("name"));
		user.setPassWord(request.getParameter("passWord"));
	}

	// -----------------------------------------------------------------------//
}
