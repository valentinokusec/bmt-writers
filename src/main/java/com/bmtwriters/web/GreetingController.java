package com.bmtwriters.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bmtwriters.domains.Activity;
import com.bmtwriters.domains.Book;
import com.bmtwriters.domains.Chapters;
import com.bmtwriters.domains.Page;
import com.bmtwriters.domains.User;
import com.bmtwriters.services.ActivityService;
import com.bmtwriters.services.BookService;
import com.bmtwriters.services.CategoryService;
import com.bmtwriters.services.ChaptersService;
import com.bmtwriters.services.UserService;


@Controller
public class GreetingController {

	@Autowired
	UserService userservice;
	
	@Autowired
	ActivityService activityservice;
	
	@Autowired
	CategoryService categoryservice;
	
	@Autowired
	BookService bookeservice;
	
	@Autowired
	ChaptersService chapterservice;

	private Model addAttribute;
	
    @RequestMapping("/index")
    public String greeting( Model model) {
        model.addAttribute("User", new User());

        return "greeting";
    }
    @RequestMapping("/main")
    public String Main(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String ff = auth.getName(); //get logged in username
        List<Activity> activity_list=activityservice.list();
        model.addAttribute("category",categoryservice.list());
        model.addAttribute("category_size",categoryservice.list().size());
        model.addAttribute("size",activity_list.size());
        return "main";
    }
    @RequestMapping("/newbook")
    public String getNewBook(Model model) {
    	
      
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String ff = auth.getName(); //get logged in username
        User user = userservice.findByUserName(ff);
        model.addAttribute("user", user);
        model.addAttribute("Book", new Book());
        model.addAttribute("category",categoryservice.list());
        model.addAttribute("category_size",categoryservice.list().size());
        return "newbook";
    }
    @PostMapping("/newbook")
    public String getNewBook(Model model,Book Book) {
    	
      
    	Book.setCreated(new Timestamp(System.currentTimeMillis()));
    	Book.setUpdated(new Timestamp(System.currentTimeMillis()));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String ff = auth.getName(); //get logged in username
        User user = userservice.findByUserName(ff);
        bookeservice.save(Book);
        List<Book> bookList=user.getBook();
        bookList.add(Book);
        userservice.create(user);
        model.addAttribute("user", user);
        model.addAttribute("Book", Book);
        model.addAttribute("category",categoryservice.list());
        model.addAttribute("category_size",categoryservice.list().size());
        return "redirect:book/"+Book.getId();
    }
    @RequestMapping("/newchapter")
    public String getNewChapter(Model model) {
    	
      
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String ff = auth.getName(); //get logged in username
        User user = userservice.findByUserName(ff);
        model.addAttribute("user", user);
        model.addAttribute("Book", new Book());
        model.addAttribute("category",categoryservice.list());
        model.addAttribute("category_size",categoryservice.list().size());
        return "newbook";
    }
    @PostMapping("/newchapter")
    public String getNewChapter(Model model,@RequestParam("name") String name,@RequestParam("id") int id) {
    	
      
    	Chapters ch = new Chapters();
    	ch.setName(name);
    	chapterservice.save(ch);
    	Book book=bookeservice.findById(id);
    	ch.setBook(book);
    	List<Chapters> chList=book.getChapters();
    	chList.add(ch);
    	Page page= new Page();
    	page.setChapter(ch);
    	page.setNumber(1);
    	List<Page> pageList= new ArrayList<Page>();
    	pageList.add(page);
    	ch.setPage(pageList);
    	book.setChapters(chList);
    	book.setUpdated(new Timestamp(System.currentTimeMillis()));
    	bookeservice.save(book);
    	   model.addAttribute("Chapter", new Chapters());
           model.addAttribute("book", bookeservice.findById(id));
      
        return "redirect:book/"+ book.getId();
    }
    @RequestMapping("/app")
    public String App(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "app";
    }
    @RequestMapping("/search")
    public String Search(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "search";
    }
    @RequestMapping("/category/{category}")
    public String Category(@PathVariable(value="category") String category, Model model) {
        model.addAttribute("category",categoryservice.list());
        return "category";
    }
    @RequestMapping("/book/{id}")
    public String Book(@PathVariable(value="id") int id, Model model) {
     
        model.addAttribute("Chapter", new Chapters());
        model.addAttribute("book", bookeservice.findById(id));
        //bookeservice.findByCategory("Horror");
        return "book";
    }
    @RequestMapping("/chapter/{id}")
    public String getChapter(@PathVariable(value="id") int id, Model model) {
     
      
        model.addAttribute("chapter", chapterservice.findById(id));
        //bookeservice.findByCategory("Horror");
        return "chapter";
    }
    @RequestMapping("/details")
    public String Detail(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        //bookeservice.findByCategory("Horror");
        return "details";
    }
    @RequestMapping("/mybooks")
    public String getMyBooks(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        User user = userservice.findByUserName(name);
        model.addAttribute("user", user);
        model.addAttribute("books",   user.getBook());
      
        //bookeservice.findByCategory("Horror");
        return "mybooks";
    }
    @RequestMapping("/characters")
    public String Characters(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        //bookeservice.findByCategory("Horror");
        return "characters";
    }
    @PostMapping("/newuser")
	public String addUser(@ModelAttribute User User, Model model) {

		if (userservice.findByUserName(User.getUsername()) != null) {
			model.addAttribute("userexist", true);
			model.addAttribute("User", User);
			return "index";
		}

		userservice.create(User);
		
		return "redirect:main/" ;

	}
}
