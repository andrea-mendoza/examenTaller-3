package com.ucbcba.demo.Controllers;


import com.ucbcba.demo.Entities.Comment;
import com.ucbcba.demo.services.CommentService;
import com.ucbcba.demo.services.RestaurantService;
import com.ucbcba.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CommentController {
    private CommentService commentService;
    private UserService userService;
    private RestaurantService restaurantService;

    @Autowired
    public void setRestaurantService(RestaurantService restaurantService){ this.restaurantService = restaurantService; }

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    String save(Comment comment) {
        Integer resId = comment.getRestaurant().getId();
        Integer userId = comment.getUser().getId();
        userService.getUser(userId).setCantComentarios(userService.getUser(userId).getCantComentarios()+1);
        restaurantService.getRestaurant(resId).setCantComentarios(restaurantService.getRestaurant(resId).getCantComentarios()+1);
        commentService.saveComment(comment);
        return "redirect:/showRestaurant/" + comment.getRestaurant().getId();
    }
    @RequestMapping("/commentlike/{id}")
    String like(@PathVariable Integer id) {
        Comment comment = commentService.getComment(id);
        comment.setLikes(comment.getLikes() + 1);
        commentService.saveComment(comment);
        return "redirect:/showRestaurant/" + comment.getRestaurant().getId();
    }

    @RequestMapping("/commentdislike/{id}")
    String disLike(@PathVariable Integer id) {
        Comment comment = commentService.getComment(id);
        if(comment.getLikes() != 0){
            comment.setLikes(comment.getLikes() -1);
            commentService.saveComment(comment);
        }
        return "redirect:/showRestaurant/" + comment.getRestaurant().getId();
    }
}