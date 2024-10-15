package com.example.plugins

import com.example.models.Todo

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import java.util.concurrent.atomic.AtomicInteger



val todos = mutableListOf<Todo>()
val idCounter = AtomicInteger(0)

fun Application.configureRouting() {
    routing {
        route("/todos") {
            get {
                call.respond(todos)
            }

            post {
                val newTodo = call.receive<Todo>().copy(id = idCounter.incrementAndGet())
                todos.add(newTodo)
                call.respond(newTodo)
            }

            put("/{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                val updatedTodo = call.receive<Todo>()
                val index = todos.indexOfFirst { it.id == id }

                if (index != -1) {
                    todos[index] = updatedTodo
                    call.respond(updatedTodo)
                } else {
                    call.respondText("Todo not found", status = io.ktor.http.HttpStatusCode.NotFound)
                }
            }

            delete("/{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                val removed = todos.removeIf { it.id == id }

                if (removed) {
                    call.respondText("Todo deleted", status = io.ktor.http.HttpStatusCode.OK)
                } else {
                    call.respondText("Todo not found", status = io.ktor.http.HttpStatusCode.NotFound)
                }
            }
        }
    }
}
