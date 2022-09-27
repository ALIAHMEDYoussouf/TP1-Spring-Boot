package com.pwa22.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MesControlleurs {

    List<Personne> lesGens = new ArrayList<>();

    public MesControlleurs() {
        lesGens.add(new Personne("Toto", "Truc", 50, "Saint Etienne"));
        lesGens.add(new Personne("Toto", "Machin", 20, "Lyon"));
    }

    @GetMapping("/gens/{identifiant}")
    public String detailsDuGens(Model model, @PathVariable long identifiant) {
        // var p = lesGens.stream().filter(unGens -> unGens.id ==
        // identifiant).findFirst().get();
        Personne p = null;
        for (Personne unGens : lesGens) {
            if (unGens.id == identifiant) {
                p = unGens;
            }
        }
        model.addAttribute("p", p);
        return "details";
    }

    @GetMapping("/gens/{identifiant}/rm")
    public String suppr(@PathVariable long identifiant) {
        lesGens.removeIf(bidule -> bidule.id == identifiant);
        return "redirect:/";
    }

    @PostMapping("/gens/new")
    public String ajout(Personne p) {
        lesGens.add(p);
        return "redirect:/";
    }

    @PostMapping("/gens/newALT")
    public String ajout(@RequestParam String nom, @RequestParam String prenom, @RequestParam int age,
            @RequestParam String Adresse) {
        lesGens.add(new Personne(nom, prenom, age, Adresse));
        return "redirect:/";
    }

    // @RequestMapping(value="/", method = RequestMethod.GET)
    @GetMapping("/")
    // @ResponseBody
    public String laPageDAcceuil(Model model) {
        model.addAttribute("qui", "Prof");
        model.addAttribute("titre", "Accueil");
        model.addAttribute("gens", lesGens);
        return "maison";
    }
}
