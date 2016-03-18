package com.basho.riak.client.api;

public class RiakException extends Exception
{
    private static final long serialVersionUID = - 3350353061246674619L;

    public RiakException()
	{
		super();
	}

	public RiakException(String message)
	{
		super(message);
	}

	public RiakException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public RiakException(Throwable cause)
	{
		super(cause);
	}

}
