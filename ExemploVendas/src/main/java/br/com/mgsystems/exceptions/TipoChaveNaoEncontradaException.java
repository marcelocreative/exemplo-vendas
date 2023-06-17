package br.com.mgsystems.exceptions;

/**
 * @author rodrigo.pires
 */
public class TipoChaveNaoEncontradaException extends Exception {

    private static final long serialVersionUID = 6030130647006037701L;

	public TipoChaveNaoEncontradaException(String msg) {
        this(msg, null);
    }

    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
