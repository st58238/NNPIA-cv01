package cz.upce.fei.janacek.main.controller

import cz.upce.fei.janacek.main.model.Complex
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Controller slouží jako komponenta MVC modelu, stejně jako RestController.
 * Rozdíl je v tom, že RestController automaticky, na pozadí, přidává dodatečnou anotaci ResponseBody
 *  a zároveň automaticky převádí response na JSON/XML.
 */
@RestController
//@RequestMapping("/api/v1")
class HelloController {

    @GetMapping("")
    fun helloWorld(): String {
        return "Hello world from Spring Boot application."
    }

    @GetMapping("path")
    fun returnString(@RequestParam path: String): String {
        return "Got: $path"
    }

    @GetMapping("query")
    fun returnQuery(@RequestParam query: String): String {
        return "Query: $query"
    }

    @GetMapping("complex")
    fun returnResponseObject(): Complex {
        return Complex((Math.random() * 100).toInt(), (Math.random() * 100).toInt())
    }

    /**
     * V Javě bych využil buďto třídní anotaci @Data, nebo bych k atributům přidal anotace @Getter a @Setter,
     *  případně ještě @ToString a @EqualsAndHashCode.
     */

}