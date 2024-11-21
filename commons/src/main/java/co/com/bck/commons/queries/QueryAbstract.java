package co.com.bck.commons.queries;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public abstract class QueryAbstract<C, R> {

    /**
     * Executes the query process by calling preProcess, process, and postProcess methods in order.
     *
     * @param context The context object containing necessary information for the query execution.
     * @return The result of the query after processing and post-processing.
     */
    public final R execute(C context) {
        preProcess(context);
        R result = process(context);
        return postProcess(context, result);
    }

    /**
     * Performs any necessary pre-processing steps before the main query execution.
     *
     * @param context The context object containing necessary information for pre-processing.
     */
    public abstract void preProcess(C context);

    /**
     * Executes the main query process.
     *
     * @param context The context object containing necessary information for the query execution.
     * @return The result of the query process.
     */
    public abstract R process(C context);

    /**
     * Performs any necessary post-processing steps after the main query execution.
     * By default, this method returns the result without modification.
     *
     * @param context The context object containing necessary information for post-processing.
     * @param result The result obtained from the main query process.
     * @return The post-processed result, which by default is the same as the input result.
     */
    public R postProcess(C context, R result) {
        // Default implementation that simply returns the result without modification
        return result;
    }
}