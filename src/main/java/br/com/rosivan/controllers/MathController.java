package br.com.rosivan.controllers;

import br.com.rosivan.converters.NumberConverter;
import br.com.rosivan.exceptions.UnsupportedMathOperationException;
import br.com.rosivan.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

        private final AtomicLong counter = new AtomicLong();

        private SimpleMath math = new SimpleMath();

        @RequestMapping(
                value = "/sum/{numberOne}/{numberTwo}",
                method = RequestMethod.GET) // parametros obrigatorios
        public Double sum(
                @PathVariable(value = "numberOne") String numberOne,
                @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception {
                if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
                        throw new UnsupportedMathOperationException("Por favor insira os parametros validos");
                }
                return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        }

        @RequestMapping(
                value = "/subtraction/{numberOne}/{numberTwo}",
                method = RequestMethod.GET) // parametros obrigatorios
        public Double subtracao(
                @PathVariable(value = "numberOne") String numberOne,
                @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception {
                if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
                        throw new UnsupportedMathOperationException("Por favor insira os parametros validos");
                }
                return math.subtration(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        }
}