package com.minor.mvvm_clean_architecture.domain.common

abstract class Mapper<Input, Output> {
    abstract fun map(input: Input): Output

    fun mapList(inputs: List<Input>?): List<Output> {
        val outputs = mutableListOf<Output>()
        inputs?.forEach { input: Input ->
            outputs.add(map(input))
        }
        return outputs
    }
}