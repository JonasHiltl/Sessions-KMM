package com.example.sessions.datasource

import com.example.sessions.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @param ResultType The type of the object stored in Cache
 * @param RequestType The type of the object returned from network request
 */
fun <ResultType, RequestType> networkBoundResource(
    query: () -> ResultType,
    fetch: suspend () -> RequestType,
    saveFetchResult: (RequestType) -> Unit,
    shouldFetch: (ResultType) -> Boolean = { true }
): Flow<DataState<ResultType>> = flow {
    val data = query()

    if (shouldFetch(data)) {
        emit(DataState.loading())

        saveFetchResult(fetch())
        DataState.data(
            data = query()
        )
    }
}