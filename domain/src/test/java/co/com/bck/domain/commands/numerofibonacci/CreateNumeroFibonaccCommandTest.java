package co.com.bck.domain.commands.numerofibonacci;

import co.com.bck.commons.exceptions.DomainException;
import co.com.bck.domain.commands.AbstractCommandProcessTest;
import co.com.bck.domain.dto.numerofibonacci.NumeroFibonacciDto;
import co.com.bck.domain.services.numerofibonacci.INumeroFibonacciService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static co.com.bck.domain.constants.DomainErrors.ERROR_CONTEXTO_VACIO;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class CreateNumeroFibonaccCommandTest extends AbstractCommandProcessTest<NumeroFibonacciDto, NumeroFibonacciDto, CreateNumeroFibonaccCommand> {
    private final EasyRandom generator = new EasyRandom();

    private final NumeroFibonacciDto context = generator.nextObject(NumeroFibonacciDto.class);

    @Mock
    private INumeroFibonacciService numeroFibonacciService;

    @Override
    protected CreateNumeroFibonaccCommand createCommand() {
        return new CreateNumeroFibonaccCommand(numeroFibonacciService);
    }

    @Override
    protected NumeroFibonacciDto createValidContext() {
        return this.context;
    }

    @Override
    protected NumeroFibonacciDto createInvalidContext() {
        return null;
    }

    @Override
    protected void assertValidResult(NumeroFibonacciDto result) {
        assertEquals(this.context, result);
    }

    @Override
    protected void setMethod() {
        when(this.command.getNumeroFibonacciService().save(this.context)).thenReturn(this.context);
    }
    @Test
    @Override
    public void testPreProcess() throws DomainException {
        // Case 1: Successful pre-processing
        command.setContext(this.context);
        assertDoesNotThrow(() -> command.preProcess());
        assertTrue(command.isValid());

        // Case 2: Null context
        command.setContext(null);
        DomainException exception = assertThrows(DomainException.class, () -> command.preProcess());
        assertEquals(ERROR_CONTEXTO_VACIO, exception.getMessage());

    }
    @Test
    @Override
    public void testPostProcess() throws DomainException {
        assertDoesNotThrow(() -> command.postProcess());
    }
}
