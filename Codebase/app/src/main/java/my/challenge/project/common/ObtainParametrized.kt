package my.challenge.project.common

interface ObtainParametrized<T, P> {

    fun obtain(param: P): T
}