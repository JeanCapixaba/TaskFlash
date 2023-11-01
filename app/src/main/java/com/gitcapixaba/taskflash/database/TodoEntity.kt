package com.gitcapixaba.taskflash.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Date

@Entity(tableName = "todos")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "sub_title")
    val subTitle: String,
    @ColumnInfo(name = "done")
    val done: Boolean = false,
    @ColumnInfo(name = "added")
    val added:Long = System.currentTimeMillis()
)

val TodoEntity.addDate:String get() = SimpleDateFormat("dd/MM/yyyy hh:mm").format(Date(added))
