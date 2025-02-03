package org.skypro.skyshop_2_0.model.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {
    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> handleNoSuchProductException(NoSuchProductException e) {
        return ResponseEntity.badRequest().body(new ShopError("228", "Вы пытаетесь добавить в коризну несуществующий товар!"));
    }
}
