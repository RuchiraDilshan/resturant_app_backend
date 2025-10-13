package com.example.resturantapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resturantapp.dto.ApiResponseDTO;
import com.example.resturantapp.models.Admin;
import com.example.resturantapp.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class PublicController {
    private final AdminService adminService;

    @GetMapping("/contact")
    public ResponseEntity<ApiResponseDTO<Map<String, String>>> getContact() {
        Admin admin = adminService.getPublicContact();
        Map<String, String> contact = new HashMap<>();
        contact.put("address", admin.getAddress() != null ? admin.getAddress() : "");
        contact.put("workinghours", admin.getWorkinghours() != null ? admin.getWorkinghours() : "");
        contact.put("phone", admin.getAdminphonenumber() != null ? admin.getAdminphonenumber() : "");
        contact.put("email", admin.getEmail() != null ? admin.getEmail() : "");
        return ResponseEntity.ok(ApiResponseDTO.success(contact, "Contact retrieved successfully"));
    }
}
