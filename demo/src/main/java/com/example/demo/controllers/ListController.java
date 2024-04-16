package com.example.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.example.demo.entity.Product;
import com.example.demo.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/list")
public class ListController {

    @Autowired
    private IProductRepository pRepository;

    @GetMapping("/")
    @ResponseBody
    public Iterable<Product> getProducts() {
        return pRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<String> createProductsList(@RequestBody String url) {

        return ResponseEntity.ok("List successfully added");
    }
}
