package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.service.CompanyService;
import peaksoft.service.CourseService;
import peaksoft.service.InstructorService;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    private final CompanyService companyService;

    private final InstructorService instructorService;

    @Autowired
    public CourseController(CourseService courseService, CompanyService companyService,InstructorService instructorService) {
        this.courseService = courseService;
        this.companyService = companyService;
        this.instructorService = instructorService;
    }

    @GetMapping("/getCourses/{id}")
    public String getAllCourses(Model model,
                                @PathVariable Long id,
                                @ModelAttribute("inst")Instructor instructor) {
        model.addAttribute("allCourse", courseService.getAllCourse(id));
        model.addAttribute("companyId",id);
        model.addAttribute("instructors",instructorService.getAllInstructorsByCompany(id));
        return "course/courses";
    }

    @GetMapping("/{id}/addCourse")
    public String addCourse(@PathVariable Long id, Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("companyId", id);
        return "course/addCourse";
    }

    @PostMapping("/{id}/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course, @PathVariable Long id) {
        courseService.addCourse(course, id);
        return "redirect:/courses/getCourses/ " + id;
    }

    @GetMapping("/UpdateCourse/{courseId}")
    public String updateCourse(@PathVariable("courseId") long id, Model model) {
        Course course = courseService.getById(id);
        model.addAttribute("course",course);
        model.addAttribute("companyId", course.getCompany().getId());
        return "course/updateCourse";
    }

    @PostMapping("{id}/{courseId}/saveUpdateCourse")
    public String saveUpdateCourse(@PathVariable("courseId") Long courseId,
                                   @PathVariable ("id") Long id,
                                   @ModelAttribute("course") Course course) {
        courseService.updateCourse(courseId, course);
        return "redirect:/courses/getCourses/ "+id;
    }

    @RequestMapping("/{courseId}/{companyId}")
    public String deleteCourse(@PathVariable("courseId") long id,
                               @PathVariable("companyId") Long companyId) {
        courseService.deleteCourse(id);
        return "redirect:/courses/getCourses/ " + companyId;
    }

    @PostMapping("/saveAssignInstructorToCourse/{companyId}/{courseId}")
    private String saveAssign(@PathVariable("courseId")Long courseId,
                              @ModelAttribute("inst") Instructor instructor,
                              @PathVariable("companyId") Long compId) {
        instructorService.assignedInstructorToCourse(instructor.getId(),courseId);
        return "redirect:/courses/getCourses/ "+compId;
    }
}
