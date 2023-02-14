package com.controller;


import com.service.LibraryService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

public class controller {
    private LibraryService libraryService = new LibraryService();

    @RequestMapping("/library-form")
    public String showDictionaryForm(Model model) {
        Map<String, String> map = libraryService.getAllVocabulary();
        model.addAttribute("map", map);
        return "library";
    }

    @RequestMapping("/translate")
    public String translate(Model model, String word) {
        model.addAttribute("word", word);
        model.addAttribute("meaning", libraryService.translate(word));
        return "library";
    }
}
