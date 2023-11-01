package com.gitcapixaba.taskflash.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gitcapixaba.taskflash.database.TodoEntity
import com.gitcapixaba.taskflash.repositories.TodoRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {
    private val repo: TodoRepo by inject()

    private val _todos: MutableStateFlow<List<TodoEntity>> = MutableStateFlow(emptyList())
    val todos = _todos.asStateFlow()


    init {
        getTodos()
    }

    private fun getTodos() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getTodos().collect() { data ->
                _todos.update { data }
            }
        }
    }

    fun updateTodo(todo: TodoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateTodo(todo = todo)
        }
    }

    fun deleteTodo(todo: TodoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteTodo(todo = todo)
        }
    }

    fun addTodo(todo: TodoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addTodo(todo = todo)
        }
    }

}