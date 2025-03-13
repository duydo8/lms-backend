package com.duydv.lms.controllers.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cloudinary")
public class CloudinaryController {
  private Cloudinary cloudinary;

  @PostMapping("/delete")
  public Map deleteImage(@RequestParam String publicId) {
    try {
      Map result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
      return result;
    } catch (Exception e) {
      return Map.of("error", e.getMessage());
    }
  }
}
