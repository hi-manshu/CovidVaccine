package com.himanshoe.core.base

import com.himanshoe.core.util.Status
import kotlinx.coroutines.flow.Flow

/**
 * Created by Himanshu Singh on 30-04-2021.
 * hello2himanshusingh@gmail.com
 */
/** A Use Case that takes an argument and returns a result. */
interface BaseUseCase<in I, out R : Any> {
    /** Executes this use case with given input. */
    suspend operator fun invoke(input: I): Flow<Status<R>>
}