package tacos.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Taco;
import tacos.data.IngredientRepository;

@Slf4j		// logger
@Controller
@RequestMapping("/design")
public class DesignTacoController {
	
	private final IngredientRepository ingredientRepo;
	
	@Autowired
	public DesignTacoController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
	
	@PostMapping
	public String processDesign(@Valid Taco design, Errors errors) {
		
		// 폼 유효성 검증
		if(errors.hasErrors()) {
			return "design";
		}
		
		// 재료 선택내역 저장 - design 폼 제출
		log.info("Processing design: " + design);
		return "redirect:/orders/current";
	}
	
	@GetMapping
	public String showDesignForm(Model model) {
		// DB로부터 타코 재료 불러오기
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepo.findAll().forEach(i -> ingredients.add(i));
		
		Type[] types = Ingredient.Type.values();
		
		for(Type type : types) {
			model.addAttribute(type.toString().toLowerCase(),
					filterByType(ingredients, type));
		}
		
		model.addAttribute("taco", new Taco());
		
		return "design";
	}
	
	// 재료 타입별로 나누기
	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients.stream()
						  .filter(x -> x.getType().equals(type))
						  .collect(Collectors.toList());
	}
}
