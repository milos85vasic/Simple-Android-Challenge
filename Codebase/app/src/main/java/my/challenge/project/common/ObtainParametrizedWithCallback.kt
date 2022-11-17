package my.challenge.project.common

interface ObtainParametrizedWithCallback<T, P> {

    fun obtain(param: P, callback: ObtainCallback<T>)
}