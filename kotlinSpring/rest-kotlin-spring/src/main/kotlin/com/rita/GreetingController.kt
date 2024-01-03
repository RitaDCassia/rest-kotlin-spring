package com.rita

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
// controle pra a spring rest, retorna a um objeto e a resposta vai ser salva direto na response
class GreetingController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "world") name: String?): Greeting{
        return Greeting(counter.incrementAndGet(), "ola, ${name}")
    }
}