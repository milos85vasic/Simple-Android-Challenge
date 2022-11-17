package my.challenge.project.provider

import my.challenge.project.api.Post
import my.challenge.project.api.User

data class Data(

    val users: MutableList<User> = mutableListOf(),
    val posts: MutableMap<Long, MutableList<Post>> = mutableMapOf()
)