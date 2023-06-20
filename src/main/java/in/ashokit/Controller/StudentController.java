package in.ashokit.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.Service.StudentService;
import in.ashokit.binding.Student;

@Controller
public class StudentController {
	
	@Autowired
	  private StudentService service;
	
	
	@GetMapping("/")                      
	public  String loadIndexPage (Model model) {
		init(model);
		return "Index";
	}
	private void init(Model model) {
		model.addAttribute("Student",  new Student());
		model.addAttribute("courses",service.getcourse());
		model.addAttribute("prefTimings",service.gettimings());
	}
		@PostMapping("/save")                      
		public  String handlesubmitbtn (Student s, Model model) {
			
			boolean issaved=service.savestudent(s);
			if(issaved) {
							
			model.addAttribute("msg", "Data saved..");
			
			init(model);
			return "Index";
	}
			return null;

			
		}
		
		
}