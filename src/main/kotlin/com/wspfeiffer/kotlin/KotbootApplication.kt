package com.wspfeiffer.kotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotbootApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotbootApplication::class.java, *args)
}
