package my.challenge.project.common

interface ObtainCallback<T> {

    fun onCompleted(data: T)

    fun onFailure(error: Throwable)
}