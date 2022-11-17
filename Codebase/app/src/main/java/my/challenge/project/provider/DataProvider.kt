package my.challenge.project.provider

import android.content.Context
import my.challenge.project.api.Api
import my.challenge.project.api.Post
import my.challenge.project.api.User
import my.challenge.project.common.ObtainCallback
import my.challenge.project.common.ObtainParametrizedWithCallback

object DataProvider : ObtainParametrizedWithCallback<Data, Context> {

    val userData = Data()

    override fun obtain(param: Context, callback: ObtainCallback<Data>) {

        val api = Api()

        val postsCallback = object : ObtainCallback<List<Post>> {

            override fun onCompleted(data: List<Post>) {

                data.forEach { post ->

                    var posts = userData.posts[post.userId]
                    if (posts == null) {

                        posts = mutableListOf()
                        userData.posts[post.userId] = posts
                    }
                    posts.add(post)
                }

                callback.onCompleted(userData)
            }

            override fun onFailure(error: Throwable) = callback.onFailure(error)
        }

        fun getPosts() {

            api.getPosts(param, postsCallback)
        }

        val usersCallback = object : ObtainCallback<List<User>> {

            override fun onCompleted(data: List<User>) {

                userData.users.clear()
                userData.users.addAll(data)
                getPosts()
            }

            override fun onFailure(error: Throwable) = callback.onFailure(error)
        }

        api.getUsers(param, usersCallback)
    }
}