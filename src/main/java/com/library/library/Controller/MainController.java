package com.library.library.Controller;
import com.library.library.model.Cart;
import com.library.library.model.Pay;
import com.library.library.model.Product;
import com.library.library.model.User;
import com.library.library.repository.Cartrepository;
import com.library.library.repository.Payrepository;
import com.library.library.repository.Productrepository;
import com.library.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Controller
public class MainController {

    @Autowired
    private Productrepository productrepository;


    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/product")
    public String product() {
        return "product";
    }
    @GetMapping("/add")
    public String add() {
        return "add";
    }
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/sign")
    public String sign(@RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("password") String password) {
        User raw = userRepository.findByEmail(email);

        if (raw == null) {

            User ob = new User(username, email, password);
            userRepository.save(ob);
            return "login";
        } else {
            return "signup";
        }

    }



    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }

    @GetMapping("/payment")
    public String payment() {
        return "payment";
    }

    @GetMapping("/paysuccess")
    public String paysuccess() {
        return "paysuccess";
    }


    String upload = "C:/Users/hp/IdeaProjects/library/src/main/resources/static";

    @PostMapping("/add")
    public String adp(@RequestParam("productname") String productname, @RequestParam("stock") Integer stock, @RequestParam("price") Integer price, @RequestParam("quantity") String quantity, @RequestParam("description") String description, @RequestParam("image") MultipartFile image) throws IOException {


        String img_name = image.getOriginalFilename();
        if (!image.isEmpty()) {
            File f = new File(upload, img_name);
            image.transferTo(f);
            Product p = new Product(productname, quantity, price, stock, description, img_name);
            productrepository.save(p);
            return "add";
        } else {
            return "error";

        }


    }

    @PostMapping("/log")
    public String log(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {

        User u = userRepository.findByEmail(email);
        if (u != null && u.getPassword().equals(password)) {

            List<Product> p = productrepository.findAll();
            model.addAttribute("product", p);
            return "product";
        } else {
            return "home";
        }
    }

    @Autowired
    private Cartrepository cartrepository;

    @GetMapping("/c")
    public String c(Model m) {
        List<Cart> d = cartrepository.findAll();
        m.addAttribute("cart", d);
        return "cart";


    }

    @PostMapping("/cart")
    public String cart(@RequestParam("pname") String pname) {
        Product p = productrepository.findByProductname(pname);
        Cart c = cartrepository.findByProduct(p);
        if (c == null) {
            Integer q = 1;
            Cart ob = new Cart(q, p);
            cartrepository.save(ob);
            return "redirect:/c";
        } else {
            c.setQuantity(c.getQuantity() + 1);
            cartrepository.save(c);
            return "redirect:/c";
        }


    }
    



    @Autowired
    private Payrepository payRepository;
    @PostMapping("/pay")
    public String pay(@RequestParam("name") String name, @RequestParam("cardnum") Integer cardnum, @RequestParam("cardexp") Integer cardexp, @RequestParam("ccv") Integer ccv) {
        Pay b = new Pay(name, cardnum, cardexp, ccv);
        payRepository.save(b);
        cartrepository.deleteAll();

        return "paysuccess";
    }
}






