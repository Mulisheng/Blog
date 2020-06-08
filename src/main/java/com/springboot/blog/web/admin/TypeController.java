package com.springboot.blog.web.admin;

import com.springboot.blog.po.Type;
import com.springboot.blog.service.TypeService;
import org.hibernate.dialect.MariaDB53Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping("/types")
    public String types(@PageableDefault(size = 3,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable
    , Model model)
    {
        model.addAttribute("page",typeService.listType(pageable));
        System.out.println("进入types");
        return "admin/types";
    }
    @GetMapping("/types/input")
    public String input(ModelAndView modelAndView)
    {
        System.out.println("进入types-input");
        modelAndView.setViewName("admin/types-input");
        System.out.println(modelAndView.getViewName());

        return modelAndView.getViewName();
    }


    @PostMapping("/types")
    public String post(Type type, RedirectAttributes attributes)
    {
        System.out.println("进入post");
        String name=type.getName().toString();

        System.out.println(name);

//
//        Type type1=typeService.getTypeByName(type.getName());
//        System.out.println(type1.getName());

        if (name.equals(""))
        {
            attributes.addFlashAttribute("message","请填写标签");
            return "redirect:/admin/types";
        }
        if (typeService.getTypeByName(name)!= null)
        {
            attributes.addFlashAttribute("message","标签已存在");
            return "redirect:/admin/types";
        }
        else
        {
            Type t=typeService.saveType(type);
            System.out.println(t.getName().toString());
            attributes.addFlashAttribute("message","添加成功");

        }

        return "redirect:/admin/types";
    }


    @GetMapping("/types/{id}/update")
    public String testGetEdit(@PathVariable Long id ,ModelAndView modelAndView,Type type,RedirectAttributes attributes,HttpServletResponse response)
    {

        Type t=typeService.getType(id);
        attributes.addAttribute("editId",t.getId());
        attributes.addAttribute("editName",t.getName());


      modelAndView.setViewName("admin/types-update");


        return "/admin/types-update";


    }





//    @PostMapping("/types/update")
//    public String updateTypes(Type type, RedirectAttributes attributes,HttpServletResponse response)
//    {
//        System.out.println("进入post");
//        Long id=type.getId();
//        String name=type.getName();
//        System.out.println(id);
//        System.out.println(name);


//        if (id != null)
//        {
//            if (!name.equals("") && typeService.getTypeByName(name) == null)
//            {
//
//                typeService.updateType(id,type);
//                return "redirect:/admin/types";
//
//            }else
//            {
//
//                attributes.addFlashAttribute("message","标签已存在或标签不能为空");
//                return "redirect:/admin/types";
//            }
//        }
//        if (typeService.getType(id) == null)
//        {
//            attributes.addFlashAttribute("message","标签");
//            return "redirect:/admin/types";
//        }
//        else
//        {
//            Type t=typeService.updateType(id,type);
//            System.out.println(t.getName().toString());
//            attributes.addFlashAttribute("message","修改成功");
//
//        }

//        return "redirect:/admin/types-update";
//    }



    @GetMapping("/types/{id}/delete")
    public  String delete(@PathVariable Long id,RedirectAttributes attributes)
    {
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return  "redirect:/admin/types";
    }


}
