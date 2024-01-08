package com.rita.controller

import com.rita.converters.NumberControler
import com.rita.exceptions.UnsuportedMathOperationException
import com.rita.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.sqrt

@RestController
// controle pra a spring rest, retorna a um objeto e a resposta vai ser salva direto na response
class MathController {

    val counter: AtomicLong = AtomicLong()
    private val math: SimpleMath = SimpleMath()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    // @PathVariable lida com urls
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberControler.isNumeric(numberOne) || !NumberControler.isNumeric(numberTwo)) throw UnsuportedMathOperationException("Por favor informe um valor numerico")
        return math.sum(NumberControler.convertToDouble(numberOne), NumberControler.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["sub/{numberOne}/{numberTwo}"])
    fun sub(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberControler.isNumeric(numberOne) || !NumberControler.isNumeric(numberTwo)) throw UnsuportedMathOperationException("informe um valor valido")
        return math.sub(NumberControler.convertToDouble(numberOne), NumberControler.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["mult/{numberOne}/{numberTwo}"])
    fun mult(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberControler.isNumeric(numberOne) || !NumberControler.isNumeric(numberTwo)) throw UnsuportedMathOperationException("informe um valor valido")
        return math.mult(NumberControler.convertToDouble(numberOne), NumberControler.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["div/{numberOne}/{numberTwo}"])
    fun div(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberControler.isNumeric(numberOne) || !NumberControler.isNumeric(numberTwo)) throw UnsuportedMathOperationException("informe um valor valido")
        return math.div(NumberControler.convertToDouble(numberOne), NumberControler.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["media/{numberOne}/{numberTwo}"])
    fun media(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberControler.isNumeric(numberOne) || !NumberControler.isNumeric(numberTwo)) throw UnsuportedMathOperationException("informe um valor valido")
        return math.media(NumberControler.convertToDouble(numberOne), NumberControler.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["raiz/{numberOne}"])
    fun raiz(@PathVariable(value = "numberOne") numberOne: String?): Double {
        if (!NumberControler.isNumeric(numberOne)) throw UnsuportedMathOperationException("informe um valor valido")
        return math.raiz(numberOne)
    }

}