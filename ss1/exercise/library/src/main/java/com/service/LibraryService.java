package com.service;

import com.repository.LibraryRepository;

import java.util.Map;

public class LibraryService {
    private LibraryRepository libraryRepository = new LibraryRepository();

    public Map<String, String> getAllVocabulary() {
        return libraryRepository.getAllVocabulary();
    }

    public String translate(String word) {
        Map<String, String> map = libraryRepository.getAllVocabulary();
        for (String word1 : map.keySet()) {
            if (word.equals(word1)) {
                return map.get(word1);
            }
        }
        return "Không tìm thấy";
    }
}
